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



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FMU Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.rms.components.FMUVariable#getFmiName <em>Fmi Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.rms.components.ComponentsPackage#getFMUVariable()
 * @model
 * @generated
 */
public interface FMUVariable extends AbstractVariable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2014 University of Southampton.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html";

	/**
	 * Returns the value of the '<em><b>Fmi Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fmi Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fmi Name</em>' attribute.
	 * @see #setFmiName(String)
	 * @see ac.soton.rms.components.ComponentsPackage#getFMUVariable_FmiName()
	 * @model required="true"
	 * @generated
	 */
	String getFmiName();

	/**
	 * Sets the value of the '{@link ac.soton.rms.components.FMUVariable#getFmiName <em>Fmi Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fmi Name</em>' attribute.
	 * @see #getFmiName()
	 * @generated
	 */
	void setFmiName(String value);

} // FMUVariable
