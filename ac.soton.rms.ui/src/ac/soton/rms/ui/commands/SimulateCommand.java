/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.rms.ui.commands;

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

import ac.soton.rms.components.ComponentDiagram;
import ac.soton.rms.master.Master;
import ac.soton.rms.ui.RmsUIActivator;

/**
 * @author vitaly
 *
 */
public class SimulateCommand extends AbstractHandler {

	/**
	 * 
	 */
	private static final String PARAM_RECORD_TRACE = "ac.soton.rms.ui.parameters.recordTrace";
	private static final String PARAM_COMPARE_TRACE = "ac.soton.rms.ui.parameters.compareTrace";
	private static final String PARAM_CHECK_INVARIANTS = "ac.soton.rms.ui.parameters.checkInvariants";

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart editor = HandlerUtil.getActiveEditor(event);
		final boolean recordTrace = Boolean.valueOf(event.getParameter(PARAM_RECORD_TRACE));
		final boolean compareTrace = Boolean.valueOf(event.getParameter(PARAM_COMPARE_TRACE));
		final boolean checkInvariants = Boolean.valueOf(event.getParameter(PARAM_CHECK_INVARIANTS));
		
		// source provider service
	    ISourceProviderService sourceProviderService = (ISourceProviderService) HandlerUtil
	        .getActiveWorkbenchWindow(event).getService(ISourceProviderService.class);
	    final SimulationState simulationStateService = (SimulationState) sourceProviderService
	        .getSourceProvider(SimulationState.SIM_ACTIVE);
	    
		if (editor != null) {
			final ComponentDiagram diagram = (ComponentDiagram) ((DiagramEditor) editor).getDiagram().getElement();
			Job job = new Job("RMS Simulation") {
				@Override
				protected IStatus run(IProgressMonitor monitor) {
					return Master.simulate(diagram, monitor, recordTrace, compareTrace, checkInvariants);
				}
			};
			job.setUser(true);
			job.setPriority(Job.LONG);
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
				@Override
				public void run() {
					Display.getDefault().asyncExec(new Runnable() {
						@Override
						public void run() {
							MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Simulation Results", Master.getResultsMessage());
						}
					});
				}
			});
			job.setProperty(IProgressConstants.KEEPONE_PROPERTY, true);
			job.setProperty(IProgressConstants.ICON_PROPERTY, RmsUIActivator.getDefault().getImageRegistry().getDescriptor(RmsUIActivator.IMAGE_RMS));
			job.schedule();
			
		    simulationStateService.setActive(true);
		}
		return null;
	}

}
