import java.util.Random;
/**
 * The is the Cyclist class of Ozlympic Game Program
 * which handles the Cyclist method.
 *
 * @author  Rita Tse
 * @version 1.0
 * @since   2017-04-07
 */

public class Cyclist extends Athlete {
	
	public double time;

	//Constructor
	public Cyclist(String ID, String name, int age, String state, int score) {
		super(ID, name, age, state, score, "CYCLIST");
	}

	//Compete Method
	public double compete(){
		int minSpeed=500;
		int maxSpeed=800;
		
		Random r = new Random();
		return time = r.nextInt((maxSpeed-minSpeed) +1) +minSpeed;
	}

}
