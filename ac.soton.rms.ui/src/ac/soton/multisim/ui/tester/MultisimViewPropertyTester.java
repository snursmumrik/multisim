/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.ui.tester;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.gmf.runtime.notation.View;

import ac.soton.multisim.ComponentDiagram;

/**
 * Multisim view property tester.
 * 
 * @author vitaly
 *
 */
public class MultisimViewPropertyTester extends PropertyTester {

	private static final Object IS_DIAGRAM_PROPERTY = "isDiagram";

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		View view = (View) receiver;
		
		if (IS_DIAGRAM_PROPERTY.equals(property)) {
			return view.getElement() instanceof ComponentDiagram;
		}
		
		return false;
	}

}
