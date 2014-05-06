/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.rms.master;

import java.text.NumberFormat;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;

import ac.soton.rms.components.Component;
import ac.soton.rms.components.ComponentDiagram;
import ac.soton.rms.components.EventBComponent;
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
	
	// simulation states
	private static boolean finished = true;
	private static boolean paused = false;
	private static boolean cancelled = false;
	private static boolean error = true;
	
	private static String resultsMessage;
	private static long systemTime;
	
	/**
	 * 
	 */
	public static void pause() {
		paused = true;
	}
	
	/**
	 * @param diagram
	 * @param monitor
	 * @return
	 */
	public static IStatus simulate(final ComponentDiagram diagram, IProgressMonitor monitor) {
		paused = false;	// clear paused state
		IStatus status = SimStatus.OK_STATUS;
		
		if (finished) {
			// remember diagram configuration and read step size from Event-B
			startTime = diagram.getStartTime();
			stopTime = diagram.getStopTime();
			currentTime = startTime;
			components = diagram.getComponents();
			
			for (Component c : components) {
				if (c instanceof EventBComponent) {
					EventBComponent ebComponent = (EventBComponent) c;
					step = ebComponent.getStepPeriod();
					break;
				}
			}
			
			monitor.beginTask("", stopTime - startTime + components.size());
			
			// instantiate & initialise
			for (Component c : components) {
				monitor.subTask("Initialising '" + c.getName() + "'");
				if ((status = c.instantiate()) == SimStatus.OK_STATUS
						&& (status = c.initialise(currentTime, stopTime)) == SimStatus.OK_STATUS) {
					monitor.worked(1);
				} else {
					resultsMessage = "Could not initialise component '" + c.getName() + "'";
					currentTime = stopTime;	// to skip simulation loop
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

		while (currentTime < stopTime) {
			if (monitor.isCanceled()) {
				monitor.subTask("Cancelling simulation");
				status = SimStatus.CANCEL_STATUS;
				break;
			} else if (paused) {
				systemTime = System.currentTimeMillis() - systemTime;
				monitor.subTask("Paused");
				return SimStatus.PAUSE_STATUS;
			}
			
			monitor.subTask("Exchanging values");
			for (Component c : components)
				c.writeOutputs();
			for (Component c : components) {
				c.readInputs();
				
				// don't show if pausing
				if (!paused)
					monitor.subTask("Time=" + currentTime + "s: step '" + c.getName() + "'");
				
				status = c.doStep(currentTime, step);
				if (status.getSeverity() == SimStatus.WARNING) {
					paused = true;
					monitor.subTask("Pausing simulation: " + status.getMessage() + " detected.");
				} else if (status.getSeverity() == SimStatus.ERROR) {
					currentTime = stopTime;
					break;
				}
			}
			
			currentTime += step;
			monitor.worked(step);
		}

		systemTime = System.currentTimeMillis() - systemTime;
		
		for (Component c : components) {
			monitor.subTask("Terminating '" + c.getName() + "'");
			c.terminate();
		}
		
//		monitor.subTask("Results");
		compileResults(status);
		finished = true;
		return status;
			
	}


	/**
	 * @param status
	 */
	private static void compileResults(IStatus status) {
		switch (status.getSeverity()) {
		
		}
		if (status == SimStatus.OK_STATUS) {
			resultsMessage = "Completed successfully in " + ((double) systemTime / 1000.0) + " seconds";
		}
	}

	/**
	 * @return the paused
	 */
	public static boolean isPaused() {
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
