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
	public long random;
	doube adasd = 0.0;
	public boolean started = false;
    boolean cheat;

	
	@Override
	public void start(Stage stage) throws Exception {
		VBox main = new VBox(20);
		Scene scene = new Scene(main,500,500);
		stage.setScene(scene);
		stage.show();
		scene.setFill(Color.RED); 
		
		
		/* the javafx scene doesnt run as long as you have this section of code below idfk why 
		 * and i have on fucking clue if this code would even work mathew go crazy tryna fix it if you want
		 */
		while(!started) {     
        long start = System.currentTimeMillis(); 
        long end = System.currentTimeMillis();// Start timer
        long randomTime = Math.round(Math.random() * 5000) + 1000;                     // Set random time
        try {
            Thread.sleep(random); 
	        boolean notFirst = true;
	        if (started) {              
	            started = false;                                                    //end clock method
					Object reactionTime = "Your Reaction Speed Is " + (end - (start + randomTime)) + " Milliseconds. Click to start again";
	            }	
        }
        catch(InterruptedException e) {} 
		}
		}
		
		
		
	

	public static void main(String[] args) {
		launch(args);

	}

}

