/*
 * Copyright (c) 2015 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.edit.parts.custom;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;

import ac.soton.multisim.EventBPort;
import ac.soton.multisim.Port;
import ac.soton.multisim.VariableType;

/**
 * Custom port edit part with adjusted connection anchor and a mouse-over feedback label.
 * 
 * @author vitaly
 * @custom
 */
public abstract class AbstractPortEditPart extends AbstractBorderItemEditPart {

	// Mouse-over instant feedback label.
	Label feedbackFigure;

	public AbstractPortEditPart(View view) {
		super(view);
	}

	@Override
	public boolean canAttachNote() {
		return false;
	}

	@Override
	public void showTargetFeedback(Request request) {
		super.showTargetFeedback(request);
		if ("selection hover".equals(request.getType().toString()))
			return;
	
		// the feedback layer figures do not receive mouse e
		if (feedbackFigure == null) {
			Port port = (Port) resolveSemanticElement();
			feedbackFigure = new Label(labelName(port) + labelPrecision(port) + labelDescription(port));
			feedbackFigure.setFont(new Font(null, "Courier", 10, SWT.NORMAL));
			Rectangle bounds = feedbackFigure.getTextBounds().getCopy().expand(3, 0);
			bounds.setLocation(getFigure().getBounds().getLocation()
					.translate(20, 20));
			feedbackFigure.setBounds(bounds);
			feedbackFigure.setForegroundColor(ColorConstants.tooltipForeground);
			feedbackFigure.setBackgroundColor(ColorConstants.tooltipBackground);
			feedbackFigure.setOpaque(true);
			feedbackFigure.setBorder(new LineBorder());
	
			IFigure layer = getLayer(LayerConstants.FEEDBACK_LAYER);
			layer.add(feedbackFigure);
		}
	}

	/**
	 * Constructs port label name component.
	 * 
	 * @param port
	 * @return
	 */
	private String labelName(Port port) {
		return port.getType().getName() + " " + port.getName();
	}

	/**
	 * Constructs port label precision component.
	 * @param port
	 * @return
	 */
	private String labelPrecision(Port port) {
		if (port instanceof EventBPort && port.getType() == VariableType.REAL)
			return "\nPrecision " + ((EventBPort) port).getIntToReal();
		return "";
	}

	/**
	 * Constructs port label description component.
	 * 
	 * @param port
	 * @return
	 */
	private String labelDescription(Port port) {
		String description = port.getDescription();
		if (description != null && !description.trim().isEmpty())
			return "\n\"" + description + "\"";
		return "";
	}
	
	/* Erases mouse-over feedback.
	 */
	@Override
	public void eraseTargetFeedback(Request request) {
		super.eraseTargetFeedback(request);
		
		IFigure layer = getLayer(LayerConstants.FEEDBACK_LAYER);
		if (layer != null && feedbackFigure != null
				&& feedbackFigure.getParent() != null) {
			layer.remove(feedbackFigure);
		}
		feedbackFigure = null;
	}

	/* Defaults the anchor to the centre of the figure.
	 */
	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return getNodeFigure().getConnectionAnchor(
				NodeFigure.getDefaultAnchorID());
	}

	/* Defaults the anchor to the centre of the figure.
	 */
	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return getNodeFigure().getConnectionAnchor(
				NodeFigure.getDefaultAnchorID());
	}

}