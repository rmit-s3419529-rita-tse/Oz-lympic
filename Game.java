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
	static Official off;
	public Date d ;

	//Hashmap for keeping game results for each event
	static HashMap<Integer, Athlete> results = new HashMap<Integer, Athlete>();
	
	static HashMap<String, Double> gameTime = new HashMap<String, Double>();

	//ArrayList for chosen Athletes participating in the game event
	static ArrayList<Participant> chosenAthletes = new ArrayList<Participant>();


	//ArrayList to hold game events
	static ArrayList<Game> games = new ArrayList<Game>();

	//Game constructor
	public Game(String gameID, String gameType, Participant refselection, ArrayList<Participant> chosenAthletes){
			
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


	public static ArrayList<Participant> getChosenAthletes() {
					
		return chosenAthletes;
	}

	public ArrayList<Game> getGames() {
		return games;
	}


	//NEW to print athlete time to GUI
	static ArrayList <String> resultsdisplay = new ArrayList();
	


	//Method that Runs the Game Event, loops through the chosenAthletes list, checks if their athlete types and generate a time for each
	public static void runGame(String gameID, Participant official){

		
		for (Participant athlete : chosenAthletes){
		
			
			if (athlete.getType().equals("swimmer")){
		
				Swimmer swim = new Swimmer(athlete.getID(),athlete.getType(),athlete.getName(), athlete.getAge(), athlete.getState(),0);
				swim.compete();
				
				//add to arraylist and sends to GUI
				resultsdisplay.add(athlete.getName() + "  ...   " + swim.time);
				
				Official.competed.add(swim);
				
				
				results.put((int) swim.time, swim);
				gameTime.put(swim.getID(), swim.time);
			}
			else if 
			
			(athlete.getType().equals("cyclist")) {
				
				
				Cyclist c = new Cyclist(athlete.getID(),athlete.getType(),athlete.getName(), athlete.getAge(), athlete.getState(),0);
				c.compete();
				
				resultsdisplay.add(athlete.getName() + "  ...  " + c.time);
				
				
				Official.competed.add(c);
				System.out.println(athlete.getName() + "  ...  " + c.time);
				
				results.put((int) c.time, c);
				gameTime.put(c.getID(), c.time);
			}
			else if 
			
			(athlete.getType().equals("sprinter"))
				
			{
				Sprinter s = new Sprinter(athlete.getID(),athlete.getType(),athlete.getName(), athlete.getAge(), athlete.getState(),0);
				s.compete();
				
				resultsdisplay.add(athlete.getName() + "  ...   " + s.time);
				
				System.out.println(athlete.getName() + "  ...   " + s.time);
				
				Official.competed.add(s);
				results.put((int) s.time, s);
				gameTime.put(s.getID(), s.time);
			}
			else if 
			
			(athlete.getType().equals("super"))
				
				{
				SuperAthlete SA = new SuperAthlete(athlete.getID(),athlete.getType(),athlete.getName(), athlete.getAge(), athlete.getState(),0);
				SA.compete(Game.gameType);
				
				resultsdisplay.add(athlete.getName() + "  ...   " + SA.time);
				
				System.out.println(athlete.getName() + "  ...   " + SA.time);
				
				Official.competed.add(SA);
				results.put((int) SA.time, SA);
				gameTime.put(SA.getID(), SA.time);
			}
		}
		
		FinishLine(gameID, official, gameTime);
	}
	
	

	
	
	//method to handle the official methods after the game is run
	public static void FinishLine(String gameID, Participant official, HashMap<String, Double> gameTime) {

		Official.sumGame(results);
		Official.awardWinners(gameID, official, gameTime);

		//Clear list for new game
		chosenAthletes.clear();
	}


}


