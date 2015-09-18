/*
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.sheet.custom;

import org.eclipse.emf.ecore.EObject;

import ac.soton.multisim.FMUComponent;
import ac.soton.multisim.diagram.sheet.custom.common.AbstractTextPropertySection;

/**
 * Description property section for the FMU path.
 * 
 * @author vitaly
 *
 */
public class FMUPathPropertySection extends AbstractTextPropertySection {

	@Override
	protected String getPropertyNameLabel() {
		return "FMU Path:";
	}

	@Override
	protected void setPropertyValue(EObject object, Object value) {
		((FMUComponent) object).setPath((String) value);
	}

	@Override
	protected String getPropertyValueString() {
		return ((FMUComponent) getEObject()).getPath();
	}

	@Override
	protected String getPropertyChangeCommandName() {
		return "change path";
	}

}
