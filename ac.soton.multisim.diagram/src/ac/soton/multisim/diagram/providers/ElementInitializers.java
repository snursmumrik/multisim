/*
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.diagram.providers;

import ac.soton.multisim.DisplayPort;
import ac.soton.multisim.EventBPort;
import ac.soton.multisim.FMUPort;
import ac.soton.multisim.MultisimPackage;
import ac.soton.multisim.VariableCausality;
import ac.soton.multisim.diagram.expressions.MultisimAbstractExpression;
import ac.soton.multisim.diagram.expressions.MultisimOCLFactory;
import ac.soton.multisim.diagram.part.MultisimDiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	 * @generated
	 */
	public void init_DisplayPort_3001(DisplayPort instance) {
		try {
			Object value_0 = MultisimOCLFactory.getExpression(1,
					MultisimPackage.eINSTANCE.getDisplayPort(), null).evaluate(
					instance);

			value_0 = MultisimAbstractExpression.performCast(value_0,
					MultisimPackage.eINSTANCE.getVariableCausality());
			instance.setCausality((VariableCausality) value_0);
		} catch (RuntimeException e) {
			MultisimDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_FMUPort_3002(FMUPort instance) {
		try {
			Object value_0 = MultisimOCLFactory.getExpression(3,
					MultisimPackage.eINSTANCE.getFMUPort(), null).evaluate(
					instance);

			value_0 = MultisimAbstractExpression.performCast(value_0,
					MultisimPackage.eINSTANCE.getVariableCausality());
			instance.setCausality((VariableCausality) value_0);
		} catch (RuntimeException e) {
			MultisimDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_FMUPort_3003(FMUPort instance) {
		try {
			Object value_0 = MultisimOCLFactory.getExpression(5,
					MultisimPackage.eINSTANCE.getFMUPort(), null).evaluate(
					instance);

			value_0 = MultisimAbstractExpression.performCast(value_0,
					MultisimPackage.eINSTANCE.getVariableCausality());
			instance.setCausality((VariableCausality) value_0);
		} catch (RuntimeException e) {
			MultisimDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_EventBPort_3005(EventBPort instance) {
		try {
			Object value_0 = MultisimOCLFactory.getExpression(7,
					MultisimPackage.eINSTANCE.getEventBPort(), null).evaluate(
					instance);

			value_0 = MultisimAbstractExpression.performCast(value_0,
					MultisimPackage.eINSTANCE.getVariableCausality());
			instance.setCausality((VariableCausality) value_0);
		} catch (RuntimeException e) {
			MultisimDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_EventBPort_3006(EventBPort instance) {
		try {
			Object value_0 = MultisimOCLFactory.getExpression(9,
					MultisimPackage.eINSTANCE.getEventBPort(), null).evaluate(
					instance);

			value_0 = MultisimAbstractExpression.performCast(value_0,
					MultisimPackage.eINSTANCE.getVariableCausality());
			instance.setCausality((VariableCausality) value_0);
		} catch (RuntimeException e) {
			MultisimDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static ElementInitializers getInstance() {
		ElementInitializers cached = MultisimDiagramEditorPlugin.getInstance()
				.getElementInitializers();
		if (cached == null) {
			MultisimDiagramEditorPlugin.getInstance().setElementInitializers(
					cached = new ElementInitializers());
		}
		return cached;
	}
}
