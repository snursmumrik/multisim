/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package ac.soton.multisim.util;

import ac.soton.multisim.exception.ModelException;
import ac.soton.multisim.exception.SimulationException;
import info.monitorenter.gui.chart.Chart2D;
import info.monitorenter.gui.chart.ITrace2D;
import java.awt.Color;
import java.io.File;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.Parameter;
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
import ac.soton.multisim.MultisimPackage;
import ac.soton.multisim.Port;
import ac.soton.multisim.VariableCausality;
import ac.soton.multisim.VariableType;
import de.prob.cosimulation.FMU;
import de.prob.statespace.Trace;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see ac.soton.multisim.MultisimPackage
 * @generated
 */
public class MultisimValidator extends EObjectValidator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2014 University of Southampton.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html";

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final MultisimValidator INSTANCE = new MultisimValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "ac.soton.multisim";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultisimValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return MultisimPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case MultisimPackage.COMPONENT_DIAGRAM:
				return validateComponentDiagram((ComponentDiagram)value, diagnostics, context);
			case MultisimPackage.COMPONENT:
				return validateComponent((Component)value, diagnostics, context);
			case MultisimPackage.EVENT_BCOMPONENT:
				return validateEventBComponent((EventBComponent)value, diagnostics, context);
			case MultisimPackage.FMU_COMPONENT:
				return validateFMUComponent((FMUComponent)value, diagnostics, context);
			case MultisimPackage.PORT:
				return validatePort((Port)value, diagnostics, context);
			case MultisimPackage.ABSTRACT_VARIABLE:
				return validateAbstractVariable((AbstractVariable)value, diagnostics, context);
			case MultisimPackage.FMU_PARAMETER:
				return validateFMUParameter((FMUParameter)value, diagnostics, context);
			case MultisimPackage.FMU_PORT:
				return validateFMUPort((FMUPort)value, diagnostics, context);
			case MultisimPackage.EVENT_BPORT:
				return validateEventBPort((EventBPort)value, diagnostics, context);
			case MultisimPackage.DISPLAY_COMPONENT:
				return validateDisplayComponent((DisplayComponent)value, diagnostics, context);
			case MultisimPackage.DISPLAY_PORT:
				return validateDisplayPort((DisplayPort)value, diagnostics, context);
			case MultisimPackage.VARIABLE_TYPE:
				return validateVariableType((VariableType)value, diagnostics, context);
			case MultisimPackage.VARIABLE_CAUSALITY:
				return validateVariableCausality((VariableCausality)value, diagnostics, context);
			case MultisimPackage.ISTATUS:
				return validateIStatus((IStatus)value, diagnostics, context);
			case MultisimPackage.FMU:
				return validateFMU((FMU)value, diagnostics, context);
			case MultisimPackage.ITRACE2_D:
				return validateITrace2D((ITrace2D)value, diagnostics, context);
			case MultisimPackage.CHART2_D:
				return validateChart2D((Chart2D)value, diagnostics, context);
			case MultisimPackage.COLOR:
				return validateColor((Color)value, diagnostics, context);
			case MultisimPackage.PRO_BTRACE:
				return validateProBTrace((Trace)value, diagnostics, context);
			case MultisimPackage.SIMULATION_EXCEPTION:
				return validateSimulationException((SimulationException)value, diagnostics, context);
			case MultisimPackage.MODEL_EXCEPTION:
				return validateModelException((ModelException)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentDiagram(ComponentDiagram componentDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_NoCircularContainment(componentDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMultiplicityConforms(componentDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(componentDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(componentDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(componentDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(componentDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(componentDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(componentDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(componentDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validateComponentDiagram_noDirectFMU(componentDiagram, diagnostics, context);
		return result;
	}

	/**
	 * Validates the noDirectFMU constraint of '<em>Component Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * Cannot have directly connected FMU components.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateComponentDiagram_noDirectFMU(ComponentDiagram componentDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		for (Component c : componentDiagram.getComponents()) {
			if (c instanceof FMUComponent) {
				for (Port p : c.getInputs()) {
					if (p.getIn() instanceof FMUPort) {
						if (diagnostics != null) {
							diagnostics.add
								(new BasicDiagnostic
									(Diagnostic.ERROR,
									 DIAGNOSTIC_SOURCE,
									 0,
									 "Direct connection of FMUs is not supported",
									 new Object[] { componentDiagram }));
						}
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponent(Component component, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(component, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEventBComponent(EventBComponent eventBComponent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_NoCircularContainment(eventBComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMultiplicityConforms(eventBComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(eventBComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(eventBComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(eventBComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(eventBComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(eventBComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(eventBComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(eventBComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateEventBComponent_consistentReadEvents(eventBComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateEventBComponent_validMachineReference(eventBComponent, diagnostics, context);
		return result;
	}

	/**
	 * Validates the consistentReadEvents constraint of '<em>Event BComponent</em>'.
	 * <!-- begin-user-doc -->
	 * All read events must have the same signature (name, number and type[validation not implemented yet] of parameters)
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateEventBComponent_consistentReadEvents(EventBComponent eventBComponent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		EList<Event> reads = eventBComponent.getReadInputEvents();
		// skip single event
		if (reads.size() <= 1)
			return true;
		
		// read first
		Event event1 = reads.get(0);
		Set<String> paramNames = new HashSet<String>(event1.getParameters().size());
		for (Parameter p : event1.getParameters())
			paramNames.add(p.getName());
		
		// compare to the rest
		boolean failed = false;
		Event event2 = null;
		for (Event e : reads) {
			if (event1.getParameters().size() != e.getParameters().size()) {
				event2 = e;
				failed = true;
				break;
			}
			for (Parameter p : e.getParameters()) {
				if (!paramNames.contains(p.getName())) {
					event2 = e;
					failed = true;
					break;
				}
			}
		}
		
		if (failed) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 MessageFormat.format("Read events ''{1}'' and ''{2}'' should match in number/name of parameters", new Object[] { event1.getName(), event2.getName() }),	
						 new Object[] { eventBComponent }));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validMachineReference constraint of '<em>Event BComponent</em>'.
	 * <!-- begin-user-doc -->
	 * Must have a valid Machine reference.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateEventBComponent_validMachineReference(EventBComponent eventBComponent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Machine m = eventBComponent.getMachine();
		//NOTE: null is checked by another validation constraint
		if (m != null && m.eIsProxy()) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "Invalid machine reference",
						 new Object[] { eventBComponent }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFMUComponent(FMUComponent fmuComponent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_NoCircularContainment(fmuComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMultiplicityConforms(fmuComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(fmuComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(fmuComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(fmuComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(fmuComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(fmuComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(fmuComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(fmuComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateFMUComponent_validPath(fmuComponent, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validPath constraint of '<em>FMU Component</em>'.
	 * <!-- begin-user-doc -->
	 * FMU path must point to an existing .fmu file.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateFMUComponent_validPath(FMUComponent fmuComponent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		String path = fmuComponent.getPath();
		//NOTE: null is checked by another rule
		if (path != null && (path.endsWith(".fmu") == false || new File(path).exists() == false)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "Invalid FMU path",	
						 new Object[] { fmuComponent }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePort(Port port, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_NoCircularContainment(port, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMultiplicityConforms(port, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(port, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(port, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(port, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(port, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(port, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(port, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(port, diagnostics, context);
		if (result || diagnostics != null) result &= validatePort_compatibleType(port, diagnostics, context);
		return result;
	}

	/**
	 * Validates the compatibleType constraint of '<em>Port</em>'.
	 * <!-- begin-user-doc -->
	 * Connected ports must have compatible types (except DisplayPort).
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validatePort_compatibleType(Port port, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// skip if not connected
		Port input = port.getIn();
		if (input == null)
			return true;
		
		// ignore Display ports
		if (port instanceof DisplayPort == false && port.getType() != input.getType()) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 MessageFormat.format("Ports ''{0}'' and ''{1}'' have incompatible types", new Object[] { port.getName(), input.getName()}),
						 new Object[] { port }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractVariable(AbstractVariable abstractVariable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(abstractVariable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFMUParameter(FMUParameter fmuParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(fmuParameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFMUPort(FMUPort fmuPort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_NoCircularContainment(fmuPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMultiplicityConforms(fmuPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(fmuPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(fmuPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(fmuPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(fmuPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(fmuPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(fmuPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(fmuPort, diagnostics, context);
		if (result || diagnostics != null) result &= validatePort_compatibleType(fmuPort, diagnostics, context);
		if (result || diagnostics != null) result &= validateFMUPort_validFMUReference(fmuPort, diagnostics, context);
		if (result || diagnostics != null) result &= validateFMUPort_inputConnected(fmuPort, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validFMUReference constraint of '<em>FMU Port</em>'.
	 * <!-- begin-user-doc -->
	 * FMU variable must have a valid FMU reference (name from the modelDescription.xml).
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateFMUPort_validFMUReference(FMUPort fmuPort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement actual FMU reference validation
		if (fmuPort.getName() == null) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "Undefined name",	
						 new Object[] { fmuPort }));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the inputConnected constraint of '<em>FMU Port</em>'.
	 * <!-- begin-user-doc -->
	 * FMU inputs must be connected to input signals.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateFMUPort_inputConnected(FMUPort fmuPort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (fmuPort.getCausality() == VariableCausality.INPUT && fmuPort.getIn() == null) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "FMU input must be connected",	
						 new Object[] { fmuPort }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEventBPort(EventBPort eventBPort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_NoCircularContainment(eventBPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMultiplicityConforms(eventBPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(eventBPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(eventBPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(eventBPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(eventBPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(eventBPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(eventBPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(eventBPort, diagnostics, context);
		if (result || diagnostics != null) result &= validatePort_compatibleType(eventBPort, diagnostics, context);
		if (result || diagnostics != null) result &= validateEventBPort_validEventBReference(eventBPort, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validEventBReference constraint of '<em>Event BPort</em>'.
	 * <!-- begin-user-doc -->
	 * Event-B port must have a reference to either a variable or a parameter, depending on its type.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateEventBPort_validEventBReference(EventBPort eventBPort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		String errorText = null;
		if (eventBPort.getCausality() == VariableCausality.INPUT && eventBPort.getParameter() == null)
			errorText = "Undefined input parameter";
		else if (eventBPort.getCausality() == VariableCausality.OUTPUT && eventBPort.getVariable() == null)
			errorText = "Undefined output variable";
		
		if (errorText != null) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 errorText,	
						 new Object[] { eventBPort }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDisplayComponent(DisplayComponent displayComponent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(displayComponent, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDisplayPort(DisplayPort displayPort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_NoCircularContainment(displayPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMultiplicityConforms(displayPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(displayPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(displayPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(displayPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(displayPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(displayPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(displayPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(displayPort, diagnostics, context);
		if (result || diagnostics != null) result &= validatePort_compatibleType(displayPort, diagnostics, context);
		if (result || diagnostics != null) result &= validateDisplayPort_nonStringInput(displayPort, diagnostics, context);
		return result;
	}

	/**
	 * Validates the nonStringInput constraint of '<em>Display Port</em>'.
	 * <!-- begin-user-doc -->
	 * Not supported String input.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateDisplayPort_nonStringInput(DisplayPort displayPort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Port input = displayPort.getIn();
		if (input != null && input.getType() == VariableType.STRING) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "String input not allowed by Display",	
						 new Object[] { displayPort }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableType(VariableType variableType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableCausality(VariableCausality variableCausality, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIStatus(IStatus iStatus, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFMU(FMU fmu, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateITrace2D(ITrace2D iTrace2D, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateChart2D(Chart2D chart2D, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateColor(Color color, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProBTrace(Trace proBTrace, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSimulationException(SimulationException simulationException, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelException(ModelException modelException, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //MultisimValidator
