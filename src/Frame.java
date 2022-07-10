
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;
public class Frame  extends JFrame {
	
	private TopPanel topPanel;
	private CenterPanel centerPanel;
	private BottomPanel bottomPanel;
	public Player player1,player2;
	public String userString;
	
	public Frame(String username)
	{
			userString = username;
		
		
		
		setTitle("WORDLE");
		setLayout(new BorderLayout());
		player1 = new Player(1,userString);
		
		topPanel = new TopPanel();
		this.add(topPanel,BorderLayout.PAGE_START);
		
		centerPanel = new CenterPanel();
		this.add(centerPanel, BorderLayout.CENTER);
		
		bottomPanel = new BottomPanel(player1);
		this.add(bottomPanel, BorderLayout.SOUTH);
		
		
		bottomPanel.setVisible(true);
		centerPanel.setVisible(true);
		topPanel.setVisible(true);
		setVisible(true);
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
