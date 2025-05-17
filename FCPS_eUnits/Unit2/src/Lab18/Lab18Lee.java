package Lab18;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Lab18Lee extends JPanel {
	public static void main(String[] args) {
		TurtleLee t = new TurtleLee();
		t.turnLeft(5);
		t.setPenDown(true);
		for (int k = 0; k < 4; k++) {
			t.forward(100);
			t.turnLeft(90);
		}

		JFrame f = new JFrame("Lab18");
		f.setSize(800, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new Lab18Lee());
		f.setVisible(true);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(TurtleLee.getImage(), 0, 0, getWidth(), getHeight(), null);
	}
}

