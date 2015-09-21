/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.sheet.custom;

import org.eclipse.emf.ecore.EObject;

import ac.soton.multisim.ComponentDiagram;
import ac.soton.multisim.EventBComponent;
import ac.soton.multisim.diagram.sheet.custom.common.AbstractTextPropertySection;

/**
 * @author vitaly
 *
 */
public class StepSizePropertySection extends AbstractTextPropertySection {

	@Override
	protected String getPropertyNameLabel() {
		return "Step Size:";
	}

	@Override
	protected void setPropertyValue(EObject object, Object value) {
		assert object instanceof ComponentDiagram;
		try {
			int stepValue = Integer.parseInt((String) value);
			((EventBComponent) object).setStepSize(stepValue);
		} catch (NumberFormatException e) {
			//ignore
		}
	}

	@Override
	protected String getPropertyValueString() {
		return String.valueOf(((EventBComponent) getEObject()).getStepSize());
	}

	@Override
	protected String getPropertyChangeCommandName() {
		return "change step";
	}

}
