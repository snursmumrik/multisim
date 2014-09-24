/*
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

import ac.soton.multisim.ComponentDiagram;
import ac.soton.multisim.DisplayComponent;
import ac.soton.multisim.DisplayPort;
import ac.soton.multisim.EventBPort;
import ac.soton.multisim.FMUPort;
import ac.soton.multisim.diagram.edit.parts.ComponentDiagramEditPart;
import ac.soton.multisim.diagram.edit.parts.ConnectorEditPart;
import ac.soton.multisim.diagram.edit.parts.DisplayComponentEditPart;
import ac.soton.multisim.diagram.edit.parts.DisplayPortEditPart;
import ac.soton.multisim.diagram.edit.parts.EventBComponentEditPart;
import ac.soton.multisim.diagram.edit.parts.EventBComponentNameEditPart;
import ac.soton.multisim.diagram.edit.parts.EventBInputPortEditPart;
import ac.soton.multisim.diagram.edit.parts.EventBOutputPortEditPart;
import ac.soton.multisim.diagram.edit.parts.FMUComponentEditPart;
import ac.soton.multisim.diagram.edit.parts.FMUComponentNameEditPart;
import ac.soton.multisim.diagram.edit.parts.FMUInputPortEditPart;
import ac.soton.multisim.diagram.edit.parts.FMUOutputPortEditPart;
import ac.soton.multisim.diagram.part.MultisimDiagramEditorPlugin;
import ac.soton.multisim.diagram.part.MultisimVisualIDRegistry;
import ac.soton.multisim.diagram.providers.MultisimElementTypes;
import ac.soton.multisim.diagram.providers.MultisimParserProvider;

/**
 * @generated
 */
public class MultisimNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		MultisimDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		MultisimDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof MultisimNavigatorItem
				&& !isOwnView(((MultisimNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof MultisimNavigatorGroup) {
			MultisimNavigatorGroup group = (MultisimNavigatorGroup) element;
			return MultisimDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof MultisimNavigatorItem) {
			MultisimNavigatorItem navigatorItem = (MultisimNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (MultisimVisualIDRegistry.getVisualID(view)) {
		case ComponentDiagramEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://soton.ac.uk/models/multisim/2.0?ComponentDiagram", MultisimElementTypes.ComponentDiagram_1000); //$NON-NLS-1$
		case DisplayComponentEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/multisim/2.0?DisplayComponent", MultisimElementTypes.DisplayComponent_2004); //$NON-NLS-1$
		case FMUComponentEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/multisim/2.0?FMUComponent", MultisimElementTypes.FMUComponent_2005); //$NON-NLS-1$
		case EventBComponentEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/multisim/2.0?EventBComponent", MultisimElementTypes.EventBComponent_2006); //$NON-NLS-1$
		case DisplayPortEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/multisim/2.0?DisplayPort", MultisimElementTypes.DisplayPort_3001); //$NON-NLS-1$
		case FMUInputPortEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/multisim/2.0?FMUPort", MultisimElementTypes.FMUPort_3002); //$NON-NLS-1$
		case FMUOutputPortEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/multisim/2.0?FMUPort", MultisimElementTypes.FMUPort_3003); //$NON-NLS-1$
		case EventBInputPortEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/multisim/2.0?EventBPort", MultisimElementTypes.EventBPort_3005); //$NON-NLS-1$
		case EventBOutputPortEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/multisim/2.0?EventBPort", MultisimElementTypes.EventBPort_3006); //$NON-NLS-1$
		case ConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://soton.ac.uk/models/multisim/2.0?Port?out", MultisimElementTypes.PortOut_4001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = MultisimDiagramEditorPlugin.getInstance()
				.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& MultisimElementTypes.isKnownElementType(elementType)) {
			image = MultisimElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof MultisimNavigatorGroup) {
			MultisimNavigatorGroup group = (MultisimNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof MultisimNavigatorItem) {
			MultisimNavigatorItem navigatorItem = (MultisimNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (MultisimVisualIDRegistry.getVisualID(view)) {
		case ComponentDiagramEditPart.VISUAL_ID:
			return getComponentDiagram_1000Text(view);
		case DisplayComponentEditPart.VISUAL_ID:
			return getDisplayComponent_2004Text(view);
		case FMUComponentEditPart.VISUAL_ID:
			return getFMUComponent_2005Text(view);
		case EventBComponentEditPart.VISUAL_ID:
			return getEventBComponent_2006Text(view);
		case DisplayPortEditPart.VISUAL_ID:
			return getDisplayPort_3001Text(view);
		case FMUInputPortEditPart.VISUAL_ID:
			return getFMUPort_3002Text(view);
		case FMUOutputPortEditPart.VISUAL_ID:
			return getFMUPort_3003Text(view);
		case EventBInputPortEditPart.VISUAL_ID:
			return getEventBPort_3005Text(view);
		case EventBOutputPortEditPart.VISUAL_ID:
			return getEventBPort_3006Text(view);
		case ConnectorEditPart.VISUAL_ID:
			return getPortOut_4001Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getComponentDiagram_1000Text(View view) {
		ComponentDiagram domainModelElement = (ComponentDiagram) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			MultisimDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDisplayComponent_2004Text(View view) {
		DisplayComponent domainModelElement = (DisplayComponent) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			MultisimDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 2004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFMUComponent_2005Text(View view) {
		IParser parser = MultisimParserProvider.getParser(
				MultisimElementTypes.FMUComponent_2005,
				view.getElement() != null ? view.getElement() : view,
				MultisimVisualIDRegistry
						.getType(FMUComponentNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MultisimDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEventBComponent_2006Text(View view) {
		IParser parser = MultisimParserProvider.getParser(
				MultisimElementTypes.EventBComponent_2006,
				view.getElement() != null ? view.getElement() : view,
				MultisimVisualIDRegistry
						.getType(EventBComponentNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MultisimDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDisplayPort_3001Text(View view) {
		DisplayPort domainModelElement = (DisplayPort) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			MultisimDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 3001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFMUPort_3002Text(View view) {
		FMUPort domainModelElement = (FMUPort) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			MultisimDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 3002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFMUPort_3003Text(View view) {
		FMUPort domainModelElement = (FMUPort) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			MultisimDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 3003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEventBPort_3005Text(View view) {
		EventBPort domainModelElement = (EventBPort) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			MultisimDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 3005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEventBPort_3006Text(View view) {
		EventBPort domainModelElement = (EventBPort) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			MultisimDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 3006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPortOut_4001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return ComponentDiagramEditPart.MODEL_ID
				.equals(MultisimVisualIDRegistry.getModelID(view));
	}

}
