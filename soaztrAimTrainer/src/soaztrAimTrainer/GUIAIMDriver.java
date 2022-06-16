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
import java.util.concurrent.TimeUnit;

public class GUIAIMDriver extends Application {
	
	final int WIDTH = 400;
	final int HEIGHT = 400;
	private static final int MAX_X = 1000;
	private static final int MAX_Y = 600;
	int clickCount = 0;
	long startTime = 0;
	long endTime = 0;
		
	public Random randomPOS;
	createPlayer newPlayer = new createPlayer("Guest", 0, "NA");
	boolean hitTarget = false;
	
	@Override
	public void start(Stage stage) throws Exception {
		
		// establishing fonts 
		Font font = new Font("Consolas", 35);
		Font buttonFont = new Font("Consolas", 24);
		stage.setTitle("Create Profile");
		
        TextField name = new TextField();
        name.setMaxWidth(150);
       
        //Creating vbox
        VBox start = new VBox(20);
        VBox vbox = new VBox(20);
        VBox difficulty = new VBox(20);
        
        //Center the vbox's
        start.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        difficulty.setAlignment(Pos.CENTER);
        
        //Creates the scenes (or windows)
        Scene scene = new Scene(start, HEIGHT, WIDTH);
        Scene mainMenu = new Scene(vbox, 800, 800);
        Scene difficultyGrid = new Scene(difficulty, HEIGHT, WIDTH);
       
        //Sets the scene to the create player screen
        stage.setScene(scene); 
        Label label = new Label("Enter player name:");
        label.setFont(font);
        Button create = new Button("Create"); 
        create.setFont(buttonFont);
        create.setPrefSize(150, 50);
      
        //Creates difficulty screen
        Label diff = new Label("Select a difficulty");
        diff.setFont(font);
        Button easy = new Button("Easy"); 
        Button medium = new Button("Medium"); 
        Button hard = new Button("Hard"); 
        easy.setFont(buttonFont);
        easy.setPrefSize(150, 50);
        medium.setFont(buttonFont);
        medium.setPrefSize(150, 50);
        hard.setFont(buttonFont);
        hard.setPrefSize(150, 50);
        
        // creating the gridshot scene 
        randomPOS = new Random();
  	  	Circle circle = new Circle(MAX_X / 2, MAX_Y / 2, 30);
  	  	circle.setFill(Color.PURPLE);
  	  	Text text = new Text("Click on the circle to start the game"); 
  	  	text.setX(400);
  	  	text.setY(250);
  	  	text.setFill(Color.WHITE);
  	  	Group onScreen = new Group(circle, text); 
  	  	Scene gridShotScene = new Scene(onScreen, MAX_X, MAX_Y); 
  	  	gridShotScene.setFill(Color.BLACK);
  	  	
    	//Creation of buttons (main menu)
    	Label title = new Label("Welcome " + newPlayer.getName() + "!");
    	title.setTextFill(Color.BLUEVIOLET);
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
    	
    	
    	EventHandler<MouseEvent> circleEventHandler = new EventHandler<MouseEvent>() { 
            public void handle(MouseEvent e) { 
            	if (clickCount >= 0) {
            	clickCount = clickCount + 2;
            	}
            	if (clickCount < 0) {
            		clickCount = 0;
            		clickCount++;
            	}
            	text.setText("Your current score is " + clickCount);
            	
            	 startTime = System.currentTimeMillis();
            	if (clickCount == 1)
            	 endTime = System.currentTimeMillis();
            	long totalTime = startTime - endTime;
            	// At 50 score, the program will print how long it took you to click 50 circles
            	if (clickCount == 5) {
            	long totalSec = TimeUnit.MILLISECONDS.toSeconds(totalTime);
            	System.out.println(totalSec);
            	newPlayer.setTime(totalSec);
            	try {
            	FileWriter myWriter = new FileWriter("gridshotHS.txt", true);
            	myWriter.write( "\n Username: " + newPlayer.getName() + " | " + "Time: " + newPlayer.getTime() + " Seconds" + " | Difficulty: " + newPlayer.getDiff());
            	myWriter.close();
            	} catch (IOException d) {
            		System.out.println("error");
            		d.printStackTrace();
            	}
            	
            	}
            	
            } 
         };  
         
         circle.addEventFilter(MouseEvent.MOUSE_CLICKED, circleEventHandler);
         
         EventHandler<MouseEvent> backgroundEventHandler = new EventHandler<MouseEvent>() {
        	 public void handle(MouseEvent e) {
        		
        		clickCount--;
        		
        		
        		circle.setCenterX(randomPOS.nextInt((int) MAX_X));
                circle.setCenterY(randomPOS.nextInt((int) MAX_Y));
                
                if (clickCount < 0) {
        		text.setText("Your current score is 0");
                } else {
                	text.setText("Your current score is " + clickCount);
                }
                
        		text.setX(10); 
                text.setY(30);
                text.setFont(buttonFont);
                text.setFill(Color.WHITE);
     		
        		
        	 }	 
        	
         };
         
         gridShotScene.addEventFilter(MouseEvent.MOUSE_CLICKED, backgroundEventHandler);
        
    	
        //Adding 
    	
    	vbox.getChildren().addAll(title, gridshot, tracking, reactionTime);
        start.getChildren().addAll(label, name, create);
        difficulty.getChildren().addAll(diff, easy, medium, hard);
        
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
        	mainMenu.setFill(Color.BLACK);
        	System.out.println(newPlayer);
        	
        });  
       
        gridshot.setOnAction(e -> {
        	stage.setScene(difficultyGrid);
        });

        easy.setOnAction(e -> {
        	stage.setScene(gridShotScene);
        	stage.setTitle(newPlayer.getName() + " | " + "Gridshot" + " | " + "Easy");	
        	newPlayer.setDiff("Easy");
        });
        
        medium.setOnAction(e -> {
        	stage.setScene(gridShotScene);
        	stage.setTitle(newPlayer.getName() + " | " + "Gridshot" + " | " + "Medium");
        	circle.setRadius(25);
        	newPlayer.setDiff("Medium");
        });
        
        hard.setOnAction(e -> {
        	stage.setScene(gridShotScene);
        	stage.setTitle(newPlayer.getName() + " | " + "Gridshot" + " | " + "Hard");
        	circle.setRadius(10);
        	newPlayer.setDiff("Hard");
        });
        
        
        
        
        stage.show();
	
	}
	
	public static void decreaseSize(Circle circle, int clickCount) {
		if (clickCount % 10 == 0) {
			circle.setRadius(circle.getRadius() - 5);
		}
	}
	
	public static void main(String[] args) {
		launch(args);

	}
}
