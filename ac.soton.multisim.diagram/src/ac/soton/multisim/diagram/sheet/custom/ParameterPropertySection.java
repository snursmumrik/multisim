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
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.MachinePackage;
import org.eventb.emf.core.machine.Parameter;

import ac.soton.multisim.EventBComponent;
import ac.soton.multisim.EventBPort;
import ac.soton.multisim.MultisimPackage;
import ac.soton.multisim.diagram.sheet.custom.common.AbstractEnumerationPropertySection;

/**
 * Parameter property section for the Event-B input port.
 * 
 * @author vitaly
 *
 */
public class ParameterPropertySection extends AbstractEnumerationPropertySection {

	private EList<EObject> parameters;

	@Override
	protected boolean isEqual(int index) {
		return false;
	}

	@Override
	protected EStructuralFeature getFeature() {
		return MultisimPackage.Literals.EVENT_BPORT__PARAMETER;
	}

	@Override
	protected String[] getEnumerationFeatureValues() {
		EObject container = ((EventBPort) eObject).eContainer();
		if (container instanceof EventBComponent) {
			EventBComponent component = (EventBComponent) container;
			EList<Event> reads = component.getStartStepEvents();
			if (reads.size() > 0) {
				parameters = reads.get(0).getAllContained(MachinePackage.Literals.PARAMETER, true);
				String[] values = new String[parameters.size()];
				int i = 0;
				for (EObject p : parameters) {
					values[i++] = p == null ? ""
							: ((Parameter) p).getName();
				}
				return values;
			}
		}
		return new String[0];
	}

	@Override
	protected String getFeatureAsText() {
		Parameter parameter = ((EventBPort) eObject).getParameter();
		return parameter == null ? "" 
				: ((Parameter) parameter).getName();
	}

	@Override
	protected Object getFeatureValue(int index) {
		return parameters.get(index);
	}

	@Override
	protected String getLabelText() {
		return "Parameter:";
	}

}
