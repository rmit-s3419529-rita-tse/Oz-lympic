import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The is the txt file of Ozlympic Game Program which can read and write data by
 * txt file not finish yet,just make it work first
 *
 * @author SZUYING CHEN
 * @version 1.1
 * @since 2017-05-05
 */

public class GameFile {

	public static void main(String[] args) throws Exception {
		GameFile gamefile = new GameFile();
		gamefile.loadFile("participants.txt");

		// do {
		// Interface();
		// } while ();

		gamefile.saveToFile("gameResults.txt");

		System.out.println("Good Bye!");
	}

	// read a txt file
	public String loadFile(String filepath) {

		try {
			BufferedReader input = new BufferedReader(new FileReader(filepath));

			String next = input.readLine();

			while (next != null) {
				System.out.println(next);
				next = input.readLine();
			}
			input.close();
			return next;
		} catch (IOException e) {
			System.err.println("File Reading Error!");
			System.exit(0);
		}
		return null;
	}

	// write a txt file
	public void saveToFile(String filepath) {

		PrintWriter writer = null;

		try {
			writer = new PrintWriter("gameResults.txt");

			// writer = new PrintWriter(new FileOutputStream("output.txt",
			// true));
			// appending the file

		} catch (FileNotFoundException e) {
			System.err.println("File cannot be created, or cannot be opened");
			System.exit(0);
		}

		writer.println("The mouse ran down,");
		writer.println("mouse ran up the clock.");

		writer.close();
	}
}