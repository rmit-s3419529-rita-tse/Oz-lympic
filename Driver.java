import java.net.URL;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 * The is the Driver of Ozlympic Game Program
 * which handles the main mechanics of the game.
 *
 * @author  Rita Tse
 * @version 1.0
 * @since   2017-04-07
 */

//Main controller
public class Driver implements Initializable {
	//NEW CODE
	@FXML
	private Label Message;
	
	private TextArea ta;
	
	
	//public ComboBox<String> cb;
	ObservableList<Athlete> list = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//cb.setItems(list);
	}
	
	//displays and confirms message
	String msg = null;
	
	//NEW BUTTONS
	//buttons to select sports
	public void selectSwim(ActionEvent event) {
		Message.setText("You have selected Swimming.");

		Swimcount++;
		GenerateGameID("SW0");
		selection = 7;

	}
	
	public void selectTrack(ActionEvent event) {
			Message.setText("You have selected Track.");

			Trackcount++;
			GenerateGameID("T0");
			selection =8;

	}
	
	public void selectCycle(ActionEvent event) {
		Message.setText("You have selected Cycling.");

		Cyclecount++;
		GenerateGameID("C0");
		selection =9;
		
	}
	
	//NEW CODE ENDS
	
	//Game selection
	private int selection;

	//Games stored in ArrayList
	ArrayList<Game> games = new ArrayList<Game>();

	//Counters for Game Events, and initial Game ID
	private int Swimcount = 0;
	private int Cyclecount = 0;
	private int Trackcount = 0;
	private String GID=null;
	private String Event=null;


	//Referee for the Game
	private Official chosenReferee;


	//Method to Start Game Event; after Game ID is created and to add in Athletes
	public void startGame(){

		System.out.println("====================  GAME INFO ===================");
		Game.AddAthletes(selection);//needs to remove
		newGame();

	}

	//Method to Create Game Object
	public void newGame(){

		Game n = new Game(GID, Event, chosenReferee, Game.chosenAthletes);
		games.add(n);

		SelectOfficial();
		System.out.println("___________________________________________________");
		System.out.println("GAME ID   " + n.getGameID() + " |  EVENT   " +  n.getGameType());
		System.out.println("___________________________________________________");
		Game.runGame();

	}


	//Method that generates GameID for the game event	
	public String GenerateGameID(String prefix){
		StringBuilder sb = new StringBuilder();

		if (prefix == "SW0") {
			{
				sb.append(prefix);
				sb.append(Swimcount);
				GID = prefix+Swimcount;
				Event ="Swimming";
			} 
		} else if (prefix=="C0") {
			sb.append(prefix);
			sb.append(Cyclecount);
			GID = prefix+Cyclecount;
			Event = "Cycling";

		} else if (prefix=="T0") {
			sb.append(prefix);
			sb.append(Trackcount);
			GID = prefix+Trackcount;
			Event="Track";
		}
		return GID;

	}

//not needed - needs to be changed to select official
	//Method to select the Official referee for the Game
	public Official SelectOfficial (){

		Random ran = new Random();
		int ref = ran.nextInt(4);

		System.out.println("The Official Referee for this Game is: " + GameDB.officials[ref].getID() + "   " + GameDB.officials[ref].getName());

		return chosenReferee = GameDB.officials[ref];

	}


	//Method to display each game winners
	public void DisplayResults(){

		System.out.println("\n ========= Game Results: =========== \n");
		for (int i=0; i < games.size(); i++){
			System.out.println(games.get(i).getGameID() + " | ");
			System.out.println(Official.GameResults.get(i));
			System.out.println("__________________________________________________________");
		}
		System.out.println("---------------------------------------------------------");

	}

	//Method to Display Overall Rankings of Athletes
	public void DisplayRankings(){

		System.out.println("\n ++++++++++ OZLYMPIC GAME RANKINGS +++++++++++++");
		Official.awardRank();
	}


//updated code - exit in TOP MENU
	//Method when User leaves game, prints a good-bye message.
	public void Exit(){
		Message.setText("Thank you for playing.");
		Platform.exit();
		System.exit(0);
	}




}
