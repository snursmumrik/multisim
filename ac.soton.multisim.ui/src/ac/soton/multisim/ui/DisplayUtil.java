/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.ui;

import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Shell;

/**
 * @author vitaly
 *
 */
public class DisplayUtil {

	/**
	 * Converts inches to current display bounds.
	 * 
	 * @param shell
	 * @param w width in inches
	 * @param h height in inches
	 * @return
	 */
	public static Rectangle inchToDisplay(Shell shell, int w, int h) {
		Rectangle mb = shell.getMonitor().getClientArea();
		Point dpi = shell.getDisplay().getDPI();
		if (Platform.OS_MACOSX.equals(Platform.getOS())) {
			dpi = new Point(110, 110); // OSX DPI is always 72; 110 is a common value for modern LCD screens
		}
		int width = dpi.x * 5;
		int height = dpi.y * 5;
		int x = mb.x + (mb.width - width) / 2;
		if (x < mb.x) {
			x = mb.x;
		}
		int y = mb.y + (mb.height - height) / 2;
		if (y < mb.y) {
			y = mb.y;
		}
		return new Rectangle(x, y, width, height);
	}

}
