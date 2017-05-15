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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

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
	private Button swimbtn;
	@FXML
	private Button trackbtn;
	@FXML
	private Button cyclebtn;
	@FXML 
	private Button startbtn;
	@FXML
	private Button resultsbtn;
	@FXML
	private Button rankingsbtn;
	
	@FXML
	private Label Message;
	@FXML
	private TextArea ta;
	
	//listview of selected participants
	@FXML public ListView<String> list;

		
	
	//table view to handle DB- firstable view
	@FXML private TableView<Participant> table;
	@FXML private TableColumn<Participant, String> ID;
	@FXML private TableColumn<Participant, String> type;
	@FXML private TableColumn<Participant, String> name;
	

	//use later
	//GameDatabase gdb = new GameDatabase();
	
	//test for now
	GameDB gb = new GameDB();
	public ObservableList<Participant> data = FXCollections.observableArrayList(gb.part);
	
	
	
	
	//user line below later when DB is complete
	//public ObservableList<Participant> data = FXCollections.observableArrayList(gdb .GetParticipants());
	
	

	//https://stackoverflow.com/questions/22191954/javafx-casting-arraylist-to-observablelist

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ID.setCellValueFactory(new PropertyValueFactory<Participant, String>("ID"));
		type.setCellValueFactory(new PropertyValueFactory<Participant, String>("type"));
		name.setCellValueFactory(new PropertyValueFactory<Participant, String>("name"));
		table.setItems(data);
		table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}
	
	
	//displays and confirms message
	String msg = null;
	
	
	
	//Button actions
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
	
	
	//list to handle user selections
	static ObservableList<Participant> chosen = null;
			
	//button to add and remove selected participants
	//add from table
	public void addAthlete(ActionEvent e){
				
		chosen = table.getSelectionModel().getSelectedItems();
		
		for (Participant z : chosen) {
			
			list.getItems().add(z.getName() + " " + z.getType());
		}
	}
	
	//remove from selected list
	public void removeAthlete(ActionEvent e){
		ObservableList<String> remove = null;
		
		remove = list.getSelectionModel().getSelectedItems();

		for (String q : remove){
			list.getItems().removeAll(remove);
		}
	}
	
		
	
	//add this observable list to Arraylist for Game to run
	//might have to handled by the start button.........with exceptions.
		//Game.chosenAthletes.addAll(chosen);
		//Game.chosenAthletes.add(chosen);

				
	//Method to Start Game Event; after Game ID is created and to add in Athletes
	public void startGame(ActionEvent e){
		
		
		//checks if chosen has enough athletes
		//checks if there's an official selected
		//checks if any 

		System.out.println("====================  GAME INFO ===================");
		newGame();

	}
	
	
	//Method to Create Game Object
	public void newGame(){
		
		//Game n = new Game(GID, Event, ref, Game.chosenAthletes);
		//games.add(n);

		System.out.println("___________________________________________________");
		//System.out.println("GAME ID   " + n.getGameID() + " |  EVENT   " +  n.getGameType());
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


	//Method to display each game winners
	public void DisplayResults(ActionEvent e){

		System.out.println("\n ========= Game Results: =========== \n");
		for (int i=0; i < games.size(); i++){
			System.out.println(games.get(i).getGameID() + " | ");
			System.out.println(Official.GameResults.get(i));
			System.out.println("__________________________________________________________");
		}
		System.out.println("---------------------------------------------------------");

	}

	//Method to Display Overall Rankings of Athletes
	public void DisplayRankings(ActionEvent e){

		System.out.println("\n ++++++++++ OZLYMPIC GAME RANKINGS +++++++++++++");
		//Official.awardRank();
	}


//updated code - exit in TOP MENU
	//Method when User leaves game, prints a good-bye message.
	public void Exit(){
		Message.setText("Thank you for playing.");
		Platform.exit();
		System.exit(0);
	}






}
