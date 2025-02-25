import edu.fcps.karel2.Display;

public class Lab04 {
    public static void takeTheField(Athlete arg){
        arg.move();
        arg.move();
        arg.move();
        arg.move();
        arg.turnRight();
        arg.move();
        arg.move();
    }
    public static void toCoachPosition(Athlete argC) {
        argC.turnAround();
        argC.move();
        argC.turnRight();
        argC.move();
        argC.move();
        argC.turnRight();
    }
    public static void main(String[] args) {
        Display.openWorld("maps/arena.map");
        Display.setSize(10, 10);

        Athlete GoalKeeper = new Athlete(1, 1, Display.NORTH, 0);
        Athlete Defender_Left = new Athlete(1, 1, Display.NORTH, 0);
        Athlete Defender_Right = new Athlete(1, 1, Display.NORTH, 0);
        Athlete Attacker_Left = new Athlete(1, 1, Display.NORTH, 0);
        Athlete Attacker_Middle = new Athlete(1, 1, Display.NORTH, 0);
        Athlete Attacker_Right = new Athlete(1, 1, Display.NORTH, 0);
        Athlete Coach = new Athlete(1, 1, Display.NORTH, 0);

        takeTheField(GoalKeeper);
        takeTheField(Defender_Left);
        takeTheField(Defender_Right);
        takeTheField(Attacker_Left);
        takeTheField(Attacker_Middle);
        takeTheField(Attacker_Right);
        takeTheField(Coach);

        toCoachPosition(Coach);

        GoalKeeper.move();
        GoalKeeper.move();
        GoalKeeper.move();
        GoalKeeper.turnLeft();
        GoalKeeper.move();
        GoalKeeper.move();
        GoalKeeper.turnAround();

        Defender_Left.move();
        Defender_Left.move();
        Defender_Left.move();
        Defender_Left.move();
        Defender_Left.move();
        Defender_Left.turnLeft();
        Defender_Left.move();
        Defender_Left.turnAround();

        Defender_Right.move();
        Defender_Right.turnLeft();
        Defender_Right.move();
        Defender_Right.turnAround();

        Attacker_Left.move();
        Attacker_Left.move();
        Attacker_Left.move();
        Attacker_Left.move();
        Attacker_Left.turnRight();

        Attacker_Middle.move();
        Attacker_Middle.move();
        Attacker_Middle.move();
        Attacker_Middle.turnRight();

        Attacker_Right.move();
        Attacker_Right.move();
        Attacker_Right.turnRight();

    }
}
