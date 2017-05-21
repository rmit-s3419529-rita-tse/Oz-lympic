

import java.util.List;

import org.hsqldb.Server;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DBGameResultTest {
	
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
	public void testGetResult() {
		IGameResult db = new GameResultHandler("");
		List<DbGameResultModel> actual = db.GetResult();
		Assert.assertTrue(actual.size() > 0);
	}
	
	@Test
	public void testAddP_Add_Valid()
	{
		IGameResult db = new GameResultHandler("");
		db.AddResult("123", "123", "123", new Double(2.0), new Integer(1));
	}
	
	@Test
	public void testAddP_Add_Invalid()
	{
		IGameResult db = new GameResultHandler("");
		db.AddResult("", "", "", new Double(2.0), new Integer(1));
	}
	
}
