package soaztrAimTrainer;

public class createPlayer {
	private String name;
	private long time;
	
	createPlayer(String pName, int pScore){
		name = pName;
		time = pScore;
	}
	
	public String getName() {
		return name;
	}
	
	public long getTime() {
		return time;
	}
	
	public String setName(String setName) {
		name = setName;
		return setName;
	}
	
	public long setTime(long setTime) {
		time = setTime;
		return setTime;
	}
	
	
	@Override 
	
	public String toString() {
		return String.format("Name: %s | Time: %s", name, time);
	}
	
	
}
