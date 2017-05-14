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
	static ArrayList<Official> officials = new ArrayList<Official>();

	//list of swimmers	
	static Swimmer swimmer1 = new Swimmer("1001", "swimmer", "A. Edwin", 30, "VIC",0);
	static Swimmer swimmer2 = new Swimmer("1002", "swimmer", "M. McKendrick", 34, "NSW",0);
	static Swimmer swimmer3 = new Swimmer("1003", "swimmer", "C. Brown", 54, "SA",0);
	static Swimmer swimmer4 = new Swimmer("1004", "swimmer", "Y. Lee", 42, "NSW",0);
	static Swimmer swimmer5 = new Swimmer("1005", "swimmer", "S. Fary", 36, "NT",0);
	static Swimmer swimmer6 = new Swimmer("1006", "swimmer", "M. Phelps", 22, "TAS",0);
	static Swimmer swimmer7 = new Swimmer("1007", "swimmer", "D. Shakes", 43, "QLD",0);
	static Swimmer swimmer8 = new Swimmer("1008", "swimmer", "J. Mahadevan", 18, "WA",0);

	//list of sprinters
	static Sprinter sprinter1 = new Sprinter("2001", "sprinters", "U. Bolt", 20, "VIC",0);
	static Sprinter sprinter2 = new Sprinter("2002", "sprinters", "S. Pearson", 34, "WA",0);
	static Sprinter sprinter3 = new Sprinter("2003", "sprinters", "F. Gump", 33, "QLD",0);
	static Sprinter sprinter4 = new Sprinter("2004", "sprinters", "R. Fenty", 41, "NT",0);
	static Sprinter sprinter5 = new Sprinter("2005", "sprinters", "S. Germanotta", 38, "TAS",0);
	static Sprinter sprinter6 = new Sprinter("2006", "sprinters", "C. Freeman", 44, "NSW",0);
	static Sprinter sprinter7 = new Sprinter("2007", "sprinters", "J. Ross", 52, "NT",0);
	static Sprinter sprinter8 = new Sprinter("2008", "sprinters", "P. Johnson", 23, "SA",0);

	//list of cyclists
	static Cyclist cyclist1 = new Cyclist("3001", "cyclist", "C. Evans", 24, "VIC",0);
	static Cyclist cyclist2 = new Cyclist("3002", "cyclist", "L. Armstrong", 24, "WA",0);
	static Cyclist cyclist3 = new Cyclist("3003", "cyclist", "H. Huntley", 24, "SA",0);
	static Cyclist cyclist4 = new Cyclist("3004", "cyclist", "P. Gilert", 24, "VIC",0);
	static Cyclist cyclist5 = new Cyclist("3005", "cyclist", "A. Chan", 24, "NSW",0);
	static Cyclist cyclist6 = new Cyclist("3006", "cyclist", "R. Tsang", 24, "NT",0);
	static Cyclist cyclist7 = new Cyclist("3007", "cyclist", "E. Kawamura", 24, "QLD",0);
	static Cyclist cyclist8 = new Cyclist("3008", "cyclist", "B. Hayes", 24, "TAS",0);

	//list of super athletes
	static SuperAthlete superA1 = new SuperAthlete("4001", "super", "T. Fernandez", 18, "NT", 0);
	static SuperAthlete superA2 = new SuperAthlete("4002", "super", "C. Bird", 28, "TAS", 0);
	static SuperAthlete superA3 = new SuperAthlete("4003", "super", "F. Jalal", 25, "NSW",0 );
	static SuperAthlete superA4 = new SuperAthlete("4004", "super", "G. Seow", 26, "SA",0);
	static SuperAthlete superA5 = new SuperAthlete("4005", "super", "D. Chinn", 30, "QLD",0);
	static SuperAthlete superA6 = new SuperAthlete("4006", "super", "P. Lai", 43, "VIC",0);
	
	
	//list of officials
	static Official off1 = new Official("REF001", "Official", "Thomas", 50, "VIC");
	static Official off2 = new Official("REF002", "Official", "Frank", 48, "QLD" );
	static Official off3 = new Official("REF003", "Official", "Tamora", 34, "NSW" );
	static Official off4 = new Official("REF004", "Official", "Nicole", 24, "NT");
	


	public static void LoadDB(){
		
		swimmers.addAll(swimmers);
		sprinters.addAll(sprinters);
		cyclists.addAll(cyclists);
		superAthletes.addAll(superAthletes);
		officials.addAll(officials);



	}
}
