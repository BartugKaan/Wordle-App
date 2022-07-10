import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class WinPanel extends JPanel implements ActionListener{
	private int pWidth = 500;
	private int pHeight = 500;
	
	private Image star1,star2,star3;
	private Timer timer;
	private int yVelocity = 1;
	
	int xstar1 = 0;
	int ystar1 = 300;
	int xstar2 = 200;
	int ystar2 = 500;
	int xstar3 = 400;
	int ystar3 = 400;

	
	public WinPanel() {
		
		
		
		
		this.setPreferredSize(new Dimension(pWidth,pHeight));
		this.setBackground(Color.DARK_GRAY);

        star1 = new ImageIcon("C:\\\\\\\\Users\\\\\\\\bartu\\\\\\\\eclipse-java\\\\\\\\Wordle-App\\\\\\\\src\\\\\\\\star.png").getImage();


        timer = new Timer(10, this);
        timer.start();
	}
	
	public void paint(Graphics g) {

        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(star1, xstar1, ystar1, null);
        g2d.drawImage(star1, xstar2, ystar2, null);
        g2d.drawImage(star1, xstar3, ystar3, null);

    }

	@Override
	public void actionPerformed(ActionEvent e) {
		ystar1 = ystar1 - yVelocity;
		ystar2 = ystar2 - yVelocity;
		ystar3 = ystar3 - yVelocity;
        repaint();
        
	}
	

}
