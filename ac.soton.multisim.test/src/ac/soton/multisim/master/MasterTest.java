package ac.soton.multisim.master;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

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
			Files.copy(is, fmuFile.toPath());
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
}
