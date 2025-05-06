package Lab13;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ProjectPanel extends JPanel {
    private static final ImageIcon THOMAS = new ImageIcon("src/Lab13/tj.jpg");
    private BufferedImage myImage;
    private Graphics2D myBuffer;
    private Timer t1,t2;
    private int xPos = 250;
    private int yPos = 180;

    public ProjectPanel(){
        xPos = 50;
        myImage = new BufferedImage(700, 500, BufferedImage.TYPE_INT_RGB);
        myBuffer = (Graphics2D) myImage.getGraphics();
        t1 = new Timer(120,new Listener_1());
        t1.start();
        t2 = new Timer(3000,new Listener_2());
    }
    public void paintComponent(Graphics g){
        g.drawImage(myImage, 0, 0, getWidth(),getHeight(),null);
    }
    public class Listener_1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            int xPoints[] = {xPos,xPos,xPos+50,xPos,xPos-50,xPos,xPos,xPos-50,xPos,xPos+50};
            int yPoints[] = {yPos,yPos+50,yPos,yPos+50,yPos,yPos+50,yPos+100,yPos+150,yPos+100,yPos+150};
            myBuffer.setColor(Color.gray);
            myBuffer.fillRect(0, 0, 700, 350);
            myBuffer.setColor(Color.darkGray);
            myBuffer.fillRect(0,335,700,500);
            myBuffer.drawImage(THOMAS.getImage(), xPos-40,50,75,125, null);
            myBuffer.setStroke(new BasicStroke(10.0f));
            myBuffer.drawPolyline(xPoints, yPoints, 10);

            repaint();
            xPos = xPos + 5;
            if(xPos >= 200){
                myBuffer.setFont(new Font("Monospaced",Font.BOLD,24));
                myBuffer.drawString("颱風天要帶多少錢出門?", 300, 150);
                myBuffer.drawOval(250, 80, 400, 100);
                repaint();
                t1.stop();
                t2.start();
            }
        }
    }
    public class Listener_2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0){
            t2.stop();
            myBuffer.setFont(new Font("Monospaced",Font.BOLD,24));
            myBuffer.drawString("4千萬 因為...", 320, 250);
            myBuffer.drawString("颱風天沒\"事千萬\"別出門", 330, 280);
            myBuffer.drawOval(280, 190, 400, 130);
            repaint();
        }
    }
}
