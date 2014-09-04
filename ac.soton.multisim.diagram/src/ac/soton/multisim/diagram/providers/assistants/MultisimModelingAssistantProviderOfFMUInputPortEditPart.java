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
public class MultisimModelingAssistantProviderOfFMUInputPortEditPart extends
		MultisimModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((FMUInputPortEditPart) sourceEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSource(FMUInputPortEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(MultisimElementTypes.PortOut_4001);
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
				(FMUInputPortEditPart) sourceEditPart, targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSourceAndTarget(
			FMUInputPortEditPart source, IGraphicalEditPart targetEditPart) {
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
		return doGetTypesForTarget((FMUInputPortEditPart) sourceEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForTarget(FMUInputPortEditPart source,
			IElementType relationshipType) {
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
		return doGetRelTypesOnTarget((FMUInputPortEditPart) targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnTarget(FMUInputPortEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(1);
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
		return doGetTypesForSource((FMUInputPortEditPart) targetEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForSource(FMUInputPortEditPart target,
			IElementType relationshipType) {
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
