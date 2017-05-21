import java.util.ArrayList;
import java.util.Date;

public interface IGameResult {
	
	final String GAME_ID_PREFIX_SWIMMING = "SW0";
	final String GAME_ID_PREFIX_CYCLING = "C0";
	final String GAME_ID_PREFIX_TRACK = "T0";
	
	void AddResult(String gameId, String officialId, String athleteId, Double result, Integer score);
	void AddResult(String gameId, String officialId, String athleteId, Double result, Integer score,Date timeStamp);
	void DeleteReault(String gameId);
	void PrintResult();
	ArrayList<DbGameResultModel> GetResult();
	String getNewGameID(String gameType);
	
}