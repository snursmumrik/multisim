/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.ui.viewers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Composite;

import ac.soton.multisim.FMUParameter;
import ac.soton.multisim.ui.providers.ColumnProvider;

/**
 * Table viewer for editing FMU parameters.
 * 
 * @author vitaly
 *
 */
public class FMUParameterTableViewer extends ColumnProviderTableViewer {

	public FMUParameterTableViewer(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected List<ColumnProvider> createColumnProviders() {
		ArrayList<ColumnProvider> providers = new ArrayList<ColumnProvider>();
		providers.add(new ColumnProvider("Name", 200, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((FMUParameter) element).getName();
			}}));
		providers.add(new ColumnProvider("Type", 70, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((FMUParameter) element).getType().toString();
			}}));
		providers.add(new ColumnProvider("Value", 70, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Object value = ((FMUParameter) element).getStartValue();
				return value == null ? null : value.toString();
			}}, 
			new StartValueEditingSupport(this)));
		providers.add(new ColumnProvider("Description", 200, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((FMUParameter) element).getDescription();
			}}));
		return providers;
	}
	
	private class StartValueEditingSupport extends EditingSupport {
		
		public StartValueEditingSupport(ColumnViewer viewer) {
			super(viewer);
		}

		@Override
		protected CellEditor getCellEditor(Object element) {
			return new AbstractVariableValueCellEditor(((TableViewer) getViewer()).getTable(), (FMUParameter) element);
		}

		@Override
		protected boolean canEdit(Object element) {
			return true;
		}

		@Override
		protected Object getValue(Object element) {
			Object value = ((FMUParameter) element).getStartValue();
			return value == null ? "" : value.toString();
		}

		@Override
		protected void setValue(Object element, Object value) {
			FMUParameter param = (FMUParameter) element;
			String valueStr = String.valueOf(value);
			Object startValue = null;
			switch (param.getType()) {
			case BOOLEAN:
				startValue = Boolean.parseBoolean(valueStr);
				break;
			case INTEGER:
				startValue = Integer.parseInt(valueStr);
				break;
			case REAL:
				startValue = Double.parseDouble(valueStr);
				break;
			case STRING:
				startValue = valueStr;
			}
			assert startValue != null;
			param.setStartValue(startValue);
			getViewer().update(element, null);
		}
	}

}
