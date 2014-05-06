/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package ac.soton.rms.components.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.ptolemy.fmi.FMIScalarVariable;

import ac.soton.rms.components.ComponentsPackage;
import ac.soton.rms.components.FMUPort;
import org.eclipse.emf.common.notify.Notification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FMU Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.rms.components.impl.FMUPortImpl#getFmiScalarVar <em>Fmi Scalar Var</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FMUPortImpl extends PortImpl implements FMUPort {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2014 University of Southampton.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html";

	/**
	 * The default value of the '{@link #getFmiScalarVar() <em>Fmi Scalar Var</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFmiScalarVar()
	 * @generated
	 * @ordered
	 */
	protected static final FMIScalarVariable FMI_SCALAR_VAR_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getFmiScalarVar() <em>Fmi Scalar Var</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFmiScalarVar()
	 * @generated
	 * @ordered
	 */
	protected FMIScalarVariable fmiScalarVar = FMI_SCALAR_VAR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FMUPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentsPackage.Literals.FMU_PORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FMIScalarVariable getFmiScalarVar() {
		return fmiScalarVar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFmiScalarVar(FMIScalarVariable newFmiScalarVar) {
		FMIScalarVariable oldFmiScalarVar = fmiScalarVar;
		fmiScalarVar = newFmiScalarVar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.FMU_PORT__FMI_SCALAR_VAR, oldFmiScalarVar, fmiScalarVar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentsPackage.FMU_PORT__FMI_SCALAR_VAR:
				return getFmiScalarVar();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ComponentsPackage.FMU_PORT__FMI_SCALAR_VAR:
				setFmiScalarVar((FMIScalarVariable)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ComponentsPackage.FMU_PORT__FMI_SCALAR_VAR:
				setFmiScalarVar(FMI_SCALAR_VAR_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ComponentsPackage.FMU_PORT__FMI_SCALAR_VAR:
				return FMI_SCALAR_VAR_EDEFAULT == null ? fmiScalarVar != null : !FMI_SCALAR_VAR_EDEFAULT.equals(fmiScalarVar);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (fmiScalarVar: ");
		result.append(fmiScalarVar);
		result.append(')');
		return result.toString();
	}

	@Override
	public String getLabel() {
		FMIScalarVariable var = getFmiScalarVar();
		assert var != null;
		return var.name;
	}

} //FMUPortImpl
