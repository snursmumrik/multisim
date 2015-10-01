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

import org.eventb.emf.core.EventBNamedCommentedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.multisim.AbstractVariable#getType <em>Type</em>}</li>
 *   <li>{@link ac.soton.multisim.AbstractVariable#getCausality <em>Causality</em>}</li>
 *   <li>{@link ac.soton.multisim.AbstractVariable#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.multisim.MultisimPackage#getAbstractVariable()
 * @model abstract="true"
 * @generated
 */
public interface AbstractVariable extends EventBNamedCommentedElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2015 University of Southampton.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html";

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link ac.soton.multisim.VariableType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see ac.soton.multisim.VariableType
	 * @see #setType(VariableType)
	 * @see ac.soton.multisim.MultisimPackage#getAbstractVariable_Type()
	 * @model required="true"
	 * @generated
	 */
	VariableType getType();

	/**
	 * Sets the value of the '{@link ac.soton.multisim.AbstractVariable#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see ac.soton.multisim.VariableType
	 * @see #getType()
	 * @generated
	 */
	void setType(VariableType value);

	/**
	 * Returns the value of the '<em><b>Causality</b></em>' attribute.
	 * The literals are from the enumeration {@link ac.soton.multisim.VariableCausality}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Causality</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Causality</em>' attribute.
	 * @see ac.soton.multisim.VariableCausality
	 * @see #setCausality(VariableCausality)
	 * @see ac.soton.multisim.MultisimPackage#getAbstractVariable_Causality()
	 * @model required="true"
	 * @generated
	 */
	VariableCausality getCausality();

	/**
	 * Sets the value of the '{@link ac.soton.multisim.AbstractVariable#getCausality <em>Causality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Causality</em>' attribute.
	 * @see ac.soton.multisim.VariableCausality
	 * @see #getCausality()
	 * @generated
	 */
	void setCausality(VariableCausality value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Object)
	 * @see ac.soton.multisim.MultisimPackage#getAbstractVariable_Value()
	 * @model transient="true"
	 * @generated
	 */
	Object getValue();

	/**
	 * Sets the value of the '{@link ac.soton.multisim.AbstractVariable#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Object value);

} // AbstractVariable
