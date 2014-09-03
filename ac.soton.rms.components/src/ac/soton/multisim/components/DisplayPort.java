/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package ac.soton.multisim.components;

import info.monitorenter.gui.chart.ITrace2D;

import java.awt.Color;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Display Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.multisim.components.DisplayPort#getTrace <em>Trace</em>}</li>
 *   <li>{@link ac.soton.multisim.components.DisplayPort#getColor <em>Color</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.multisim.components.ComponentsPackage#getDisplayPort()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='nonStringInput'"
 * @generated
 */
public interface DisplayPort extends Port {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2014 University of Southampton.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html";

	/**
	 * Returns the value of the '<em><b>Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace</em>' attribute.
	 * @see #setTrace(ITrace2D)
	 * @see ac.soton.multisim.components.ComponentsPackage#getDisplayPort_Trace()
	 * @model dataType="ac.soton.multisim.components.ITrace2D" transient="true"
	 * @generated
	 */
	ITrace2D getTrace();

	/**
	 * Sets the value of the '{@link ac.soton.multisim.components.DisplayPort#getTrace <em>Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace</em>' attribute.
	 * @see #getTrace()
	 * @generated
	 */
	void setTrace(ITrace2D value);

	/**
	 * Returns the value of the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Color</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color</em>' attribute.
	 * @see #setColor(Color)
	 * @see ac.soton.multisim.components.ComponentsPackage#getDisplayPort_Color()
	 * @model dataType="ac.soton.multisim.components.Color"
	 * @generated
	 */
	Color getColor();

	/**
	 * Sets the value of the '{@link ac.soton.multisim.components.DisplayPort#getColor <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color</em>' attribute.
	 * @see #getColor()
	 * @generated
	 */
	void setColor(Color value);

} // DisplayPort
