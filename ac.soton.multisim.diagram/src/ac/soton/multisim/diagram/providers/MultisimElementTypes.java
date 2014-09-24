/*
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.providers;

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

import ac.soton.multisim.MultisimPackage;
import ac.soton.multisim.diagram.edit.parts.ComponentDiagramEditPart;
import ac.soton.multisim.diagram.edit.parts.ConnectorEditPart;
import ac.soton.multisim.diagram.edit.parts.DisplayComponentEditPart;
import ac.soton.multisim.diagram.edit.parts.DisplayPortEditPart;
import ac.soton.multisim.diagram.edit.parts.EventBComponentEditPart;
import ac.soton.multisim.diagram.edit.parts.EventBInputPortEditPart;
import ac.soton.multisim.diagram.edit.parts.EventBOutputPortEditPart;
import ac.soton.multisim.diagram.edit.parts.FMUComponentEditPart;
import ac.soton.multisim.diagram.edit.parts.FMUInputPortEditPart;
import ac.soton.multisim.diagram.edit.parts.FMUOutputPortEditPart;
import ac.soton.multisim.diagram.part.MultisimDiagramEditorPlugin;

/**
 * @generated
 */
public class MultisimElementTypes {

	/**
	 * @generated
	 */
	private MultisimElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			MultisimDiagramEditorPlugin.getInstance()
					.getItemProvidersAdapterFactory());

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType ComponentDiagram_1000 = getElementType("ac.soton.multisim.diagram.ComponentDiagram_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType DisplayComponent_2004 = getElementType("ac.soton.multisim.diagram.DisplayComponent_2004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FMUComponent_2005 = getElementType("ac.soton.multisim.diagram.FMUComponent_2005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType EventBComponent_2006 = getElementType("ac.soton.multisim.diagram.EventBComponent_2006"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType DisplayPort_3001 = getElementType("ac.soton.multisim.diagram.DisplayPort_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FMUPort_3002 = getElementType("ac.soton.multisim.diagram.FMUPort_3002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FMUPort_3003 = getElementType("ac.soton.multisim.diagram.FMUPort_3003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType EventBPort_3005 = getElementType("ac.soton.multisim.diagram.EventBPort_3005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType EventBPort_3006 = getElementType("ac.soton.multisim.diagram.EventBPort_3006"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType PortOut_4001 = getElementType("ac.soton.multisim.diagram.PortOut_4001"); //$NON-NLS-1$

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
					MultisimPackage.eINSTANCE.getComponentDiagram());

			elements.put(DisplayComponent_2004,
					MultisimPackage.eINSTANCE.getDisplayComponent());

			elements.put(FMUComponent_2005,
					MultisimPackage.eINSTANCE.getFMUComponent());

			elements.put(EventBComponent_2006,
					MultisimPackage.eINSTANCE.getEventBComponent());

			elements.put(DisplayPort_3001,
					MultisimPackage.eINSTANCE.getDisplayPort());

			elements.put(FMUPort_3002, MultisimPackage.eINSTANCE.getFMUPort());

			elements.put(FMUPort_3003, MultisimPackage.eINSTANCE.getFMUPort());

			elements.put(EventBPort_3005,
					MultisimPackage.eINSTANCE.getEventBPort());

			elements.put(EventBPort_3006,
					MultisimPackage.eINSTANCE.getEventBPort());

			elements.put(PortOut_4001, MultisimPackage.eINSTANCE.getPort_Out());
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
			KNOWN_ELEMENT_TYPES.add(DisplayComponent_2004);
			KNOWN_ELEMENT_TYPES.add(FMUComponent_2005);
			KNOWN_ELEMENT_TYPES.add(EventBComponent_2006);
			KNOWN_ELEMENT_TYPES.add(DisplayPort_3001);
			KNOWN_ELEMENT_TYPES.add(FMUPort_3002);
			KNOWN_ELEMENT_TYPES.add(FMUPort_3003);
			KNOWN_ELEMENT_TYPES.add(EventBPort_3005);
			KNOWN_ELEMENT_TYPES.add(EventBPort_3006);
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
			return DisplayComponent_2004;
		case FMUComponentEditPart.VISUAL_ID:
			return FMUComponent_2005;
		case EventBComponentEditPart.VISUAL_ID:
			return EventBComponent_2006;
		case DisplayPortEditPart.VISUAL_ID:
			return DisplayPort_3001;
		case FMUInputPortEditPart.VISUAL_ID:
			return FMUPort_3002;
		case FMUOutputPortEditPart.VISUAL_ID:
			return FMUPort_3003;
		case EventBInputPortEditPart.VISUAL_ID:
			return EventBPort_3005;
		case EventBOutputPortEditPart.VISUAL_ID:
			return EventBPort_3006;
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
			return ac.soton.multisim.diagram.providers.MultisimElementTypes
					.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		@Override
		public IElementType getElementTypeForVisualId(int visualID) {
			return ac.soton.multisim.diagram.providers.MultisimElementTypes
					.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public ENamedElement getDefiningNamedElement(
				IAdaptable elementTypeAdapter) {
			return ac.soton.multisim.diagram.providers.MultisimElementTypes
					.getElement(elementTypeAdapter);
		}
	};

}
