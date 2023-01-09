package game;

/* Add comments here
 * 
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class MainGame {
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainGame();
			}
		});
	}

	/***** constants *****/
	final static int PANW = 1100;
	final static int PANH = 700;
	final static int TIMERSPEED = 10;
	
	
	/***** instance variables (global) *****/
	DrawingPanel panel = new DrawingPanel();
	
	//constructor
	MainGame() {
		createAndShowGUI();
		startTimer();
	}
	
	void createAndShowGUI() {
		JFrame frame = new JFrame("Awesome game!");
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );		
		frame.setResizable(false);
		

		frame.add(panel);
		frame.pack();
		frame.setLocationRelativeTo( null );		
		frame.setVisible(true);		
	}
	
	void startTimer() {		
//		Timer timer = new Timer(TIMERSPEED, this);
//		timer.setInitialDelay(1000);
//		timer.start();
	}
	
	class DrawingPanel extends JPanel {
		DrawingPanel() {
			this.setBackground(Color.LIGHT_GRAY);
			this.setPreferredSize(new Dimension(PANW,PANH));  //remember that the JPanel size is more accurate than JFrame.
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			//gets background image after running try catch
			BufferedImage img = loadImage("Background1.jpg");
			g.drawImage(img, 0, 100, getWidth(), 600, null);
		}

		static BufferedImage loadImage(String filename) {
			BufferedImage img = null;
			try {
				img = ImageIO.read(new File(filename));
			} catch (IOException e) {
				System.out.println(e.toString());
				JOptionPane.showMessageDialog(null, "An image failed to load:" + filename, "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			return img;
		}
	}	
}

