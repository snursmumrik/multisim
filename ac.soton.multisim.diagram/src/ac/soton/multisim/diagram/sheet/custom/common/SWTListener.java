/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.sheet.custom.common;

import java.util.EventListener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

/**
 * SWT wrapper to EventListener.
 * 
 * @author vitaly
 *
 */
public class SWTListener implements Listener {

	private EventListener eventListener;

	public SWTListener(EventListener listener) {
		eventListener = listener;
	}

	@Override
	public void handleEvent(Event event) {
		switch (event.type) {
		case SWT.Modify: {
			((ModifyListener) eventListener).modifyText(new ModifyEvent(event));
			break;
		}
		}
	}

}
