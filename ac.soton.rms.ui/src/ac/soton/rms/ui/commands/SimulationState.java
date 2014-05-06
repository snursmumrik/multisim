/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.rms.ui.commands;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISources;

import ac.soton.rms.master.Master;

/**
 * @author vitaly
 *
 */
public class SimulationState extends AbstractSourceProvider {

	public static final String SIM_ACTIVE = "ac.soton.rms.ui.commands.simulation.active";
	private static final String ACTIVE = "ACTIVE";
	private static final String INACTIVE = "INACTIVE";
	private boolean active;

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("rawtypes")
	@Override
	public Map getCurrentState() {
		Map map = new HashMap(1);
		String value = active ? ACTIVE : INACTIVE;
		map.put(SIM_ACTIVE, value);
		return map;
	}

	@Override
	public String[] getProvidedSourceNames() {
		return new String[] { SIM_ACTIVE };
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
		String value = active ? ACTIVE : INACTIVE;
		fireSourceChanged(ISources.WORKBENCH, SIM_ACTIVE, value);
	}

}
