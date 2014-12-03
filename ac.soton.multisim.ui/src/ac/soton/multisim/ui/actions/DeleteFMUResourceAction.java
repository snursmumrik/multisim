/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.ui.actions;

import java.io.File;
import java.net.URI;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;

import ac.soton.multisim.util.FMUResource;

/**
 * Action for deleting an FMU resource from the Event-B Explorer view.
 * 
 * @author vitaly
 *
 */
public class DeleteFMUResourceAction extends Action {

	private ICommonActionExtensionSite site;

	public DeleteFMUResourceAction(ICommonActionExtensionSite actionSite) {
		site = actionSite;
		setText("&Delete");
		setToolTipText("Delete FMU File");
		setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_DELETE));
	}
	
	@Override
	public void run() {
		if (!(site.getStructuredViewer().getSelection().isEmpty())) {
			IStructuredSelection ssel = (IStructuredSelection) site.getStructuredViewer().getSelection();
			
			Object element = ssel.getFirstElement();
			if (element instanceof FMUResource) {
				File file = ((FMUResource) element).getFile();
				if (file != null) {
					URI uri = file.toURI();
					IWorkspace ws = ResourcesPlugin.getWorkspace();
					IFile[] files = ws.getRoot().findFilesForLocationURI(uri);
					if (files != null && files.length > 0) {
						try {
							files[0].delete(false, new NullProgressMonitor());
						} catch (CoreException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

}
