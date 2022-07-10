import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class LosePanel extends JPanel implements ActionListener{
	private int pWidth = 500;
	private int pHeight = 500;
	
	private Image cross1;
	private Timer timer;
	private int yVelocity = 1;
	
	int xcross1 = 0;
	int ycross1 = 300;
	int xcross2 = 200;
	int ycross2 = 500;
	int xcross3 = 400;
	int ycross3 = 400;

	
	public LosePanel() {
		
		
		
		
		this.setPreferredSize(new Dimension(pWidth,pHeight));
		this.setBackground(Color.DARK_GRAY);

        cross1 = new ImageIcon("C:\\\\\\\\Users\\\\\\\\bartu\\\\\\\\eclipse-java\\\\\\\\Wordle-App\\\\\\\\src\\\\\\\\cross.png").getImage();


        timer = new Timer(10, this);
        timer.start();
	}
	
	public void paint(Graphics g) {

        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(cross1, xcross1, ycross1, null);
        g2d.drawImage(cross1, xcross2, ycross2, null);
        g2d.drawImage(cross1, xcross3, ycross3, null);

    }

	@Override
	public void actionPerformed(ActionEvent e) {
		ycross1 = ycross1 - yVelocity;
		ycross2 = ycross2 - yVelocity;
		ycross3 = ycross3 - yVelocity;
        repaint();
        
	}
	
}
