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
	private Button confirm;
	
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
	IParticipant gdb = new ParticipantHandler("participants.txt");
	public ObservableList<Participant> data = FXCollections.observableArrayList(gdb .GetParticipants(null));
		
	//TEMPORARY for now - ObservableList to fill the table, gets data from databse
	//GameDB gb = new GameDB();
	//public ObservableList<Participant> data = FXCollections.observableArrayList(gb.part);
	
	//initalisations of table
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ID.setCellValueFactory(new PropertyValueFactory<Participant, String>("ID"));
		type.setCellValueFactory(new PropertyValueFactory<Participant, String>("type"));
		name.setCellValueFactory(new PropertyValueFactory<Participant, String>("name"));
		table.setItems(data);
		table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}	
	
	//Counters for Game Events, and initial Game ID
	private int Swimcount = 0;
	private int Cyclecount = 0;
	private int Trackcount = 0;
	private String GID=null;
	private String Event=null;
	
		
	//Button actions for Sport event selections
	public void selectSwim(ActionEvent event) {
		Message.setText("You have selected Swimming.");

		Swimcount++;
		GenerateGameID("SW0");
		Event="Swimming";
	}
	
	public void selectTrack(ActionEvent event) {
			Message.setText("You have selected Track.");

			Trackcount++;
			GenerateGameID("T0");
			Event="Track";
	}
	
	public void selectCycle(ActionEvent event) {
		Message.setText("You have selected Cycling.");

		Cyclecount++;
		GenerateGameID("C0");
		Event="Cycling";
		
	}
	

	
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
	ArrayList<Participant> checked = new ArrayList<Participant>(); 
	
	//add selected athletes to list unchecked Athletes list
	public void getUserSelectedAthletes(){
	//method to loop through arraylist (participants)
	//use id too retrieve one whole participant object
	//use split to split the id, name, type and add them into array
	//use the id to call the athlete object
		
		for (int i=0; i < list.getItems().size(); i++){ 
			
			//printing to console to debug
			System.out.println(list.getItems().get(i));
			
			String[] output = list.getItems().get(i).split("\\-");
			
			//printing to console to debug
			System.out.println(output[0]);
			
		//looping through gb.part database arraylist to find
		
	  for (Participant p : gdb.GetParticipants(null)){
		//for (Participant p : gb.part){
			if (p.getID().equals(output[0])){
				
				//printing to console to debug
			System.out.println(p.getName()+p.getAge());
			
			//gets user's selected athletes
			unchecked.add(p);
			
			}
		} 
		
		}				
	}
	

	//EXCEPTION for checking valid number of athletes
	public void checkAthleteNo(int num) throws TooFewAthleteException, GameFullException {
		
		//twofewAthletes exception
		if (num < 5) {
			try {
		throw new TooFewAthleteException("Not enough athletes");
			} catch (TooFewAthleteException e1) {
				ta.setText(e1.toString());
				
				//printing to console to debug
				System.out.println(e1);
				
				gameReady=false;
			}
	} else if 
	//Gamefull exception
		(num > 8){
		try {
		throw new GameFullException("Too many athletes in this game.");
		} catch (GameFullException e2){
			
			//printing to console to debug
		System.out.println(e2);
		
		ta.setText(e2.toString());
		gameReady=false;
		
		}
	}
	}
	
	boolean validNumAthletes = false;
	
	public void NumAthletes() throws TooFewAthleteException, GameFullException {
		
		//checks list size - not enough or too many
		checkAthleteNo(list.getItems().size());
	
	}
	
	
	boolean validTypeAthletes;
	
	public void TypeAthletes() throws WrongTypeException, NoRefereeException {
		
		//get list into arraylist
		getUserSelectedAthletes();
		
		//checks athlete types
		checkAthleteType(unchecked);
		
	}

	
	
	boolean gameReady = false;
		
	//confirm button to debug print console
	public void ConfirmSelection(ActionEvent e) throws NoRefereeException, WrongTypeException, TooFewAthleteException, GameFullException{
		
		do {
			//checks number of athletes user selected
		NumAthletes();

		//failed number of athletes
		if (validNumAthletes=false){
			ta.setText("please check number of selections");
			checked.clear();
			unchecked.clear();
			gameReady=false;
			
		} else {
			//enough and not too many atheltes ==> check types of participants match game selection
			TypeAthletes();
		}
		
		//failed type of athletes(wrong type for the game)
		if (validTypeAthletes = false){
			//clear lists as users update the lists
			checked.clear();
			unchecked.clear();
			gameReady=false;
			
		} else {
			
			//type of athletes match event type
			//add checked type athletes list to checked list
			for (Participant p : unchecked){
			checked.add(p);
			gameReady=false;
			
			//check if referee is selected
			refChecked();
		}
			//referee is not selected
			if (refereeExists=false){
				gameReady=false;
			} 
		}
		
		//should print only when all exceptions/checks are ok
		//not right
	//ta.setText("YOUR GAME IS READY. Please press START GAME.");

		} while(gameReady);//while gameReady=true
		
	}
	
	
	public void refChecked() throws NoRefereeException {
		
		//check ref selection
		checkReferee(refselection);
		
	}
	

	static Participant refselection;
	
	//button to add referee - added to label
	public void addReferee(ActionEvent e){
	
		//take from selection from Observablelist
		refselection = table.getSelectionModel().getSelectedItem();
		
		//check if is official
		if (refselection.getType().equals("Official")){
		
		//add to label
		referee.setText(refselection.getName());
		}	
	}
	
	boolean refereeExists;
	//EXCEPTION
    public void checkReferee(Participant refselection) throws NoRefereeException {
    	
    	if (refselection==null) {
			try {
		throw new NoRefereeException("\nYou have not selected a referee for this game.\n Please select one before you proceed");
			} catch (NoRefereeException e3) {
				ta.setText(e3.toString());
				
				//printing to console to debug
				System.out.println(e3);
				refereeExists=false;
			}
	}
	}
    
    
	// EXCEPTION
	public void checkAthleteType(ArrayList<Participant> unchecked) throws WrongTypeException {

		if (Event == "Swimming") {

	    	for (Participant p : unchecked) {
	    		 
	    		if (p.getType().equals("sprinter") || p.getType().equals("cyclist")) {
	    			try { throw new WrongTypeException ("\nYou've selected the wrong type of athletes for swim game.\n");
	    		} catch (WrongTypeException e4) {
	    			ta.setText(e4.toString());
	    			//printing to console to debug
	    			System.out.println(e4);
	    			
	    			validTypeAthletes=false;
	    			gameReady=false;
	    			unchecked.clear();
	    			break;
	    		}
	    	}	
		} 
		} else if (Event=="Track") {
			for (Participant p : unchecked) {
				 
	    		if (p.getType().equals("swimmer") || p.getType().equals("cyclist")) {
	    			try { throw new WrongTypeException ("\nYou've selected the wrong type of athletes for track game\n");
	    		} catch (WrongTypeException e5) {
	    			ta.setText(e5.toString());
	    			//printing to console to debug
	    			System.out.println(e5);
	    			
	    			validTypeAthletes=false;
	    			gameReady=false;
	    			unchecked.clear();
	    			break;
	    		}
	    	}	
			}
		} else if (Event == "Cycling") {
			for (Participant p : unchecked) {
				 
	    		if (p.getType().equals("swimmer") || p.getType().equals("sprinter")) {
	    			try { throw new WrongTypeException ("\nYou've selected the wrong type of athletes for cycling game\n");
	    		} catch (WrongTypeException e6) {
	    			ta.setText(e6.toString());
	    			//printing to console to debug
	    			System.out.println(e6);
	    			
	    			validTypeAthletes=false;
	    			gameReady=false;
	    			unchecked.clear();
	    			break;
	    		}
	    	}	
			}
		}
	}
		
				
	//Method to Start Game Event; after Game ID is created and to add in Athletes
	public void startGame(ActionEvent e){
		
				
		if (gameReady=true) {
					
		//add checked athletes to arraylist		
		for (Participant p : checked){
		
		//Game.chosenAthletes.add((Athlete) p);
		Game.chosenAthletes.add(p);
		}
		
		//printing to console to debug
	System.out.println(Game.getChosenAthletes().toString());
		
	//create new game
		newGame();
		
		} else {
			ta.setText("SORRY YOUR GAME NOT READY");

	}
	}
	
	
	//Method to Create Game Object
	public void newGame(){
		
		//create new game, add to games arraylist
		Game n = new Game(GID, Event, refselection, Game.chosenAthletes);
		Game.games.add(n);		
		
		Game.runGame();
		
		//display to GUI
		StringBuilder finish = new StringBuilder();
		finish.append("====================  GAME INFO ===================");
		finish.append("\n \n");
		finish.append("GAME ID   " + n.getGameID() + " |  EVENT   " +  n.getGameType());
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
		unchecked.clear();
		checked.clear();
		
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

		//display to GUI
				StringBuilder allresults = new StringBuilder();
				allresults.append("\n ========= Game Results: =========== \n");
				
				for (int i=0; i < Game.games.size(); i++){
				allresults.append("\n \n");
				allresults.append(Game.games.get(i).getGameID() + " | ");
				allresults.append("\n");
				allresults.append(Official.GameResults.get(i));
				allresults.append("\n \n");
				allresults.append("________________________________________________");
				}
				
				String all = allresults.toString();
				ta.setText(all);

	}

	//Method to Display Overall Rankings of Athletes.....to be done
	public void DisplayRankings(ActionEvent e){

		System.out.println("\n ++++++++++ OZLYMPIC GAME RANKINGS +++++++++++++");
		Official.awardRank();
		ta.setText(Official.displayranking);
	}


//updated code - exit in TOP MENU
	//Method when User leaves game, prints a good-bye message.
	public void Exit(){
		Message.setText("Thank you for playing.");
		Platform.exit();
		System.exit(0);
	}

}
