import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class FileGameResultTest {

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
	public void testGetResult_File() {		
		IGameResult al = new FileGameResult("");
		al.AddResult("", "", "", 2.0, 0);
	}
	
	@Test
	public void testGetResults() {
		IGameResult gameResultHandler = new GameResultHandler("gameResults.txt");
		ArrayList<DbGameResultModel> results = gameResultHandler.GetResult();
		
		Assert.assertTrue(results.size() >= 13);
	}

}
