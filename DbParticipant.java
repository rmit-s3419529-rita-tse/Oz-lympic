import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.hsqldb.Server;

/**
 * The is the database of Ozlympic Game Program which can connect to database
 * 
 *
 * @author SZUYING CHEN
 * @version 4.0
 * @since 2017-05-08
 */

public class DbParticipant implements IParticipant {

	static Connection connection = null;
	static ResultSet rs = null;

	public DbParticipant() {		
		// making a connection
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/TestDB", "sa", "123");
			//connection = DriverManager.getConnection("jdbc:hsqldb:file:TestDB", "sa", "123");			
		} catch (SQLException e2) {
			e2.printStackTrace();
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		// end of stub code for in/out stub
	}

	public Boolean AddParticipants(String ID, String strType, String strName, Integer Age, String State) {
		Boolean result = false;
		try {
			result = connection.prepareStatement("insert into participants (id, type, name, age, state) " + "values ('" + ID
					+ "', '" + strType + "', '" + strName + "', " + Age + ", '" + State + "');").execute();

			connection.commit();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return result;
	}

	public void DeleteParticipants() {
		try {
			connection.prepareStatement("DELETE FROM participants").execute();
			connection.commit();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

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

    //use linkedList to list the data from participants	
	public List<Participant> GetParticipants() {
		List<Participant> participants = new LinkedList<Participant>();
		try {
			rs = connection.prepareStatement("select * from participants;").executeQuery();
			while (rs.next())
				participants.add(new Participant(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getString(5)));

			
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}
		return participants;
	}

}