package Lab17;

//Name:    Date:
import javax.swing.*;

import Lab10.Polkadot;
import Lab17.PrizePanel.Key;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class PrizePanel extends JPanel {
	private static final int FRAME = 400;
	private static final Color BACKGROUND = new Color(204, 204, 204);
	private BufferedImage myImage;
	private Graphics myBuffer;
	private Ball ball;
	private Polkadot pd;
	private Timer t;
	int count = 0;
	private JLabel label,label1;

	// constructor
	public PrizePanel() {
		
		setLayout(null);
		label = new JLabel("Use ↑, ↓, ← and → to control PD.");
		label.setFont(new Font("Serif", Font.BOLD, 15));
		label.setBounds(170, 0, 250, 100);
		label.setForeground(Color.RED);
	//	label1.setPreferredSize(new Dimension(250, 100)); // 設置首選大小
		add(label);
		
		label1 = new JLabel("Use W, A, S and D to control ball.");
		label1.setFont(new Font("Serif", Font.BOLD, 15));
		label1.setBounds(170, 20, 250, 100);
		label1.setForeground(Color.black);
	//	label1.setPreferredSize(new Dimension(250, 100)); // 設置首選大小
		add(label1);

		myImage = new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
		myBuffer = myImage.getGraphics();
		myBuffer.setColor(BACKGROUND);
		myBuffer.fillRect(0, 0, FRAME, FRAME);
		pd = new Polkadot();
		int xPos = (int) (Math.random() * (FRAME - 100) + 50);
		int yPos = (int) (Math.random() * (FRAME - 100) + 50);
		ball = new Ball(xPos, yPos, 50, Color.BLACK);

		t = new Timer(1, new Listener());
		t.start();

		addMouseListener(new Mouse());
		addKeyListener(new Key());
		setFocusable(true);
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
			pd.draw(myBuffer);
			collide(ball, pd);
			myBuffer.setColor(Color.BLACK);
			myBuffer.setFont(new Font("標楷體", Font.BOLD | Font.ITALIC, 30));
			myBuffer.drawString("計分: " + count, 250, 30);
			repaint();
		}
	}

	private void collide(Ball b, Polkadot pd) {
		double d = distance(b.getX(), b.getY(), pd.getX(), pd.getY());
		if (d <= (b.getRadius() + pd.getRadius())) {
			pd.jump(FRAME, FRAME);
			count++;
		}
	}

	private double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

	}

	public class Mouse extends MouseAdapter implements MouseListener {

		public void mousePressed(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON3) {
				ball.setX(e.getX());
				ball.setY(e.getY());

			} else if (e.isShiftDown()) {
				ball.setdx(Math.random() * 12);
				ball.setdy(Math.random() * 12);

			} else if (e.getButton() == MouseEvent.BUTTON1) {
				pd.setX(e.getX());
				pd.setY(e.getY());
			}
		}
	}

	public class Key extends KeyAdapter implements KeyListener {
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case 'W':
				ball.setY(ball.getY() - 10);
				break;
			case 'A':
				ball.setX(ball.getX() - 10);
				break;
			case 'S':
				ball.setY(ball.getY() + 10);
				break;
			case 'D':
				ball.setX(ball.getX() + 10);
				break;
			case KeyEvent.VK_UP:
				pd.setY(pd.getY() - 10);
				if (pd.getY() < 0) {
					pd.setY(pd.getRadius());
				}
				break;
			case KeyEvent.VK_DOWN:
				pd.setY(pd.getY() + 10);
				if (pd.getY() > FRAME) {
					pd.setY(FRAME - pd.getRadius());
				}
				break;
			case KeyEvent.VK_LEFT:
				pd.setX(pd.getX() - 10);
				if (pd.getX() < 0) {
					pd.setX(pd.getRadius());
				}
				break;
			case KeyEvent.VK_RIGHT:
				pd.setX(pd.getX() + 10);
				if (pd.getX() > FRAME) {
					pd.setX(FRAME - pd.getRadius());
				}
				break;
			}
		}
	}
}