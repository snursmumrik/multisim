/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.part.custom;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.util.ObjectAdapter;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.tools.CreationTool;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import ac.soton.multisim.Component;
import ac.soton.multisim.ComponentDiagram;
import ac.soton.multisim.diagram.part.MultisimDiagramEditor;

/**
 * Component creation command from the palette.
 * Creates a copy of the tool entry element.
 * 
 * @author vitaly
 *
 */
public class InstantiateComponentRequestTool extends CreationTool {
	
	private Component component;
	private GraphicalEditPart diagramEP;

	public InstantiateComponentRequestTool(Component comp) {
		super();
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (editor instanceof MultisimDiagramEditor) {
			component = comp;
			diagramEP = ((MultisimDiagramEditor) editor).getDiagramEditPart();
		}
	}

	@Override
	protected Command getCommand() {
		ObjectAdapter adapter = new ObjectAdapter(EcoreUtil.copy(component));
		final ViewDescriptor viewDescriptor = new CreateViewRequest.ViewDescriptor(
				adapter,
				Node.class, 
				null,
				((GraphicalEditPart) diagramEP).getDiagramPreferencesHint());

		// element and view command
		//FIXME: positioning doesn't work
		CompoundCommand cc = new CompoundCommand("Instantiate");
		cc.add(new ICommandProxy(new CreateInstanceCommand(adapter, diagramEP, cc.getLabel())));
		cc.add(diagramEP.getCommand(new CreateViewRequest(viewDescriptor)));
//		cc.add(new ICommandProxy(new SetBoundsCommand(diagramEP.getEditingDomain(), "Position", viewDescriptor, new Point(10,10))));
		return cc;
	}
	
	/**
	 * Creates existing element's copy.
	 * 
	 * @author vitaly
	 *
	 */
	public class CreateInstanceCommand extends AbstractTransactionalCommand {
		
		private ObjectAdapter adapter;
		private GraphicalEditPart containerEP;

		public CreateInstanceCommand(ObjectAdapter adapter, GraphicalEditPart containerEP, String label) {
			super(containerEP.getEditingDomain(), label, Collections.singletonList(WorkspaceSynchronizer.getFile(((View) containerEP.getModel()).eResource())));
			this.adapter = adapter;
			this.containerEP = containerEP;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			Component newComponent = (Component) EcoreUtil.copy((EObject) adapter.getAdapter(EObject.class));
			((ComponentDiagram) containerEP.resolveSemanticElement()).getComponents().add(newComponent);
			adapter.setObject(newComponent);
			return CommandResult.newOKCommandResult(new EObjectAdapter(newComponent));
		}

	}


}