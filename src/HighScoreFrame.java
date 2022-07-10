import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;
public class HighScoreFrame extends JFrame{
	private JTextArea jTextArea;
	private JButton jButton; 
	
	public HighScoreFrame() {
		this.setTitle("High Scores");
		
		jTextArea = new JTextArea();
		jTextArea.setEditable(false);
		getScString(jTextArea);
		
		jButton = new JButton("Return");
		jButton.setBackground(Color.ORANGE);
		
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuFrame menuFrame = new MenuFrame();
				dispose();
				
			}
		});
		
		
		
		this.add(jButton);
		jButton.setBounds(155, 365, 180, 50);
		this.add(jTextArea);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(500, 500);
	}
	

	
	
	public void getScString(JTextArea textAreaArray)
	{
		File textsFile = new File("C:\\Users\\bartu\\eclipse-java\\Wordle-App\\src\\HighScoreDB.txt");
		List<String> dataList = new ArrayList<>();
		try {
			Scanner sc = new Scanner(textsFile);
			while(sc.hasNextLine() == true)
			{
				String data = sc.nextLine();
				dataList.add(data);
			}
			sc.close();
			for(int i = 0; i < dataList.size();i++)
			{
				textAreaArray.append((i+1)+"-)" + dataList.get(i) + "\n");
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Data base Reading Error : File cannot Find");
			e.printStackTrace();
			
		}
		
		
		
	}
	
}
