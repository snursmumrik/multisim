/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.ui.policies;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.util.ObjectAdapter;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eventb.core.basis.MachineRoot;

import ac.soton.multisim.Component;
import ac.soton.multisim.ComponentDiagram;
import ac.soton.multisim.FMUComponent;
import ac.soton.multisim.MultisimFactory;
import ac.soton.multisim.diagram.part.MultisimPaletteFactory;

/**
 * Drag & drop import edit policy for component diagram.
 * Accepts the drop of:
 * - existing components
 * - machine root
 * - fmu file (eclipse resource IFile)
 * - fmu file (external File)
 * 
 * @author vitaly
 *
 */
public class ComponentImportEditPolicy extends DiagramDragDropEditPolicy {

	// dummy components for the initial value of an element adapter passed to a view request
	private static final Object dummyEventBComponent = MultisimFactory.eINSTANCE.createEventBComponent();
	private static final Object dummyFMUComponent = MultisimFactory.eINSTANCE.createFMUComponent();

	@Override
	public Command getDropObjectsCommand(DropObjectsRequest dropRequest) {
		EObject newElement = null;
		ArrayList<CreateViewRequest.ViewDescriptor> viewDescriptors = new ArrayList<CreateViewRequest.ViewDescriptor>();
		for (Iterator<?> it = dropRequest.getObjects().iterator(); it.hasNext();) {
			Object nextObject = it.next();
			ObjectAdapter adapter = new ObjectAdapter();
			viewDescriptors.add(new CreateViewRequest.ViewDescriptor(
					adapter,
					Node.class, 
					null,
					((GraphicalEditPart) getHost()).getDiagramPreferencesHint()));
			if (nextObject instanceof Component) {
				adapter.setObject(nextObject);
			} else if (nextObject instanceof MachineRoot) {
				adapter.setObject(dummyEventBComponent);
			} else if (nextObject instanceof IFile || nextObject instanceof File) {
				adapter.setObject(dummyFMUComponent);
			}
			
			CompoundCommand cc = new CompoundCommand("Import component");
			cc.add(new ICommandProxy(new ImportCommand(nextObject, adapter, (GraphicalEditPart) getHost(), cc.getLabel())));
			cc.add(createViewsAndArrangeCommand(dropRequest, viewDescriptors));
			return cc;
		}
		return null;
	}

	/**
	 * @author vitaly
	 *
	 */
	public class ImportCommand extends AbstractTransactionalCommand {
		
		private Object importedObject;
		private ObjectAdapter adapter;
		private GraphicalEditPart containerEP;

		public ImportCommand(Object object, ObjectAdapter adapter, GraphicalEditPart containerEP, String label) {
			super(containerEP.getEditingDomain(), label, Collections.singletonList(WorkspaceSynchronizer.getFile(((View) containerEP.getModel()).eResource())));
			this.importedObject = object;
			this.adapter = adapter;
			this.containerEP = containerEP;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			Component component = null;
			if (importedObject instanceof Component) {
				component = (Component) EcoreUtil.copy((Component) importedObject);
			} else if (importedObject instanceof MachineRoot) {
				
			} else if (importedObject instanceof IFile) {
				
			} else if (importedObject instanceof File) {
				
			}
			
			((ComponentDiagram) containerEP.resolveSemanticElement()).getComponents().add(component);
			adapter.setObject(component);

			// add to import palette group
			MultisimPaletteFactory paletteFactory = new MultisimPaletteFactory();
			EditDomain ed = containerEP.getViewer().getEditDomain();
			paletteFactory.addToPalette(ed.getPaletteViewer().getPaletteRoot(), component);
			return CommandResult.newOKCommandResult(new EObjectAdapter(component));
		}
		
		/**
		 * @return
		 */
		private Component getNewComponent() {
			FMUComponent element = MultisimFactory.eINSTANCE.createFMUComponent();
			
			// import wizard for a new component
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			if (MessageDialog.openQuestion(shell, "Name", "Lego?"))
				element.setName("Lego");
			return element;
		}

	}
}