package Lab19;

//Name:    Date:
import javax.swing.*;

import Lab10.Polkadot;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class PrizePanel extends JPanel {
	private static final int FRAME = 400;
	private static final Color BACKGROUND = new Color(204, 204, 204);
	private BufferedImage myImage;
	private Graphics myBuffer;
	private Ball ball;
	private Polkadot[] myPDarray;
	private Timer t;
	int count = 0;

	// constructor
	public PrizePanel() {
		myImage = new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
		myBuffer = myImage.getGraphics();
		myBuffer.setColor(BACKGROUND);
		myBuffer.fillRect(0, 0, FRAME, FRAME);

		int xPos = (int) (Math.random() * (FRAME - 100) + 50);
		int yPos = (int) (Math.random() * (FRAME - 100) + 50);
		ball = new Ball(xPos, yPos, 50, Color.BLACK);

		myPDarray = new Polkadot[50];
		for (int k = 0; k < myPDarray.length; k++) {
			xPos = (int) (Math.random() * FRAME);
			yPos = (int) (Math.random() * FRAME);
			myPDarray[k] = new Polkadot(xPos, yPos, 25, Color.red);
		}

		t = new Timer(1, new Listener());
		t.start();
	}

	public void paintComponent(Graphics g) {
		g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
	}

	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			myBuffer.setColor(BACKGROUND);
			myBuffer.fillRect(0, 0, FRAME, FRAME);
			ball.move(FRAME, FRAME);
			ball.draw(myBuffer);

			for (int k = 0; k < myPDarray.length; k++) {
				myPDarray[k].draw(myBuffer);
			}

           for (Polkadot pd : myPDarray) {
        	   pd.draw(myBuffer);
           }

			collide(ball, myPDarray);
			myBuffer.setColor(Color.BLACK);
			myBuffer.setFont(new Font("標楷體", Font.BOLD | Font.ITALIC, 30));
			myBuffer.drawString("計分: " + count, 250, 30);
			repaint();
		}
	}

	private void collide(Ball b, Polkadot[] myPDarray) {
		for (int k = 0; k < myPDarray.length; k++) {
			double d = distance(b.getX(), b.getY(), myPDarray[k].getX(), myPDarray[k].getY());
			if (d <= (b.getRadius() + myPDarray[k].getRadius())) {
				myPDarray[k].jump(FRAME, FRAME);
				count++;
			}
		}

		for (Polkadot pd : myPDarray) {
			double d = distance(b.getX(), b.getY(), pd.getX(), pd.getY());
			if (d <= (b.getRadius() + pd.getRadius())) {
				pd.jump(FRAME, FRAME);
				count++;
			}
		}
	}

	private double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

	}
}