package soaztrAimTrainer;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
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
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Random;

public class GUIAIMDriver extends Application {
	
	final int WIDTH = 400;
	final int HEIGHT = 400;
	private static final int MAX_X = 1000;
	private static final int MAX_Y = 600;
	int clickCount = 0;
	public Random randomPOS;
	createPlayer newPlayer = new createPlayer("Guest", 0);
	
	@Override
	public void start(Stage stage) throws Exception {
		
		//Thyana we can change this font dw lmao
		Font font = new Font("Consolas", 40);
		Font buttonFont = new Font("Consolas", 24);
		stage.setTitle("Create Profile");
		
        TextField name = new TextField();
        name.setMaxWidth(150);
        
        VBox start = new VBox(20);
        VBox vbox = new VBox(20);
        VBox vbox2 = new VBox(20);
        
        start.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
      
        
        //Creates the scenes (or windows)
        Scene scene = new Scene(start, HEIGHT, WIDTH);
        Scene mainMenu = new Scene(vbox, 800, 800);
       
        //Sets the scene to the create player screen
        stage.setScene(scene); 
        Label label = new Label("Player name:");
        label.setFont(font);
        Button create = new Button("Create"); 
        create.setFont(buttonFont);
        create.setPrefSize(150, 50);
        
        
        // 
        randomPOS = new Random();
  	  	Circle circle = new Circle(MAX_X / 2, MAX_Y / 2, 30);
  	  	Text text = new Text("Click on the circle to start the game"); 
  	  	text.setX(400);
  	  	text.setY(250);
  	  	Group onScreen = new Group(circle, text); 
  	  	Scene gridShotScene = new Scene(onScreen, MAX_X, MAX_Y); 
  	  	
  	  
  	  	
  	  	
    	//Creation of buttons (main menu)
    	Label title = new Label("Welcome " + newPlayer.getName() + "!");
    	Button gridshot = new Button("GRIDSHOT");
    	title.setFont(font);
    	gridshot.setMinWidth(400);
    	gridshot.setMinHeight(50);
    	gridshot.setFont(buttonFont);
    	Button tracking = new Button("TRACKING");
    	tracking.setMinWidth(400);
    	tracking.setMinHeight(50);
    	tracking.setFont(buttonFont);
    	Button reactionTime = new Button("REACTION TIME");
    	reactionTime.setMinWidth(400);
    	reactionTime.setMinHeight(50);
    	reactionTime.setFont(buttonFont);
    	
    	
    	EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() { 
            public void handle(MouseEvent e) { 
           	clickCount++;
               circle.setCenterX(randomPOS.nextInt((int) MAX_X));
               circle.setCenterY(randomPOS.nextInt((int) MAX_Y));
               text.setX(10); 
               text.setY(30);
               text.setText("Your current score is " + clickCount);
               text.setFont(buttonFont);

            } 
         };  
         
         circle.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    	
        //Adding 
    	vbox.getChildren().add(title);
    	vbox.getChildren().addAll(gridshot, tracking, reactionTime);
        start.getChildren().add(label);
        start.getChildren().add(name);
        start.getChildren().add(create);
        
        
    	
        //On button press it creates a new player
        create.setOnAction(e -> { 
        	stage.setScene(mainMenu);
        	String playerName = name.getText();
        	if (playerName == "") {
        		playerName = "Guest";
        	} else {
        		title.setText("Welcome " + playerName + "!");
        		newPlayer.setName(playerName);
        	}      
        	stage.setTitle("Select Gamemode");
        });  
       
        gridshot.setOnAction(e -> {
        	stage.setScene(gridShotScene);
        	stage.setTitle(newPlayer.getName() + " | " + "Gridshot");	
        });
        
        
        
        stage.show();
	
	}
	
	public static void main(String[] args) {
		launch(args);

	}
}
