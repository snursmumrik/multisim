/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.ui.navigator;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import ac.soton.multisim.ui.MultisimUIActivator;
import ac.soton.multisim.util.FMUResource;

/**
 * @author vitaly
 *
 */
public class FMUNavigatorLabelProvider extends LabelProvider {

	@Override
	public Image getImage(Object element) {
		if (element instanceof FMUResource) {
			return MultisimUIActivator.getImage(MultisimUIActivator.IMAGE_FMU);
		}
		return super.getImage(element);
	}

	@Override
	public String getText(Object element) {
		if (element instanceof FMUResource) {
			return ((FMUResource) element).getName();
		}
		return super.getText(element);
	}

}
