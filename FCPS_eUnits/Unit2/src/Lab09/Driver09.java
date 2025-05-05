package Lab09;
import java.awt.Color;

import javax.swing.JFrame;

import Lab06.TurtlePanel;

public class Driver09 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Polygon Turtles");
        frame.setSize(400,400);
        frame.setLocation(300,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new TurtlePanel());
        frame.setVisible(true);
        TwistyTurtle rotatetriangle = new TwistyTurtle(1);
        TwistyTurtle rotatet = new TwistyTurtle(100,250,90,2);
        TwistyTurtle rotatetsquares = new TwistyTurtle(500,350,90,3);

        Thread t1 = new Thread(rotatetriangle);
        Thread t2 = new Thread(rotatet);
        Thread t3 = new Thread(rotatetsquares);

        t1.start();
        t2.start();
        t3.start();
    }
}
