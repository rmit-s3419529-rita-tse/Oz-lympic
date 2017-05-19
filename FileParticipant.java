import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
        //for test 
		//		ArrayList<Participant> test =GetParticipants();
        //		for (int i = 0; i < test.size(); i++) {
        //			System.out.println(test.get(i).getID());
        //		}
	}

	@Override
	public ArrayList<Participant> GetParticipants() {
		
		ArrayList<Participant> participants = new  ArrayList<Participant>();
		
		try {
			BufferedReader input = new BufferedReader(new FileReader(strFilePath));

			String next = input.readLine();

			while (next != null) {
				
				String string = next;
				String[] parts = string.split(",");
				String id = parts[0];
				String type = parts[1]; 
				String name = parts[2]; 
				String age = parts[3].trim(); 
				String state = parts[4]; 	
	
				Participant participant=new Participant(id, type, name,  Integer.parseInt(age), state);
			//	System.out.println(next);
				participants.add(participant);
				next = input.readLine();
			}
			input.close();
		} catch (IOException e) {
			System.err.println("File Reading Error!");
			System.exit(0);
		}
		return participants;
	}
    public static void main(String[] arg){
    	FileParticipant testFile;
		testFile=new  FileParticipant("participants.txt");
		testFile.PrintParticipants();
    }

	@Override
	public ArrayList<Participant> GetParticipants(String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
