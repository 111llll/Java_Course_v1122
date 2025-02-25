import edu.fcps.karel2.Display;

public class Lab03 {
    public static void main(String[] args) {
        Display.openWorld("maps/mountain.map");
        Display.setSize(16, 16);

        Climber ClimbBot = new Climber(8);
        //Base camp
        ClimbBot.putBeeper();
        //Climb up right
        ClimbBot.turnRight();
        ClimbBot.move();
        ClimbBot.climbUpRight();
        ClimbBot.climbUpRight();
        ClimbBot.climbUpRight();
        //Climb down right
        ClimbBot.climbDownRight();
        ClimbBot.climbDownRight();
        //Pick up and back
        ClimbBot.pickBeeper();
        //Climb up left
        ClimbBot.turnAround();
        ClimbBot.climbUpLeft();
        ClimbBot.climbUpLeft();
        //Climb down left
        ClimbBot.climbDownLeft();
        ClimbBot.climbDownLeft();
        ClimbBot.climbDownLeft();
        //Put down
        ClimbBot.move();
        ClimbBot.putBeeper();
    }

}
