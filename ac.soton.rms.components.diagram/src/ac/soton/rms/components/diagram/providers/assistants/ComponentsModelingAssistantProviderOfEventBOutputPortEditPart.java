/*
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.rms.components.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import ac.soton.rms.components.diagram.edit.parts.DisplayPortEditPart;
import ac.soton.rms.components.diagram.edit.parts.EventBInputPortEditPart;
import ac.soton.rms.components.diagram.edit.parts.EventBOutputPortEditPart;
import ac.soton.rms.components.diagram.edit.parts.FMUInputPortEditPart;
import ac.soton.rms.components.diagram.edit.parts.FMUOutputPortEditPart;
import ac.soton.rms.components.diagram.providers.ComponentsElementTypes;
import ac.soton.rms.components.diagram.providers.ComponentsModelingAssistantProvider;

/**
 * @generated
 */
public class ComponentsModelingAssistantProviderOfEventBOutputPortEditPart
		extends ComponentsModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((EventBOutputPortEditPart) sourceEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSource(
			EventBOutputPortEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(ComponentsElementTypes.PortOut_4001);
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget(
				(EventBOutputPortEditPart) sourceEditPart, targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSourceAndTarget(
			EventBOutputPortEditPart source, IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof DisplayPortEditPart) {
			types.add(ComponentsElementTypes.PortOut_4001);
		}
		if (targetEditPart instanceof FMUInputPortEditPart) {
			types.add(ComponentsElementTypes.PortOut_4001);
		}
		if (targetEditPart instanceof FMUOutputPortEditPart) {
			types.add(ComponentsElementTypes.PortOut_4001);
		}
		if (targetEditPart instanceof EventBInputPortEditPart) {
			types.add(ComponentsElementTypes.PortOut_4001);
		}
		if (targetEditPart instanceof EventBOutputPortEditPart) {
			types.add(ComponentsElementTypes.PortOut_4001);
		}
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((EventBOutputPortEditPart) sourceEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForTarget(
			EventBOutputPortEditPart source, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == ComponentsElementTypes.PortOut_4001) {
			types.add(ComponentsElementTypes.DisplayPort_3001);
			types.add(ComponentsElementTypes.FMUPort_3002);
			types.add(ComponentsElementTypes.FMUPort_3003);
			types.add(ComponentsElementTypes.EventBPort_3005);
			types.add(ComponentsElementTypes.EventBPort_3006);
		}
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((EventBOutputPortEditPart) targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnTarget(
			EventBOutputPortEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(ComponentsElementTypes.PortOut_4001);
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((EventBOutputPortEditPart) targetEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForSource(
			EventBOutputPortEditPart target, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == ComponentsElementTypes.PortOut_4001) {
			types.add(ComponentsElementTypes.DisplayPort_3001);
			types.add(ComponentsElementTypes.FMUPort_3002);
			types.add(ComponentsElementTypes.FMUPort_3003);
			types.add(ComponentsElementTypes.EventBPort_3005);
			types.add(ComponentsElementTypes.EventBPort_3006);
		}
		return types;
	}

}
