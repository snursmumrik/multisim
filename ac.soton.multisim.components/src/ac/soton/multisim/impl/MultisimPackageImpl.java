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

import info.monitorenter.gui.chart.Chart2D;
import info.monitorenter.gui.chart.ITrace2D;

import java.awt.Color;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.machine.MachinePackage;

import ac.soton.multisim.AbstractVariable;
import ac.soton.multisim.Component;
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
import ac.soton.multisim.Port;
import ac.soton.multisim.VariableCausality;
import ac.soton.multisim.VariableType;
import ac.soton.multisim.exception.ModelException;
import ac.soton.multisim.exception.SimulationException;
import ac.soton.multisim.util.MultisimValidator;
import de.prob.statespace.Trace;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MultisimPackageImpl extends EPackageImpl implements MultisimPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2014 University of Southampton.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventBComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fmuComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fmuParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fmuPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventBPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass displayComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass displayPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum variableTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum variableCausalityEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iStatusEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType fmuEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iTrace2DEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType chart2DEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType colorEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType proBTraceEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType simulationExceptionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType modelExceptionEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see ac.soton.multisim.MultisimPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MultisimPackageImpl() {
		super(eNS_URI, MultisimFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link MultisimPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MultisimPackage init() {
		if (isInited) return (MultisimPackage)EPackage.Registry.INSTANCE.getEPackage(MultisimPackage.eNS_URI);

		// Obtain or create and register package
		MultisimPackageImpl theMultisimPackage = (MultisimPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MultisimPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MultisimPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theMultisimPackage.createPackageContents();

		// Initialize created meta-data
		theMultisimPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theMultisimPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return MultisimValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theMultisimPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MultisimPackage.eNS_URI, theMultisimPackage);
		return theMultisimPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentDiagram() {
		return componentDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentDiagram_Components() {
		return (EReference)componentDiagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentDiagram_StopTime() {
		return (EAttribute)componentDiagramEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentDiagram_StartTime() {
		return (EAttribute)componentDiagramEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentDiagram_StepSize() {
		return (EAttribute)componentDiagramEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentDiagram_Arguments() {
		return (EAttribute)componentDiagramEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentDiagram_RecordTrace() {
		return (EAttribute)componentDiagramEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponent() {
		return componentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_Inputs() {
		return (EReference)componentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_Outputs() {
		return (EReference)componentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponent_StepPeriod() {
		return (EAttribute)componentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventBComponent() {
		return eventBComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventBComponent_Machine() {
		return (EReference)eventBComponentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventBComponent_Composed() {
		return (EAttribute)eventBComponentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventBComponent_ReadInputEvents() {
		return (EReference)eventBComponentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventBComponent_WaitEvents() {
		return (EReference)eventBComponentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventBComponent_Trace() {
		return (EAttribute)eventBComponentEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFMUComponent() {
		return fmuComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMUComponent_Path() {
		return (EAttribute)fmuComponentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFMUComponent_Parameters() {
		return (EReference)fmuComponentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMUComponent_Fmu() {
		return (EAttribute)fmuComponentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPort() {
		return portEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPort_In() {
		return (EReference)portEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPort_Out() {
		return (EReference)portEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractVariable() {
		return abstractVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractVariable_Type() {
		return (EAttribute)abstractVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractVariable_Causality() {
		return (EAttribute)abstractVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractVariable_Value() {
		return (EAttribute)abstractVariableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractVariable_Description() {
		return (EAttribute)abstractVariableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFMUParameter() {
		return fmuParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMUParameter_DefaultValue() {
		return (EAttribute)fmuParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFMUParameter_StartValue() {
		return (EAttribute)fmuParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFMUPort() {
		return fmuPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventBPort() {
		return eventBPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventBPort_Parameter() {
		return (EReference)eventBPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventBPort_Variable() {
		return (EReference)eventBPortEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventBPort_IntToReal() {
		return (EAttribute)eventBPortEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDisplayComponent() {
		return displayComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDisplayComponent_Chart() {
		return (EAttribute)displayComponentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDisplayPort() {
		return displayPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDisplayPort_Trace() {
		return (EAttribute)displayPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDisplayPort_Color() {
		return (EAttribute)displayPortEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVariableType() {
		return variableTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVariableCausality() {
		return variableCausalityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIStatus() {
		return iStatusEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getFMU() {
		return fmuEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getITrace2D() {
		return iTrace2DEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getChart2D() {
		return chart2DEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getColor() {
		return colorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getProBTrace() {
		return proBTraceEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSimulationException() {
		return simulationExceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getModelException() {
		return modelExceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultisimFactory getMultisimFactory() {
		return (MultisimFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		componentDiagramEClass = createEClass(COMPONENT_DIAGRAM);
		createEReference(componentDiagramEClass, COMPONENT_DIAGRAM__COMPONENTS);
		createEAttribute(componentDiagramEClass, COMPONENT_DIAGRAM__STOP_TIME);
		createEAttribute(componentDiagramEClass, COMPONENT_DIAGRAM__START_TIME);
		createEAttribute(componentDiagramEClass, COMPONENT_DIAGRAM__STEP_SIZE);
		createEAttribute(componentDiagramEClass, COMPONENT_DIAGRAM__ARGUMENTS);
		createEAttribute(componentDiagramEClass, COMPONENT_DIAGRAM__RECORD_TRACE);

		componentEClass = createEClass(COMPONENT);
		createEReference(componentEClass, COMPONENT__INPUTS);
		createEReference(componentEClass, COMPONENT__OUTPUTS);
		createEAttribute(componentEClass, COMPONENT__STEP_PERIOD);

		eventBComponentEClass = createEClass(EVENT_BCOMPONENT);
		createEReference(eventBComponentEClass, EVENT_BCOMPONENT__MACHINE);
		createEAttribute(eventBComponentEClass, EVENT_BCOMPONENT__COMPOSED);
		createEReference(eventBComponentEClass, EVENT_BCOMPONENT__READ_INPUT_EVENTS);
		createEReference(eventBComponentEClass, EVENT_BCOMPONENT__WAIT_EVENTS);
		createEAttribute(eventBComponentEClass, EVENT_BCOMPONENT__TRACE);

		fmuComponentEClass = createEClass(FMU_COMPONENT);
		createEAttribute(fmuComponentEClass, FMU_COMPONENT__PATH);
		createEReference(fmuComponentEClass, FMU_COMPONENT__PARAMETERS);
		createEAttribute(fmuComponentEClass, FMU_COMPONENT__FMU);

		portEClass = createEClass(PORT);
		createEReference(portEClass, PORT__IN);
		createEReference(portEClass, PORT__OUT);

		abstractVariableEClass = createEClass(ABSTRACT_VARIABLE);
		createEAttribute(abstractVariableEClass, ABSTRACT_VARIABLE__TYPE);
		createEAttribute(abstractVariableEClass, ABSTRACT_VARIABLE__CAUSALITY);
		createEAttribute(abstractVariableEClass, ABSTRACT_VARIABLE__VALUE);
		createEAttribute(abstractVariableEClass, ABSTRACT_VARIABLE__DESCRIPTION);

		fmuParameterEClass = createEClass(FMU_PARAMETER);
		createEAttribute(fmuParameterEClass, FMU_PARAMETER__DEFAULT_VALUE);
		createEAttribute(fmuParameterEClass, FMU_PARAMETER__START_VALUE);

		fmuPortEClass = createEClass(FMU_PORT);

		eventBPortEClass = createEClass(EVENT_BPORT);
		createEReference(eventBPortEClass, EVENT_BPORT__PARAMETER);
		createEReference(eventBPortEClass, EVENT_BPORT__VARIABLE);
		createEAttribute(eventBPortEClass, EVENT_BPORT__INT_TO_REAL);

		displayComponentEClass = createEClass(DISPLAY_COMPONENT);
		createEAttribute(displayComponentEClass, DISPLAY_COMPONENT__CHART);

		displayPortEClass = createEClass(DISPLAY_PORT);
		createEAttribute(displayPortEClass, DISPLAY_PORT__TRACE);
		createEAttribute(displayPortEClass, DISPLAY_PORT__COLOR);

		// Create enums
		variableTypeEEnum = createEEnum(VARIABLE_TYPE);
		variableCausalityEEnum = createEEnum(VARIABLE_CAUSALITY);

		// Create data types
		iStatusEDataType = createEDataType(ISTATUS);
		fmuEDataType = createEDataType(FMU);
		iTrace2DEDataType = createEDataType(ITRACE2_D);
		chart2DEDataType = createEDataType(CHART2_D);
		colorEDataType = createEDataType(COLOR);
		proBTraceEDataType = createEDataType(PRO_BTRACE);
		simulationExceptionEDataType = createEDataType(SIMULATION_EXCEPTION);
		modelExceptionEDataType = createEDataType(MODEL_EXCEPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		MachinePackage theMachinePackage = (MachinePackage)EPackage.Registry.INSTANCE.getEPackage(MachinePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		componentDiagramEClass.getESuperTypes().add(theCorePackage.getEventBNamed());
		componentEClass.getESuperTypes().add(theCorePackage.getEventBNamed());
		eventBComponentEClass.getESuperTypes().add(theCorePackage.getAbstractExtension());
		eventBComponentEClass.getESuperTypes().add(this.getComponent());
		fmuComponentEClass.getESuperTypes().add(this.getComponent());
		portEClass.getESuperTypes().add(this.getAbstractVariable());
		abstractVariableEClass.getESuperTypes().add(theCorePackage.getEventBNamed());
		fmuParameterEClass.getESuperTypes().add(this.getAbstractVariable());
		fmuPortEClass.getESuperTypes().add(this.getPort());
		eventBPortEClass.getESuperTypes().add(this.getPort());
		displayComponentEClass.getESuperTypes().add(this.getComponent());
		displayPortEClass.getESuperTypes().add(this.getPort());

		// Initialize classes and features; add operations and parameters
		initEClass(componentDiagramEClass, ComponentDiagram.class, "ComponentDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentDiagram_Components(), this.getComponent(), null, "components", null, 0, -1, ComponentDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentDiagram_StopTime(), ecorePackage.getEInt(), "stopTime", null, 0, 1, ComponentDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentDiagram_StartTime(), ecorePackage.getEInt(), "startTime", null, 0, 1, ComponentDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentDiagram_StepSize(), theEcorePackage.getEInt(), "stepSize", null, 0, 1, ComponentDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentDiagram_Arguments(), ecorePackage.getEString(), "arguments", null, 0, 1, ComponentDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentDiagram_RecordTrace(), ecorePackage.getEBoolean(), "recordTrace", null, 0, 1, ComponentDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(componentEClass, Component.class, "Component", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponent_Inputs(), this.getPort(), null, "inputs", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_Outputs(), this.getPort(), null, "outputs", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponent_StepPeriod(), ecorePackage.getEInt(), "stepPeriod", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(componentEClass, null, "instantiate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getSimulationException());
		addEException(op, this.getModelException());

		op = addEOperation(componentEClass, null, "initialise", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEInt(), "tStart", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEInt(), "tStop", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getSimulationException());

		op = addEOperation(componentEClass, null, "readInputs", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getSimulationException());
		addEException(op, this.getModelException());

		addEOperation(componentEClass, null, "writeOutputs", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(componentEClass, null, "doStep", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEInt(), "time", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEInt(), "step", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getSimulationException());
		addEException(op, this.getModelException());

		addEOperation(componentEClass, null, "terminate", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(eventBComponentEClass, EventBComponent.class, "EventBComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEventBComponent_Machine(), theMachinePackage.getMachine(), null, "machine", null, 1, 1, EventBComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEventBComponent_Composed(), ecorePackage.getEBoolean(), "composed", null, 1, 1, EventBComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEventBComponent_ReadInputEvents(), theMachinePackage.getEvent(), null, "readInputEvents", null, 0, -1, EventBComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEventBComponent_WaitEvents(), theMachinePackage.getEvent(), null, "waitEvents", null, 1, -1, EventBComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEventBComponent_Trace(), this.getProBTrace(), "trace", null, 0, 1, EventBComponent.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fmuComponentEClass, FMUComponent.class, "FMUComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFMUComponent_Path(), ecorePackage.getEString(), "path", null, 1, 1, FMUComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFMUComponent_Parameters(), this.getFMUParameter(), null, "parameters", null, 0, -1, FMUComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFMUComponent_Fmu(), this.getFMU(), "fmu", null, 0, 1, FMUComponent.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(portEClass, Port.class, "Port", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPort_In(), this.getPort(), this.getPort_Out(), "in", null, 0, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPort_Out(), this.getPort(), this.getPort_In(), "out", null, 0, -1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractVariableEClass, AbstractVariable.class, "AbstractVariable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractVariable_Type(), this.getVariableType(), "type", null, 1, 1, AbstractVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractVariable_Causality(), this.getVariableCausality(), "causality", null, 1, 1, AbstractVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractVariable_Value(), ecorePackage.getEJavaObject(), "value", null, 0, 1, AbstractVariable.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractVariable_Description(), ecorePackage.getEString(), "description", null, 0, 1, AbstractVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fmuParameterEClass, FMUParameter.class, "FMUParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFMUParameter_DefaultValue(), ecorePackage.getEJavaObject(), "defaultValue", null, 0, 1, FMUParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFMUParameter_StartValue(), ecorePackage.getEJavaObject(), "startValue", null, 0, 1, FMUParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fmuPortEClass, FMUPort.class, "FMUPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eventBPortEClass, EventBPort.class, "EventBPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEventBPort_Parameter(), theMachinePackage.getParameter(), null, "parameter", null, 0, 1, EventBPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEventBPort_Variable(), theMachinePackage.getVariable(), null, "variable", null, 0, 1, EventBPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEventBPort_IntToReal(), ecorePackage.getEInt(), "intToReal", null, 0, 1, EventBPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(displayComponentEClass, DisplayComponent.class, "DisplayComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDisplayComponent_Chart(), this.getChart2D(), "chart", null, 0, 1, DisplayComponent.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(displayPortEClass, DisplayPort.class, "DisplayPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDisplayPort_Trace(), this.getITrace2D(), "trace", null, 0, 1, DisplayPort.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDisplayPort_Color(), this.getColor(), "color", null, 0, 1, DisplayPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(variableTypeEEnum, VariableType.class, "VariableType");
		addEEnumLiteral(variableTypeEEnum, VariableType.REAL);
		addEEnumLiteral(variableTypeEEnum, VariableType.INTEGER);
		addEEnumLiteral(variableTypeEEnum, VariableType.BOOLEAN);
		addEEnumLiteral(variableTypeEEnum, VariableType.STRING);

		initEEnum(variableCausalityEEnum, VariableCausality.class, "VariableCausality");
		addEEnumLiteral(variableCausalityEEnum, VariableCausality.INPUT);
		addEEnumLiteral(variableCausalityEEnum, VariableCausality.OUTPUT);
		addEEnumLiteral(variableCausalityEEnum, VariableCausality.INTERNAL);
		addEEnumLiteral(variableCausalityEEnum, VariableCausality.NONE);

		// Initialize data types
		initEDataType(iStatusEDataType, IStatus.class, "IStatus", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(fmuEDataType, de.prob.cosimulation.FMU.class, "FMU", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(iTrace2DEDataType, ITrace2D.class, "ITrace2D", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(chart2DEDataType, Chart2D.class, "Chart2D", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(colorEDataType, Color.class, "Color", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(proBTraceEDataType, Trace.class, "ProBTrace", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(simulationExceptionEDataType, SimulationException.class, "SimulationException", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(modelExceptionEDataType, ModelException.class, "ModelException", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// org.eventb.emf.core.extendedMetaClasses
		createOrgAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";		
		addAnnotation
		  (componentDiagramEClass, 
		   source, 
		   new String[] {
			 "constraints", "noDirectFMU"
		   });			
		addAnnotation
		  (eventBComponentEClass, 
		   source, 
		   new String[] {
			 "constraints", "consistentReadEvents\nvalidMachineReference"
		   });		
		addAnnotation
		  (fmuComponentEClass, 
		   source, 
		   new String[] {
			 "constraints", "validPath"
		   });		
		addAnnotation
		  (portEClass, 
		   source, 
		   new String[] {
			 "constraints", "compatibleType"
		   });		
		addAnnotation
		  (fmuPortEClass, 
		   source, 
		   new String[] {
			 "constraints", "validFMUReference"
		   });		
		addAnnotation
		  (eventBPortEClass, 
		   source, 
		   new String[] {
			 "constraints", "validEventBReference"
		   });		
		addAnnotation
		  (displayPortEClass, 
		   source, 
		   new String[] {
			 "constraints", "nonStringInput"
		   });
	}

	/**
	 * Initializes the annotations for <b>org.eventb.emf.core.extendedMetaClasses</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createOrgAnnotations() {
		String source = "org.eventb.emf.core.extendedMetaClasses";			
		addAnnotation
		  (eventBComponentEClass, 
		   source, 
		   new String[] {
		   },
		   new URI[] {
			 URI.createURI(CorePackage.eNS_URI).appendFragment("//machine/Machine")
		   });						
	}

} //MultisimPackageImpl
