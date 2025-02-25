import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class Lab01 {

    public static void main(String[] args) {
        
        Display.openWorld("maps/school.map");
        Display.setSize(10,10);

        Robot Lisa = new Robot(1,1,Display.EAST,0);
        Robot Pete = new Robot(4,5,Display.SOUTH,0);

        //Lisa
        Lisa.move();
        Lisa.move();
        Lisa.turnLeft();
        Lisa.move();
        Lisa.turnLeft();
        Lisa.move();
        Lisa.pickBeeper();
        Lisa.turnLeft();
        Lisa.turnLeft();
        Lisa.move();
        Lisa.turnLeft();
        Lisa.turnLeft();
        Lisa.turnLeft();
        Lisa.move();
        Lisa.turnLeft();
        Lisa.move();
        Lisa.move();
        Lisa.move();
        Lisa.turnLeft();
        Lisa.move();
        Lisa.move();
        Lisa.move();
        Lisa.turnLeft();
        Lisa.move();
        Lisa.move();
        Lisa.turnLeft();
        Lisa.turnLeft();
        Lisa.turnLeft();
        Lisa.move();
        Lisa.putBeeper();

        //Pete
        Pete.pickBeeper();
        Pete.move();
        Pete.turnLeft();
        Pete.move();
        Pete.move();
        Pete.turnLeft();
        Pete.move();
        Pete.move();
        Pete.turnLeft();
        Pete.turnLeft();
        Pete.turnLeft();
        Pete.move();
        Pete.move();
        Pete.turnLeft();
        Pete.move();
        Pete.turnLeft();
        Pete.move();
        Pete.move();
        Pete.turnLeft();
        Pete.turnLeft();
        Pete.turnLeft();
        Pete.move();
        Pete.move();
        Pete.turnLeft();
        Pete.move();
        Pete.move();
        Pete.putBeeper();
        Pete.turnLeft();
        Pete.turnLeft();
        Pete.move();

    }
}
