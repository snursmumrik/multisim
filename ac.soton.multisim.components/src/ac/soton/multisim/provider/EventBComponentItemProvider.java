/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package ac.soton.multisim.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITableItemColorProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.provider.AbstractExtensionItemProvider;

import ac.soton.multisim.EventBComponent;
import ac.soton.multisim.MultisimFactory;
import ac.soton.multisim.MultisimPackage;

/**
 * This is the item provider adapter for a {@link ac.soton.multisim.EventBComponent} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EventBComponentItemProvider
	extends AbstractExtensionItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource,
		ITableItemLabelProvider,
		ITableItemColorProvider,
		IItemColorProvider {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2014 University of Southampton.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html";

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventBComponentItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addCommentPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addStepPeriodPropertyDescriptor(object);
			addMachinePropertyDescriptor(object);
			addComposedPropertyDescriptor(object);
			addStartStepEventsPropertyDescriptor(object);
			addEndStepEventsPropertyDescriptor(object);
			addTracePropertyDescriptor(object);
			addRecordTracePropertyDescriptor(object);
			addTraceFileNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Comment feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCommentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EventBCommented_comment_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EventBCommented_comment_feature", "_UI_EventBCommented_type"),
				 CorePackage.Literals.EVENT_BCOMMENTED__COMMENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EventBNamed_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EventBNamed_name_feature", "_UI_EventBNamed_type"),
				 CorePackage.Literals.EVENT_BNAMED__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Step Period feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStepPeriodPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Component_stepPeriod_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Component_stepPeriod_feature", "_UI_Component_type"),
				 MultisimPackage.Literals.COMPONENT__STEP_PERIOD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTracePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EventBComponent_trace_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EventBComponent_trace_feature", "_UI_EventBComponent_type"),
				 MultisimPackage.Literals.EVENT_BCOMPONENT__TRACE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Record Trace feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRecordTracePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EventBComponent_recordTrace_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EventBComponent_recordTrace_feature", "_UI_EventBComponent_type"),
				 MultisimPackage.Literals.EVENT_BCOMPONENT__RECORD_TRACE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace File Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceFileNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EventBComponent_traceFileName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EventBComponent_traceFileName_feature", "_UI_EventBComponent_type"),
				 MultisimPackage.Literals.EVENT_BCOMPONENT__TRACE_FILE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Machine feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMachinePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EventBComponent_machine_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EventBComponent_machine_feature", "_UI_EventBComponent_type"),
				 MultisimPackage.Literals.EVENT_BCOMPONENT__MACHINE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Composed feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addComposedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EventBComponent_composed_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EventBComponent_composed_feature", "_UI_EventBComponent_type"),
				 MultisimPackage.Literals.EVENT_BCOMPONENT__COMPOSED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Start Step Events feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStartStepEventsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EventBComponent_startStepEvents_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EventBComponent_startStepEvents_feature", "_UI_EventBComponent_type"),
				 MultisimPackage.Literals.EVENT_BCOMPONENT__START_STEP_EVENTS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the End Step Events feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEndStepEventsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EventBComponent_endStepEvents_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EventBComponent_endStepEvents_feature", "_UI_EventBComponent_type"),
				 MultisimPackage.Literals.EVENT_BCOMPONENT__END_STEP_EVENTS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(MultisimPackage.Literals.COMPONENT__INPUTS);
			childrenFeatures.add(MultisimPackage.Literals.COMPONENT__OUTPUTS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns EventBComponent.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/EventBComponent"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((EventBComponent)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_EventBComponent_type") :
			getString("_UI_EventBComponent_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(EventBComponent.class)) {
			case MultisimPackage.EVENT_BCOMPONENT__COMMENT:
			case MultisimPackage.EVENT_BCOMPONENT__NAME:
			case MultisimPackage.EVENT_BCOMPONENT__STEP_PERIOD:
			case MultisimPackage.EVENT_BCOMPONENT__COMPOSED:
			case MultisimPackage.EVENT_BCOMPONENT__RECORD_TRACE:
			case MultisimPackage.EVENT_BCOMPONENT__TRACE_FILE_NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case MultisimPackage.EVENT_BCOMPONENT__INPUTS:
			case MultisimPackage.EVENT_BCOMPONENT__OUTPUTS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EVENT_BELEMENT__EXTENSIONS,
				 MultisimFactory.eINSTANCE.createEventBComponent()));

		newChildDescriptors.add
			(createChildParameter
				(MultisimPackage.Literals.COMPONENT__INPUTS,
				 MultisimFactory.eINSTANCE.createFMUPort()));

		newChildDescriptors.add
			(createChildParameter
				(MultisimPackage.Literals.COMPONENT__INPUTS,
				 MultisimFactory.eINSTANCE.createEventBPort()));

		newChildDescriptors.add
			(createChildParameter
				(MultisimPackage.Literals.COMPONENT__INPUTS,
				 MultisimFactory.eINSTANCE.createDisplayPort()));

		newChildDescriptors.add
			(createChildParameter
				(MultisimPackage.Literals.COMPONENT__OUTPUTS,
				 MultisimFactory.eINSTANCE.createFMUPort()));

		newChildDescriptors.add
			(createChildParameter
				(MultisimPackage.Literals.COMPONENT__OUTPUTS,
				 MultisimFactory.eINSTANCE.createEventBPort()));

		newChildDescriptors.add
			(createChildParameter
				(MultisimPackage.Literals.COMPONENT__OUTPUTS,
				 MultisimFactory.eINSTANCE.createDisplayPort()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == MultisimPackage.Literals.COMPONENT__INPUTS ||
			childFeature == MultisimPackage.Literals.COMPONENT__OUTPUTS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
