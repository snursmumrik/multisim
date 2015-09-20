/*
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.part;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.part.DefaultNodeToolEntry;
import org.eclipse.jface.resource.ImageDescriptor;

import ac.soton.multisim.Component;
import ac.soton.multisim.EventBComponent;
import ac.soton.multisim.FMUComponent;
import ac.soton.multisim.diagram.part.custom.InstantiateComponentTool;
import ac.soton.multisim.diagram.providers.MultisimElementTypes;

/**
 * @generated
 */
public class MultisimPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createComponents1Group());
	}

	/**
	 * @custom
	 */
	public static void addToPalette(PaletteRoot paletteRoot, Component component) {
		PaletteGroup importedGroup = null;
		for (Object child : paletteRoot.getChildren()) {
			if (child instanceof PaletteGroup
					&& "importedComponentsGroup".equals(((PaletteGroup) child)
							.getId())) {
				importedGroup = (PaletteGroup) child;
				break;
			}
		}
		if (importedGroup == null) {
			importedGroup = new PaletteGroup("Imported") {
				Set<String> importedIDs = new HashSet<>();

				@Override
				public void add(PaletteEntry entry) {
					if (!importedIDs.contains(entry.getId())) {
						super.add(entry);
						importedIDs.add(entry.getId());
					}
				}
			};
			importedGroup.setId("importedComponentsGroup");
			//			paletteRoot.add(new PaletteSeparator());
			paletteRoot.add(importedGroup);
		}
		String id = null;
		ImageDescriptor imageDescriptor = null;
		if (component instanceof EventBComponent) {
			id = ((EventBComponent) component).getReference();
			imageDescriptor = MultisimDiagramEditorPlugin
					.findImageDescriptor("/ac.soton.multisim/icons/custom/EventBComponent.gif");
		} else if (component instanceof FMUComponent) {
			id = ((FMUComponent) component).getPath();
			imageDescriptor = MultisimDiagramEditorPlugin
					.findImageDescriptor("/ac.soton.multisim/icons/custom/FMUComponent.gif");
		}

		if (id == null)
			return;

		//XXX creates element copy so that it is not affected by the original
		PaletteEntry entry = createComponentInstantiationTool(
				EcoreUtil.copy(component), imageDescriptor);
		entry.setId(id);
		importedGroup.add(entry);
	}

	/**
	 * @param component
	 * @param imageDescriptor 
	 * @return
	 * @custom
	 */
	private static PaletteEntry createComponentInstantiationTool(
			Component component, ImageDescriptor imageDescriptor) {
		InstantiateComponentTool cit = new InstantiateComponentTool(
				component.getName(), "Instantiate " + component.getName(),
				null, component);

		cit.setToolProperty("comp", component);
		cit.setSmallIcon(imageDescriptor);
		cit.setLargeIcon(cit.getSmallIcon());
		return cit;
	}

	/**
	 * Creates "Components" palette tool group
	 * @generated
	 */
	private PaletteContainer createComponents1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.Components1Group_title);
		paletteContainer.setId("createComponents1Group"); //$NON-NLS-1$
		paletteContainer.add(createDisplay1CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDisplay1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				Messages.Display1CreationTool_title,
				Messages.Display1CreationTool_desc,
				Collections
						.singletonList(MultisimElementTypes.DisplayComponent_2004));
		entry.setId("createDisplay1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MultisimDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.multisim/icons/custom/DisplayComponent.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}
}
