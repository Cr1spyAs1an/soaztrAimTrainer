package soaztrAimTrainer;

import java.util.Random;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class testing extends Application {

	private static final int MAX_X = 1000;
	private static final int MAX_Y = 600;

	public Random random;

	@Override
	public void start(Stage stage) throws Exception {

		random = new Random();

		// Drawing a Circle
		Circle circle = new Circle(MAX_X / 2, MAX_Y / 2, 30);

		// Setting the position of the circle
		circle.setCenterX(random.nextInt((int) MAX_X));
		circle.setCenterY(random.nextInt((int) MAX_Y));

		// Setting the text
		Text text = new Text("Click on the circle to start the game");

		// Setting the font of the text
		text.setFont(Font.font(null, FontWeight.BOLD, 15));

		// Setting the color of the text
		text.setFill(Color.CRIMSON);

		// setting the position of the text
		text.setX(350);
		text.setY(50);

		// Creating a Group object
		Group onScreen = new Group(circle, text);

		// Creating a scene object
		Scene scene = new Scene(onScreen, MAX_X, MAX_Y);

		// Setting the fill color to the scene
		scene.setFill(Color.LAVENDER);

		// Setting title to the Stage
		stage.setTitle("Gridshot");

		// Adding scene to the stage
		stage.setScene(scene);

		// Displaying the contents of the stage
		stage.show();
	}

	public static void main(String args[]) {
		launch(args);
	}

}
