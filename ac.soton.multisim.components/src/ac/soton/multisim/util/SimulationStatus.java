/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.util;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

/**
 * Simulation status factory.
 * 
 * @author vitaly
 * @custom
 */
public final class SimulationStatus extends Status {
	
	public static final String ID = "ac.soton.multisim";

	/**
	 * Hidden constructors.
	 */
	private SimulationStatus(int severity, String pluginId, String message) { super(severity, pluginId, message); }
	private SimulationStatus(int severity, String pluginId, String message, Throwable exception) { super(severity, pluginId, message, exception); }
	
	/**
	 * Creates OK status.
	 * @param message
	 * @return
	 */
	public static IStatus createOKStatus(String message) {
		return new SimulationStatus(OK, ID, message);
	}
	
	/**
	 * Creates an info status.
	 * @param message
	 * @return
	 */
	public static IStatus createInfoStatus(String message) {
		return new SimulationStatus(INFO, ID, message);
	}
	
	/**
	 * Creates an error status.
	 * 
	 * @param message
	 * @param exception
	 * @return
	 */
	public static IStatus createErrorStatus(String message, Throwable exception) {
		return new SimulationStatus(ERROR, ID, message, exception);
	}
	
	public static IStatus createErrorStatus(String message) {
		return new SimulationStatus(ERROR, ID, message);
	}

}
