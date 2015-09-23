package ac.soton.multisim.master;
/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */


import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import ac.soton.multisim.Component;
import ac.soton.multisim.ComponentDiagram;
import ac.soton.multisim.exception.ModelException;
import ac.soton.multisim.exception.SimulationException;
import ac.soton.multisim.util.SimulationStatus;
import ac.soton.multisim.util.SimulationUtil;

/**
 * Master algorithm for FMU-EventB co-simulation.
 * 
 * @author vitaly
 *
 */
public class TwoListMaster {

	@SuppressWarnings("unused")
	private static final String PLUGIN_ID = "ac.soton.multisim.components.master";

	// parameters
	private static ComponentDiagram diagram;
	private static int tCurrent;
	private static int tStart;
	private static int tStop;
	private static int step;
	
	// two-list
	private static Map<Component, Integer> updateList = new HashMap<Component, Integer>();
	private static List<Component> evaluationList = new ArrayList<Component>();
	
	private static BufferedWriter resultWriter;

	/**
	 * Simulate a diagram.
	 * @param cd
	 * @param monitor
	 * @param outputFile
	 * @return
	 */
	public static IStatus simulate(ComponentDiagram cd, IProgressMonitor monitor, File outputFile) {
		diagram = cd;
		tStart = diagram.getStartTime();
		tStop = diagram.getStopTime();
//		step = diagram.getStepSize();
		updateList.clear();
		evaluationList.clear();
		int cStep;
		IStatus status = Status.OK_STATUS;
		long simulationTime = System.currentTimeMillis();
		
		try {
			// create output file
			if (diagram.isRecordOutputs()) {
				if (outputFile == null)
					outputFile = new File(System.getProperty("user.home")+"/results.csv");
				resultWriter = SimulationUtil.createOutputWriter(outputFile);
			}

			// instantiate components
			for (Component c : diagram.getComponents())
				c.instantiate();
			
			// initialisation step
			for (Component c : diagram.getComponents()) {
				c.initialise(tStart, tStop);
				// time-zero initialisation
				updateList.put(c, tStart);
			}
			
			// header output
			if (diagram.isRecordOutputs())
				SimulationUtil.writeColumns(diagram, resultWriter);
	
			// simulation loop
			for (tCurrent = tStart; tCurrent <= tStop; ++tCurrent) {
				if (monitor.isCanceled()) {
					status = Status.CANCEL_STATUS;
					break;
				}
				
				// read update list for evaluation-ready components
				for (Component c : diagram.getComponents()) {
					if (tCurrent == updateList.get(c))
						evaluationList.add(c);
				}
				
				if (evaluationList.isEmpty())
					continue;
				
				// only simulate components in evaluation list
				// read port values
				for (Component c : evaluationList)
					c.writeOutputs();
				
				// write port values
				for (Component c : evaluationList)
					c.readInputs();
				
				// do step & update the update list
				for (Component c : evaluationList) {
					cStep = 1;//c.getStepPeriod() == 0 ? step : c.getStepPeriod();
					if (tCurrent + cStep <= tStop) {
						c.doStep(tCurrent, cStep);
						updateList.put(c, updateList.get(c) + cStep);
					}
				}
				
				// clear evaluation list
				evaluationList.clear();
				
				// write file output
				if (diagram.isRecordOutputs())
					SimulationUtil.writeOutput(diagram, tCurrent, resultWriter);
			}
		} catch (SimulationException | ModelException | IOException e) {
			status = SimulationStatus.createErrorStatus("Terminated due to an exception:\n" + e.getMessage(), e);
		}

		// termination step
		for (Component c : diagram.getComponents())
			c.terminate();
		
		// close file
		if (resultWriter != null) {
			try {
				resultWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (status.getSeverity() == Status.OK)
			status = SimulationStatus.createOKStatus("Finished in " + (System.currentTimeMillis() - simulationTime) + "ms"
					+ (diagram.isRecordOutputs() ? "\nOutput saved to '"+outputFile.getAbsolutePath().toString()+"'\n" : "")
					+ diagram.createStatusReport());
		
		return status;
	}

}
