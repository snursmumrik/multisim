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

import org.ptolemy.fmi.FMIScalarVariable;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FMU Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.rms.components.FMUPort#getFmiScalarVar <em>Fmi Scalar Var</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.rms.components.ComponentsPackage#getFMUPort()
 * @model
 * @generated
 */
public interface FMUPort extends Port {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2014 University of Southampton.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html";

	/**
	 * Returns the value of the '<em><b>Fmi Scalar Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fmi Scalar Var</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fmi Scalar Var</em>' attribute.
	 * @see #setFmiScalarVar(FMIScalarVariable)
	 * @see ac.soton.rms.components.ComponentsPackage#getFMUPort_FmiScalarVar()
	 * @model dataType="ac.soton.rms.components.FMIScalarVariable"
	 * @generated
	 */
	FMIScalarVariable getFmiScalarVar();

	/**
	 * Sets the value of the '{@link ac.soton.rms.components.FMUPort#getFmiScalarVar <em>Fmi Scalar Var</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fmi Scalar Var</em>' attribute.
	 * @see #getFmiScalarVar()
	 * @generated
	 */
	void setFmiScalarVar(FMIScalarVariable value);

} // FMUPort
