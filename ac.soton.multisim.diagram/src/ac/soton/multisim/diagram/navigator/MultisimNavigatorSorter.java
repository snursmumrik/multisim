/*
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

import ac.soton.multisim.diagram.part.MultisimVisualIDRegistry;

/**
 * @generated
 */
public class MultisimNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 7008;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof MultisimNavigatorItem) {
			MultisimNavigatorItem item = (MultisimNavigatorItem) element;
			return MultisimVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
