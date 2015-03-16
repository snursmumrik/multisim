/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.sheet.custom;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import ac.soton.multisim.DisplayPort;
import ac.soton.multisim.MultisimPackage;
import ac.soton.multisim.diagram.part.MultisimDiagramEditor;
import ac.soton.multisim.diagram.sheet.custom.common.AbstractMultisimPropertySection;
import ac.soton.multisim.diagram.sheet.custom.common.ColorPicker;

/**
 * Colour property section for DisplayPort.
 * 
 * @author vitaly
 *
 */
public class ColourPropertySection extends AbstractMultisimPropertySection {

	private ColorPicker picker;

	@Override
	protected String getLabelText() {
		return "Colour:";
	}

	@Override
	protected EStructuralFeature getFeature() {
		return MultisimPackage.eINSTANCE.getDisplayPort_Color();
	}

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage propertySheetPage) {
		super.createControls(parent, propertySheetPage);

		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		FormData data;

		picker = new ColorPicker(composite, null);
		data = new FormData();
		data.left = new FormAttachment(0, getPropertyLabelWidth(composite));
		data.top = new FormAttachment(0, 0);
		picker.setLayoutData(data);

		CLabel nameLabel = getWidgetFactory().createCLabel(composite, getLabelText());
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(picker, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(picker, 0, SWT.CENTER);
		nameLabel.setLayoutData(data);

		picker.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				handlePickerModified(e);
			}
		});
	}

	/**
	 * Handle picker modified event.
	 * @param e 
	 */
	protected void handlePickerModified(ModifyEvent e) {
		EditingDomain editingDomain = ((MultisimDiagramEditor) getPart()).getEditingDomain();
		RGB rgb = (RGB) e.data;
		if (rgb != null) {
			Object value = new java.awt.Color(rgb.red, rgb.green, rgb.blue);
			/* apply the property change to single selected object */
			editingDomain.getCommandStack().execute(
					SetCommand.create(editingDomain, eObject, getFeature(),
							value));
		} else {
			editingDomain.getCommandStack().execute(
					SetCommand.create(editingDomain, eObject, getFeature(),
							null));
		}
	}

	@Override
	public void refresh() {
		java.awt.Color colour = ((DisplayPort) eObject).getColor();
		Color pickerColour = null;
		if (colour != null)
			pickerColour = new Color(Display.getCurrent(), colour.getRed(), colour.getGreen(), colour.getBlue());
		picker.setSelectedColor(pickerColour);
	}

}
