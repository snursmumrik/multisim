/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.rms.components.util.custom;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eventb.core.IEventBRoot;
import org.eventb.emf.core.machine.Machine;
import org.rodinp.core.IRodinFile;
import org.rodinp.core.RodinCore;

import de.prob.cosimulation.FMU;
import ac.soton.rms.components.AbstractVariable;
import ac.soton.rms.components.FMUParameter;
import ac.soton.rms.components.VariableType;

/**
 * @author vitaly
 *
 */
public class SimulationUtil {
	
	/**
	 * Returns Event-B Root element of a machine.
	 * @param machine
	 * @return
	 */
	public static IEventBRoot getMachineRoot(Machine machine) {
		Resource resource = machine.eResource();
		if (resource != null && resource.isLoaded()) {
			IFile file = WorkspaceSynchronizer.getFile(resource);
			IRodinFile rodinFile = RodinCore.valueOf(file);
			if (rodinFile != null)
				return (IEventBRoot) rodinFile.getRoot();
		}
		return null;
	}

	/**
	 * Returns FMI value from provided Event-B (string) value.
	 * NOTE: As doubles are not yet supported by Event-B,
	 * they are modelled as integers, converted from a double
	 * with a specified precision: double = int / (10 ^ precision)
	 * 
	 * @param value 
	 * @param type
	 * @param intToReal integer to real conversion precision
	 * @return
	 */
	public static Object getFMIValue(String value, VariableType type, int intToReal) {
		switch (type) {
		case BOOLEAN:
			return Boolean.valueOf(value);
		case INTEGER:
			return Integer.valueOf(value);
		case REAL:
			Integer integer = Integer.valueOf(value);
			return integer.doubleValue() / Math.pow(10d, intToReal);
		case STRING:
		default:
			return value;
		}
	}

	/**
	 * @param value
	 * @param type
	 * @param intToReal
	 * @return
	 */
	public static String getEventBValue(Object value, VariableType type,
			int intToReal) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param fmu
	 * @param variable
	 * @param value
	 */
	public static void fmuSet(FMU fmu, AbstractVariable variable, Object value) {
		String name = variable.getLabel();
		switch (variable.getType()) {
		case BOOLEAN:
			fmu.set(name, (Boolean) value);
			break;
		case INTEGER:
			fmu.set(name, (Integer) value);
			break;
		case REAL:
			fmu.set(name, (Double) value);
			break;
		case STRING:
			fmu.set(name, (String) value);
			break;
		}
	}

	/**
	 * @param fmu
	 * @param variable
	 * @return
	 */
	public static Object fmuGet(FMU fmu, AbstractVariable variable) {
		String name = variable.getLabel();
		Object value = null;
		switch (variable.getType()) {
		case BOOLEAN:
			value  = fmu.getBoolean(name) == false; //XXX: hack to fix the bug with JFMI (returns negated value of actual boolean value)
			break;
		case INTEGER:
			value = fmu.getInt(name);
			break;
		case REAL:
			value = fmu.getDouble(name);
			break;
		case STRING:
			value = fmu.getString(name);
			break;
		}
		return value;
	}

	
}
