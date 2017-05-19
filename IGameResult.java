import java.util.List;

public interface IGameResult {
	void AddResult(String gameId, String officialId, String athleteId, Double result, Integer score);
	void DeleteReault(String gameId);
	void PrintResult();
	List<DbGameResultModel> GetResult();
	
}