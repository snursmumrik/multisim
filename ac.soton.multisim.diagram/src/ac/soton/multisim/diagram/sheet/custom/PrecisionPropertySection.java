/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.sheet.custom;

import org.eclipse.emf.ecore.EStructuralFeature;

import ac.soton.multisim.EventBPort;
import ac.soton.multisim.MultisimPackage;
import ac.soton.multisim.diagram.sheet.custom.common.AbstractSpinnerPropertySection;

/**
 * @author vitaly
 *
 */
public class PrecisionPropertySection extends AbstractSpinnerPropertySection {

	@Override
	protected int getFeatureValue() {
		return ((EventBPort) eObject).getIntToReal();
	}

	@Override
	protected int getIncrement() {
		return 1;
	}

	@Override
	protected int getMaxValue() {
		return 10;
	}

	@Override
	protected int getMinValue() {
		return 0;
	}

	@Override
	protected String getLabelText() {
		return "Precision";
	}

	@Override
	protected EStructuralFeature getFeature() {
		return MultisimPackage.Literals.EVENT_BPORT__INT_TO_REAL;
	}
}
