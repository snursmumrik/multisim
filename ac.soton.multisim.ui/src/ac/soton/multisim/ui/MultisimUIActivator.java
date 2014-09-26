package ac.soton.multisim.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
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
	public static final String IMAGE_HANDLE_IN_NORTH = "icons/handle_incoming_north.png";
	public static final String IMAGE_HANDLE_IN_SOUTH = "icons/handle_incoming_south.png";
	public static final String IMAGE_HANDLE_IN_WEST = "icons/handle_incoming_west.png";
	public static final String IMAGE_HANDLE_IN_EAST = "icons/handle_incoming_east.png";
	public static final String IMAGE_HANDLE_OUT_NORTH = "icons/handle_outgoing_north.png";
	public static final String IMAGE_HANDLE_OUT_SOUTH = "icons/handle_outgoing_south.png";
	public static final String IMAGE_HANDLE_OUT_WEST = "icons/handle_outgoing_west.png";
	public static final String IMAGE_HANDLE_OUT_EAST = "icons/handle_outgoing_east.png";

	@Override
    protected void initializeImageRegistry(ImageRegistry registry) {
       loadImage(registry, IMAGE_MULTISIM);
       loadImage(registry, IMAGE_HANDLE_IN_NORTH);
       loadImage(registry, IMAGE_HANDLE_IN_SOUTH);
       loadImage(registry, IMAGE_HANDLE_IN_WEST);
       loadImage(registry, IMAGE_HANDLE_IN_EAST);
       loadImage(registry, IMAGE_HANDLE_OUT_NORTH);
       loadImage(registry, IMAGE_HANDLE_OUT_SOUTH);
       loadImage(registry, IMAGE_HANDLE_OUT_WEST);
       loadImage(registry, IMAGE_HANDLE_OUT_EAST);
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

	public static Image getImage(String id) {
		if (plugin == null)
			return null;
		return plugin.getImageRegistry().get(id);
	}
}
