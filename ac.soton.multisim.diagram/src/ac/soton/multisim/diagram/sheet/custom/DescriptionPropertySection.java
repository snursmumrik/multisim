/*
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.sheet.custom;

import org.eclipse.emf.ecore.EObject;

import ac.soton.multisim.FMUPort;
import ac.soton.multisim.diagram.sheet.custom.common.AbstractTextPropertySection;

/**
 * Description property section for the FMU port.
 * 
 * @author vitaly
 *
 */
public class DescriptionPropertySection extends AbstractTextPropertySection {

	@Override
	protected String getPropertyNameLabel() {
		return "Description:";
	}

	@Override
	protected void setPropertyValue(EObject object, Object value) {
		((FMUPort) object).setDescription((String) value);
	}

	@Override
	protected String getPropertyValueString() {
		return ((FMUPort) getEObject()).getDescription();
	}

	@Override
	protected String getPropertyChangeCommandName() {
		return "change description";
	}

}
