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
	
	@Test
	public void testSimulateDECT() throws CoreException, IOException, InterruptedException {
//		IMachineRoot machine = createSampleMachineDE(eventBProject, "m0");
//
//		createVariable(machine, "y");
//		createVariable(machine, "io");
//		createInvariant(machine, "inv1", "y" + MEMBER_OF + INT, false);
//		createInvariant(machine, "inv2", "io" + MEMBER_OF + BOOL, false);
//
//		IEvent init = createEvent(machine, "INITIALISATION");
//		createAction(init, "act1", "y" + ASSIGN + "0");
//		createAction(init, "act2", "io" + ASSIGN + "TRUE");
//
//		IEvent read = createEvent(machine, "read");
//		createParameter(read, "u");
//		createGuard(read, "grd1", "u" + MEMBER_OF + INT, false);
//		createGuard(read, "grd2", "io = TRUE", false);
//		createAction(read, "act1", "y" + ASSIGN + "u");
//		createAction(read, "act2", "io" + ASSIGN + "FALSE");
//
//		IEvent wait = createEvent(machine, "wait");
//		createGuard(wait, "grd1", "io = FALSE", false);
//		createAction(wait, "act1", "io" + ASSIGN + "TRUE");
//		createAction(wait, "act2", "y" + ASSIGN + "y+1");
//
//		// save file and build workspace - this triggers static check, and
//		// generates missing files
//		machine.getRodinFile().save(monitor, false);
//		workspace.build(IncrementalProjectBuilder.FULL_BUILD, monitor);
//		IProject projectRes = ResourcesPlugin.getWorkspace().getRoot().getProject("MATest");
//
//		// FMU
//		URL base = Platform.getBundle("ac.soton.rms.master.test").getEntry("fmu/src/models");
//		String command = "make";
//		String[] envp = {};
//		File dir = new File(FileLocator.toFileURL(base).getPath());
//		Process proc = Runtime.getRuntime().exec(command, envp, dir);
//		assertTrue(proc.waitFor() == 0);
//		File fmuFile = new File(dir.getPath().replaceFirst("src/models", "fmu/ct.fmu"));
//		assertTrue(fmuFile.exists());
//		FileUtils.copyFileToDirectory(fmuFile, new File(projectRes.getLocation().toOSString()));
//
//		// EMF
//		ResourceSetImpl rs = new ResourceSetImpl();
//		IFile file = projectRes.getFile(DE_NAME + ".bum");
//		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
//		Resource resource = rs.getResource(uri, true);
//		Machine m = (Machine) resource.getContents().get(0);
//
//		ComponentDiagram diagram = MultisimFactory.eINSTANCE.createComponentDiagram();
//
//		EventBComponent de = MultisimFactory.eINSTANCE.createEventBComponent();
//		de.setMachine(m);
//		for (Event e : m.getEvents()) {
//			if (e.getName().equals("read")) {
//				de.getStartStepEvents().add(e);
//				EventBPort u = MultisimFactory.eINSTANCE.createEventBPort();
//				u.setParameter(e.getParameters().get(0));
//				u.setType(VariableType.INTEGER);
//				u.setCausality(VariableCausality.INPUT);
//				de.getInputs().add(u);
//			} else if (e.getName().equals("wait")) {
//				de.getEndStepEvents().add(e);
//			}
//		}
//		EventBPort y = MultisimFactory.eINSTANCE.createEventBPort();
//		y.setVariable(m.getVariables().get(m.getVariables().get(0).getName().equals("y") ? 0 : 1));
//		y.setType(VariableType.INTEGER);
//		y.setCausality(VariableCausality.OUTPUT);
//		de.getOutputs().add(y);
//		de.setStepSize(3000);
//
//		FMUComponent ct = MultisimFactory.eINSTANCE.createFMUComponent();
//		ct.setName(CT_NAME + "1");
//		ct.setPath(fmuFile.getPath());
//		FMUPort uc = MultisimFactory.eINSTANCE.createFMUPort();
//		uc.setCausality(VariableCausality.INPUT);
//		uc.setType(VariableType.INTEGER);
//		uc.setName("u");
//		ct.getInputs().add(uc);
//		FMUPort yc = MultisimFactory.eINSTANCE.createFMUPort();
//		yc.setCausality(VariableCausality.OUTPUT);
//		yc.setType(VariableType.INTEGER);
//		yc.setName("y");
//		ct.getOutputs().add(yc);
//
//		de.getInputs().get(0).setIn(ct.getOutputs().get(0));
//		ct.getInputs().get(0).setIn(de.getOutputs().get(0));
//		diagram.getComponents().add(de);
//		diagram.getComponents().add(ct);
//		diagram.setStartTime(0);
//		diagram.setStopTime(12000);
//		Master.simulate(diagram, null, new NullProgressMonitor());
//
//		Object y1 = de.getOutputs().get(0).getValue();
//		Object y2 = ct.getOutputs().get(0).getValue();
//		System.out.println(de.getName() + ".y=" + y1);
//		System.out.println(ct.getName() + ".y=" + y2);
//		assertTrue((int) y1 == 6 && (int) y2 == 8);
	}
}
