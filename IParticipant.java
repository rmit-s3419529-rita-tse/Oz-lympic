import java.util.ArrayList;

/**
 * The is the Ozlympic Game Program.
 * It is the interface of DbParticipant 
 * 
 * @author  SZUYING CHEN
 * @version 1.0
 * @since   2017-05-15
 */
//Method bodies exist only for default methods and static methods
public interface IParticipant {
	
	final String SWIMMER = "swimmer";
	final String SPRINTER = "sprinter";
	final String CYCLIST = "cyclist";
	final String SUPER = "super";
	final String OFFICIAL = "Official";
	
	Boolean AddParticipants(String ID, String strType, String strName, Integer Age, String State);
	void DeleteParticipants();
	void PrintParticipants();
	ArrayList<Participant> GetParticipants(String type);
}