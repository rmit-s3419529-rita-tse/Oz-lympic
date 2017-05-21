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
	public void test() {
//		
//		URL url = this.getClass().getResource("/test.wsdl");
//		File testWsdl = new File(url.getFile());
//		fail("Not yet implemented");
//		
//DbParticipant gameDB = new DbParticipant();
//		
//		ArrayList<Participant> actual = gameDB.GetParticipants(null);
//		Assert.assertTrue(actual.size() > 0);
	}

}
