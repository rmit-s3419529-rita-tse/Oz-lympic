import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.hsqldb.server.Server;

/**
 * The is the DbGameResult class of Ozlympic Game
 * It shows the database of the gameResult
 * It can display the result from each game and store it
 * @author SZUYING CHEN
 * @version 2.1
 * @since 2017-05-14
 */

public class DbGameResult implements IGameResult {
	static Connection connection = null;
	static ResultSet rs = null;

	public DbGameResult() throws SQLException, ClassNotFoundException {
		// making a connection
		try {
			String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
			Class.forName("org.hsqldb.jdbcDriver");
			// Server mode
            //connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/TestDB", "sa", "123");
			// File mode
			connection = DriverManager.getConnection("jdbc:hsqldb:file:TestDB", "sa", "123");
			connection.prepareStatement("select * from GAMERESULTS").executeQuery();
		} catch (SQLException e2) {
			throw e2;
		} catch (ClassNotFoundException e2) {
			throw e2;
		}
		// end of stub code for in/out stub
	}

	//Add game result in to the database   
	public void AddResult(String gameId, String officialId, String athleteId, Double result, Integer score) {
		try {
			PreparedStatement statement = connection.prepareStatement("insert into GAMERESULTS(" 
					+ DbGameResultModel.COL_GAME_ID + ","
					+ DbGameResultModel.COL_OFFICIAL_ID + ","
					+ DbGameResultModel.COL_ATHLETE_ID + ","
					+ DbGameResultModel.COL_RESULT + ","
					+ DbGameResultModel.COL_SCORE
					+ ") values (?, ?, ?, ?, ?)");
				statement.setString(1, gameId);
				statement.setString(2, officialId);
				statement.setString(3, athleteId);
				statement.setDouble(4, result);
				statement.setInt(5, score);
				statement.execute();
				connection.commit();
			}
			catch(Exception e)
			{
				
			}
		}
 
	// not using ,just for extra feature 
	public void DeleteReault(String gameId) {
		try {
			connection.prepareStatement("delete from GAMERESULTS where " + DbGameResultModel.COL_GAME_ID + " = " + gameId + ";")
				.execute();
			connection.commit();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	// not using ,just for extra feature and testing
	public void PrintResult() {
		try {
			rs = connection.prepareStatement("select * from GAMERESULTS;").executeQuery();
			while (rs.next())
				System.out.println(
						String.format("gameId:%1s, athleteId:%1s, officialId:%1s, result:%1s, score:%1s",
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

	//use arrayList to store the result from each game
	public ArrayList<DbGameResultModel> GetResult() {
		ArrayList<DbGameResultModel> result = new ArrayList<DbGameResultModel>();
		try {
			ResultSet rs = connection.prepareStatement("select * from GAMERESULTS;").executeQuery();
			while (rs.next())
				result.add(new DbGameResultModel(
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

//	not using
	@Override
	public void AddResult(String gameId, String officialId, String athleteId, Double result, Integer score,
			Date timeStamp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNewGameID(String gameType) {
		ArrayList<DbGameResultModel> result = new ArrayList<DbGameResultModel>();
		result = GetResult();
		int maxID = 0;
		for(DbGameResultModel item : result)
		{
			if(item.getGameId().contains(gameType)) {
				if(Integer.parseInt(item.getGameId().replace(gameType, "")) > maxID)
					maxID = Integer.parseInt(item.getGameId().replace(gameType, ""));
			}
		}
		return gameType + (maxID + 1);
	}
}
