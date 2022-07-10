import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.Format;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class BottomPanel extends JPanel{
	
	private JButton button = new JButton("Enter");
	private JTextField textField = new JTextField();
	private JLabel timerLabel = new JLabel("00:00");
	private CenterPanel centerPanel;
	private WordPanel wordPanel;
	public String word;
	private Player player;
	private int second = 0;
	private int minute = 0;
	public String sSecond = String.format("%02d", second);
	public String sMinute= String.format("%02d", minute);
	private int elepsedTime = 0;
	
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
	
	
	public BottomPanel(Player player)
	{
		timer.start();
		this.add(timerLabel);
		timerLabel.setBorder(new EmptyBorder(0,0,0,40));
		this.player = player;
		this.setLayout(new FlowLayout());

		
		
		textField.setPreferredSize(new Dimension(150,25));
		
		
		button.setPreferredSize(new Dimension(150,25));
		button.setBackground(Color.ORANGE);
		buttonFunc();
		
		
		word = getRandomWord();
		System.out.println("Todays Word : " + word);
		
		textField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
	             if(!(Character.isAlphabetic(c) || (c==KeyEvent.VK_ENTER) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE )) {
	            	 JOptionPane.showMessageDialog(null, "Try to enter alphabetic characters");
	            	 textField.setText("");
	             }
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					String UserInput = textField.getText().trim().toUpperCase();
					
					CenterPanel.wordMaching(UserInput, word,BottomPanel.this.player);
					textField.setText("");
				}
				
				
			}
		});		
		this.add(textField);
		this.add(button);
		this.setVisible(true);
		this.setSize(500, 100);
	}
	
	public void buttonFunc()
	{
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String UserInput = textField.getText().trim().toUpperCase();
				
				CenterPanel.wordMaching(UserInput, word,BottomPanel.this.player);
				textField.setText("");
			}	
		});	
	}
	
	

	public String getRandomWord()
	{
		File textsFile = new File("C:\\Users\\bartu\\eclipse-java\\Wordle-App\\src\\Words.txt");
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
