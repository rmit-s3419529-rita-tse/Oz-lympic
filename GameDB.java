import java.util.ArrayList;

/**
 * The is the Databse of Ozlympic Game Program which handles the Athletes and
 * Officials Objects data.
 *
 * @author Rita Tse
 * @version 2.0
 * @since 2017-04-07
 */

public class GameDB {

	// Athletes and Officials DB
	static ArrayList<Athlete> swimmers = new ArrayList<Athlete>();
	static ArrayList<Athlete> sprinters = new ArrayList<Athlete>();
	static ArrayList<Athlete> cyclists = new ArrayList<Athlete>();
	static ArrayList<Athlete> superAthletes = new ArrayList<Athlete>();
	static ArrayList<Official> officials = new ArrayList<Official>();

	// list of swimmers
	static Swimmer swimmer1 = new Swimmer("Oz1001", "swimmer", "A. Edwin", 30, "VIC", 0);
	static Swimmer swimmer2 = new Swimmer("Oz1002", "swimmer", "M. McKendrick", 34, "NSW", 0);
	static Swimmer swimmer3 = new Swimmer("Oz1003", "swimmer", "C. Brown", 54, "SA", 0);
	static Swimmer swimmer4 = new Swimmer("Oz1004", "swimmer", "Y. Lee", 42, "NSW", 0);
	static Swimmer swimmer5 = new Swimmer("Oz1005", "swimmer", "S. Fary", 36, "NT", 0);
	static Swimmer swimmer6 = new Swimmer("Oz1006", "swimmer", "M. Phelps", 22, "TAS", 0);
	static Swimmer swimmer7 = new Swimmer("Oz1007", "swimmer", "D. Shakes", 43, "QLD", 0);
	static Swimmer swimmer8 = new Swimmer("Oz1008", "swimmer", "J. Mahadevan", 18, "WA", 0);
	static Swimmer swimmer9 = new Swimmer("Oz1009", "swimmer", "M. Jasmine", 23, "WA", 0);
	static Swimmer swimmer10 = new Swimmer("Oz1010", "swimmer", "A. Allison", 40, "QLD", 0);
	static Swimmer swimmer11 = new Swimmer("Oz1011", "swimmer", "J. Savannah", 18, "TAS", 0);
	static Swimmer swimmer12 = new Swimmer("Oz1012", "swimmer", "R. Isabel", 31, "QLD", 0);

	// list of sprinters
	static Sprinter sprinter1 = new Sprinter("Oz2001", "sprinters", "U. Bolt", 20, "VIC", 0);
	static Sprinter sprinter2 = new Sprinter("Oz2002", "sprinters", "S. Pearson", 34, "WA", 0);
	static Sprinter sprinter3 = new Sprinter("Oz2003", "sprinters", "F. Gump", 33, "QLD", 0);
	static Sprinter sprinter4 = new Sprinter("Oz2004", "sprinters", "R. Fenty", 41, "NT", 0);
	static Sprinter sprinter5 = new Sprinter("Oz2005", "sprinters", "S. Germanotta", 38, "TAS", 0);
	static Sprinter sprinter6 = new Sprinter("Oz2006", "sprinters", "C. Freeman", 44, "NSW", 0);
	static Sprinter sprinter7 = new Sprinter("Oz2007", "sprinters", "J. Ross", 52, "NT", 0);
	static Sprinter sprinter8 = new Sprinter("Oz2008", "sprinters", "P. Johnson", 23, "SA", 0);
	static Sprinter sprinter9 = new Sprinter("Oz2009", "sprinters", "B. Anna", 18, "NT", 0);
	static Sprinter sprinter10 = new Sprinter("Oz2010", "sprinters", "C. Zoe", 24, "SA", 0);
	static Sprinter sprinter11 = new Sprinter("Oz2011", "sprinters", "F. Natalie", 42, "NT", 0);
	static Sprinter sprinter12 = new Sprinter("Oz2012", "sprinters", "W. Kylie", 33, "WA", 0);

	// list of cyclists
	static Cyclist cyclist1 = new Cyclist("Oz3001", "cyclist", "C. Evans", 24, "VIC", 0);
	static Cyclist cyclist2 = new Cyclist("Oz3002", "cyclist", "L. Armstrong", 25, "WA", 0);
	static Cyclist cyclist3 = new Cyclist("Oz3003", "cyclist", "H. Huntley", 24, "SA", 0);
	static Cyclist cyclist4 = new Cyclist("Oz3004", "cyclist", "P. Gilert", 27, "VIC", 0);
	static Cyclist cyclist5 = new Cyclist("Oz3005", "cyclist", "A. Chan", 25, "NSW", 0);
	static Cyclist cyclist6 = new Cyclist("Oz3006", "cyclist", "R. Tsang", 34, "NT", 0);
	static Cyclist cyclist7 = new Cyclist("Oz3007", "cyclist", "E. Kawamura", 32, "QLD", 0);
	static Cyclist cyclist8 = new Cyclist("Oz3008", "cyclist", "B. Hayes", 25, "TAS", 0);
	static Cyclist cyclist9 = new Cyclist("Oz3005", "cyclist", "K. Gavin", 27, "SA", 0);
	static Cyclist cyclist10 = new Cyclist("Oz3006", "cyclist", "T. Daniel", 20, "NT", 0);
	static Cyclist cyclist11 = new Cyclist("Oz3007", "cyclist", "E. Kawamura", 34, "VIC", 0);
	static Cyclist cyclist12 = new Cyclist("Oz3008", "cyclist", "I. Luke", 44, "WA", 0);

	// list of super athletes
	static SuperAthlete superA1 = new SuperAthlete("Oz4001", "super", "T. Fernandez", 18, "NT", 0);
	static SuperAthlete superA2 = new SuperAthlete("Oz4002", "super", "C. Bird", 28, "TAS", 0);
	static SuperAthlete superA3 = new SuperAthlete("Oz4003", "super", "F. Jalal", 25, "NSW", 0);
	static SuperAthlete superA4 = new SuperAthlete("Oz4004", "super", "G. Seow", 26, "SA", 0);
	static SuperAthlete superA5 = new SuperAthlete("Oz4005", "super", "D. Chinn", 30, "QLD", 0);
	static SuperAthlete superA6 = new SuperAthlete("Oz4006", "super", "P. Lai", 43, "VIC", 0);
	static SuperAthlete superA7 = new SuperAthlete("Oz4007", "super", "L. Sade", 36, "NSW", 0);
	static SuperAthlete superA8 = new SuperAthlete("Oz4008", "super", "D. Laraine", 29, "QLD", 0);
	static SuperAthlete superA9 = new SuperAthlete("Oz4009", "super", "C. Aletta", 24, "VIC", 0);

	
	//list of officials
	static Official off1 = new Official("REF001", "Official", "Thomas", 50, "VIC");
	static Official off2 = new Official("REF002", "Official", "Frank", 48, "QLD");
	static Official off3 = new Official("REF003", "Official", "Tamora", 34, "NSW");
	static Official off4 = new Official("REF004", "Official", "Nicole", 24, "NT");
	static Official off5 = new Official("REF005", "Official", "Claudia", 20, "SA");
	static Official off6 = new Official("REF006", "Official", "Lilith", 18, "QLD");
	static Official off7 = new Official("REF007", "Official", "Michael", 24, "NSW");
	static Official off8 = new Official("REF008", "Official", "Andrew", 28, "WA");

	public static void LoadDB() {
		// add the list of Athletes and Officials into database
		GameDatabase TestGame = new GameDatabase();
		
		// delete old database
		TestGame.DeleteParticipants();
		TestGame.AddParticipants("Oz1001", "swimmer", "A. Edwin", 30, "VIC");
		TestGame.AddParticipants("Oz1002", "swimmer", "M. McKendrick", 34, "NSW");
		TestGame.AddParticipants("Oz1003", "swimmer", "C. Brown", 54, "SA");
		TestGame.AddParticipants("Oz1004", "swimmer", "Y. Lee", 42, "NSW");
		TestGame.AddParticipants("Oz1005", "swimmer", "S. Fary", 36, "NT");
		TestGame.AddParticipants("Oz1006", "swimmer", "M. Phelps", 22, "TAS");
		TestGame.AddParticipants("Oz1007", "swimmer", "D. Shakes", 43, "QLD");
		TestGame.AddParticipants("Oz1008", "swimmer", "J. Mahadevan", 18, "WA");
		TestGame.AddParticipants("Oz1009", "swimmer", "M. Jasmine", 23, "WA");
		TestGame.AddParticipants("Oz1010", "swimmer", "A. Allison", 40, "QLD");
		TestGame.AddParticipants("Oz1011", "swimmer", "J. Savannah", 18, "TAS");
		TestGame.AddParticipants("Oz1012", "swimmer", "R. Isabel", 31, "QLD");
		TestGame.AddParticipants("Oz2001", "sprinters", "U. Bolt", 20, "VIC");
		TestGame.AddParticipants("Oz2002", "sprinters", "S. Pearson", 34, "WA");
		TestGame.AddParticipants("Oz2003", "sprinters", "F. Gump", 33, "QLD");
		TestGame.AddParticipants("Oz2004", "sprinters", "R. Fenty", 41, "NT");
		TestGame.AddParticipants("Oz2005", "sprinters", "S. Germanotta", 38, "TAS");
		TestGame.AddParticipants("Oz2006", "sprinters", "C. Freeman", 44, "NSW");
		TestGame.AddParticipants("Oz2007", "sprinters", "J. Ross", 52, "NT");
		TestGame.AddParticipants("Oz2008", "sprinters", "P. Johnson", 23, "SA");
		TestGame.AddParticipants("Oz2009", "sprinters", "B. Anna", 18, "NT");
		TestGame.AddParticipants("Oz2010", "sprinters", "C. Zoe", 24, "SA");
		TestGame.AddParticipants("Oz2011", "sprinters", "F. Natalie", 42, "NT");
		TestGame.AddParticipants("Oz2012", "sprinters", "W. Kylie", 33, "WA");
		TestGame.AddParticipants("Oz3001", "cyclist", "C. Evans", 24, "VIC");
		TestGame.AddParticipants("Oz3002", "cyclist", "L. Armstrong", 25, "WA");
		TestGame.AddParticipants("Oz3003", "cyclist", "H. Huntley", 24, "SA");
		TestGame.AddParticipants("Oz3004", "cyclist", "P. Gilert", 27, "VIC");
		TestGame.AddParticipants("Oz3005", "cyclist", "A. Chan", 25, "NSW");
		TestGame.AddParticipants("Oz3006", "cyclist", "R. Tsang", 34, "NT");
		TestGame.AddParticipants("Oz3007", "cyclist", "E. Kawamura", 32, "QLD");
		TestGame.AddParticipants("Oz3008", "cyclist", "B. Hayes", 25, "TAS");
		TestGame.AddParticipants("Oz3005", "cyclist", "K. Gavin", 27, "SA");
		TestGame.AddParticipants("Oz3006", "cyclist", "T. Daniel", 20, "NT");
		TestGame.AddParticipants("Oz3007", "cyclist", "E. Kawamura", 34, "VIC");
		TestGame.AddParticipants("Oz3008", "cyclist", "I. Luke", 44, "WA");
		TestGame.AddParticipants("Oz4001", "super", "T. Fernandez", 18, "NT");
		TestGame.AddParticipants("Oz4002", "super", "C. Bird", 28, "TAS");
		TestGame.AddParticipants("Oz4003", "super", "F. Jalal", 25, "NSW");
		TestGame.AddParticipants("Oz4004", "super", "G. Seow", 26, "SA");
		TestGame.AddParticipants("Oz4005", "super", "D. Chinn", 30, "QLD");
		TestGame.AddParticipants("Oz4006", "super", "P. Lai", 43, "VIC");
		TestGame.AddParticipants("Oz4007", "super", "L. Sade", 36, "NSW");
		TestGame.AddParticipants("Oz4008", "super", "D. Laraine", 29, "QLD");
		TestGame.AddParticipants("Oz4009", "super", "C. Aletta", 24, "VIC");
		TestGame.AddParticipants("REF001", "Official", "Thomas", 50, "VIC");
		TestGame.AddParticipants("REF002", "Official", "Frank", 48, "QLD");
		TestGame.AddParticipants("REF003", "Official", "Tamora", 34, "NSW");
		TestGame.AddParticipants("REF004", "Official", "Nicole", 24, "NT");
		TestGame.AddParticipants("REF005", "Official", "Claudia", 20, "SA");
		TestGame.AddParticipants("REF006", "Official", "Lilith", 18, "QLD");
		TestGame.AddParticipants("REF007", "Official", "Michael", 24, "NSW");
		TestGame.AddParticipants("REF008", "Official", "Andrew", 28, "WA");

		//
		swimmers.addAll(swimmers);
		sprinters.addAll(sprinters);
		cyclists.addAll(cyclists);
		superAthletes.addAll(superAthletes);
		officials.addAll(officials);

	}

}
