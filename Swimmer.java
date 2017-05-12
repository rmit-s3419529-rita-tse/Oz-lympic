import java.util.Random;

/**
 * The is the Swimmer class of Ozlympic Game Program
 * which handles the Swimmer method.
 *
 * @author  Rita Tse
 * @version 1.0
 * @since   2017-04-07
 */

public class Swimmer extends Athlete {

	public double time;

	//Constructor
	public Swimmer(String ID, String type, String name, int age, String state, int score) {
		super(ID, type, name, age, state, score);
	}

	//Compete Method
	public double compete(){
		int minSpeed=100;
		int maxSpeed=200;
		
		Random r = new Random();
		return time = r.nextInt((maxSpeed-minSpeed) +1) +minSpeed;
	}

}
