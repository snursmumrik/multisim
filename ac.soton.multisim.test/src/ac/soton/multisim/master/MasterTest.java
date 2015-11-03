package ac.soton.multisim.master;

import static org.junit.Assert.*;

import org.eclipse.core.resources.ResourcesPlugin;
import org.junit.Test;

public class MasterTest {

	@Test
	public void test() {
		assertNotNull(ResourcesPlugin.getWorkspace());
	}

}
