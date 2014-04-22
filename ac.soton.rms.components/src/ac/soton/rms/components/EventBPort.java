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

import org.eventb.emf.core.machine.Parameter;
import org.eventb.emf.core.machine.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event BPort</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.rms.components.EventBPort#getParameter <em>Parameter</em>}</li>
 *   <li>{@link ac.soton.rms.components.EventBPort#getVariable <em>Variable</em>}</li>
 *   <li>{@link ac.soton.rms.components.EventBPort#getIntToReal <em>Int To Real</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.rms.components.ComponentsPackage#getEventBPort()
 * @model
 * @generated
 */
public interface EventBPort extends Port {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2014 University of Southampton.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html";

	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' reference.
	 * @see #setParameter(Parameter)
	 * @see ac.soton.rms.components.ComponentsPackage#getEventBPort_Parameter()
	 * @model
	 * @generated
	 */
	Parameter getParameter();

	/**
	 * Sets the value of the '{@link ac.soton.rms.components.EventBPort#getParameter <em>Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter</em>' reference.
	 * @see #getParameter()
	 * @generated
	 */
	void setParameter(Parameter value);

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(Variable)
	 * @see ac.soton.rms.components.ComponentsPackage#getEventBPort_Variable()
	 * @model
	 * @generated
	 */
	Variable getVariable();

	/**
	 * Sets the value of the '{@link ac.soton.rms.components.EventBPort#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>Int To Real</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Int To Real</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Int To Real</em>' attribute.
	 * @see #setIntToReal(int)
	 * @see ac.soton.rms.components.ComponentsPackage#getEventBPort_IntToReal()
	 * @model
	 * @generated
	 */
	int getIntToReal();

	/**
	 * Sets the value of the '{@link ac.soton.rms.components.EventBPort#getIntToReal <em>Int To Real</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Int To Real</em>' attribute.
	 * @see #getIntToReal()
	 * @generated
	 */
	void setIntToReal(int value);

} // EventBPort
