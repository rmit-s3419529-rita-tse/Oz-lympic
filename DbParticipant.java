import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hsqldb.lib.StringUtil;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * The is the DbParticipant class of Ozlympic Game which can connect to database
 * It shows participants list on the database  and store it
 * 
 * @author SZUYING CHEN
 * @version 4.0
 * @since 2017-05-08
 */

public class DbParticipant implements IParticipant {

	static Connection connection = null;
	static ResultSet rs = null;

	public DbParticipant() throws SQLException, ClassNotFoundException {		
		// making a connection
		try {
			Class.forName("org.hsqldb.jdbcDriver");
//			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/TestDB", "sa", "123"); sever mode
			connection = DriverManager.getConnection("jdbc:hsqldb:file:TestDB", "sa", "123");			
		} catch (SQLException e2) {
			throw e2;
		} catch (ClassNotFoundException e2) {			
			throw e2;
		}
		// end of stub code for in/out stub
	}
	
    // not using ,just for extra feature and testing
	public Boolean AddParticipants(String ID, String strType, String strName, Integer Age, String State) {
		Boolean result = false;
		try {			
				 PreparedStatement statement = connection.prepareStatement("insert into participants (id, type, name, age, state) " 
					 + "values (?, ?, ? ,? , ?);");
				 statement.setString(1, ID);
				 statement.setString(2, strType);
				 statement.setString(3, strName);
				 statement.setInt(4, Age);
				 statement.setString(5, State);
				 result = statement.executeUpdate() > 0 ? true : false;

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return result;
	}

	// not using ,just for extra feature and testing
	public void DeleteParticipants() {
		try {
			connection.prepareStatement("DELETE FROM participants").execute();
			connection.commit();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}
	
    //print data from participants    
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
	
    //use arrayList to store the different type of athlete and official from the participants 	
	public ArrayList<Participant> GetParticipants(String type) {
		ArrayList<Participant> participants = new ArrayList<Participant>();
		ResultSet rs = null;
		try {
			PreparedStatement statement = connection.prepareStatement("select distinct * from participants where UPPER(type) = isnull(?, UPPER(type));");
			statement.setString(1, StringUtil.isEmpty(type) ? type :type.toUpperCase());
			rs = statement.executeQuery();
			
			while (rs.next()) {
				participants.add(new Participant(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getString(5)));
			}
			
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}
		return participants;
	}
}