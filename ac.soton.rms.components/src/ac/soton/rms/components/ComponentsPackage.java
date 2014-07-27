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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eventb.emf.core.CorePackage;

import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see ac.soton.rms.components.ComponentsFactory
 * @model kind="package"
 * @generated
 */
public interface ComponentsPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2014 University of Southampton.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "components";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://soton.ac.uk/models/components/2.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "components";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ComponentsPackage eINSTANCE = ac.soton.rms.components.impl.ComponentsPackageImpl.init();

	/**
	 * The meta object id for the '{@link ac.soton.rms.components.impl.ComponentDiagramImpl <em>Component Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.rms.components.impl.ComponentDiagramImpl
	 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getComponentDiagram()
	 * @generated
	 */
	int COMPONENT_DIAGRAM = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__NAME = CorePackage.EVENT_BNAMED__NAME;

	/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__COMPONENTS = CorePackage.EVENT_BNAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stop Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__STOP_TIME = CorePackage.EVENT_BNAMED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__START_TIME = CorePackage.EVENT_BNAMED_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Component Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM_FEATURE_COUNT = CorePackage.EVENT_BNAMED_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link ac.soton.rms.components.Component <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.rms.components.Component
	 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 1;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__LABEL = CoreextensionPackage.EVENT_BLABELED__LABEL;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__INPUTS = CoreextensionPackage.EVENT_BLABELED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__OUTPUTS = CoreextensionPackage.EVENT_BLABELED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__VARIABLES = CoreextensionPackage.EVENT_BLABELED_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = CoreextensionPackage.EVENT_BLABELED_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link ac.soton.rms.components.impl.EventBComponentImpl <em>Event BComponent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.rms.components.impl.EventBComponentImpl
	 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getEventBComponent()
	 * @generated
	 */
	int EVENT_BCOMPONENT = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__ANNOTATIONS = CorePackage.ABSTRACT_EXTENSION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__EXTENSIONS = CorePackage.ABSTRACT_EXTENSION__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__ATTRIBUTES = CorePackage.ABSTRACT_EXTENSION__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__REFERENCE = CorePackage.ABSTRACT_EXTENSION__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__GENERATED = CorePackage.ABSTRACT_EXTENSION__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__LOCAL_GENERATED = CorePackage.ABSTRACT_EXTENSION__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__INTERNAL_ID = CorePackage.ABSTRACT_EXTENSION__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Extension Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__EXTENSION_ID = CorePackage.ABSTRACT_EXTENSION__EXTENSION_ID;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__LABEL = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__INPUTS = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__OUTPUTS = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__VARIABLES = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__MACHINE = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Composed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__COMPOSED = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Trace File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__TRACE_FILE_PATH = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Read Input Events</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__READ_INPUT_EVENTS = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Wait Events</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__WAIT_EVENTS = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Check Invariants</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__CHECK_INVARIANTS = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Compare Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__COMPARE_TRACE = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Record Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__RECORD_TRACE = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__TRACE = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Step Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__STEP_PERIOD = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 13;

	/**
	 * The number of structural features of the '<em>Event BComponent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT_FEATURE_COUNT = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 14;

	/**
	 * The meta object id for the '{@link ac.soton.rms.components.impl.FMUComponentImpl <em>FMU Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.rms.components.impl.FMUComponentImpl
	 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getFMUComponent()
	 * @generated
	 */
	int FMU_COMPONENT = 3;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_COMPONENT__LABEL = COMPONENT__LABEL;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_COMPONENT__INPUTS = COMPONENT__INPUTS;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_COMPONENT__OUTPUTS = COMPONENT__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_COMPONENT__VARIABLES = COMPONENT__VARIABLES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_COMPONENT__NAME = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_COMPONENT__PATH = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_COMPONENT__PARAMETERS = COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Fmu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_COMPONENT__FMU = COMPONENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>FMU Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_COMPONENT_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link ac.soton.rms.components.impl.AbstractVariableImpl <em>Abstract Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.rms.components.impl.AbstractVariableImpl
	 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getAbstractVariable()
	 * @generated
	 */
	int ABSTRACT_VARIABLE = 5;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE__LABEL = CoreextensionPackage.EVENT_BLABELED__LABEL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE__TYPE = CoreextensionPackage.EVENT_BLABELED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Causality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE__CAUSALITY = CoreextensionPackage.EVENT_BLABELED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE__VALUE = CoreextensionPackage.EVENT_BLABELED_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE__DESCRIPTION = CoreextensionPackage.EVENT_BLABELED_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Abstract Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE_FEATURE_COUNT = CoreextensionPackage.EVENT_BLABELED_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link ac.soton.rms.components.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.rms.components.impl.PortImpl
	 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 4;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__LABEL = ABSTRACT_VARIABLE__LABEL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__TYPE = ABSTRACT_VARIABLE__TYPE;

	/**
	 * The feature id for the '<em><b>Causality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__CAUSALITY = ABSTRACT_VARIABLE__CAUSALITY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__VALUE = ABSTRACT_VARIABLE__VALUE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__DESCRIPTION = ABSTRACT_VARIABLE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__IN = ABSTRACT_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Out</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__OUT = ABSTRACT_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = ABSTRACT_VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ac.soton.rms.components.impl.FMUVariableImpl <em>FMU Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.rms.components.impl.FMUVariableImpl
	 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getFMUVariable()
	 * @generated
	 */
	int FMU_VARIABLE = 6;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_VARIABLE__LABEL = ABSTRACT_VARIABLE__LABEL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_VARIABLE__TYPE = ABSTRACT_VARIABLE__TYPE;

	/**
	 * The feature id for the '<em><b>Causality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_VARIABLE__CAUSALITY = ABSTRACT_VARIABLE__CAUSALITY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_VARIABLE__VALUE = ABSTRACT_VARIABLE__VALUE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_VARIABLE__DESCRIPTION = ABSTRACT_VARIABLE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_VARIABLE__NAME = ABSTRACT_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>FMU Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_VARIABLE_FEATURE_COUNT = ABSTRACT_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ac.soton.rms.components.impl.EventBVariableImpl <em>Event BVariable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.rms.components.impl.EventBVariableImpl
	 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getEventBVariable()
	 * @generated
	 */
	int EVENT_BVARIABLE = 7;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BVARIABLE__LABEL = ABSTRACT_VARIABLE__LABEL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BVARIABLE__TYPE = ABSTRACT_VARIABLE__TYPE;

	/**
	 * The feature id for the '<em><b>Causality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BVARIABLE__CAUSALITY = ABSTRACT_VARIABLE__CAUSALITY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BVARIABLE__VALUE = ABSTRACT_VARIABLE__VALUE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BVARIABLE__DESCRIPTION = ABSTRACT_VARIABLE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BVARIABLE__VARIABLE = ABSTRACT_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Event BVariable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BVARIABLE_FEATURE_COUNT = ABSTRACT_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ac.soton.rms.components.impl.FMUParameterImpl <em>FMU Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.rms.components.impl.FMUParameterImpl
	 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getFMUParameter()
	 * @generated
	 */
	int FMU_PARAMETER = 8;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PARAMETER__LABEL = FMU_VARIABLE__LABEL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PARAMETER__TYPE = FMU_VARIABLE__TYPE;

	/**
	 * The feature id for the '<em><b>Causality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PARAMETER__CAUSALITY = FMU_VARIABLE__CAUSALITY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PARAMETER__VALUE = FMU_VARIABLE__VALUE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PARAMETER__DESCRIPTION = FMU_VARIABLE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PARAMETER__NAME = FMU_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PARAMETER__DEFAULT_VALUE = FMU_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Start Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PARAMETER__START_VALUE = FMU_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>FMU Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PARAMETER_FEATURE_COUNT = FMU_VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ac.soton.rms.components.impl.FMUPortImpl <em>FMU Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.rms.components.impl.FMUPortImpl
	 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getFMUPort()
	 * @generated
	 */
	int FMU_PORT = 9;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PORT__LABEL = PORT__LABEL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PORT__TYPE = PORT__TYPE;

	/**
	 * The feature id for the '<em><b>Causality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PORT__CAUSALITY = PORT__CAUSALITY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PORT__VALUE = PORT__VALUE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PORT__DESCRIPTION = PORT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PORT__IN = PORT__IN;

	/**
	 * The feature id for the '<em><b>Out</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PORT__OUT = PORT__OUT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PORT__NAME = PORT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>FMU Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ac.soton.rms.components.impl.EventBPortImpl <em>Event BPort</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.rms.components.impl.EventBPortImpl
	 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getEventBPort()
	 * @generated
	 */
	int EVENT_BPORT = 10;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT__LABEL = PORT__LABEL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT__TYPE = PORT__TYPE;

	/**
	 * The feature id for the '<em><b>Causality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT__CAUSALITY = PORT__CAUSALITY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT__VALUE = PORT__VALUE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT__DESCRIPTION = PORT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT__IN = PORT__IN;

	/**
	 * The feature id for the '<em><b>Out</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT__OUT = PORT__OUT;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT__PARAMETER = PORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT__VARIABLE = PORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Int To Real</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT__INT_TO_REAL = PORT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Event BPort</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link ac.soton.rms.components.impl.DisplayComponentImpl <em>Display Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.rms.components.impl.DisplayComponentImpl
	 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getDisplayComponent()
	 * @generated
	 */
	int DISPLAY_COMPONENT = 11;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_COMPONENT__LABEL = COMPONENT__LABEL;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_COMPONENT__INPUTS = COMPONENT__INPUTS;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_COMPONENT__OUTPUTS = COMPONENT__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_COMPONENT__VARIABLES = COMPONENT__VARIABLES;

	/**
	 * The feature id for the '<em><b>Chart</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_COMPONENT__CHART = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Display Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_COMPONENT_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ac.soton.rms.components.impl.DisplayPortImpl <em>Display Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.rms.components.impl.DisplayPortImpl
	 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getDisplayPort()
	 * @generated
	 */
	int DISPLAY_PORT = 12;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_PORT__LABEL = PORT__LABEL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_PORT__TYPE = PORT__TYPE;

	/**
	 * The feature id for the '<em><b>Causality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_PORT__CAUSALITY = PORT__CAUSALITY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_PORT__VALUE = PORT__VALUE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_PORT__DESCRIPTION = PORT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_PORT__IN = PORT__IN;

	/**
	 * The feature id for the '<em><b>Out</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_PORT__OUT = PORT__OUT;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_PORT__TRACE = PORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_PORT__COLOR = PORT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Display Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ac.soton.rms.components.VariableType <em>Variable Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.rms.components.VariableType
	 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getVariableType()
	 * @generated
	 */
	int VARIABLE_TYPE = 13;

	/**
	 * The meta object id for the '{@link ac.soton.rms.components.VariableCausality <em>Variable Causality</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.rms.components.VariableCausality
	 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getVariableCausality()
	 * @generated
	 */
	int VARIABLE_CAUSALITY = 14;


	/**
	 * The meta object id for the '<em>IStatus</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.runtime.IStatus
	 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getIStatus()
	 * @generated
	 */
	int ISTATUS = 15;

	/**
	 * The meta object id for the '<em>FMU</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.prob.cosimulation.FMU
	 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getFMU()
	 * @generated
	 */
	int FMU = 16;

	/**
	 * The meta object id for the '<em>ITrace2 D</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see info.monitorenter.gui.chart.ITrace2D
	 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getITrace2D()
	 * @generated
	 */
	int ITRACE2_D = 17;

	/**
	 * The meta object id for the '<em>Chart2 D</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see info.monitorenter.gui.chart.Chart2D
	 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getChart2D()
	 * @generated
	 */
	int CHART2_D = 18;

	/**
	 * The meta object id for the '<em>Color</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.awt.Color
	 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getColor()
	 * @generated
	 */
	int COLOR = 19;

	/**
	 * The meta object id for the '<em>Pro BTrace</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.prob.statespace.Trace
	 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getProBTrace()
	 * @generated
	 */
	int PRO_BTRACE = 20;

	/**
	 * Default RMS components extension ID.
	 * @custom
	 */
	public static final String COMPONENTS_EXTENSION_ID = "ac.soton.rms.components";

	/**
	 * Returns the meta object for class '{@link ac.soton.rms.components.ComponentDiagram <em>Component Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Diagram</em>'.
	 * @see ac.soton.rms.components.ComponentDiagram
	 * @generated
	 */
	EClass getComponentDiagram();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.rms.components.ComponentDiagram#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see ac.soton.rms.components.ComponentDiagram#getComponents()
	 * @see #getComponentDiagram()
	 * @generated
	 */
	EReference getComponentDiagram_Components();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.rms.components.ComponentDiagram#getStopTime <em>Stop Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stop Time</em>'.
	 * @see ac.soton.rms.components.ComponentDiagram#getStopTime()
	 * @see #getComponentDiagram()
	 * @generated
	 */
	EAttribute getComponentDiagram_StopTime();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.rms.components.ComponentDiagram#getStartTime <em>Start Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Time</em>'.
	 * @see ac.soton.rms.components.ComponentDiagram#getStartTime()
	 * @see #getComponentDiagram()
	 * @generated
	 */
	EAttribute getComponentDiagram_StartTime();

	/**
	 * Returns the meta object for class '{@link ac.soton.rms.components.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see ac.soton.rms.components.Component
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.rms.components.Component#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inputs</em>'.
	 * @see ac.soton.rms.components.Component#getInputs()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Inputs();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.rms.components.Component#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outputs</em>'.
	 * @see ac.soton.rms.components.Component#getOutputs()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Outputs();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.rms.components.Component#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see ac.soton.rms.components.Component#getVariables()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Variables();

	/**
	 * Returns the meta object for class '{@link ac.soton.rms.components.EventBComponent <em>Event BComponent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event BComponent</em>'.
	 * @see ac.soton.rms.components.EventBComponent
	 * @generated
	 */
	EClass getEventBComponent();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.rms.components.EventBComponent#getMachine <em>Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Machine</em>'.
	 * @see ac.soton.rms.components.EventBComponent#getMachine()
	 * @see #getEventBComponent()
	 * @generated
	 */
	EReference getEventBComponent_Machine();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.rms.components.EventBComponent#isComposed <em>Composed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Composed</em>'.
	 * @see ac.soton.rms.components.EventBComponent#isComposed()
	 * @see #getEventBComponent()
	 * @generated
	 */
	EAttribute getEventBComponent_Composed();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.rms.components.EventBComponent#getTraceFilePath <em>Trace File Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trace File Path</em>'.
	 * @see ac.soton.rms.components.EventBComponent#getTraceFilePath()
	 * @see #getEventBComponent()
	 * @generated
	 */
	EAttribute getEventBComponent_TraceFilePath();

	/**
	 * Returns the meta object for the reference list '{@link ac.soton.rms.components.EventBComponent#getReadInputEvents <em>Read Input Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Read Input Events</em>'.
	 * @see ac.soton.rms.components.EventBComponent#getReadInputEvents()
	 * @see #getEventBComponent()
	 * @generated
	 */
	EReference getEventBComponent_ReadInputEvents();

	/**
	 * Returns the meta object for the reference list '{@link ac.soton.rms.components.EventBComponent#getWaitEvents <em>Wait Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Wait Events</em>'.
	 * @see ac.soton.rms.components.EventBComponent#getWaitEvents()
	 * @see #getEventBComponent()
	 * @generated
	 */
	EReference getEventBComponent_WaitEvents();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.rms.components.EventBComponent#getStepPeriod <em>Step Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step Period</em>'.
	 * @see ac.soton.rms.components.EventBComponent#getStepPeriod()
	 * @see #getEventBComponent()
	 * @generated
	 */
	EAttribute getEventBComponent_StepPeriod();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.rms.components.EventBComponent#isCheckInvariants <em>Check Invariants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Check Invariants</em>'.
	 * @see ac.soton.rms.components.EventBComponent#isCheckInvariants()
	 * @see #getEventBComponent()
	 * @generated
	 */
	EAttribute getEventBComponent_CheckInvariants();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.rms.components.EventBComponent#isCompareTrace <em>Compare Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Compare Trace</em>'.
	 * @see ac.soton.rms.components.EventBComponent#isCompareTrace()
	 * @see #getEventBComponent()
	 * @generated
	 */
	EAttribute getEventBComponent_CompareTrace();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.rms.components.EventBComponent#isRecordTrace <em>Record Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Record Trace</em>'.
	 * @see ac.soton.rms.components.EventBComponent#isRecordTrace()
	 * @see #getEventBComponent()
	 * @generated
	 */
	EAttribute getEventBComponent_RecordTrace();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.rms.components.EventBComponent#getTrace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trace</em>'.
	 * @see ac.soton.rms.components.EventBComponent#getTrace()
	 * @see #getEventBComponent()
	 * @generated
	 */
	EAttribute getEventBComponent_Trace();

	/**
	 * Returns the meta object for class '{@link ac.soton.rms.components.FMUComponent <em>FMU Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FMU Component</em>'.
	 * @see ac.soton.rms.components.FMUComponent
	 * @generated
	 */
	EClass getFMUComponent();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.rms.components.FMUComponent#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see ac.soton.rms.components.FMUComponent#getPath()
	 * @see #getFMUComponent()
	 * @generated
	 */
	EAttribute getFMUComponent_Path();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.rms.components.FMUComponent#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see ac.soton.rms.components.FMUComponent#getParameters()
	 * @see #getFMUComponent()
	 * @generated
	 */
	EReference getFMUComponent_Parameters();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.rms.components.FMUComponent#getFmu <em>Fmu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fmu</em>'.
	 * @see ac.soton.rms.components.FMUComponent#getFmu()
	 * @see #getFMUComponent()
	 * @generated
	 */
	EAttribute getFMUComponent_Fmu();

	/**
	 * Returns the meta object for class '{@link ac.soton.rms.components.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see ac.soton.rms.components.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.rms.components.Port#getIn <em>In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>In</em>'.
	 * @see ac.soton.rms.components.Port#getIn()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_In();

	/**
	 * Returns the meta object for the reference list '{@link ac.soton.rms.components.Port#getOut <em>Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Out</em>'.
	 * @see ac.soton.rms.components.Port#getOut()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Out();

	/**
	 * Returns the meta object for class '{@link ac.soton.rms.components.AbstractVariable <em>Abstract Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Variable</em>'.
	 * @see ac.soton.rms.components.AbstractVariable
	 * @generated
	 */
	EClass getAbstractVariable();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.rms.components.AbstractVariable#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see ac.soton.rms.components.AbstractVariable#getType()
	 * @see #getAbstractVariable()
	 * @generated
	 */
	EAttribute getAbstractVariable_Type();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.rms.components.AbstractVariable#getCausality <em>Causality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Causality</em>'.
	 * @see ac.soton.rms.components.AbstractVariable#getCausality()
	 * @see #getAbstractVariable()
	 * @generated
	 */
	EAttribute getAbstractVariable_Causality();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.rms.components.AbstractVariable#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see ac.soton.rms.components.AbstractVariable#getValue()
	 * @see #getAbstractVariable()
	 * @generated
	 */
	EAttribute getAbstractVariable_Value();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.rms.components.AbstractVariable#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see ac.soton.rms.components.AbstractVariable#getDescription()
	 * @see #getAbstractVariable()
	 * @generated
	 */
	EAttribute getAbstractVariable_Description();

	/**
	 * Returns the meta object for class '{@link ac.soton.rms.components.FMUVariable <em>FMU Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FMU Variable</em>'.
	 * @see ac.soton.rms.components.FMUVariable
	 * @generated
	 */
	EClass getFMUVariable();

	/**
	 * Returns the meta object for class '{@link ac.soton.rms.components.EventBVariable <em>Event BVariable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event BVariable</em>'.
	 * @see ac.soton.rms.components.EventBVariable
	 * @generated
	 */
	EClass getEventBVariable();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.rms.components.EventBVariable#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see ac.soton.rms.components.EventBVariable#getVariable()
	 * @see #getEventBVariable()
	 * @generated
	 */
	EReference getEventBVariable_Variable();

	/**
	 * Returns the meta object for class '{@link ac.soton.rms.components.FMUParameter <em>FMU Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FMU Parameter</em>'.
	 * @see ac.soton.rms.components.FMUParameter
	 * @generated
	 */
	EClass getFMUParameter();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.rms.components.FMUParameter#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value</em>'.
	 * @see ac.soton.rms.components.FMUParameter#getDefaultValue()
	 * @see #getFMUParameter()
	 * @generated
	 */
	EAttribute getFMUParameter_DefaultValue();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.rms.components.FMUParameter#getStartValue <em>Start Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Value</em>'.
	 * @see ac.soton.rms.components.FMUParameter#getStartValue()
	 * @see #getFMUParameter()
	 * @generated
	 */
	EAttribute getFMUParameter_StartValue();

	/**
	 * Returns the meta object for class '{@link ac.soton.rms.components.FMUPort <em>FMU Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FMU Port</em>'.
	 * @see ac.soton.rms.components.FMUPort
	 * @generated
	 */
	EClass getFMUPort();

	/**
	 * Returns the meta object for class '{@link ac.soton.rms.components.EventBPort <em>Event BPort</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event BPort</em>'.
	 * @see ac.soton.rms.components.EventBPort
	 * @generated
	 */
	EClass getEventBPort();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.rms.components.EventBPort#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter</em>'.
	 * @see ac.soton.rms.components.EventBPort#getParameter()
	 * @see #getEventBPort()
	 * @generated
	 */
	EReference getEventBPort_Parameter();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.rms.components.EventBPort#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see ac.soton.rms.components.EventBPort#getVariable()
	 * @see #getEventBPort()
	 * @generated
	 */
	EReference getEventBPort_Variable();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.rms.components.EventBPort#getIntToReal <em>Int To Real</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Int To Real</em>'.
	 * @see ac.soton.rms.components.EventBPort#getIntToReal()
	 * @see #getEventBPort()
	 * @generated
	 */
	EAttribute getEventBPort_IntToReal();

	/**
	 * Returns the meta object for class '{@link ac.soton.rms.components.DisplayComponent <em>Display Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Display Component</em>'.
	 * @see ac.soton.rms.components.DisplayComponent
	 * @generated
	 */
	EClass getDisplayComponent();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.rms.components.DisplayComponent#getChart <em>Chart</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Chart</em>'.
	 * @see ac.soton.rms.components.DisplayComponent#getChart()
	 * @see #getDisplayComponent()
	 * @generated
	 */
	EAttribute getDisplayComponent_Chart();

	/**
	 * Returns the meta object for class '{@link ac.soton.rms.components.DisplayPort <em>Display Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Display Port</em>'.
	 * @see ac.soton.rms.components.DisplayPort
	 * @generated
	 */
	EClass getDisplayPort();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.rms.components.DisplayPort#getTrace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trace</em>'.
	 * @see ac.soton.rms.components.DisplayPort#getTrace()
	 * @see #getDisplayPort()
	 * @generated
	 */
	EAttribute getDisplayPort_Trace();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.rms.components.DisplayPort#getColor <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color</em>'.
	 * @see ac.soton.rms.components.DisplayPort#getColor()
	 * @see #getDisplayPort()
	 * @generated
	 */
	EAttribute getDisplayPort_Color();

	/**
	 * Returns the meta object for enum '{@link ac.soton.rms.components.VariableType <em>Variable Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Variable Type</em>'.
	 * @see ac.soton.rms.components.VariableType
	 * @generated
	 */
	EEnum getVariableType();

	/**
	 * Returns the meta object for enum '{@link ac.soton.rms.components.VariableCausality <em>Variable Causality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Variable Causality</em>'.
	 * @see ac.soton.rms.components.VariableCausality
	 * @generated
	 */
	EEnum getVariableCausality();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.runtime.IStatus <em>IStatus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IStatus</em>'.
	 * @see org.eclipse.core.runtime.IStatus
	 * @model instanceClass="org.eclipse.core.runtime.IStatus" serializeable="false"
	 * @generated
	 */
	EDataType getIStatus();

	/**
	 * Returns the meta object for data type '{@link de.prob.cosimulation.FMU <em>FMU</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>FMU</em>'.
	 * @see de.prob.cosimulation.FMU
	 * @model instanceClass="de.prob.cosimulation.FMU" serializeable="false"
	 * @generated
	 */
	EDataType getFMU();

	/**
	 * Returns the meta object for data type '{@link info.monitorenter.gui.chart.ITrace2D <em>ITrace2 D</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>ITrace2 D</em>'.
	 * @see info.monitorenter.gui.chart.ITrace2D
	 * @model instanceClass="info.monitorenter.gui.chart.ITrace2D" serializeable="false"
	 * @generated
	 */
	EDataType getITrace2D();

	/**
	 * Returns the meta object for data type '{@link info.monitorenter.gui.chart.Chart2D <em>Chart2 D</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Chart2 D</em>'.
	 * @see info.monitorenter.gui.chart.Chart2D
	 * @model instanceClass="info.monitorenter.gui.chart.Chart2D" serializeable="false"
	 * @generated
	 */
	EDataType getChart2D();

	/**
	 * Returns the meta object for data type '{@link java.awt.Color <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Color</em>'.
	 * @see java.awt.Color
	 * @model instanceClass="java.awt.Color"
	 * @generated
	 */
	EDataType getColor();

	/**
	 * Returns the meta object for data type '{@link de.prob.statespace.Trace <em>Pro BTrace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Pro BTrace</em>'.
	 * @see de.prob.statespace.Trace
	 * @model instanceClass="de.prob.statespace.Trace" serializeable="false"
	 * @generated
	 */
	EDataType getProBTrace();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ComponentsFactory getComponentsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link ac.soton.rms.components.impl.ComponentDiagramImpl <em>Component Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.rms.components.impl.ComponentDiagramImpl
		 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getComponentDiagram()
		 * @generated
		 */
		EClass COMPONENT_DIAGRAM = eINSTANCE.getComponentDiagram();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_DIAGRAM__COMPONENTS = eINSTANCE.getComponentDiagram_Components();

		/**
		 * The meta object literal for the '<em><b>Stop Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_DIAGRAM__STOP_TIME = eINSTANCE.getComponentDiagram_StopTime();

		/**
		 * The meta object literal for the '<em><b>Start Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_DIAGRAM__START_TIME = eINSTANCE.getComponentDiagram_StartTime();

		/**
		 * The meta object literal for the '{@link ac.soton.rms.components.Component <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.rms.components.Component
		 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__INPUTS = eINSTANCE.getComponent_Inputs();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__OUTPUTS = eINSTANCE.getComponent_Outputs();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__VARIABLES = eINSTANCE.getComponent_Variables();

		/**
		 * The meta object literal for the '{@link ac.soton.rms.components.impl.EventBComponentImpl <em>Event BComponent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.rms.components.impl.EventBComponentImpl
		 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getEventBComponent()
		 * @generated
		 */
		EClass EVENT_BCOMPONENT = eINSTANCE.getEventBComponent();

		/**
		 * The meta object literal for the '<em><b>Machine</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_BCOMPONENT__MACHINE = eINSTANCE.getEventBComponent_Machine();

		/**
		 * The meta object literal for the '<em><b>Composed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_BCOMPONENT__COMPOSED = eINSTANCE.getEventBComponent_Composed();

		/**
		 * The meta object literal for the '<em><b>Trace File Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_BCOMPONENT__TRACE_FILE_PATH = eINSTANCE.getEventBComponent_TraceFilePath();

		/**
		 * The meta object literal for the '<em><b>Read Input Events</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_BCOMPONENT__READ_INPUT_EVENTS = eINSTANCE.getEventBComponent_ReadInputEvents();

		/**
		 * The meta object literal for the '<em><b>Wait Events</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_BCOMPONENT__WAIT_EVENTS = eINSTANCE.getEventBComponent_WaitEvents();

		/**
		 * The meta object literal for the '<em><b>Step Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_BCOMPONENT__STEP_PERIOD = eINSTANCE.getEventBComponent_StepPeriod();

		/**
		 * The meta object literal for the '<em><b>Check Invariants</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_BCOMPONENT__CHECK_INVARIANTS = eINSTANCE.getEventBComponent_CheckInvariants();

		/**
		 * The meta object literal for the '<em><b>Compare Trace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_BCOMPONENT__COMPARE_TRACE = eINSTANCE.getEventBComponent_CompareTrace();

		/**
		 * The meta object literal for the '<em><b>Record Trace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_BCOMPONENT__RECORD_TRACE = eINSTANCE.getEventBComponent_RecordTrace();

		/**
		 * The meta object literal for the '<em><b>Trace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_BCOMPONENT__TRACE = eINSTANCE.getEventBComponent_Trace();

		/**
		 * The meta object literal for the '{@link ac.soton.rms.components.impl.FMUComponentImpl <em>FMU Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.rms.components.impl.FMUComponentImpl
		 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getFMUComponent()
		 * @generated
		 */
		EClass FMU_COMPONENT = eINSTANCE.getFMUComponent();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU_COMPONENT__PATH = eINSTANCE.getFMUComponent_Path();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMU_COMPONENT__PARAMETERS = eINSTANCE.getFMUComponent_Parameters();

		/**
		 * The meta object literal for the '<em><b>Fmu</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU_COMPONENT__FMU = eINSTANCE.getFMUComponent_Fmu();

		/**
		 * The meta object literal for the '{@link ac.soton.rms.components.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.rms.components.impl.PortImpl
		 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>In</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__IN = eINSTANCE.getPort_In();

		/**
		 * The meta object literal for the '<em><b>Out</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__OUT = eINSTANCE.getPort_Out();

		/**
		 * The meta object literal for the '{@link ac.soton.rms.components.impl.AbstractVariableImpl <em>Abstract Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.rms.components.impl.AbstractVariableImpl
		 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getAbstractVariable()
		 * @generated
		 */
		EClass ABSTRACT_VARIABLE = eINSTANCE.getAbstractVariable();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_VARIABLE__TYPE = eINSTANCE.getAbstractVariable_Type();

		/**
		 * The meta object literal for the '<em><b>Causality</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_VARIABLE__CAUSALITY = eINSTANCE.getAbstractVariable_Causality();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_VARIABLE__VALUE = eINSTANCE.getAbstractVariable_Value();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_VARIABLE__DESCRIPTION = eINSTANCE.getAbstractVariable_Description();

		/**
		 * The meta object literal for the '{@link ac.soton.rms.components.impl.FMUVariableImpl <em>FMU Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.rms.components.impl.FMUVariableImpl
		 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getFMUVariable()
		 * @generated
		 */
		EClass FMU_VARIABLE = eINSTANCE.getFMUVariable();

		/**
		 * The meta object literal for the '{@link ac.soton.rms.components.impl.EventBVariableImpl <em>Event BVariable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.rms.components.impl.EventBVariableImpl
		 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getEventBVariable()
		 * @generated
		 */
		EClass EVENT_BVARIABLE = eINSTANCE.getEventBVariable();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_BVARIABLE__VARIABLE = eINSTANCE.getEventBVariable_Variable();

		/**
		 * The meta object literal for the '{@link ac.soton.rms.components.impl.FMUParameterImpl <em>FMU Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.rms.components.impl.FMUParameterImpl
		 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getFMUParameter()
		 * @generated
		 */
		EClass FMU_PARAMETER = eINSTANCE.getFMUParameter();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU_PARAMETER__DEFAULT_VALUE = eINSTANCE.getFMUParameter_DefaultValue();

		/**
		 * The meta object literal for the '<em><b>Start Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU_PARAMETER__START_VALUE = eINSTANCE.getFMUParameter_StartValue();

		/**
		 * The meta object literal for the '{@link ac.soton.rms.components.impl.FMUPortImpl <em>FMU Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.rms.components.impl.FMUPortImpl
		 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getFMUPort()
		 * @generated
		 */
		EClass FMU_PORT = eINSTANCE.getFMUPort();

		/**
		 * The meta object literal for the '{@link ac.soton.rms.components.impl.EventBPortImpl <em>Event BPort</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.rms.components.impl.EventBPortImpl
		 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getEventBPort()
		 * @generated
		 */
		EClass EVENT_BPORT = eINSTANCE.getEventBPort();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_BPORT__PARAMETER = eINSTANCE.getEventBPort_Parameter();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_BPORT__VARIABLE = eINSTANCE.getEventBPort_Variable();

		/**
		 * The meta object literal for the '<em><b>Int To Real</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_BPORT__INT_TO_REAL = eINSTANCE.getEventBPort_IntToReal();

		/**
		 * The meta object literal for the '{@link ac.soton.rms.components.impl.DisplayComponentImpl <em>Display Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.rms.components.impl.DisplayComponentImpl
		 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getDisplayComponent()
		 * @generated
		 */
		EClass DISPLAY_COMPONENT = eINSTANCE.getDisplayComponent();

		/**
		 * The meta object literal for the '<em><b>Chart</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISPLAY_COMPONENT__CHART = eINSTANCE.getDisplayComponent_Chart();

		/**
		 * The meta object literal for the '{@link ac.soton.rms.components.impl.DisplayPortImpl <em>Display Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.rms.components.impl.DisplayPortImpl
		 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getDisplayPort()
		 * @generated
		 */
		EClass DISPLAY_PORT = eINSTANCE.getDisplayPort();

		/**
		 * The meta object literal for the '<em><b>Trace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISPLAY_PORT__TRACE = eINSTANCE.getDisplayPort_Trace();

		/**
		 * The meta object literal for the '<em><b>Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISPLAY_PORT__COLOR = eINSTANCE.getDisplayPort_Color();

		/**
		 * The meta object literal for the '{@link ac.soton.rms.components.VariableType <em>Variable Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.rms.components.VariableType
		 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getVariableType()
		 * @generated
		 */
		EEnum VARIABLE_TYPE = eINSTANCE.getVariableType();

		/**
		 * The meta object literal for the '{@link ac.soton.rms.components.VariableCausality <em>Variable Causality</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.rms.components.VariableCausality
		 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getVariableCausality()
		 * @generated
		 */
		EEnum VARIABLE_CAUSALITY = eINSTANCE.getVariableCausality();

		/**
		 * The meta object literal for the '<em>IStatus</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.runtime.IStatus
		 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getIStatus()
		 * @generated
		 */
		EDataType ISTATUS = eINSTANCE.getIStatus();

		/**
		 * The meta object literal for the '<em>FMU</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.prob.cosimulation.FMU
		 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getFMU()
		 * @generated
		 */
		EDataType FMU = eINSTANCE.getFMU();

		/**
		 * The meta object literal for the '<em>ITrace2 D</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see info.monitorenter.gui.chart.ITrace2D
		 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getITrace2D()
		 * @generated
		 */
		EDataType ITRACE2_D = eINSTANCE.getITrace2D();

		/**
		 * The meta object literal for the '<em>Chart2 D</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see info.monitorenter.gui.chart.Chart2D
		 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getChart2D()
		 * @generated
		 */
		EDataType CHART2_D = eINSTANCE.getChart2D();

		/**
		 * The meta object literal for the '<em>Color</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.awt.Color
		 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getColor()
		 * @generated
		 */
		EDataType COLOR = eINSTANCE.getColor();

		/**
		 * The meta object literal for the '<em>Pro BTrace</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.prob.statespace.Trace
		 * @see ac.soton.rms.components.impl.ComponentsPackageImpl#getProBTrace()
		 * @generated
		 */
		EDataType PRO_BTRACE = eINSTANCE.getProBTrace();

	}

} //ComponentsPackage
