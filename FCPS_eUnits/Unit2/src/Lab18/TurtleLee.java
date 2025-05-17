package Lab18;

import java.awt.Color;
import java.awt.Graphics;
// Torbert, 7.20.06
import java.awt.Image;
import java.awt.image.BufferedImage;

public class TurtleLee {
	private static BufferedImage img;
	private static Graphics graphics;
//	private static int black = 0;
//	private static int blue = 255; // 2^8-1
//	private static int green = 65280; // (2^8-1)*2^8
//	private static int red = 16711680; // (2^8-1)*2^16
	private static int white = 16777215; // 2^24-1
	private boolean penIsDown;
	private double x, y, theta; // what does a Turtle know?
	private Color TurtleColor;
	private int x1, y1;
	static // a static initializer list
	{
		img = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
		graphics = img.getGraphics();
	}

	public TurtleLee() {
		// img = new BufferedImage(800,600,BufferedImage.TYPE_INT_RGB);
		x = img.getWidth() / 2; // start at center
		y = img.getHeight() / 2; // start at center
		theta = 90; // start facing north
	}

	public static Image getImage() {
		return img;
	}

	public void turnLeft(double a) {
		theta += a;
	}

	public void turnRight(double a) {
		theta -= a;
	}

	public void forward(double r) {
		if (penIsDown) {
			for (int i = 0; i <= (int) r; i++) {
				x1 = (int) (x + i * Math.cos(theta * Math.PI / 180));
				y1 = (int) (y - i * Math.sin(theta * Math.PI / 180));
				img.setRGB(x1, y1, white);
			}
		}
		x = (int) (x + r * Math.cos(theta * Math.PI / 180));
		y = (int) (y - r * Math.sin(theta * Math.PI / 180));

		// drawLine(x,y,x1,y1);
	}

	public void back(double r) {
		if (penIsDown) {
			for (int i = 0; i <= (int) r; i++) {
				x1 = (int) (x - i * Math.cos(theta * Math.PI / 180));
				y1 = (int) (y + i * Math.sin(theta * Math.PI / 180));
				img.setRGB(x1, y1, white);
			}
		}
		x = (int) (x - r * Math.cos(theta * Math.PI / 180));
		y = (int) (y + r * Math.sin(theta * Math.PI / 180));
	}

	public Color getColor() {
		return TurtleColor;
	}

	public void setColor(Color c) {
		TurtleColor = c;
		graphics.setColor(TurtleColor);
	}

	public static void clear(Color c) {
		graphics.setColor(c);
		graphics.fillRect(0, 0, 800, 600);
		graphics.drawImage(img, 0, 0, 800, 600, null);
	}

	public static void clear() {
		clear(Color.black);
	}

	public void drawLine(int x1, int yl, int x2, int y2) {
		int ix, iy;
		double slope = (double) (x2 - x1) / (y2 - y1);
		for (ix = x1; ix <= x2; ix++) {
			iy = (int) (y1 + slope * (ix - x1));
			img.setRGB(ix, iy, white);
		}
	}

	public void setPenDown(boolean x) {
		this.penIsDown = x;
	}
}