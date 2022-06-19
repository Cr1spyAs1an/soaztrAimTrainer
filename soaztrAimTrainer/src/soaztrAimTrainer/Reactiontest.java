package soaztrAimTrainer;

import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Reactiontest extends Application {
	public Random random;
	long start = 0;
	int click = 0;
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Reaction Time");
	    Text text = new Text("After clicking start the background colour will change, try to click it as fast as you can"); 
	    text.setFont(Font.font(null, FontWeight.BOLD, 15));    
	    text.setFill(Color.BLACK);
	    text.setX(50); 
	    text.setY(50); 
		Group root = new Group(text);
		Scene scene = new Scene(root, 700, 500);
		scene.setFill(Color.RED);
		Button btn = new Button();
		btn.setMinWidth(100);
		btn.setMinHeight(50);
		btn.setLayoutX(300);
		btn.setLayoutY(210);
		btn.setText("START");
		btn.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				try {
					btn.setVisible(false);
					Thread.sleep((long) (Math.random() * 5000));
					long start1 = System.currentTimeMillis();
					start = start1;

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				scene.setFill(Color.GREEN);
			}		
		});
		EventHandler<MouseEvent> backGroundClick = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				long end = System.currentTimeMillis();
				click++;
				if(click == 2) {
				text.setX(250); 
				text.setY(250);
				text.setText("Your reaction time is " + (end - start) + " ms");
				} 
			}
		};
		
		scene.addEventFilter(MouseEvent.MOUSE_CLICKED, backGroundClick);
		
		root.getChildren().add(btn);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
