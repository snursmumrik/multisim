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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.multisim.Port#getIn <em>In</em>}</li>
 *   <li>{@link ac.soton.multisim.Port#getOut <em>Out</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.multisim.MultisimPackage#getPort()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='compatibleType'"
 * @generated
 */
public interface Port extends AbstractVariable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2015 University of Southampton.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html";

	/**
	 * Returns the value of the '<em><b>In</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link ac.soton.multisim.Port#getOut <em>Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In</em>' reference.
	 * @see #setIn(Port)
	 * @see ac.soton.multisim.MultisimPackage#getPort_In()
	 * @see ac.soton.multisim.Port#getOut
	 * @model opposite="out"
	 * @generated
	 */
	Port getIn();

	/**
	 * Sets the value of the '{@link ac.soton.multisim.Port#getIn <em>In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In</em>' reference.
	 * @see #getIn()
	 * @generated
	 */
	void setIn(Port value);

	/**
	 * Returns the value of the '<em><b>Out</b></em>' reference list.
	 * The list contents are of type {@link ac.soton.multisim.Port}.
	 * It is bidirectional and its opposite is '{@link ac.soton.multisim.Port#getIn <em>In</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out</em>' reference list.
	 * @see ac.soton.multisim.MultisimPackage#getPort_Out()
	 * @see ac.soton.multisim.Port#getIn
	 * @model opposite="in"
	 * @generated
	 */
	EList<Port> getOut();

} // Port
