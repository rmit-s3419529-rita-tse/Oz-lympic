import org.hsqldb.server.Server;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The is the Ozlympic Game Program.
 * It has three types of games a User can choose to run.
 * 
 * @author  Rita Tse
 * @version 1.0
 * @since   2017-04-07
 */

public class Ozlympic extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
			Scene scene = new Scene(root,800,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public static void main(String[] args) {   
		launch(args);
	}



}
