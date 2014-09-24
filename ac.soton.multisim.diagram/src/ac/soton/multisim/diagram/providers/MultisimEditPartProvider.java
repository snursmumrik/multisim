/*
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.providers;

import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;

import ac.soton.multisim.diagram.edit.parts.ComponentDiagramEditPart;
import ac.soton.multisim.diagram.edit.parts.MultisimEditPartFactory;
import ac.soton.multisim.diagram.part.MultisimVisualIDRegistry;

/**
 * @generated
 */
public class MultisimEditPartProvider extends DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public MultisimEditPartProvider() {
		super(new MultisimEditPartFactory(),
				MultisimVisualIDRegistry.TYPED_INSTANCE,
				ComponentDiagramEditPart.MODEL_ID);
	}

}
