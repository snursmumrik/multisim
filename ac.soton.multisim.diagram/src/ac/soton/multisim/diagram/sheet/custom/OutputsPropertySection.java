/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.sheet.custom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Composite;
import org.eventb.emf.core.machine.Machine;

import ac.soton.multisim.EventBComponent;
import ac.soton.multisim.EventBPort;
import ac.soton.multisim.MultisimPackage;
import ac.soton.multisim.VariableCausality;
import ac.soton.multisim.diagram.sheet.custom.common.AbstractTablePropertySection;
import ac.soton.multisim.diagram.sheet.custom.common.EventBPortDialog;

/**
 * Wait property section for wait events.
 * 
 * @author vitaly/cfsnook
 *
 */
public class OutputsPropertySection extends AbstractTablePropertySection {

	@Override
	protected String getButtonLabelText() {
		return "Output";
	}

	@Override
	protected List getOwnedRows() {
		return ((EventBComponent) eObject).getOutputs();
	}

	@Override
	protected EStructuralFeature getFeature() {
		return MultisimPackage.eINSTANCE.getComponent_Outputs();
	}

	@Override
	protected List<Object> getValuesForRow(Object object) {
		ArrayList<Object> values = new ArrayList<Object>();
		EventBPort port = (EventBPort) object;
		values.add(port.getName());
		values.add(port.getType().getName());
		values.add(port.getVariable() != null ? port.getVariable().getName() : "<undefined>");
		return values;
	}

	@Override
	protected List<Object> getColumnLabelText() {
		ArrayList<Object> values = new ArrayList<Object>();
		values.add("Name");
		values.add("Type");
		values.add("Variable");
		return values;
	}

	@Override
	protected Object getNewChild() {
		EventBComponent component = (EventBComponent) eObject;
		Machine machine = (Machine) component.getMachine();
		if (machine == null)
			return null;

		EventBPortDialog inputDialog = new EventBPortDialog(getPart().getSite()
				.getShell(), VariableCausality.OUTPUT,
				machine.getVariables());
		inputDialog.setTitle("New Output");
		if (Dialog.OK == inputDialog.open()) {
			Object[] result = inputDialog.getResult();
			return result[0];
		}
		return null;
	}

	@Override
	protected String getLabelText() {
		return "Outputs:";
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
