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
	
	//dummy data to be deleted
	ArrayList <Participant> part = new ArrayList<Participant>();
	
	public GameDB() {
		part.add(new Participant("Oz1001", "swimmer", "A. Edwin", 30, "VIC"));
		part.add(new Participant("Oz1002", "swimmer", "M. McKendrick", 34, "NSW"));
		part.add(new Participant("Oz1003", "swimmer", "C. Brown", 54, "SA"));
		part.add(new Participant("Oz1004", "swimmer", "Y. Lee", 42, "NSW"));
		part.add(new Participant("Oz1005", "swimmer", "S. Fary", 36, "NT"));
		part.add(new Participant("Oz1006", "swimmer", "M. Phelps", 22, "TAS"));
		part.add(new Participant("Oz1007", "swimmer", "D. Shakes", 43, "QLD"));
		part.add(new Participant("Oz1008", "swimmer", "J. Mahadevan", 18, "WA"));
		part.add(new Participant("Oz1009", "swimmer", "M. Jasmine", 23, "WA"));
		part.add(new Participant("Oz1010", "swimmer", "A. Allison", 40, "QLD"));
		part.add(new Participant("Oz1011", "swimmer", "J. Savannah", 18, "TAS"));
		part.add(new Participant("Oz1012", "swimmer", "R. Isabel", 31, "QLD"));
		part.add(new Participant("Oz2001", "sprinter", "U. Bolt", 20, "VIC"));
		part.add(new Participant("Oz2002", "sprinter", "S. Pearson", 34, "WA"));
		part.add(new Participant("Oz2003", "sprinter", "F. Gump", 33, "QLD"));
		part.add(new Participant("Oz2004", "sprinter", "R. Fenty", 41, "NT"));
		part.add(new Participant("Oz2005", "sprinter", "S. Germanotta", 38, "TAS"));
		part.add(new Participant("Oz2006", "sprinter", "C. Freeman", 44, "NSW"));
		part.add(new Participant("Oz2007", "sprinter", "J. Ross", 52, "NT"));
		part.add(new Participant("Oz2008", "sprinter", "P. Johnson", 23, "SA"));
		part.add(new Participant("Oz2009", "sprinter", "B. Anna", 18, "NT"));
		part.add(new Participant("Oz2010", "sprinter", "C. Zoe", 24, "SA"));
		part.add(new Participant("Oz2011", "sprinter", "F. Natalie", 42, "NT"));
		part.add(new Participant("Oz2012", "sprinter", "W. Kylie", 33, "WA"));
		part.add(new Participant("Oz3001", "cyclist", "C. Evans", 24, "VIC"));
		part.add(new Participant("Oz3002", "cyclist", "L. Armstrong", 25, "WA"));
		part.add(new Participant("Oz3003", "cyclist", "H. Huntley", 24, "SA"));
		part.add(new Participant("Oz3004", "cyclist", "P. Gilert", 27, "VIC"));
		part.add(new Participant("Oz3005", "cyclist", "A. Chan", 25, "NSW"));
		part.add(new Participant("Oz3006", "cyclist", "R. Tsang", 34, "NT"));
		part.add(new Participant("Oz3007", "cyclist", "E. Kawamura", 32, "QLD"));
		part.add(new Participant("Oz3008", "cyclist", "B. Hayes", 25, "TAS"));
		part.add(new Participant("Oz3005", "cyclist", "K. Gavin", 27, "SA"));
		part.add(new Participant("Oz3006", "cyclist", "T. Daniel", 20, "NT"));
		part.add(new Participant("Oz3007", "cyclist", "E. Kawamura", 34, "VIC"));
		part.add(new Participant("Oz3008", "cyclist", "I. Luke", 44, "WA"));
		part.add(new Participant("Oz4001", "super", "T. Fernandez", 18, "NT"));
		part.add(new Participant("Oz4002", "super", "C. Bird", 28, "TAS"));
		part.add(new Participant("Oz4003", "super", "F. Jalal", 25, "NSW"));
		part.add(new Participant("Oz4004", "super", "G. Seow", 26, "SA"));
		part.add(new Participant("Oz4005", "super", "D. Chinn", 30, "QLD"));
		part.add(new Participant("Oz4006", "super", "P. Lai", 43, "VIC"));
		part.add(new Participant("Oz4007", "super", "L. Sade", 36, "NSW"));
		part.add(new Participant("Oz4008", "super", "D. Laraine", 29, "QLD"));
		part.add(new Participant("Oz4009", "super", "C. Aletta", 24, "VIC"));
		part.add(new Participant("REF001", "Official", "Thomas", 50, "VIC"));
		part.add(new Participant("REF002", "Official", "Frank", 48, "QLD"));
		part.add(new Participant("REF003", "Official", "Tamora", 34, "NSW"));
		part.add(new Participant("REF004", "Official", "Nicole", 24, "NT"));
		part.add(new Participant("REF005", "Official", "Claudia", 20, "SA"));
		part.add(new Participant("REF006", "Official", "Lilith", 18, "QLD"));
		part.add(new Participant("REF007", "Official", "Michael", 24, "NSW"));
		part.add(new Participant("REF008", "Official", "Andrew", 28, "WA"));
	}
	
	
	
	
	

	public static void LoadDB() {
		// add the list of Athletes and Officials into database
		DbParticipant TestGame = new DbParticipant();
		
		
		
		
		// delete old database
		//TestGame.DeleteParticipants();
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

		/*
		swimmers.addAll(swimmers);
		sprinters.addAll(sprinters);
		cyclists.addAll(cyclists);
		superAthletes.addAll(superAthletes);
		officials.addAll(officials);
*/
	}

}
