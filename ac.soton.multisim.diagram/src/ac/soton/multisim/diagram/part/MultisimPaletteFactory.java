/*
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.part;

import java.util.ArrayList;
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
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;

import ac.soton.multisim.Component;
import ac.soton.multisim.EventBComponent;
import ac.soton.multisim.FMUComponent;
import ac.soton.multisim.diagram.part.custom.ComponentInstantiationTool;
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
	public void addToPalette(PaletteRoot paletteRoot, Component component) {
		PaletteGroup importedGroup = null;
		for (Object child : paletteRoot.getChildren()) {
			if (child instanceof PaletteGroup && "importedComponentsGroup".equals(((PaletteGroup) child).getId())) {
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
				}};
			importedGroup.setId("importedComponentsGroup");
			paletteRoot.add(new PaletteSeparator());
			paletteRoot.add(importedGroup);
		}
		String id = null;
		ImageDescriptor imageDescriptor = null;
		if (component instanceof EventBComponent) {
			id = ((EventBComponent) component).getReference();
			imageDescriptor = MultisimDiagramEditorPlugin.findImageDescriptor("/ac.soton.multisim/icons/custom/EventBComponent.gif");
		} else if (component instanceof FMUComponent) {
			id = ((FMUComponent) component).getPath();
			imageDescriptor = MultisimDiagramEditorPlugin.findImageDescriptor("/ac.soton.multisim/icons/custom/FMUComponent.gif");
		}
		
		if (id == null)
			return;
		
		//XXX creates element copy so that it is not affected by the original
		PaletteEntry entry = createComponentInstantiationTool(EcoreUtil.copy(component), imageDescriptor);
		entry.setId(id);
		importedGroup.add(entry);
	}

	/**
	 * @param component
	 * @param imageDescriptor 
	 * @return
	 * @custom
	 */
	private PaletteEntry createComponentInstantiationTool(Component component, ImageDescriptor imageDescriptor) {
		ComponentInstantiationTool cit = new ComponentInstantiationTool(component.getName(), "Instantiate component "+component.getName(), null, component);

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
		paletteContainer.add(createFMUComponent1CreationTool());
		paletteContainer.add(createEventBComponent2CreationTool());
		paletteContainer.add(createDisplayComponent3CreationTool());
		paletteContainer.add(createInputPort4CreationTool());
		paletteContainer.add(createOutputPort5CreationTool());
		paletteContainer.add(createConnector6CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFMUComponent1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.FMUComponent1CreationTool_title,
				Messages.FMUComponent1CreationTool_desc,
				Collections
						.singletonList(MultisimElementTypes.FMUComponent_2005));
		entry.setId("createFMUComponent1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MultisimDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.multisim/icons/custom/FMUComponent.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEventBComponent2CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.EventBComponent2CreationTool_title,
				Messages.EventBComponent2CreationTool_desc,
				Collections
						.singletonList(MultisimElementTypes.EventBComponent_2006));
		entry.setId("createEventBComponent2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MultisimDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.multisim/icons/custom/EventBComponent.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDisplayComponent3CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.DisplayComponent3CreationTool_title,
				Messages.DisplayComponent3CreationTool_desc,
				Collections
						.singletonList(MultisimElementTypes.DisplayComponent_2004));
		entry.setId("createDisplayComponent3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MultisimDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.multisim/icons/custom/DisplayComponent.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInputPort4CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(MultisimElementTypes.DisplayPort_3001);
		types.add(MultisimElementTypes.FMUPort_3002);
		types.add(MultisimElementTypes.EventBPort_3005);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.InputPort4CreationTool_title,
				Messages.InputPort4CreationTool_desc, types);
		entry.setId("createInputPort4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MultisimDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.multisim/icons/custom/InputPort.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOutputPort5CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(MultisimElementTypes.FMUPort_3003);
		types.add(MultisimElementTypes.EventBPort_3006);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.OutputPort5CreationTool_title,
				Messages.OutputPort5CreationTool_desc, types);
		entry.setId("createOutputPort5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MultisimDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.multisim/icons/custom/OutputPort.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConnector6CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Connector6CreationTool_title,
				Messages.Connector6CreationTool_desc,
				Collections.singletonList(MultisimElementTypes.PortOut_4001));
		entry.setId("createConnector6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MultisimDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.multisim/icons/custom/Connector.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List<IElementType> elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List<IElementType> relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
