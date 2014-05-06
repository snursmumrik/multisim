package ac.soton.rms.ui;

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
public class RmsUIActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "ac.soton.rms.ui"; //$NON-NLS-1$

	// The shared instance
	private static RmsUIActivator plugin;
	
    public static final String IMAGE_RMS = "image.rms";

    protected void initializeImageRegistry(ImageRegistry registry) {
       Bundle bundle = Platform.getBundle(PLUGIN_ID);
       IPath path = new Path("icons/SimulateJob.gif");
       URL url = FileLocator.find(bundle, path, null);
       ImageDescriptor desc = ImageDescriptor.createFromURL(url);
       registry.put(IMAGE_RMS, desc);
    }
	
	/**
	 * The constructor
	 */
	public RmsUIActivator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static RmsUIActivator getDefault() {
		return plugin;
	}

}
