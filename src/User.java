import javax.swing.*;
public abstract class User {
	private int id;
  	private String userName;
  	
  	public User(int id, String userName) {
		this.id = id;
		this.userName = userName;
		
	}
  	abstract public void saveHighScore();
  	
  	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	private int highScore;
  	
	public int getHighScore() {
		return highScore;
	}
	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}
}
