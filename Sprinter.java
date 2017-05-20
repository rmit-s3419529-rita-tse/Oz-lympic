/**
 * The is the Sprinter class of Ozlympic Game Program
 * which handles the Sprinter method.
 *
 * @author  Rita Tse
 * @version 1.0
 * @since   2017-04-07
 */

import java.util.Random;

public class Sprinter extends Athlete {

	public double time;


	//Constructor
	//public Sprinter(String ID, String type, String name, int age, String state) {
	public Sprinter(String ID, String type, String name, int age, String state, int score) {
		super(ID, type, name, age, state, score);
		//super(ID, type, name, age, state);
	}

	//Compete Method
	public double compete(){
		int minSpeed=10;
		int maxSpeed=20;

		Random r = new Random();
		return time = r.nextInt((maxSpeed-minSpeed) +1) +minSpeed;
	}

}
