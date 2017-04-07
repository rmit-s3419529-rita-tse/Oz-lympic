import java.util.ArrayList;
/**
 * The is the Databse of Ozlympic Game Program
 * which handles the Athletes and Officials Objects data.
 *
 * @author  Rita Tse
 * @version 1.0
 * @since   2017-04-07
 */


public class GameDB {

	//Athletes and Officials DB
	static ArrayList<Athlete> swimmers = new ArrayList<Athlete>();
	static ArrayList<Athlete> sprinters = new ArrayList<Athlete>();
	static ArrayList<Athlete> cyclists = new ArrayList<Athlete>();
	static ArrayList<Athlete> superAthletes = new ArrayList<Athlete>();

	static Official[] officials=new Official[4]; 

	//list of swimmers	
	static Swimmer swimmer1 = new Swimmer("1001", "A. Edwin", 30, "VIC",0);
	static Swimmer swimmer2 = new Swimmer("1002", "M. McKendrick", 34, "NSW",0);
	static Swimmer swimmer3 = new Swimmer("1003", "C. Brown", 54, "SA",0);
	static Swimmer swimmer4 = new Swimmer("1004", "Y. Lee", 42, "NSW",0);
	static Swimmer swimmer5 = new Swimmer("1005", "S. Fary", 36, "NT",0);
	static Swimmer swimmer6 = new Swimmer("1006", "M. Phelps", 22, "TAS",0);
	static Swimmer swimmer7 = new Swimmer("1007", "D. Shakes", 43, "QLD",0);
	static Swimmer swimmer8 = new Swimmer("1008", "J. Mahadevan", 18, "WA",0);

	//list of sprinters
	static Sprinter sprinter1 = new Sprinter("2001", "U. Bolt", 20, "VIC",0);
	static Sprinter sprinter2 = new Sprinter("2002", "S. Pearson", 34, "WA",0);
	static Sprinter sprinter3 = new Sprinter("2003", "F. Gump", 33, "QLD",0);
	static Sprinter sprinter4 = new Sprinter("2004", "R. Fenty", 41, "NT",0);
	static Sprinter sprinter5 = new Sprinter("2005", "S. Germanotta", 38, "TAS",0);
	static Sprinter sprinter6 = new Sprinter("2006", "C. Freeman", 44, "NSW",0);
	static Sprinter sprinter7 = new Sprinter("2007", "J. Ross", 52, "NT",0);
	static Sprinter sprinter8 = new Sprinter("2008", "P. Johnson", 23, "SA",0);

	//list of cyclists
	static Cyclist cyclist1 = new Cyclist("3001", "C. Evans", 24, "VIC",0);
	static Cyclist cyclist2 = new Cyclist("3002", "L. Armstrong", 24, "WA",0);
	static Cyclist cyclist3 = new Cyclist("3003", "H. Huntley", 24, "SA",0);
	static Cyclist cyclist4 = new Cyclist("3004", "P. Gilert", 24, "VIC",0);
	static Cyclist cyclist5 = new Cyclist("3005", "A. Chan", 24, "NSW",0);
	static Cyclist cyclist6 = new Cyclist("3006", "R. Tsang", 24, "NT",0);
	static Cyclist cyclist7 = new Cyclist("3007", "E. Kawamura", 24, "QLD",0);
	static Cyclist cyclist8 = new Cyclist("3008", "B. Hayes", 24, "TAS",0);

	//list of super athletes
	static SuperAthlete superA1 = new SuperAthlete("4001", "T. Fernandez", 18, "NT", 0);
	static SuperAthlete superA2 = new SuperAthlete("4002", "C. Bird", 28, "TAS", 0);
	static SuperAthlete superA3 = new SuperAthlete("4003", "F. Jalal", 25, "NSW",0 );
	static SuperAthlete superA4 = new SuperAthlete("4004", "G. Seow", 26, "SA",0);
	static SuperAthlete superA5 = new SuperAthlete("4005", "D. Chinn", 30, "QLD",0);
	static SuperAthlete superA6 = new SuperAthlete("4006", "P. Lai", 43, "VIC",0);


	public static void LoadDB(){

		//list of officials
		officials[0] = new Official("REF001", "Thomas", 50, "VIC");
		officials[1] = new Official("REF001", "Frank", 48, "QLD" );
		officials[2] = new Official("REF001", "Tamora", 34, "NSW" );
		officials[3] = new Official("REF001", "Nicole", 24, "NT");


		swimmers.add(swimmer1);
		swimmers.add(swimmer2);
		swimmers.add(swimmer3);
		swimmers.add(swimmer4);
		swimmers.add(swimmer5);
		swimmers.add(swimmer6);
		swimmers.add(swimmer7);
		swimmers.add(swimmer8);

		sprinters.add(sprinter1);
		sprinters.add(sprinter2);
		sprinters.add(sprinter3);
		sprinters.add(sprinter4);
		sprinters.add(sprinter5);
		sprinters.add(sprinter6);
		sprinters.add(sprinter7);
		sprinters.add(sprinter8);

		cyclists.add(cyclist1);
		cyclists.add(cyclist2);
		cyclists.add(cyclist3);
		cyclists.add(cyclist4);
		cyclists.add(cyclist5);
		cyclists.add(cyclist6);
		cyclists.add(cyclist7);
		cyclists.add(cyclist8);

		superAthletes.add(superA1);
		superAthletes.add(superA2);
		superAthletes.add(superA3);
		superAthletes.add(superA4);
		superAthletes.add(superA5);
		superAthletes.add(superA6);



	}
}
