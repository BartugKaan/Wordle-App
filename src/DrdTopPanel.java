import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class DrdTopPanel extends JPanel{
	private JLabel title =  new JLabel("Wordle");
	
	
	public DrdTopPanel() {
		setLayout(new FlowLayout());
		title = new JLabel("WORDLE");
		this.add(title);
		
		this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.lightGray));
		setVisible(true);
		setSize(500, 50);
	}

}
