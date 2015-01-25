/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.ui.commands;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import ac.soton.multisim.diagram.part.MultisimDiagramEditorPlugin;
import ac.soton.multisim.diagram.part.ValidateAction;
import ac.soton.multisim.util.SimulationStatus;

/**
 * Command handler for validating the diagram.
 * 
 * @author vitaly
 *
 */
public class ValidateCommandHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart diagramEditor = HandlerUtil.getActiveEditorChecked(event);

		// reuse GMF-generated validate action from the diagram
		Action validateAction = new ValidateAction(diagramEditor.getSite().getPage());
		validateAction.run();
		
		// show validation results
		IFile file = WorkspaceSynchronizer.getFile(((IDiagramWorkbenchPart) diagramEditor)
				.getDiagram().eResource());
		List<IMarker> markers = null;
		try {
			markers = ValidateAction.getErrorMarkers(file);
		} catch (CoreException e) {
			throw new ExecutionException(
					"Validation result retrieval failed", e);
		}
		if (markers.isEmpty()) {
			MessageDialog.openInformation(diagramEditor.getSite().getShell(),
					"Validation Information",
					"Validation completed successfully");
		} else {
			final String PID = MultisimDiagramEditorPlugin.ID;
			MultiStatus errors = new MultiStatus(PID, 1, "Diagram constraints violated", null);
			for (IMarker marker : markers) {
				errors.add(SimulationStatus.createErrorStatus(
						marker.getAttribute(IMarker.MESSAGE, "unknown error")));
			}
			ErrorDialog.openError(diagramEditor.getSite().getShell(),
					"Validation Problems", "Problems found during validation",
					errors);
		}

		return null;
	}

}
