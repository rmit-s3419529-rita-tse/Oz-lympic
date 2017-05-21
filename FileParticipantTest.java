import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileParticipantTest {
	FileParticipant testFile;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	public void TestGetParticipants_All()
	{
		testFile= new  FileParticipant("participants.txt");
		
		ArrayList<Participant> actual = testFile.GetParticipants(null);
		Assert.assertNotNull(actual);
		Assert.assertTrue(actual.size() > 0);
	}
	
	@Test 
	public void TestGetParticipants_Swimmer()
	{
		testFile= new FileParticipant("participants.txt");
		
		ArrayList<Participant> actual = testFile.GetParticipants(IParticipant.SWIMMER);
		Assert.assertTrue(actual.size() == 12);
	}
	
	@Test 
	public void TestGetParticipants__Cyclist()
	{
		testFile= new FileParticipant("participants.txt");
		
		ArrayList<Participant> actual = testFile.GetParticipants(IParticipant.CYCLIST);
		Assert.assertTrue(actual.size() == 12);
	}
	
	@Test 
	public void TestGetParticipants_Official()
	{
		testFile= new FileParticipant("participants.txt");
		
		ArrayList<Participant> actual = testFile.GetParticipants(IParticipant.OFFICIAL);
		Assert.assertTrue(actual.size() == 8);
	}
	
	@Test 
	public void TestGetParticipants_SPRINTER()
	{
		testFile= new FileParticipant("participants.txt");
		
		ArrayList<Participant> actual = testFile.GetParticipants(IParticipant.SPRINTER);
		Assert.assertTrue(actual.size() == 12);
	}
	
	@Test 
	public void TestGetParticipants_Super()
	{
		testFile= new FileParticipant("participants.txt");
		
		ArrayList<Participant> actual = testFile.GetParticipants(IParticipant.SUPER);
		Assert.assertTrue(actual.size() == 9);
	}
}