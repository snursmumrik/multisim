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

import java.awt.Color;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import ac.soton.multisim.ComponentDiagram;
import ac.soton.multisim.DisplayComponent;
import ac.soton.multisim.DisplayPort;
import ac.soton.multisim.EventBComponent;
import ac.soton.multisim.EventBPort;
import ac.soton.multisim.FMUComponent;
import ac.soton.multisim.FMUParameter;
import ac.soton.multisim.FMUPort;
import ac.soton.multisim.MultisimFactory;
import ac.soton.multisim.MultisimPackage;
import ac.soton.multisim.VariableCausality;
import ac.soton.multisim.VariableType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MultisimFactoryImpl extends EFactoryImpl implements MultisimFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2014 University of Southampton.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MultisimFactory init() {
		try {
			MultisimFactory theMultisimFactory = (MultisimFactory)EPackage.Registry.INSTANCE.getEFactory("http://soton.ac.uk/models/multisim/2.0"); 
			if (theMultisimFactory != null) {
				return theMultisimFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MultisimFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultisimFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MultisimPackage.COMPONENT_DIAGRAM: return createComponentDiagram();
			case MultisimPackage.EVENT_BCOMPONENT: return createEventBComponent();
			case MultisimPackage.FMU_COMPONENT: return createFMUComponent();
			case MultisimPackage.FMU_PARAMETER: return createFMUParameter();
			case MultisimPackage.FMU_PORT: return createFMUPort();
			case MultisimPackage.EVENT_BPORT: return createEventBPort();
			case MultisimPackage.DISPLAY_COMPONENT: return createDisplayComponent();
			case MultisimPackage.DISPLAY_PORT: return createDisplayPort();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case MultisimPackage.VARIABLE_TYPE:
				return createVariableTypeFromString(eDataType, initialValue);
			case MultisimPackage.VARIABLE_CAUSALITY:
				return createVariableCausalityFromString(eDataType, initialValue);
			case MultisimPackage.COLOR:
				return createColorFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case MultisimPackage.VARIABLE_TYPE:
				return convertVariableTypeToString(eDataType, instanceValue);
			case MultisimPackage.VARIABLE_CAUSALITY:
				return convertVariableCausalityToString(eDataType, instanceValue);
			case MultisimPackage.COLOR:
				return convertColorToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentDiagram createComponentDiagram() {
		ComponentDiagramImpl componentDiagram = new ComponentDiagramImpl();
		return componentDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventBComponent createEventBComponent() {
		EventBComponentImpl eventBComponent = new EventBComponentImpl();
		return eventBComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FMUComponent createFMUComponent() {
		FMUComponentImpl fmuComponent = new FMUComponentImpl();
		return fmuComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FMUParameter createFMUParameter() {
		FMUParameterImpl fmuParameter = new FMUParameterImpl();
		return fmuParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FMUPort createFMUPort() {
		FMUPortImpl fmuPort = new FMUPortImpl();
		return fmuPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventBPort createEventBPort() {
		EventBPortImpl eventBPort = new EventBPortImpl();
		return eventBPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DisplayComponent createDisplayComponent() {
		DisplayComponentImpl displayComponent = new DisplayComponentImpl();
		return displayComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DisplayPort createDisplayPort() {
		DisplayPortImpl displayPort = new DisplayPortImpl();
		return displayPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableType createVariableTypeFromString(EDataType eDataType, String initialValue) {
		VariableType result = VariableType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVariableTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableCausality createVariableCausalityFromString(EDataType eDataType, String initialValue) {
		VariableCausality result = VariableCausality.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVariableCausalityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Color createColorFromString(EDataType eDataType, String initialValue) {
		return new Color(Integer.parseInt(initialValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertColorToString(EDataType eDataType, Object instanceValue) {
		return ((Color) instanceValue).getRGB() + "";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultisimPackage getMultisimPackage() {
		return (MultisimPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MultisimPackage getPackage() {
		return MultisimPackage.eINSTANCE;
	}

} //MultisimFactoryImpl
