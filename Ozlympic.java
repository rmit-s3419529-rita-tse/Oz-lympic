/**
 * The is the Ozlympic Game Program.
 * It has three types of games a User can choose to run.
 * 
 * @author  Rita Tse
 * @version 1.0
 * @since   2017-04-07
 **
 ***
 ****
 *****hello
 */

public class Ozlympic {



	public static void main(String[] args) {

		//Loads and initialise the Database and the Driver for the Game
		GameDB.LoadDB();

		Driver a = new Driver();
		a.OzlympicStart();


	}

}
