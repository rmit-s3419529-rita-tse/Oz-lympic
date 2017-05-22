import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import com.sun.javafx.collections.MappingChange.Map;

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
 * The is the Driver of Ozlympic Game Program which handles the main mechanics
 * of the game.
 *
 * @author Rita Tse
 * @version 1.0
 * @since 2017-04-07
 */

// Main controller
public class Driver implements Initializable {
	// NEW CODE
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

	// listview of selected participants
	@FXML
	public ListView<String> list;

	// table view to handle DB- firstable view
	@FXML
	private TableView<Participant> table;
	@FXML
	private TableColumn<Participant, String> ID;
	@FXML
	private TableColumn<Participant, String> type;
	@FXML
	private TableColumn<Participant, String> name;

	// use later when DB can be loaded
	IParticipant gdb = new ParticipantHandler("participants.txt");
	public ObservableList<Participant> data = FXCollections.observableArrayList(gdb.GetParticipants(null));

	// TEMPORARY for now - ObservableList to fill the table, gets data from
	// databse
	// GameDB gb = new GameDB();
	// public ObservableList<Participant> data =
	// FXCollections.observableArrayList(gb.part);

	// initalisations of table
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ID.setCellValueFactory(new PropertyValueFactory<Participant, String>("ID"));
		type.setCellValueFactory(new PropertyValueFactory<Participant, String>("type"));
		name.setCellValueFactory(new PropertyValueFactory<Participant, String>("name"));
		table.setItems(data);
		table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}

	// Counters for Game Events, and initial Game ID
	private int Swimcount = 0;
	private int Cyclecount = 0;
	private int Trackcount = 0;
	private String GID = null;
	private String Event = null;

	// Button actions for Sport event selections
	public void selectSwim(ActionEvent event) {
		Message.setText("You have selected Swimming.");

		Swimcount++;
		//GenerateGameID("SW0");
		Event = "Swimming";
	}

	public void selectTrack(ActionEvent event) {
		Message.setText("You have selected Track.");

		Trackcount++;
		//GenerateGameID("T0");
		Event = "Track";
	}

	public void selectCycle(ActionEvent event) {
		Message.setText("You have selected Cycling.");

		Cyclecount++;
		//GenerateGameID("C0");
		Event = "Cycling";

	}

	// list to handle user selections on gui - empty to start with
	static ObservableList<Participant> chosen;

	// button to add and remove selected participants
	// add from table
	public void addAthlete(ActionEvent e) {

		// add selected athletes from table into chosen List
		chosen = table.getSelectionModel().getSelectedItems();

		// get selection to display on the ListView on gui - string and in that
		// format
		for (Participant z : chosen) {
			if (!list.getItems().contains(z.getID() + "-" + z.getName() + "-" + z.getType()))
				list.getItems().add(z.getID() + "-" + z.getName() + "-" + z.getType());			
		}
	}

	// remove from selected list
	public void removeAthlete(ActionEvent e) {
		// list view that holds the list as strings in listviewbox
		ObservableList<String> remove;

		remove = list.getSelectionModel().getSelectedItems();

		for (String q : remove) {
			list.getItems().removeAll(remove);
		}
	}

	// unchecked participants list
	ArrayList<Participant> unchecked = new ArrayList<Participant>();
	ArrayList<Participant> checked = new ArrayList<Participant>();

	// add selected athletes to list unchecked Athletes list
	public void getUserSelectedAthletes() {
		// method to loop through arraylist (participants)
		// use id too retrieve one whole participant object
		// use split to split the id, name, type and add them into array
		// use the id to call the athlete object

		for (int i = 0; i < list.getItems().size(); i++) {

			// printing to console to debug
			System.out.println(list.getItems().get(i));

			String[] output = list.getItems().get(i).split("\\-");

			// printing to console to debug
			System.out.println(output[0]);

			// looping through gb.part database arraylist to find

			for (Participant p : gdb.GetParticipants(null)) {
				// for (Participant p : gb.part){
				if (p.getID().equals(output[0])) {

					// printing to console to debug 
					System.out.println(p.getName() + p.getAge());

					// gets user's selected athletes
					if(!unchecked.contains(p))
						unchecked.add(p);

				}
					
			}

		}
	}

	// EXCEPTION for checking valid number of athletes
	public void checkAthleteNo(int num) throws TooFewAthleteException, GameFullException {
		validNumAthletes = true;
		// twofewAthletes exception
		if (num < 5) {
			try {
				throw new TooFewAthleteException("Not enough athletes");
			} catch (TooFewAthleteException e1) {
				ta.appendText(e1.toString());

				// printing to console to debug
				System.out.println(e1);
				validNumAthletes = false;
				gameReady = false;
			}
		} else if
		// Gamefull exception
		(num > 8) {
			try {
				throw new GameFullException("Too many athletes in this game.");
			} catch (GameFullException e2) {
				// printing to console to debug
				System.out.println(e2);
				validNumAthletes = false;
				ta.setText(e2.toString());
				gameReady = false;

			}
		}
	}

	boolean validNumAthletes = false;

	public void NumAthletes() throws TooFewAthleteException, GameFullException {

		// checks list size - not enough or too many
		checkAthleteNo(list.getItems().size());

	}

	boolean validTypeAthletes;

	public void TypeAthletes() throws WrongTypeException, NoRefereeException {

		// get list into arraylist
		getUserSelectedAthletes();

		// checks athlete types
		checkAthleteType(unchecked);

	}

	boolean gameReady = false;

	// confirm button to debug print console
	public void ConfirmSelection(ActionEvent e)
			throws NoRefereeException, WrongTypeException, TooFewAthleteException, GameFullException {
		confirmSelectionCore();
 	}
	
	private void confirmSelectionCore() throws TooFewAthleteException, GameFullException, WrongTypeException, NoRefereeException
	{
		ta.clear();
		do {
			// checks number of athletes user selected
			NumAthletes();

			// failed number of athletes
			if (!validNumAthletes) {
				ta.appendText("please check number of selections");
				checked.clear();
				unchecked.clear();
				gameReady = false;

			} else {
				// enough and not too many atheltes ==> check types of
				// participants match game selection
				TypeAthletes();
			}

			// failed type of athletes(wrong type for the game)
			if (!validTypeAthletes) {
				// clear lists as users update the lists
				checked.clear();
				unchecked.clear();
				gameReady = false;

			} else {

				// type of athletes match event type
				// add checked type athletes list to checked list
				for (Participant p : unchecked) {
					checked.add(p);
					gameReady = false;
				}
				// check if referee is selected
				refChecked();
				// referee is not selected
				if (refereeExists) {
					gameReady = false;
				}
			}

			// should print only when all exceptions/checks are ok
			// not right
			// ta.setText("YOUR GAME IS READY. Please press START GAME.");

		} while (gameReady);// while gameReady=true
		
		// Remove duplicate
		ArrayList<Participant> uniqueList = new ArrayList<Participant>();
		for(Participant item : checked) {
			if(!uniqueList.contains(item))
				uniqueList.add(item);
		}
		checked.clear();
		checked.addAll(uniqueList);
	}

	public void refChecked() throws NoRefereeException {

		// check ref selection
		checkReferee(refselection);

	}

	static Participant refselection;

	// button to add referee - added to label
	public void addReferee(ActionEvent e) {

		// take from selection from Observablelist
		refselection = table.getSelectionModel().getSelectedItem();

		// check if is official
		if (refselection.getType().equals("Official")) {

			// add to label
			referee.setText(refselection.getName());
		}
	}

	boolean refereeExists;

	// EXCEPTION
	public void checkReferee(Participant refselection) throws NoRefereeException {
		refereeExists = true;
		if (refselection == null) {
			try {
				throw new NoRefereeException(
						"\nYou have not selected a referee for this game.\n Please select one before you proceed");
			} catch (NoRefereeException e3) {
				ta.appendText(e3.toString());

				// printing to console to debug
				System.out.println(e3);
				refereeExists = false;
			}
		}
	}

	// EXCEPTION
	public void checkAthleteType(ArrayList<Participant> unchecked) throws WrongTypeException {
		validTypeAthletes = true;
		if (Event == "Swimming") {

			for (Participant p : unchecked) {

				if (p.getType().equals("sprinter") || p.getType().equals("cyclist")) {
					try {
						throw new WrongTypeException("\nYou've selected the wrong type of athletes for swim game.\n");
					} catch (WrongTypeException e4) {
						ta.setText(e4.toString());
						// printing to console to debug
						System.out.println(e4);

						validTypeAthletes = false;
						gameReady = false;
						unchecked.clear();
						break;
					}
				}
			}
		} else if (Event == "Track") {
			for (Participant p : unchecked) {

				if (p.getType().equals("swimmer") || p.getType().equals("cyclist")) {
					try {
						throw new WrongTypeException("\nYou've selected the wrong type of athletes for track game\n");
					} catch (WrongTypeException e5) {
						ta.setText(e5.toString());
						// printing to console to debug
						System.out.println(e5);

						validTypeAthletes = false;
						gameReady = false;
						unchecked.clear();
						break;
					}
				}
			}
		} else if (Event == "Cycling") {
			for (Participant p : unchecked) {

				if (p.getType().equals("swimmer") || p.getType().equals("sprinter")) {
					try {
						throw new WrongTypeException("\nYou've selected the wrong type of athletes for cycling game\n");
					} catch (WrongTypeException e6) {
						ta.setText(e6.toString());
						// printing to console to debug
						System.out.println(e6);

						validTypeAthletes = false;
						gameReady = false;
						unchecked.clear();
						break;
					}
				}
			}
		}
	}

	// Method to Start Game Event; after Game ID is created and to add in
	// Athletes
	public void startGame(ActionEvent e) {
		// Confirm the selection again to make sure all setting are good.
		try {
			confirmSelectionCore();
		} catch (TooFewAthleteException | GameFullException | WrongTypeException | NoRefereeException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Check if game is ready
		if(validNumAthletes && validTypeAthletes && refereeExists && Event != null && Event.trim() != "")
			gameReady = true;
		else 
			gameReady = false;
		if (gameReady) {

			// add checked athletes to arraylist
			for (Participant p : checked) {

				// Game.chosenAthletes.add((Athlete) p);
				Game.chosenAthletes.add(p);
			}

			// printing to console to debug
			System.out.println(Game.getChosenAthletes().toString());

			// create new game
			newGame();

		} else {
			if(ta.getText().trim() != "")
				ta.appendText("\nSORRY YOUR GAME NOT READY");
			else
				ta.setText("SORRY YOUR GAME NOT READY");
		}
	}

	// Method to Create Game Object
	public void newGame() {

		if (Event.equals("Swimming"))
			GenerateGameID(IGameResult.GAME_ID_PREFIX_SWIMMING);
		else if (Event.equals("Track"))
			GenerateGameID(IGameResult.GAME_ID_PREFIX_TRACK);
		else if (Event.equals("Cycling"))
			GenerateGameID(IGameResult.GAME_ID_PREFIX_CYCLING);
		// create new game, add to games arraylist
		Game n = new Game(GID, Event, refselection, Game.chosenAthletes);
		Game.games.add(n);

		Game.runGame(GID, refselection);

		// display to GUI
		StringBuilder finish = new StringBuilder();
		finish.append("====================  GAME INFO ===================");
		finish.append("\n \n");
		finish.append("GAME ID   " + n.getGameID() + " |  EVENT   " + n.getGameType());
		finish.append("\n \n");
		finish.append(Game.resultsdisplay.toString());
		finish.append("\n \n");
		finish.append("WINNERS + POINTS AWARDS: ");
		finish.append("\n \n");
		finish.append(Official.awardslist.toString());
		String gameend = finish.toString();

		ta.setText(gameend);

		// clear for next game
		Game.resultsdisplay.clear();
		Official.awardslist.clear();
		unchecked.clear();
		checked.clear();

	}

	// Method that generates GameID for the game event
	public String GenerateGameID(String prefix) {
		StringBuilder sb = new StringBuilder();
		
		IGameResult gameResultHandler = new GameResultHandler("gameResults.txt");
		GID = gameResultHandler.getNewGameID(prefix);

		/*if (prefix == "SW0") {
			{
				sb.append(prefix);
				sb.append(Swimcount);
				GID = prefix + Swimcount;

			}
		} else if (prefix == "C0") {
			sb.append(prefix);
			sb.append(Cyclecount);
			GID = prefix + Cyclecount;

		} else if (prefix == "T0") {
			sb.append(prefix);
			sb.append(Trackcount);
			GID = prefix + Trackcount;

		}*/
		return GID;

	}

	// Method to display each game winners
	public void DisplayResults(ActionEvent e) {

		// display to GUI
		StringBuilder allresults = new StringBuilder();
		IGameResult gameResultHandler = new GameResultHandler("gameResults.txt");
		ArrayList<DbGameResultModel> results = gameResultHandler.GetResult();
		allresults.append("\n ========= Game Results: =========== \n");
		for (DbGameResultModel result : results) {
			allresults.append(result.toString() + "\n");
		}

		String all = allresults.toString();
		ta.setText(all);

	}

	// Method to Display Overall Rankings of Athletes.....to be done
	public void DisplayRankings(ActionEvent e) {

		System.out.println("++++++++++ OZLYMPIC GAME RANKINGS +++++++++++++\n");
		ta.setText("++++++++++ OZLYMPIC GAME RANKINGS +++++++++++++\n");
		Official.awardRank();
		
		// display to GUI
		StringBuilder allresults = new StringBuilder();
		
		// Get all participants records except Official.
		IParticipant participantHandler = new ParticipantHandler("participants.txt");
		ArrayList<Participant> allParticipants = participantHandler.GetParticipants(IParticipant.CYCLIST);
		allParticipants.addAll(participantHandler.GetParticipants(IParticipant.SPRINTER));
		allParticipants.addAll(participantHandler.GetParticipants(IParticipant.SUPER));
		allParticipants.addAll(participantHandler.GetParticipants(IParticipant.SWIMMER));
		
		// Get all game result
		IGameResult gameResultHandler = new GameResultHandler("gameResults.txt");
		ArrayList<DbGameResultModel> results = gameResultHandler.GetResult();
		// ArrayList to show all athelete rank.
		ArrayList<Athlete> ranks = new ArrayList<Athlete>();
		
		for(Participant p : allParticipants)
		{
			Athlete athlete = new Athlete(p.getID(), p.getType(), p.getName(), p.getAge(), p.getState(), 0);
			if(!ranks.contains(athlete))
				ranks.add(athlete);
			for(DbGameResultModel result : results)
			{
				if(p.getID().equals(result.getAthleteId())) {
					if(ranks.contains(athlete)) {
						ranks.get(ranks.indexOf(athlete)).addScore(result.getScore());
					}
				}
			}
		}
		
		ArrayList<Athlete> sortedRanks = new ArrayList<Athlete>(ranks);
		Collections.sort(sortedRanks, new Comparator<Athlete>() {
	        public int compare(Athlete p1, Athlete p2) {
	        	if (p1.getScore() < p2.getScore())
	        		return 1;
	        	else if (p1.getScore() == p2.getScore())
	        		return 0;
	        	else 
	        		return -1;
	        }
		});
		
		for(Athlete rank : sortedRanks) {
			allresults.append(rank.toString() + "\n");
		}
			        
		ta.appendText(allresults.toString());
		//ta.setText(Official.displayranking);
	}

	// updated code - exit in TOP MENU
	// Method when User leaves game, prints a good-bye message.
	public void Exit() {
		Message.setText("Thank you for playing.");
		Platform.exit();
		System.exit(0);
	}
}
