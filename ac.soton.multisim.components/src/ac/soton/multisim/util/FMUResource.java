/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.util;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IResource;
import org.ptolemy.fmi.FMIModelDescription;
import org.ptolemy.fmi.FMUFile;

/**
 * FMU resource (file) wrapper.
 * 
 * @author vitaly
 *
 */
public class FMUResource {

	private File file;
	private FMIModelDescription md;

	public FMUResource(File file) {
		this.file = file;
		try {
			md = FMUFile.parseFMUFile(file.getAbsolutePath());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public FMUResource(IResource res) {
		this(new File(res.getLocation().toOSString()));
	}
	
	public FMUResource(String path) {
		this(new File(path));
	}

	public String getName() {
		return md.modelName;
	}
	
	public File getFile() {
		return file;
	}
}
