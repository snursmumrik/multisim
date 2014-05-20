/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.rms.master;

import java.util.ArrayList;
import java.util.List;

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
	
	private static int startTime;
	private static int stopTime;
	private static int currentTime;
	private static int step;
	private static List<Component> components;
	private static List<Component> dependentFMUs = new ArrayList<Component>();
	
	// simulation states
	private static boolean finished = true;
	private static boolean paused = false;
	private static boolean ok = true;
	
	private static String resultsMessage;
	private static long systemTime;
	
	/**
	 * 
	 */
	synchronized public static void pause() {
		System.out.println("Paused");
		paused = true;
	}
	
	/**
	 * @param diagram
	 * @param monitor
	 * @param checkInvariants 
	 * @param compareTrace 
	 * @param recordTrace 
	 * @return
	 */
	public static IStatus simulate(final ComponentDiagram diagram, IProgressMonitor monitor, boolean recordTrace, boolean compareTrace, boolean checkInvariants) {
		paused = false;	// clear paused state
		ok = true;
		IStatus status = SimStatus.OK_STATUS;
		
		if (finished) {
			startTime = diagram.getStartTime();
			stopTime = diagram.getStopTime();
			currentTime = startTime;
			components = diagram.getComponents();
			
			// read step size from Event-B
			for (Component c : components) {
				if (c instanceof EventBComponent) {
					EventBComponent ebComponent = (EventBComponent) c;
					ebComponent.eSetDeliver(false);
					ebComponent.setRecordTrace(recordTrace);
					ebComponent.setCompareTrace(compareTrace);
					ebComponent.setCheckInvariants(checkInvariants);
					step = ebComponent.getStepPeriod();
					dependentFMUs.clear();
					setDependentFMUs(ebComponent);
					break;
				}
			}
			
			monitor.beginTask("", stopTime - startTime + components.size());
			
			// instantiate & initialise
			for (Component c : components) {
				monitor.subTask("Initialising '" + c.getLabel() + "'");
				if ((status = c.instantiate()) == SimStatus.OK_STATUS
						&& (status = c.initialise(currentTime, stopTime)) == SimStatus.OK_STATUS) {
					monitor.worked(1);
				} else {
					resultsMessage = "Could not initialise component '" + c.getLabel() + "'";
					ok = false;
					break;
				}
			}

			finished = false;	// mark as started
			systemTime = System.currentTimeMillis();
		} else {
			monitor.beginTask("", stopTime - startTime + components.size());
			monitor.worked(components.size() + currentTime - startTime);
			systemTime = System.currentTimeMillis() - systemTime;
		}

		while (currentTime < stopTime && ok) {
			if (monitor.isCanceled()) {
				monitor.subTask("Cancelling simulation");
				status = SimStatus.CANCEL_STATUS;
				break;
			} else if (isPaused()) {
				systemTime = System.currentTimeMillis() - systemTime;
				monitor.subTask("Paused");
//				status = SimStatus.PAUSE_STATUS;
				generateResultsMessage(status);
				return status;
			}
			
			monitor.subTask("Exchanging values");
			for (Component c : components) {
				if ((status = c.writeOutputs()) != SimStatus.OK_STATUS) {
					ok = false;
					break;
				}
			}
//			// zero-step for affected FMUs
//			//FIXME: only applicable for an algebraic loop and only if Event-B output has changed
//			for (Component cc : eventBFMUs) {
//				cc.readInputs();
//				cc.doStep(currentTime, 0);
//				cc.writeOutputs();
//			}
			
			for (Component c : components) {
				if ((status = c.readInputs()) != SimStatus.OK_STATUS) {
					ok = false;
					break;
				}
				
				// don't show if pausing
				if (!paused)
					monitor.subTask("Time=" + currentTime/1000f + "s: step '" + c.getLabel() + "'");
				
				status = c.doStep(currentTime, step);
				if (status.getSeverity() == SimStatus.WARNING) {
					paused = true;
					monitor.subTask("Pausing simulation: " + status.getMessage() + " detected.");
				} else if (status.getSeverity() == SimStatus.ERROR) {
					ok = false;
					break;
				}
				
				
			}
			
			
			if (ok) {
				currentTime += step;
				monitor.worked(step);
			}
		}

		systemTime = System.currentTimeMillis() - systemTime;
		
		for (Component c : components) {
			monitor.subTask("Terminating '" + c.getLabel() + "'");
			//TODO: add error handling for the terminate() method
			c.terminate();
		}
		
		generateResultsMessage(status);
		finished = true;
		return status;
			
	}

	/**
	 * Set a list of FMUs, directly dependent on component's output
	 * @param c
	 */
	private static void setDependentFMUs(Component c) {
		Component cc = null;
		for (Port po : c.getOutputs()) {
			for (Port pi : po.getOut()) {
				cc = (Component) pi.eContainer();
				if (!dependentFMUs.contains(cc) && cc instanceof FMUComponent) {
					dependentFMUs.add(cc);
					setDependentFMUs(cc);
				}
			}
		}
	}

	/**
	 * @param status
	 */
	private static void generateResultsMessage(IStatus status) {
		switch (status.getSeverity()) {
		case IStatus.OK:
			resultsMessage = "Completed successfully in " + ((double) systemTime / 1000.0) + " seconds";
			break;
		case IStatus.INFO:
		case IStatus.WARNING:
			resultsMessage = "Simulation interrupted at time=" + currentTime/1000f + "s\nReason: " + status.getMessage();
			break;
		case IStatus.ERROR:
			resultsMessage = "SImulation terminated at time=" + currentTime/1000f + "s\nError: " + status.getMessage();
		}
	}

	/**
	 * @return the paused
	 */
	synchronized public static boolean isPaused() {
		return paused;
	}

	/**
	 * @return the finished
	 */
	public static boolean isFinished() {
		return finished;
	}

	/**
	 * @return the resultsMessage
	 */
	public static String getResultsMessage() {
		return resultsMessage;
	}
	
	
}
