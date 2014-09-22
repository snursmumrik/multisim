package ac.soton.multisim.ui;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class MultisimUIActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "ac.soton.multisim.ui"; //$NON-NLS-1$

	// The shared instance
	private static MultisimUIActivator plugin;
	
	// images
    public static final String IMAGE_MULTISIM = "icons/Multisim.png";
	public static final String EVENTB_COMPONENT_IMAGE = "icons/EventBComponent_big.png";

	@Override
    protected void initializeImageRegistry(ImageRegistry registry) {
       loadImage(registry, IMAGE_MULTISIM);
//       loadImage(registry, EVENTB_COMPONENT_IMAGE);
    }
    
	protected void loadImage(ImageRegistry registry, String id) {
		loadImage(registry, id, getBundle().getSymbolicName());
	}

	protected void loadImage(ImageRegistry registry, String id, String bundleId) {
		ImageDescriptor descriptor = imageDescriptorFromPlugin(bundleId, id);
		if (descriptor != null) {
			registry.put(id, descriptor);
		}
	}
	
	/**
	 * The constructor
	 */
	public MultisimUIActivator() {
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static MultisimUIActivator getDefault() {
		return plugin;
	}
	
	/**
	 * Logs an error.
	 * 
	 * @param error
	 */
	public void logError(String error) {
		logError(error, null);
	}

	public void logError(String error, Throwable throwable) {
		if (error == null && throwable != null) {
			error = throwable.getMessage();
		}
		getLog().log(
				new Status(IStatus.ERROR, MultisimUIActivator.PLUGIN_ID,
						IStatus.OK, error, throwable));
		debug(error, throwable);
	}
	
	private void debug(String message, Throwable throwable) {
		if (!isDebugging()) {
			return;
		}
		if (message != null) {
			System.err.println(message);
		}
		if (throwable != null) {
			throwable.printStackTrace();
		}
	}
}
