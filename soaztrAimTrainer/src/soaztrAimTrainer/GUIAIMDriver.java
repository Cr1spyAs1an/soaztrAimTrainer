package soaztrAimTrainer;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.control.TextField;  
import java.io.IOException;
import java.io.FileWriter;

public class GUIAIMDriver extends Application {
	final int WIDTH = 400;
	final int HEIGHT = 400;
	
	
	@Override
	public void start(Stage stage) throws Exception {
		//Thyana we can change this font dw lmao
		Font font = new Font("Impact",48);
		Font buttonFont = new Font("Impact",24);
		stage.setTitle("Create Profile");
		

        TextField name = new TextField();
        
        HBox hbox = new HBox(20);
        VBox vbox = new VBox(20);
        
        hbox.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
       //Creates the scenes (or windows)
        Scene scene = new Scene(hbox, HEIGHT, WIDTH);
        Scene scene2 = new Scene(vbox, 800, 800);
        stage.setScene(scene); 
        Label label = new Label("Player name:");
        Button create = new Button("Create"); 
        create.setPrefSize(100, 50);
        
    	//Creation of buttons
        createPlayer newPlayer = new createPlayer("Guest", 0);
    	Label title = new Label("Welcome " + newPlayer.getName() + "!");
    	Button gridshot = new Button("Gridshot");
    	title.setFont(font);
    	gridshot.setMinWidth(400);
    	gridshot.setMinHeight(50);
    	gridshot.setFont(buttonFont);
    	Button tracking = new Button("Tracking");
    	tracking.setMinWidth(400);
    	tracking.setMinHeight(50);
    	tracking.setFont(buttonFont);
    	Button reactionTime = new Button("Reaction Time");
    	reactionTime.setMinWidth(400);
    	reactionTime.setMinHeight(50);
    	reactionTime.setFont(buttonFont);
    	

    	vbox.getChildren().add(title);
    	vbox.getChildren().addAll(gridshot, tracking, reactionTime);
        hbox.getChildren().add(label);
        hbox.getChildren().add(name);
        hbox.getChildren().add(create);
        
        
    	
        //On button press it creates a new player
        create.setOnAction(e -> { 
        	stage.setScene(scene2);
        	String playerName = name.getText();
        	if (playerName == "") {
        		playerName = "Guest";
        	} else {
        		title.setText("Welcome " + playerName + "!");
        	}        	       	       	       	        	        	        	       	
        });  
       
        stage.show();
	
	}
	
	public static void main(String[] args) {
		launch(args);

	}
}
