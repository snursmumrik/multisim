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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eventb.emf.core.CorePackage;

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
 * @see ac.soton.multisim.MultisimFactory
 * @model kind="package"
 * @generated
 */
public interface MultisimPackage extends EPackage {

	/**
	 * @custom
	 */
	String EXTENSION_ID = "ac.soton.multisim";
	
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
	String eNAME = "multisim";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://soton.ac.uk/models/multisim/2.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "multisim";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MultisimPackage eINSTANCE = ac.soton.multisim.impl.MultisimPackageImpl.init();

	/**
	 * The meta object id for the '{@link ac.soton.multisim.impl.ComponentDiagramImpl <em>Component Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.multisim.impl.ComponentDiagramImpl
	 * @see ac.soton.multisim.impl.MultisimPackageImpl#getComponentDiagram()
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
	 * The feature id for the '<em><b>Step Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__STEP_SIZE = CorePackage.EVENT_BNAMED_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__ARGUMENTS = CorePackage.EVENT_BNAMED_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Record Outputs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__RECORD_OUTPUTS = CorePackage.EVENT_BNAMED_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Component Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM_FEATURE_COUNT = CorePackage.EVENT_BNAMED_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link ac.soton.multisim.Component <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.multisim.Component
	 * @see ac.soton.multisim.impl.MultisimPackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__NAME = CorePackage.EVENT_BNAMED__NAME;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__INPUTS = CorePackage.EVENT_BNAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__OUTPUTS = CorePackage.EVENT_BNAMED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Step Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__STEP_PERIOD = CorePackage.EVENT_BNAMED_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = CorePackage.EVENT_BNAMED_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link ac.soton.multisim.impl.EventBComponentImpl <em>Event BComponent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.multisim.impl.EventBComponentImpl
	 * @see ac.soton.multisim.impl.MultisimPackageImpl#getEventBComponent()
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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__NAME = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Step Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__STEP_PERIOD = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 3;

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
	 * The feature id for the '<em><b>Read Input Events</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__READ_INPUT_EVENTS = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Wait Events</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__WAIT_EVENTS = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__TRACE = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Record Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__RECORD_TRACE = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Event BComponent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT_FEATURE_COUNT = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link ac.soton.multisim.impl.FMUComponentImpl <em>FMU Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.multisim.impl.FMUComponentImpl
	 * @see ac.soton.multisim.impl.MultisimPackageImpl#getFMUComponent()
	 * @generated
	 */
	int FMU_COMPONENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_COMPONENT__NAME = COMPONENT__NAME;

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
	 * The feature id for the '<em><b>Step Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_COMPONENT__STEP_PERIOD = COMPONENT__STEP_PERIOD;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_COMPONENT__PATH = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_COMPONENT__PARAMETERS = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fmu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_COMPONENT__FMU = COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>FMU Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_COMPONENT_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link ac.soton.multisim.impl.AbstractVariableImpl <em>Abstract Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.multisim.impl.AbstractVariableImpl
	 * @see ac.soton.multisim.impl.MultisimPackageImpl#getAbstractVariable()
	 * @generated
	 */
	int ABSTRACT_VARIABLE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE__NAME = CorePackage.EVENT_BNAMED__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE__TYPE = CorePackage.EVENT_BNAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Causality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE__CAUSALITY = CorePackage.EVENT_BNAMED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE__VALUE = CorePackage.EVENT_BNAMED_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE__DESCRIPTION = CorePackage.EVENT_BNAMED_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Abstract Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE_FEATURE_COUNT = CorePackage.EVENT_BNAMED_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link ac.soton.multisim.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.multisim.impl.PortImpl
	 * @see ac.soton.multisim.impl.MultisimPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__NAME = ABSTRACT_VARIABLE__NAME;

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
	 * The meta object id for the '{@link ac.soton.multisim.impl.FMUParameterImpl <em>FMU Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.multisim.impl.FMUParameterImpl
	 * @see ac.soton.multisim.impl.MultisimPackageImpl#getFMUParameter()
	 * @generated
	 */
	int FMU_PARAMETER = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PARAMETER__NAME = ABSTRACT_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PARAMETER__TYPE = ABSTRACT_VARIABLE__TYPE;

	/**
	 * The feature id for the '<em><b>Causality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PARAMETER__CAUSALITY = ABSTRACT_VARIABLE__CAUSALITY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PARAMETER__VALUE = ABSTRACT_VARIABLE__VALUE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PARAMETER__DESCRIPTION = ABSTRACT_VARIABLE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PARAMETER__DEFAULT_VALUE = ABSTRACT_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Start Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PARAMETER__START_VALUE = ABSTRACT_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>FMU Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PARAMETER_FEATURE_COUNT = ABSTRACT_VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ac.soton.multisim.impl.FMUPortImpl <em>FMU Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.multisim.impl.FMUPortImpl
	 * @see ac.soton.multisim.impl.MultisimPackageImpl#getFMUPort()
	 * @generated
	 */
	int FMU_PORT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PORT__NAME = PORT__NAME;

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
	 * The number of structural features of the '<em>FMU Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link ac.soton.multisim.impl.EventBPortImpl <em>Event BPort</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.multisim.impl.EventBPortImpl
	 * @see ac.soton.multisim.impl.MultisimPackageImpl#getEventBPort()
	 * @generated
	 */
	int EVENT_BPORT = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT__NAME = PORT__NAME;

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
	 * The meta object id for the '{@link ac.soton.multisim.impl.DisplayComponentImpl <em>Display Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.multisim.impl.DisplayComponentImpl
	 * @see ac.soton.multisim.impl.MultisimPackageImpl#getDisplayComponent()
	 * @generated
	 */
	int DISPLAY_COMPONENT = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_COMPONENT__NAME = COMPONENT__NAME;

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
	 * The feature id for the '<em><b>Step Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_COMPONENT__STEP_PERIOD = COMPONENT__STEP_PERIOD;

	/**
	 * The feature id for the '<em><b>Chart</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_COMPONENT__CHART = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Buffer Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_COMPONENT__BUFFER_SIZE = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Display Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_COMPONENT_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ac.soton.multisim.impl.DisplayPortImpl <em>Display Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.multisim.impl.DisplayPortImpl
	 * @see ac.soton.multisim.impl.MultisimPackageImpl#getDisplayPort()
	 * @generated
	 */
	int DISPLAY_PORT = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_PORT__NAME = PORT__NAME;

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
	 * The meta object id for the '{@link ac.soton.multisim.VariableType <em>Variable Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.multisim.VariableType
	 * @see ac.soton.multisim.impl.MultisimPackageImpl#getVariableType()
	 * @generated
	 */
	int VARIABLE_TYPE = 11;

	/**
	 * The meta object id for the '{@link ac.soton.multisim.VariableCausality <em>Variable Causality</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.multisim.VariableCausality
	 * @see ac.soton.multisim.impl.MultisimPackageImpl#getVariableCausality()
	 * @generated
	 */
	int VARIABLE_CAUSALITY = 12;

	/**
	 * The meta object id for the '<em>IStatus</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.runtime.IStatus
	 * @see ac.soton.multisim.impl.MultisimPackageImpl#getIStatus()
	 * @generated
	 */
	int ISTATUS = 13;

	/**
	 * The meta object id for the '<em>FMU</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.prob.cosimulation.FMU
	 * @see ac.soton.multisim.impl.MultisimPackageImpl#getFMU()
	 * @generated
	 */
	int FMU = 14;

	/**
	 * The meta object id for the '<em>ITrace2 D</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see info.monitorenter.gui.chart.ITrace2D
	 * @see ac.soton.multisim.impl.MultisimPackageImpl#getITrace2D()
	 * @generated
	 */
	int ITRACE2_D = 15;

	/**
	 * The meta object id for the '<em>Chart2 D</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see info.monitorenter.gui.chart.Chart2D
	 * @see ac.soton.multisim.impl.MultisimPackageImpl#getChart2D()
	 * @generated
	 */
	int CHART2_D = 16;

	/**
	 * The meta object id for the '<em>Color</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.awt.Color
	 * @see ac.soton.multisim.impl.MultisimPackageImpl#getColor()
	 * @generated
	 */
	int COLOR = 17;

	/**
	 * The meta object id for the '<em>Pro BTrace</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.prob.statespace.Trace
	 * @see ac.soton.multisim.impl.MultisimPackageImpl#getProBTrace()
	 * @generated
	 */
	int PRO_BTRACE = 18;

	/**
	 * The meta object id for the '<em>Simulation Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.multisim.exception.SimulationException
	 * @see ac.soton.multisim.impl.MultisimPackageImpl#getSimulationException()
	 * @generated
	 */
	int SIMULATION_EXCEPTION = 19;

	/**
	 * The meta object id for the '<em>Model Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.multisim.exception.ModelException
	 * @see ac.soton.multisim.impl.MultisimPackageImpl#getModelException()
	 * @generated
	 */
	int MODEL_EXCEPTION = 20;

	/**
	 * Returns the meta object for class '{@link ac.soton.multisim.ComponentDiagram <em>Component Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Diagram</em>'.
	 * @see ac.soton.multisim.ComponentDiagram
	 * @generated
	 */
	EClass getComponentDiagram();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.multisim.ComponentDiagram#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see ac.soton.multisim.ComponentDiagram#getComponents()
	 * @see #getComponentDiagram()
	 * @generated
	 */
	EReference getComponentDiagram_Components();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.multisim.ComponentDiagram#getStopTime <em>Stop Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stop Time</em>'.
	 * @see ac.soton.multisim.ComponentDiagram#getStopTime()
	 * @see #getComponentDiagram()
	 * @generated
	 */
	EAttribute getComponentDiagram_StopTime();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.multisim.ComponentDiagram#getStartTime <em>Start Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Time</em>'.
	 * @see ac.soton.multisim.ComponentDiagram#getStartTime()
	 * @see #getComponentDiagram()
	 * @generated
	 */
	EAttribute getComponentDiagram_StartTime();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.multisim.ComponentDiagram#getStepSize <em>Step Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step Size</em>'.
	 * @see ac.soton.multisim.ComponentDiagram#getStepSize()
	 * @see #getComponentDiagram()
	 * @generated
	 */
	EAttribute getComponentDiagram_StepSize();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.multisim.ComponentDiagram#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Arguments</em>'.
	 * @see ac.soton.multisim.ComponentDiagram#getArguments()
	 * @see #getComponentDiagram()
	 * @generated
	 */
	EAttribute getComponentDiagram_Arguments();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.multisim.ComponentDiagram#isRecordOutputs <em>Record Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Record Outputs</em>'.
	 * @see ac.soton.multisim.ComponentDiagram#isRecordOutputs()
	 * @see #getComponentDiagram()
	 * @generated
	 */
	EAttribute getComponentDiagram_RecordOutputs();

	/**
	 * Returns the meta object for class '{@link ac.soton.multisim.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see ac.soton.multisim.Component
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.multisim.Component#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inputs</em>'.
	 * @see ac.soton.multisim.Component#getInputs()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Inputs();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.multisim.Component#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outputs</em>'.
	 * @see ac.soton.multisim.Component#getOutputs()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Outputs();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.multisim.Component#getStepPeriod <em>Step Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step Period</em>'.
	 * @see ac.soton.multisim.Component#getStepPeriod()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_StepPeriod();

	/**
	 * Returns the meta object for class '{@link ac.soton.multisim.EventBComponent <em>Event BComponent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event BComponent</em>'.
	 * @see ac.soton.multisim.EventBComponent
	 * @generated
	 */
	EClass getEventBComponent();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.multisim.EventBComponent#getMachine <em>Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Machine</em>'.
	 * @see ac.soton.multisim.EventBComponent#getMachine()
	 * @see #getEventBComponent()
	 * @generated
	 */
	EReference getEventBComponent_Machine();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.multisim.EventBComponent#isComposed <em>Composed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Composed</em>'.
	 * @see ac.soton.multisim.EventBComponent#isComposed()
	 * @see #getEventBComponent()
	 * @generated
	 */
	EAttribute getEventBComponent_Composed();

	/**
	 * Returns the meta object for the reference list '{@link ac.soton.multisim.EventBComponent#getReadInputEvents <em>Read Input Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Read Input Events</em>'.
	 * @see ac.soton.multisim.EventBComponent#getReadInputEvents()
	 * @see #getEventBComponent()
	 * @generated
	 */
	EReference getEventBComponent_ReadInputEvents();

	/**
	 * Returns the meta object for the reference list '{@link ac.soton.multisim.EventBComponent#getWaitEvents <em>Wait Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Wait Events</em>'.
	 * @see ac.soton.multisim.EventBComponent#getWaitEvents()
	 * @see #getEventBComponent()
	 * @generated
	 */
	EReference getEventBComponent_WaitEvents();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.multisim.EventBComponent#getTrace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trace</em>'.
	 * @see ac.soton.multisim.EventBComponent#getTrace()
	 * @see #getEventBComponent()
	 * @generated
	 */
	EAttribute getEventBComponent_Trace();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.multisim.EventBComponent#isRecordTrace <em>Record Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Record Trace</em>'.
	 * @see ac.soton.multisim.EventBComponent#isRecordTrace()
	 * @see #getEventBComponent()
	 * @generated
	 */
	EAttribute getEventBComponent_RecordTrace();

	/**
	 * Returns the meta object for class '{@link ac.soton.multisim.FMUComponent <em>FMU Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FMU Component</em>'.
	 * @see ac.soton.multisim.FMUComponent
	 * @generated
	 */
	EClass getFMUComponent();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.multisim.FMUComponent#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see ac.soton.multisim.FMUComponent#getPath()
	 * @see #getFMUComponent()
	 * @generated
	 */
	EAttribute getFMUComponent_Path();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.multisim.FMUComponent#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see ac.soton.multisim.FMUComponent#getParameters()
	 * @see #getFMUComponent()
	 * @generated
	 */
	EReference getFMUComponent_Parameters();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.multisim.FMUComponent#getFmu <em>Fmu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fmu</em>'.
	 * @see ac.soton.multisim.FMUComponent#getFmu()
	 * @see #getFMUComponent()
	 * @generated
	 */
	EAttribute getFMUComponent_Fmu();

	/**
	 * Returns the meta object for class '{@link ac.soton.multisim.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see ac.soton.multisim.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.multisim.Port#getIn <em>In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>In</em>'.
	 * @see ac.soton.multisim.Port#getIn()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_In();

	/**
	 * Returns the meta object for the reference list '{@link ac.soton.multisim.Port#getOut <em>Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Out</em>'.
	 * @see ac.soton.multisim.Port#getOut()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Out();

	/**
	 * Returns the meta object for class '{@link ac.soton.multisim.AbstractVariable <em>Abstract Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Variable</em>'.
	 * @see ac.soton.multisim.AbstractVariable
	 * @generated
	 */
	EClass getAbstractVariable();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.multisim.AbstractVariable#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see ac.soton.multisim.AbstractVariable#getType()
	 * @see #getAbstractVariable()
	 * @generated
	 */
	EAttribute getAbstractVariable_Type();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.multisim.AbstractVariable#getCausality <em>Causality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Causality</em>'.
	 * @see ac.soton.multisim.AbstractVariable#getCausality()
	 * @see #getAbstractVariable()
	 * @generated
	 */
	EAttribute getAbstractVariable_Causality();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.multisim.AbstractVariable#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see ac.soton.multisim.AbstractVariable#getValue()
	 * @see #getAbstractVariable()
	 * @generated
	 */
	EAttribute getAbstractVariable_Value();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.multisim.AbstractVariable#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see ac.soton.multisim.AbstractVariable#getDescription()
	 * @see #getAbstractVariable()
	 * @generated
	 */
	EAttribute getAbstractVariable_Description();

	/**
	 * Returns the meta object for class '{@link ac.soton.multisim.FMUParameter <em>FMU Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FMU Parameter</em>'.
	 * @see ac.soton.multisim.FMUParameter
	 * @generated
	 */
	EClass getFMUParameter();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.multisim.FMUParameter#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value</em>'.
	 * @see ac.soton.multisim.FMUParameter#getDefaultValue()
	 * @see #getFMUParameter()
	 * @generated
	 */
	EAttribute getFMUParameter_DefaultValue();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.multisim.FMUParameter#getStartValue <em>Start Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Value</em>'.
	 * @see ac.soton.multisim.FMUParameter#getStartValue()
	 * @see #getFMUParameter()
	 * @generated
	 */
	EAttribute getFMUParameter_StartValue();

	/**
	 * Returns the meta object for class '{@link ac.soton.multisim.FMUPort <em>FMU Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FMU Port</em>'.
	 * @see ac.soton.multisim.FMUPort
	 * @generated
	 */
	EClass getFMUPort();

	/**
	 * Returns the meta object for class '{@link ac.soton.multisim.EventBPort <em>Event BPort</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event BPort</em>'.
	 * @see ac.soton.multisim.EventBPort
	 * @generated
	 */
	EClass getEventBPort();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.multisim.EventBPort#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter</em>'.
	 * @see ac.soton.multisim.EventBPort#getParameter()
	 * @see #getEventBPort()
	 * @generated
	 */
	EReference getEventBPort_Parameter();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.multisim.EventBPort#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see ac.soton.multisim.EventBPort#getVariable()
	 * @see #getEventBPort()
	 * @generated
	 */
	EReference getEventBPort_Variable();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.multisim.EventBPort#getIntToReal <em>Int To Real</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Int To Real</em>'.
	 * @see ac.soton.multisim.EventBPort#getIntToReal()
	 * @see #getEventBPort()
	 * @generated
	 */
	EAttribute getEventBPort_IntToReal();

	/**
	 * Returns the meta object for class '{@link ac.soton.multisim.DisplayComponent <em>Display Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Display Component</em>'.
	 * @see ac.soton.multisim.DisplayComponent
	 * @generated
	 */
	EClass getDisplayComponent();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.multisim.DisplayComponent#getChart <em>Chart</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Chart</em>'.
	 * @see ac.soton.multisim.DisplayComponent#getChart()
	 * @see #getDisplayComponent()
	 * @generated
	 */
	EAttribute getDisplayComponent_Chart();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.multisim.DisplayComponent#getBufferSize <em>Buffer Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Buffer Size</em>'.
	 * @see ac.soton.multisim.DisplayComponent#getBufferSize()
	 * @see #getDisplayComponent()
	 * @generated
	 */
	EAttribute getDisplayComponent_BufferSize();

	/**
	 * Returns the meta object for class '{@link ac.soton.multisim.DisplayPort <em>Display Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Display Port</em>'.
	 * @see ac.soton.multisim.DisplayPort
	 * @generated
	 */
	EClass getDisplayPort();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.multisim.DisplayPort#getTrace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trace</em>'.
	 * @see ac.soton.multisim.DisplayPort#getTrace()
	 * @see #getDisplayPort()
	 * @generated
	 */
	EAttribute getDisplayPort_Trace();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.multisim.DisplayPort#getColor <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color</em>'.
	 * @see ac.soton.multisim.DisplayPort#getColor()
	 * @see #getDisplayPort()
	 * @generated
	 */
	EAttribute getDisplayPort_Color();

	/**
	 * Returns the meta object for enum '{@link ac.soton.multisim.VariableType <em>Variable Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Variable Type</em>'.
	 * @see ac.soton.multisim.VariableType
	 * @generated
	 */
	EEnum getVariableType();

	/**
	 * Returns the meta object for enum '{@link ac.soton.multisim.VariableCausality <em>Variable Causality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Variable Causality</em>'.
	 * @see ac.soton.multisim.VariableCausality
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
	 * Returns the meta object for data type '{@link ac.soton.multisim.exception.SimulationException <em>Simulation Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Simulation Exception</em>'.
	 * @see ac.soton.multisim.exception.SimulationException
	 * @model instanceClass="ac.soton.multisim.exception.SimulationException" serializeable="false"
	 * @generated
	 */
	EDataType getSimulationException();

	/**
	 * Returns the meta object for data type '{@link ac.soton.multisim.exception.ModelException <em>Model Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Model Exception</em>'.
	 * @see ac.soton.multisim.exception.ModelException
	 * @model instanceClass="ac.soton.multisim.exception.ModelException" serializeable="false"
	 * @generated
	 */
	EDataType getModelException();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MultisimFactory getMultisimFactory();

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
		 * The meta object literal for the '{@link ac.soton.multisim.impl.ComponentDiagramImpl <em>Component Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.multisim.impl.ComponentDiagramImpl
		 * @see ac.soton.multisim.impl.MultisimPackageImpl#getComponentDiagram()
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
		 * The meta object literal for the '<em><b>Step Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_DIAGRAM__STEP_SIZE = eINSTANCE.getComponentDiagram_StepSize();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_DIAGRAM__ARGUMENTS = eINSTANCE.getComponentDiagram_Arguments();

		/**
		 * The meta object literal for the '<em><b>Record Outputs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_DIAGRAM__RECORD_OUTPUTS = eINSTANCE.getComponentDiagram_RecordOutputs();

		/**
		 * The meta object literal for the '{@link ac.soton.multisim.Component <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.multisim.Component
		 * @see ac.soton.multisim.impl.MultisimPackageImpl#getComponent()
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
		 * The meta object literal for the '<em><b>Step Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__STEP_PERIOD = eINSTANCE.getComponent_StepPeriod();

		/**
		 * The meta object literal for the '{@link ac.soton.multisim.impl.EventBComponentImpl <em>Event BComponent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.multisim.impl.EventBComponentImpl
		 * @see ac.soton.multisim.impl.MultisimPackageImpl#getEventBComponent()
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
		 * The meta object literal for the '<em><b>Trace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_BCOMPONENT__TRACE = eINSTANCE.getEventBComponent_Trace();

		/**
		 * The meta object literal for the '<em><b>Record Trace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_BCOMPONENT__RECORD_TRACE = eINSTANCE.getEventBComponent_RecordTrace();

		/**
		 * The meta object literal for the '{@link ac.soton.multisim.impl.FMUComponentImpl <em>FMU Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.multisim.impl.FMUComponentImpl
		 * @see ac.soton.multisim.impl.MultisimPackageImpl#getFMUComponent()
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
		 * The meta object literal for the '{@link ac.soton.multisim.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.multisim.impl.PortImpl
		 * @see ac.soton.multisim.impl.MultisimPackageImpl#getPort()
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
		 * The meta object literal for the '{@link ac.soton.multisim.impl.AbstractVariableImpl <em>Abstract Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.multisim.impl.AbstractVariableImpl
		 * @see ac.soton.multisim.impl.MultisimPackageImpl#getAbstractVariable()
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
		 * The meta object literal for the '{@link ac.soton.multisim.impl.FMUParameterImpl <em>FMU Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.multisim.impl.FMUParameterImpl
		 * @see ac.soton.multisim.impl.MultisimPackageImpl#getFMUParameter()
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
		 * The meta object literal for the '{@link ac.soton.multisim.impl.FMUPortImpl <em>FMU Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.multisim.impl.FMUPortImpl
		 * @see ac.soton.multisim.impl.MultisimPackageImpl#getFMUPort()
		 * @generated
		 */
		EClass FMU_PORT = eINSTANCE.getFMUPort();

		/**
		 * The meta object literal for the '{@link ac.soton.multisim.impl.EventBPortImpl <em>Event BPort</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.multisim.impl.EventBPortImpl
		 * @see ac.soton.multisim.impl.MultisimPackageImpl#getEventBPort()
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
		 * The meta object literal for the '{@link ac.soton.multisim.impl.DisplayComponentImpl <em>Display Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.multisim.impl.DisplayComponentImpl
		 * @see ac.soton.multisim.impl.MultisimPackageImpl#getDisplayComponent()
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
		 * The meta object literal for the '<em><b>Buffer Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISPLAY_COMPONENT__BUFFER_SIZE = eINSTANCE.getDisplayComponent_BufferSize();

		/**
		 * The meta object literal for the '{@link ac.soton.multisim.impl.DisplayPortImpl <em>Display Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.multisim.impl.DisplayPortImpl
		 * @see ac.soton.multisim.impl.MultisimPackageImpl#getDisplayPort()
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
		 * The meta object literal for the '{@link ac.soton.multisim.VariableType <em>Variable Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.multisim.VariableType
		 * @see ac.soton.multisim.impl.MultisimPackageImpl#getVariableType()
		 * @generated
		 */
		EEnum VARIABLE_TYPE = eINSTANCE.getVariableType();

		/**
		 * The meta object literal for the '{@link ac.soton.multisim.VariableCausality <em>Variable Causality</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.multisim.VariableCausality
		 * @see ac.soton.multisim.impl.MultisimPackageImpl#getVariableCausality()
		 * @generated
		 */
		EEnum VARIABLE_CAUSALITY = eINSTANCE.getVariableCausality();

		/**
		 * The meta object literal for the '<em>IStatus</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.runtime.IStatus
		 * @see ac.soton.multisim.impl.MultisimPackageImpl#getIStatus()
		 * @generated
		 */
		EDataType ISTATUS = eINSTANCE.getIStatus();

		/**
		 * The meta object literal for the '<em>FMU</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.prob.cosimulation.FMU
		 * @see ac.soton.multisim.impl.MultisimPackageImpl#getFMU()
		 * @generated
		 */
		EDataType FMU = eINSTANCE.getFMU();

		/**
		 * The meta object literal for the '<em>ITrace2 D</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see info.monitorenter.gui.chart.ITrace2D
		 * @see ac.soton.multisim.impl.MultisimPackageImpl#getITrace2D()
		 * @generated
		 */
		EDataType ITRACE2_D = eINSTANCE.getITrace2D();

		/**
		 * The meta object literal for the '<em>Chart2 D</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see info.monitorenter.gui.chart.Chart2D
		 * @see ac.soton.multisim.impl.MultisimPackageImpl#getChart2D()
		 * @generated
		 */
		EDataType CHART2_D = eINSTANCE.getChart2D();

		/**
		 * The meta object literal for the '<em>Color</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.awt.Color
		 * @see ac.soton.multisim.impl.MultisimPackageImpl#getColor()
		 * @generated
		 */
		EDataType COLOR = eINSTANCE.getColor();

		/**
		 * The meta object literal for the '<em>Pro BTrace</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.prob.statespace.Trace
		 * @see ac.soton.multisim.impl.MultisimPackageImpl#getProBTrace()
		 * @generated
		 */
		EDataType PRO_BTRACE = eINSTANCE.getProBTrace();

		/**
		 * The meta object literal for the '<em>Simulation Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.multisim.exception.SimulationException
		 * @see ac.soton.multisim.impl.MultisimPackageImpl#getSimulationException()
		 * @generated
		 */
		EDataType SIMULATION_EXCEPTION = eINSTANCE.getSimulationException();

		/**
		 * The meta object literal for the '<em>Model Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.multisim.exception.ModelException
		 * @see ac.soton.multisim.impl.MultisimPackageImpl#getModelException()
		 * @generated
		 */
		EDataType MODEL_EXCEPTION = eINSTANCE.getModelException();

	}

} //MultisimPackage
