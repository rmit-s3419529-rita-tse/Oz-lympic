import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * The is the text file class of Ozlympic Game Program which can read and write
 * data by text file. It can handle
 * 
 * @author SZUYING CHEN
 * @version 1.1
 * @since 2017-05-05
 */
public class FileGameResult implements IGameResult {

	private String strFilePath;

	public FileGameResult(String filePath) {
		strFilePath = filePath;
	}

	@Override
	public void DeleteReault(String gameId) {
		// TODO Auto-generated method stub
	}

	@Override
	public void PrintResult() {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<DbGameResultModel> GetResult() {

		ArrayList<DbGameResultModel> results = new ArrayList<DbGameResultModel>();

		try {
			BufferedReader input = new BufferedReader(new FileReader(strFilePath));

			String next = input.readLine();

			while (next != null) {

				String string = next;
				String[] parts = string.split(",");
				if (parts.length >= 5) {
					String gameId = parts[0];
					String officialId = parts[1];
					String athleteId = parts[2];
					String _result = parts[3].trim();
					String score = parts[4];

					// insert.
					if (gameId != null && !gameId.trim().equals("") && officialId != null 
							&& !officialId.trim().equals("")
							&& athleteId != null && !athleteId.trim().equals("") 
							&& _result != null && !_result.trim().equals("")
							&& score != null && !score.trim().equals("")) {
						DbGameResultModel result = new DbGameResultModel(gameId, officialId, athleteId, Double.parseDouble(_result),
							Integer.parseInt(score));
						results.add(result);
					}
				}
				next = input.readLine();
			}
			input.close();
		} catch (IOException e) {
			System.err.println("File Reading Error!");
			System.exit(0);
		}
		return results;
	}
	// public static void main(String[] args){
	//
	// SimpleDateFormat dateformat2 = new SimpleDateFormat("dd-M-yyyy
	// hh:mm:ss");
	// String strdate2 = "02-04-2015 11:35:42";
	// Date timeStamp=null;
	// try {
	// timeStamp = dateformat2.parse(strdate2);
	// } catch (java.text.ParseException e) {
	// e.printStackTrace();
	// }
	//
	//
	// FileGameResult testFileRs =new FileGameResult("gameResults.txt");
	// testFileRs.AddResult("001", "013", "athleteId", 55.98, 5, timeStamp);
	// }

	@Override
	public void AddResult(String gameId, String officialId, String athleteId, Double result, Integer score,
			Date timeStamp) {
		// TODO Auto-generated method stub
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(strFilePath);
			writer.println(gameId);
			writer.println(officialId);
			writer.println(athleteId);
			writer.println(timeStamp);
			writer.println(result.toString());
			writer.println(score.toString());
			writer.close();
		} catch (IOException e) {
			// show an error message
			System.err.println("File cannot be created, or cannot be opened");
			System.exit(0);
		}
	}

	@Override
	public void AddResult(String gameId, String officialId, String athleteId, Double result, Integer score) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getNewGameID(String gameType) {
		int maxID = 0;
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(strFilePath));
			String next = input.readLine();
			
			while (next != null) {
	
				String string = next;
				String[] parts = string.split(",");
				if (parts.length >= 5) {
					if(Integer.parseInt(parts[0].replace(gameType, "")) > maxID)
						maxID = Integer.parseInt(parts[0].replace(gameType, ""));
				}
				next = input.readLine();
			}
			input.close();
		}
		catch(Exception e)
		{
		}
		return gameType + (maxID + 1);
	}
}
