package ac.soton.multisim.master;
/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */


import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import ac.soton.multisim.Component;
import ac.soton.multisim.ComponentDiagram;
import ac.soton.multisim.exception.ModelException;
import ac.soton.multisim.exception.SimulationException;
import ac.soton.multisim.util.SimulationStatus;
import ac.soton.multisim.util.SimulationUtil;

/**
 * Master algorithm for FMU-EventB co-simulation.
 * 
 * @author vitaly
 *
 */
public class TwoListMaster {

	private static final String PLUGIN_ID = "ac.soton.multisim.components.master";
	
	// simulation parameter names
	public static final String PARAMETER_START_TIME = "parameter.startTime";
	public static final String PARAMETER_STOP_TIME = "parameter.stopTime";
	public static final String PARAMETER_STEP_SIZE = "parameter.stepSize";
	public static final String PARAMETER_OUTPUT_FILE = "parameter.outputFile";

	// parameters
	private static ComponentDiagram diagram;
	private static int tCurrent;
	private static int tStart;
	private static int tStop;
	private static int step;
	
	// two-list
	private static Map<Component, Integer> updateList = new HashMap<Component, Integer>();
	private static List<Component> evaluationList = new ArrayList<Component>();
	
	private static File resultFile;
	private static BufferedWriter resultWriter;

	/**
	 * Simulate a diagram.
	 * @param cd
	 * @param monitor
	 * @param params
	 * @return
	 */
	public static IStatus simulate(ComponentDiagram cd, IProgressMonitor monitor, Map<String, String> params) {
		diagram = cd;
		tStart = diagram.getStartTime();
		tStop = diagram.getStopTime();
		step = diagram.getStepSize();
		resultFile = new File(params.get(PARAMETER_OUTPUT_FILE));
		updateList.clear();
		evaluationList.clear();
		int cStep;
		IStatus status = Status.OK_STATUS;
		long simulationTime = System.currentTimeMillis();
		
		try {
			// create output file
			resultWriter = SimulationUtil.apiCreateOutput((File) resultFile);

			// instantiate components
			for (Component c : diagram.getComponents())
				c.instantiate();
			
			// initialisation step
			for (Component c : diagram.getComponents()) {
				c.initialise(tStart, tStop);
				// time-zero initialisation
				updateList.put(c, tStart);
			}
			
			// header output
			SimulationUtil.apiOutputColumns(diagram, resultWriter);
	
			// simulation loop
			for (tCurrent = tStart; tCurrent <= tStop; ++tCurrent) {
				if (monitor.isCanceled()) {
					status = Status.CANCEL_STATUS;
					break;
				}
				
				// read update list for evaluation-ready components
				for (Component c : diagram.getComponents()) {
					if (tCurrent == updateList.get(c))
						evaluationList.add(c);
				}
				
				if (evaluationList.isEmpty())
					continue;
				
				// only simulate components in evaluation list
				// read port values
				for (Component c : evaluationList)
					c.writeOutputs();
				
				// write port values
				for (Component c : evaluationList)
					c.readInputs();
				
				// do step & update the update list
				for (Component c : evaluationList) {
					cStep = c.getStepPeriod() == 0 ? step : c.getStepPeriod();
					if (tCurrent + cStep <= tStop) {
						c.doStep(tCurrent, cStep);
						updateList.put(c, updateList.get(c) + cStep);
					}
				}
				
				// clear evaluation list
				evaluationList.clear();
				
				// write file output
				SimulationUtil.apiOutput(diagram, tCurrent, resultWriter);
			}
		} catch (SimulationException | ModelException | IOException e) {
			status = SimulationStatus.createErrorStatus("Simulation terminated.\n" + e.getMessage(), e);
		}

		// termination step
		for (Component c : diagram.getComponents())
			c.terminate();
		
		// close file
		try {
			resultWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (status.getSeverity() == Status.OK)
			status = SimulationStatus.createOKStatus("Completed in " + (System.currentTimeMillis() - simulationTime) + "ms");
		
		return status;
	}

}
