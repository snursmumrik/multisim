/*
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import ac.soton.multisim.Port;
import ac.soton.multisim.diagram.edit.parts.DisplayPortEditPart;
import ac.soton.multisim.diagram.edit.parts.EventBInputPortEditPart;
import ac.soton.multisim.diagram.edit.parts.EventBOutputPortEditPart;
import ac.soton.multisim.diagram.edit.parts.FMUInputPortEditPart;
import ac.soton.multisim.diagram.edit.parts.FMUOutputPortEditPart;
import ac.soton.multisim.diagram.providers.MultisimElementTypes;
import ac.soton.multisim.diagram.providers.MultisimModelingAssistantProvider;

/**
 * @generated
 */
public class MultisimModelingAssistantProviderOfEventBInputPortEditPart extends
		MultisimModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((EventBInputPortEditPart) sourceEditPart);
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> doGetRelTypesOnSource(
			EventBInputPortEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		// commented to remove the output connection handle
		//		types.add(MultisimElementTypes.PortOut_4001);
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
				(EventBInputPortEditPart) sourceEditPart, targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSourceAndTarget(
			EventBInputPortEditPart source, IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof DisplayPortEditPart) {
			types.add(MultisimElementTypes.PortOut_4001);
		}
		if (targetEditPart instanceof FMUInputPortEditPart) {
			types.add(MultisimElementTypes.PortOut_4001);
		}
		if (targetEditPart instanceof FMUOutputPortEditPart) {
			types.add(MultisimElementTypes.PortOut_4001);
		}
		if (targetEditPart instanceof EventBInputPortEditPart) {
			types.add(MultisimElementTypes.PortOut_4001);
		}
		if (targetEditPart instanceof EventBOutputPortEditPart) {
			types.add(MultisimElementTypes.PortOut_4001);
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
		return doGetTypesForTarget((EventBInputPortEditPart) sourceEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForTarget(
			EventBInputPortEditPart source, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == MultisimElementTypes.PortOut_4001) {
			types.add(MultisimElementTypes.DisplayPort_3001);
			types.add(MultisimElementTypes.FMUPort_3002);
			types.add(MultisimElementTypes.FMUPort_3003);
			types.add(MultisimElementTypes.EventBPort_3005);
			types.add(MultisimElementTypes.EventBPort_3006);
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
		return doGetRelTypesOnTarget((EventBInputPortEditPart) targetEditPart);
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> doGetRelTypesOnTarget(
			EventBInputPortEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		// only show the input connection handle if there is no input yet
		if (((Port) target.resolveSemanticElement()).getIn() == null)
			types.add(MultisimElementTypes.PortOut_4001);
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
		return doGetTypesForSource((EventBInputPortEditPart) targetEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForSource(
			EventBInputPortEditPart target, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == MultisimElementTypes.PortOut_4001) {
			types.add(MultisimElementTypes.DisplayPort_3001);
			types.add(MultisimElementTypes.FMUPort_3002);
			types.add(MultisimElementTypes.FMUPort_3003);
			types.add(MultisimElementTypes.EventBPort_3005);
			types.add(MultisimElementTypes.EventBPort_3006);
		}
		return types;
	}

}
