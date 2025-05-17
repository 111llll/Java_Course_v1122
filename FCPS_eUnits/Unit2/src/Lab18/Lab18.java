package Lab18;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


//import edu.fcps.Turtle;


public class Lab18 extends JPanel {
	
	public static void main(String[] args) {
		
//		Turtle.setCrawl(true);     //a class method
//        Turtle.setSpeed(10);
		
		Turtle t = new Turtle();
		t.turnLeft(5);
		t.setPenDown(true);
		for (int k = 0; k < 4; k++) {
			t.forward(100);
			t.turnLeft(90);
		}
		
		JFrame f = new JFrame("Lab18");
		f.setSize(800, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new Lab18());
		f.setVisible(true);

	}
	public void paintComponent(Graphics g) {
		g.drawImage(Turtle.getImage(), 0, 0, getWidth(), getHeight(), null);
	}

}