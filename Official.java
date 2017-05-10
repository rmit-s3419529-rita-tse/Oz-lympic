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

	
	public Official(String ID, String name, int age, String state) {
		super(ID, name, age, state);
	}

	//ArrayList to store the winners of each game; will display the top 3 with the Game ID
	static ArrayList<String> GameResults = new ArrayList<String>();

	//ArrayList to store sorted results of each game;
	static TreeMap<Integer, Athlete> sort = new TreeMap<Integer, Athlete>();

	//Winners of each game, handled as ID and Names to be used to check predictions and storing final game results
	public static String winningAthlete;
	public static String SecondAth;
	public static String ThirdAth;
	public static String Results1;
	public static String Results2;
	public static String Results3;

	//UPDATED CODE
	//Official's method to summarize the game results using a treemap.
	public static void sumGame(HashMap results){

		sort.clear();
		sort.putAll(results);
		results.clear();


	}

	
	//Award the Top 3 Athletes their points and record their names in the Game Results list
	public static void awardWinners() {
		
		System.out.println("*************** W I N N E R S ****************");  
		Collection<Athlete> winners = sort.values();
		Iterator<Athlete> it = winners.iterator();

		//1st Place
		Athlete Gold = it.next();
		System.out.println("1st PLACE  : " + Gold.getName());
		System.out.println(Gold.getName() + " has scored 5pts.");
		System.out.println("\n");
		Gold.addScore(5);
		winningAthlete=Gold.getID();
		Results1=Gold.getName();

		//2nd Place
		Athlete Silver = it.next();
		System.out.println("2nd PLACE  : " + Silver.getName());
		System.out.println(Silver.getName() + " has scored 3pts.");
		System.out.println("\n");
		Silver.addScore(3);
		SecondAth=Silver.getID();
		Results2=Silver.getName();

		//3rd Place
		Athlete Bronze = it.next();
		System.out.println("3rd PLACE  : " + Bronze.getName());
		System.out.println(Bronze.getName() + " has scored 1pts.");
		System.out.println("\n");
		Bronze.addScore(1);
		ThirdAth = Bronze.getID();
		Results3=Bronze.getName();
		
		//add this game results to GameResults arraylist
		GameResults.add("1: " + Results1 + " |  2: " + Results2 + " |  3: " + Results3);
		
		//after game results is recorded, list is cleared for the next game
		winners.clear();
		
		
		//clear treemap for next game
		sort.clear();
		
	}
	
	
	//Inner class to compare the Athletes score to produce overall ranking
	static class RankComp implements Comparator<Athlete>{
		@Override
		public int compare(Athlete a1, Athlete a2) {
			if (a1.getScore() < a2.getScore())  {
				return 1;
			} else {
				return -1;
			}
		}
	}

	
	//UPDATED CODE
	//Method to generate the ranking of Athletes for Ozlympic
	public static void awardRank(){

		//The ranking is held is a TreeSet, loaded with Athletes Objects
		TreeSet <Athlete> rankings = new TreeSet<Athlete>(new RankComp());
		
		//adding all the athletes types to the rankings board
		rankings.addAll(GameDB.sprinters);
		rankings.addAll(GameDB.cyclists);
		rankings.addAll(GameDB.superAthletes);
		rankings.addAll(GameDB.swimmers);

		//prints the athletes rankings in an order, with highest score first
		for (Athlete a:rankings) {
			System.out.println(a);
		}

	}


}
