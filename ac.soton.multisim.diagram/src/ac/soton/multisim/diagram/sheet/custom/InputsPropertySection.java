/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.sheet.custom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Composite;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.Parameter;

import ac.soton.multisim.EventBComponent;
import ac.soton.multisim.EventBPort;
import ac.soton.multisim.MultisimPackage;
import ac.soton.multisim.Port;
import ac.soton.multisim.VariableCausality;
import ac.soton.multisim.diagram.sheet.custom.common.AbstractTablePropertySection;
import ac.soton.multisim.diagram.sheet.custom.common.EventBPortDialog;

/**
 * Wait property section for wait events.
 * 
 * @author vitaly/cfsnook
 *
 */
public class InputsPropertySection extends AbstractTablePropertySection {

	@Override
	protected String getButtonLabelText() {
		return "Input";
	}

	@Override
	protected List<Port> getOwnedRows() {
		return ((EventBComponent) eObject).getInputs();
	}

	@Override
	protected EStructuralFeature getFeature() {
		return MultisimPackage.eINSTANCE.getComponent_Inputs();
	}

	@Override
	protected List<Object> getValuesForRow(Object object) {
		ArrayList<Object> values = new ArrayList<Object>();
		EventBPort port = (EventBPort) object;
		values.add(port.getName());
		values.add(port.getType().getName());
		values.add(port.getParameter() != null ? port.getParameter().getName() : "<undefined>");
		return values;
	}

	@Override
	protected List<String> getColumnLabelText() {
		ArrayList<String> values = new ArrayList<String>();
		values.add("Name");
		values.add("Type");
		values.add("Parameter");
		return values;
	}

	@Override
	protected Object getNewChild() {
		EventBComponent component = (EventBComponent) eObject;
		Machine machine = (Machine) component.getMachine();
		if (machine == null)
			return null;

		// set of parameters from all refinements
		Map<String, Parameter> paramMap = new HashMap<String, Parameter>();
		Event readEvent = component.getReadInputEvents().get(0);
		while (readEvent != null) {
			for (Parameter p : readEvent.getParameters())
				paramMap.put(p.getName(), p);
			
			if (readEvent.isExtended())
				readEvent = readEvent.getRefines().get(0);
			else
				readEvent = null;
		}
		
		EventBPortDialog inputDialog = new EventBPortDialog(getPart().getSite().getShell(), 
				VariableCausality.INPUT, paramMap.values());
		inputDialog.setTitle("New Input Port");
		if (Dialog.OK == inputDialog.open()) {
			Object[] result = inputDialog.getResult();
			return result[0];
		}
		return null;
	}

	@Override
	protected String getLabelText() {
		return "Inputs:";
	}

	@Override
	protected ISelection getEditorSelection(Object object) {
		return null;
	}

	@Override
	protected int getPropertyLabelWidth(Composite composite) {
		return 0;
	}
}
