/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package ac.soton.multisim.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eventb.core.IEventBRoot;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.impl.AbstractExtensionImpl;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;

import ac.soton.multisim.Component;
import ac.soton.multisim.ComponentDiagram;
import ac.soton.multisim.EventBComponent;
import ac.soton.multisim.EventBPort;
import ac.soton.multisim.MultisimPackage;
import ac.soton.multisim.Port;
import ac.soton.multisim.exception.ModelException;
import ac.soton.multisim.exception.SimulationException;
import ac.soton.multisim.util.SimulationStatus;
import ac.soton.multisim.util.SimulationUtil;

import com.google.inject.Injector;

import de.be4.classicalb.core.parser.exceptions.BException;
import de.prob.model.eventb.EventBModel;
import de.prob.scripting.EventBFactory;
import de.prob.statespace.OpInfo;
import de.prob.statespace.StateId;
import de.prob.statespace.StateSpace;
import de.prob.statespace.Trace;
import de.prob.statespace.TraceConverter;
import de.prob.webconsole.ServletContextListener;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event BComponent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.multisim.impl.EventBComponentImpl#getName <em>Name</em>}</li>
 *   <li>{@link ac.soton.multisim.impl.EventBComponentImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link ac.soton.multisim.impl.EventBComponentImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link ac.soton.multisim.impl.EventBComponentImpl#getStepPeriod <em>Step Period</em>}</li>
 *   <li>{@link ac.soton.multisim.impl.EventBComponentImpl#getMachine <em>Machine</em>}</li>
 *   <li>{@link ac.soton.multisim.impl.EventBComponentImpl#isComposed <em>Composed</em>}</li>
 *   <li>{@link ac.soton.multisim.impl.EventBComponentImpl#getReadInputEvents <em>Read Input Events</em>}</li>
 *   <li>{@link ac.soton.multisim.impl.EventBComponentImpl#getWaitEvents <em>Wait Events</em>}</li>
 *   <li>{@link ac.soton.multisim.impl.EventBComponentImpl#getTrace <em>Trace</em>}</li>
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
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

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
	 * The default value of the '{@link #getTrace() <em>Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrace()
	 * @generated
	 * @ordered
	 */
	protected static final Trace TRACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTrace() <em>Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrace()
	 * @generated
	 * @ordered
	 */
	protected Trace trace = TRACE_EDEFAULT;

	/**
	 * @custom
	 */
	private Random random = new Random(System.currentTimeMillis());
	private Set<String> readSet = new HashSet<String>();
	private Set<String> waitSet = new HashSet<String>();
	private DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");

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
		return MultisimPackage.Literals.EVENT_BCOMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MultisimPackage.EVENT_BCOMPONENT__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MultisimPackage.EVENT_BCOMPONENT__STEP_PERIOD, oldStepPeriod, stepPeriod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trace getTrace() {
		return trace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrace(Trace newTrace) {
		Trace oldTrace = trace;
		trace = newTrace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MultisimPackage.EVENT_BCOMPONENT__TRACE, oldTrace, trace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Port> getInputs() {
		if (inputs == null) {
			inputs = new EObjectContainmentEList.Resolving<Port>(Port.class, this, MultisimPackage.EVENT_BCOMPONENT__INPUTS);
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
			outputs = new EObjectContainmentEList.Resolving<Port>(Port.class, this, MultisimPackage.EVENT_BCOMPONENT__OUTPUTS);
		}
		return outputs;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MultisimPackage.EVENT_BCOMPONENT__MACHINE, oldMachine, machine));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MultisimPackage.EVENT_BCOMPONENT__MACHINE, oldMachine, machine));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MultisimPackage.EVENT_BCOMPONENT__COMPOSED, oldComposed, composed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Event> getReadInputEvents() {
		if (readInputEvents == null) {
			readInputEvents = new EObjectResolvingEList<Event>(Event.class, this, MultisimPackage.EVENT_BCOMPONENT__READ_INPUT_EVENTS);
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
			waitEvents = new EObjectResolvingEList<Event>(Event.class, this, MultisimPackage.EVENT_BCOMPONENT__WAIT_EVENTS);
		}
		return waitEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IStatus instantiate() throws SimulationException {
		// load event-b machine
		final IEventBRoot machineRoot = SimulationUtil.getMachineRoot(getMachine());
		if (machineRoot == null) {
			throw new SimulationException("Cannot load machine component '" + getLabel()
					+ "'\nReason: Machine root cannot be determined.");
		}
		
		String fileName = machineRoot.getResource().getRawLocation().makeAbsolute().toOSString();
		if (fileName.endsWith(".buc")) {
			fileName = fileName.replace(".buc", ".bcc");
		} else {
			fileName = fileName.replace(".bum", ".bcm");
		}

		Map<String, String> params = new HashMap<String, String>();
		String args = ((ComponentDiagram) eContainer()).getArguments();
		if (args != null && !args.trim().isEmpty()) {
			String[] argArray = args.split(",");
			try {
				for (int i=0; i< argArray.length; i++) {
					String[] arg = argArray[i].split("=");
					params.put(arg[0], argArray[1]);
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				throw new SimulationException("ProB parameter format is invalid");
			}
		}

		Injector injector = ServletContextListener.INJECTOR;
		final EventBFactory instance = injector.getInstance(EventBFactory.class);
		EventBModel model = instance.load(fileName, params, false);
		if (model == null)
			throw new SimulationException("ProB could not load machine file '" + fileName + "' with parameters=" + params.toString());
		
		StateSpace s = model.getStatespace();
		s.startTransaction();	// presumably putting everything into a transaction should make it perform faster
		trace = new Trace(s);	//NOTE: don't use setTrace() method to avoid notification
		System.gc();
		
		// recall events for doStep matching
		if (!readSet.isEmpty())
			readSet.clear();
		if (!waitSet.isEmpty())
			waitSet.clear();
		for (Event re : getReadInputEvents())
			readSet.add(re.getName());
		for (Event we : getWaitEvents())
			waitSet.add(we.getName());

		// disable notification for modifying output ports
		// so that using EMF transactions is not required
		// while setting port value
		for (Port p : getOutputs())
			p.eSetDeliver(false);
		
		return SimulationStatus.OK_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws SimulationException 
	 * @generated NOT
	 */
	public IStatus initialise(int tStart, int tStop) throws SimulationException {
		// execute first two events: 'setup_constants' and 'initialise'
		//NOTE: setup_constants can be absent if there are no constants
		trace = trace.anyEvent(null);
		assert trace.getCurrent().getOp().getName() != null;
		if (!"$initialise_machine".equals(trace.getCurrent().getOp().getName()))
			trace = trace.anyEvent(null);
		if (!"$initialise_machine".equals(trace.getCurrent().getOp().getName()))
			throw new SimulationException("Cannot initialise component '" + getLabel()
					+ "'\nReason: $initialise_machine operation not found.");
		
		return SimulationStatus.OK_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws SimulationException 
	 * @throws ModelException 
	 * @generated NOT
	 */
	public IStatus readInputs() throws SimulationException, ModelException {
		assert trace != null;
		EList<Event> readEvents = getReadInputEvents();
		
		// skip if no inputs
		if (readEvents.isEmpty())
			return SimulationStatus.OK_STATUS;
		
		// build parameter predicate for event execution
		StringBuilder predicate = new StringBuilder("TRUE=TRUE");
		for (Port p : getInputs()) {
			// if port not connected, let ProB to pick the value non-deterministically
			if (p.getIn() == null)
				continue;
			
			assert p instanceof EventBPort && ((EventBPort) p).getParameter() != null;
			assert p.getIn().getValue() != null;

			// add parameter to event predicate string
			predicate.append("&" + ((EventBPort) p).getParameter().getName() + "=" + SimulationUtil.getEventBValue(p.getIn().getValue(), p.getType(), ((EventBPort) p).getIntToReal()));
		}
		
		// find enabled read event
		List<OpInfo> readOps = new ArrayList<OpInfo>();
		String predicateStr = predicate.toString();
		for (Event re : readEvents) {
			try {
				readOps.add(trace.findOneOp(re.getName(), predicateStr));
			} catch (IllegalArgumentException e) {
				// no operation found -> proceed
			} catch (BException e) {
				// BException, i.e. ProB failed
				throw new SimulationException("Cannot read inputs of component '" + getLabel() + "'\n" +
						"Reason: ProB failed to find enabled read event '" + re.getName() + "[" + predicateStr + "]'", e);
			}
		}
		
		// no reads are enabled
		if (readOps.isEmpty())
			throw new ModelException("No read events enabled in '" + getLabel() + "'");
		
		// execute read event
		trace = trace.add(readOps.get(random.nextInt(readOps.size())).getId());
		
		return SimulationStatus.OK_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IStatus writeOutputs() {
		assert trace != null;
		StateId state = trace.getCurrentState();
		
		for (Port p : getOutputs()) {
			assert p instanceof EventBPort && ((EventBPort) p).getVariable() != null;
			
			p.setValue(SimulationUtil.getFMIValue(
					(String) state.value(p.getName()), 
					p.getType(), 
					((EventBPort) p).getIntToReal()));
		}
		
		return SimulationStatus.OK_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws ModelException 
	 * @generated NOT
	 */
	public IStatus doStep(int time, int step) throws ModelException {
		Set<OpInfo> ops = null;
		OpInfo nextOp = null;
		boolean wait = false;
		while (!wait) {
			ops = trace.getStateSpace().evaluateOps(trace.getNextTransitions());
			
			// check deadlock
			if (ops == null || ops.isEmpty())
				throw new ModelException("Deadlock in '" + getLabel() + "'");
			
			// find next op
			nextOp = (OpInfo) ops.toArray()[random.nextInt(ops.size())];
			
			// check if wait and read
			assert nextOp.getName() != null;
			if (waitSet.contains(nextOp.getName())) {
				wait = true;
				if (readSet.contains(nextOp.getName()))
					break;
			}
			
			// execute
			trace = trace.add(nextOp.getId());
		}

		return SimulationStatus.OK_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IStatus terminate() {
		assert trace != null;
		trace.getStateSpace().endTransaction();
		
		// re-enable notifications
		for (Port p : getOutputs())
			p.eSetDeliver(true);
		
		// save trace
		if (((ComponentDiagram) eContainer()).isRecordTrace()) {
			String traceFilePath = WorkspaceSynchronizer.getFile(machine.eResource()).getLocation().removeFileExtension().toOSString()
					+ "_" + getLabel() + "_" + dateFormat.format(new java.util.Date()) + ".xml";
			trace.toString();	//XXX has to be called to fix the serialisation bug
			TraceConverter.save(trace, traceFilePath);
		}

//		// show in ProB
//		Injector injector = ServletContextListener.INJECTOR;
//		AnimationSelector selector = injector.getInstance(AnimationSelector.class);
//		selector.addNewAnimation(trace);
		
		trace = null;
		System.gc();
		
		return SimulationStatus.OK_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String doGetName() {
		if (this.eIsProxy()){
			String fragment = ((InternalEObject)this).eProxyURI().fragment();
			int ind = fragment.lastIndexOf("::");
			if (ind>-1) fragment = fragment.substring(ind+2);
			fragment = fragment.substring(fragment.lastIndexOf('.')+1);
			return fragment;
		}else{
			return name;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MultisimPackage.EVENT_BCOMPONENT__INPUTS:
				return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
			case MultisimPackage.EVENT_BCOMPONENT__OUTPUTS:
				return ((InternalEList<?>)getOutputs()).basicRemove(otherEnd, msgs);
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
			case MultisimPackage.EVENT_BCOMPONENT__NAME:
				return getName();
			case MultisimPackage.EVENT_BCOMPONENT__INPUTS:
				return getInputs();
			case MultisimPackage.EVENT_BCOMPONENT__OUTPUTS:
				return getOutputs();
			case MultisimPackage.EVENT_BCOMPONENT__STEP_PERIOD:
				return getStepPeriod();
			case MultisimPackage.EVENT_BCOMPONENT__MACHINE:
				if (resolve) return getMachine();
				return basicGetMachine();
			case MultisimPackage.EVENT_BCOMPONENT__COMPOSED:
				return isComposed();
			case MultisimPackage.EVENT_BCOMPONENT__READ_INPUT_EVENTS:
				return getReadInputEvents();
			case MultisimPackage.EVENT_BCOMPONENT__WAIT_EVENTS:
				return getWaitEvents();
			case MultisimPackage.EVENT_BCOMPONENT__TRACE:
				return getTrace();
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
			case MultisimPackage.EVENT_BCOMPONENT__NAME:
				setName((String)newValue);
				return;
			case MultisimPackage.EVENT_BCOMPONENT__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends Port>)newValue);
				return;
			case MultisimPackage.EVENT_BCOMPONENT__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends Port>)newValue);
				return;
			case MultisimPackage.EVENT_BCOMPONENT__STEP_PERIOD:
				setStepPeriod((Integer)newValue);
				return;
			case MultisimPackage.EVENT_BCOMPONENT__MACHINE:
				setMachine((Machine)newValue);
				return;
			case MultisimPackage.EVENT_BCOMPONENT__COMPOSED:
				setComposed((Boolean)newValue);
				return;
			case MultisimPackage.EVENT_BCOMPONENT__READ_INPUT_EVENTS:
				getReadInputEvents().clear();
				getReadInputEvents().addAll((Collection<? extends Event>)newValue);
				return;
			case MultisimPackage.EVENT_BCOMPONENT__WAIT_EVENTS:
				getWaitEvents().clear();
				getWaitEvents().addAll((Collection<? extends Event>)newValue);
				return;
			case MultisimPackage.EVENT_BCOMPONENT__TRACE:
				setTrace((Trace)newValue);
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
			case MultisimPackage.EVENT_BCOMPONENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MultisimPackage.EVENT_BCOMPONENT__INPUTS:
				getInputs().clear();
				return;
			case MultisimPackage.EVENT_BCOMPONENT__OUTPUTS:
				getOutputs().clear();
				return;
			case MultisimPackage.EVENT_BCOMPONENT__STEP_PERIOD:
				setStepPeriod(STEP_PERIOD_EDEFAULT);
				return;
			case MultisimPackage.EVENT_BCOMPONENT__MACHINE:
				setMachine((Machine)null);
				return;
			case MultisimPackage.EVENT_BCOMPONENT__COMPOSED:
				setComposed(COMPOSED_EDEFAULT);
				return;
			case MultisimPackage.EVENT_BCOMPONENT__READ_INPUT_EVENTS:
				getReadInputEvents().clear();
				return;
			case MultisimPackage.EVENT_BCOMPONENT__WAIT_EVENTS:
				getWaitEvents().clear();
				return;
			case MultisimPackage.EVENT_BCOMPONENT__TRACE:
				setTrace(TRACE_EDEFAULT);
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
			case MultisimPackage.EVENT_BCOMPONENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MultisimPackage.EVENT_BCOMPONENT__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case MultisimPackage.EVENT_BCOMPONENT__OUTPUTS:
				return outputs != null && !outputs.isEmpty();
			case MultisimPackage.EVENT_BCOMPONENT__STEP_PERIOD:
				return stepPeriod != STEP_PERIOD_EDEFAULT;
			case MultisimPackage.EVENT_BCOMPONENT__MACHINE:
				return machine != null;
			case MultisimPackage.EVENT_BCOMPONENT__COMPOSED:
				return composed != COMPOSED_EDEFAULT;
			case MultisimPackage.EVENT_BCOMPONENT__READ_INPUT_EVENTS:
				return readInputEvents != null && !readInputEvents.isEmpty();
			case MultisimPackage.EVENT_BCOMPONENT__WAIT_EVENTS:
				return waitEvents != null && !waitEvents.isEmpty();
			case MultisimPackage.EVENT_BCOMPONENT__TRACE:
				return TRACE_EDEFAULT == null ? trace != null : !TRACE_EDEFAULT.equals(trace);
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
		if (baseClass == EventBNamed.class) {
			switch (derivedFeatureID) {
				case MultisimPackage.EVENT_BCOMPONENT__NAME: return CorePackage.EVENT_BNAMED__NAME;
				default: return -1;
			}
		}
		if (baseClass == Component.class) {
			switch (derivedFeatureID) {
				case MultisimPackage.EVENT_BCOMPONENT__INPUTS: return MultisimPackage.COMPONENT__INPUTS;
				case MultisimPackage.EVENT_BCOMPONENT__OUTPUTS: return MultisimPackage.COMPONENT__OUTPUTS;
				case MultisimPackage.EVENT_BCOMPONENT__STEP_PERIOD: return MultisimPackage.COMPONENT__STEP_PERIOD;
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
		if (baseClass == EventBNamed.class) {
			switch (baseFeatureID) {
				case CorePackage.EVENT_BNAMED__NAME: return MultisimPackage.EVENT_BCOMPONENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == Component.class) {
			switch (baseFeatureID) {
				case MultisimPackage.COMPONENT__INPUTS: return MultisimPackage.EVENT_BCOMPONENT__INPUTS;
				case MultisimPackage.COMPONENT__OUTPUTS: return MultisimPackage.EVENT_BCOMPONENT__OUTPUTS;
				case MultisimPackage.COMPONENT__STEP_PERIOD: return MultisimPackage.EVENT_BCOMPONENT__STEP_PERIOD;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", stepPeriod: ");
		result.append(stepPeriod);
		result.append(", composed: ");
		result.append(composed);
		result.append(", trace: ");
		result.append(trace);
		result.append(')');
		return result.toString();
	}

	/* @custom
	 */
	@Override
	public String getExtensionId() {
		return MultisimPackage.EXTENSION_ID;
	}

} //EventBComponentImpl
