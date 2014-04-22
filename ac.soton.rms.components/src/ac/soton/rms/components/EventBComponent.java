/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package ac.soton.rms.components;

import org.eventb.emf.core.AbstractExtension;

import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event BComponent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.rms.components.EventBComponent#getMachine <em>Machine</em>}</li>
 *   <li>{@link ac.soton.rms.components.EventBComponent#isComposed <em>Composed</em>}</li>
 *   <li>{@link ac.soton.rms.components.EventBComponent#getTraceFilePath <em>Trace File Path</em>}</li>
 *   <li>{@link ac.soton.rms.components.EventBComponent#getReadInputEvents <em>Read Input Events</em>}</li>
 *   <li>{@link ac.soton.rms.components.EventBComponent#getWaitEvents <em>Wait Events</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.rms.components.ComponentsPackage#getEventBComponent()
 * @model
 * @generated
 */
public interface EventBComponent extends AbstractExtension, Component {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2014 University of Southampton.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html";

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
	 * @see ac.soton.rms.components.ComponentsPackage#getEventBComponent_Machine()
	 * @model
	 * @generated
	 */
	Machine getMachine();

	/**
	 * Sets the value of the '{@link ac.soton.rms.components.EventBComponent#getMachine <em>Machine</em>}' reference.
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
	 * @see ac.soton.rms.components.ComponentsPackage#getEventBComponent_Composed()
	 * @model required="true"
	 * @generated
	 */
	boolean isComposed();

	/**
	 * Sets the value of the '{@link ac.soton.rms.components.EventBComponent#isComposed <em>Composed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composed</em>' attribute.
	 * @see #isComposed()
	 * @generated
	 */
	void setComposed(boolean value);

	/**
	 * Returns the value of the '<em><b>Trace File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace File Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace File Path</em>' attribute.
	 * @see #setTraceFilePath(String)
	 * @see ac.soton.rms.components.ComponentsPackage#getEventBComponent_TraceFilePath()
	 * @model
	 * @generated
	 */
	String getTraceFilePath();

	/**
	 * Sets the value of the '{@link ac.soton.rms.components.EventBComponent#getTraceFilePath <em>Trace File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace File Path</em>' attribute.
	 * @see #getTraceFilePath()
	 * @generated
	 */
	void setTraceFilePath(String value);

	/**
	 * Returns the value of the '<em><b>Read Input Events</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Input Events</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Input Events</em>' reference.
	 * @see #setReadInputEvents(Event)
	 * @see ac.soton.rms.components.ComponentsPackage#getEventBComponent_ReadInputEvents()
	 * @model
	 * @generated
	 */
	Event getReadInputEvents();

	/**
	 * Sets the value of the '{@link ac.soton.rms.components.EventBComponent#getReadInputEvents <em>Read Input Events</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Input Events</em>' reference.
	 * @see #getReadInputEvents()
	 * @generated
	 */
	void setReadInputEvents(Event value);

	/**
	 * Returns the value of the '<em><b>Wait Events</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wait Events</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wait Events</em>' reference.
	 * @see #setWaitEvents(Event)
	 * @see ac.soton.rms.components.ComponentsPackage#getEventBComponent_WaitEvents()
	 * @model
	 * @generated
	 */
	Event getWaitEvents();

	/**
	 * Sets the value of the '{@link ac.soton.rms.components.EventBComponent#getWaitEvents <em>Wait Events</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wait Events</em>' reference.
	 * @see #getWaitEvents()
	 * @generated
	 */
	void setWaitEvents(Event value);

} // EventBComponent
