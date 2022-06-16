package soaztrAimTrainer;

import java.util.Random;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class tracking extends Application {

	private static final double MAX_X = 1000;
	private static final double MAX_Y = 600;

	public Random random;

	@Override
	public void start(Stage stage) throws Exception {

		random = new Random();

		// Drawing a Circle
		Circle circle = new Circle(MAX_X / 2, MAX_Y / 2, 30);

		// Setting the position of the circle
		circle.setCenterX(random.nextInt((int) MAX_X));
		circle.setCenterY(random.nextInt((int) MAX_Y));
		circle.setFill(Color.GREEN);
		
		Polyline polyline = new Polyline();
		polyline.getPoints().addAll(new Double[] {
			circle.getCenterX(),circle.getCenterY(),
			(double) random.nextInt((int) MAX_X), (double)random.nextInt((int) MAX_Y),
			500.0, 200.0,
			200.0, 500.0,
			300.0, 400.0});
			
		
		
		PathTransition transition = new PathTransition();
		transition.setNode(circle);
		transition.setDuration(Duration.seconds(5.0));
		transition.setPath(polyline);
		transition.setCycleCount(Timeline.INDEFINITE);
		transition.setAutoReverse(true);
		
		
		EventHandler<MouseEvent> circleMovement = new EventHandler<MouseEvent>() {
       	 public void handle(MouseEvent e) {
       		
       		transition.play();
    		
       		
       	 }	 
       	
        };
		
        circle.addEventFilter(MouseEvent.MOUSE_MOVED, circleMovement);
	

		// Setting the text
		Text text = new Text("Click on the circle to start the game");

		// Setting the font of the text
		text.setFont(Font.font(null, FontWeight.BOLD, 15));

		// Setting the color of the text
		text.setFill(Color.WHITE);

		// setting the position of the text
		text.setX(350);
		text.setY(50);

		// Creating a Group object
		Group onScreen = new Group(circle, text);

		// Creating a scene object
		Scene scene = new Scene(onScreen, MAX_X, MAX_Y);

		// Setting the fill color to the scene
		scene.setFill(Color.BLUE);

		// Setting title to the Stage
		stage.setTitle("Tracking");

		// Adding scene to the stage
		stage.setScene(scene);

		// Displaying the contents of the stage
		stage.show();
	}

	public static void main(String args[]) {
		launch(args);
	}

}
