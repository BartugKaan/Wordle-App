
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;

public class TopPanel extends JPanel {
	private JLabel label;
	
	public TopPanel()
	{
		setLayout(new FlowLayout());
		label = new JLabel("WORDLE");
		this.add(label);
		
		this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.lightGray));
		setVisible(true);
		setSize(500, 50);
		
	}

}
