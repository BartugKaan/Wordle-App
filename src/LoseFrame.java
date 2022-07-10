import javax.swing.*;
public class LoseFrame extends JFrame{
	LosePanel panel;
	
	public LoseFrame() {
		panel = new LosePanel();
		this.setTitle("YOU LOSE");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setVisible(true);
	}

}
