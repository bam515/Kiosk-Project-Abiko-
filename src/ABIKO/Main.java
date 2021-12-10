package ABIKO;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	DatabaseHandler databaseHandler;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("orderView.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("main.css").toString());
		
		databaseHandler = DatabaseHandler.getInstance();
        Controller.lateInit();
		
		primaryStage.setTitle("ABIKO");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
