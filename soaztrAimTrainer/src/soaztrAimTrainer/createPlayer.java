package soaztrAimTrainer;

/**
 * creates user's player information and its profile 
 * @author Thyana Tran, Mathew So, Furqan Azmat
 *
 */
public class createPlayer {
	
	// player's attributes 
	private String name;
	private long time;
	private String difficulty;

	/**
	 * puts all the attributes into player obkect
	 * @param pName, player's name
	 * @param pScore, player's score
	 * @param pDifficulty, player's difficulty 
	 */
	createPlayer(String pName, int pScore, String pDifficulty){
		name = pName;
		time = pScore;
		difficulty = pDifficulty;
	}
	
	/**
	 * gets/retrieves player's name 
	 * @return name, player's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * gets/retrieves the user's time/score
	 * @return time, duration of how long it takes for user to complete each mode 
	 */
	public long getTime() {
		return time;
	}
	
	/**
	 * assigns the user's name to player profile 
	 * @param setName, user's inputed name
	 * @return setName, player's inputed name 
	 */
	public String setName(String setName) {
		name = setName;
		return setName;
	}
	
	/**
	 * assigns the time to player profile 
	 * @param setTime, user's time 
	 * @return setTime, player's time 
	 */
	public long setTime(long setTime) {
		time = setTime;
		return setTime;
	}
	
	/**
	 * gets/retrieves the difficulty level
	 * @return difficulty, either easy medium or hard 
	 */
	public String getDiff() {
		return difficulty;
	}
	
	/**
	 * assigns it to player profile 
	 * @param setDiff, user's chosen difficulty level 
	 * @return setDiff, player's difficulty level 
	 */
	public String setDiff(String setDiff) {
		difficulty = setDiff;
		return setDiff;
	}
}
