
public class DbGameResultModel {
	
	public static final String COL_GAME_ID = "GAMEID";
	public static final String COL_OFFICIAL_ID = "OFFICIALID";
	public static final String COL_ATHLETE_ID = "ATHLETEID";
	public static final String COL_RESULT = "RESULT";
	public static final String COL_SCORE = "SCORE";
	
	private String gameId;
	private String officialId;
	private String athleteId;
	private Double result;
	private Integer score;
	
	
	public DbGameResultModel(String gameId, String officialId, String athleteId, Double result,
			Integer score) {
		super();
		this.gameId = gameId;
		this.officialId = officialId;
		this.athleteId = athleteId;
		this.result = result;
		this.score = score;
	}


	public DbGameResultModel() {
		super();
	}


	
	public String getGameId() {
		return gameId;
	}


	public void setGameId(String gameId) {
		this.gameId = gameId;
	}


	public String getOfficialId() {
		return officialId;
	}


	public void setOfficialId(String officialId) {
		this.officialId = officialId;
	}


	public String getAthleteId() {
		return athleteId;
	}


	public void setAthleteId(String athleteId) {
		this.athleteId = athleteId;
	}


	public Double getResult() {
		return result;
	}


	public void setResult(Double result) {
		this.result = result;
	}


	public Integer getScore() {
		return score;
	}


	public void setScore(Integer score) {
		this.score = score;
	}


	@Override
	public String toString() {
		return "gameId=" + gameId + ", officialId=" + officialId + ", athleteId=" + athleteId
				+ ", result=" + result + ", score=" + score + "";
	}
	
	
	
}
