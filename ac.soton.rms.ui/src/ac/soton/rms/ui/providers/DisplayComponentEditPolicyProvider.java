/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.rms.ui.providers;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;

import ac.soton.rms.components.diagram.edit.parts.DisplayComponentEditPart;
import ac.soton.rms.ui.policies.DisplayComponentOpenEditPolicy;

/**
 * Provides open edit policy for opening a chart on a double-click of the Display component.
 * 
 * @author vitaly
 *
 */
public class DisplayComponentEditPolicyProvider implements IEditPolicyProvider {

	@Override
	public void addProviderChangeListener(IProviderChangeListener listener) {
	}

	@Override
	public void removeProviderChangeListener(IProviderChangeListener listener) {
	}

	@Override
	public boolean provides(IOperation operation) {
		if (operation instanceof CreateEditPoliciesOperation) {
			EditPart editPart = ((CreateEditPoliciesOperation) operation).getEditPart();
			if (editPart instanceof DisplayComponentEditPart)
				return true;
		}
		return false;
	}

	@Override
	public void createEditPolicies(EditPart editPart) {
		editPart.installEditPolicy(EditPolicyRoles.OPEN_ROLE, new DisplayComponentOpenEditPolicy());
	}

}
