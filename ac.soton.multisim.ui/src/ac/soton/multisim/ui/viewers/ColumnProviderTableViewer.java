/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.ui.viewers;

import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import ac.soton.multisim.ui.providers.ColumnProvider;

/**
 * Table viewer for displaying elements via column providers.
 * Capable of editing variable values via cell editor.
 * 
 * @author vitaly
 *
 */
public abstract class ColumnProviderTableViewer extends TableViewer {

	/**
	 * @param parent
	 * @param style
	 */
	public ColumnProviderTableViewer(Composite parent, int style) {
		super(parent, style);
		createColumns();
	    Table table = getTable();
	    table.setHeaderVisible(true);
	    table.setLinesVisible(true);
		setContentProvider(ArrayContentProvider.getInstance());
	}
	
	/**
	 * Creates column providers for the table viewer.
	 * 
	 * @return providers
	 */
	protected abstract List<ColumnProvider> createColumnProviders();

	/**
	 * Creates columns from providers.
	 */
	private void createColumns() {
		List<ColumnProvider> columnProviders = createColumnProviders();
	    for (ColumnProvider provider : columnProviders) {
			TableViewerColumn column = createTableViewerColumn(provider.getTitle(), provider.getBound());
			column.setLabelProvider(provider.getLabelProvider());
			if (provider.getEditingSupport() != null) {
				column.setEditingSupport(provider.getEditingSupport());
			}
		}
	}

	/**
	 * Creates a table viewer column.
	 * 
	 * @param title column title
	 * @param bound column width
	 * @return table viewer column
	 */
	private TableViewerColumn createTableViewerColumn(String title, int bound) {
		TableViewerColumn viewerColumn = new TableViewerColumn(this, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		return viewerColumn;
	}

}
