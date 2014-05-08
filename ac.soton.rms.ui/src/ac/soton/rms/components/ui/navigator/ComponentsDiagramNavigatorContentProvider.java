/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.rms.components.ui.navigator;

import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.Viewer;

import ac.soton.rms.components.diagram.navigator.ComponentsNavigatorContentProvider;

/**
 * @author vitaly
 *
 */
public class ComponentsDiagramNavigatorContentProvider extends ComponentsNavigatorContentProvider {
	
	/**
	 * 
	 */
	public static final String COMPONENTS_DIAGRAM_EXTENSION = "rmd";
	private static final Object[] NO_OBJECT = new Object[0];

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof IProject) {
			IProject project = (IProject) element;
			return getChildren(project).length > 0;
		}
		return super.hasChildren(element);
	}

	@Override
	public Object[] getChildren(Object element) {
		if (element instanceof IProject) {
			IProject project = (IProject) element;
			if (project.exists() && project.isOpen()) {
				IResource[] members = null;
				try {
					members = project.members();
				} catch (CoreException e) {
					return NO_OBJECT;
				}
				ArrayList<Object> children = new ArrayList<Object>();
				for (IResource res : members) {
					if (COMPONENTS_DIAGRAM_EXTENSION.equals(res.getFileExtension())) {
						Object[] c = super.getChildren(res);
						for (Object o : c)
							children.add(o);
					}
				}
				return children.toArray();
			}
		} else {
			return super.getChildren(element);
		}
		return NO_OBJECT;
	}
	
	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

}
