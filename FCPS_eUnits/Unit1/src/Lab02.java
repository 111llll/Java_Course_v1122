import edu.fcps.karel2.Display;

public class Lab02 {

    public static void main(String[] args) {
        Display.openWorld("maps/maze.map");
        Display.setSize(8, 8);

        Athlete AthlBot = new Athlete();
        
        AthlBot.putAndMove();
        AthlBot.turnRight();
        AthlBot.putAndMove();
        AthlBot.turnRight();
        AthlBot.putAndMove();
        AthlBot.turnLeft();
        AthlBot.putAndMove();
        AthlBot.turnLeft();
        AthlBot.putAndMove();
        AthlBot.turnRight();
        AthlBot.putAndMove();
        AthlBot.putAndMove();
        AthlBot.turnRight();
        AthlBot.putAndMove();
        AthlBot.turnLeft();
        AthlBot.putAndMove();
        AthlBot.turnLeft();
        AthlBot.putAndMove();
        AthlBot.putAndMove();
        AthlBot.putAndMove();
        AthlBot.putAndMove();
        AthlBot.turnRight();
        AthlBot.putAndMove();
        AthlBot.putAndMove();

    }
    
}
