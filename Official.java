import java.util.*;

/**
 * The is the Official class of Ozlympic Game Program
 * which handles the results and scoring system of the Games.
 *
 * @author  Rita Tse
 * @version 1.0
 * @since   2017-04-07
 */

public class Official extends Participant {

	//Official constructor
	public Official(String ID, String type, String name, int age, String state) {
		super(ID, type, name, age, state);
	}

	//ArrayList to store the winners of each game; will display the top 3 with the Game ID
	static ArrayList<String> GameResults = new ArrayList<String>();

	//ArrayList to store sorted results of each game;
	static TreeMap<Integer, Athlete> sort = new TreeMap<Integer, Athlete>();
	
	//arraylists for athlete who have competed
	static ArrayList<Athlete> competed = new ArrayList<Athlete>();

	//Winners of each game, handled as ID and Names to be used to check predictions and storing final game results
	public static String winningAthlete;
	public static String SecondAth;
	public static String ThirdAth;
	public static String Results1;
	public static String Results2;
	public static String Results3;
	
	static String displayranking;

	
	//Official's method to summarize the game results using a treemap.
	public static void sumGame(HashMap results){

		sort.clear();
		sort.putAll(results);
		results.clear();

	}

	static ArrayList <String> awardslist = new ArrayList();
	
	//Award the Top 3 Athletes their points and record their names in the Game Results list
	public static void awardWinners(String gameID, Participant official, HashMap<String, Double> gameTime) {
		
		System.out.println("*************** W I N N E R S ****************");  
		Collection<Athlete> winners = sort.values();
		Iterator<Athlete> it = winners.iterator();

		//1st Place
		Athlete Gold = it.next();
		
		awardslist.add("1st PLACE  : " + Gold.getName() + "has scored 5pts");
		System.out.println("1st PLACE  : " + Gold.getName());
		System.out.println(Gold.getName() + " has scored 5pts.");
		System.out.println("\n");
		
		Gold.addScore(5);
		winningAthlete=Gold.getID();
		Results1=Gold.getName();


		//2nd Place
		Athlete Silver = it.next();
		
		awardslist.add("2nd PLACE  : " + Silver.getName() + " has scored 2pts.");
		System.out.println("2nd PLACE  : " + Silver.getName());
		System.out.println(Silver.getName() + " has scored 2pts.");
		System.out.println("\n");
		
		Silver.addScore(2);
		SecondAth=Silver.getID();
		Results2=Silver.getName();
	

		//3rd Place
		Athlete Bronze = it.next();
		
		awardslist.add("3rd PLACE  : " + Bronze.getName() + " has scored 1pts.");
		System.out.println("3rd PLACE  : " + Bronze.getName());
		System.out.println(Bronze.getName() + " has scored 1pts.");
		System.out.println("\n");
		
		Bronze.addScore(1);
		ThirdAth = Bronze.getID();
		Results3=Bronze.getName();
	
		//add this game results to GameResults arraylist
		GameResults.add("OFFICIAL: " + Driver.refselection.getName() + " |  1: " + Results1 + " |  2: " + Results2 + " |  3: " + Results3);
		
		IGameResult gameResultHandler = new GameResultHandler("participants.txt");
		gameResultHandler.AddResult(gameID, official.getID(), Gold.getID(), Double.parseDouble(gameTime.get(Gold.getID()).toString()), 5, new Date());
		gameResultHandler.AddResult(gameID, official.getID(), Silver.getID(), Double.parseDouble(gameTime.get(Silver.getID()).toString()), 2, new Date());
		gameResultHandler.AddResult(gameID, official.getID(), Bronze.getID(), Double.parseDouble(gameTime.get(Bronze.getID()).toString()), 1, new Date());
		
		while(it.hasNext())
		{
			Athlete other = it.next();
			gameResultHandler.AddResult(gameID, official.getID(), other.getID(), Double.parseDouble(gameTime.get(other.getID()).toString()), 0, new Date());
		}
		
		//after game results is recorded, list is cleared for the next game
		winners.clear();
		
		//clear treemap for next game
		sort.clear();
		
	}
	

	
	
	//Method to generate the ranking of Athletes for Ozlympic
	public static void awardRank(){

		
		ArrayList <Athlete> rank = new ArrayList<Athlete>();

		
		Athlete min;
		
		//adds first competed athletes to rank
		if (rank.isEmpty()){
			
			for (Athlete d : competed) {
			rank.add(d);
			}
			
			//if rank is not empty
		} else {
				
			//loop through competed list
				for (Athlete c : competed) {
					
					//checks if rank contains same athlete	in 2nd competed list
					if (rank.contains(c)) {
						
						//loops through rank
						for (Athlete r : rank) {
							
							//checks if thei ID matches
							if (c.getID().equals(r.getID())) {
								
								//add their score
								c.addScore(r.getScore());
								break;
							}
						}
		
				
			}
				}
		}
			
			
		
		

			StringBuilder allranks = new StringBuilder();

			allranks.append("\n========== OZLYMPIC GAME RANKINGS ============\n");
			
		//prints the athletes rankings in an order, with highest score first
		for (Athlete a:rank) {
			
			allranks.append(a);
			allranks.append("\n");
			System.out.println(a);
			
		}
		
			String ranking = allranks.toString();
			displayranking = ranking;
			
	}



}
