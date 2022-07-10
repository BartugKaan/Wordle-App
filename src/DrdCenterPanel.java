import java.awt.Color;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class DrdCenterPanel extends JPanel{
	private static WordPanel[] wordsPanel = new WordPanel[6];
	public static int index = 0;
	private static boolean isTrueCounter;
		
	public DrdCenterPanel() {
		this.setLayout(new GridLayout(6,1));
		isTrueCounter =  false; 
		
		for(int i = 0;i < 6;i++)
		{
			wordsPanel[i] = new WordPanel();
			this.add(wordsPanel[i]);
		}
		
		
		this.setBorder(new  EmptyBorder(30, 70, 30, 70));
		
		this.setVisible(true);
		this.setSize(350, 350);
	}

	public static WordPanel getPanel()
	{
		return wordsPanel[index];
	}
	
	public static void setCharToLabel(String data,int index)
	{
		getPanel().setPanelTextDrD(data, index);
	}
	
	
	public static void  wordMaching(String input,String word, Player player)
	{
		List<String> wordArray = Arrays.asList(word.split(""));
		String[] inputArray = input.split("");
		
		if(inputArray.length != 5)
		{
			JOptionPane.showMessageDialog(null, "try 5 letter");
		}
		else
		{
			for(int i = 0;i < 5; i++)
			{
				if(wordArray.contains(inputArray[i]))
				{
					if(wordArray.get(i).equals(inputArray[i]))
					{
						getPanel().setPanelText(inputArray[i], i, Color.green);
					}
					else
					{
						getPanel().setPanelText(inputArray[i], i, Color.yellow);
						player.calculateHighScore(1);
					}
				}
				else
				{
					getPanel().setPanelText(inputArray[i], i, Color.gray);
					player.calculateHighScore(2);
				}	
				
				if(getPanel().trueCounter == 5)
				{
					isTrueCounter = true;		
				}
				else
				{
					isTrueCounter = false;
				}
				
				
			}
			index++;
			
			
			if (index >= 6 && isTrueCounter == false) {
				player.setFinished(true);
				player.saveHighScore();
				LoseFrame loseFrame = new LoseFrame();
				JOptionPane.showMessageDialog(null, "you lose, your score is : " + player.playerHighScore + "/300"
						+ "\n" + "Finished Time " + player.finishedTime);
				System.exit(0);
			}
			if (isTrueCounter) {
				player.setFinished(true);
				player.saveHighScore();
				WinFrame winFrame = new WinFrame();
				JOptionPane.showMessageDialog(null, "you won, your score is : " + player.playerHighScore + "/300" + "\n"
						+ "Finished Time " + player.finishedTime);
				System.exit(0);
				
				
			}

		}
			}	
}
