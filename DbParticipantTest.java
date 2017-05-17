import java.util.ArrayList;
import java.util.List;

import org.hsqldb.Server;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test cases for the DbParticipant class
 * Not finish yet,will add more.
 *
 * @author SZUYING CHEN
 * @version 1.0
 * @since 2017-05-15
 */

public class DbParticipantTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Server hsqlServer = null;

		hsqlServer = new Server();
		hsqlServer.setLogWriter(null);
		hsqlServer.setSilent(true);
		hsqlServer.setDatabaseName(0, "TestDB");
		hsqlServer.setDatabasePath(0, "file:TestDB");
		hsqlServer.start();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetParticipants() {
		DbParticipant gameDB = new DbParticipant();
	
		ArrayList<Participant> actual = gameDB.GetParticipants();
		
		Assert.assertTrue(actual.size() > 0);
	}
	
	@Test
	public void testAddParticipants()
	{
		IParticipant gameDB = new DbParticipant();
		
		Boolean actual = gameDB.AddParticipants("Oz1001", "swimmer", "A. Edwin", 30, "VIC");
		
		Assert.assertEquals(false, actual);
	}
	
	@Test
	public void testDeleteParticipants()
	{		
		
	}

}