import java.util.ArrayList;
import java.util.Date;

public class GameResultHandler implements IGameResult {

	private IGameResult dbMode;
	private IGameResult fileMode;
	private String filepath;
	
	public GameResultHandler(String filepath)
	{
		this.filepath = filepath;
	}
	
	@Override
	public void AddResult(String gameId, String officialId, String athleteId, Double result, Integer score) {
		try
		{
			dbMode = new DbGameResult();
			dbMode.AddResult(gameId, officialId, athleteId, result, score);
		}
		catch(Exception e)
		{
			fileMode = new FileGameResult(this.filepath);
			fileMode.AddResult(gameId, officialId, athleteId, result, score, new Date());
		}
		
	}

	@Override
	public void AddResult(String gameId, String officialId, String athleteId, Double result, Integer score,
			Date timeStamp) {
		try
		{
			dbMode = new DbGameResult();
			dbMode.AddResult(gameId, officialId, athleteId, result, score);
		}
		catch(Exception e)
		{
			fileMode = new FileGameResult(this.filepath);
			fileMode.AddResult(gameId, officialId, athleteId, result, score, timeStamp);
		}
	}

	@Override
	public void DeleteReault(String gameId) {
		try
		{
			dbMode = new DbGameResult();
			dbMode.DeleteReault(gameId);
		}
		catch(Exception e)
		{
			fileMode = new FileGameResult(this.filepath);
			fileMode.DeleteReault(gameId);
		}
	}

	@Override
	public void PrintResult() {
		try
		{
			dbMode = new DbGameResult();
			dbMode.PrintResult();
		}
		catch(Exception e)
		{
			fileMode = new FileGameResult(this.filepath);
			fileMode.PrintResult();
		}
	}

	@Override
	public ArrayList<DbGameResultModel> GetResult() {
		try
		{
			dbMode = new DbGameResult();
			return dbMode.GetResult();
		}
		catch(Exception e)
		{
			fileMode = new FileGameResult(this.filepath);
			return fileMode.GetResult();
		}
	}

	@Override
	public String getNewGameID(String gameType) {
		try
		{
			dbMode = new DbGameResult();
			return dbMode.getNewGameID(gameType);
		}
		catch(Exception e)
		{
			fileMode = new FileGameResult(this.filepath);
			return fileMode.getNewGameID(gameType);
		}
	}

}
