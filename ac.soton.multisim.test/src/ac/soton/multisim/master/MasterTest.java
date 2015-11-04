package ac.soton.multisim.master;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.junit.Test;
import org.ptolemy.fmi.FMIModelDescription;
import org.ptolemy.fmi.FMUFile;

public class MasterTest {

	@Test
	public void testFMULoad() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		assertNotNull(workspace);
		
		InputStream is = this.getClass().getResourceAsStream("/ct.fmu");
		assertNotNull(is);
		
		IProject project = workspace.getRoot().getProject("CT");
		try {
			project.create(null);
			project.open(null);
		} catch (CoreException e) {
			fail("Cannot create a workspace project");
		}
		
		String fmuFileName = project.getFile("ct.fmu").getLocation().toOSString();
		try {
			File fmuFile = new File(fmuFileName);
			FileUtils.copyInputStreamToFile(is, fmuFile);
		} catch (IOException e) {
			fail("Cannot copy FMU to the project");
		}
		
		FMIModelDescription description = null;
		try {
			description = FMUFile.parseFMUFile(fmuFileName);
			assertNotNull(description);
		} catch (IOException e) {
			fail("Cannot parse the FMU file: " + fmuFileName);
		}
		
		assertNotNull(description.modelName);
		
	}
	
//	@Test
//	public final void testFMUBuild() throws IOException, InterruptedException {
//		MasterTest.class.getClassLoader().
//		URL base = Platform.getBundle("ac.soton.multisim.tests").getEntry("fmu/src/models");
//		String command = "make";
//		String[] envp = {};
//		File dir = new File(FileLocator.toFileURL(base).getPath()) ;
//		Process proc = Runtime.getRuntime().exec(command, envp, dir);
//		assertTrue(proc.waitFor() == 0);
//		File fmuFile = new File(dir.getPath().replaceFirst("src/models", "fmu/inc.fmu"));
//		assertTrue(fmuFile.exists());
//		
//		FileUtils.copyFileToDirectory(fmuFile, new File(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString()));
//	}

}
