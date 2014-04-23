/**
 * Copyright University of Dusseldorf, 2014
 */
package de.prob.cosimulation;

import java.util.Map;

import org.ptolemy.fmi.FMIScalarVariable;

public interface IFMUListener {

	void trigger(Map<String, FMIScalarVariable> variables);

}
