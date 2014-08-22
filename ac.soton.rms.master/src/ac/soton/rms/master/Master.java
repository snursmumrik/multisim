/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.rms.master;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

import ac.soton.rms.components.Component;
import ac.soton.rms.components.ComponentDiagram;
import ac.soton.rms.components.EventBComponent;
import ac.soton.rms.components.FMUComponent;
import ac.soton.rms.components.Port;
import ac.soton.rms.components.util.custom.SimStatus;

/**
 * @author vitaly
 *
 */
public class Master {
	// simulation data
	private static List<Component> components;
	private static int startTime;
	private static int stopTime;
	private static int currentTime;
	
	// component lists
	private static Map<EventBComponent, Integer> updateList = new HashMap<>();
	private static Set<EventBComponent> deList = new HashSet<>();
	private static Set<FMUComponent> ctList = new HashSet<>();
	private static Map<Component, Integer> lastEvalTime = new HashMap<>();
	private static Map<Port, Object> preValue = new HashMap<Port, Object>();
	
	/**
	 * Simulate the diagram.
	 * 
	 * @param diagram
	 * @param monitor progress monitor
	 * @param checkInvariants invariant check flag
	 * @param compareTrace trace comparison flag 
	 * @param recordTrace trace recording flag
	 * @return
	 */
	public static IStatus simulate(final ComponentDiagram diagram, IProgressMonitor monitor, boolean recordTrace, boolean compareTrace, boolean checkInvariants) {
		IStatus status = SimStatus.OK_STATUS;
		
		updateList.clear();
		deList.clear();
		ctList .clear();
		lastEvalTime.clear();
		preValue.clear();
		
		components = diagram.getComponents();
		startTime = diagram.getStartTime();
		stopTime = diagram.getStopTime();
		
		// instantiate & initialise
		for (Component c : components) {
			c.instantiate();
			c.initialise(startTime, stopTime);
			
			// first evaluation of DE
			if (c instanceof EventBComponent)
				updateList.put((EventBComponent) c, startTime + ((EventBComponent) c).getStepPeriod());
			else if (c instanceof FMUComponent)
				lastEvalTime.put(c, 0);		// store eval time for CT
			
			// initial IO #1
			c.writeOutputs();
			
			if (c instanceof EventBComponent)
				for (Port y : c.getOutputs())
					preValue.put(y, y.getValue());
		}
		// initial IO #2
		for (Component c : components)
			c.readInputs();

		// simulation loop
		for (currentTime = startTime; currentTime <= stopTime; ++currentTime) {
			if (monitor.isCanceled()) {
				status = SimStatus.CANCEL_STATUS;
				break;
			}
			
			for (Component c : diagram.getComponents()) {
				if (updateList.containsKey(c) && currentTime == updateList.get(c)) {
					deList.add((EventBComponent) c);
					updateList.put((EventBComponent) c, currentTime + ((EventBComponent) c).getStepPeriod());
				}
			}
			
			// skip CT steps if no DE
			if (deList.isEmpty())
				continue;
			
			// DE step
			for (EventBComponent c : deList) {
				c.doStep(currentTime, c.getStepPeriod());
				c.writeOutputs();
				// evaluate any input CT
				for (Port u : c.getInputs()) {
					if (u.getIn() != null && u.getIn().eContainer() instanceof FMUComponent) {
						ctList.add((FMUComponent) u.getIn().eContainer());
					}
				}
				// evaluate any output CT if DE output has changed
				for (Port y : c.getOutputs()) {
					if (y.getValue() != preValue.get(y)) {
						preValue.put(y, y.getValue());
						for (Port u : y.getOut()) {
							if (u.eContainer() instanceof FMUComponent)
								ctList.add((FMUComponent) u.eContainer());
						}
					}
				}
			}
			
			// CT step
			for (FMUComponent c : ctList) {
				int tEval = lastEvalTime .get(c);
				c.doStep(tEval, currentTime - tEval);
				c.writeOutputs();
				lastEvalTime.put(c, currentTime);
			}
			
			// IO
			for (Component c : deList)
				c.readInputs();
			for (Component c : ctList)
				c.readInputs();
			
			deList.clear();
			ctList.clear();
		}
		
		// termination
		for (Component c : components) {
			c.terminate();
		}
		
		return status;
	}

	public static void pause() {
		// TODO Auto-generated method stub
		
	}
}
