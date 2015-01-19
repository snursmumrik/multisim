/**
 * Copyright (c) 2015 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.providers.custom;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;

import ac.soton.multisim.Component;

/**
 * @author vitaly
 *
 */
public class MultisimDecoratorProvider extends AbstractProvider implements IDecoratorProvider {

	/**
	 * @author vitaly
	 *
	 */
	public class RecordDecorator extends AbstractDecorator {

		public RecordDecorator(IDecoratorTarget decoratorTarget) {
			super(decoratorTarget);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void activate() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void refresh() {
			// TODO Auto-generated method stub
			
		}

	}

	public static final String RECORD = "recordDecorator";

	@Override
	public boolean provides(IOperation operation) {
		if (!(operation instanceof CreateDecoratorsOperation)) {
  			return false;
  		}
		
		IAdaptable adapter = ((CreateDecoratorsOperation) operation).getDecoratorTarget();
  		Object element = adapter.getAdapter(Component.class);
  		
  		return element != null;//ReviewDecorator.getDecoratorTargetNode(decoratorTarget) != null;
	}

	@Override
	public void createDecorators(IDecoratorTarget decoratorTarget) {
		Object element = decoratorTarget.getAdapter(Component.class);//Node node = ReviewDecorator.getDecoratorTargetNode(decoratorTarget);
		if (element != null) {
			decoratorTarget.installDecorator(RECORD, new RecordDecorator(decoratorTarget));
		}
	}
}
