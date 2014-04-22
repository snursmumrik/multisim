/*
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.rms.components.diagram.part;

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

import ac.soton.rms.components.AbstractVariable;
import ac.soton.rms.components.Component;
import ac.soton.rms.components.ComponentDiagram;
import ac.soton.rms.components.ComponentsPackage;
import ac.soton.rms.components.DisplayComponent;
import ac.soton.rms.components.DisplayPort;
import ac.soton.rms.components.EventBComponent;
import ac.soton.rms.components.EventBPort;
import ac.soton.rms.components.FMUComponent;
import ac.soton.rms.components.FMUPort;
import ac.soton.rms.components.Port;
import ac.soton.rms.components.diagram.edit.parts.ComponentDiagramEditPart;
import ac.soton.rms.components.diagram.edit.parts.ConnectorEditPart;
import ac.soton.rms.components.diagram.edit.parts.DisplayComponentEditPart;
import ac.soton.rms.components.diagram.edit.parts.DisplayPortEditPart;
import ac.soton.rms.components.diagram.edit.parts.EventBComponentEditPart;
import ac.soton.rms.components.diagram.edit.parts.EventBComponentEventBVariablesCompartmentEditPart;
import ac.soton.rms.components.diagram.edit.parts.EventBInputPortEditPart;
import ac.soton.rms.components.diagram.edit.parts.EventBOutputPortEditPart;
import ac.soton.rms.components.diagram.edit.parts.EventBVariableEditPart;
import ac.soton.rms.components.diagram.edit.parts.FMUComponentEditPart;
import ac.soton.rms.components.diagram.edit.parts.FMUComponentFMUVariablesCompartmentEditPart;
import ac.soton.rms.components.diagram.edit.parts.FMUInputPortEditPart;
import ac.soton.rms.components.diagram.edit.parts.FMUOutputPortEditPart;
import ac.soton.rms.components.diagram.edit.parts.FMUVariableEditPart;
import ac.soton.rms.components.diagram.providers.ComponentsElementTypes;

/**
 * @generated
 */
public class ComponentsDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<ComponentsNodeDescriptor> getSemanticChildren(View view) {
		switch (ComponentsVisualIDRegistry.getVisualID(view)) {
		case ComponentDiagramEditPart.VISUAL_ID:
			return getComponentDiagram_1000SemanticChildren(view);
		case DisplayComponentEditPart.VISUAL_ID:
			return getDisplayComponent_2001SemanticChildren(view);
		case FMUComponentEditPart.VISUAL_ID:
			return getFMUComponent_2002SemanticChildren(view);
		case EventBComponentEditPart.VISUAL_ID:
			return getEventBComponent_2003SemanticChildren(view);
		case FMUComponentFMUVariablesCompartmentEditPart.VISUAL_ID:
			return getFMUComponentFMUVariablesCompartment_7001SemanticChildren(view);
		case EventBComponentEventBVariablesCompartmentEditPart.VISUAL_ID:
			return getEventBComponentEventBVariablesCompartment_7002SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsNodeDescriptor> getComponentDiagram_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		ComponentDiagram modelElement = (ComponentDiagram) view.getElement();
		LinkedList<ComponentsNodeDescriptor> result = new LinkedList<ComponentsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getComponents().iterator(); it
				.hasNext();) {
			Component childElement = (Component) it.next();
			int visualID = ComponentsVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == DisplayComponentEditPart.VISUAL_ID) {
				result.add(new ComponentsNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FMUComponentEditPart.VISUAL_ID) {
				result.add(new ComponentsNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventBComponentEditPart.VISUAL_ID) {
				result.add(new ComponentsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsNodeDescriptor> getDisplayComponent_2001SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		DisplayComponent modelElement = (DisplayComponent) view.getElement();
		LinkedList<ComponentsNodeDescriptor> result = new LinkedList<ComponentsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getInputs().iterator(); it.hasNext();) {
			Port childElement = (Port) it.next();
			int visualID = ComponentsVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == DisplayPortEditPart.VISUAL_ID) {
				result.add(new ComponentsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsNodeDescriptor> getFMUComponent_2002SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		FMUComponent modelElement = (FMUComponent) view.getElement();
		LinkedList<ComponentsNodeDescriptor> result = new LinkedList<ComponentsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getInputs().iterator(); it.hasNext();) {
			Port childElement = (Port) it.next();
			int visualID = ComponentsVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == FMUInputPortEditPart.VISUAL_ID) {
				result.add(new ComponentsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getOutputs().iterator(); it
				.hasNext();) {
			Port childElement = (Port) it.next();
			int visualID = ComponentsVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == FMUOutputPortEditPart.VISUAL_ID) {
				result.add(new ComponentsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsNodeDescriptor> getEventBComponent_2003SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		EventBComponent modelElement = (EventBComponent) view.getElement();
		LinkedList<ComponentsNodeDescriptor> result = new LinkedList<ComponentsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getInputs().iterator(); it.hasNext();) {
			Port childElement = (Port) it.next();
			int visualID = ComponentsVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == EventBInputPortEditPart.VISUAL_ID) {
				result.add(new ComponentsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getOutputs().iterator(); it
				.hasNext();) {
			Port childElement = (Port) it.next();
			int visualID = ComponentsVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == EventBOutputPortEditPart.VISUAL_ID) {
				result.add(new ComponentsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsNodeDescriptor> getFMUComponentFMUVariablesCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		FMUComponent modelElement = (FMUComponent) containerView.getElement();
		LinkedList<ComponentsNodeDescriptor> result = new LinkedList<ComponentsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getVariables().iterator(); it
				.hasNext();) {
			AbstractVariable childElement = (AbstractVariable) it.next();
			int visualID = ComponentsVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == FMUVariableEditPart.VISUAL_ID) {
				result.add(new ComponentsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsNodeDescriptor> getEventBComponentEventBVariablesCompartment_7002SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		EventBComponent modelElement = (EventBComponent) containerView
				.getElement();
		LinkedList<ComponentsNodeDescriptor> result = new LinkedList<ComponentsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getVariables().iterator(); it
				.hasNext();) {
			AbstractVariable childElement = (AbstractVariable) it.next();
			int visualID = ComponentsVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == EventBVariableEditPart.VISUAL_ID) {
				result.add(new ComponentsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getContainedLinks(View view) {
		switch (ComponentsVisualIDRegistry.getVisualID(view)) {
		case ComponentDiagramEditPart.VISUAL_ID:
			return getComponentDiagram_1000ContainedLinks(view);
		case DisplayComponentEditPart.VISUAL_ID:
			return getDisplayComponent_2001ContainedLinks(view);
		case FMUComponentEditPart.VISUAL_ID:
			return getFMUComponent_2002ContainedLinks(view);
		case EventBComponentEditPart.VISUAL_ID:
			return getEventBComponent_2003ContainedLinks(view);
		case DisplayPortEditPart.VISUAL_ID:
			return getDisplayPort_3001ContainedLinks(view);
		case FMUInputPortEditPart.VISUAL_ID:
			return getFMUPort_3002ContainedLinks(view);
		case FMUOutputPortEditPart.VISUAL_ID:
			return getFMUPort_3003ContainedLinks(view);
		case FMUVariableEditPart.VISUAL_ID:
			return getFMUVariable_3004ContainedLinks(view);
		case EventBInputPortEditPart.VISUAL_ID:
			return getEventBPort_3005ContainedLinks(view);
		case EventBOutputPortEditPart.VISUAL_ID:
			return getEventBPort_3006ContainedLinks(view);
		case EventBVariableEditPart.VISUAL_ID:
			return getEventBVariable_3007ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getIncomingLinks(View view) {
		switch (ComponentsVisualIDRegistry.getVisualID(view)) {
		case DisplayComponentEditPart.VISUAL_ID:
			return getDisplayComponent_2001IncomingLinks(view);
		case FMUComponentEditPart.VISUAL_ID:
			return getFMUComponent_2002IncomingLinks(view);
		case EventBComponentEditPart.VISUAL_ID:
			return getEventBComponent_2003IncomingLinks(view);
		case DisplayPortEditPart.VISUAL_ID:
			return getDisplayPort_3001IncomingLinks(view);
		case FMUInputPortEditPart.VISUAL_ID:
			return getFMUPort_3002IncomingLinks(view);
		case FMUOutputPortEditPart.VISUAL_ID:
			return getFMUPort_3003IncomingLinks(view);
		case FMUVariableEditPart.VISUAL_ID:
			return getFMUVariable_3004IncomingLinks(view);
		case EventBInputPortEditPart.VISUAL_ID:
			return getEventBPort_3005IncomingLinks(view);
		case EventBOutputPortEditPart.VISUAL_ID:
			return getEventBPort_3006IncomingLinks(view);
		case EventBVariableEditPart.VISUAL_ID:
			return getEventBVariable_3007IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getOutgoingLinks(View view) {
		switch (ComponentsVisualIDRegistry.getVisualID(view)) {
		case DisplayComponentEditPart.VISUAL_ID:
			return getDisplayComponent_2001OutgoingLinks(view);
		case FMUComponentEditPart.VISUAL_ID:
			return getFMUComponent_2002OutgoingLinks(view);
		case EventBComponentEditPart.VISUAL_ID:
			return getEventBComponent_2003OutgoingLinks(view);
		case DisplayPortEditPart.VISUAL_ID:
			return getDisplayPort_3001OutgoingLinks(view);
		case FMUInputPortEditPart.VISUAL_ID:
			return getFMUPort_3002OutgoingLinks(view);
		case FMUOutputPortEditPart.VISUAL_ID:
			return getFMUPort_3003OutgoingLinks(view);
		case FMUVariableEditPart.VISUAL_ID:
			return getFMUVariable_3004OutgoingLinks(view);
		case EventBInputPortEditPart.VISUAL_ID:
			return getEventBPort_3005OutgoingLinks(view);
		case EventBOutputPortEditPart.VISUAL_ID:
			return getEventBPort_3006OutgoingLinks(view);
		case EventBVariableEditPart.VISUAL_ID:
			return getEventBVariable_3007OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getComponentDiagram_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getDisplayComponent_2001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getFMUComponent_2002ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getEventBComponent_2003ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getDisplayPort_3001ContainedLinks(
			View view) {
		DisplayPort modelElement = (DisplayPort) view.getElement();
		LinkedList<ComponentsLinkDescriptor> result = new LinkedList<ComponentsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Out_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getFMUPort_3002ContainedLinks(
			View view) {
		FMUPort modelElement = (FMUPort) view.getElement();
		LinkedList<ComponentsLinkDescriptor> result = new LinkedList<ComponentsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Out_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getFMUPort_3003ContainedLinks(
			View view) {
		FMUPort modelElement = (FMUPort) view.getElement();
		LinkedList<ComponentsLinkDescriptor> result = new LinkedList<ComponentsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Out_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getFMUVariable_3004ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getEventBPort_3005ContainedLinks(
			View view) {
		EventBPort modelElement = (EventBPort) view.getElement();
		LinkedList<ComponentsLinkDescriptor> result = new LinkedList<ComponentsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Out_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getEventBPort_3006ContainedLinks(
			View view) {
		EventBPort modelElement = (EventBPort) view.getElement();
		LinkedList<ComponentsLinkDescriptor> result = new LinkedList<ComponentsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Out_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getEventBVariable_3007ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getDisplayComponent_2001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getFMUComponent_2002IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getEventBComponent_2003IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getDisplayPort_3001IncomingLinks(
			View view) {
		DisplayPort modelElement = (DisplayPort) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ComponentsLinkDescriptor> result = new LinkedList<ComponentsLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Port_Out_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getFMUPort_3002IncomingLinks(
			View view) {
		FMUPort modelElement = (FMUPort) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ComponentsLinkDescriptor> result = new LinkedList<ComponentsLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Port_Out_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getFMUPort_3003IncomingLinks(
			View view) {
		FMUPort modelElement = (FMUPort) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ComponentsLinkDescriptor> result = new LinkedList<ComponentsLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Port_Out_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getFMUVariable_3004IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getEventBPort_3005IncomingLinks(
			View view) {
		EventBPort modelElement = (EventBPort) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ComponentsLinkDescriptor> result = new LinkedList<ComponentsLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Port_Out_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getEventBPort_3006IncomingLinks(
			View view) {
		EventBPort modelElement = (EventBPort) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ComponentsLinkDescriptor> result = new LinkedList<ComponentsLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Port_Out_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getEventBVariable_3007IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getDisplayComponent_2001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getFMUComponent_2002OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getEventBComponent_2003OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getDisplayPort_3001OutgoingLinks(
			View view) {
		DisplayPort modelElement = (DisplayPort) view.getElement();
		LinkedList<ComponentsLinkDescriptor> result = new LinkedList<ComponentsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Out_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getFMUPort_3002OutgoingLinks(
			View view) {
		FMUPort modelElement = (FMUPort) view.getElement();
		LinkedList<ComponentsLinkDescriptor> result = new LinkedList<ComponentsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Out_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getFMUPort_3003OutgoingLinks(
			View view) {
		FMUPort modelElement = (FMUPort) view.getElement();
		LinkedList<ComponentsLinkDescriptor> result = new LinkedList<ComponentsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Out_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getFMUVariable_3004OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getEventBPort_3005OutgoingLinks(
			View view) {
		EventBPort modelElement = (EventBPort) view.getElement();
		LinkedList<ComponentsLinkDescriptor> result = new LinkedList<ComponentsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Out_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getEventBPort_3006OutgoingLinks(
			View view) {
		EventBPort modelElement = (EventBPort) view.getElement();
		LinkedList<ComponentsLinkDescriptor> result = new LinkedList<ComponentsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Out_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getEventBVariable_3007OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<ComponentsLinkDescriptor> getIncomingFeatureModelFacetLinks_Port_Out_4001(
			Port target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ComponentsLinkDescriptor> result = new LinkedList<ComponentsLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == ComponentsPackage.eINSTANCE
					.getPort_Out()) {
				result.add(new ComponentsLinkDescriptor(setting.getEObject(),
						target, ComponentsElementTypes.PortOut_4001,
						ConnectorEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ComponentsLinkDescriptor> getOutgoingFeatureModelFacetLinks_Port_Out_4001(
			Port source) {
		LinkedList<ComponentsLinkDescriptor> result = new LinkedList<ComponentsLinkDescriptor>();
		for (Iterator<?> destinations = source.getOut().iterator(); destinations
				.hasNext();) {
			Port destination = (Port) destinations.next();
			result.add(new ComponentsLinkDescriptor(source, destination,
					ComponentsElementTypes.PortOut_4001,
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
		public List<ComponentsNodeDescriptor> getSemanticChildren(View view) {
			return ComponentsDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<ComponentsLinkDescriptor> getContainedLinks(View view) {
			return ComponentsDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<ComponentsLinkDescriptor> getIncomingLinks(View view) {
			return ComponentsDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<ComponentsLinkDescriptor> getOutgoingLinks(View view) {
			return ComponentsDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
