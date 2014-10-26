/*
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;

import ac.soton.multisim.EventBPort;
import ac.soton.multisim.VariableType;
import ac.soton.multisim.diagram.edit.policies.EventBInputPortItemSemanticEditPolicy;

/**
 * @generated
 */
public class EventBInputPortEditPart extends AbstractBorderItemEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3005;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public EventBInputPortEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
				getPrimaryDragEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new EventBInputPortItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child
						.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new InputPortFigure();
	}

	/**
	 * @generated
	 */
	public InputPortFigure getPrimaryShape() {
		return (InputPortFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(10, 10);

		//FIXME: workaround for #154536
		result.getBounds().setSize(result.getPreferredSize());
		return result;
	}

	/**
	 * @generated
	 */
	public EditPolicy getPrimaryDragEditPolicy() {
		EditPolicy result = super.getPrimaryDragEditPolicy();
		if (result instanceof ResizableEditPolicy) {
			ResizableEditPolicy ep = (ResizableEditPolicy) result;
			ep.setResizeDirections(PositionConstants.NONE);
		}
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public class InputPortFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		public InputPortFigure() {
			this.setForegroundColor(ColorConstants.gray);
			this.setBackgroundColor(THIS_BACK);
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 230, 230, 230);

	/* (non-Javadoc)
	 * @custom
	 */
	@Override
	public boolean canAttachNote() {
		return false;
	}

	/**
	 * Mouse-over instant feedback label.
	 * @custom
	 */
	private Label feedbackFigure;

	/* Draws mouse-over feedback.
	 * @custom
	 */
	@Override
	public void showTargetFeedback(Request request) {
		super.showTargetFeedback(request);
		// the feedback layer figures do not receive mouse e
		if (feedbackFigure == null) {
			EventBPort port = (EventBPort) resolveSemanticElement();
			feedbackFigure = new Label("Name:  " + port.getName() +
					"\nParam: " + (port.getParameter() != null ? port.getParameter().getName() : "null") + 
					"\nType:  " + port.getType().getName() +
					(port.getType() == VariableType.REAL ? "\nPrecis: " + port.getIntToReal() : ""));
			feedbackFigure.setFont(new Font(null, "Arial", 12, SWT.NORMAL));
			Rectangle bounds = feedbackFigure.getTextBounds().getCopy().expand(3, 0);
			bounds.setLocation(getFigure().getBounds().getLocation()
					.translate(0, 20));
			feedbackFigure.setBounds(bounds);
			feedbackFigure.setForegroundColor(ColorConstants.tooltipForeground);
			feedbackFigure.setBackgroundColor(ColorConstants.tooltipBackground);
			feedbackFigure.setOpaque(true);
			feedbackFigure.setBorder(new LineBorder());

			IFigure layer = getLayer(LayerConstants.FEEDBACK_LAYER);
			layer.add(feedbackFigure);
		}
	}

	/* Erases mouse-over feedback.
	 * @custom
	 */
	@Override
	public void eraseTargetFeedback(Request request) {
		super.eraseTargetFeedback(request);
		if (request instanceof CreateConnectionRequest)
			return;
		
		IFigure layer = getLayer(LayerConstants.FEEDBACK_LAYER);
		if (layer != null && feedbackFigure != null
				&& feedbackFigure.getParent() != null) {
			layer.remove(feedbackFigure);
		}
		feedbackFigure = null;
	}

	/* Defaults the anchor to the centre of the figure.
	 * @custom
	 */
	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return getNodeFigure().getConnectionAnchor(
				NodeFigure.getDefaultAnchorID());
	}

	/* Defaults the anchor to the centre of the figure.
	 * @custom
	 */
	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return getNodeFigure().getConnectionAnchor(
				NodeFigure.getDefaultAnchorID());
	}

}
