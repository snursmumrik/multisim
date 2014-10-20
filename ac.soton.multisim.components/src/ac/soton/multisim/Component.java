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
import org.eventb.emf.core.EventBNamed;

import ac.soton.multisim.exception.ModelException;
import ac.soton.multisim.exception.SimulationException;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.multisim.Component#getInputs <em>Inputs</em>}</li>
 *   <li>{@link ac.soton.multisim.Component#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link ac.soton.multisim.Component#getStepPeriod <em>Step Period</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.multisim.MultisimPackage#getComponent()
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
	 * The list contents are of type {@link ac.soton.multisim.Port}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inputs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' containment reference list.
	 * @see ac.soton.multisim.MultisimPackage#getComponent_Inputs()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Port> getInputs();

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' containment reference list.
	 * The list contents are of type {@link ac.soton.multisim.Port}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' containment reference list.
	 * @see ac.soton.multisim.MultisimPackage#getComponent_Outputs()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Port> getOutputs();

	/**
	 * Returns the value of the '<em><b>Step Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step Period</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step Period</em>' attribute.
	 * @see #setStepPeriod(int)
	 * @see ac.soton.multisim.MultisimPackage#getComponent_StepPeriod()
	 * @model
	 * @generated
	 */
	int getStepPeriod();

	/**
	 * Sets the value of the '{@link ac.soton.multisim.Component#getStepPeriod <em>Step Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Period</em>' attribute.
	 * @see #getStepPeriod()
	 * @generated
	 */
	void setStepPeriod(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="ac.soton.multisim.SimulationException ac.soton.multisim.ModelException"
	 * @generated
	 */
	void instantiate() throws SimulationException, ModelException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="ac.soton.multisim.SimulationException"
	 * @generated
	 */
	void initialise(int tStart, int tStop) throws SimulationException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="ac.soton.multisim.SimulationException ac.soton.multisim.ModelException"
	 * @generated
	 */
	void readInputs() throws SimulationException, ModelException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void writeOutputs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="ac.soton.multisim.SimulationException ac.soton.multisim.ModelException"
	 * @generated
	 */
	void doStep(int time, int step) throws ModelException, SimulationException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void terminate();

} // Component
