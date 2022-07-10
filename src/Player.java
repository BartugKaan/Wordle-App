import java.io.*;
import java.util.Scanner;

import javax.sound.sampled.Line;
public class Player extends User{
	int playerHighScore = 300;
	boolean isFinished = false;
	public String finishedTime = "00:00";
	
	public Player(int id, String userName) {
		super(id, userName);

		
	}
	

	public void calculateHighScore(int i)
	{	
		if(i == 1)
		{
			playerHighScore = playerHighScore - 5;
		}
		else if(i == 2)
		{
			playerHighScore = playerHighScore - 10;
		}
		
	}
	
	@Override
	public void saveHighScore() {
		if(playerHighScore < 0 )
		{
			playerHighScore = 0;
		}
			String data ="Player Name: " + this.getUserName() + ", Player High Score: " + playerHighScore + " ,Game Finished Time " + finishedTime;
		try {
			FileWriter writer = new FileWriter("C:\\\\Users\\\\bartu\\\\eclipse-java\\\\Wordle-App\\\\src\\\\HighScoreDB.txt",true);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			
			bufferedWriter.write(data);
			bufferedWriter.newLine();
			
			bufferedWriter.close();
			
		}
		catch (IOException e) {
				System.out.println("Error while writing high score");
		}
		
	}
	
	@Override
	public int getHighScore() {
		return super.getHighScore();
	}

	@Override
	public void setHighScore(int highScore) {
		super.setHighScore(highScore);
	}


	public boolean isFinished() {
		return isFinished;
	}


	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}


	public String getFinishedTime() {
		return finishedTime;
	}


	public void setFinishedTime(String finishedTime) {
		this.finishedTime = finishedTime;
	}
}
