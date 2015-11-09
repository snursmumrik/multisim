package ac.soton.multisim.master;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eventb.core.IEventBProject;
import org.eventb.core.IMachineRoot;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.ptolemy.fmi.FMIModelDescription;
import org.ptolemy.fmi.FMUFile;
import org.rodinp.core.IRodinProject;
import org.rodinp.core.RodinDBException;

import ac.soton.multisim.common.SampleEventBTest;
import de.prob.animator.domainobjects.EvalResult;
import de.prob.animator.domainobjects.IEvalResult;
import de.prob.statespace.Trace;

/**
 * Master algorithm unit test.
 * Creates a sample Event-B machine and a composed DE-CT diagram
 * for co-simulation, and performs simulation of it.
 * 
 * @author vitaly
 *
 */
public class MasterTest extends SampleEventBTest {
	private IEventBProject eventBProject;

	/**
	 * Creates a temporary workspace project to contain the models used by the
	 * tests.
	 */
	@Before
	public void setUp() {
		try {
			super.setUp();
			eventBProject = createEventBProject("test");
			assertNotNull(eventBProject);

			IRodinProject rodinProject = eventBProject.getRodinProject();
			saveOpenable(rodinProject);
			assertTrue(rodinProject.exists());
		} catch (Exception e) {
			fail("Cannot create a test Rodin project");
		}
	}

	/**
	 * Deletes the test project for the resources used by tests.
	 */
	@After
	public void tearDown() {
		try {
			if (eventBProject != null && eventBProject.getRodinProject().exists())
				eventBProject.getRodinProject().getProject().delete(true, monitor);
		} catch (Exception e) {
			fail("Failed to delete the test project");
		}
		
		try {
			super.tearDown();
		} catch (Exception e) {
			fail("Failed to clean up after test");
		}
	}

	/**
	 * Tests if the FMU loading works in the unit test.
	 */
	@Test
	public void testFMULoad() {
		InputStream is = this.getClass().getResourceAsStream("/ct.fmu");
		assertNotNull(is);

		IProject project = eventBProject.getRodinProject().getProject();
		String fmuFileName = project.getFile("ct.fmu").getLocation().toOSString();
		try {
			File fmuFile = new File(fmuFileName);
			Files.copy(is, fmuFile.toPath());
			is.close();
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

		assertEquals("ct", description.modelName);
	}

	/**
	 * Tests if ProB animation works in the unit test.
	 */
	@Test
	public void testEventBAnimation() {
		// create machine file
		IMachineRoot machine = null;
		try {
			machine = createSampleMachine(eventBProject, "m0");
			assertNotNull(machine);
			saveOpenable(machine.getOpenable());
			assertTrue(machine.getResource().exists());
		} catch (RodinDBException e1) {
			fail("Cannot create a test Event-B machine");
		}

		// build workspace
		try {
			workspace.build(IncrementalProjectBuilder.FULL_BUILD, monitor);
		} catch (CoreException e) {
			fail("Failed to build the test workspace");
		}

		// animate machine
		Trace trace = getAnimationTrace(machine);
		assertNotNull(trace);
		
		trace = trace.anyEvent(null);
		IEvalResult evalResult = trace.getCurrentState().eval("var");
		assertTrue(evalResult instanceof EvalResult);
		
		String varValue = ((EvalResult) evalResult).getValue();
		assertEquals("TRUE", varValue);
		
		trace = trace.anyEvent(null);
		evalResult = trace.getCurrentState().eval("var");
		assertTrue(evalResult instanceof EvalResult);
		
		varValue = ((EvalResult) evalResult).getValue();
		assertEquals("FALSE", varValue);
	}
}
