/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.ui.policies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionHandleEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandle;
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandle.HandleDirection;
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandleLocator;
import org.eclipse.swt.graphics.Image;

import ac.soton.multisim.ui.MultisimUIActivator;

/**
 * Draws connection handles on the free (unobstructed) side of the port.
 * 
 * @author vitaly
 *
 */
public final class PortConnectionHandleEditPolicy extends
		ConnectionHandleEditPolicy {
	/**
	 * Custom handle locator.
	 * Centers handle location relative to port figure.
	 * @author vitaly
	 *
	 */
	public final class MultisimHandleLocator extends ConnectionHandleLocator {
		public MultisimHandleLocator(IFigure reference, Point cursorPosition) {
			super(reference, cursorPosition);
		}

		@Override
		public void relocate(IFigure target) {
			super.relocate(target);
			int side = getBorderSide();
			Dimension diff = getReference().getBounds().getCenter().getDifference(target.getBounds().getCenter());
			if (side == PositionConstants.WEST || side == PositionConstants.EAST) {
				target.translate(0, diff.height);
			} else if (side == PositionConstants.SOUTH || side == PositionConstants.NORTH) {
				target.translate(diff.width,  0);
			}
		}
	}

	/**
	 * Custom image connection handle.
	 * @author vitaly
	 *
	 */
	public final class MultisimHandle extends ConnectionHandle {
		public MultisimHandle(IGraphicalEditPart ownerEditPart,
				HandleDirection relationshipDirection, String tooltip) {
			super(ownerEditPart, relationshipDirection, tooltip);
			this.setToolTip(null);
		}

		@Override
		protected Image getImage(int side) {
	        if (side == PositionConstants.WEST) {
	            return isIncoming() ? MultisimUIActivator.getImage(MultisimUIActivator.IMAGE_HANDLE_IN_WEST)
	                : MultisimUIActivator.getImage(MultisimUIActivator.IMAGE_HANDLE_OUT_WEST);
	        } else if (side == PositionConstants.EAST) {
	            return isIncoming() ? MultisimUIActivator.getImage(MultisimUIActivator.IMAGE_HANDLE_IN_EAST)
	            	: MultisimUIActivator.getImage(MultisimUIActivator.IMAGE_HANDLE_OUT_EAST);
	        } else if (side == PositionConstants.SOUTH) {
	            return isIncoming() ? MultisimUIActivator.getImage(MultisimUIActivator.IMAGE_HANDLE_IN_SOUTH)
	                : MultisimUIActivator.getImage(MultisimUIActivator.IMAGE_HANDLE_OUT_SOUTH);
	        } else {
	            return isIncoming() ? MultisimUIActivator.getImage(MultisimUIActivator.IMAGE_HANDLE_IN_NORTH)
	                : MultisimUIActivator.getImage(MultisimUIActivator.IMAGE_HANDLE_OUT_NORTH);
	        }
		}
	}

	@Override
	protected ConnectionHandleLocator getConnectionHandleLocator(
			Point referencePoint) {
		Rectangle componentBounds = ((GraphicalEditPart) getHost().getParent()).getFigure().getBounds();
		Rectangle portBounds = getHostFigure().getBounds();
		Point portCentre = portBounds.getCenter();
		
		Point position;
		if (portCentre.x < componentBounds.x)
			position = portBounds.getLeft();
		else if (portCentre.x > componentBounds.getRight().x)
			position = portBounds.getRight();
		else if (portCentre.y < componentBounds.y)
			position = portBounds.getTop();
		else if (portCentre.y > componentBounds.getBottom().y)
			position = portBounds.getBottom();
		else
			position = referencePoint;
		
		return new MultisimHandleLocator(getHostFigure(), position);
	}

	@Override
	protected List<ConnectionHandle> getHandleFigures() {
		List<ConnectionHandle> list = new ArrayList<>(2);
		
		String tooltip;
		tooltip = buildTooltip(HandleDirection.INCOMING);
		if (tooltip != null) {
			list.add(new MultisimHandle((IGraphicalEditPart) getHost(), HandleDirection.INCOMING, tooltip));
		}

		tooltip = buildTooltip(HandleDirection.OUTGOING);
		if (tooltip != null) {
			list.add(new MultisimHandle((IGraphicalEditPart) getHost(), HandleDirection.OUTGOING, tooltip));
		}

		return list;
	}
}