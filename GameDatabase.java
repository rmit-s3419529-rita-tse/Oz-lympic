
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.hsqldb.Server;

/**
 * The is the database connection of Ozlympic Game Program
 * which can connect to the database
 * not finish yet,just try the code from tutorial 
 *
 * @author  SZUYING CHEN
 * @version 1.0
 * @since   2017-05-08
 */
	
	public class GameDatabase {
	public static void main(String[] args) {
	Server hsqlServer = null;
	Connection connection = null;
	ResultSet rs = null;
	hsqlServer = new Server();
	hsqlServer.setLogWriter(null);
	hsqlServer.setSilent(true);
	hsqlServer.setDatabaseName(0, "TestDB");
	hsqlServer.setDatabasePath(0, "file:MYDB");
	hsqlServer.start();
	// making a connection
	try {
	Class.forName("org.hsqldb.jdbcDriver");
	connection =
	DriverManager.getConnection("jdbc:hsqldb:TestDB", "sa", "123");
	connection.prepareStatement("drop table barcodes if exists;").execute();
	connection.prepareStatement("create table barcodes (id integer, barcode varchar(20) not null);").execute();
	connection.prepareStatement("insert into barcodes (id, barcode)"
	+ "values (1, '12345577');").execute();
	//
	// // query from the db
	rs = connection.prepareStatement("select id, barcode from barcodes;").executeQuery();
	rs.next();
	System.out.println(String.format("ID: %1d, Name: %1s", rs.getInt(1), rs.getString(2)));
	connection.commit();
	} catch (SQLException e2) {
	e2.printStackTrace();
	} catch (ClassNotFoundException e2) {
	e2.printStackTrace();
	}
	// end of stub code for in/out stub
	}
	
public static void createTable(String[] args) {
		
		Connection con = null;
		Statement stmt = null;
		int result = 0;
		
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
			stmt = con.createStatement();
			
			result = stmt.executeUpdate("CREATE TABLE tutorials_tbl                                       (id INT NOT NULL, title VARCHAR(50) NOT NULL,author VARCHAR(20) NOT NULL,                                           submission_date DATE,PRIMARY KEY (id));");
			//Warning, your compiler might not like the newlines in the SQL query
	
		}  catch (Exception e) {
			e.printStackTrace(System.out);
		}
		System.out.println("Table created successfully");
	}



	   public static void viewData(String[] args) {
	      Connection con = null;
	      Statement stmt = null;
	      ResultSet result = null;
	      
	      try {
	         Class.forName("org.hsqldb.jdbc.JDBCDriver");
	         con = DriverManager.getConnection(
	            "jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
	         stmt = con.createStatement();
	         result = stmt.executeQuery(
	            "SELECT * FROM tutorials_tbl");
	         
	         while(result.next()){
	            System.out.println(result.getInt("id")+" | "+
	               result.getString("title")+" | "+
	               result.getString("author"));
	         }
	      } catch (Exception e) {
	         e.printStackTrace(System.out);
	      }
	   }
	   public static void upDateData(String[] args) {
	        Connection con = null;
	        Statement stmt = null;
	        ResultSet output = null;
	        int result = 0;
			
	        try {
	            Class.forName("org.hsqldb.jdbc.JDBCDriver");
	            con = DriverManager.getConnection(
					"jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
	            stmt = con.createStatement();
	            result = stmt.executeUpdate(
					"UPDATE tutorials_tbl SET title = 'Data Structures' WHERE id = 100");
					
	            output = stmt.executeQuery(
					"SELECT * FROM tutorials_tbl");
					
	            while(output.next()){
	                System.out.println(output.getInt("id")+" | "+
				     		output.getString("title")+" | "+
							output.getString("author"));
	                }		
	            } catch (Exception e) {
	                e.printStackTrace(System.out);
	        }
	        System.out.println(result+" Rows effected");
	    }
	}
	