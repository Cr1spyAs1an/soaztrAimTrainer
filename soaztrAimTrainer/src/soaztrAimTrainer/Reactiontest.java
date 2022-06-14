package soaztrAimTrainer;

import java.util.Random;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage; 

public class Reactiontest extends Application {
	int thing = 13;
	public Random random;
	
	@Override
	public void start(Stage stage) throws Exception {
		VBox main = new VBox(20);
		Scene scene = new Scene(main,500,500);
		stage.setScene(scene);
		stage.show();
		scene.setFill(Color.GREEN); 

	}

	public static void main(String[] args) {
		launch(args);

	}

}
