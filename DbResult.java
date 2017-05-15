import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.hsqldb.Server;

/**
 * The is the database connection of Ozlympic Game Program which can connect to database
 * It showed the database of the gameResult
 * Not finish yet,still debug this part 
 * @author SZUYING CHEN
 * @version 1.0
 * @since 2017-05-14
 */

public class DbResult {
	static Connection connection = null;
	static ResultSet rs = null;

	public DbResult() {
		Server hsqlServer = null;

		hsqlServer = new Server();
		hsqlServer.setLogWriter(null);
		hsqlServer.setSilent(true);
		hsqlServer.setDatabaseName(0, "ResultDB");
		hsqlServer.setDatabasePath(0, "file:MyDB");
		hsqlServer.start();
		// making a connection
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			connection = DriverManager.getConnection("jdbc:hsqldb:file:ResultDB", "sa", "123");
			// The table can only be created but not dropped, so once it
			// created, comment out the following commands
			// connection.prepareStatement("drop table barcodes
			// ifexists;").execute();
			try {
				connection
						.prepareStatement(
								"create table gameResults(id varchar(20), type varchar(20), name varchar(20), age integer, state varchar(20), score interger );")
						.execute();
			} catch (Exception e2) {

			}

		} catch (SQLException e2) {
			e2.printStackTrace();
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		// end of stub code for in/out stub
	}

	public static void main(String[] args) {
		DbResult TestGame = new DbResult();
		TestGame.AddResult("ID", "strType", "strName", 26, "State", 10);
		// TestGame.DeleteParticipants();
		TestGame.GetResult();
	}

	public void AddResult(String ID, String strType, String strName, Integer Age, String State, Integer score) {
		try {

			connection
					.prepareStatement("insert into gameResults (id, type, name, age, state, score) " + "values ('" + ID
							+ "', '" + strType + "', '" + strName + "', " + Age + ", '" + State + "'," + score + ");")
					.execute();

			connection.commit();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	public void DeleteReault() {
		try {
			connection.prepareStatement("DELETE FROM gameReasults").execute();
			connection.commit();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	public void PrintResult() {
		try {
			rs = connection.prepareStatement("select * from gameReasults;").executeQuery();
			while (rs.next())
				System.out.println(
						String.format("ID: %1s, type:%1s, name:%1s, age:%1s, state:%1s, score:%1s", rs.getString(1),
								rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6)));
			// return null;
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		System.out.println("There is no data!");
	}

	public List<Athlete> GetResult() {
		List<Athlete> athlete = new LinkedList<Athlete>();
		try {
			rs = connection.prepareStatement("select * from gameResults;").executeQuery();
			while (rs.next())
				athlete.add(new Athlete(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getString(5), rs.getInt(6)));
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}
		return athlete;
	}
}
