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
	private Label Message;
	@FXML
	private TextArea ta;
	@FXML
	public ListView<Athlete> list;
	
	
	//table view to handle DB
	@FXML private TableView<Athlete> table;
	@FXML private TableColumn<Athlete, String> ID;
	@FXML private TableColumn<Athlete, String> type;
	@FXML private TableColumn<Athlete, String> name;
	
	
	public ObservableList<Athlete> data = FXCollections.observableArrayList(

			//test dummy data			
			new Athlete("123", "super", "name1", 23, "vic", 0),
			new Athlete("123", "cyc", "name1", 23, "vic", 0),
			new Athlete("122", "sprint", "name1", 23, "vic", 0),
			new Athlete("123", "swim", "name1", 23, "vic", 0),
			new Athlete("123", "super", "name1", 23, "vic", 0)
			
			);
		
			
	//https://stackoverflow.com/questions/22191954/javafx-casting-arraylist-to-observablelist

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ID.setCellValueFactory(new PropertyValueFactory<Athlete, String>("ID"));
		type.setCellValueFactory(new PropertyValueFactory<Athlete, String>("type"));
		name.setCellValueFactory(new PropertyValueFactory<Athlete, String>("name"));
		table.setItems(data);
		table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		//to be worked on:
		table.getItems().addAll(GameDB.swimmers);
	}

	/*pls ignore
	//table view to load athletes db
	@FXML
	private TableView<Table>  table = new TableView<>();
	@FXML
	TableView<Table> data = FXCollections.observableArrayList();
	@FXML
	TableColumn col1 = new TableColumn("ID");
	
	
	/*COMBOBOX FOR OFFICIALS........not sure if it works
	//combox for officials
	public ComboBox<Official> cb;
	ObservableList<Official> referees = FXCollections.observableArrayList(GameDB.officials);
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cb.setItems(referees);
	}
	pls ignore*/
	
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
	static ObservableList<Athlete> chosen = null;
			
	//button to control listview
	public void addAthlete(ActionEvent e){
		
		chosen = table.getSelectionModel().getSelectedItems();
		for (Athlete z : chosen) {
			list.getItems().addAll(chosen);
		}
		
		//add this observable list to Arraylist for Game to run
		Game.chosenAthletes.addAll(chosen);
	}
	
	
	public void removeAthlete(ActionEvent e){
		ObservableList<Athlete> remove = null;
		
		remove = list.getSelectionModel().getSelectedItems();
		for (Athlete q : remove){
			list.getItems().removeAll(remove);
		}
		
	}
	
	

	//temp
	private Official ref=GameDB.off1;

	//this method needs to be updated.... currently crashing
	
	//Method to Start Game Event; after Game ID is created and to add in Athletes
	public void startGame(ActionEvent e){

		System.out.println("====================  GAME INFO ===================");
		newGame();

	}
	//Method to Create Game Object
	public void newGame(){
		
		Game n = new Game(GID, Event, ref, Game.chosenAthletes);
		games.add(n);

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
