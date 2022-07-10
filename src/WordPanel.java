
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;
public class WordPanel extends JPanel {

	JLabel[] wordsLabel = new JLabel[5];
	Border wordBorder = BorderFactory.createLineBorder(Color.lightGray);
	public int trueCounter = 0;
	
	
	
	public WordPanel()
	{
		this.setLayout(new GridLayout(1,5));
		for(int i = 0;i<5;i++)
		{
			wordsLabel[i] = new JLabel("",JLabel.CENTER);
			wordsLabel[i].setOpaque(true);
			wordsLabel[i].setBorder(wordBorder);
			this.add(wordsLabel[i]);
		}
		
		
		
		this.setVisible(true);
	}
	
	
	public void setPanelText(String word,int index,Color color) {
		if(color == Color.green)
		{
			this.trueCounter++;
		}
		this.wordsLabel[index].setBackground(color);
		this.wordsLabel[index].setText(word);
	}
	
	public void setPanelTextDrD(String word,int index)
	{
		this.wordsLabel[index].setText(word);
	}
	

}
