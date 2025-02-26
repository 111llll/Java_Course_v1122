import javax.swing.JOptionPane;
import edu.fcps.karel2.Display;

public class Lab10 {
    public static void followWallsRight(Athlete arg){
        if(arg.rightIsClear()){
            arg.turnRight();
            arg.move();
        }
        else if(!arg.rightIsClear() && arg.frontIsClear())
            arg.move();
        else if(!arg.rightIsClear() && !arg.frontIsClear() && arg.leftIsClear())
            arg.turnLeft();
        else if(!arg.rightIsClear() && !arg.frontIsClear() && !arg.leftIsClear())
            arg.turnAround();
    }

    public static void main(String[] args) {
        String fileName = JOptionPane.showInputDialog("What maze map?");
        Display.openWorld("maps/"+fileName+".map");
        Display.setSize(10, 10);
        Display.setSpeed(5);

        Athlete pathFinder = new Athlete();
        while(!pathFinder.nextToABeeper())
            followWallsRight(pathFinder);
    }
}
