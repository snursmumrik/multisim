/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.ui.wizards.pages;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Parameter;

import ac.soton.multisim.EventBComponent;
import ac.soton.multisim.EventBPort;
import ac.soton.multisim.VariableCausality;
import ac.soton.multisim.diagram.sheet.custom.common.EventBPortDialog;
import ac.soton.multisim.ui.providers.ColumnProvider;
import ac.soton.multisim.ui.wizards.controls.EditableTableViewerContainer;
import ac.soton.multisim.ui.wizards.controls.SelectionDialogProvider;

/**
 * Event-B component port definition page.
 * Allows to add input/output ports.
 * 
 * @author vitaly
 *
 */
public class EventBComponentPortsPage extends AbstractWizardPage {

	private EventBComponent component;
	private EditableTableViewerContainer inputsViewer;
	private EditableTableViewerContainer outputsViewer;

	/**
	 * @param pageName
	 * @param component
	 */
	public EventBComponentPortsPage(String pageName, EventBComponent component) {
		super(pageName);
		this.component = component;
	}
	
	@Override
	public void createControl(Composite parent) {
		Composite composite = fillLayoutComposite(new Composite(parent, SWT.NULL));
		
		// input and output port tables
		inputsViewer = createLabeledEditableTable(composite, "Input ports:", "Add/Remove input ports", createPortColumnProviders(VariableCausality.INPUT), null);
		outputsViewer = createLabeledEditableTable(composite, "Output ports:", "Add/Remove output ports", createPortColumnProviders(VariableCausality.OUTPUT), null);
		createDialogProviders();
		
		setControl(composite);
	}

	private void createDialogProviders() {
		inputsViewer.setSelectionDialogProvider(new SelectionDialogProvider() {
			@Override
			public SelectionDialog getDialog() {
				Event event = component.getStartStepEvents().get(0);
				EList<Parameter> parameters = new BasicEList<Parameter>();
				while (event != null) {
					parameters.addAll(event.getParameters());
					if (event.isExtended())
						event = event.getRefines().get(0);
					else
						event = null;
				}
				return new EventBPortDialog(getShell(), VariableCausality.INPUT, parameters);
			}
		});
		outputsViewer.setSelectionDialogProvider(new SelectionDialogProvider() {
			@Override
			public SelectionDialog getDialog() {
				return new EventBPortDialog(getShell(), VariableCausality.OUTPUT, component.getMachine().getVariables());
			}
		});
	}

	/**
	 * Creates a list of column providers for the port definition tables.
	 * @param causality 
	 * @return list of column providers
	 */
	private List<ColumnProvider> createPortColumnProviders(VariableCausality causality) {
		ArrayList<ColumnProvider> providers = new ArrayList<ColumnProvider>();
		providers.add(new ColumnProvider("Name", 200, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((EventBPort) element).getName();
			}}));
		providers.add(new ColumnProvider("Type", 70, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((EventBPort) element).getType().toString();
			}}));
		if (causality == VariableCausality.INPUT) {
			providers.add(new ColumnProvider("Parameter", 130, new ColumnLabelProvider() {
				@Override
				public String getText(Object element) {
					return ((EventBPort) element).getParameter().getName();
				}}));
		} else if (causality == VariableCausality.OUTPUT) {
			providers.add(new ColumnProvider("Variable", 130, new ColumnLabelProvider() {
				@Override
				public String getText(Object element) {
					return ((EventBPort) element).getVariable().getName();
				}}));
		}
		return providers;
	}
	
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			if (component == null)
				return;
			
			inputsViewer.setInput(null, component.getInputs());
			outputsViewer.setInput(null, component.getOutputs());
			
			((Composite) getControl()).layout(true, true);
			
			//FIXME: handle case if read event has been redefined and some of ports left are pointing to the wrong event (not read event anymore)
		}
	}

	public EventBComponent getModel() {
		return component;
	}
}
