import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.hsqldb.server.Server;

/**
 * The is the database of gameResult
 * It showed the database of the gameResult
 * Not finish yet,still debug this part 
 * @author SZUYING CHEN
 * @version 2.0
 * @since 2017-05-14
 */

public class DbGameResult implements IGameResult {
	static Connection connection = null;
	static ResultSet rs = null;

	public DbGameResult() {
		// making a connection
		try {
			String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
			Class.forName("org.hsqldb.jdbcDriver");
			// Server mode
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/TestDB", "sa", "123");
			// File mode
			//connection = DriverManager.getConnection("jdbc:hsqldb:file:TestDB", "sa", "123");
			connection.prepareStatement("select * from GAMERESULTS").executeQuery();
		} catch (SQLException e2) {
			e2.printStackTrace();
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		// end of stub code for in/out stub
	}

	public void AddResult(String gameId, String officialId, String athleteId, Double result, Integer score) {
		try {
			connection.prepareStatement("insert into GAMERESULTS (" + DbGameResultModel.COL_GAME_ID + ","
					+ " " + DbGameResultModel.COL_OFFICIAL_ID + ", " + DbGameResultModel.COL_ATHLETE_ID + ", " 
				+ DbGameResultModel.COL_RESULT + ", " + DbGameResultModel.COL_SCORE + " ) values ( " 
				+ "'" + gameId + "', '" + officialId + "', '" + athleteId + "', " + result + ", '" 
				+ score + ");").execute();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	public void DeleteReault(String gameId) {
		try {
			connection.prepareStatement("delete from GAMERESULTS where " + DbGameResultModel.COL_GAME_ID + " = " + gameId + ";")
				.execute();
			connection.commit();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Server hsqlServer = null;

		hsqlServer = new Server();
		hsqlServer.setLogWriter(null);
		hsqlServer.setSilent(true);
		hsqlServer.setDatabaseName(0, "TestDB");
		hsqlServer.setDatabasePath(0, "file:TestDB");
		hsqlServer.start();	
		DbGameResult Db = new DbGameResult();
		Db.AddResult("gameId"," officialId", "athleteId", 11.5,1);
		Db.PrintResult();
	}
	public void PrintResult() {
		try {
			rs = connection.prepareStatement("select * from GAMERESULTS;").executeQuery();
			while (rs.next())
				System.out.println(
						String.format("listId:%1s, gameId:%1s, athleteId:%1s, officialId:%1s, result:%1s, score:%1s",
							rs.getInt(DbGameResultModel.COL_LISTID),
							rs.getString(DbGameResultModel.COL_GAME_ID), 
							rs.getString(DbGameResultModel.COL_OFFICIAL_ID),
							rs.getString(DbGameResultModel.COL_ATHLETE_ID),
							rs.getDouble(DbGameResultModel.COL_RESULT),
							rs.getInt(DbGameResultModel.COL_SCORE)));
			// return null;
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		System.out.println("There is no data!");
	}

	public ArrayList<DbGameResultModel> GetResult() {
		ArrayList<DbGameResultModel> result = new ArrayList<DbGameResultModel>();
		try {
			ResultSet rs = connection.prepareStatement("select * from GAMERESULTS;").executeQuery();
			while (rs.next())
				result.add(new DbGameResultModel(rs.getInt(DbGameResultModel.COL_LISTID),
					rs.getString(DbGameResultModel.COL_GAME_ID), 
					rs.getString(DbGameResultModel.COL_OFFICIAL_ID),
					rs.getString(DbGameResultModel.COL_ATHLETE_ID),
					rs.getDouble(DbGameResultModel.COL_RESULT),
					rs.getInt(DbGameResultModel.COL_SCORE)));
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}
		return result;
	}

	@Override
	public void AddResult(String gameId, String officialId, String athleteId, Double result, Integer score,
			Date timeStamp) {
		// TODO Auto-generated method stub
		
	}
}
