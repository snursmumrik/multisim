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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eventb.emf.core.EventBNamed;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.rms.components.Component#getInputs <em>Inputs</em>}</li>
 *   <li>{@link ac.soton.rms.components.Component#getOutputs <em>Outputs</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.rms.components.ComponentsPackage#getComponent()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Component extends EventBNamed {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2014 University of Southampton.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html";

	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
	 * The list contents are of type {@link ac.soton.rms.components.Port}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inputs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' containment reference list.
	 * @see ac.soton.rms.components.ComponentsPackage#getComponent_Inputs()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Port> getInputs();

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' containment reference list.
	 * The list contents are of type {@link ac.soton.rms.components.Port}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' containment reference list.
	 * @see ac.soton.rms.components.ComponentsPackage#getComponent_Outputs()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Port> getOutputs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="ac.soton.rms.components.IStatus"
	 * @generated
	 */
	IStatus instantiate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="ac.soton.rms.components.IStatus"
	 * @generated
	 */
	IStatus initialise(int tStart, int tStop);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="ac.soton.rms.components.IStatus"
	 * @generated
	 */
	IStatus readInputs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="ac.soton.rms.components.IStatus"
	 * @generated
	 */
	IStatus writeOutputs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="ac.soton.rms.components.IStatus"
	 * @generated
	 */
	IStatus doStep(int time, int step);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="ac.soton.rms.components.IStatus"
	 * @generated
	 */
	IStatus terminate();

} // Component
