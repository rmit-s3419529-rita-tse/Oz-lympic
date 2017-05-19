import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * The is the text file class of Ozlympic Game Program which can read and write data by
 * text file. 
 *It can handle
 * @author SZUYING CHEN
 * @version 1.1
 * @since 2017-05-05
 */
public class FileGameResult implements IGameResult {

	private String strFilePath;
	public FileGameResult(String filePath){
		strFilePath=filePath;
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
		// TODO Auto-generated method stub
		ArrayList<DbGameResultModel> participants = new  ArrayList<DbGameResultModel>();
		return null;
	}
//public static void main(String[] args){
//	
//    SimpleDateFormat dateformat2 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
//    String strdate2 = "02-04-2013 11:35:42";
//    Date timeStamp=null;
//    try {
//        timeStamp = dateformat2.parse(strdate2);
//    } catch (java.text.ParseException e) {
//        e.printStackTrace();
//    } 
//
//	
//	 FileGameResult testFileRs =new FileGameResult("gameResults.txt");
//	 testFileRs.AddResult("gameId", "officialId", "athleteId",  55.98, 5, timeStamp);
//}


@Override
public void AddResult(String gameId, String officialId, String athleteId, Double result, Integer score,Date timeStamp) {
	// TODO Auto-generated method stub
	PrintWriter writer = null;
	try{
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
}
