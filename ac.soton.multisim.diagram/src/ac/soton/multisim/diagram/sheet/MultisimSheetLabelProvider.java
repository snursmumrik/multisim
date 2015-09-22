/*
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.sheet;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Image;

import ac.soton.multisim.Port;
import ac.soton.multisim.diagram.navigator.MultisimNavigatorGroup;
import ac.soton.multisim.diagram.part.MultisimVisualIDRegistry;
import ac.soton.multisim.diagram.providers.MultisimElementTypes;
import ac.soton.multisim.provider.MultisimItemProviderAdapterFactory;

/**
 * @generated
 */
public class MultisimSheetLabelProvider extends BaseLabelProvider implements
		ILabelProvider {
	// @custom
	AdapterFactoryLabelProvider factoryProvider = new AdapterFactoryLabelProvider(
			new MultisimItemProviderAdapterFactory());

	/**
	 * @generated
	 */
	public String getText(Object element) {
		element = unwrap(element);
		if (element instanceof MultisimNavigatorGroup) {
			return ((MultisimNavigatorGroup) element).getGroupName();
		}
		IElementType etype = getElementType(getView(element));
		return etype == null ? "" : etype.getDisplayName();
	}

	/**
	 * @generated NOT
	 */
	public Image getImage(Object element) {

		// use generated label provider for ports (to distinguish between input and output)
		EObject eobject = getView(unwrap(element)).getElement();
		if (eobject instanceof Port)
			return factoryProvider.getImage(eobject);

		IElementType etype = getElementType(getView(unwrap(element)));
		return etype == null ? null : MultisimElementTypes.getImage(etype);
	}

	/**
	 * @generated
	 */
	private Object unwrap(Object element) {
		if (element instanceof IStructuredSelection) {
			return ((IStructuredSelection) element).getFirstElement();
		}
		return element;
	}

	/**
	 * @generated
	 */
	private View getView(Object element) {
		if (element instanceof View) {
			return (View) element;
		}
		if (element instanceof IAdaptable) {
			return (View) ((IAdaptable) element).getAdapter(View.class);
		}
		return null;
	}

	/**
	 * @generated
	 */
	private IElementType getElementType(View view) {
		// For intermediate views climb up the containment hierarchy to find the one associated with an element type.
		while (view != null) {
			int vid = MultisimVisualIDRegistry.getVisualID(view);
			IElementType etype = MultisimElementTypes.getElementType(vid);
			if (etype != null) {
				return etype;
			}
			view = view.eContainer() instanceof View ? (View) view.eContainer()
					: null;
		}
		return null;
	}

	@Override
	public void dispose() {
		super.dispose();
		factoryProvider.dispose();
	}

}
