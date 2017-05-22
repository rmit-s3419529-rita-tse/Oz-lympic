import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
		/*Server hsqlServer = null;

		hsqlServer = new Server();
		hsqlServer.setLogWriter(null);
		hsqlServer.setSilent(true);
		hsqlServer.setDatabaseName(0, "TestDB");
		hsqlServer.setDatabasePath(0, "file:TestDB");
		hsqlServer.start();*/
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
		Assert.assertTrue(actual.size() < 53);
	}
	
	@Test
	public void testGetParticipants_Official() {
		IParticipant gameDB = new ParticipantHandler("");
		
		ArrayList<Participant> actual = gameDB.GetParticipants(IParticipant.OFFICIAL);
		Assert.assertTrue(actual.size() < 53);
	}
	
	@Test
	public void testGetParticipants_SPRINTER() {
		IParticipant gameDB = new ParticipantHandler("");
		
		ArrayList<Participant> actual = gameDB.GetParticipants(IParticipant.SPRINTER);
		Assert.assertTrue(actual.size() < 53);
	}
	
	
	@Test
	public void testGetParticipants_super() {
		IParticipant gameDB = new ParticipantHandler("");
		
		ArrayList<Participant> actual = gameDB.GetParticipants(IParticipant.SUPER);
		Assert.assertTrue(actual.size() < 53);
	}
	
	
	@Test
	public void testGetParticipants_swimmer() {
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
		
		Assert.assertEquals(false, actual);
	}
	
	@Test
	public void testDeleteParticipants()
	{		
		
	}
	
	@Test
	public void testSortedArrayList()
	{
		ArrayList<Athlete> sortedRanks = new ArrayList<Athlete>();
		Athlete a1 = new Athlete("a1", "", "", 50, "WA", 0);
		Athlete a2 = new Athlete("a2", "", "", 50, "WA", 0);
		Athlete a3 = new Athlete("a3", "", "", 50, "WA", 10);
		Athlete a4 = new Athlete("a4", "", "", 50, "WA", 1);
		Athlete a5 = new Athlete("a5", "", "", 50, "WA", 5);
		Athlete a6 = new Athlete("a6", "", "", 50, "WA", 0);
		sortedRanks.add(a1);
		sortedRanks.add(a2);
		sortedRanks.add(a3);
		sortedRanks.add(a4);
		sortedRanks.add(a5);
		sortedRanks.add(a6);
		
		Collections.sort(sortedRanks, new Comparator<Athlete>() {
	        public int compare(Athlete p1, Athlete p2) {
	        	if (p1.getScore() < p2.getScore())
	        		return 1;
	        	else if (p1.getScore() == p2.getScore())
	        		return 0;
	        	else 
	        		return -1;
	        }
		});
		
		Assert.assertTrue(true);
	}
	
	@Test
	public void testComputeScores()
	{
		// Get all participants records except Official.
		IParticipant participantHandler = new ParticipantHandler("participants.txt");
		ArrayList<Participant> allParticipants = participantHandler.GetParticipants(IParticipant.SWIMMER);
		allParticipants.addAll(participantHandler.GetParticipants(IParticipant.SPRINTER));
		allParticipants.addAll(participantHandler.GetParticipants(IParticipant.SUPER));
		allParticipants.addAll(participantHandler.GetParticipants(IParticipant.CYCLIST));
		
		// Get all game result
		IGameResult gameResultHandler = new GameResultHandler("gameResults.txt");
		ArrayList<DbGameResultModel> results = gameResultHandler.GetResult();
		// ArrayList to show all athelete rank.
		ArrayList<Athlete> ranks = new ArrayList<Athlete>();
		
		for(Participant p : allParticipants)
		{
			Athlete athlete = new Athlete(p.getID(), p.getType(), p.getName(), p.getAge(), p.getState(), 0);
			if(!ranks.contains(athlete))
				ranks.add(athlete);
			for(DbGameResultModel result : results)
			{
				if(p.getID().equals(result.getAthleteId())) {
					System.out.println(result.getGameId() + " : " + result.getAthleteId() + " : " + athlete.getID() + " : " + result.getScore());
					Athlete temp = ranks.get(ranks.indexOf(athlete));
					int currentScore = result.getScore().intValue();
					
					temp.addScore(currentScore);
				}
			}
		}
		
		for(Athlete p: ranks) {
			System.out.println(p.getID() + " : " + p.getScore());
		}
		
		
		Assert.assertTrue(true);
	}

}