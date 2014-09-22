/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.ui.wizards.pages;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;
import org.eventb.emf.core.machine.Machine;

import ac.soton.multisim.EventBComponent;
import ac.soton.multisim.MultisimFactory;
import ac.soton.multisim.ui.MultisimUIActivator;

/**
 * Component import wizard that allows to import and configure Event-B component.
 * 
 * @author vitaly
 *
 */
public class EventBImportWizard extends Wizard implements IImportWizard {
	
	private static final int DEFAULT_STEP = 1000;
	
	protected EventBComponentEventsPage eventsPage;
	protected EventBComponentPortsPage portsPage;

	@SuppressWarnings("unused")
	private IWorkbench workbench;
	@SuppressWarnings("unused")
	private IStructuredSelection selection;
	private EventBComponent component;
	
	public EventBImportWizard(Machine machine) {
		super();

		component = MultisimFactory.eINSTANCE.createEventBComponent();
		component.setName(machine.getName());
		component.setMachine(machine);
		component.setStepPeriod(DEFAULT_STEP);
	}

	@Override
	public boolean performFinish() {
		return true;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle("Event-B Import Wizard");
	}
	
	public void addPages() {
		eventsPage = new EventBComponentEventsPage("EventBComponentParamDefinitionPage", component);
		eventsPage.setTitle("Parameters and Events");
		eventsPage.setDescription("Specify simulation step size and I/O events");
		eventsPage.setImageDescriptor(MultisimUIActivator.getDefault().getImageRegistry().getDescriptor(MultisimUIActivator.IMAGE_MULTISIM));
		addPage(eventsPage);
		
		portsPage = new EventBComponentPortsPage("EventBComponentVariableDefinitionPage", component);
		portsPage.setTitle("Ports");
		portsPage.setDescription("Specify input and output ports for data exchange");
		portsPage.setImageDescriptor(MultisimUIActivator.getDefault().getImageRegistry().getDescriptor(MultisimUIActivator.IMAGE_MULTISIM));
		addPage(portsPage);
	}

	@Override
	public boolean canFinish() {
		return super.canFinish();
	}
	
	public EventBComponent getComponent() {
		return component;
	}
}
