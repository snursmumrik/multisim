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
import ac.soton.multisim.diagram.sheet.custom.common.AbstractTextPropertySection;

/**
 * @author vitaly
 *
 */
public class StopTimePropertySection extends AbstractTextPropertySection {

	@Override
	protected String getPropertyNameLabel() {
		return "Stop Time:";
	}

	@Override
	protected void setPropertyValue(EObject object, Object value) {
		assert object instanceof ComponentDiagram;
		try {
			int stopValue = Integer.parseInt((String) value);
			((ComponentDiagram) object).setStopTime(stopValue);
		} catch (NumberFormatException e) {
			//ignore
		}
	}

	@Override
	protected String getPropertyValueString() {
		return String.valueOf(((ComponentDiagram) getEObject()).getStopTime());
	}

	@Override
	protected String getPropertyChangeCommandName() {
		return "change stop time";
	}

}
