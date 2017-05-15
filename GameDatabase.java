
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.hsqldb.Server;

/**
 * The is the database connection of Ozlympic Game Program which can connect to database
 * 
 *
 * @author SZUYING CHEN
 * @version 3.0
 * @since 2017-05-08
 */

public class GameDatabase {

	static Connection connection = null;
	static ResultSet rs = null;

	public GameDatabase() {
		Server hsqlServer = null;

		hsqlServer = new Server();
		hsqlServer.setLogWriter(null);
		hsqlServer.setSilent(true);
		hsqlServer.setDatabaseName(0, "TestDB");
		hsqlServer.setDatabasePath(0, "file:MyDB");
		hsqlServer.start();
		// making a connection
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			connection = DriverManager.getConnection("jdbc:hsqldb:file:TestDB", "sa", "123");
			// The table can only be created but not dropped, so once it
			// created, comment out the following commands
			// connection.prepareStatement("drop table barcodes
			// ifexists;").execute();
			try {
				// connection.prepareStatement("create table participants(id
				// varchar(20), type varchar(20), name varchar(20), age integer,
				// state varchar(20) );").execute();
			} catch (Exception e2) {

			}

		} catch (SQLException e2) {
			e2.printStackTrace();
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		// end of stub code for in/out stub
	}

	public void AddParticipants(String ID, String strType, String strName, Integer Age, String State) {
		try {
			// connection.prepareStatement("insert into participants (id, type,
			// name, age, state) "+
			// "values ('Oz1123', 'officer', 'Derek', 21,'WA'), " +
			// "('Oz3434', 'sprinter', 'Mary', 35, 'VIC'), "+
			// "('Oz0091', 'super', 'Hannah', 24, 'NSW'), "+
			// "('Oz1234', 'swimmer', 'Beck', 30, 'TAS');").execute();
			connection.prepareStatement("insert into participants (id, type, name, age, state) " + "values ('" + ID
					+ "', '" + strType + "', '" + strName + "', " + Age + ", '" + State + "');").execute();

			// connection.prepareStatement(strSQL).execute();

			connection.commit();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	public void DeleteParticipants() {
		try {
			connection.prepareStatement("DELETE FROM participants").execute();
			connection.commit();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	// This is the way to check if the database can connection and work
	// public static void main(String[] args){
	// GameDatabase TestGame= new GameDatabase();
	// TestGame.AddParticipants("ID", "strType", "strName", 26, "State");
	// TestGame.DeleteParticipants();
	// TestGame.GetParticipants();
	// }
	public void PrintParticipants() {
		try {
			rs = connection.prepareStatement("select * from participants;").executeQuery();
			while (rs.next())
				System.out.println(String.format("ID: %1s, type:%1s, name:%1s, age:%1s, state:%1s", rs.getString(1),
						rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
			// return null;
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		System.out.println("There is no data!");
	}

	public List<Participant> GetParticipants() {
		List<Participant> participants = new LinkedList<Participant>();
		try {
			rs = connection.prepareStatement("select * from participants;").executeQuery();
			while (rs.next())
				participants.add(new DbParticipant(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getString(5)));
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}
		return participants;
	}

}
