import java.util.Random;
/**
 * The is the SuperAthlete class of Ozlympic Game Program
 * which handles the Super Athlete method.
 *
 * @author  Rita Tse
 * @version 1.0
 * @since   2017-04-07
 */

public class SuperAthlete extends Athlete {

	public double time;

	//Constructor
	public SuperAthlete(String ID, String type, String name, int age, String state, int score) {
		super(ID, type, name, age, state, score);
	}

	//Compete Method
	public double compete(String gameType) {
		int maxSpeed=0;
		int minSpeed=0;

		if (gameType=="Swimming"){
			minSpeed = 100;
			maxSpeed = 200;

		} else if (gameType=="Track") {
			minSpeed=10;
			maxSpeed=20;

		} else if (gameType=="Cycling") {
			minSpeed = 500;
			maxSpeed = 800;
		}

		Random r = new Random();
		return time = r.nextInt((maxSpeed-minSpeed) +1) +minSpeed;
	}


}
