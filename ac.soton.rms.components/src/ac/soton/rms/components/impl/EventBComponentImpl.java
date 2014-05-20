/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package ac.soton.rms.components.impl;

import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;
import ac.soton.eventb.emf.core.extension.coreextension.EventBLabeled;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eventb.core.IEventBRoot;
import org.eventb.emf.core.impl.AbstractExtensionImpl;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;
import ac.soton.rms.components.AbstractVariable;
import ac.soton.rms.components.Component;
import ac.soton.rms.components.ComponentsPackage;
import ac.soton.rms.components.EventBComponent;
import ac.soton.rms.components.EventBPort;
import ac.soton.rms.components.Port;
import ac.soton.rms.components.util.custom.SimStatus;
import ac.soton.rms.components.util.custom.SimulationUtil;
import de.be4.classicalb.core.parser.exceptions.BException;
import de.prob.core.Animator;
import de.prob.core.command.CheckInitialisationStatusCommand;
import de.prob.core.command.CheckInvariantStatusCommand;
import de.prob.core.command.ClearMachineCommand;
import de.prob.core.command.ExecuteOperationCommand;
import de.prob.core.command.ExecuteRandomStepsCommand;
import de.prob.core.command.GetOperationByPredicateCommand;
import de.prob.core.command.LoadEventBModelCommand;
import de.prob.core.domainobjects.Operation;
import de.prob.core.domainobjects.Variable;
import de.prob.exceptions.ProBException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event BComponent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.rms.components.impl.EventBComponentImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link ac.soton.rms.components.impl.EventBComponentImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link ac.soton.rms.components.impl.EventBComponentImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link ac.soton.rms.components.impl.EventBComponentImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link ac.soton.rms.components.impl.EventBComponentImpl#getMachine <em>Machine</em>}</li>
 *   <li>{@link ac.soton.rms.components.impl.EventBComponentImpl#isComposed <em>Composed</em>}</li>
 *   <li>{@link ac.soton.rms.components.impl.EventBComponentImpl#getTraceFilePath <em>Trace File Path</em>}</li>
 *   <li>{@link ac.soton.rms.components.impl.EventBComponentImpl#getReadInputEvents <em>Read Input Events</em>}</li>
 *   <li>{@link ac.soton.rms.components.impl.EventBComponentImpl#getWaitEvents <em>Wait Events</em>}</li>
 *   <li>{@link ac.soton.rms.components.impl.EventBComponentImpl#getStepPeriod <em>Step Period</em>}</li>
 *   <li>{@link ac.soton.rms.components.impl.EventBComponentImpl#isCheckInvariants <em>Check Invariants</em>}</li>
 *   <li>{@link ac.soton.rms.components.impl.EventBComponentImpl#isCompareTrace <em>Compare Trace</em>}</li>
 *   <li>{@link ac.soton.rms.components.impl.EventBComponentImpl#isRecordTrace <em>Record Trace</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventBComponentImpl extends AbstractExtensionImpl implements EventBComponent {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2014 University of Southampton.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html";

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> inputs;

	/**
	 * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputs()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> outputs;

	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractVariable> variables;

	/**
	 * The cached value of the '{@link #getMachine() <em>Machine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMachine()
	 * @generated
	 * @ordered
	 */
	protected Machine machine;

	/**
	 * The default value of the '{@link #isComposed() <em>Composed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComposed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COMPOSED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isComposed() <em>Composed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComposed()
	 * @generated
	 * @ordered
	 */
	protected boolean composed = COMPOSED_EDEFAULT;

	/**
	 * The default value of the '{@link #getTraceFilePath() <em>Trace File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceFilePath()
	 * @generated
	 * @ordered
	 */
	protected static final String TRACE_FILE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTraceFilePath() <em>Trace File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceFilePath()
	 * @generated
	 * @ordered
	 */
	protected String traceFilePath = TRACE_FILE_PATH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReadInputEvents() <em>Read Input Events</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReadInputEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<Event> readInputEvents;

	/**
	 * The cached value of the '{@link #getWaitEvents() <em>Wait Events</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWaitEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<Event> waitEvents;

	/**
	 * The default value of the '{@link #getStepPeriod() <em>Step Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepPeriod()
	 * @generated
	 * @ordered
	 */
	protected static final int STEP_PERIOD_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStepPeriod() <em>Step Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepPeriod()
	 * @generated
	 * @ordered
	 */
	protected int stepPeriod = STEP_PERIOD_EDEFAULT;

	/**
	 * The default value of the '{@link #isCheckInvariants() <em>Check Invariants</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCheckInvariants()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CHECK_INVARIANTS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCheckInvariants() <em>Check Invariants</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCheckInvariants()
	 * @generated
	 * @ordered
	 */
	protected boolean checkInvariants = CHECK_INVARIANTS_EDEFAULT;

	/**
	 * The default value of the '{@link #isCompareTrace() <em>Compare Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCompareTrace()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COMPARE_TRACE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCompareTrace() <em>Compare Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCompareTrace()
	 * @generated
	 * @ordered
	 */
	protected boolean compareTrace = COMPARE_TRACE_EDEFAULT;

	/**
	 * The default value of the '{@link #isRecordTrace() <em>Record Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRecordTrace()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RECORD_TRACE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRecordTrace() <em>Record Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRecordTrace()
	 * @generated
	 * @ordered
	 */
	protected boolean recordTrace = RECORD_TRACE_EDEFAULT;

	/**
	 * @custom
	 */
	private Random random = new Random(System.currentTimeMillis());
	private Set<String> waitSet = new HashSet<String>();
	private BufferedReader traceReader;
	private BufferedWriter traceWriter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventBComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentsPackage.Literals.EVENT_BCOMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getLabel() {
		return getMachine() == null ? "" : getMachine().getName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStepPeriod() {
		return stepPeriod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStepPeriod(int newStepPeriod) {
		int oldStepPeriod = stepPeriod;
		stepPeriod = newStepPeriod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BCOMPONENT__STEP_PERIOD, oldStepPeriod, stepPeriod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCheckInvariants() {
		return checkInvariants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCheckInvariants(boolean newCheckInvariants) {
		boolean oldCheckInvariants = checkInvariants;
		checkInvariants = newCheckInvariants;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BCOMPONENT__CHECK_INVARIANTS, oldCheckInvariants, checkInvariants));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCompareTrace() {
		return compareTrace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompareTrace(boolean newCompareTrace) {
		boolean oldCompareTrace = compareTrace;
		compareTrace = newCompareTrace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BCOMPONENT__COMPARE_TRACE, oldCompareTrace, compareTrace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRecordTrace() {
		return recordTrace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecordTrace(boolean newRecordTrace) {
		boolean oldRecordTrace = recordTrace;
		recordTrace = newRecordTrace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BCOMPONENT__RECORD_TRACE, oldRecordTrace, recordTrace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Port> getInputs() {
		if (inputs == null) {
			inputs = new EObjectContainmentEList.Resolving<Port>(Port.class, this, ComponentsPackage.EVENT_BCOMPONENT__INPUTS);
		}
		return inputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Port> getOutputs() {
		if (outputs == null) {
			outputs = new EObjectContainmentEList.Resolving<Port>(Port.class, this, ComponentsPackage.EVENT_BCOMPONENT__OUTPUTS);
		}
		return outputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractVariable> getVariables() {
		if (variables == null) {
			variables = new EObjectContainmentEList.Resolving<AbstractVariable>(AbstractVariable.class, this, ComponentsPackage.EVENT_BCOMPONENT__VARIABLES);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Machine getMachine() {
		if (machine != null && machine.eIsProxy()) {
			InternalEObject oldMachine = (InternalEObject)machine;
			machine = (Machine)eResolveProxy(oldMachine);
			if (machine != oldMachine) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ComponentsPackage.EVENT_BCOMPONENT__MACHINE, oldMachine, machine));
			}
		}
		return machine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Machine basicGetMachine() {
		return machine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMachine(Machine newMachine) {
		Machine oldMachine = machine;
		machine = newMachine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BCOMPONENT__MACHINE, oldMachine, machine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isComposed() {
		return composed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComposed(boolean newComposed) {
		boolean oldComposed = composed;
		composed = newComposed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BCOMPONENT__COMPOSED, oldComposed, composed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTraceFilePath() {
		return traceFilePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTraceFilePath(String newTraceFilePath) {
		String oldTraceFilePath = traceFilePath;
		traceFilePath = newTraceFilePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BCOMPONENT__TRACE_FILE_PATH, oldTraceFilePath, traceFilePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Event> getReadInputEvents() {
		if (readInputEvents == null) {
			readInputEvents = new EObjectResolvingEList<Event>(Event.class, this, ComponentsPackage.EVENT_BCOMPONENT__READ_INPUT_EVENTS);
		}
		return readInputEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Event> getWaitEvents() {
		if (waitEvents == null) {
			waitEvents = new EObjectResolvingEList<Event>(Event.class, this, ComponentsPackage.EVENT_BCOMPONENT__WAIT_EVENTS);
		}
		return waitEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IStatus instantiate() {
		assert getMachine() != null;
		
		// load machine animation
		IEventBRoot root = SimulationUtil.getMachineRoot(getMachine());
		Animator animator = Animator.getAnimator();
		if (animator.isMachineLoaded()) {
			try {
				ClearMachineCommand.clearMachine(animator);
			} catch (ProBException e) {
				return SimStatus.PROB_ERROR;
			}
		}
		try {
			LoadEventBModelCommand.load(animator, root);
		} catch (ProBException e) {
			return SimStatus.LOAD_ERROR;
		}
		
		// prepare trace comparison
		if (compareTrace) {
			try {
				if (traceReader != null)
					traceReader.close();
				
				// check trace file exists or created successfully
				File file = new File(getTraceFilePath());
				if (!file.exists() && !file.createNewFile())
					return SimStatus.TRACE_ERROR;
				
				traceReader = new BufferedReader(new FileReader(getTraceFilePath()));
			} catch (IOException e) {
				return SimStatus.TRACE_ERROR;
			}
		}
		
		// prepare trace recording
		if (recordTrace) {
			try {
				if (traceWriter != null)
					traceWriter.close();
				traceWriter = new BufferedWriter(new FileWriter(getTraceFilePath()));
			} catch (IOException e) {
				return SimStatus.TRACE_ERROR;
			}
		}
		
		// recall events for doStep matching
		if (!waitSet.isEmpty())
			waitSet.clear();
		for (Event we : getWaitEvents())
			waitSet.add(we.getName());

		// disable notification for modifying output ports
		// so that using EMF transactions is not required
		// while setting port value
		for (Port p : getOutputs())
			p.eSetDeliver(false);
		
		return SimStatus.OK_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IStatus initialise(double tStart, double tStop) {
		Animator animator = Animator.getAnimator();
		
		try {
			ExecuteRandomStepsCommand.executeOperation(animator, 1);
			if (!CheckInitialisationStatusCommand.isInitialized(animator, animator.getCurrentState().getId()))
				ExecuteRandomStepsCommand.executeOperation(animator, 1);
			if (!CheckInitialisationStatusCommand.isInitialized(animator, animator.getCurrentState().getId()))
				return SimStatus.EVENTB_ERROR;
		} catch (ProBException e) {
			return SimStatus.PROB_ERROR;
		}
		
		return SimStatus.OK_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IStatus readInputs() {
		EList<Event> readEvents = getReadInputEvents();
		
		// skip if no inputs
		if (readEvents.isEmpty())
			return SimStatus.OK_STATUS;
		
		// build parameter predicate for event execution
		StringBuilder predicate = new StringBuilder("TRUE=TRUE");
		for (Port p : getInputs()) {
			// if port not connected, let ProB to pick the value non-deterministically
			//XXX: should it pass some default value?
			if (p.getIn() == null)
				continue;
			
			// add parameter to event predicate string
			assert p instanceof EventBPort && ((EventBPort) p).getParameter() != null;
			predicate.append("&" + ((EventBPort) p).getParameter().getName() + "=" + SimulationUtil.getEventBValue(p.getIn().getValue(), p.getType(), ((EventBPort) p).getIntToReal()));
		}
		
		Animator animator = Animator.getAnimator();
		
		// find enabled read event
		Operation readOp = null;
		String predicateStr = predicate.toString();
		for (Event re : readEvents) {
			try {
				readOp = GetOperationByPredicateCommand.getOperation(animator, animator.getCurrentState().getId(), re.getName(), predicateStr);
			} catch (ProBException e) {
				return SimStatus.PROB_ERROR;
			} catch (BException e) {
				return SimStatus.EVENTB_ERROR;
			}
			if (readOp != null)
				break;
		}
		
		// stop if no reads are enabled
		if (readOp == null)
			return SimStatus.EVENTB_NO_READS;
		
		// execute read event
		try {
			ExecuteOperationCommand.executeOperation(animator, readOp);
		} catch (ProBException e) {
			return SimStatus.PROB_ERROR;
		}
		
		return SimStatus.OK_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IStatus writeOutputs() {
		Map<String, Variable> values = Animator.getAnimator().getCurrentState().getValues();
		for (Port p : getOutputs()) {
			// skip unconnected output
			if (p.getOut().isEmpty())
				continue;

			p.setValue(SimulationUtil.getFMIValue(
					values.get(p.getLabel()).getValue(), 
					p.getType(), 
					((EventBPort) p).getIntToReal()));
		}
		
		return SimStatus.OK_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IStatus doStep(double time, double step) {
		Animator animator = Animator.getAnimator();
		List<Operation> ops = null;
		Operation nextOp = null;
		IStatus status = SimStatus.OK_STATUS;
		IStatus error = null;
		while (true) {
			ops = animator.getCurrentState().getEnabledOperations();
			
			// check deadlock
			if (ops == null || ops.isEmpty())
				return SimStatus.EVENTB_DEADLOCK;
			
			nextOp = ops.get(random.nextInt(ops.size()));
			try {
				// execute
				ExecuteOperationCommand.executeOperation(animator, nextOp);
				
				// check invariants if on
				if (checkInvariants && CheckInvariantStatusCommand.isInvariantViolated(animator, animator.getCurrentState().getId())) {
					return SimStatus.EVENTB_INV_VIOLATED;
				}
				
				// check trace if on
				if (compareTrace && !nextOp.getName().equals(findRecordedOp(time))) {
					return SimStatus.EVENTB_TRACE_DIV;
					//FIXME: pass the error status from findRecordedOp()
				}
				
				// record trace if on
				if (recordTrace) {
					error = recordOp(time, nextOp.getName());
					if (error != SimStatus.OK_STATUS)
						return error;
				}
			} catch (ProBException e) {
				return SimStatus.EVENTB_ERROR;
			}
			if (waitSet.contains(nextOp.getName()))
				break;
		}

		return status;
	}

	/**
	 * @param time
	 * @param name
	 * @return 
	 * @custom
	 */
	private IStatus recordOp(double time, String name) {
		try {
			traceWriter.write("" + time + "," + name);
			traceWriter.newLine();
		} catch (IOException e) {
			return SimStatus.TRACE_ERROR;
		}
		return SimStatus.OK_STATUS;
	}

	/**
	 * @param time
	 * @return
	 * @custom
	 */
	private Object findRecordedOp(double time) {
		try {
			String line = null;
			double traceTime = -1;
			while (traceTime < time) {
				if ((line = traceReader.readLine()) == null)
					return null;
				traceTime = Double.valueOf(line.split(",")[0]);
			}
			if (traceTime == time)
				return line.split(",")[1];
		} catch (IOException e) {
			return SimStatus.TRACE_ERROR;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IStatus terminate() {
		// re-enable notifications
		for (Port p : getOutputs())
			p.eSetDeliver(true);
		
		if (traceReader != null)
			try {
				traceReader.close();
			} catch (IOException e) {
				return SimStatus.TRACE_ERROR;
			}
		//XXX cannot have both trace reader and writer, i.e. either records or replays a trace
		if (traceWriter != null) {
			try {
				traceWriter.close();
			} catch (IOException e) {
				return SimStatus.TRACE_ERROR;
			}
		}
		
		return SimStatus.OK_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComponentsPackage.EVENT_BCOMPONENT__INPUTS:
				return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
			case ComponentsPackage.EVENT_BCOMPONENT__OUTPUTS:
				return ((InternalEList<?>)getOutputs()).basicRemove(otherEnd, msgs);
			case ComponentsPackage.EVENT_BCOMPONENT__VARIABLES:
				return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentsPackage.EVENT_BCOMPONENT__LABEL:
				return getLabel();
			case ComponentsPackage.EVENT_BCOMPONENT__INPUTS:
				return getInputs();
			case ComponentsPackage.EVENT_BCOMPONENT__OUTPUTS:
				return getOutputs();
			case ComponentsPackage.EVENT_BCOMPONENT__VARIABLES:
				return getVariables();
			case ComponentsPackage.EVENT_BCOMPONENT__MACHINE:
				if (resolve) return getMachine();
				return basicGetMachine();
			case ComponentsPackage.EVENT_BCOMPONENT__COMPOSED:
				return isComposed();
			case ComponentsPackage.EVENT_BCOMPONENT__TRACE_FILE_PATH:
				return getTraceFilePath();
			case ComponentsPackage.EVENT_BCOMPONENT__READ_INPUT_EVENTS:
				return getReadInputEvents();
			case ComponentsPackage.EVENT_BCOMPONENT__WAIT_EVENTS:
				return getWaitEvents();
			case ComponentsPackage.EVENT_BCOMPONENT__STEP_PERIOD:
				return getStepPeriod();
			case ComponentsPackage.EVENT_BCOMPONENT__CHECK_INVARIANTS:
				return isCheckInvariants();
			case ComponentsPackage.EVENT_BCOMPONENT__COMPARE_TRACE:
				return isCompareTrace();
			case ComponentsPackage.EVENT_BCOMPONENT__RECORD_TRACE:
				return isRecordTrace();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ComponentsPackage.EVENT_BCOMPONENT__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends Port>)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends Port>)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends AbstractVariable>)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__MACHINE:
				setMachine((Machine)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__COMPOSED:
				setComposed((Boolean)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__TRACE_FILE_PATH:
				setTraceFilePath((String)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__READ_INPUT_EVENTS:
				getReadInputEvents().clear();
				getReadInputEvents().addAll((Collection<? extends Event>)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__WAIT_EVENTS:
				getWaitEvents().clear();
				getWaitEvents().addAll((Collection<? extends Event>)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__STEP_PERIOD:
				setStepPeriod((Integer)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__CHECK_INVARIANTS:
				setCheckInvariants((Boolean)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__COMPARE_TRACE:
				setCompareTrace((Boolean)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__RECORD_TRACE:
				setRecordTrace((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ComponentsPackage.EVENT_BCOMPONENT__INPUTS:
				getInputs().clear();
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__OUTPUTS:
				getOutputs().clear();
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__VARIABLES:
				getVariables().clear();
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__MACHINE:
				setMachine((Machine)null);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__COMPOSED:
				setComposed(COMPOSED_EDEFAULT);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__TRACE_FILE_PATH:
				setTraceFilePath(TRACE_FILE_PATH_EDEFAULT);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__READ_INPUT_EVENTS:
				getReadInputEvents().clear();
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__WAIT_EVENTS:
				getWaitEvents().clear();
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__STEP_PERIOD:
				setStepPeriod(STEP_PERIOD_EDEFAULT);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__CHECK_INVARIANTS:
				setCheckInvariants(CHECK_INVARIANTS_EDEFAULT);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__COMPARE_TRACE:
				setCompareTrace(COMPARE_TRACE_EDEFAULT);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__RECORD_TRACE:
				setRecordTrace(RECORD_TRACE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ComponentsPackage.EVENT_BCOMPONENT__LABEL:
				return LABEL_EDEFAULT == null ? getLabel() != null : !LABEL_EDEFAULT.equals(getLabel());
			case ComponentsPackage.EVENT_BCOMPONENT__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case ComponentsPackage.EVENT_BCOMPONENT__OUTPUTS:
				return outputs != null && !outputs.isEmpty();
			case ComponentsPackage.EVENT_BCOMPONENT__VARIABLES:
				return variables != null && !variables.isEmpty();
			case ComponentsPackage.EVENT_BCOMPONENT__MACHINE:
				return machine != null;
			case ComponentsPackage.EVENT_BCOMPONENT__COMPOSED:
				return composed != COMPOSED_EDEFAULT;
			case ComponentsPackage.EVENT_BCOMPONENT__TRACE_FILE_PATH:
				return TRACE_FILE_PATH_EDEFAULT == null ? traceFilePath != null : !TRACE_FILE_PATH_EDEFAULT.equals(traceFilePath);
			case ComponentsPackage.EVENT_BCOMPONENT__READ_INPUT_EVENTS:
				return readInputEvents != null && !readInputEvents.isEmpty();
			case ComponentsPackage.EVENT_BCOMPONENT__WAIT_EVENTS:
				return waitEvents != null && !waitEvents.isEmpty();
			case ComponentsPackage.EVENT_BCOMPONENT__STEP_PERIOD:
				return stepPeriod != STEP_PERIOD_EDEFAULT;
			case ComponentsPackage.EVENT_BCOMPONENT__CHECK_INVARIANTS:
				return checkInvariants != CHECK_INVARIANTS_EDEFAULT;
			case ComponentsPackage.EVENT_BCOMPONENT__COMPARE_TRACE:
				return compareTrace != COMPARE_TRACE_EDEFAULT;
			case ComponentsPackage.EVENT_BCOMPONENT__RECORD_TRACE:
				return recordTrace != RECORD_TRACE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == EventBLabeled.class) {
			switch (derivedFeatureID) {
				case ComponentsPackage.EVENT_BCOMPONENT__LABEL: return CoreextensionPackage.EVENT_BLABELED__LABEL;
				default: return -1;
			}
		}
		if (baseClass == Component.class) {
			switch (derivedFeatureID) {
				case ComponentsPackage.EVENT_BCOMPONENT__INPUTS: return ComponentsPackage.COMPONENT__INPUTS;
				case ComponentsPackage.EVENT_BCOMPONENT__OUTPUTS: return ComponentsPackage.COMPONENT__OUTPUTS;
				case ComponentsPackage.EVENT_BCOMPONENT__VARIABLES: return ComponentsPackage.COMPONENT__VARIABLES;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == EventBLabeled.class) {
			switch (baseFeatureID) {
				case CoreextensionPackage.EVENT_BLABELED__LABEL: return ComponentsPackage.EVENT_BCOMPONENT__LABEL;
				default: return -1;
			}
		}
		if (baseClass == Component.class) {
			switch (baseFeatureID) {
				case ComponentsPackage.COMPONENT__INPUTS: return ComponentsPackage.EVENT_BCOMPONENT__INPUTS;
				case ComponentsPackage.COMPONENT__OUTPUTS: return ComponentsPackage.EVENT_BCOMPONENT__OUTPUTS;
				case ComponentsPackage.COMPONENT__VARIABLES: return ComponentsPackage.EVENT_BCOMPONENT__VARIABLES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (composed: ");
		result.append(composed);
		result.append(", traceFilePath: ");
		result.append(traceFilePath);
		result.append(", stepPeriod: ");
		result.append(stepPeriod);
		result.append(", checkInvariants: ");
		result.append(checkInvariants);
		result.append(", compareTrace: ");
		result.append(compareTrace);
		result.append(", recordTrace: ");
		result.append(recordTrace);
		result.append(')');
		return result.toString();
	}

	@Override
	public String getExtensionId() {
		return ComponentsPackage.COMPONENTS_EXTENSION_ID;
	}

} //EventBComponentImpl
