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
	
	public String setName(String setName) {
		name = setName;
		return setName;
	}
	
	public int setScore(int setScore) {
		score = setScore;
		return score;
	}
	@Override 
	
	public String toString() {
		return String.format("Name: %s, Score: %s", name, score);
	}
	
	
}
