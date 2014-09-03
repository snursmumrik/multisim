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
import org.eclipse.core.runtime.Status;

import ac.soton.multisim.components.Component;
import ac.soton.multisim.components.ComponentDiagram;
import ac.soton.multisim.components.EventBComponent;
import ac.soton.multisim.components.FMUComponent;
import ac.soton.multisim.components.Port;
import ac.soton.multisim.components.util.custom.SimStatus;

/**
 * @author vitaly
 *
 */
public class Master {
	/**
	 * Parameters
	 */
	public static final String PARAM_RECORD_TRACE = "ac.soton.rms.ui.parameters.recordTrace";
	public static final String PARAM_COMPARE_TRACE = "ac.soton.rms.ui.parameters.compareTrace";
	public static final String PARAM_CHECK_INVARIANTS = "ac.soton.rms.ui.parameters.checkInvariants";
	
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
	private static Map<Port, Object> preValue = new HashMap<>();
	
	/**
	 * Simulate the diagram.
	 * 
	 * @param diagram
	 * @param monitor progress monitor
	 * @param params simulation parameters
	 * @return
	 */
	public static IStatus simulate(final ComponentDiagram diagram, IProgressMonitor monitor, Map<String, String> params) {
		IStatus status = SimStatus.OK_STATUS;
		long simulationTime = System.currentTimeMillis();
		
		updateList.clear();
		deList.clear();
		ctList .clear();
		lastEvalTime.clear();
		preValue.clear();
		
		components = diagram.getComponents();
		startTime = diagram.getStartTime();
		stopTime = diagram.getStopTime();
		
		status = initialise(monitor);

		if (status == SimStatus.OK_STATUS)
			status = doSteps(monitor);
		
		terminate();
		
		return getResultStatus(status, System.currentTimeMillis() - simulationTime);
	}

	/**
	 * Creates final result status.
	 * 
	 * @param status original status
	 * @param time elapsed time
	 * @return
	 */
	private static IStatus getResultStatus(IStatus status, long time) {
		switch (status.getSeverity()) {
		case Status.OK:
			status = new SimStatus(Status.OK, SimStatus.ID, "Simulation finished in " + time/1000 + "s"); break;
		case Status.ERROR:
			status = new SimStatus(Status.ERROR, SimStatus.ID, "Simulation terminated after " + time/1000 + "s" + "\nError: " + status.getMessage()); break;
		case Status.CANCEL:
			status = new SimStatus(Status.CANCEL, SimStatus.ID, "Simulation cancelled"); break;
		}
		
		return status;
	}

	/**
	 * Instantiate and initialise components.
	 * 
	 * @param monitor
	 * @return
	 */
	private static IStatus initialise(IProgressMonitor monitor) {
		IStatus status = SimStatus.OK_STATUS;
		
		for (Component c : components) {
			monitor.subTask("Initialising component '" + c.getName() + "'");
			if ((status = c.instantiate()) != SimStatus.OK_STATUS 
					|| (status = c.initialise(startTime, stopTime)) != SimStatus.OK_STATUS) {
				return status;
			}
			
			// first evaluation of DE
			if (c instanceof EventBComponent)
				updateList.put((EventBComponent) c, startTime + ((EventBComponent) c).getStepPeriod());
			else if (c instanceof FMUComponent)
				lastEvalTime.put(c, 0);		// store eval time for CT
			
			// initial IO #1
			if ((status = c.writeOutputs()) != SimStatus.OK_STATUS)
				return status;
			
			if (c instanceof EventBComponent)
				for (Port y : c.getOutputs())
					preValue.put(y, y.getValue());
			
		}
		// initial IO #2
		for (Component c : components)
			if ((status = c.readInputs()) != SimStatus.OK_STATUS)
				return status;
		
		return status;
	}

	/**
	 * Perform simulation steps.
	 * 
	 * @param monitor
	 * @return
	 */
	private static IStatus doSteps(IProgressMonitor monitor) {
		monitor.beginTask("Simulation", stopTime - startTime);
		int lastMonitorTick = startTime;
		IStatus status = SimStatus.OK_STATUS;

		for (currentTime = startTime; currentTime <= stopTime; ++currentTime) {
			if (monitor.isCanceled()) {
				status = SimStatus.CANCEL_STATUS;
				break;
			}
			
			for (Component c : components) {
				if (updateList.containsKey(c) && currentTime == updateList.get(c)) {
					deList.add((EventBComponent) c);
					updateList.put((EventBComponent) c, currentTime + ((EventBComponent) c).getStepPeriod());
				}
			}
			
			// skip the step if no DEs to evaluate
			if (deList.isEmpty()) {
				continue;
			}
			
			// DE step
			for (EventBComponent c : deList) {
				monitor.subTask("Time=" + currentTime + "ms: step '" + c.getName() + "'");
				if ((status = c.doStep(currentTime, c.getStepPeriod())) != SimStatus.OK_STATUS
						|| (status = c.writeOutputs()) != SimStatus.OK_STATUS)
					return status;
				
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
				monitor.subTask("Time=" + currentTime + "ms: step '" + c.getName() + "'");
				int tEval = lastEvalTime .get(c);
				if ((status = c.doStep(tEval, currentTime - tEval)) != SimStatus.OK_STATUS
						|| (status = c.writeOutputs()) != SimStatus.OK_STATUS)
					return status;
				lastEvalTime.put(c, currentTime);
			}
			
			// IO
			for (Component c : deList)
				if ((status = c.readInputs()) != SimStatus.OK_STATUS)
					return status;
			for (Component c : ctList)
				if ((status = c.readInputs()) != SimStatus.OK_STATUS)
					return status;
			
			deList.clear();
			ctList.clear();
			
			monitor.worked(currentTime-lastMonitorTick);
			lastMonitorTick = currentTime;
		}
		
		return status;
	}

	/**
	 * Terminate all components.
	 */
	private static void terminate() {
		for (Component c : components) {
			c.terminate();
		}
	}

	public static void pause() {
		// TODO Auto-generated method stub
		//NOTE: not used
	}
}
