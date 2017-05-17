import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.hsqldb.Server;

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

	public void PrintResult() {
		try {
			rs = connection.prepareStatement("select * from GAMERESULTS;").executeQuery();
			while (rs.next())
				System.out.println(
						String.format("ID: %1s, type:%1s, name:%1s, age:%1s, state:%1s, score:%1s",
							rs.getInt(DbGameResultModel.COL_LISTID),
							rs.getString(DbGameResultModel.COL_GAME_ID), 
							rs.getString(DbGameResultModel.COL_OFFICIAL_ID),
							rs.getString(DbGameResultModel.COL_ATHLETE_ID),
							rs.getInt(DbGameResultModel.COL_RESULT),
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
}
