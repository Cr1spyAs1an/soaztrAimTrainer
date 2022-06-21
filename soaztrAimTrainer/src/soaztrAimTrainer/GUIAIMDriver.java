package soaztrAimTrainer;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
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
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import javafx.scene.shape.Rectangle;

public class GUIAIMDriver extends Application {

	final int WIDTH = 400;
	final int HEIGHT = 400;
	private static final int MAX_X = 1000;
	private static final int MAX_Y = 600;
	int clickCount = 0;
	int reactionClickCount = 0;
	long startTimeGrid = 0;
	long endTimeGrid = 0;
	long startTimeReact = 0;
	long endTimeReact = 0;
	int secondsPassed = 0;
	boolean stopTimer = false;
	public Random randomPOS;
	createPlayer newPlayer = new createPlayer("Guest", 0, "NA");
	boolean hitTarget = false;

	@Override
	public void start(Stage stage) throws Exception {

		// establishing fonts
		Font font = new Font("Consolas", 35);
		Font buttonFont = new Font("Consolas", 24);
		Font reactFont = new Font("Consolas", 20);
		stage.setTitle("Create Profile");

		TextField name = new TextField();
		name.setMaxWidth(150);

		// Creating vbox
		VBox start = new VBox(20);
		VBox vbox = new VBox(20);
		VBox difficulty = new VBox(20);
		VBox endScreen = new VBox(20);

		// Center the vbox's
		start.setAlignment(Pos.CENTER);
		vbox.setAlignment(Pos.CENTER);
		difficulty.setAlignment(Pos.CENTER);
		endScreen.setAlignment(Pos.CENTER);

		// Creates the scenes (or windows)
		Scene scene = new Scene(start, HEIGHT, WIDTH);
		Scene mainMenu = new Scene(vbox, 800, 800);
		Scene difficultyGrid = new Scene(difficulty, HEIGHT, WIDTH);
		Scene gameOver = new Scene(endScreen, 400, 400);

		// Sets the scene to the create player screen
		stage.setScene(scene);
		Label label = new Label("Enter player name:");
		label.setFont(font);
		Button create = new Button("Create");
		create.setFont(buttonFont);
		create.setPrefSize(150, 50);

		// Creates difficulty screen
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
		Text gtext = new Text("Click on the circle to start the game");
		gtext.setX(400);
		gtext.setY(250);
		gtext.setFill(Color.WHITE);
		Group onScreen = new Group(circle, gtext);
		Scene gridShotScene = new Scene(onScreen, MAX_X, MAX_Y);
		gridShotScene.setFill(Color.BLACK);
		

		
				
		//
		
		Circle trackCircle = new Circle(MAX_X / 2, MAX_Y / 2, 30);
		trackCircle.setFill(Color.GREEN);

		// Setting the position of the circle
		trackCircle.setCenterX(randomPOS.nextInt((int) MAX_X));
		trackCircle.setCenterY(randomPOS.nextInt((int) MAX_Y));
		
		Text trackText = new Text("Click on the circle to start");
		trackText.setFont(Font.font(null, FontWeight.BOLD, 15));
		trackText.setFill(Color.WHITE);
		trackText.setX(350);
		trackText.setY(50);
		Group trackingScrn = new Group(trackCircle, trackText);
		Scene trackScene = new Scene(trackingScrn, MAX_X, MAX_Y);
		trackScene.setFill(Color.LIGHTSKYBLUE);
		stage.setTitle("Tracking");
		
		
		Polyline polyline = new Polyline();
		polyline.getPoints().addAll(new Double[] {
			trackCircle.getCenterX(), trackCircle.getCenterY(),
			(double) randomPOS.nextInt((int) MAX_X), (double)randomPOS.nextInt((int) MAX_Y),
			(double) randomPOS.nextInt((int) MAX_X), (double)randomPOS.nextInt((int) MAX_Y),
			(double) randomPOS.nextInt((int) MAX_X), (double)randomPOS.nextInt((int) MAX_Y),
			(double) randomPOS.nextInt((int) MAX_X), (double)randomPOS.nextInt((int) MAX_Y),
			(double) randomPOS.nextInt((int) MAX_X), (double)randomPOS.nextInt((int) MAX_Y),
			(double) randomPOS.nextInt((int) MAX_X), (double)randomPOS.nextInt((int) MAX_Y),
			(double) randomPOS.nextInt((int) MAX_X), (double)randomPOS.nextInt((int) MAX_Y),
			(double) randomPOS.nextInt((int) MAX_X), (double)randomPOS.nextInt((int) MAX_Y),
			(double) randomPOS.nextInt((int) MAX_X), (double)randomPOS.nextInt((int) MAX_Y)
			});
		
		
		PathTransition transition = new PathTransition();
		transition.setNode(trackCircle);
		transition.setDuration(Duration.seconds(20.0));
		transition.setPath(polyline);
		transition.setCycleCount(Timeline.INDEFINITE);
		transition.setAutoReverse(true);
		boolean moving = false;
		
		

	
	


		
		// Timer stuff
		Random randomNum = new Random();
		int randomSec = 1 + randomNum.nextInt(5);

		// creating reaction timer scene
		Text reactTitle = new Text(
				"After clicking start the background colour will change, try to click it as fast as you can");
		reactTitle.setX(50);
		reactTitle.setY(50);
		reactTitle.setFont(reactFont);
		Button startReact = new Button("Start");
		startReact.setMinSize(150, 50);
		startReact.setLayoutX(475);
		startReact.setLayoutY(350);
		Rectangle rec = new Rectangle(0, 0, 1100, 800);
		Group reactGroup = new Group(reactTitle, startReact, rec);
		Scene reactionScene = new Scene(reactGroup, 1100, 800);
		rec.setVisible(false);
		rec.setFill(Color.GREEN);

		// Create game over screen
		Label gameOverLbl = new Label("Clicked early!");
		gameOverLbl.setFont(font);
		Button reactTryAgain = new Button("Quit");
		reactTryAgain.setFont(buttonFont);
		reactTryAgain.setPrefSize(200, 50);

		// Detects background event click
		EventHandler<MouseEvent> reactionBackground = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				if (reactionClickCount > 1) {
					if (!startReact.isVisible()) {
						stage.setScene(gameOver);
					}
				}

			}
		};

		reactionScene.addEventFilter(MouseEvent.MOUSE_CLICKED, reactionBackground);

		// Starts timer
		startReact.setOnAction(e -> {
			reactionClickCount++;
			Timer timer = new Timer();
			TimerTask task = new TimerTask() {
				public void run() {
					if (!stopTimer) {
						if (randomSec == secondsPassed) {
							stopTimer = true;
							reactionClickCount = 0;
							rec.setVisible(true);
							startTimeReact = System.currentTimeMillis();
							
							
						}
						if (secondsPassed == 1) {
							reactionClickCount = reactionClickCount + 1;
						}
						secondsPassed++;
						System.out.println(secondsPassed);
					}
				}
			};
			timer.scheduleAtFixedRate(task, 1000, 1000);
			System.out.println(randomSec);
			startReact.setVisible(false);

		});

		// Creation of buttons (main menu)
		Label title = new Label("Welcome " + newPlayer.getName() + "!");
		title.setTextFill(Color.BLUEVIOLET);
		Button gridshot = new Button("GRIDSHOT");
		title.setFont(font);
		gridshot.setMinSize(400, 50);
		gridshot.setFont(buttonFont);
		Button tracking = new Button("TRACKING");
		tracking.setMinSize(400, 50);
		tracking.setFont(buttonFont);
		Button reactionTime = new Button("REACTION TIME");
		reactionTime.setMinSize(400, 50);
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
				gtext.setText("Your current score is " + clickCount);

				startTimeGrid = System.currentTimeMillis();
				if (clickCount == 1)
					endTimeGrid = System.currentTimeMillis();
				long totalTime = startTimeGrid - endTimeGrid;

				// At 50 score, the program will print how long it took you to click 50 circles
				if (clickCount == 5) {
					stage.setScene(gameOver);
					long totalSec = TimeUnit.MILLISECONDS.toSeconds(totalTime);
					newPlayer.setTime(totalSec);
					gameOverLbl.setText("Time: " + newPlayer.getTime() + " Seconds");
					try {
						FileWriter myWriter = new FileWriter("gridshotHS.txt", true);
						myWriter.write("\n Username: " + newPlayer.getName() + " | " + "Time: " + newPlayer.getTime()
								+ " Seconds" + " | Difficulty: " + newPlayer.getDiff());
						System.out.println(newPlayer);
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
				
				circle.setCenterX(randomPOS.nextInt((int) MAX_X - 30) + 30);
				circle.setCenterY(randomPOS.nextInt((int) MAX_Y - 30) + 30);

				if (clickCount < 0) {
					gtext.setText("Your current score is 0");
				} else {
					gtext.setText("Your current score is " + clickCount);
				}

				gtext.setX(10);
				gtext.setY(30);
				gtext.setFont(buttonFont);
				gtext.setFill(Color.WHITE);

			}

		};

		gridShotScene.addEventFilter(MouseEvent.MOUSE_CLICKED, backgroundEventHandler);

		EventHandler<MouseEvent> reactionEventHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				if (stopTimer = true) {
					endTimeReact = System.currentTimeMillis();
					System.out.println(endTimeReact - startTimeReact + "ms");
					gameOverLbl.setText(Long.toString(endTimeReact - startTimeReact) + "MS");
					stage.setScene(gameOver);
				}
			}
		};

		rec.addEventFilter(MouseEvent.MOUSE_CLICKED, reactionEventHandler);
		
		EventHandler<MouseEvent> circleMovement = new EventHandler<MouseEvent>() {
	       	 public void handle(MouseEvent e) {
	       		transition.play();
	       		trackText.setVisible(false);
	       	 }	 };
			
	        trackCircle.addEventFilter(MouseEvent.MOUSE_CLICKED, circleMovement);
	        
		// Adding
		vbox.getChildren().addAll(title, gridshot, tracking, reactionTime);
		start.getChildren().addAll(label, name, create);
		difficulty.getChildren().addAll(diff, easy, medium, hard);
		endScreen.getChildren().addAll(gameOverLbl, reactTryAgain);
		
		// Try again button
		reactTryAgain.setOnAction(e -> {
			stage.close();
		});

		// On button press it creates a new player
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
			stage.setTitle("Select Difficulty");
		});
		
		

		reactionTime.setOnAction(e -> {
			stage.setScene(reactionScene);
			stage.setTitle(newPlayer.getName() + " | " + "Reaction Time");
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
		
		tracking.setOnAction (e -> {
			stage.setScene(trackScene);
			
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
