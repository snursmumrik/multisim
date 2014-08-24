/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.rms.components.util;

import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Parameter;
import ac.soton.rms.components.AbstractVariable;
import ac.soton.rms.components.Component;
import ac.soton.rms.components.ComponentDiagram;
import ac.soton.rms.components.ComponentsPackage;
import ac.soton.rms.components.DisplayComponent;
import ac.soton.rms.components.DisplayPort;
import ac.soton.rms.components.EventBComponent;
import ac.soton.rms.components.EventBPort;
import ac.soton.rms.components.FMUComponent;
import ac.soton.rms.components.FMUParameter;
import ac.soton.rms.components.FMUPort;
import ac.soton.rms.components.Port;
import ac.soton.rms.components.VariableCausality;
import ac.soton.rms.components.VariableType;
import de.prob.cosimulation.FMU;
import de.prob.statespace.Trace;
import info.monitorenter.gui.chart.Chart2D;
import info.monitorenter.gui.chart.ITrace2D;
import java.awt.Color;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see ac.soton.rms.components.ComponentsPackage
 * @generated
 */
public class ComponentsValidator extends EObjectValidator {
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
	public static final ComponentsValidator INSTANCE = new ComponentsValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "ac.soton.rms.components";

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
	public ComponentsValidator() {
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
	  return ComponentsPackage.eINSTANCE;
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
			case ComponentsPackage.COMPONENT_DIAGRAM:
				return validateComponentDiagram((ComponentDiagram)value, diagnostics, context);
			case ComponentsPackage.COMPONENT:
				return validateComponent((Component)value, diagnostics, context);
			case ComponentsPackage.EVENT_BCOMPONENT:
				return validateEventBComponent((EventBComponent)value, diagnostics, context);
			case ComponentsPackage.FMU_COMPONENT:
				return validateFMUComponent((FMUComponent)value, diagnostics, context);
			case ComponentsPackage.PORT:
				return validatePort((Port)value, diagnostics, context);
			case ComponentsPackage.ABSTRACT_VARIABLE:
				return validateAbstractVariable((AbstractVariable)value, diagnostics, context);
			case ComponentsPackage.FMU_PARAMETER:
				return validateFMUParameter((FMUParameter)value, diagnostics, context);
			case ComponentsPackage.FMU_PORT:
				return validateFMUPort((FMUPort)value, diagnostics, context);
			case ComponentsPackage.EVENT_BPORT:
				return validateEventBPort((EventBPort)value, diagnostics, context);
			case ComponentsPackage.DISPLAY_COMPONENT:
				return validateDisplayComponent((DisplayComponent)value, diagnostics, context);
			case ComponentsPackage.DISPLAY_PORT:
				return validateDisplayPort((DisplayPort)value, diagnostics, context);
			case ComponentsPackage.VARIABLE_TYPE:
				return validateVariableType((VariableType)value, diagnostics, context);
			case ComponentsPackage.VARIABLE_CAUSALITY:
				return validateVariableCausality((VariableCausality)value, diagnostics, context);
			case ComponentsPackage.ISTATUS:
				return validateIStatus((IStatus)value, diagnostics, context);
			case ComponentsPackage.FMU:
				return validateFMU((FMU)value, diagnostics, context);
			case ComponentsPackage.ITRACE2_D:
				return validateITrace2D((ITrace2D)value, diagnostics, context);
			case ComponentsPackage.CHART2_D:
				return validateChart2D((Chart2D)value, diagnostics, context);
			case ComponentsPackage.COLOR:
				return validateColor((Color)value, diagnostics, context);
			case ComponentsPackage.PRO_BTRACE:
				return validateProBTrace((Trace)value, diagnostics, context);
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
		return validate_EveryDefaultConstraint(componentDiagram, diagnostics, context);
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
		if (!validate_NoCircularContainment(eventBComponent, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(eventBComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(eventBComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(eventBComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(eventBComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(eventBComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(eventBComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(eventBComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(eventBComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateEventBComponent_consistentReadEvents(eventBComponent, diagnostics, context);
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
		EList<Event> events = eventBComponent.getReadInputEvents();
		// skip single event
		if (events.size() <= 1)
			return true;
		
		// read first
		Event event1 = events.get(0);
		Set<String> paramNames = new HashSet<String>(event1.getParameters().size());
		for (Parameter p : event1.getParameters())
			paramNames.add(p.getName());
		
		// compare to the rest
		boolean failed = false;
		Event event2 = null;
		for (Event e : events) {
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
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",	// MessageFormat.format("Component ''{0}'' has inconsistent read input events ''{1}'' and ''{2}'' (mismatched number/names of parameters)", new Object[] { eventBComponent.getName(), event1.getName(), event2.getName() }),	
						 new Object[] { "consistentReadEvents", getObjectLabel(eventBComponent, context) },
						 new Object[] { eventBComponent },
						 context));
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
		if (!validate_NoCircularContainment(fmuComponent, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(fmuComponent, diagnostics, context);
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
	 * FMU path must point to an existing file.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateFMUComponent_validPath(FMUComponent fmuComponent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		String path = fmuComponent.getPath();
		if (path == null || new File(path).exists() == false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",	// MessageFormat.format("Component ''{0}'' must have a valid FMU path"
						 new Object[] { "validPath", getObjectLabel(fmuComponent, context) },	// new Object[] { this.getName() }
						 new Object[] { fmuComponent },
						 context));
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
		if (!validate_NoCircularContainment(port, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(port, diagnostics, context);
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
		
		if (port.getType() != input.getType() && port instanceof DisplayPort == false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",	// MessageFormat.format("Connected ports ''{0}'' and ''{1}'' have incompatible types"
						 new Object[] { "compatibleType", getObjectLabel(port, context) },	// , new Object[] { port1.getName(), port2.getName())
						 new Object[] { port },
						 context));
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
		if (!validate_NoCircularContainment(fmuPort, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(fmuPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(fmuPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(fmuPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(fmuPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(fmuPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(fmuPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(fmuPort, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(fmuPort, diagnostics, context);
		if (result || diagnostics != null) result &= validatePort_compatibleType(fmuPort, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEventBPort(EventBPort eventBPort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(eventBPort, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(eventBPort, diagnostics, context);
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
		//TODO: cover type&reference combinations and set the error message accordingly
		if (eventBPort.getParameter() == null && eventBPort.getVariable() == null) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "validEventBReference", getObjectLabel(eventBPort, context) },
						 new Object[] { eventBPort },
						 context));
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
		if (!validate_NoCircularContainment(displayPort, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(displayPort, diagnostics, context);
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
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "nonStringInput", getObjectLabel(displayPort, context) },
						 new Object[] { displayPort },
						 context));
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

} //ComponentsValidator
