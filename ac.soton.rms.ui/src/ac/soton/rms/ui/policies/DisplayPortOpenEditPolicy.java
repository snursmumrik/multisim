/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.rms.ui.policies;

import java.awt.Color;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Display;

import ac.soton.rms.components.DisplayPort;

/**
 * @author vitaly
 *
 */
public class DisplayPortOpenEditPolicy extends OpenEditPolicy {

	@Override
	protected Command getOpenCommand(Request request) {
		final DisplayPort port = (DisplayPort) ((GraphicalEditPart) getHost()).getNotationView().getElement();
		return new Command() {
			@Override
			public void execute() {
				ColorDialog dialog = new ColorDialog(Display.getDefault().getActiveShell());
				dialog.setText("Signal Colour");
				Color color = port.getColor();
				if (color != null)
					dialog.setRGB(new RGB(color.getRed(), color.getGreen(), color.getBlue()));
				RGB picked = dialog.open();
				if (picked != null) {
					port.eSetDeliver(false);
					port.setColor(new Color(picked.red, picked.green, picked.blue));
					port.eSetDeliver(true);
				}
			}
			
		};
	}

}
