/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.ui.commands;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.progress.IProgressConstants;
import org.eclipse.ui.services.ISourceProviderService;

import ac.soton.multisim.ComponentDiagram;
import ac.soton.multisim.master.Master;
import ac.soton.multisim.ui.MultisimUIActivator;

/**
 * @author vitaly
 *
 */
public class SimulateCommand extends AbstractHandler {

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart editor = HandlerUtil.getActiveEditor(event);
		
		final Map<String, String> params = new HashMap<>();
		params.put(Master.PARAM_CHECK_INVARIANTS, Boolean.valueOf(event.getParameter(Master.PARAM_CHECK_INVARIANTS)).toString());
		
		// source provider service
	    ISourceProviderService sourceProviderService = (ISourceProviderService) HandlerUtil
	        .getActiveWorkbenchWindow(event).getService(ISourceProviderService.class);
	    final SimulationState simulationStateService = (SimulationState) sourceProviderService
	        .getSourceProvider(SimulationState.SIM_ACTIVE);
	    
		if (editor != null) {
			final ComponentDiagram diagram = (ComponentDiagram) ((DiagramEditor) editor).getDiagram().getElement();
			final Job job = new Job("Multi-simulation") {
				@Override
				protected IStatus run(IProgressMonitor monitor) {
					return Master.simulate(diagram, monitor, params);
				}
				@Override
				public boolean belongsTo(Object family) {
					return "Multi-simulation".equals(getName());
				}
			};
			
			job.setUser(true);				// user UI job
			job.setPriority(Job.LONG);		// long-running job scheduling (lower priority than interactive and short, but higher than build)
			job.setProperty(IProgressConstants.KEEPONE_PROPERTY, true);		// keep only one job in progress monitor
			job.setProperty(IProgressConstants.ICON_PROPERTY, MultisimUIActivator.getDefault().getImageRegistry().getDescriptor(MultisimUIActivator.IMAGE_MULTISIM_JOB));	// job icon
			job.addJobChangeListener(new JobChangeAdapter() {
				@Override
				public void done(IJobChangeEvent event) {
					Display.getDefault().syncExec(new Runnable() {
						@Override
						public void run() {
							simulationStateService.setActive(false);
						}
					});
				}
			});
			job.setProperty(IProgressConstants.ACTION_PROPERTY, new Action() {
				Job jb = job;
				@Override
				public void run() {
					Display.getDefault().asyncExec(new Runnable() {
						@Override
						public void run() {
							MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Simulation Results", jb.getResult().getMessage());
						}
					});
				}
			});
			job.schedule();
			
		    simulationStateService.setActive(true);
		}
		return null;
	}

}
