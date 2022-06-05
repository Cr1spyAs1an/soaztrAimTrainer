package soaztrAimTrainer;

public class createPlayer {
	private String name;
	private int score;
	
	createPlayer(String pName, int pScore){
		name = pName;
		score = pScore;
	}
	
	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}
	@Override 
	
	public String toString() {
		return String.format("Name: %s, Score: %s", name, score);
	}
	
	
}
