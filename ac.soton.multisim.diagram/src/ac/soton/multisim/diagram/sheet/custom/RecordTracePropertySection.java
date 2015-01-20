/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.sheet.custom;

import org.eclipse.emf.ecore.EStructuralFeature;

import ac.soton.multisim.EventBComponent;
import ac.soton.multisim.MultisimPackage;
import ac.soton.multisim.diagram.sheet.custom.common.AbstractCheckboxPropertySection;

/**
 * @author vitaly
 *
 */
public class RecordTracePropertySection extends AbstractCheckboxPropertySection {

	@Override
	protected boolean getFeatureValue() {
		return ((EventBComponent) eObject).isRecordTrace();
	}
	@Override
	protected String getLabelText() {
		return "Record:";
	}

	@Override
	protected EStructuralFeature getFeature() {
		return MultisimPackage.Literals.EVENT_BCOMPONENT__RECORD_TRACE;
	}
}
