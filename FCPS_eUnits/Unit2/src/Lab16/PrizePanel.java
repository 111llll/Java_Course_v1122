package Lab16;

   //Name:    Date:
   import javax.swing.*;

import Lab10.Polkadot;
import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.*;
    public class PrizePanel extends JPanel
   {
	private static final int FRAME = 400;
      private static final Color BACKGROUND = new Color(204, 204, 204);
      private BufferedImage myImage;
      private Graphics myBuffer;
      private Ball ball;
      private Polkadot pd;
      private Timer t; 
      int count = 0;
		//constructor   
       public PrizePanel() {
    	   myImage = new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
    	   myBuffer = myImage.getGraphics();
    	   myBuffer.setColor(BACKGROUND);
    	   myBuffer.fillRect(0, 0, FRAME, FRAME);
    	   pd = new Polkadot();
    	   int xPos = (int)(Math.random()*(FRAME-100) + 50);
    	   int yPos = (int)(Math.random()*(FRAME-100) + 50);
    	   ball = new Ball(xPos, yPos, 50, Color.BLACK);
    	   
    	   t = new Timer(1, new Listener());
    	   t.start();
    	   
    	   addMouseListener(new Mouse());
      }
       public void paintComponent(Graphics g) {
    	   g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
      }
       private class Listener implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
           myBuffer.setColor(BACKGROUND);
           myBuffer.fillRect(0, 0, FRAME, FRAME);
           ball.move(FRAME, FRAME);
           ball.draw(myBuffer);
           pd.draw(myBuffer);
           collide(ball, pd);
           myBuffer.setColor(Color.BLACK);
   		   myBuffer.setFont(new Font("標楷體",Font.BOLD | Font.ITALIC, 30));
   		   myBuffer.drawString("計分: "+count, 250, 30);
           repaint();
         }
      }   
       private void collide(Ball b, Polkadot pd)
      {
        double d = distance(b.getX(),b.getY(),pd.getX(),pd.getY());  
		if (d <= (b.getRadius()+pd.getRadius())) {
			 pd.jump(FRAME, FRAME);
			 count++;
		} 
      }
       private double distance(double x1, double y1, double x2, double y2)
      {
         return Math.sqrt(Math.pow(x2 - x1, 2)+Math.pow(y2 - y1, 2));
        		 
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
   }