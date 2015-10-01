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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.multisim.ComponentDiagram#getComponents <em>Components</em>}</li>
 *   <li>{@link ac.soton.multisim.ComponentDiagram#getStopTime <em>Stop Time</em>}</li>
 *   <li>{@link ac.soton.multisim.ComponentDiagram#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link ac.soton.multisim.ComponentDiagram#getArguments <em>Arguments</em>}</li>
 *   <li>{@link ac.soton.multisim.ComponentDiagram#isRecordOutputs <em>Record Outputs</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.multisim.MultisimPackage#getComponentDiagram()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='noDirectFMU'"
 * @generated
 */
public interface ComponentDiagram extends EventBNamed {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2015 University of Southampton.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html";

	/**
	 * Returns the value of the '<em><b>Components</b></em>' containment reference list.
	 * The list contents are of type {@link ac.soton.multisim.Component}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' containment reference list.
	 * @see ac.soton.multisim.MultisimPackage#getComponentDiagram_Components()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Component> getComponents();

	/**
	 * Returns the value of the '<em><b>Stop Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stop Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stop Time</em>' attribute.
	 * @see #setStopTime(int)
	 * @see ac.soton.multisim.MultisimPackage#getComponentDiagram_StopTime()
	 * @model
	 * @generated
	 */
	int getStopTime();

	/**
	 * Sets the value of the '{@link ac.soton.multisim.ComponentDiagram#getStopTime <em>Stop Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stop Time</em>' attribute.
	 * @see #getStopTime()
	 * @generated
	 */
	void setStopTime(int value);

	/**
	 * Returns the value of the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Time</em>' attribute.
	 * @see #setStartTime(int)
	 * @see ac.soton.multisim.MultisimPackage#getComponentDiagram_StartTime()
	 * @model
	 * @generated
	 */
	int getStartTime();

	/**
	 * Sets the value of the '{@link ac.soton.multisim.ComponentDiagram#getStartTime <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Time</em>' attribute.
	 * @see #getStartTime()
	 * @generated
	 */
	void setStartTime(int value);

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' attribute.
	 * @see #setArguments(String)
	 * @see ac.soton.multisim.MultisimPackage#getComponentDiagram_Arguments()
	 * @model
	 * @generated
	 */
	String getArguments();

	/**
	 * Sets the value of the '{@link ac.soton.multisim.ComponentDiagram#getArguments <em>Arguments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Arguments</em>' attribute.
	 * @see #getArguments()
	 * @generated
	 */
	void setArguments(String value);

	/**
	 * Returns the value of the '<em><b>Record Outputs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Record Outputs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Record Outputs</em>' attribute.
	 * @see #setRecordOutputs(boolean)
	 * @see ac.soton.multisim.MultisimPackage#getComponentDiagram_RecordOutputs()
	 * @model
	 * @generated
	 */
	boolean isRecordOutputs();

	/**
	 * Sets the value of the '{@link ac.soton.multisim.ComponentDiagram#isRecordOutputs <em>Record Outputs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Record Outputs</em>' attribute.
	 * @see #isRecordOutputs()
	 * @generated
	 */
	void setRecordOutputs(boolean value);

	/**
	 * Generates simulation status report.
	 * @return
	 * @custom
	 */
	String createStatusReport();

} // ComponentDiagram
