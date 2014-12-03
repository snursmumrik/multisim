/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.ui.navigator;

import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import ac.soton.multisim.util.FMUResource;

/**
 * @author vitaly
 *
 */
public class FMUNavigatorContentProvider implements ITreeContentProvider {
	
	private static final Object[] NO_OBJECT = new Object[0];
	private static final String FMU_EXTENSION = "fmu";

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof IProject) {
			IProject project = (IProject) element;
			return getChildren(project).length > 0;
		}
		return false;
	}
	
	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IProject) {
			IProject project = (IProject) parentElement;
			if (project.exists() && project.isOpen()) {
				IResource[] members = null;
				try {
					members = project.members();
				} catch (CoreException e) {
					return NO_OBJECT;
				}
				ArrayList<Object> children = new ArrayList<Object>();
				for (IResource res : members) {
					if (FMU_EXTENSION.equals(res.getFileExtension())) {
						children.add(new FMUResource(res));
					}
				}
				return children.toArray();
			}
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
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}
	
	@Override
	public void dispose() {
	}
}
