/**
 * The is the Driver of Ozlympic Game Program
 * which handles the main mechanics of the game.
 *
 * @author  Rita Tse
 * @version 1.0
 * @since   2017-04-07
 */

public class Athlete extends Participant {

	private int score=0;


	//Constructor
	//public Athlete(String ID, String type, String name, int age, String state) {
	public Athlete(String ID, String type, String name, int age, String state, int score) {
		super(ID, type, name, age, state);
		this.score=score;

	}

	//Getter
	public int getScore(){
		return score;
	}

	//Compete method for all Athletes, will be overridden depending on type of Athlete
	public double compete(){
		double time=0;
		return time;
	}

	//Score method for their ranking
	public int addScore(int points){
		return score += points;
	}

	@Override
	public boolean equals(Object obj) {
		if(this.getID().toString().trim().equals(((Athlete)obj).getID().toString().trim()))
			return true;
		return false;
	}

	//Prints Athlete details
	public String toString(){
		return " | ID: " + getID() + " |  " +  getType() + "  |  "  + getName() + "   ===  Total Score : " + getScore();
	}
}
