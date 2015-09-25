/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.master;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

import ac.soton.multisim.Component;
import ac.soton.multisim.ComponentDiagram;
import ac.soton.multisim.EventBComponent;
import ac.soton.multisim.FMUComponent;
import ac.soton.multisim.Port;
import ac.soton.multisim.exception.ModelException;
import ac.soton.multisim.exception.SimulationException;
import ac.soton.multisim.util.SimulationStatus;
import ac.soton.multisim.util.SimulationUtil;

/**
 * @author vitaly
 *
 */
public class Master {

	/**
	 * Simulate the diagram.
	 * 
	 * @param diagram
	 * @param monitor progress monitor
	 * @return
	 * @throws IOException 
	 * @throws ModelException 
	 * @throws SimulationException 
	 */
	public static IStatus simulate(final ComponentDiagram diagram, final String outputPath, IProgressMonitor monitor) {
		IStatus status = SimulationStatus.OK_STATUS;
		long simStartTime = System.currentTimeMillis();
		
		// data
		int tStart = diagram.getStartTime();
		int tStop = diagram.getStopTime();
		List<EventBComponent> eventbComps = new ArrayList<EventBComponent>();
		List<FMUComponent> fmuComps = new ArrayList<FMUComponent>();
		Map<Component, Collection<Component>> fmuIO = new HashMap<Component, Collection<Component>>();
		for (Component c : diagram.getComponents()) {
			if (c instanceof EventBComponent) {
				eventbComps.add((EventBComponent) c);
				List<Component> connected = new ArrayList<Component>();
				for (Port p : c.getInputs()) {
					Component inputComp = (Component) p.getIn().eContainer();
					if (inputComp instanceof FMUComponent)
						connected.add(inputComp);
				}
				for (Port p : c.getOutputs()) {
					for (Port p2 : p.getOut()) {
						Component outputComp = (Component) p2.eContainer();
						if (outputComp instanceof FMUComponent)
							connected.add(outputComp);
					}
				}
				fmuIO.put(c, connected);
			} else if (c instanceof FMUComponent) {
				fmuComps.add((FMUComponent) c);
			}
		}
		BufferedWriter resultWriter = null;
		
		try {
			
			// recording
			if (outputPath != null)
				resultWriter = SimulationUtil.createOutputWriter(new File(outputPath + "/results.csv"));
			
			// instantiation & initialisation
			for (Component c : diagram.getComponents()) {
				c.instantiate();
				c.initialise(tStart, tStop);
			}
			
			// initial IO
			for (Component c : eventbComps)
				c.writeOutputs();
			for (Component c : fmuComps) {
				c.readInputs();
				c.writeOutputs();
			}
			for (Component c : eventbComps)
				c.readInputs();
	
			// record header and initial values
			if (diagram.isRecordOutputs()) {
				SimulationUtil.writeColumns(diagram, resultWriter);
				SimulationUtil.writeOutput(diagram, tStart, resultWriter);
			}
				
			// first eval
			Map<Component, Integer> updateList = new HashMap<Component, Integer>(eventbComps.size() + fmuComps.size());
			for (EventBComponent c : eventbComps)
				updateList .put(c, tStart + c.getStepSize());
			for (FMUComponent c : fmuComps)
				updateList.put(c, tStart);
				
			// simulation loop
			List<EventBComponent> evalListB = new ArrayList<EventBComponent>(eventbComps.size());
			Set<Component> evalListFMU = new HashSet<Component>(fmuComps.size());
			for (int tCurrent = tStart+1; tCurrent <= tStop; ++tCurrent) {
				if (monitor.isCanceled()) {
					status = SimulationStatus.CANCEL_STATUS;
					break;
				}
				
				// update eval list
				for (EventBComponent c : eventbComps)
					if (updateList.get(c) == tCurrent) {
						evalListB.add(c);
						evalListFMU.addAll(fmuIO.get(c));
					}
				
				// evaluate
				//XXX for Event-B components tCurrent and tStep do not matter (at the moment) for doStep()
				for (EventBComponent c : evalListB) {
					c.doStep(tCurrent, 0);
					updateList.put(c, c.getStepSize());	// update the next eval record for the evaluated Event-B component
				}
				for (Component c : evalListFMU) {
					int tLast = updateList.get(c);
					c.doStep(tLast, tCurrent - tLast);
					updateList.put(c, tCurrent);	// update FMU component last eval record
				}
				
				// IO
				for (Component c : evalListB)
					c.writeOutputs();
				for (Component c : evalListFMU) {
					c.readInputs();
					c.writeOutputs();
				}
				for (Component c : evalListB)
					c.readInputs();
				
				// record if any Event-B is evaluated (possible changes occurred)
				//XXX: output may be better recorded at fixed interval irrespective of evaluation
				if (resultWriter != null && !evalListB.isEmpty())
					SimulationUtil.writeOutput(diagram, tCurrent, resultWriter);
				
				evalListB.clear();
				evalListFMU.clear();
			}
			
			for (Component c : diagram.getComponents())
				c.terminate();
		
		} catch (IOException | SimulationException | ModelException e) {
			status = SimulationStatus.createErrorStatus("Simulation terminated", e);
		}
		
		// stop recording
		if (resultWriter != null) {
			try {
				resultWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return status;//getResultStatus(status, System.currentTimeMillis() - simulationTime);
	}
}
