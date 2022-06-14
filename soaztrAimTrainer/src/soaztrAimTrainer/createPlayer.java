package soaztrAimTrainer;

public class createPlayer {
	private String name;
	private int time;
	
	createPlayer(String pName, int pScore){
		name = pName;
		time = pScore;
	}
	
	public String getName() {
		return name;
	}
	
	public int getScore() {
		return time;
	}
	
	public String setName(String setName) {
		name = setName;
		return setName;
	}
	
	
	@Override 
	
	public String toString() {
		return String.format("Name: %s, Time: %s", name, time);
	}
	
	
}
