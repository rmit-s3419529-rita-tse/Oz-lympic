import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The is the FileParticipant class of Ozlympic Game
 * It can read a text file from the participants list
 * 
 * @author SZUYING CHEN
 * @version 1.1
 * @since 2017-05-16
 */

public class FileParticipant implements IParticipant {
	private String strFilePath;
	public FileParticipant(String filePath){
		strFilePath=filePath;
	}

	@Override
	public Boolean AddParticipants(String ID, String strType, String strName, Integer Age, String State) {
		
		return null;
	}

	@Override
	public void DeleteParticipants() {
		
	}

	@Override
	public void PrintParticipants() {

	}
    //Reading text files using an ArrayList
	@Override
	public ArrayList<Participant> GetParticipants(String type) {
		
		ArrayList<Participant> participants = new  ArrayList<Participant>();
		
		try {
			BufferedReader input = new BufferedReader(new FileReader(strFilePath));

			String next = input.readLine();

			while (next != null) {
				
				String string = next;
				String[] parts = string.split(",");
				if  (parts[1].trim()==type){
				String id = parts[0];
				String partype = parts[1]; 
				String name = parts[2]; 
				String age = parts[3].trim(); 
				String state = parts[4]; 	
	
				Participant participant=new Participant(id, partype, name,  Integer.parseInt(age), state);
			//	System.out.println(next);
				participants.add(participant);
				}
				next = input.readLine();
			}
			input.close();
		} catch (IOException e) {
			System.err.println("File Reading Error!");
			System.exit(0);
		}
		return participants;
	}
}

