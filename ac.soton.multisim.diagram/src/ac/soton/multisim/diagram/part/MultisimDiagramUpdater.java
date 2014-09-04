/*
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

import ac.soton.multisim.Component;
import ac.soton.multisim.ComponentDiagram;
import ac.soton.multisim.DisplayComponent;
import ac.soton.multisim.DisplayPort;
import ac.soton.multisim.EventBComponent;
import ac.soton.multisim.EventBPort;
import ac.soton.multisim.FMUComponent;
import ac.soton.multisim.FMUPort;
import ac.soton.multisim.MultisimPackage;
import ac.soton.multisim.Port;
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
import ac.soton.multisim.diagram.providers.MultisimElementTypes;

/**
 * @generated
 */
public class MultisimDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<MultisimNodeDescriptor> getSemanticChildren(View view) {
		switch (MultisimVisualIDRegistry.getVisualID(view)) {
		case ComponentDiagramEditPart.VISUAL_ID:
			return getComponentDiagram_1000SemanticChildren(view);
		case DisplayComponentEditPart.VISUAL_ID:
			return getDisplayComponent_2004SemanticChildren(view);
		case FMUComponentEditPart.VISUAL_ID:
			return getFMUComponent_2005SemanticChildren(view);
		case EventBComponentEditPart.VISUAL_ID:
			return getEventBComponent_2006SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MultisimNodeDescriptor> getComponentDiagram_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		ComponentDiagram modelElement = (ComponentDiagram) view.getElement();
		LinkedList<MultisimNodeDescriptor> result = new LinkedList<MultisimNodeDescriptor>();
		for (Iterator<?> it = modelElement.getComponents().iterator(); it
				.hasNext();) {
			Component childElement = (Component) it.next();
			int visualID = MultisimVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == DisplayComponentEditPart.VISUAL_ID) {
				result.add(new MultisimNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FMUComponentEditPart.VISUAL_ID) {
				result.add(new MultisimNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventBComponentEditPart.VISUAL_ID) {
				result.add(new MultisimNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MultisimNodeDescriptor> getDisplayComponent_2004SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		DisplayComponent modelElement = (DisplayComponent) view.getElement();
		LinkedList<MultisimNodeDescriptor> result = new LinkedList<MultisimNodeDescriptor>();
		for (Iterator<?> it = modelElement.getInputs().iterator(); it.hasNext();) {
			Port childElement = (Port) it.next();
			int visualID = MultisimVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == DisplayPortEditPart.VISUAL_ID) {
				result.add(new MultisimNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MultisimNodeDescriptor> getFMUComponent_2005SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		FMUComponent modelElement = (FMUComponent) view.getElement();
		LinkedList<MultisimNodeDescriptor> result = new LinkedList<MultisimNodeDescriptor>();
		for (Iterator<?> it = modelElement.getInputs().iterator(); it.hasNext();) {
			Port childElement = (Port) it.next();
			int visualID = MultisimVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == FMUInputPortEditPart.VISUAL_ID) {
				result.add(new MultisimNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getOutputs().iterator(); it
				.hasNext();) {
			Port childElement = (Port) it.next();
			int visualID = MultisimVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == FMUOutputPortEditPart.VISUAL_ID) {
				result.add(new MultisimNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MultisimNodeDescriptor> getEventBComponent_2006SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		EventBComponent modelElement = (EventBComponent) view.getElement();
		LinkedList<MultisimNodeDescriptor> result = new LinkedList<MultisimNodeDescriptor>();
		for (Iterator<?> it = modelElement.getInputs().iterator(); it.hasNext();) {
			Port childElement = (Port) it.next();
			int visualID = MultisimVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == EventBInputPortEditPart.VISUAL_ID) {
				result.add(new MultisimNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getOutputs().iterator(); it
				.hasNext();) {
			Port childElement = (Port) it.next();
			int visualID = MultisimVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == EventBOutputPortEditPart.VISUAL_ID) {
				result.add(new MultisimNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MultisimLinkDescriptor> getContainedLinks(View view) {
		switch (MultisimVisualIDRegistry.getVisualID(view)) {
		case ComponentDiagramEditPart.VISUAL_ID:
			return getComponentDiagram_1000ContainedLinks(view);
		case DisplayComponentEditPart.VISUAL_ID:
			return getDisplayComponent_2004ContainedLinks(view);
		case FMUComponentEditPart.VISUAL_ID:
			return getFMUComponent_2005ContainedLinks(view);
		case EventBComponentEditPart.VISUAL_ID:
			return getEventBComponent_2006ContainedLinks(view);
		case DisplayPortEditPart.VISUAL_ID:
			return getDisplayPort_3001ContainedLinks(view);
		case FMUInputPortEditPart.VISUAL_ID:
			return getFMUPort_3002ContainedLinks(view);
		case FMUOutputPortEditPart.VISUAL_ID:
			return getFMUPort_3003ContainedLinks(view);
		case EventBInputPortEditPart.VISUAL_ID:
			return getEventBPort_3005ContainedLinks(view);
		case EventBOutputPortEditPart.VISUAL_ID:
			return getEventBPort_3006ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MultisimLinkDescriptor> getIncomingLinks(View view) {
		switch (MultisimVisualIDRegistry.getVisualID(view)) {
		case DisplayComponentEditPart.VISUAL_ID:
			return getDisplayComponent_2004IncomingLinks(view);
		case FMUComponentEditPart.VISUAL_ID:
			return getFMUComponent_2005IncomingLinks(view);
		case EventBComponentEditPart.VISUAL_ID:
			return getEventBComponent_2006IncomingLinks(view);
		case DisplayPortEditPart.VISUAL_ID:
			return getDisplayPort_3001IncomingLinks(view);
		case FMUInputPortEditPart.VISUAL_ID:
			return getFMUPort_3002IncomingLinks(view);
		case FMUOutputPortEditPart.VISUAL_ID:
			return getFMUPort_3003IncomingLinks(view);
		case EventBInputPortEditPart.VISUAL_ID:
			return getEventBPort_3005IncomingLinks(view);
		case EventBOutputPortEditPart.VISUAL_ID:
			return getEventBPort_3006IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MultisimLinkDescriptor> getOutgoingLinks(View view) {
		switch (MultisimVisualIDRegistry.getVisualID(view)) {
		case DisplayComponentEditPart.VISUAL_ID:
			return getDisplayComponent_2004OutgoingLinks(view);
		case FMUComponentEditPart.VISUAL_ID:
			return getFMUComponent_2005OutgoingLinks(view);
		case EventBComponentEditPart.VISUAL_ID:
			return getEventBComponent_2006OutgoingLinks(view);
		case DisplayPortEditPart.VISUAL_ID:
			return getDisplayPort_3001OutgoingLinks(view);
		case FMUInputPortEditPart.VISUAL_ID:
			return getFMUPort_3002OutgoingLinks(view);
		case FMUOutputPortEditPart.VISUAL_ID:
			return getFMUPort_3003OutgoingLinks(view);
		case EventBInputPortEditPart.VISUAL_ID:
			return getEventBPort_3005OutgoingLinks(view);
		case EventBOutputPortEditPart.VISUAL_ID:
			return getEventBPort_3006OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MultisimLinkDescriptor> getComponentDiagram_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MultisimLinkDescriptor> getDisplayComponent_2004ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MultisimLinkDescriptor> getFMUComponent_2005ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MultisimLinkDescriptor> getEventBComponent_2006ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MultisimLinkDescriptor> getDisplayPort_3001ContainedLinks(
			View view) {
		DisplayPort modelElement = (DisplayPort) view.getElement();
		LinkedList<MultisimLinkDescriptor> result = new LinkedList<MultisimLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Out_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MultisimLinkDescriptor> getFMUPort_3002ContainedLinks(
			View view) {
		FMUPort modelElement = (FMUPort) view.getElement();
		LinkedList<MultisimLinkDescriptor> result = new LinkedList<MultisimLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Out_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MultisimLinkDescriptor> getFMUPort_3003ContainedLinks(
			View view) {
		FMUPort modelElement = (FMUPort) view.getElement();
		LinkedList<MultisimLinkDescriptor> result = new LinkedList<MultisimLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Out_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MultisimLinkDescriptor> getEventBPort_3005ContainedLinks(
			View view) {
		EventBPort modelElement = (EventBPort) view.getElement();
		LinkedList<MultisimLinkDescriptor> result = new LinkedList<MultisimLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Out_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MultisimLinkDescriptor> getEventBPort_3006ContainedLinks(
			View view) {
		EventBPort modelElement = (EventBPort) view.getElement();
		LinkedList<MultisimLinkDescriptor> result = new LinkedList<MultisimLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Out_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MultisimLinkDescriptor> getDisplayComponent_2004IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MultisimLinkDescriptor> getFMUComponent_2005IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MultisimLinkDescriptor> getEventBComponent_2006IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MultisimLinkDescriptor> getDisplayPort_3001IncomingLinks(
			View view) {
		DisplayPort modelElement = (DisplayPort) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MultisimLinkDescriptor> result = new LinkedList<MultisimLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Port_Out_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MultisimLinkDescriptor> getFMUPort_3002IncomingLinks(
			View view) {
		FMUPort modelElement = (FMUPort) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MultisimLinkDescriptor> result = new LinkedList<MultisimLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Port_Out_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MultisimLinkDescriptor> getFMUPort_3003IncomingLinks(
			View view) {
		FMUPort modelElement = (FMUPort) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MultisimLinkDescriptor> result = new LinkedList<MultisimLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Port_Out_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MultisimLinkDescriptor> getEventBPort_3005IncomingLinks(
			View view) {
		EventBPort modelElement = (EventBPort) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MultisimLinkDescriptor> result = new LinkedList<MultisimLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Port_Out_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MultisimLinkDescriptor> getEventBPort_3006IncomingLinks(
			View view) {
		EventBPort modelElement = (EventBPort) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MultisimLinkDescriptor> result = new LinkedList<MultisimLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Port_Out_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MultisimLinkDescriptor> getDisplayComponent_2004OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MultisimLinkDescriptor> getFMUComponent_2005OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MultisimLinkDescriptor> getEventBComponent_2006OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MultisimLinkDescriptor> getDisplayPort_3001OutgoingLinks(
			View view) {
		DisplayPort modelElement = (DisplayPort) view.getElement();
		LinkedList<MultisimLinkDescriptor> result = new LinkedList<MultisimLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Out_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MultisimLinkDescriptor> getFMUPort_3002OutgoingLinks(
			View view) {
		FMUPort modelElement = (FMUPort) view.getElement();
		LinkedList<MultisimLinkDescriptor> result = new LinkedList<MultisimLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Out_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MultisimLinkDescriptor> getFMUPort_3003OutgoingLinks(
			View view) {
		FMUPort modelElement = (FMUPort) view.getElement();
		LinkedList<MultisimLinkDescriptor> result = new LinkedList<MultisimLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Out_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MultisimLinkDescriptor> getEventBPort_3005OutgoingLinks(
			View view) {
		EventBPort modelElement = (EventBPort) view.getElement();
		LinkedList<MultisimLinkDescriptor> result = new LinkedList<MultisimLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Out_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MultisimLinkDescriptor> getEventBPort_3006OutgoingLinks(
			View view) {
		EventBPort modelElement = (EventBPort) view.getElement();
		LinkedList<MultisimLinkDescriptor> result = new LinkedList<MultisimLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Out_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MultisimLinkDescriptor> getIncomingFeatureModelFacetLinks_Port_Out_4001(
			Port target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MultisimLinkDescriptor> result = new LinkedList<MultisimLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == MultisimPackage.eINSTANCE
					.getPort_Out()) {
				result.add(new MultisimLinkDescriptor(setting.getEObject(),
						target, MultisimElementTypes.PortOut_4001,
						ConnectorEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MultisimLinkDescriptor> getOutgoingFeatureModelFacetLinks_Port_Out_4001(
			Port source) {
		LinkedList<MultisimLinkDescriptor> result = new LinkedList<MultisimLinkDescriptor>();
		for (Iterator<?> destinations = source.getOut().iterator(); destinations
				.hasNext();) {
			Port destination = (Port) destinations.next();
			result.add(new MultisimLinkDescriptor(source, destination,
					MultisimElementTypes.PortOut_4001,
					ConnectorEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		 * @generated
		 */
		@Override
		public List<MultisimNodeDescriptor> getSemanticChildren(View view) {
			return MultisimDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<MultisimLinkDescriptor> getContainedLinks(View view) {
			return MultisimDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<MultisimLinkDescriptor> getIncomingLinks(View view) {
			return MultisimDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<MultisimLinkDescriptor> getOutgoingLinks(View view) {
			return MultisimDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
