/*
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.ui.policies;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eventb.core.basis.MachineRoot;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.persistence.EMFRodinDB;
import org.ptolemy.fmi.FMIModelDescription;
import org.ptolemy.fmi.FMIScalarVariable;
import org.ptolemy.fmi.FMIScalarVariable.Causality;
import org.ptolemy.fmi.FMUFile;

import ac.soton.multisim.Component;
import ac.soton.multisim.ComponentDiagram;
import ac.soton.multisim.FMUComponent;
import ac.soton.multisim.FMUPort;
import ac.soton.multisim.MultisimFactory;
import ac.soton.multisim.MultisimPackage;
import ac.soton.multisim.Port;
import ac.soton.multisim.VariableCausality;
import ac.soton.multisim.ui.DisplayUtil;
import ac.soton.multisim.ui.wizards.pages.EventBImportWizard;
import ac.soton.multisim.util.FMUResource;
import ac.soton.multisim.util.SimulationUtil;

/**
 * Creates component based on the provided element.
 * 
 * Customised from the generated GMF diagram.edit.commands.XXXCreateCommand
 */
public class ComponentCreateCommand extends EditElementCommand {

	private Object element;

	/**
	 * @generated
	 */
	private ComponentCreateCommand(CreateElementRequest req) {
		super(req.getLabel(), null, req);
	}

	public ComponentCreateCommand(CreateElementRequest createElementRequest, Object element) {
		this(createElementRequest);
		this.element = element;
	}

	/**
	 * FIXME: replace with setElementToEdit()
	 * @generated
	 */
	protected EObject getElementToEdit() {
		EObject container = ((CreateElementRequest) getRequest())
				.getContainer();
		if (container instanceof View) {
			container = ((View) container).getElement();
		}
		return container;
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		return true;

	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		Component newElement = createNewElement();
		if (newElement == null)
			return CommandResult.newCancelledCommandResult();

		ComponentDiagram owner = (ComponentDiagram) getElementToEdit();
		owner.getComponents().add(newElement);

		doConfigure(newElement, monitor, info);

		((CreateElementRequest) getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}

	/**
	 * @generated
	 */
	protected void doConfigure(Component newElement,
			IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {
		IElementType elementType = ((CreateElementRequest) getRequest())
				.getElementType();
		ConfigureRequest configureRequest = new ConfigureRequest(
				getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(((CreateElementRequest) getRequest())
				.getClientContext());
		configureRequest.addParameters(getRequest().getParameters());
		ICommand configureCommand = elementType
				.getEditCommand(configureRequest);
		if (configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}

	/**
	 * Creates a new component element.
	 * 
	 * @return
	 * @throws ExecutionException if existing element is not supported for creating a component from
	 */
	private Component createNewElement() throws ExecutionException {
		if (element instanceof Component)
			return EcoreUtil.copy((Component) element);
		else if (element instanceof MachineRoot)
			return getEventBComponent((MachineRoot) element);
		else if (element instanceof FMUResource)
			return getFMUComponent((FMUResource) element);
		
		//XXX shoudln't happen
		throw new ExecutionException("Undefined element");
	}

	/**
	 * Returns an FMU component from an FMU resource wrapper.
	 * 
	 * @param fmu
	 * @return
	 */
	private Component getFMUComponent(FMUResource fmu) {
		return importFMUComponent(fmu.getFile());
	}

	/**
	 * Returns an Event-B component from a machine root.
	 * 
	 * @param root
	 * @return
	 */
	private Component getEventBComponent(MachineRoot root) {
		EventBElement machine = EMFRodinDB.INSTANCE.loadEventBComponent(root);
		
		// check if already defined in the machine
		for (AbstractExtension extension : machine.getExtensions()) {
			if (MultisimPackage.EXTENSION_ID.equals(extension.getExtensionId())) {
				return (Component) EcoreUtil.copy(extension);
			}
		}
		
		return importEventBComponent((Machine) machine);
	}	
	
	/**
	 * Imports Event-B component from a Machine via configuration wizard.
	 * 
	 * @param machine
	 * @return
	 */
	private Component importEventBComponent(Machine machine) {
		Shell shell = Display.getCurrent().getActiveShell();
		EventBImportWizard wiz = new EventBImportWizard(machine);
		wiz.init(PlatformUI.getWorkbench(), null);
		WizardDialog wd = new WizardDialog(shell, wiz);
		wd.create();
		
		Rectangle bounds = DisplayUtil.inchToDisplay(shell, 5, 5);
		wd.getShell().setLocation(bounds.x, bounds.y);
		wd.getShell().setSize(bounds.width, bounds.height);
		
		if (wd.open() != Window.OK)
			return null;
		
		return wiz.getComponent();
	}
	
	/**
	 * Imports FMU component from a system File.
	 * 
	 * @param fmuFile
	 * @return
	 */
	private Component importFMUComponent(File fmuFile) {
		FMIModelDescription modelDescription;
		try {
			modelDescription = FMUFile.parseFMUFile(fmuFile.getAbsolutePath());
			if (Double.parseDouble(modelDescription.fmiVersion) != 1d)
				throw new IOException("Wrong FMI version");
		} catch (IOException e) {
			e.printStackTrace();
			Display.getCurrent().asyncExec(new Runnable() {
				@Override
				public void run() {
					MessageDialog.openError(Display.getCurrent().getActiveShell(), 
							"FMU Import Error", "FMU file cannot be parsed.\n" +
							"Check wether it is corrupt or not supported: only FMI 1.0 for Co-simulation files are supported for import.");
				}
			});
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
		variable.setComment(scalarVariable.description);
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
		variable.setComment(scalarVariable.description);
		component.getOutputs().add((Port) variable);
	}

}
