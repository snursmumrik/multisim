/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.ui.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISources;

/**
 * Simulation state source provider for the UI command handlers.
 * 
 * @author vitaly
 *
 */
public class SimulationStateSourceProvider extends AbstractSourceProvider {

	public static final String STATE_SIMULATING = "ac.soton.multisim.state.simulating";
	
	private static final String TRUE = "T";
	private static final String FALSE = "F";
	private boolean simulating;

	@Override
	public void dispose() {
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map getCurrentState() {
		Map map = new HashMap(1);
		String value = simulating ? TRUE : FALSE;
		map.put(STATE_SIMULATING, value);
		return map;
	}

	@Override
	public String[] getProvidedSourceNames() {
		return new String[] { STATE_SIMULATING };
	}

	/**
	 * @param state
	 */
	public void setSimulating(boolean state) {
		this.simulating = state;
		String value = state ? TRUE : FALSE;
		fireSourceChanged(ISources.WORKBENCH, STATE_SIMULATING, value);
	}

}
