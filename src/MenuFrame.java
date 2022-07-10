import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class MenuFrame extends JFrame{
	private JButton keyboardButton;
	private JButton dragAndDropButton;
	private JButton quitButton;
	private JButton highscoreButton;
	private JLabel titleLabel;

	public MenuFrame()
	{
		setTitle("Menu");
		setLayout(new BorderLayout());
		
		
		topPanel();
		centerPanel();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
	}
	
	public String getUsername()
	{
		String userName = JOptionPane.showInputDialog("Username: ");
		try {
			while(userName.trim().isEmpty())
			{	
				JOptionPane.showMessageDialog(null, "please enter a name!");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				userName = JOptionPane.showInputDialog("Username: ");
			}
		}
		catch (NullPointerException e) {
			System.out.println("Error! : Username = " + userName);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return userName;
	}
	
	public void topPanel() {
		JPanel topPanel = new JPanel();
		titleLabel = new JLabel();
		titleLabel.setText("Wordle");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
		topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.lightGray));
		
		topPanel.setLayout(new FlowLayout());
		topPanel.add(titleLabel);
		add(topPanel,BorderLayout.NORTH);
	}
	
	public void centerPanel()
	{
		JPanel centPanel = new JPanel();
		
		
		keyboardButton = new JButton();
		keyboardButton.setText("Keyboard Play");
		keyboardButton.setBackground(Color.ORANGE);
		keyboardButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = getUsername();
				if(username != null) {
					Frame mainKeyboardFrame = new Frame(username);
					dispose();
				}
			}
		});
		
		dragAndDropButton =  new JButton();
		dragAndDropButton.setText("Drag And Drop Play");
		dragAndDropButton.setBackground(Color.ORANGE);
		dragAndDropButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = getUsername();
				if(username != null)
				{
					DrdFrame mainDrdFrame = new DrdFrame(username);
					dispose();
				}
				
				
			}
		});
		
		highscoreButton = new JButton();
		highscoreButton.setText("High Scores");
		highscoreButton.setBackground(Color.ORANGE);
		highscoreButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				HighScoreFrame highScoreFrame = new HighScoreFrame();
				dispose();
				
			}
		});
		
		quitButton = new JButton();
		quitButton.setText("Exit");
		quitButton.setBackground(Color.ORANGE);
		quitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		keyboardButton.setBounds(155, 50, 180, 50);
		dragAndDropButton.setBounds(155, 155, 180, 50);
		highscoreButton.setBounds(155, 260, 180, 50);
		quitButton.setBounds(155, 365, 180, 50);
		

		keyboardButton.setFont(new Font("Arial", Font.BOLD, 12));
		dragAndDropButton.setFont(new Font("Arial", Font.BOLD, 12));
		highscoreButton.setFont(new Font("Arial", Font.BOLD, 12));
		quitButton.setFont(new Font("Arial", Font.BOLD, 12));
		
		centPanel.setLayout(null);
		centPanel.add(keyboardButton);
		centPanel.add(dragAndDropButton);
		centPanel.add(highscoreButton);
		centPanel.add(quitButton);
		
		
		add(centPanel,BorderLayout.CENTER);
	}
	

}
