/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package ac.soton.multisim.impl;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.impl.EventBNamedCommentedElementImpl;

import ac.soton.multisim.FMUComponent;
import ac.soton.multisim.FMUParameter;
import ac.soton.multisim.MultisimPackage;
import ac.soton.multisim.Port;
import ac.soton.multisim.exception.ModelException;
import ac.soton.multisim.util.SimulationUtil;
import de.prob.cosimulation.FMU;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FMU Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.multisim.impl.FMUComponentImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link ac.soton.multisim.impl.FMUComponentImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link ac.soton.multisim.impl.FMUComponentImpl#getPath <em>Path</em>}</li>
 *   <li>{@link ac.soton.multisim.impl.FMUComponentImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link ac.soton.multisim.impl.FMUComponentImpl#getFmu <em>Fmu</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FMUComponentImpl extends EventBNamedCommentedElementImpl implements FMUComponent {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2015 University of Southampton.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html";

	/**
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> inputs;

	/**
	 * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputs()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> outputs;

	/**
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected String path = PATH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<FMUParameter> parameters;

	/**
	 * The default value of the '{@link #getFmu() <em>Fmu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFmu()
	 * @generated
	 * @ordered
	 */
	protected static final FMU FMU_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFmu() <em>Fmu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFmu()
	 * @generated
	 * @ordered
	 */
	protected FMU fmu = FMU_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FMUComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MultisimPackage.Literals.FMU_COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Port> getInputs() {
		if (inputs == null) {
			inputs = new EObjectContainmentEList.Resolving<Port>(Port.class, this, MultisimPackage.FMU_COMPONENT__INPUTS);
		}
		return inputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Port> getOutputs() {
		if (outputs == null) {
			outputs = new EObjectContainmentEList.Resolving<Port>(Port.class, this, MultisimPackage.FMU_COMPONENT__OUTPUTS);
		}
		return outputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath(String newPath) {
		String oldPath = path;
		path = newPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MultisimPackage.FMU_COMPONENT__PATH, oldPath, path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FMUParameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList.Resolving<FMUParameter>(FMUParameter.class, this, MultisimPackage.FMU_COMPONENT__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FMU getFmu() {
		return fmu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFmu(FMU newFmu) {
		FMU oldFmu = fmu;
		fmu = newFmu;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MultisimPackage.FMU_COMPONENT__FMU, oldFmu, fmu));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws ModelException 
	 * @generated NOT
	 */
	public void instantiate() throws ModelException {
		// disable notification
		for (Port p : getOutputs())
			p.eSetDeliver(false);
		
		// reuse FMU if possible
		if (fmu != null) {
			fmu.reset();
		} else {
			try {
				fmu = new FMU(getPath());
			} catch (IOException e) {
				throw new ModelException("Cannot load FMU file '" + getPath() + "':\n" + e.getMessage());
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void initialise(int tStart, int tStop) {
		// initialise parameters that have non-default values
		for (FMUParameter param : getParameters())
			SimulationUtil.fmiSet(fmu, param, param.getStartValue());
		
		// initialise FMU
		fmu.initialize(tStart/1000.0, tStop/1000.0);
		
		// update outputs
		for (Port p : getOutputs())
			p.setValue(SimulationUtil.fmiGet(fmu, p));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void readInputs() {
		for (Port port : getInputs()) {
			Port input = port.getIn();
			
			// skip port if not connected
			if (input == null) {
				continue;
			}
			
			SimulationUtil.fmiSet(fmu, port, input.getValue());
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void writeOutputs() {
		for (Port port : getOutputs()) {
			port.setValue(SimulationUtil.fmiGet(fmu, port));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void doStep(int time, int step) {
		fmu.doStep(time/1000.0, step/1000.0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void terminate() {
		// re-enable notification
		for (Port p : getOutputs())
			p.eSetDeliver(true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MultisimPackage.FMU_COMPONENT__INPUTS:
				return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
			case MultisimPackage.FMU_COMPONENT__OUTPUTS:
				return ((InternalEList<?>)getOutputs()).basicRemove(otherEnd, msgs);
			case MultisimPackage.FMU_COMPONENT__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MultisimPackage.FMU_COMPONENT__INPUTS:
				return getInputs();
			case MultisimPackage.FMU_COMPONENT__OUTPUTS:
				return getOutputs();
			case MultisimPackage.FMU_COMPONENT__PATH:
				return getPath();
			case MultisimPackage.FMU_COMPONENT__PARAMETERS:
				return getParameters();
			case MultisimPackage.FMU_COMPONENT__FMU:
				return getFmu();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MultisimPackage.FMU_COMPONENT__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends Port>)newValue);
				return;
			case MultisimPackage.FMU_COMPONENT__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends Port>)newValue);
				return;
			case MultisimPackage.FMU_COMPONENT__PATH:
				setPath((String)newValue);
				return;
			case MultisimPackage.FMU_COMPONENT__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends FMUParameter>)newValue);
				return;
			case MultisimPackage.FMU_COMPONENT__FMU:
				setFmu((FMU)newValue);
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
			case MultisimPackage.FMU_COMPONENT__INPUTS:
				getInputs().clear();
				return;
			case MultisimPackage.FMU_COMPONENT__OUTPUTS:
				getOutputs().clear();
				return;
			case MultisimPackage.FMU_COMPONENT__PATH:
				setPath(PATH_EDEFAULT);
				return;
			case MultisimPackage.FMU_COMPONENT__PARAMETERS:
				getParameters().clear();
				return;
			case MultisimPackage.FMU_COMPONENT__FMU:
				setFmu(FMU_EDEFAULT);
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
			case MultisimPackage.FMU_COMPONENT__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case MultisimPackage.FMU_COMPONENT__OUTPUTS:
				return outputs != null && !outputs.isEmpty();
			case MultisimPackage.FMU_COMPONENT__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
			case MultisimPackage.FMU_COMPONENT__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case MultisimPackage.FMU_COMPONENT__FMU:
				return FMU_EDEFAULT == null ? fmu != null : !FMU_EDEFAULT.equals(fmu);
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
		result.append(" (path: ");
		result.append(path);
		result.append(", fmu: ");
		result.append(fmu);
		result.append(')');
		return result.toString();
	}
	

	/**
	 * Override of {@link org.eventb.emf.core.impl.EventBNamedCommentedElementImpl.setName(String)}
	 * Removes the replacement of : and . characters in the name attribute.
	 * @custom
	 */
	public void setName(String newName) {
		if (newName == null) return;
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.EVENT_BNAMED_COMMENTED_ELEMENT__NAME, oldName, name));
	}

} //FMUComponentImpl
