/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.ui.dialogs;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import ac.soton.multisim.ComponentDiagram;
import ac.soton.multisim.MultisimPackage;

/**
 * Simulation parameters input dialog.
 * Requires to input simulation time and step size.
 * 
 * @author vitaly
 *
 */
public class SimulationSettingsDialog extends Dialog {

	// default values
	private static final int START_DEFAULT = 0;
	private static final int STOP_DEFAULT = 1000;
	private static final int STEP_DEFAULT = 100;
	private static final String ARGUMENTS_DEFAULT = "CLPFD=FALSE,MEMO=TRUE,MAX_OPERATIONS=1";
	private static final String ARGS_TOOLTIP = "Comma-separated <argument>=<value>\nExamples:\n"+
				"IGNORE_HASH_COLLISIONS=TRUE\n"+
				"FORGET_STATE_SPACE=TRUE\nMEMO=TRUE\n"+	// storing statespace -  gains a bit of performance (but it could increase the memory footprint)
				"TIME_OUT=4000\n"+
				"COMPRESSION=TRUE\n" +
				"CLPFD=FALSE\n" +
				"MAX_OPERATIONS=1\n" +
				"NUMBER_OF_ANIMATED_ABSTRACTIONS=1"; // only interested in seeing the variables at the lowest level of abstraction.
	
	// controls
	private Text startTimeText;
	private Text stopTimeText;
	private Text stepSizeText;
	private Text argsText;
	private Button recordOutputs;
	private ControlDecoration timeErrorDecorator;
	private ControlDecoration stepTimeErrorDecorator;
	
	// validators
	private DecoratedInputValidator startTimeValidator;
	private DecoratedInputValidator stopTimeValidator;
	private DecoratedInputValidator stepSizeValidator;
	private boolean startTimeValid;
	private boolean stopTimeValid;
	private boolean stepSizeValid;
	private boolean totalTimeValid;
	private boolean stepTotalValid;
	
	// data
	private int startTime;
	private int stopTime;
	private int stepSize;
	private String args;
	private boolean record;
	
	private ComponentDiagram diagram;

	/**
	 * Simulation start dialog.
	 * 
	 * @param parentShell shell
	 * @param time default simulation time
	 * @param step default step size
	 */
	public SimulationSettingsDialog(Shell parentShell, ComponentDiagram diagram) {
		super(parentShell);
		this.diagram = diagram;
		
		startTime = diagram.getStartTime() > 0 ? diagram.getStartTime() : START_DEFAULT;
		stopTime = diagram.getStopTime() > 0 ? diagram.getStopTime() : STOP_DEFAULT;
		stepSize = diagram.getStepSize() > 0 ? diagram.getStepSize() : STEP_DEFAULT;
		args = diagram.getArguments() != null ? diagram.getArguments() : ARGUMENTS_DEFAULT;
		record = diagram.isRecordTrace();
		
		startTimeValid = true;
		stopTimeValid = true;
		stepSizeValid = true;
		totalTimeValid = true;
		stepTotalValid = true;
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Simulation Settings");
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		FormLayout layout = new FormLayout();
		layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		// start time
		Label label = new Label(composite, SWT.NONE);
		label.setText("Start time:");
		startTimeText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		startTimeText.setLayoutData(getAttachedData(label, true));
		startTimeText.setText(Integer.toString(startTime));
		startTimeText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				validateStartTime();
			}
		});
		
		// stop time
		label = new Label(composite, SWT.NONE);
		label.setText("Stop time:");
		label.setLayoutData(getAttachedData(startTimeText, false));
		stopTimeText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		stopTimeText.setLayoutData(getAttachedData(label, true));
		stopTimeText.setText(Integer.toString(stopTime));
		stopTimeText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				validateStopTime();
			}
		});
		
		// step size
		label = new Label(composite, SWT.NONE);
		label.setText("Step size:");
		label.setLayoutData(getAttachedData(stopTimeText, false));
		stepSizeText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		stepSizeText.setLayoutData(getAttachedData(label, true));
		stepSizeText.setText(Integer.toString(stepSize));
		stepSizeText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				validateStepSize();
			}
		});
		
		// ProB arguments
		label = new Label(composite, SWT.NONE);
		label.setText("ProB arguments:");
		label.setLayoutData(getAttachedData(stepSizeText, false));
		FormData layoutData = getAttachedData(label, true);
		argsText = new Text(composite, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL | SWT.WRAP);
		GC gc = new GC(argsText);
		layoutData.height = gc.getFontMetrics().getHeight() * 3;
		gc.dispose();
		argsText.setLayoutData(layoutData);
		argsText.setToolTipText(ARGS_TOOLTIP);
		argsText.setText(args);

		// record checkbox
		recordOutputs = new Button(composite, SWT.CHECK);
		recordOutputs.setLayoutData(getAttachedData(argsText, false));
		recordOutputs.setText("Record Event-B traces");
		
		// validators
		addValidators();
		validateTime();
		
		return composite;
	}

	/**
	 * Creates form data attached to provided control.
	 * 
	 * @param control attached control
	 * @param stretch stretch horizontally
	 * @return
	 */
	private FormData getAttachedData(Control control, boolean stretch) {
		FormData layoutData = new FormData();
		layoutData.top = new FormAttachment(control, IDialogConstants.VERTICAL_SPACING);
		layoutData.left = new FormAttachment(0);
		if (stretch)
			layoutData.right = new FormAttachment(100);
		return layoutData;
	}

	/**
	 * Adds input field validators.
	 */
	private void addValidators() {
		startTimeValidator = createTextValidator(startTimeText);
		stopTimeValidator = createTextValidator2(stopTimeText);
		stepSizeValidator = createTextValidator2(stepSizeText);
		
		timeErrorDecorator = DecoratedInputValidator.createDecorator(stopTimeText,
				"Stop time should be after start time",
				FieldDecorationRegistry.DEC_ERROR, false);
		
		stepTimeErrorDecorator = DecoratedInputValidator.createDecorator(stepSizeText,
				"Step size cannot exceed simulation time",
				FieldDecorationRegistry.DEC_ERROR, false);
	}
	
	/**
	 * Validates if text is an integer > 0.
	 * @return
	 */
	private DecoratedInputValidator createTextValidator(Text text) {
		return new DecoratedInputValidator(
				DecoratedInputValidator.createDecorator(text,
						"Please enter time in ms",
						FieldDecorationRegistry.DEC_ERROR, false)) {
			@Override
			public String isValidInput(String timeString) {
				try {
					int input = Integer.parseInt(timeString.trim());
					if (input < 0)
						return "Time must be positive";
				} catch (NumberFormatException e) {
					return "Invalid number format";
				}
				return null;
			}
		};
	}

	/**
	 * Validates if text is an integer >= 0;
	 * @return
	 */
	private DecoratedInputValidator createTextValidator2(Text text) {
		return new DecoratedInputValidator(
				DecoratedInputValidator.createDecorator(text,
						"Please enter time in ms",
						FieldDecorationRegistry.DEC_ERROR, false)) {
			@Override
			public String isValidInput(String timeString) {
				try {
					int input = Integer.parseInt(timeString.trim());
					if (input <= 0)
						return "Time must be greater that zero";
				} catch (NumberFormatException e) {
					return "Invalid number format";
				}
				return null;
			}
		};
	}

	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		// only here the buttons are available, so that's where OK can be disabled for initial state
		update();
		return contents;
	}
	
	@Override
	protected void buttonPressed(int buttonId) {
		if (buttonId == OK) {
			startTime = Integer.parseInt(startTimeText.getText().trim());
			stopTime = Integer.parseInt(stopTimeText.getText().trim());
			stepSize = Integer.parseInt(stepSizeText.getText().trim());
			args = argsText.getText().trim();
			record = recordOutputs.getSelection();
			saveToModel();
		}
		super.buttonPressed(buttonId);
	}

	private void saveToModel() {
		EditingDomain editingDomain = TransactionUtil.getEditingDomain(diagram);
		CompoundCommand cc = new CompoundCommand();
		cc.append(SetCommand.create(editingDomain, diagram, MultisimPackage.eINSTANCE.getComponentDiagram_StartTime(), startTime));
		cc.append(SetCommand.create(editingDomain, diagram, MultisimPackage.eINSTANCE.getComponentDiagram_StopTime(), stopTime));
		cc.append(SetCommand.create(editingDomain, diagram, MultisimPackage.eINSTANCE.getComponentDiagram_StepSize(), stepSize));
		cc.append(SetCommand.create(editingDomain, diagram, MultisimPackage.eINSTANCE.getComponentDiagram_Arguments(), args));
		cc.append(SetCommand.create(editingDomain, diagram, MultisimPackage.eINSTANCE.getComponentDiagram_RecordTrace(), record));
		editingDomain.getCommandStack().execute(cc);
	}

	/**
	 * Validates start time.
	 */
	protected void validateStartTime() {
		if (startTimeValidator != null) {
			startTimeValid = startTimeValidator.isValid(startTimeText.getText()) == null;
		}
		validateTime();
	}

	/**
	 * Validates stop time.
	 */
	protected void validateStopTime() {
		if (stopTimeValidator != null) {
			stopTimeValid = stopTimeValidator.isValid(stopTimeText.getText()) == null;
		}
		validateTime();
	}

	/**
	 * Validates step size.
	 */
	protected void validateStepSize() {
		if (stepSizeValidator != null) {
			stepSizeValid = stepSizeValidator.isValid(stepSizeText.getText()) == null;
		}
		validateTime();
	}
	
	/**
	 * Validates start time against stop time
	 * and step size against total simulation time.
	 */
	private void validateTime() {
		if (timeErrorDecorator == null || stepTimeErrorDecorator == null)
			return;
		
		if (startTimeValid && stopTimeValid && stepSizeValid) {
			long startTime = Long.parseLong(startTimeText.getText());
			long stopTime = Long.parseLong(stopTimeText.getText());
			long stepSize = Long.parseLong(stepSizeText.getText());
			
			totalTimeValid = stopTime > startTime;
			if (totalTimeValid) {
				timeErrorDecorator.hide();
			} else {
				timeErrorDecorator.show();
			}
			
			stepTotalValid = stepSize <= (stopTime - startTime);
			if (stepTotalValid) {
				stepTimeErrorDecorator.hide();
			} else {
				stepTimeErrorDecorator.show();
			}
		}
		update();
	}
	
	/**
	 * Updates the buttons based on validation results.
	 */
	private void update() {
		Control button = getButton(IDialogConstants.OK_ID);
		if (button != null) {
			button.setEnabled(startTimeValid && stopTimeValid && stepSizeValid && totalTimeValid && stepTotalValid);
		}
	}

}
