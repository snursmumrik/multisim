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
		Rectangle componentBounds = ((GraphicalEditPart) getHost().getParent()).getFigure().getBounds();
		Rectangle portBounds = getHostFigure().getBounds();
		Point portCentre = portBounds.getCenter();
		
		Point position;
		switch (componentBounds.getCenter().getPosition(portCentre)) {
		case PositionConstants.NORTH: position = portBounds.getTop(); break;
		case PositionConstants.SOUTH: position = portBounds.getBottom(); break;
		case PositionConstants.EAST: position = portBounds.getRight(); break;
		case PositionConstants.WEST: position = portBounds.getLeft(); break;
		default: position = referencePoint;
		}
		
//		if (componentBounds.getLeft().getPosition(portCentre) == PositionConstants.WEST)
//			position = portBounds.getLeft();
//		else if (componentBounds.getRight().getPosition(portCentre) == PositionConstants.EAST)
//			position = portBounds.getRight();
//		else if (componentBounds.getTop().getPosition(portCentre) == PositionConstants.NORTH)
//			position = portBounds.getTop();
//		else if (componentBounds.getBottom().getPosition(portCentre) == PositionConstants.SOUTH)
//			position = portBounds.getBottom();
//		else
//			position = referencePoint;
		return new ConnectionHandleLocator(getHostFigure(), position);
	}
}