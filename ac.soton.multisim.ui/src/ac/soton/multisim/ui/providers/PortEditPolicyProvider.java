/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.ui.providers;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;

import ac.soton.multisim.diagram.edit.parts.DisplayPortEditPart;
import ac.soton.multisim.diagram.edit.parts.EventBInputPortEditPart;
import ac.soton.multisim.diagram.edit.parts.EventBOutputPortEditPart;
import ac.soton.multisim.diagram.edit.parts.FMUInputPortEditPart;
import ac.soton.multisim.diagram.edit.parts.FMUOutputPortEditPart;
import ac.soton.multisim.ui.policies.PortConnectionHandleEditPolicy;

/**
 * Any port edit policy provider.
 * 
 * @author vitaly
 *
 */
public class PortEditPolicyProvider implements IEditPolicyProvider {

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
			if (editPart instanceof DisplayPortEditPart
					|| editPart instanceof EventBInputPortEditPart
					|| editPart instanceof EventBOutputPortEditPart
					|| editPart instanceof FMUInputPortEditPart
					|| editPart instanceof FMUOutputPortEditPart)
				return true;
		}
		return false;
	}

	@Override
	public void createEditPolicies(EditPart editPart) {
		editPart.installEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE, new PortConnectionHandleEditPolicy());
	}

}
