/*
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.rms.components.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import ac.soton.rms.components.ComponentsPackage;
import ac.soton.rms.components.diagram.edit.parts.ComponentDiagramEditPart;
import ac.soton.rms.components.diagram.edit.parts.ConnectorEditPart;
import ac.soton.rms.components.diagram.edit.parts.DisplayComponentEditPart;
import ac.soton.rms.components.diagram.edit.parts.DisplayPortEditPart;
import ac.soton.rms.components.diagram.edit.parts.EventBComponentEditPart;
import ac.soton.rms.components.diagram.edit.parts.EventBInputPortEditPart;
import ac.soton.rms.components.diagram.edit.parts.EventBOutputPortEditPart;
import ac.soton.rms.components.diagram.edit.parts.EventBVariableEditPart;
import ac.soton.rms.components.diagram.edit.parts.FMUComponentEditPart;
import ac.soton.rms.components.diagram.edit.parts.FMUInputPortEditPart;
import ac.soton.rms.components.diagram.edit.parts.FMUOutputPortEditPart;
import ac.soton.rms.components.diagram.edit.parts.FMUVariableEditPart;
import ac.soton.rms.components.diagram.part.ComponentsDiagramEditorPlugin;

/**
 * @generated
 */
public class ComponentsElementTypes {

	/**
	 * @generated
	 */
	private ComponentsElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			ComponentsDiagramEditorPlugin.getInstance()
					.getItemProvidersAdapterFactory());

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType ComponentDiagram_1000 = getElementType("ac.soton.rms.components.diagram.ComponentDiagram_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType DisplayComponent_2001 = getElementType("ac.soton.rms.components.diagram.DisplayComponent_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FMUComponent_2002 = getElementType("ac.soton.rms.components.diagram.FMUComponent_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType EventBComponent_2003 = getElementType("ac.soton.rms.components.diagram.EventBComponent_2003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType DisplayPort_3001 = getElementType("ac.soton.rms.components.diagram.DisplayPort_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FMUPort_3002 = getElementType("ac.soton.rms.components.diagram.FMUPort_3002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FMUPort_3003 = getElementType("ac.soton.rms.components.diagram.FMUPort_3003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FMUVariable_3004 = getElementType("ac.soton.rms.components.diagram.FMUVariable_3004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType EventBPort_3005 = getElementType("ac.soton.rms.components.diagram.EventBPort_3005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType EventBPort_3006 = getElementType("ac.soton.rms.components.diagram.EventBPort_3006"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType EventBVariable_3007 = getElementType("ac.soton.rms.components.diagram.EventBVariable_3007"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType PortOut_4001 = getElementType("ac.soton.rms.components.diagram.PortOut_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		return elementTypeImages.getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		return elementTypeImages.getImage(element);
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		return getImageDescriptor(getElement(hint));
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		return getImage(getElement(hint));
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(ComponentDiagram_1000,
					ComponentsPackage.eINSTANCE.getComponentDiagram());

			elements.put(DisplayComponent_2001,
					ComponentsPackage.eINSTANCE.getDisplayComponent());

			elements.put(FMUComponent_2002,
					ComponentsPackage.eINSTANCE.getFMUComponent());

			elements.put(EventBComponent_2003,
					ComponentsPackage.eINSTANCE.getEventBComponent());

			elements.put(DisplayPort_3001,
					ComponentsPackage.eINSTANCE.getDisplayPort());

			elements.put(FMUPort_3002, ComponentsPackage.eINSTANCE.getFMUPort());

			elements.put(FMUPort_3003, ComponentsPackage.eINSTANCE.getFMUPort());

			elements.put(FMUVariable_3004,
					ComponentsPackage.eINSTANCE.getFMUVariable());

			elements.put(EventBPort_3005,
					ComponentsPackage.eINSTANCE.getEventBPort());

			elements.put(EventBPort_3006,
					ComponentsPackage.eINSTANCE.getEventBPort());

			elements.put(EventBVariable_3007,
					ComponentsPackage.eINSTANCE.getEventBVariable());

			elements.put(PortOut_4001,
					ComponentsPackage.eINSTANCE.getPort_Out());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(ComponentDiagram_1000);
			KNOWN_ELEMENT_TYPES.add(DisplayComponent_2001);
			KNOWN_ELEMENT_TYPES.add(FMUComponent_2002);
			KNOWN_ELEMENT_TYPES.add(EventBComponent_2003);
			KNOWN_ELEMENT_TYPES.add(DisplayPort_3001);
			KNOWN_ELEMENT_TYPES.add(FMUPort_3002);
			KNOWN_ELEMENT_TYPES.add(FMUPort_3003);
			KNOWN_ELEMENT_TYPES.add(FMUVariable_3004);
			KNOWN_ELEMENT_TYPES.add(EventBPort_3005);
			KNOWN_ELEMENT_TYPES.add(EventBPort_3006);
			KNOWN_ELEMENT_TYPES.add(EventBVariable_3007);
			KNOWN_ELEMENT_TYPES.add(PortOut_4001);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case ComponentDiagramEditPart.VISUAL_ID:
			return ComponentDiagram_1000;
		case DisplayComponentEditPart.VISUAL_ID:
			return DisplayComponent_2001;
		case FMUComponentEditPart.VISUAL_ID:
			return FMUComponent_2002;
		case EventBComponentEditPart.VISUAL_ID:
			return EventBComponent_2003;
		case DisplayPortEditPart.VISUAL_ID:
			return DisplayPort_3001;
		case FMUInputPortEditPart.VISUAL_ID:
			return FMUPort_3002;
		case FMUOutputPortEditPart.VISUAL_ID:
			return FMUPort_3003;
		case FMUVariableEditPart.VISUAL_ID:
			return FMUVariable_3004;
		case EventBInputPortEditPart.VISUAL_ID:
			return EventBPort_3005;
		case EventBOutputPortEditPart.VISUAL_ID:
			return EventBPort_3006;
		case EventBVariableEditPart.VISUAL_ID:
			return EventBVariable_3007;
		case ConnectorEditPart.VISUAL_ID:
			return PortOut_4001;
		}
		return null;
	}

	/**
	 * @generated
	 */
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(
			elementTypeImages) {

		/**
		 * @generated
		 */
		@Override
		public boolean isKnownElementType(IElementType elementType) {
			return ac.soton.rms.components.diagram.providers.ComponentsElementTypes
					.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		@Override
		public IElementType getElementTypeForVisualId(int visualID) {
			return ac.soton.rms.components.diagram.providers.ComponentsElementTypes
					.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public ENamedElement getDefiningNamedElement(
				IAdaptable elementTypeAdapter) {
			return ac.soton.rms.components.diagram.providers.ComponentsElementTypes
					.getElement(elementTypeAdapter);
		}
	};

}
