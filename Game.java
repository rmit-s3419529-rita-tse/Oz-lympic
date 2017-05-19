import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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
	public Date d ;

	//Hashmap for keeping game results for each event
	static HashMap<Integer, Athlete> results = new HashMap<Integer, Athlete>();

	//ArrayList for chosen Athletes participating in the game event
	static ArrayList<Athlete> chosenAthletes = new ArrayList<Athlete>();


	//ArrayList to hold game events
	static ArrayList<Game> games = new ArrayList<Game>();

	//Game constructor
	public Game(String gameID, String gameType, Participant refselection, ArrayList<Athlete> chosenAthletes){
		this.gameID = gameID;
		Game.gameType = gameType;
		this.chosenAthletes= chosenAthletes;

		this.off=off;
		d = new Date();

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


	//NEW to print athlete time to GUI
	static ArrayList <String> resultsdisplay = new ArrayList();
	
	
	

	

	//Method that Runs the Game Event, loops through the chosenAthletes list, checks if their athlete types and generate a time for each
	public static void runGame(){

		System.out.println("\n Ready Set Go!!!  ----------------------------------- \n");
		
		for (Athlete athlete : chosenAthletes){

			if (athlete instanceof Swimmer){
				Swimmer swim = (Swimmer) athlete;
				swim.compete();
				
				//add to arraylist and sends to GUI
				resultsdisplay.add(athlete.getName() + "  ...   " + swim.time);
				
				System.out.println(athlete.getName() + "  ...   " + swim.time);
				results.put((int) swim.time, athlete);
			}
			else if (athlete instanceof Cyclist){
				Cyclist c = (Cyclist) athlete;
				c.compete();
				
				resultsdisplay.add(athlete.getName() + "  ...  " + c.time);
				
				System.out.println(athlete.getName() + "  ...  " + c.time);
				
				results.put((int) c.time, athlete);
			}
			else if (athlete instanceof Sprinter){
				Sprinter s = (Sprinter) athlete;
				s.compete();
				
				resultsdisplay.add(athlete.getName() + "  ...   " + s.time);
				
				System.out.println(athlete.getName() + "  ...   " + s.time);
				
				results.put((int) s.time, athlete);
			}
			else if (athlete instanceof SuperAthlete){
				SuperAthlete SA = (SuperAthlete) athlete;
				SA.compete(Game.gameType);
				
				resultsdisplay.add(athlete.getName() + "  ...   " + SA.time);
				
				System.out.println(athlete.getName() + "  ...   " + SA.time);
				results.put((int) SA.time, athlete);
			}
		}
		
		FinishLine();
	}
	
	
	//
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


