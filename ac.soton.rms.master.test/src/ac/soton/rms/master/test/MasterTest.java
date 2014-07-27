/**
 * 
 */
package ac.soton.rms.master.test;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eventb.core.IEvent;
import org.eventb.core.IEventBProject;
import org.eventb.core.IEventBRoot;
import org.eventb.core.IMachineRoot;
import org.eventb.core.IVariable;
import org.eventb.emf.core.machine.Action;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Guard;
import org.eventb.emf.core.machine.Invariant;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.MachineFactory;
import org.eventb.emf.core.machine.Parameter;
import org.eventb.emf.core.machine.Variable;
import org.junit.Test;
import org.rodinp.core.IRodinFile;
import org.rodinp.core.RodinCore;

import com.google.inject.Injector;

import de.be4.classicalb.core.parser.exceptions.BException;
import de.prob.model.eventb.EventBModel;
import de.prob.model.representation.AbstractModel;
import de.prob.scripting.EventBFactory;
import de.prob.statespace.AnimationSelector;
import de.prob.statespace.StateSpace;
import de.prob.statespace.Trace;
import de.prob.webconsole.ServletContextListener;
import ac.soton.rms.components.ComponentDiagram;
import ac.soton.rms.components.ComponentsFactory;
import ac.soton.rms.components.EventBComponent;
import ac.soton.rms.components.EventBPort;
import ac.soton.rms.components.VariableCausality;
import ac.soton.rms.components.VariableType;
import ac.soton.rms.components.util.custom.SimStatus;
import ac.soton.rms.master.Master;

/**
 * @author vitaly
 *
 * Creates an example component connection graph:
 * 		->	C1	->
 * 		D1		D2
 * 		<-	C2	<-
 * 
 * where Dn - discrete component (Event-B)
 * 		Cn - continuous component (FMU)
 * 		-> - direction of the data exchange (IO)
 */
public class MasterTest extends AbstractEventBTests {
	
	protected static final String CARTESIAN_PRODUCT = "\u00d7";
	protected static final String DIRECT_PRODUCT = "\u2297";
	protected static final String MEMBER_OF = " \u2208 ";
	protected static final String TOTAL_FUNCTION = "\u2192";
	protected static final String TOTAL_SURJECTION = "\u21a0";
	protected static final String TOTAL_INJECTION = "\u21a3";
	protected static final String TOTAL_BIJECTION = "\u2916";
	protected static final String LPAR = "(";
	protected static final String RPAR = ")";
	protected static final String FOR_ALL = "\u2200";
	protected static final String MID_DOT = " \u00b7 ";
	protected static final String MAPLET = "\u21a6";
	protected static final String EQUALS = " \u003d ";
	protected static final String ASSIGN = "\u2254";
	private static final String INT = "\u2124";
	private static final String BOOL = "BOOL";

	/**
	 * Test method for {@link ac.soton.rms.master.Master#simulate(ac.soton.rms.components.ComponentDiagram, org.eclipse.core.runtime.IProgressMonitor, boolean, boolean, boolean)}.
	 * @throws CoreException 
	 */
	@Test
	public final void testSimulate() throws CoreException {
		IEventBProject project = createEventBProject("MATest");
		IMachineRoot machine = createMachine(project, "DT");

		createVariable(machine, "y");
		createVariable(machine, "io");
		createInvariant(machine, "inv1", "y"+MEMBER_OF+INT, false);
		createInvariant(machine, "inv2", "io"+MEMBER_OF+BOOL, false);
		
		IEvent init = createEvent(machine, "INITIALISATION");
		createAction(init, "act1", "y"+ASSIGN+"0");
		createAction(init, "act2", "io"+ASSIGN+"TRUE");
		
		IEvent read = createEvent(machine, "read");
		createParameter(read, "u");
		createGuard(read, "grd1", "u"+MEMBER_OF+INT, false);
		createGuard(read, "grd2", "io = TRUE", false);
		createAction(read, "act1", "y"+ASSIGN+"u");
		createAction(read, "act2", "io"+ASSIGN+"FALSE");
		
		IEvent wait = createEvent(machine, "wait");
		createGuard(wait, "grd1", "io = FALSE", false);
		createAction(wait, "act1", "io"+ASSIGN+"TRUE");
		createAction(wait, "act2", "y"+ASSIGN+"y+1");

		// save file and build workspace - this triggers static check, and
		// generates missing files
		machine.getRodinFile().save(monitor, false);
		workspace.build(IncrementalProjectBuilder.FULL_BUILD, monitor);
		
		// EMF
		ResourceSetImpl rs = new ResourceSetImpl();
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getProject("MATest").getFile("DT.bum");
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		Resource resource = rs.getResource(uri, true);
		Machine m = (Machine) resource.getContents().get(0);

		ComponentDiagram diagram = ComponentsFactory.eINSTANCE.createComponentDiagram();
		
		EventBComponent dt1 = ComponentsFactory.eINSTANCE.createEventBComponent();
		dt1.setMachine(m);
		for (Event e : m.getEvents()) {
			if (e.getName().equals("read")) {
				dt1.getReadInputEvents().add(e);
				EventBPort u = ComponentsFactory.eINSTANCE.createEventBPort();
				u.setParameter(e.getParameters().get(0));
				u.setType(VariableType.INTEGER);
				u.setCausality(VariableCausality.INPUT);
				dt1.getInputs().add(u);
			} else if (e.getName().equals("wait")) {
				dt1.getWaitEvents().add(e);
			}
		}
		EventBPort y = ComponentsFactory.eINSTANCE.createEventBPort();
		y.setVariable(m.getVariables().get(m.getVariables().get(0).getName().equals("y") ? 0 : 1));
		y.setType(VariableType.INTEGER);
		y.setCausality(VariableCausality.OUTPUT);
		dt1.getOutputs().add(y);
		dt1.setStepPeriod(3);
		
		EventBComponent dt2 = EcoreUtil.copy(dt1);
		dt2.setStepPeriod(4);
		
		dt1.getInputs().get(0).setIn(dt2.getOutputs().get(0));
		dt2.getInputs().get(0).setIn(dt1.getOutputs().get(0));
		diagram.getComponents().add(dt1);
		diagram.getComponents().add(dt2);
		diagram.setStartTime(0);
		diagram.setStopTime(12);
		Master.simulate(diagram, null, false, false, false);
		
		Object y1 = dt1.getOutputs().get(0).getValue();
		Object y2 = dt2.getOutputs().get(0).getValue();
		assertTrue((int)y1 == 3 && (int)y2 == 2);
	}
	
	@Test
	public final void testAnimation() throws CoreException, BException {
		IEventBProject project = createEventBProject("anim");
		
		ResourceSetImpl rs = new ResourceSetImpl();
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getProject("anim").getFile("m0.bum");
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		Resource resource = rs.createResource(uri);
		Machine machine = MachineFactory.eINSTANCE.createMachine();
		machine.setName("m0");
		
		Variable var = MachineFactory.eINSTANCE.createVariable();
		var.setName("y");
		machine.getVariables().add(var);
		Variable var2 = MachineFactory.eINSTANCE.createVariable();
		var2.setName("io");
		machine.getVariables().add(var2);
		
		Invariant inv = MachineFactory.eINSTANCE.createInvariant();
		inv.setPredicate("y" + MEMBER_OF + INT);
		machine.getInvariants().add(inv);
		Invariant inv2 = MachineFactory.eINSTANCE.createInvariant();
		inv2.setPredicate("io" + MEMBER_OF + BOOL);
		machine.getInvariants().add(inv2);

		Event init = MachineFactory.eINSTANCE.createEvent();
		init.setName("INITIALISATION");
		Action iact = MachineFactory.eINSTANCE.createAction();
		iact.setAction("y" + ASSIGN + "0");
		init.getActions().add(iact);
		Action iact2 = MachineFactory.eINSTANCE.createAction();
		iact2.setAction("io" + ASSIGN + "TRUE");
		init.getActions().add(iact2);
		machine.getEvents().add(init);
		
		Event read = MachineFactory.eINSTANCE.createEvent();
		read.setName("read");
		Parameter param = MachineFactory.eINSTANCE.createParameter();
		param.setName("p");
		read.getParameters().add(param);
		Guard grd = MachineFactory.eINSTANCE.createGuard();
		grd.setPredicate("p" + MEMBER_OF + INT);
		read.getGuards().add(grd);
		Guard grd2 = MachineFactory.eINSTANCE.createGuard();
		grd2.setPredicate("io" + EQUALS + "TRUE");
		read.getGuards().add(grd2);
		Action ract = MachineFactory.eINSTANCE.createAction();
		ract.setAction("y" + ASSIGN + "p");
		read.getActions().add(ract);
		Action ract2 = MachineFactory.eINSTANCE.createAction();
		ract2.setAction("io" + ASSIGN + "FALSE");
		read.getActions().add(ract2);
		machine.getEvents().add(read);
		
		Event wait = MachineFactory.eINSTANCE.createEvent();
		wait.setName("wait");
		Guard grd3 = MachineFactory.eINSTANCE.createGuard();
		grd3.setPredicate("io" + EQUALS + "FALSE");
		wait.getGuards().add(grd3);
		Action wact = MachineFactory.eINSTANCE.createAction();
		wact.setAction("y" + ASSIGN + "y + 1");
		read.getActions().add(wact);
		Action wact2 = MachineFactory.eINSTANCE.createAction();
		wact2.setAction("io" + ASSIGN + "TRUE");
		read.getActions().add(wact2);
		machine.getEvents().add(wait);
		
		try {
			resource.getContents().add(machine);
			resource.save(Collections.EMPTY_MAP);
			resource.unload();
		} catch (IOException e) {
			fail("Failed to save the machine");
		}

		workspace.build(IncrementalProjectBuilder.FULL_BUILD, monitor);

		rs = new ResourceSetImpl();
		resource = rs.getResource(uri, true);
		machine = (Machine) resource.getContents().get(0);
		assertTrue(machine.getVariables().size() > 0);
		
//		Trace trace = loadAnimation(resource);
//		assertNotNull("Failed to start machine animation", trace);
//		
//		AbstractModel m = trace.getModel();
//		trace = trace.anyEvent(null);
//		trace = trace.anyEvent(null);
//		trace = trace.anyEvent(null);
//		assertEquals("Invalid state", "wait", trace.getCurrent().getOp().getName());
//		
//		trace = trace.add("read", "p=5").anyEvent(null);
//		assertEquals("Wrong value", 6, trace.getCurrentState().value("y"));
	}
	
	public Trace loadAnimation(Resource resource) {
		IFile file = WorkspaceSynchronizer.getFile(resource);
		IRodinFile rodinFile = RodinCore.valueOf(file);
		if (rodinFile == null)
			return null;
		
		IEventBRoot machineRoot = (IEventBRoot) rodinFile.getRoot();
		String fileName = machineRoot.getResource().getRawLocation()
				.makeAbsolute().toOSString();
		if (fileName.endsWith(".buc")) {
			fileName = fileName.replace(".buc", ".bcc");
		} else {
			fileName = fileName.replace(".bum", ".bcm");
		}

		Injector injector = ServletContextListener.INJECTOR;
		final EventBFactory instance = injector.getInstance(EventBFactory.class);
		EventBModel model = instance.load(fileName, new HashMap<String, String>(), true);	//FIXME: add exception handling if loading fails
		StateSpace s = model.getStatespace();
		return new Trace(s);	//NOTE: don't use setTrace() method to avoid notification
	}
	
	@Test
	public final void testCreateVariable() throws CoreException {
		IEventBProject project = createEventBProject("TestProject");
		IMachineRoot machine = createMachine(project, "TestMachine");

		IVariable v1 = createVariable(machine, "y");
		IVariable v2 = createVariable(machine, "io");
		createInvariant(machine, "inv1", "y"+MEMBER_OF+INT, false);
		createInvariant(machine, "inv2", "io"+MEMBER_OF+BOOL, false);
		
		IEvent init = createEvent(machine, "INITIALISATION");
		createAction(init, "act1", "y"+ASSIGN+"0");
		createAction(init, "act2", "io"+ASSIGN+"TRUE");
		
		IEvent read = createEvent(machine, "read");
		createParameter(read, "u");
		createGuard(read, "grd1", "u"+MEMBER_OF+INT, false);
		createGuard(read, "grd2", "io = TRUE", false);
		createAction(read, "act1", "y"+ASSIGN+"u");
		createAction(read, "act2", "io"+ASSIGN+"FALSE");
		
		IEvent wait = createEvent(machine, "wait");
		createGuard(wait, "grd1", "io = FALSE", false);
		createAction(wait, "act1", "io"+ASSIGN+"TRUE");
		createAction(wait, "act2", "y"+ASSIGN+"y+1");

		// save file and build workspace - this triggers static check, and
		// generates missing files
		machine.getRodinFile().save(monitor, false);
		workspace.build(IncrementalProjectBuilder.FULL_BUILD, monitor);

		// there should be one variable and one SC variable
		assertEquals(2, machine.getVariables().length);
		
		String fileName = machine.getResource().getRawLocation()
				.makeAbsolute().toOSString();
		if (fileName.endsWith(".buc")) {
			fileName = fileName.replace(".buc", ".bcc");
		} else {
			fileName = fileName.replace(".bum", ".bcm");
		}

		Injector injector = ServletContextListener.INJECTOR;
		final EventBFactory instance = injector.getInstance(EventBFactory.class);
		EventBModel model = instance.load(fileName, new HashMap<String, String>(), true);	//FIXME: add exception handling if loading fails
		StateSpace s = model.getStatespace();
		Trace trace = new Trace(s);
		
		trace = trace.anyEvent(null);
		Object value = trace.getCurrentState().value("y");
		trace = trace.anyEvent(null);
	}
}
