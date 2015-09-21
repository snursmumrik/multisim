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

import info.monitorenter.gui.chart.Chart2D;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Display Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.multisim.DisplayComponent#getChart <em>Chart</em>}</li>
 *   <li>{@link ac.soton.multisim.DisplayComponent#getBufferSize <em>Buffer Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.multisim.MultisimPackage#getDisplayComponent()
 * @model
 * @generated
 */
public interface DisplayComponent extends Component {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2015 University of Southampton.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html";

	/**
	 * Returns the value of the '<em><b>Chart</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chart</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chart</em>' attribute.
	 * @see #setChart(Chart2D)
	 * @see ac.soton.multisim.MultisimPackage#getDisplayComponent_Chart()
	 * @model dataType="ac.soton.multisim.Chart2D" transient="true"
	 * @generated
	 */
	Chart2D getChart();

	/**
	 * Sets the value of the '{@link ac.soton.multisim.DisplayComponent#getChart <em>Chart</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chart</em>' attribute.
	 * @see #getChart()
	 * @generated
	 */
	void setChart(Chart2D value);

	/**
	 * Returns the value of the '<em><b>Buffer Size</b></em>' attribute.
	 * The default value is <code>"1500"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Buffer Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffer Size</em>' attribute.
	 * @see #setBufferSize(int)
	 * @see ac.soton.multisim.MultisimPackage#getDisplayComponent_BufferSize()
	 * @model default="1500"
	 * @generated
	 */
	int getBufferSize();

	/**
	 * Sets the value of the '{@link ac.soton.multisim.DisplayComponent#getBufferSize <em>Buffer Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffer Size</em>' attribute.
	 * @see #getBufferSize()
	 * @generated
	 */
	void setBufferSize(int value);

} // DisplayComponent
