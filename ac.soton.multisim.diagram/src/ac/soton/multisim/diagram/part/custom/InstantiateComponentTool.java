/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.part.custom;

import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import ac.soton.multisim.Component;

/**
 * Component creation tool.
 * 
 * @author vitaly
 *
 */
public class InstantiateComponentTool extends ToolEntry {

	private Component component;


	public InstantiateComponentTool(String title, String description, List<IElementType> elementTypes) {
		super(title, description, null, null);
	}
	
	public InstantiateComponentTool(String title, String description, List<IElementType> elementTypes, Component component) {
		super(title, description, null, null);
		this.component = component;
	}


	@Override
	public Tool createTool() {
		Tool tool = new InstantiateComponentRequestTool(component);
		tool.setProperties(getToolProperties());
		return tool;
	}
}
