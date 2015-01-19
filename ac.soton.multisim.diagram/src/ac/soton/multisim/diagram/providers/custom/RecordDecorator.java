/**
 * Copyright (c) 2015 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.providers.custom;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Image;

import ac.soton.multisim.EventBComponent;
import ac.soton.multisim.MultisimPackage;
import ac.soton.multisim.diagram.part.MultisimDiagramEditorPlugin;

/**
 * Trace recording decorator for Event-B components.
 * Modified code from the {@link org.eclipse.gmf.examples.runtime.diagram.decorator.provider.ReviewDecorator} GMF example.
 * 
 * @author vitaly
 *
 */
public class RecordDecorator extends AbstractDecorator {

	private static final Image ICON_RECORD = MultisimDiagramEditorPlugin.getBundledImageDescriptor("icons/obj16/record.png").createImage();

	public RecordDecorator(IDecoratorTarget decoratorTarget) {
		super(decoratorTarget);
	}
	
	/**
	 * getDecoratorTargetClassifier Utility method to determine if the
	 * decoratorTarget is a supported type for this decorator and return the
	 * associated Classifier element.
	 * 
	 * @param decoratorTarget
	 *            IDecoratorTarget to check and return valid Classifier target.
	 * @return node Node if IDecoratorTarget can be supported, null
	 *         otherwise.
	 */
	static public Node getDecoratorTargetNode(IDecoratorTarget decoratorTarget) {
		Object element = decoratorTarget.getAdapter(EventBComponent.class);
		if (element != null) {
			return (Node) decoratorTarget.getAdapter(View.class);
		}
		return null;

	}

	/**
	 * Creates the appropriate review decoration if all the criteria is
	 * satisfied by the view passed in.
	 */
	@Override
	public void refresh() {
		removeDecoration();

		Node node = getDecoratorTargetNode(getDecoratorTarget());

		if (node != null) {
			boolean recording = getRecordStatus(node);
			if (recording) {
				setDecoration(getDecoratorTarget().addShapeDecoration(ICON_RECORD, IDecoratorTarget.Direction.NORTH_EAST, 0, true));
			}
		}
	}

	/**
	 * Accessor to retrieve the recording status from a Node.
	 * 
	 * @param node Node to retrieve the description style from.
	 * @return DescriptionStyle style object
	 */
	private boolean getRecordStatus(Node node) {
		EventBComponent component = (EventBComponent) node.getElement();
		return component.isRecordTrace();			 
	}

	private NotificationListener notificationListener = new NotificationListener() {

        /* (non-Javadoc)
         * @see org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener#notifyChanged(org.eclipse.emf.common.notify.Notification)
         */
        public void notifyChanged(Notification notification) {
            refresh();
        }
	};
	
	/**
	 * Adds decoration if applicable.
	 */
	@Override
	public void activate() {
        
        IGraphicalEditPart gep = (IGraphicalEditPart) getDecoratorTarget().getAdapter(IGraphicalEditPart.class);
        assert gep != null;
        
        DiagramEventBroker.getInstance(gep.getEditingDomain()).addNotificationListener(gep.resolveSemanticElement(), 
                MultisimPackage.eINSTANCE.getEventBComponent_RecordTrace(), notificationListener);
	}

	/**
	 * Removes the decoration.
	 */
	@Override
	public void deactivate() {
		removeDecoration();

        IGraphicalEditPart gep = (IGraphicalEditPart)getDecoratorTarget().getAdapter(IGraphicalEditPart.class);
        assert gep != null;
        
        DiagramEventBroker.getInstance(gep.getEditingDomain()).removeNotificationListener(gep.resolveSemanticElement(), 
                MultisimPackage.eINSTANCE.getEventBComponent_RecordTrace(), notificationListener);
	}
}