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
//        for test to print the participants list
//				ArrayList<Participant> test =GetParticipants("jku");
//        		for (int i = 0; i < test.size(); i++) {
//        			System.out.print(test.get(i).getID() + "   " );
//        			System.out.print(test.get(i).getType() + "  " );
//        			System.out.print(test.get(i).getName() + "  " );
//        			System.out.print(test.get(i).getAge() + "  " );
//        			System.out.println(test.get(i).getState() + "  " );
//        		}
	}

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

//    public static void main(String[] arg){
//    	FileParticipant testFile;
//		testFile=new  FileParticipant("participants.txt");
//		testFile.PrintParticipants();
}

