import java.awt.BorderLayout;

import javax.swing.*;
public class DrdFrame extends JFrame{
	private String playeName;
	private DrdBottomPanel drdBottomPanel;
	private DrdTopPanel drdTopPanel;
	private DrdCenterPanel drdCenterPanel;
	private Player player1;
	
	
	public DrdFrame(String userName)
	{
		playeName = userName;
		player1 = new Player(1,playeName);
		this.setTitle("Wordle");
		this.setLayout(new BorderLayout());
		
		drdTopPanel =  new DrdTopPanel();
		this.add(drdTopPanel,BorderLayout.NORTH);
		
		
		drdCenterPanel = new DrdCenterPanel();
		this.add(drdCenterPanel,BorderLayout.CENTER);
		
		drdBottomPanel = new DrdBottomPanel(player1);
		this.add(drdBottomPanel, BorderLayout.SOUTH);
		
		
		
		
		
		
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setVisible(true);
	}

}
