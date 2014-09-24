/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.ui.policies;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionHandleEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandleLocator;

/**
 * Draws connection handles on the freeside of the port.
 * 
 * @author vitaly
 *
 */
public final class PortConnectionHandleEditPolicy extends
		ConnectionHandleEditPolicy {
	@Override
	protected ConnectionHandleLocator getConnectionHandleLocator(
			Point referencePoint) {
		Rectangle bounds = getHostFigure().getBounds();
		Point position;
		Point portLocation = bounds.getCenter();
		Point componentLocation = ((GraphicalEditPart) getHost().getParent()).getFigure().getBounds().getCenter();
		switch (componentLocation.getPosition(portLocation)) {
		case PositionConstants.NORTH: position = bounds.getTop(); break;
		case PositionConstants.SOUTH: position = bounds.getBottom(); break;
		case PositionConstants.EAST: position = bounds.getRight(); break;
		case PositionConstants.WEST: position = bounds.getLeft(); break;
		default: position = referencePoint;
		}
		return new ConnectionHandleLocator(getHostFigure(), position);
	}
}