import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Set;

import exceptions.GameFullException;
import exceptions.NoRefereeException;
import exceptions.TooFewAthleteException;
import exceptions.WrongTypeException;
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
import javafx.scene.text.TextFlow;

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
	private Button refereebtn;
	@FXML
	private Label referee;
	
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
	

	//use later when DB can be loaded
	//DbParticipant gdb = new DbParticipant();
	//public ObservableList<Participant> data = FXCollections.observableArrayList(gdb .GetParticipants());
		
	//TEMPORARY for now - ObservableList to fill the table, gets data from databse
	GameDB gb = new GameDB();
	public ObservableList<Participant> data = FXCollections.observableArrayList(gb.part);
	
	//initalisations of table
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ID.setCellValueFactory(new PropertyValueFactory<Participant, String>("ID"));
		type.setCellValueFactory(new PropertyValueFactory<Participant, String>("type"));
		name.setCellValueFactory(new PropertyValueFactory<Participant, String>("name"));
		table.setItems(data);
		table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}
	
	//not sure if needed
	//displays and confirms message
	String msg = null;
	
		
	//Button actions for Sport event selections
	public void selectSwim(ActionEvent event) {
		Message.setText("You have selected Swimming.");

		Swimcount++;
		GenerateGameID("SW0");
		selection = 7;
		Event="Swimming";
	}
	
	public void selectTrack(ActionEvent event) {
			Message.setText("You have selected Track.");

			Trackcount++;
			GenerateGameID("T0");
			selection =8;
			Event="Track";
	}
	
	public void selectCycle(ActionEvent event) {
		Message.setText("You have selected Cycling.");

		Cyclecount++;
		GenerateGameID("C0");
		selection =9;
		Event="Cycling";
		
	}
	
	//Game selection..maybe not needed
	private int selection;



	//Counters for Game Events, and initial Game ID
	private int Swimcount = 0;
	private int Cyclecount = 0;
	private int Trackcount = 0;
	private String GID=null;
	private String Event=null;
	
	
	//list to handle user selections on gui - empty to start with
	static ObservableList<Participant> chosen;
		

	//button to add and remove selected participants
	//add from table
	public void addAthlete(ActionEvent e){
		
		//add selected athletes from table into chosen List
		chosen = table.getSelectionModel().getSelectedItems();
		
		//get selection to display on the ListView on gui - string and in that format
		for (Participant z : chosen) {
			list.getItems().add(z.getID() + "-" + z.getName() + "-" + z.getType());
		}
	}
		
	//remove from selected list
	public void removeAthlete(ActionEvent e){
		//list view that holds the list as strings in listviewbox
		ObservableList<String> remove;
		
		remove = list.getSelectionModel().getSelectedItems();

		for (String q : remove){
			list.getItems().removeAll(remove);
			}		
	}
	
	
	
	//unchecked participants list
	ArrayList<Participant> unchecked = new ArrayList<Participant>();
	
	//add selected athletes to list Game arraylist
	public void getUserSelectedAthletes(){
	//method to loop through arraylist (participants)
	//use id too retrieve one whole participant object
	//public void getAthlete(){

	//use split to split the id, name, type and add them into array
	//use the id to call the athlete object
		
		for (int i=0; i < list.getItems().size(); i++){ 
			
			System.out.println(list.getItems().get(i));
			
			String[] output = list.getItems().get(i).split("\\-");
			System.out.println(output[0]);
			
		//looping through gb.part database arraylist to find
		//for (Participant p : gdb.GetParticipants()){
		for (Participant p : gb.part){
			if (p.getID().equals(output[0])){
			System.out.println(p.getName()+p.getAge());
			//Game.chosenAthletes.add((Athlete) p);
			unchecked.add(p);
			//add to one arraylist to check for duplicates, wrong type
			
			//add directly to arraylist
			Game.chosenAthletes.add((Athlete) p);
			}
		} 
		
		}				
	}
	
	
	//to be continued...only handling duplicates...do last
	public void checkAthletesSelection(){
		
		//remove duplicates
		Set<Participant> set = new HashSet<Participant>(unchecked);
		
		Game.chosenAthletes.add((Athlete) set);
		//for testing purposes
		   for (Object theFruit : set){
			      System.out.println(theFruit);
		   }
	}
	

	//EXCEPTION for checking valid number of athletes
	public void checkAthleteNo(int num) throws TooFewAthleteException, GameFullException {
		
		//twofewAthletes exception
		if (num < 5) {
			try {
		throw new TooFewAthleteException("Not enough athletes");
			} catch (TooFewAthleteException e1) {
				System.out.println(e1);
			}
	} else if 
	//Gamefull exception
		(num > 8){
		try {
		throw new GameFullException("Too many athletes in this game.");
		} catch (GameFullException e2){
		System.out.println(e2);
		}
	}
	}
	
	
		
	//button to debug print console
	public void ConfirmSelection(ActionEvent e) throws TooFewAthleteException, GameFullException, NoRefereeException, WrongTypeException{
		
		//EXCEPTION CHECKS
		checkAthleteNo(list.getItems().size());
		checkReferee(refselection);
		
		//not done
		checkAthleteType(unchecked);
		
		//PRINTING TO CONSOLE TO CHECK
		//loop takes in size of list,
		//but needs to be trimmed before using it to call particiapnts to create athletes objects

		
		getUserSelectedAthletes();
	System.out.println(Game.getChosenAthletes().toString());
	
	}

		//checkAthletesSelection();

	
	Participant refselection;
	//button to add referee - added to label
	public void addReferee(ActionEvent e){
	
		//take from selection from Observablelist
		
		refselection = table.getSelectionModel().getSelectedItem();
		
		//check if is official
		if (refselection.getType()=="Official" || refselection.getType()=="official"){
		
		//add to label
		referee.setText(refselection.getName());
		}	
	}
	
	
	//EXCEPTION
    public void checkReferee(Participant refselection) throws NoRefereeException {
		if (refselection==null) {
			try {
		throw new NoRefereeException("You haven not selected a referee for this game.");
			} catch (NoRefereeException e1) {
				ta.setText(e1.toString()); //to textarea GUI
			//	Message.setText(e1.toString()); //to GUI
				System.out.println(e1);
			}
	}
	}
    
    //EXCEPTION--- not done
    public void checkAthleteType(ArrayList<Participant> unchecked) throws WrongTypeException {
    	
    	for (Participant p : unchecked) {
    		
    if ((Event == "Swimming") && (p.getType()!="swimmer" || p.getType()!="super")){
    		try { 
    			throw new WrongTypeException ("wrong athlete type for swim game.");
    		} catch (WrongTypeException e1) {
    			ta.setText(e1.toString());
    			System.out.println(e1);
    		}
    	}		
    	}
    
    }
    
    
	
	
	

	
	
	//add this observable list to Arraylist for Game to run
	//might have to handled by the start button.........with exceptions.

				
	//Method to Start Game Event; after Game ID is created and to add in Athletes
	public void startGame(ActionEvent e){
		
		
		//checks if chosen has enough athletes or not enough
		//checks if there's an official selected
		//NoRefereeException


		System.out.println("====================  GAME INFO ===================");
		newGame();

	}
	
	
	//Method to Create Game Object
	public void newGame(){
		
		//create new game, add to games arraylist
		Game n = new Game(GID, Event, refselection, Game.chosenAthletes);
		Game.games.add(n);

		System.out.println("___________________________________________________");
		//System.out.println("GAME ID   " + n.getGameID() + " |  EVENT   " +  n.getGameType());
		System.out.println("___________________________________________________");
		Game.runGame();
		
		//display to GUI
		StringBuilder finish = new StringBuilder();
		finish.append("GAME START");
		finish.append("\n \n");
		finish.append(Game.resultsdisplay.toString());
		finish.append("\n \n");
		finish.append("WINNERS + POINTS AWARDS: ");
		finish.append("\n \n");
		finish.append(Official.awardslist.toString());
		String gameend = finish.toString();
		
		ta.setText(gameend);
		
		//clear for next game
		Game.resultsdisplay.clear();
		Official.awardslist.clear();
		

	}
	


	//Method that generates GameID for the game event	
	public String GenerateGameID(String prefix){
		StringBuilder sb = new StringBuilder();

		if (prefix == "SW0") {
			{
				sb.append(prefix);
				sb.append(Swimcount);
				GID = prefix+Swimcount;
				
			} 
		} else if (prefix=="C0") {
			sb.append(prefix);
			sb.append(Cyclecount);
			GID = prefix+Cyclecount;
			

		} else if (prefix=="T0") {
			sb.append(prefix);
			sb.append(Trackcount);
			GID = prefix+Trackcount;
			
		}
		return GID;

	}


	//Method to display each game winners
	public void DisplayResults(ActionEvent e){

		System.out.println("\n ========= Game Results: =========== \n");
		for (int i=0; i < Game.games.size(); i++){
			System.out.println(Game.games.get(i).getGameID() + " | ");
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
