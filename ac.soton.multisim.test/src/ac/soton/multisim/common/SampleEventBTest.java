package ac.soton.multisim.common;

import org.eventb.core.IEvent;
import org.eventb.core.IEventBProject;
import org.eventb.core.IMachineRoot;
import org.rodinp.core.RodinDBException;

/**
 * Event-B sample unit test.
 * Provides methods for creating sample Event-B machines
 * for testing purposes.
 * 
 * @author vitaly
 *
 */
public abstract class SampleEventBTest extends AbstractEventBTest {

	/**
	 * Creates a sample Event-B machine.
	 * The machine contains a set of variables and events to be able
	 * to run a simple animation via e.g. ProB.
	 * 
	 * @param eventBProject Event-B project to contain a created machine
	 * @param machineName name of the created Event-B machine
	 * @return sample machine
	 * @throws RodinDBException if creating Event-B machine failed
	 */
	protected IMachineRoot createSampleMachine(IEventBProject eventBProject, String machineName) throws RodinDBException {
		IMachineRoot machine = createMachine(eventBProject, machineName);
		
		createVariable(machine, "var");
		createInvariant(machine, "inv1", "var " + MEMBER_OF + " BOOL", false);
		
		IEvent event = createEvent(machine, IEvent.INITIALISATION);
		createAction(event, "act1", "var " + ASSIGN + " TRUE");
		
		event = createEvent(machine, "evt1");
		createAction(event, "act2", "var " + ASSIGN + " FALSE");
		
		return machine;
	}

}