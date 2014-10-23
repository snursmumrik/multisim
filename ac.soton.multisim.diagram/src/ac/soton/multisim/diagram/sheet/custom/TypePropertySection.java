/*
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.sheet.custom;

import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;

import ac.soton.multisim.MultisimPackage;
import ac.soton.multisim.Port;
import ac.soton.multisim.VariableType;
import ac.soton.multisim.diagram.sheet.custom.common.AbstractEnumerationPropertySection;

/**
 * Variable type property section.
 * 
 * @author vitaly
 *
 */
public class TypePropertySection extends AbstractEnumerationPropertySection {

	@Override
	protected boolean isEqual(int index) {
		return VariableType.VALUES.get(index).equals(((Port) eObject).getType());
	}

	@Override
	protected String[] getEnumerationFeatureValues() {
		List<VariableType> values = VariableType.VALUES;
		String[] ret = new String[values.size()];
		for (int i = 0; i < values.size(); i++) {
			ret[i] = values.get(i).getName();
		}
		return ret;
	}

	@Override
	protected String getFeatureAsText() {
		return ((Port) eObject).getType().getName();
	}

	@Override
	protected Object getFeatureValue(int index) {
		return VariableType.VALUES.get(index);
	}

	@Override
	protected String getLabelText() {
		return "Type:";
	}

	@Override
	protected EStructuralFeature getFeature() {
		return MultisimPackage.Literals.ABSTRACT_VARIABLE__TYPE;
	}

}
