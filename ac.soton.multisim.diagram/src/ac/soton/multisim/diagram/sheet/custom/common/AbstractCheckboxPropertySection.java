/*
 * Copyright (c) 2015 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.sheet.custom.common;

import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * An abstract implementation of a section with a checkbox.
 * 
 */
public abstract class AbstractCheckboxPropertySection
	extends AbstractMultisimPropertySection {

	/**
	 * The checkbox control for the section.
	 */
	private Button checkbox;

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#createControls(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	public void createControls(Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		Composite composite = getWidgetFactory()
			.createFlatFormComposite(parent);
		FormData data;

		checkbox = new Button(composite, SWT.CHECK);
		data = new FormData();
		data.left = new FormAttachment(0, getPropertyLabelWidth(composite));
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, 0);
		checkbox.setLayoutData(data);

		CLabel nameLabel = getWidgetFactory().createCLabel(composite,
			getLabelText());
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(checkbox, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(checkbox, 0, SWT.CENTER);
		nameLabel.setLayoutData(data);

		checkbox.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				handleCheckboxModified();
			}
		});
	}

	/**
	 * Handle the checkbox modified event.
	 */
	protected void handleCheckboxModified() {
		EditingDomain editingDomain = ((DiagramEditor) getPart()).getEditingDomain();
		editingDomain.getCommandStack().execute(SetCommand.create(editingDomain, eObject, getFeature(), checkbox.getSelection()));
	}

	/**
	 * Get the value of the feature as boolean for the checkbox.
	 * 
	 * @return the value of the feature as boolean.
	 */
	protected abstract boolean getFeatureValue();

	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		checkbox.setSelection(getFeatureValue());
	}
}