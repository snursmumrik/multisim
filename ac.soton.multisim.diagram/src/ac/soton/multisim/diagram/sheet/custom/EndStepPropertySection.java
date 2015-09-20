/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.sheet.custom;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;

import ac.soton.multisim.EventBComponent;
import ac.soton.multisim.MultisimPackage;
import ac.soton.multisim.diagram.sheet.custom.common.AbstractTablePropertySection;

/**
 * Property section for 'EndStep' events.
 * 
 * @author vitaly/cfsnook
 *
 */
public class EndStepPropertySection extends AbstractTablePropertySection {
	
	private static ILabelProvider eventLabelProvider = new LabelProvider() {

	@Override
	public String getText(Object element) {
		return ((Event) element).getName();
	}};

	@Override
	protected String getButtonLabelText() {
		return "Event";
	}

	@Override
	protected List<Event> getOwnedRows() {
		return ((EventBComponent) eObject).getEndStepEvents();
	}

	@Override
	protected EStructuralFeature getFeature() {
		return MultisimPackage.eINSTANCE.getEventBComponent_EndStepEvents();
	}

	@Override
	protected List<Object> getValuesForRow(Object object) {
		ArrayList<Object> values = new ArrayList<Object>();
		values.add(((Event) object).getName());
		values.add(((Event) object).getRefinesNames().toString().substring(1).replace("]",""));		
		return values;
	}

	@Override
	protected List<String> getColumnLabelText() {
		ArrayList<String> values = new ArrayList<String>();
		values.add("Event");
		values.add("Refines");		
		return values;
	}

	@Override
	protected Object getNewChild() {
		Machine machine = (Machine) ((EventBComponent) eObject).getMachine();
		if (machine == null)
			return null;

		ListSelectionDialog eventsDialog = new ListSelectionDialog(getPart()
				.getSite().getShell(), machine.getEvents(),
				ArrayContentProvider.getInstance(), eventLabelProvider,
				"Select 'EndStep' events:");
		eventsDialog.setTitle(machine.getName() + " Events");
		if (Dialog.OK == eventsDialog.open()) {
			Object[] result = eventsDialog.getResult();
			if (result.length > 0) {
				Set<Event> existingEvents = new HashSet<>(((EventBComponent) eObject).getEndStepEvents());
				List<Event> events = new ArrayList<Event>();
				for (Object obj : result) {
					if (!existingEvents.contains(obj))
						events.add((Event) obj);
				}
				return events;
			}
		}
		return null;
	}

	@Override
	protected String getLabelText() {
		return null;
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
