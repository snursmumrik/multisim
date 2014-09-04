/*
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import ac.soton.multisim.diagram.providers.MultisimElementTypes;
import ac.soton.multisim.diagram.providers.MultisimModelingAssistantProvider;

/**
 * @generated
 */
public class MultisimModelingAssistantProviderOfComponentDiagramEditPart extends
		MultisimModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(MultisimElementTypes.DisplayComponent_2004);
		types.add(MultisimElementTypes.FMUComponent_2005);
		types.add(MultisimElementTypes.EventBComponent_2006);
		return types;
	}

}
