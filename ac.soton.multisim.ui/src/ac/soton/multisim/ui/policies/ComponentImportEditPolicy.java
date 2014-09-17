/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.ui.policies;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
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
import org.eventb.core.IEventBRoot;
import org.eventb.core.basis.MachineRoot;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.persistence.EMFRodinDB;
import org.ptolemy.fmi.FMIModelDescription;
import org.ptolemy.fmi.FMIScalarVariable;
import org.ptolemy.fmi.FMIScalarVariable.Causality;
import org.ptolemy.fmi.FMUFile;
import org.rodinp.core.IRodinProject;
import org.rodinp.core.RodinCore;

import ac.soton.multisim.Component;
import ac.soton.multisim.ComponentDiagram;
import ac.soton.multisim.EventBComponent;
import ac.soton.multisim.FMUComponent;
import ac.soton.multisim.FMUPort;
import ac.soton.multisim.MultisimFactory;
import ac.soton.multisim.MultisimPackage;
import ac.soton.multisim.Port;
import ac.soton.multisim.VariableCausality;
import ac.soton.multisim.diagram.part.MultisimPaletteFactory;
import ac.soton.multisim.util.custom.SimulationUtil;

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
		
		private static final String MACHINE_EXTENSION = "bum";
		private static final String FMU_EXTENSION = "fmu";
		private static final int DEFAULT_STEP = 1000;
		
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
			
			// resolve workspace files
			if (importedObject instanceof IFile) {
				IFile file = (IFile) importedObject;
				if (MACHINE_EXTENSION.equals(file.getFileExtension())) {
					IRodinProject project = RodinCore.getRodinDB().getRodinProject(file.getProject().getName());
					importedObject = project.getRodinFile(file.getName()).getRoot();
				} else if (FMU_EXTENSION.equals(file.getFileExtension())) {
					importedObject = new File(file.getLocation().toOSString());
				}
			}
			
			// get component from input
			if (importedObject instanceof File) {
				component = createFMUComponent((File) importedObject);
			} else if (importedObject instanceof Component) {
				component = (Component) EcoreUtil.copy((Component) importedObject);
			} else if (importedObject instanceof MachineRoot) {
				IEventBRoot root = (IEventBRoot) importedObject;
				EventBElement machine = EMFRodinDB.INSTANCE.loadEventBComponent(root);
				for (AbstractExtension extension : machine.getExtensions()) {
					if (MultisimPackage.EXTENSION_ID.equals(extension.getExtensionId())) {
						component = (Component) EcoreUtil.copy(extension);
					}
				}
				if (component == null) {
					component = createEventBComponent((Machine) machine);
				}
			} 
			
			if (component == null)
				return CommandResult.newErrorCommandResult("Component import error: Invalid input");
			
			((ComponentDiagram) containerEP.resolveSemanticElement()).getComponents().add(component);
			adapter.setObject(component);

			// add to import palette group
			MultisimPaletteFactory paletteFactory = new MultisimPaletteFactory();
			EditDomain ed = containerEP.getViewer().getEditDomain();
			paletteFactory.addToPalette(ed.getPaletteViewer().getPaletteRoot(), component);
			return CommandResult.newOKCommandResult(new EObjectAdapter(component));
		}
		
		private Component createEventBComponent(Machine machine) {
			EventBComponent component = MultisimFactory.eINSTANCE.createEventBComponent();
			component.setName(machine.getName());
			component.setMachine(machine);
			component.setStepPeriod(DEFAULT_STEP);
			return component;
		}

		/**
		 * Creates an FMU component from a system File.
		 * 
		 * @param fmuFile
		 * @return
		 */
		private Component createFMUComponent(File fmuFile) {
			FMIModelDescription modelDescription;
			try {
				modelDescription = FMUFile.parseFMUFile(fmuFile.getAbsolutePath());
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
			
			FMUComponent component = MultisimFactory.eINSTANCE.createFMUComponent();
			component.setName(modelDescription.modelName);
			component.setPath(fmuFile.getAbsolutePath());

			for (FMIScalarVariable scalarVariable : modelDescription.modelVariables) {
				if (scalarVariable.causality == Causality.input) {
					createFMUInput(scalarVariable, component);
				} else if (scalarVariable.causality == Causality.output) {
					createFMUOutput(scalarVariable, component);
				}
			}
			
			return component;
		}

		/**
		 * Creates and appends to component an FMU input port.
		 * 
		 * @param scalarVariable
		 * @param component
		 */
		private void createFMUInput(FMIScalarVariable scalarVariable,
				FMUComponent component) {
			FMUPort variable = MultisimFactory.eINSTANCE.createFMUPort();
			variable.setName(scalarVariable.name);
			variable.setType(SimulationUtil.fmiGetType(scalarVariable));
			variable.setCausality(VariableCausality.INPUT);
			variable.setDescription(scalarVariable.description);
			component.getInputs().add((Port) variable);
		}

		/**
		 * Creates and appends to component an FMU output port.
		 * 
		 * @param scalarVariable
		 * @param component
		 */
		private void createFMUOutput(FMIScalarVariable scalarVariable,
				FMUComponent component) {
			FMUPort variable = MultisimFactory.eINSTANCE.createFMUPort();
			variable.setName(scalarVariable.name);
			variable.setType(SimulationUtil.fmiGetType(scalarVariable));
			variable.setCausality(VariableCausality.OUTPUT);
			variable.setDescription(scalarVariable.description);
			component.getOutputs().add((Port) variable);
		}
	}
}