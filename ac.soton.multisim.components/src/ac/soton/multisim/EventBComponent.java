/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package ac.soton.multisim;

import org.eclipse.emf.common.util.EList;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;

import de.prob.statespace.Trace;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event BComponent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.multisim.EventBComponent#getMachine <em>Machine</em>}</li>
 *   <li>{@link ac.soton.multisim.EventBComponent#isComposed <em>Composed</em>}</li>
 *   <li>{@link ac.soton.multisim.EventBComponent#getStartStepEvents <em>Start Step Events</em>}</li>
 *   <li>{@link ac.soton.multisim.EventBComponent#getEndStepEvents <em>End Step Events</em>}</li>
 *   <li>{@link ac.soton.multisim.EventBComponent#getTrace <em>Trace</em>}</li>
 *   <li>{@link ac.soton.multisim.EventBComponent#isRecordTrace <em>Record Trace</em>}</li>
 *   <li>{@link ac.soton.multisim.EventBComponent#getTraceFileName <em>Trace File Name</em>}</li>
 *   <li>{@link ac.soton.multisim.EventBComponent#getStepSize <em>Step Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.multisim.MultisimPackage#getEventBComponent()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='consistentReadEvents\nvalidMachineReference'"
 * @generated
 */
public interface EventBComponent extends AbstractExtension, Component {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2015 University of Southampton.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html";

	/**
	 * Returns the value of the '<em><b>Machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Machine</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machine</em>' reference.
	 * @see #setMachine(Machine)
	 * @see ac.soton.multisim.MultisimPackage#getEventBComponent_Machine()
	 * @model required="true"
	 * @generated
	 */
	Machine getMachine();

	/**
	 * Sets the value of the '{@link ac.soton.multisim.EventBComponent#getMachine <em>Machine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Machine</em>' reference.
	 * @see #getMachine()
	 * @generated
	 */
	void setMachine(Machine value);

	/**
	 * Returns the value of the '<em><b>Composed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composed</em>' attribute.
	 * @see #setComposed(boolean)
	 * @see ac.soton.multisim.MultisimPackage#getEventBComponent_Composed()
	 * @model required="true"
	 * @generated
	 */
	boolean isComposed();

	/**
	 * Sets the value of the '{@link ac.soton.multisim.EventBComponent#isComposed <em>Composed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composed</em>' attribute.
	 * @see #isComposed()
	 * @generated
	 */
	void setComposed(boolean value);

	/**
	 * Returns the value of the '<em><b>Start Step Events</b></em>' reference list.
	 * The list contents are of type {@link org.eventb.emf.core.machine.Event}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Step Events</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Step Events</em>' reference list.
	 * @see ac.soton.multisim.MultisimPackage#getEventBComponent_StartStepEvents()
	 * @model required="true"
	 * @generated
	 */
	EList<Event> getStartStepEvents();

	/**
	 * Returns the value of the '<em><b>End Step Events</b></em>' reference list.
	 * The list contents are of type {@link org.eventb.emf.core.machine.Event}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Step Events</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Step Events</em>' reference list.
	 * @see ac.soton.multisim.MultisimPackage#getEventBComponent_EndStepEvents()
	 * @model required="true"
	 * @generated
	 */
	EList<Event> getEndStepEvents();

	/**
	 * Returns the value of the '<em><b>Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace</em>' attribute.
	 * @see #setTrace(Trace)
	 * @see ac.soton.multisim.MultisimPackage#getEventBComponent_Trace()
	 * @model dataType="ac.soton.multisim.ProBTrace" transient="true"
	 * @generated
	 */
	Trace getTrace();

	/**
	 * Sets the value of the '{@link ac.soton.multisim.EventBComponent#getTrace <em>Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace</em>' attribute.
	 * @see #getTrace()
	 * @generated
	 */
	void setTrace(Trace value);

	/**
	 * Returns the value of the '<em><b>Record Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Record Trace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Record Trace</em>' attribute.
	 * @see #setRecordTrace(boolean)
	 * @see ac.soton.multisim.MultisimPackage#getEventBComponent_RecordTrace()
	 * @model
	 * @generated
	 */
	boolean isRecordTrace();

	/**
	 * Sets the value of the '{@link ac.soton.multisim.EventBComponent#isRecordTrace <em>Record Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Record Trace</em>' attribute.
	 * @see #isRecordTrace()
	 * @generated
	 */
	void setRecordTrace(boolean value);

	/**
	 * Returns the value of the '<em><b>Trace File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace File Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace File Name</em>' attribute.
	 * @see #setTraceFileName(String)
	 * @see ac.soton.multisim.MultisimPackage#getEventBComponent_TraceFileName()
	 * @model
	 * @generated
	 */
	String getTraceFileName();

	/**
	 * Sets the value of the '{@link ac.soton.multisim.EventBComponent#getTraceFileName <em>Trace File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace File Name</em>' attribute.
	 * @see #getTraceFileName()
	 * @generated
	 */
	void setTraceFileName(String value);

	/**
	 * Returns the value of the '<em><b>Step Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step Size</em>' attribute.
	 * @see #setStepSize(int)
	 * @see ac.soton.multisim.MultisimPackage#getEventBComponent_StepSize()
	 * @model
	 * @generated
	 */
	int getStepSize();

	/**
	 * Sets the value of the '{@link ac.soton.multisim.EventBComponent#getStepSize <em>Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Size</em>' attribute.
	 * @see #getStepSize()
	 * @generated
	 */
	void setStepSize(int value);

} // EventBComponent
