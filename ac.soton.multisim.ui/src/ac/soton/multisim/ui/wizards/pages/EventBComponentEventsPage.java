/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.ui.wizards.pages;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eventb.emf.core.machine.Event;

import ac.soton.multisim.EventBComponent;
import ac.soton.multisim.ui.dialogs.DecoratedInputValidator;
import ac.soton.multisim.ui.providers.ColumnProvider;
import ac.soton.multisim.ui.wizards.controls.EditableTableViewerContainer;

/**
 * Event-B component event definition page.
 * Allows to define simulation parameters and events.
 * 
 * @author vitaly
 *
 */
public class EventBComponentEventsPage extends AbstractWizardPage {

	private EventBComponent component;
	
	// UI elements
	private Text stepPeriodText;
	private EditableTableViewerContainer startStepEventsViewer;
	private EditableTableViewerContainer endStepEventsViewer;
	private DecoratedInputValidator stepPeriodValidator;
	private boolean stepPeriodValid;

	/**
	 * @param pageName
	 * @param source
	 */
	public EventBComponentEventsPage(String pageName, EventBComponent component) {
		super(pageName);
		this.component = component;
	}
	
	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		composite.setLayout(layout);

		Composite group = fillLayoutComposite(new Composite(composite, SWT.NULL));
		stepPeriodText = createLabeledText(group, "Step size (ms):", "Enter time period of one simulation step");
		group.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		
		group = fillLayoutComposite(new Composite(composite, SWT.NULL));
		startStepEventsViewer = createLabeledEditableTable(group, "StartStep events:", "Add/Remove events indicating simulation step start and reading inputs", createEventColumnProviders(), null);
		endStepEventsViewer = createLabeledEditableTable(group, "EndStep events:", "Add/Remove events indicating simulation step end", createEventColumnProviders(), null);
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		addValidators();
		addListeners();
		setControl(composite);
	}

	/**
	 * Creates and adds input validators for UI controls.
	 */
	private void addValidators() {
		stepPeriodValidator = new DecoratedInputValidator(
				DecoratedInputValidator.createDecorator(stepPeriodText,
						"Please enter simulation step size (ms)",
						FieldDecorationRegistry.DEC_ERROR, false)) {
			@Override
			public String isValidInput(String timeString) {
				try {
					long input = Integer.parseInt(timeString);
					if (input <= 0)
						return "Simulation step size must be greater that zero";
				} catch (NumberFormatException e) {
					return "Invalid number format";
				}
				return null;
			}
		};
	}

	/**
	 * Creates and adds listeners to UI controls.
	 */
	private void addListeners() {
		stepPeriodText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				if (validateStepPeriod())
					component.setStepPeriod(Integer.parseInt(stepPeriodText.getText()));
			}
		});
		startStepEventsViewer.setChangeListener(new Listener() {
			@Override
			public void handleEvent(org.eclipse.swt.widgets.Event event) {
				validatePage();
			}
		});
		endStepEventsViewer.setChangeListener(new Listener() {
			@Override
			public void handleEvent(org.eclipse.swt.widgets.Event event) {
				validatePage();
			}
		});
	}

	protected boolean validateStepPeriod() {
		if (stepPeriodValidator != null) {
			stepPeriodValid = stepPeriodValidator.isValid(stepPeriodText.getText()) == null;
		}
		validatePage();
		return stepPeriodValid;
	}

	/**
	 * Creates Event-B Event column providers.
	 * 
	 * @return
	 */
	private List<ColumnProvider> createEventColumnProviders() {
		ArrayList<ColumnProvider> providers = new ArrayList<ColumnProvider>();
		providers.add(new ColumnProvider("Name", 200, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((Event) element).getName();
			}}));
		providers.add(new ColumnProvider("Refines", 200, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				String refinesNames = ((Event) element).getRefinesNames().toString();
				return refinesNames.substring(1, refinesNames.length()-1);
			}}));
		return providers;
	}
	
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			
			if (component == null)
				return;
			
			// set input
			stepPeriodText.setText(Integer.toString(component.getStepPeriod()));
			startStepEventsViewer.setInput(component.getMachine().getEvents(), component.getStartStepEvents());
			endStepEventsViewer.setInput(component.getMachine().getEvents(), component.getEndStepEvents());
			
			((Composite) getControl()).layout(true, true);
			
			validatePage();
		}
	}

	/**
	 * Validates page input.
	 */
	public void validatePage() {
		boolean valid = true;
		valid &= stepPeriodValid;
		valid &= startStepEventsViewer.getInput() != null && ((List<?>) startStepEventsViewer.getInput()).size() > 0;
		valid &= endStepEventsViewer.getInput() != null && ((List<?>) endStepEventsViewer.getInput()).size() > 0;
		
		setPageComplete(valid);
	}

	public boolean isModified() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Returns imported component.
	 * 
	 * @return
	 */
	public EventBComponent getModel() {
		return component;
	}

}
