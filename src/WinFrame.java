import javax.swing.*;
public class WinFrame extends JFrame{
	WinPanel winPanel;
	
	
	public WinFrame() {
		winPanel = new WinPanel();
		this.setTitle("YOU W�N");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(winPanel);
        this.pack();
        this.setVisible(true);
	}

}
