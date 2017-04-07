import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * The is the Driver of Ozlympic Game Program
 * which handles the main mechanics of the game.
 *
 * @author  Rita Tse
 * @version 1.0
 * @since   2017-04-07
 */

public class Driver {

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

	//User's Prediction
	private static String prediction;
	static boolean betmade = false;

	//Referee for the Game
	private Official chosenReferee;

	//Start of Game
	public void OzlympicStart(){

		int input=0;
		do
		{
			try
			{
				Menu();
				input=1;
			}

			catch(NumberFormatException e)
			{
				System.out.println("Please enter a valid ID");
				System.out.println();
				Menu();
			}
			catch(InputMismatchException e)
			{
				System.out.println();
				System.out.println("Please enter a valid number from the menu");
				System.out.println();
				Menu();
			}
		}while(input!=0);	

	}


	//Menu Method
	public void Menu(){

		Scanner sc = new Scanner(System.in);
		printMenu();
		int userInput = sc.nextInt();

		switch (userInput) {
		case(1): Game.chosenAthletes.clear();
		SelectGame(); 
		//needs to remove last Game if it did not run????
		break;
		case(2): Game.runGame();
		Menu();
		break;
		case(3): DisplayResults();
		Menu();//results of game - 3 winners for each game
		break;
		case(4): DisplayRankings();//score/ranking for athletes - overall ranking for all athletes
		Menu();
		break;
		case(0): Exit();
		default:
			System.out.println("Please enter the correct value from the menu");
			System.out.println();
		}	
	}

	//Game Selection Menu
	public void SelectGame(){
		boolean correct=false;
		do
		{
			System.out.println("");
			System.out.println(":::::::::::::Choose a Game to Run::::::::::::::");
			System.out.println("Select <7> for Swimming");
			System.out.println("Select <8> for Track");
			System.out.println("Select <9> for Cycling");
			System.out.println("");

			try {

				Scanner sc= new Scanner(System.in);
				selection = sc.nextInt();

				//User selects Swimming Game
				switch (selection){
				case(7): System.out.println("You have selected Swimming.\n");

				Swimcount++;
				GenerateGameID("SW0");

				startGame();
				;
				correct=true;

				break;

				//User selects Track Game 
				case(8): System.out.println("You have selected Track.\n");

				Trackcount++;
				GenerateGameID("T0");

				startGame();

				correct=true;
				break;

				//User selects Cycling Game
				case(9): System.out.println("You have selected Cycling.\n");

				Cyclecount++;
				GenerateGameID("C0");

				startGame();

				correct=true;

				break;

				default:
					System.out.println("Please enter the correct value from the menu");
					System.out.println();
				}
			} catch (NumberFormatException e) {
				System.out.println("Error ---- Please enter a valid option [0, 1, 2, 3, 4, 5]");
			}

		}while(!correct);
	}

	//Method to Start Game Event; after Game ID is created and to add in Athletes
	public void startGame(){

		System.out.println("====================  GAME INFO ===================");
		Game.AddAthletes(selection);
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

		MakeBet();

	}


	//Method to ask User to make a bet on the winner of the game
	public boolean MakeBet(){

		System.out.println("Would you like to predict a winner for this game?");
		System.out.println("Press 4 to make a prediction, or 5 to Continue with game without prediction.");
		Scanner sc= new Scanner(System.in);
		int input = sc.nextInt();

		if (input ==4){

			try{
				System.out.println("Please enter Athletes ID: ");

				String predict = sc.next();
				for (int i =0; i < Game.chosenAthletes.size(); i++) {
					if (predict.equals(Game.chosenAthletes.get(i)));

				}System.out.println("Your prediction is stored");
				System.out.println(predict);
				prediction = predict;
				betmade = true;

			} catch (InputMismatchException a) { //not really catching exception...
				System.out.println("problem");
			}

		} else if (input ==5){
			System.out.println("\n You did not make a bet");
			betmade= false;

		}
		System.out.println("\n To run this game, press 2 on main menu.");
		Menu();
		return betmade;
	}


	//Method to check User's prediction
	public static void checkPrediction(boolean betmade){

		if (betmade=true){

			if (prediction == Official.winningAthlete) {
				System.out.println("Congratulation, your athlete has won First Place in this game!!");
			} else if (prediction == Official.SecondAth) {
				System.out.println("Congratulation, your athlete has won Second Place in this game!!");
			} else if (prediction == Official.ThirdAth) {
				System.out.println("Congratulation, your athlete has won Third Place in this game!!");
			} else {

			} }


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



	//Method to Print Main Menu
	public void printMenu(){
		System.out.println("");
		System.out.println(">>>>>>>>>>>>>>>>>>>>> O Z  L Y M P I C <<<<<<<<<<<<<<<<<<< \n");
		System.out.println("---------------------GAME MAIN MENU ----------------------");
		System.out.println("<1> Select a Game");
		System.out.println("<2> Run Selected Game");
		System.out.println("<3> Display Game Results");
		System.out.println("<4> Display Athletes Rankings");
		System.out.println("<0> Exit Game");
		System.out.println("");
	}	


	//Method when User leaves game, prints a good-bye message.
	public void Exit(){
		System.out.println("Thank you for playing.");
		System.exit(0);
	}


}
