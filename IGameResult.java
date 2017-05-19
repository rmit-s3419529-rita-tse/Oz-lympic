import java.util.ArrayList;
import java.util.Date;

public interface IGameResult {
	void AddResult(String gameId, String officialId, String athleteId, Double result, Integer score);
	void AddResult(String gameId, String officialId, String athleteId, Double result, Integer score,Date timeStamp);
	void DeleteReault(String gameId);
	void PrintResult();
	ArrayList<DbGameResultModel> GetResult();
	
}