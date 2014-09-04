/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.util.custom;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

/**
 * @author vitaly
 *
 */
public class SimStatus extends Status {
	
	public static final String ID = "ac.soton.rms.components";
	
	public static final IStatus PAUSE_STATUS = new Status(INFO, ID, "Pause");
	public static final IStatus LOAD_ERROR = new Status(ERROR, ID, "Loading error");
	public static final IStatus TRACE_ERROR = new Status(ERROR, ID, "Trace error");
	public static final IStatus PROB_ERROR = new Status(ERROR, ID, "ProB failure");
	public static final IStatus EVENTB_TRACE_DIV = new Status(ERROR, ID, "Divergence from trace");
	public static final IStatus EVENTB_DEADLOCK = new Status(ERROR, ID, "Deadlock");
	public static final IStatus EVENTB_ERROR = new Status(ERROR, ID, "Execution error");
	public static final IStatus EVENTB_NO_READS = new Status(ERROR, ID, "No enabled ReadInput events");
	public static final IStatus EVENTB_INV_VIOLATED = new Status(ERROR, ID, "Invariant violation");

	/**
	 * @param severity
	 * @param pluginId
	 * @param message
	 */
	public SimStatus(int severity, String pluginId, String message) {
		super(severity, pluginId, message);
	}

	/**
	 * @param severity
	 * @param pluginId
	 * @param message
	 * @param exception
	 */
	public SimStatus(int severity, String pluginId, String message,
			Throwable exception) {
		super(severity, pluginId, message, exception);
	}

}
