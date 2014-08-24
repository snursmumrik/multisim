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

import ac.soton.rms.components.Component;
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
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
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
import org.rodinp.core.IRodinFile;
import org.rodinp.core.RodinCore;
import ac.soton.rms.components.ComponentsPackage;
import ac.soton.rms.components.EventBComponent;
import ac.soton.rms.components.EventBPort;
import ac.soton.rms.components.Port;
import ac.soton.rms.components.util.custom.SimStatus;
import ac.soton.rms.components.util.custom.SimulationUtil;
import com.google.inject.Injector;
import de.be4.classicalb.core.parser.exceptions.BException;
import de.prob.model.eventb.EventBModel;
import de.prob.scripting.EventBFactory;
import de.prob.statespace.AnimationSelector;
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
 *   <li>{@link ac.soton.rms.components.impl.EventBComponentImpl#getName <em>Name</em>}</li>
 *   <li>{@link ac.soton.rms.components.impl.EventBComponentImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link ac.soton.rms.components.impl.EventBComponentImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link ac.soton.rms.components.impl.EventBComponentImpl#getMachine <em>Machine</em>}</li>
 *   <li>{@link ac.soton.rms.components.impl.EventBComponentImpl#isComposed <em>Composed</em>}</li>
 *   <li>{@link ac.soton.rms.components.impl.EventBComponentImpl#getReadInputEvents <em>Read Input Events</em>}</li>
 *   <li>{@link ac.soton.rms.components.impl.EventBComponentImpl#getWaitEvents <em>Wait Events</em>}</li>
 *   <li>{@link ac.soton.rms.components.impl.EventBComponentImpl#getTrace <em>Trace</em>}</li>
 *   <li>{@link ac.soton.rms.components.impl.EventBComponentImpl#getStepPeriod <em>Step Period</em>}</li>
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
		return ComponentsPackage.Literals.EVENT_BCOMPONENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BCOMPONENT__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BCOMPONENT__TRACE, oldTrace, trace));
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
	 * Returns Event-B Root element of a machine.
	 * @param machine
	 * @return
	 * @custom
	 */
	private IEventBRoot getMachineRoot(Machine machine) {
		Resource resource = machine.eResource();
		if (resource != null) {
			URI uri = resource.getURI();
			if (uri.isPlatformResource()) {
				IFile file = WorkspaceSynchronizer.getFile(resource);
				IRodinFile rodinFile = RodinCore.valueOf(file);
				if (rodinFile != null) {
					return (IEventBRoot) rodinFile.getRoot();
				}
			}
			//FIXME: root for a non-workspace resource?
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IStatus instantiate() {
		// load event-b machine
		final IEventBRoot machineRoot = getMachineRoot(getMachine());
		if (machineRoot == null) {
			return new SimStatus(Status.ERROR, SimStatus.ID, "Cannot load machine component '" + getLabel()
					+ "'\nReason: Machine root cannot be determined.");
		}
		
		String fileName = machineRoot.getResource().getRawLocation()
				.makeAbsolute().toOSString();
		if (fileName.endsWith(".buc")) {
			fileName = fileName.replace(".buc", ".bcc");
		} else {
			fileName = fileName.replace(".bum", ".bcm");
		}

		Injector injector = ServletContextListener.INJECTOR;
		final EventBFactory instance = injector.getInstance(EventBFactory.class);
		Map<String, String> params = new HashMap<String, String>();
		params.put("IGNORE_HASH_COLLISIONS","TRUE");
//		params.put("FORGET_STATE_SPACE","TRUE");
		params.put("MEMO", "TRUE");
		params.put("TIME_OUT", "4000");
		EventBModel model = instance.load(fileName, params, false);
		if (model == null)
			return SimStatus.PROB_ERROR;
		
		StateSpace s = model.getStatespace();
		s.startTransaction();	// presumably putting everything into a transaction should make it perform faster
		trace = new Trace(s);	//NOTE: don't use setTrace() method to avoid notification
		System.gc();
		
		// recall events for doStep matching
		if (!readSet.isEmpty())
			readSet.clear();
		for (Event re : getReadInputEvents())
			readSet.add(re.getName());
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
	public IStatus initialise(int tStart, int tStop) {
		// execute first two events: 'setup_constants' and 'initialise'
		//NOTE: setup_constants can be absent if there are no constants
		trace = trace.anyEvent(null);
		assert trace.getCurrent().getOp().getName() != null;
		if (!"$initialise_machine".equals(trace.getCurrent().getOp().getName()))
			trace = trace.anyEvent(null);
		if (!"$initialise_machine".equals(trace.getCurrent().getOp().getName()))
			return new SimStatus(Status.ERROR, SimStatus.ID, "Cannot initialise component '" + getLabel()
					+ "'\nReason: $initialise_machine operation not found.");
		
		return SimStatus.OK_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @generated NOT
	 */
	public IStatus readInputs() {
		assert trace != null;
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
			} catch (BException | IllegalArgumentException e) {
				return new SimStatus(Status.ERROR, SimStatus.ID, "Event-B error when reading inputs of component '" + getLabel() + "'\n" +
						"Reason: ProB failed to find an enabled read event '" + re.getName() + "' with the predicate '" + predicateStr + "'", e);
			}
		}
		
		// stop if no reads are enabled
		if (readOps.isEmpty())
			return SimStatus.EVENTB_NO_READS;
		
		// execute read event
		trace = trace.add(readOps.get(random.nextInt(readOps.size())).getId());
		
		return SimStatus.OK_STATUS;
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
		
		return SimStatus.OK_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IStatus doStep(int time, int step) {
		Set<OpInfo> ops = null;
		OpInfo nextOp = null;
		boolean noWait = true;
		IStatus status = SimStatus.OK_STATUS;
		
		while (noWait) {
			ops = trace.getStateSpace().evaluateOps(trace.getNextTransitions());
			
			// check deadlock
			if (ops == null || ops.isEmpty())
				return SimStatus.EVENTB_DEADLOCK;
			
			// find next op
			nextOp = (OpInfo) ops.toArray()[random.nextInt(ops.size())];
			
			// check if wait and read
			assert nextOp.getName() != null;
			if (waitSet.contains(nextOp.getName())) {
				noWait = false;
				if (readSet.contains(nextOp.getName()))
					break;
			}
			
			// execute
			trace = trace.add(nextOp.getId());
		}

		return status;
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
		String traceFilePath = WorkspaceSynchronizer.getFile(machine.eResource()).getLocation().removeFileExtension().toOSString()
				+ "_" + dateFormat.format(new java.util.Date()) + ".xml";
		trace.toString();	//XXX has to be called to fix the serialisation bug
		TraceConverter.save(trace, traceFilePath);

		// show in ProB
		Injector injector = ServletContextListener.INJECTOR;
		AnimationSelector selector = injector.getInstance(AnimationSelector.class);
		selector.addNewAnimation(trace);
		
		trace = null;
		System.gc();
		
		return SimStatus.OK_STATUS;
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
			case ComponentsPackage.EVENT_BCOMPONENT__INPUTS:
				return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
			case ComponentsPackage.EVENT_BCOMPONENT__OUTPUTS:
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
			case ComponentsPackage.EVENT_BCOMPONENT__NAME:
				return getName();
			case ComponentsPackage.EVENT_BCOMPONENT__INPUTS:
				return getInputs();
			case ComponentsPackage.EVENT_BCOMPONENT__OUTPUTS:
				return getOutputs();
			case ComponentsPackage.EVENT_BCOMPONENT__MACHINE:
				if (resolve) return getMachine();
				return basicGetMachine();
			case ComponentsPackage.EVENT_BCOMPONENT__COMPOSED:
				return isComposed();
			case ComponentsPackage.EVENT_BCOMPONENT__READ_INPUT_EVENTS:
				return getReadInputEvents();
			case ComponentsPackage.EVENT_BCOMPONENT__WAIT_EVENTS:
				return getWaitEvents();
			case ComponentsPackage.EVENT_BCOMPONENT__TRACE:
				return getTrace();
			case ComponentsPackage.EVENT_BCOMPONENT__STEP_PERIOD:
				return getStepPeriod();
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
			case ComponentsPackage.EVENT_BCOMPONENT__NAME:
				setName((String)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends Port>)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends Port>)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__MACHINE:
				setMachine((Machine)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__COMPOSED:
				setComposed((Boolean)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__READ_INPUT_EVENTS:
				getReadInputEvents().clear();
				getReadInputEvents().addAll((Collection<? extends Event>)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__WAIT_EVENTS:
				getWaitEvents().clear();
				getWaitEvents().addAll((Collection<? extends Event>)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__TRACE:
				setTrace((Trace)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__STEP_PERIOD:
				setStepPeriod((Integer)newValue);
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
			case ComponentsPackage.EVENT_BCOMPONENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__INPUTS:
				getInputs().clear();
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__OUTPUTS:
				getOutputs().clear();
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__MACHINE:
				setMachine((Machine)null);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__COMPOSED:
				setComposed(COMPOSED_EDEFAULT);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__READ_INPUT_EVENTS:
				getReadInputEvents().clear();
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__WAIT_EVENTS:
				getWaitEvents().clear();
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__TRACE:
				setTrace(TRACE_EDEFAULT);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__STEP_PERIOD:
				setStepPeriod(STEP_PERIOD_EDEFAULT);
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
			case ComponentsPackage.EVENT_BCOMPONENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ComponentsPackage.EVENT_BCOMPONENT__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case ComponentsPackage.EVENT_BCOMPONENT__OUTPUTS:
				return outputs != null && !outputs.isEmpty();
			case ComponentsPackage.EVENT_BCOMPONENT__MACHINE:
				return machine != null;
			case ComponentsPackage.EVENT_BCOMPONENT__COMPOSED:
				return composed != COMPOSED_EDEFAULT;
			case ComponentsPackage.EVENT_BCOMPONENT__READ_INPUT_EVENTS:
				return readInputEvents != null && !readInputEvents.isEmpty();
			case ComponentsPackage.EVENT_BCOMPONENT__WAIT_EVENTS:
				return waitEvents != null && !waitEvents.isEmpty();
			case ComponentsPackage.EVENT_BCOMPONENT__TRACE:
				return TRACE_EDEFAULT == null ? trace != null : !TRACE_EDEFAULT.equals(trace);
			case ComponentsPackage.EVENT_BCOMPONENT__STEP_PERIOD:
				return stepPeriod != STEP_PERIOD_EDEFAULT;
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
				case ComponentsPackage.EVENT_BCOMPONENT__NAME: return CorePackage.EVENT_BNAMED__NAME;
				default: return -1;
			}
		}
		if (baseClass == Component.class) {
			switch (derivedFeatureID) {
				case ComponentsPackage.EVENT_BCOMPONENT__INPUTS: return ComponentsPackage.COMPONENT__INPUTS;
				case ComponentsPackage.EVENT_BCOMPONENT__OUTPUTS: return ComponentsPackage.COMPONENT__OUTPUTS;
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
				case CorePackage.EVENT_BNAMED__NAME: return ComponentsPackage.EVENT_BCOMPONENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == Component.class) {
			switch (baseFeatureID) {
				case ComponentsPackage.COMPONENT__INPUTS: return ComponentsPackage.EVENT_BCOMPONENT__INPUTS;
				case ComponentsPackage.COMPONENT__OUTPUTS: return ComponentsPackage.EVENT_BCOMPONENT__OUTPUTS;
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
		result.append(", composed: ");
		result.append(composed);
		result.append(", trace: ");
		result.append(trace);
		result.append(", stepPeriod: ");
		result.append(stepPeriod);
		result.append(')');
		return result.toString();
	}

	@Override
	public String getExtensionId() {
		return ComponentsPackage.COMPONENTS_EXTENSION_ID;
	}

} //EventBComponentImpl
