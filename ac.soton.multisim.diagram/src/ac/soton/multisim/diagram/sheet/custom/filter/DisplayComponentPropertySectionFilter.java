/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.sheet.custom.filter;

import ac.soton.multisim.DisplayComponent;

/**
 * Filter for Display component.
 * 
 * @author vitaly
 *
 */
public class DisplayComponentPropertySectionFilter extends
		AbstractPropertySectionFilter {
	@Override
	public boolean select(Object toTest) {
		return unwrap(toTest) instanceof DisplayComponent;
	}

}
