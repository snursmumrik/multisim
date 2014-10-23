/*
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.sheet.custom;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.MachinePackage;
import org.eventb.emf.core.machine.Variable;

import ac.soton.multisim.EventBComponent;
import ac.soton.multisim.EventBPort;
import ac.soton.multisim.MultisimPackage;
import ac.soton.multisim.diagram.sheet.custom.common.AbstractEnumerationPropertySection;

/**
 * Variable property section.
 * 
 * @author vitaly
 *
 */
public class VariablePropertySection extends AbstractEnumerationPropertySection {

	private EList<EObject> variables;

	@Override
	protected boolean isEqual(int index) {
		return false;
	}

	@Override
	protected EStructuralFeature getFeature() {
		return MultisimPackage.Literals.EVENT_BPORT__VARIABLE;
	}

	@Override
	protected String[] getEnumerationFeatureValues() {
		EObject container = ((EventBPort) eObject).eContainer();
		if (container instanceof EventBComponent) {
			EventBComponent component = (EventBComponent) container;
			Machine machine = component.getMachine();
			if (machine != null) {
				variables = machine.getAllContained(MachinePackage.Literals.VARIABLE, true);
				String[] values = new String[variables.size()];
				int i = 0;
				for (EObject v : variables) {
					values[i++] = v == null ? ""
							: ((Variable) v).getName();
				}
				return values;
			}
		}
		return new String[0];
	}

	@Override
	protected String getFeatureAsText() {
		Variable variable = ((EventBPort) eObject).getVariable();
		return variable == null ? "" 
				: ((Variable) variable).getName();
	}

	@Override
	protected Object getFeatureValue(int index) {
		return variables.get(index);
	}

	@Override
	protected String getLabelText() {
		return "Variable:";
	}

}
