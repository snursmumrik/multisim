package ac.soton.multisim.ui;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
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
	
	// Multisim job icon
    public static final String IMAGE_MULTISIM_JOB = "image.multisim.job";

    protected void initializeImageRegistry(ImageRegistry registry) {
       Bundle bundle = Platform.getBundle(PLUGIN_ID);
       IPath path = new Path("icons/SimulateJob.gif");
       URL url = FileLocator.find(bundle, path, null);
       ImageDescriptor desc = ImageDescriptor.createFromURL(url);
       registry.put(IMAGE_MULTISIM_JOB, desc);
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

}
