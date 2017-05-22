import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.hsqldb.lib.StringUtil;

/**
 * The is the FileParticipant class of Ozlympic Game It can read a text file
 * from the participants list
 * 
 * @author SZUYING CHEN
 * @version 1.1
 * @since 2017-05-16
 */

public class FileParticipant implements IParticipant {
	private String strFilePath;

	public FileParticipant(String filePath) {
		strFilePath = filePath;
		File f = new File(filePath);
		if (!f.exists()) {
			f.mkdirs();
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
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

	// Reading text files using an ArrayList
	@Override
	public ArrayList<Participant> GetParticipants(String type) {

		ArrayList<Participant> participants = new ArrayList<Participant>();

		try {
			BufferedReader input = new BufferedReader(new FileReader(strFilePath));

			String next = input.readLine();

			while (next != null) {

				String string = next;
				String[] parts = string.split(",");
				if (parts.length >= 5) {
					if (parts[1].trim().toUpperCase().equals(type.toUpperCase()) || type == null) {
						String id = parts[0];
						String partype = parts[1];
						String name = parts[2];
						String age = parts[3].trim();
						String state = parts[4];

						// TODO check each column has valid value. Otherwise, do
						// not insert.
						if (id != null && !id.trim().equals("") && partype != null && !partype.trim().equals("")
								&& name != null && !name.trim().equals("") && age != null && !age.trim().equals("")
								&& state != null && !state.trim().equals("")) {
							Participant participant = new Participant(id, partype, name, Integer.parseInt(age), state);
							Boolean hasContained = false;
							for (Participant item : participants) {
								if (item.getID().equals(participant.getID()))
									hasContained = true;
							}
							if (!hasContained)
								participants.add(participant);
						}
					}
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
