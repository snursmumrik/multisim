/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.rms.ui.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;

/**
 * Action for deleting a component diagram.
 * 
 * @author vitaly
 *
 */
public class DeleteDiagramAction extends Action {

	private ICommonActionExtensionSite site;

	public DeleteDiagramAction(ICommonActionExtensionSite actionSite) {
		site = actionSite;
		setText("&Delete");
		setToolTipText("Delete component diagram");
		setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_DELETE));
	}

	@Override
	public void run() {
		if (!(site.getStructuredViewer().getSelection().isEmpty())) {
			IStructuredSelection ssel = (IStructuredSelection) site.getStructuredViewer().getSelection();
			
			Object element = ssel.getFirstElement();
			if (element instanceof IAdaptable) {
				View view = (View) ((IAdaptable) element).getAdapter(View.class);
				Resource resource = view.eResource();
				
				if (resource != null && resource.isLoaded()) {
					IFile file = WorkspaceSynchronizer.getFile(resource);
					MessageDialog dialog = new MessageDialog(
							site.getViewSite().getShell(), 
							"Confirm Diagram Delete", 
							null,
							"Are you sure you want to delete the diagram file '"
									+ file.getName() 
									+ "' from the project '"
									+ file.getParent().getName() 
									+ "' ?",
							MessageDialog.QUESTION,
							new String[] { "Yes", "No" }, 
							0);

					if (dialog.open() == 0) {
						Resource domResource = view.getElement().eResource();
						try {
							closeOpenedEditor(file);
							file.delete(false, false, new NullProgressMonitor());
							WorkspaceSynchronizer.getFile(domResource).delete(false, false, new NullProgressMonitor());
						} catch (PartInitException e) {
							e.printStackTrace();
						} catch (CoreException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	/**
	 * Closes an open editor for a file.
	 * 
	 * @param file
	 * @throws PartInitException
	 */
	static void closeOpenedEditor(IFile file) throws PartInitException {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorReference[] editorReferences = page.getEditorReferences();
		for (int j = 0; j < editorReferences.length; j++) {
			IFile inputFile = (IFile) editorReferences[j].getEditorInput()
					.getAdapter(IFile.class);

			if (file.equals(inputFile)) {
				IEditorPart editor = editorReferences[j].getEditor(true);
				page.closeEditor(editor, false);
			}
		}
	}
}
