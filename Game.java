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


	
	

	

	//Method that Runs the Game Event, loops through the chosenAthletes list, checks if their athlete types and generate a time for each
	public static void runGame(){

		System.out.println("\n Ready Set Go!!!  ----------------------------------- \n");
		
		//if (gametype==swim) {
		//swim.compete();
		//results.put((int).swim.time, athlete);
		
		//casted from previous..might have to change back
		for (Participant athlete : Driver.chosen){

			if (athlete instanceof Swimmer){
				Swimmer swim = (Swimmer) athlete;
				swim.compete();
				System.out.println(athlete.getName() + "  ...   " + swim.time);
				results.put((int) swim.time, (Athlete) athlete);
			}
			else if (athlete instanceof Cyclist){
				Cyclist c = (Cyclist) athlete;
				c.compete();
				System.out.println(athlete.getName() + "  ...  " + c.time);
				results.put((int) c.time, (Athlete) athlete);
			}
			else if (athlete instanceof Sprinter){
				Sprinter s = (Sprinter) athlete;
				s.compete();
				System.out.println(athlete.getName() + "  ...   " + s.time);
				results.put((int) s.time, (Athlete) athlete);
			}
			else if (athlete instanceof SuperAthlete){
				SuperAthlete SA = (SuperAthlete) athlete;
				SA.compete(Game.gameType);
				System.out.println(athlete.getName() + "  ...   " + SA.time);
				results.put((int) SA.time, (Athlete) athlete);
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


