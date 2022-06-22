package soaztrAimTrainer;

public class createPlayer {
	private String name;
	private long time;
	private String difficulty;

	
	createPlayer(String pName, int pScore, String pDifficulty){
		name = pName;
		time = pScore;
		difficulty = pDifficulty;
		
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
	
	public String getDiff() {
		return difficulty;
	}
	
	public String setDiff(String setDiff) {
		difficulty = setDiff;
		return setDiff;
	}
}
