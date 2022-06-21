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
		Circle trackCircle = new Circle(MAX_X / 2, MAX_Y / 2, 30);
		trackCircle.setFill(Color.GREEN);

		// Setting the position of the circle
		trackCircle.setCenterX(random.nextInt((int) MAX_X));
		trackCircle.setCenterY(random.nextInt((int) MAX_Y));
		
		//
		Text trackText = new Text("Click on the circle to start the game");
		trackText.setFont(Font.font(null, FontWeight.BOLD, 15));
		trackText.setFill(Color.WHITE);
		trackText.setX(350);
		trackText.setY(50);
		Group trackingScrn = new Group(circle, text);
		Scene scene = new Scene(trackingScrn, MAX_X, MAX_Y);
		scene.setFill(Color.LIGHTSKYBLUE);
		stage.setTitle("Tracking");
		stage.setScene(scene);
		stage.show();
		
		Polyline polyline = new Polyline();
		polyline.getPoints().addAll(new Double[] {
			trackCircle.getCenterX(), trackCircle.getCenterY(),
			(double) random.nextInt((int) MAX_X), (double)random.nextInt((int) MAX_Y),
			(double) random.nextInt((int) MAX_X), (double)random.nextInt((int) MAX_Y),
			(double) random.nextInt((int) MAX_X), (double)random.nextInt((int) MAX_Y),
			(double) random.nextInt((int) MAX_X), (double)random.nextInt((int) MAX_Y),
			(double) random.nextInt((int) MAX_X), (double)random.nextInt((int) MAX_Y),
			(double) random.nextInt((int) MAX_X), (double)random.nextInt((int) MAX_Y),
			(double) random.nextInt((int) MAX_X), (double)random.nextInt((int) MAX_Y),
			(double) random.nextInt((int) MAX_X), (double)random.nextInt((int) MAX_Y),
			(double) random.nextInt((int) MAX_X), (double)random.nextInt((int) MAX_Y)
			});
		
		
		PathTransition transition = new PathTransition();
		transition.setNode(trackCircle);
		transition.setDuration(Duration.seconds(20.0));
		transition.setPath(polyline);
		transition.setCycleCount(Timeline.INDEFINITE);
		transition.setAutoReverse(true);
		boolean moving = false;
		
		
		EventHandler<MouseEvent> circleMovement = new EventHandler<MouseEvent>() {
       	 public void handle(MouseEvent e) {
       		transition.play();
       	 }	
        };
		
        trackCircle.addEventFilter(MouseEvent.MOUSE_CLICKED, circleMovement);
	
	}

	public static void main(String args[]) {
		launch(args);
	}

}
