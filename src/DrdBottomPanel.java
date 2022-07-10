import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.Border;
public class DrdBottomPanel extends JPanel{
	
	private JLabel timerLabel = new JLabel("00:00");
	public String word;
	private Player player;
	private int second = 0;
	private int minute = 0;
	public String sSecond = String.format("%02d", second);
	public String sMinute = String.format("%02d", minute);
	private int elepsedTime = 0;
	private CenterPanel centerPanel;
	private WordPanel wordPanel;
	private Border border = BorderFactory.createLineBorder(Color.lightGray, 3);
	static int index = 0;
	private char[]  inputs = new char[5];
	private char tempChar = 0;
	private String tempString = "test";

public Timer timer = new Timer(1000,new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			elepsedTime = elepsedTime + 1000;		
			minute = (elepsedTime / 60000) % 60;
			second = (elepsedTime / 1000) % 60;
			sSecond = String.format("%02d", second);
			sMinute = String.format("%02d", minute);
			if(player.isFinished() == true)
			{
				timer.stop();
				second--;
				sSecond = String.format("%02d", second);
				
			}
			timerLabel.setText(sMinute + ":" + sSecond);
			player.finishedTime = sMinute + ":" + sSecond;
		}
	});

	String texts[] = {"Q", "W", "E", "R", "T", "Y", "U", "Ý", "O", "P",
			 			"A", "S", "D", "F", "G", "H", "J", "K", "L",
			 			"ENTER", "Z", "X", "C", "V", "B", "N", "M"};

	JLabel jlButtons[];
	

	

	public DrdBottomPanel(Player player)
	{
		timer.start();
		this.player = player;
		
		word = getRandomWord();
		System.out.println("Todays Word : " + word);
		
		
		this.setLayout(new BorderLayout());
		JPanel keyboardPanel = new JPanel();
		JPanel timePanel = new JPanel();
		timePanel.setLayout(new FlowLayout());
		timePanel.add(timerLabel);
		
		
		keyboardPanel.setLayout(new FlowLayout());
		jlButtons = new JLabel[texts.length];
		JPanel pMain = new JPanel(new GridLayout(3,1));
		JPanel pFirstRow = new JPanel(new GridLayout(1,1));
		JPanel pSecondRow = new JPanel(new GridLayout(1,1));
		JPanel pThirdRow = new JPanel(new GridLayout(1,1));
		
		for(int i = 0; i<texts.length;i++)
		{
			JLabel b= new JLabel(texts[i], SwingConstants.CENTER);
			b.setBorder(border);
	        jlButtons[i] = b;
	        if(i <= 9)
	        {
	        	pFirstRow.add(jlButtons[i]);
	        }
	        else if(i > 9 && i<19)
	        {
	        	pSecondRow.add(jlButtons[i]);
	        }
	        else
	        {
	        	pThirdRow.add(jlButtons[i]);
	        }

		}
		pMain.add(pFirstRow);
		pMain.add(pSecondRow);
		pMain.add(pThirdRow);
		keyboardPanel.add(pMain);
		
		for (int i = 0; i < jlButtons.length; i++) {
			
			jlButtons[i].addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					JLabel label = (JLabel)e.getSource();
					

					if(label.getText() !="ENTER")
					{
						tempChar = label.getText().charAt(0);
						if(index < 5)
						{
							inputs[index] = tempChar;
							String charToString = String.valueOf(tempChar);
							DrdCenterPanel.setCharToLabel(charToString, index);
							index++;
						}
						else if(index == 5)
						{
							tempString = String.valueOf(inputs);
							DrdCenterPanel.wordMaching(tempString, word, player);
							index = 0;
						}		
					}
					else if(label.getText() == "ENTER")
					{
						tempString = String.valueOf(inputs);
						DrdCenterPanel.wordMaching(tempString, word, player);
						index = 0;
					}
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			
		}
		
		this.add(timePanel,BorderLayout.CENTER);
		this.add(keyboardPanel,BorderLayout.PAGE_END);
		this.setVisible(true);
		this.setSize(500, 300);
	}
	
	
	
	
	public String getRandomWord()
	{
		File textsFile = new File("C:\\\\Users\\\\bartu\\\\eclipse-java\\\\Wordle-App\\\\src\\\\Words.txt");
		List<String> dataList = new ArrayList<>();
		try {
			
			Scanner sc = new Scanner(textsFile);
			while(sc.hasNextLine() == true)
			{
				String data = sc.nextLine();
				dataList.add(data);
			}
			sc.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("File cannot Find");
			e.printStackTrace();
			
		}
		Random random = new Random();
		int position = random.nextInt(dataList.size());
		return dataList.get(position).trim().toUpperCase();
	}
}
