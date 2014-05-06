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

import de.prob.cosimulation.FMU;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FMU Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.rms.components.FMUComponent#getPath <em>Path</em>}</li>
 *   <li>{@link ac.soton.rms.components.FMUComponent#getParameters <em>Parameters</em>}</li>
 *   <li>{@link ac.soton.rms.components.FMUComponent#getFmu <em>Fmu</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.rms.components.ComponentsPackage#getFMUComponent()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='validPath'"
 * @generated
 */
public interface FMUComponent extends Component {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2014 University of Southampton.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html";

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see ac.soton.rms.components.ComponentsPackage#getFMUComponent_Path()
	 * @model required="true"
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link ac.soton.rms.components.FMUComponent#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' reference list.
	 * The list contents are of type {@link ac.soton.rms.components.FMUParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' reference list.
	 * @see ac.soton.rms.components.ComponentsPackage#getFMUComponent_Parameters()
	 * @model
	 * @generated
	 */
	EList<FMUParameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Fmu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fmu</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fmu</em>' attribute.
	 * @see #setFmu(FMU)
	 * @see ac.soton.rms.components.ComponentsPackage#getFMUComponent_Fmu()
	 * @model dataType="ac.soton.rms.components.FMU" transient="true"
	 * @generated
	 */
	FMU getFmu();

	/**
	 * Sets the value of the '{@link ac.soton.rms.components.FMUComponent#getFmu <em>Fmu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fmu</em>' attribute.
	 * @see #getFmu()
	 * @generated
	 */
	void setFmu(FMU value);

} // FMUComponent
