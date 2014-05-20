/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package ac.soton.rms.components.impl;

import ac.soton.eventb.emf.core.extension.coreextension.impl.EventBLabeledImpl;
import info.monitorenter.gui.chart.Chart2D;
import info.monitorenter.gui.chart.IAxisScalePolicy;
import info.monitorenter.gui.chart.ITrace2D;
import info.monitorenter.gui.chart.ZoomableChart;
import info.monitorenter.gui.chart.axis.AxisLinear;
import info.monitorenter.gui.chart.labelformatters.LabelFormatterNumber;
import info.monitorenter.gui.chart.traces.Trace2DLtd;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Random;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import ac.soton.rms.components.AbstractVariable;
import ac.soton.rms.components.Component;
import ac.soton.rms.components.ComponentsPackage;
import ac.soton.rms.components.DisplayComponent;
import ac.soton.rms.components.DisplayPort;
import ac.soton.rms.components.Port;
import ac.soton.rms.components.VariableType;
import ac.soton.rms.components.util.custom.SimStatus;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Display Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.rms.components.impl.DisplayComponentImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link ac.soton.rms.components.impl.DisplayComponentImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link ac.soton.rms.components.impl.DisplayComponentImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link ac.soton.rms.components.impl.DisplayComponentImpl#getChart <em>Chart</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DisplayComponentImpl extends EventBLabeledImpl implements DisplayComponent {
	/**
	 * Maximum size of the visible chart trace.
	 * @custom
	 */
	private static final int MAX_TRACE_SIZE = 1500;
	/**
	 * Random colour generator.
	 * @custom
	 */
	private Random random = new Random(System.currentTimeMillis());

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2014 University of Southampton.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html";

	/**
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> inputs;
	/**
	 * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputs()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> outputs;
	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractVariable> variables;

	/**
	 * The default value of the '{@link #getChart() <em>Chart</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChart()
	 * @generated
	 * @ordered
	 */
	protected static final Chart2D CHART_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getChart() <em>Chart</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChart()
	 * @generated
	 * @ordered
	 */
	protected Chart2D chart = CHART_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DisplayComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentsPackage.Literals.DISPLAY_COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Port> getInputs() {
		if (inputs == null) {
			inputs = new EObjectContainmentEList.Resolving<Port>(Port.class, this, ComponentsPackage.DISPLAY_COMPONENT__INPUTS);
		}
		return inputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Port> getOutputs() {
		if (outputs == null) {
			outputs = new EObjectContainmentEList.Resolving<Port>(Port.class, this, ComponentsPackage.DISPLAY_COMPONENT__OUTPUTS);
		}
		return outputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractVariable> getVariables() {
		if (variables == null) {
			variables = new EObjectContainmentEList.Resolving<AbstractVariable>(AbstractVariable.class, this, ComponentsPackage.DISPLAY_COMPONENT__VARIABLES);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Chart2D getChart() {
		return chart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChart(Chart2D newChart) {
		Chart2D oldChart = chart;
		chart = newChart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.DISPLAY_COMPONENT__CHART, oldChart, chart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IStatus instantiate() {
		if (getChart() == null) {
			
			// new chart with double-click zoom out
			@SuppressWarnings("serial")
			Chart2D chart = new ZoomableChart() {
				long lastClickTime;
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					if (e.getWhen() - lastClickTime < 500)
						this.zoomAll();
					lastClickTime = e.getWhen();
				}
			};
			
			// remove original axes
		    chart.removeAxisXBottom(chart.getAxisX());
		    chart.removeAxisYLeft(chart.getAxisY());
		    
		    // empty label formatter for drawing border-like axes without marks
		    @SuppressWarnings("serial")
			LabelFormatterNumber lf = new LabelFormatterNumber(NumberFormat.getIntegerInstance()) {
		    	@Override
		    	public String format(double value) {
		    		return "0";
		    	}
		    };
		    
		    // set new axes (draw x/y at the top/right to make a border, but without the scale)
		    chart.setAxisXBottom(new AxisLinear<IAxisScalePolicy>(new LabelFormatterNumber(NumberFormat.getIntegerInstance())), 0);
		    chart.setAxisYLeft(new AxisLinear<IAxisScalePolicy>(new LabelFormatterNumber(NumberFormat.getIntegerInstance())), 0);
		    chart.setAxisYRight(new AxisLinear<IAxisScalePolicy>(lf), 0);
		    chart.setAxisXTop(new AxisLinear<IAxisScalePolicy>(lf), 0);
		    
		    // show grid
		    chart.getAxisX().setPaintGrid(true);
		    chart.getAxisY().setPaintGrid(true);
		    chart.setGridColor(new Color(224,224,224));
		    
		    // remove titles
		    chart.getAxisX().getAxisTitle().setTitle("");
		    chart.getAxisY().getAxisTitle().setTitle("");
		    
		    chart.setVisible(false);
		    // disable notification
		    eSetDeliver(false);
		    for (Port p : getInputs())
				p.eSetDeliver(false);
		    
			setChart(chart);
		}
		return SimStatus.OK_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IStatus initialise(double tStart, double tStop) {
		Chart2D chart = getChart();
		assert chart != null;
		
		// remove previous traces
		chart.removeAllTraces();	//XXX: is that required? do removed ports keep traces in a chart?

		// setup traces for all connected ports
		for (Port p : getInputs()) {
			assert p instanceof DisplayPort;
			DisplayPort port = (DisplayPort) p;
			Port input = port.getIn();
			
			if (input == null)
				continue;
			
			// prepare traces
		    ITrace2D trace = port.getTrace();
		    if (trace == null) {
		    	trace = new Trace2DLtd(MAX_TRACE_SIZE);
			    port.setTrace(trace);
		    } else {
		    	trace.removeAllPoints();
		    }
		    
		    // trace name = input component&port name 
			trace.setName(((Component) input.eContainer()).getLabel() + "." + input.getLabel());
		    
		    // set/generate colour
		    Color colour = port.getColor();
		    if (colour == null)
		    	colour = generateNewColour();
		    trace.setColor(colour);
		    
		    chart.addTrace(trace);
		}
		return SimStatus.OK_STATUS;
	}

	/**
	 * Generate a random colour.
	 * 
	 * @return
	 * @custom
	 */
	private Color generateNewColour() {
		final float hue = random.nextFloat();
		// Saturation between 0.7 and 0.9
		final float saturation = (random.nextInt(2000) + 7000) / 10000f;
		final float luminance = 0.8f;
		return Color.getHSBColor(hue, saturation, luminance);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IStatus readInputs() {
		return SimStatus.OK_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IStatus writeOutputs() {
		return SimStatus.OK_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IStatus doStep(double time, double step) {
		DisplayPort port = null;
		Port input = null;
		for (Port p : getInputs()) {
			assert p instanceof DisplayPort;
			port = (DisplayPort) p;
			input = port.getIn();
			
			// if port connected, plot the value
			if (port.getIn() != null) {
				assert port.getTrace() != null;
				
				Object value = input.getValue();
				double traceValue = 0;
				if (input.getType() == VariableType.REAL) {
					traceValue = ((Double) value).doubleValue();
				} else if (input.getType() == VariableType.INTEGER) {
					traceValue = ((Integer) value).intValue();
				} else if (input.getType() == VariableType.BOOLEAN) {
					traceValue = ((Boolean) value).booleanValue() ? 1 : 0;
				}
				port.getTrace().addPoint(time/1000, traceValue);
			}
		}
		return SimStatus.OK_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IStatus terminate() {
	    // re-enable notification
	    eSetDeliver(true);
	    for (Port p : getInputs())
			p.eSetDeliver(true);
		return SimStatus.OK_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComponentsPackage.DISPLAY_COMPONENT__INPUTS:
				return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
			case ComponentsPackage.DISPLAY_COMPONENT__OUTPUTS:
				return ((InternalEList<?>)getOutputs()).basicRemove(otherEnd, msgs);
			case ComponentsPackage.DISPLAY_COMPONENT__VARIABLES:
				return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentsPackage.DISPLAY_COMPONENT__INPUTS:
				return getInputs();
			case ComponentsPackage.DISPLAY_COMPONENT__OUTPUTS:
				return getOutputs();
			case ComponentsPackage.DISPLAY_COMPONENT__VARIABLES:
				return getVariables();
			case ComponentsPackage.DISPLAY_COMPONENT__CHART:
				return getChart();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ComponentsPackage.DISPLAY_COMPONENT__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends Port>)newValue);
				return;
			case ComponentsPackage.DISPLAY_COMPONENT__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends Port>)newValue);
				return;
			case ComponentsPackage.DISPLAY_COMPONENT__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends AbstractVariable>)newValue);
				return;
			case ComponentsPackage.DISPLAY_COMPONENT__CHART:
				setChart((Chart2D)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ComponentsPackage.DISPLAY_COMPONENT__INPUTS:
				getInputs().clear();
				return;
			case ComponentsPackage.DISPLAY_COMPONENT__OUTPUTS:
				getOutputs().clear();
				return;
			case ComponentsPackage.DISPLAY_COMPONENT__VARIABLES:
				getVariables().clear();
				return;
			case ComponentsPackage.DISPLAY_COMPONENT__CHART:
				setChart(CHART_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ComponentsPackage.DISPLAY_COMPONENT__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case ComponentsPackage.DISPLAY_COMPONENT__OUTPUTS:
				return outputs != null && !outputs.isEmpty();
			case ComponentsPackage.DISPLAY_COMPONENT__VARIABLES:
				return variables != null && !variables.isEmpty();
			case ComponentsPackage.DISPLAY_COMPONENT__CHART:
				return CHART_EDEFAULT == null ? chart != null : !CHART_EDEFAULT.equals(chart);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (chart: ");
		result.append(chart);
		result.append(')');
		return result.toString();
	}

	@Override
	public String getLabel() {
		return "Display";
	}

} //DisplayComponentImpl
