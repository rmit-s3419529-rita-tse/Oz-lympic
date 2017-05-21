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
 * To test connection,display participants table
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
		IParticipant gameDB = new ParticipantHandler("");
	
		ArrayList<Participant> actual = gameDB.GetParticipants(null);
		
		Assert.assertTrue(actual.size() > 0);
		
		actual = gameDB.GetParticipants(IParticipant.CYCLIST);
		Assert.assertTrue(actual.size() > 0);
		
		actual = gameDB.GetParticipants(IParticipant.OFFICIAL);
		Assert.assertTrue(actual.size() > 0);
		
		actual = gameDB.GetParticipants(IParticipant.SPRINTER);
		Assert.assertTrue(actual.size() > 0);
		
		actual = gameDB.GetParticipants(IParticipant.SUPER);
		Assert.assertTrue(actual.size() > 0);
		
		actual = gameDB.GetParticipants(IParticipant.SWIMMER);
		Assert.assertTrue(actual.size() > 0);
	}
	
	@Test
	public void testGetParticipants_All() {
		IParticipant gameDB = new ParticipantHandler("");
		
		ArrayList<Participant> actual = gameDB.GetParticipants(null);
		Assert.assertTrue(actual.size() > 0);
	}
	
	@Test
	public void testGetParticipants_Cyclist() {
		IParticipant gameDB = new ParticipantHandler("");
		
		ArrayList<Participant> actual = gameDB.GetParticipants(IParticipant.CYCLIST);
		Assert.assertTrue(actual.size() > 0);
	}
	
	@Test
	public void testGetParticipants_Official() {
		IParticipant gameDB = new ParticipantHandler("");
		
		ArrayList<Participant> actual = gameDB.GetParticipants(IParticipant.OFFICIAL);
		Assert.assertTrue(actual.size() > 0);
	}
	
	@Test
	public void testGetParticipants_SPRINTER() {
		IParticipant gameDB = new ParticipantHandler("");
		
		ArrayList<Participant> actual = gameDB.GetParticipants(IParticipant.SPRINTER);
		Assert.assertTrue(actual.size() > 0);
	}
	
	
	@Test
	public void testGetParticipants_Super() {
		IParticipant gameDB = new ParticipantHandler("");
		
		ArrayList<Participant> actual = gameDB.GetParticipants(IParticipant.SUPER);
		Assert.assertTrue(actual.size() > 0);
	}
	
	
	@Test
	public void testGetParticipants_Swimmer() {
		IParticipant gameDB = new ParticipantHandler("");
		
		ArrayList<Participant> actual = gameDB.GetParticipants(IParticipant.SWIMMER);
		Assert.assertTrue(actual.size() > 0);
	}
	
	@Test
	public void testAddParticipants()
	{
		IParticipant gameDB = new ParticipantHandler("");
		
		Boolean actual = gameDB.AddParticipants("Oz99998", "swimmer", "H. Eddy", 24, "VIC");
		
		Assert.assertEquals(true, actual);
	}
	public void testImpletedParticipant()
	{
		IParticipant gameDB = new ParticipantHandler("");
		
		Boolean actual = gameDB.AddParticipants("Oz1001", "", "A. Edwin", 30, "VIC");
		
		Assert.assertEquals(true, actual);
	}
}	
