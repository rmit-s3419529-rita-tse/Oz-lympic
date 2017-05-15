import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/**
 * The is the Game Class of Ozlympic Game Program
 * which handles the main game mechanics of the program.
 *
 * @author  Rita Tse
 * @version 1.0
 * @since   2017-04-07
 */

public class Game {

	public String gameID;
	static String gameType;
	public Official off;

	//Hashmap for keeping game results for each event
	static HashMap<Integer, Athlete> results = new HashMap<Integer, Athlete>();

	//ArrayList for chosen Athletes participating in the game event
	static ArrayList<Athlete> chosenAthletes = new ArrayList<Athlete>();


	//ArrayList to hold game events
	ArrayList<Game> games = new ArrayList<Game>();

	//Game constructor
	public Game(String gameID, String gameType, Official off, ArrayList<Athlete> chosenAthletes){
		this.gameID = gameID;
		Game.gameType = gameType;
		this.chosenAthletes= chosenAthletes;
		this.off=off;
	}

	//Getters
	public String getGameID() {
		return gameID;
	}

	public static String getGameType() {
		return gameType;
	}

	public Official getOfficials() {
		return off;
	}

	public static ArrayList<Athlete> getChosenAthletes() {
		return chosenAthletes;
	}

	public ArrayList<Game> getGames() {
		return games;
	}

/*	

	//*** METHOD TO BE UPDATED - as USER PICKS ATHLETES, random pick and joining the lists of athletes are not needed
	
	//Method to add regular and super athletes lists together, then pick out athletes for the Game based on User's selection
	public static void AddAthletes(int selection){

		ArrayList<Athlete> Tathletes = new ArrayList<Athlete>();
		if (selection ==7){	
			Tathletes.addAll(GameDB.swimmers);
			Tathletes.addAll(GameDB.superAthletes);
		} else if (selection ==8) {
			Tathletes.addAll(GameDB.sprinters);
			Tathletes.addAll(GameDB.superAthletes);
		} else if (selection ==9){
			Tathletes.addAll(GameDB.cyclists);
			Tathletes.addAll(GameDB.superAthletes);
		}

		//Shuffles the athletes up before picking them for the game
		Collections.shuffle(Tathletes);

		//Pick a random number of athletes to be selected in the game
		Random r = new Random();
		int numChosen = r.nextInt(8-5 +1)+5;

		ArrayList<Athlete> TchosenAthletes = new ArrayList(Tathletes.subList(0, numChosen));

		// Print out the chosen Athletes for the User
		System.out.println("================ Participating Athletes ============== ");

		for (int x = 0;x < numChosen;x++)
		{
			System.out.println(TchosenAthletes.get(x).getID() + "    |    " + TchosenAthletes.get(x).getName() + "    |   " + TchosenAthletes.get(x).getState() + "\n");
		}
		chosenAthletes.addAll(TchosenAthletes);

	}
	*/


	//Method that Runs the Game Event, loops through the chosenAthletes list, checks if their athlete types and generate a time for each
	public static void runGame(){

		System.out.println("\n Ready Set Go!!!  ----------------------------------- \n");
		
		//if (gametype==swim) {
		//swim.compete()

		for (Athlete athlete : Driver.chosen){

			if (athlete instanceof Swimmer){
				Swimmer swim = (Swimmer) athlete;
				swim.compete();
				System.out.println(athlete.getName() + "  ...   " + swim.time);
				results.put((int) swim.time, athlete);
			}
			else if (athlete instanceof Cyclist){
				Cyclist c = (Cyclist) athlete;
				c.compete();
				System.out.println(athlete.getName() + "  ...  " + c.time);
				results.put((int) c.time, athlete);
			}
			else if (athlete instanceof Sprinter){
				Sprinter s = (Sprinter) athlete;
				s.compete();
				System.out.println(athlete.getName() + "  ...   " + s.time);
				results.put((int) s.time, athlete);
			}
			else if (athlete instanceof SuperAthlete){
				SuperAthlete SA = (SuperAthlete) athlete;
				SA.compete(Game.gameType);
				System.out.println(athlete.getName() + "  ...   " + SA.time);
				results.put((int) SA.time, athlete);
			}
		}

		FinishLine();
	}
	
	
	//UPDATED CODE
	//method to handle the official methods after the game is run
	public static void FinishLine() {
		System.out.println(".............................................");
		Official.sumGame(results);
		Official.awardWinners();


		System.out.println("===========================================.\n \n");

		//Clear list for new game
		chosenAthletes.clear();
	}

}


