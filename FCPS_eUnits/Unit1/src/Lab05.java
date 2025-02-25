import edu.fcps.karel2.Display;

public class Lab05 {
    public static void runTheRace(Racer RandomGuy)
    {
        RandomGuy.shuttle(3, 7);
        RandomGuy.shuttle(5, 5);
        RandomGuy.shuttle(7, 3);
        RandomGuy.move();
    }
    public static void main(String[] args) {
        Display.openWorld("maps/shuttle.map");
        Display.setSize(10, 10);
        Display.setSpeed(10);

        Racer TopGuy = new Racer(7);
        Racer MiddleGuy = new Racer(4);
        Racer BottomGuy = new Racer(1);

        runTheRace(TopGuy);
        runTheRace(MiddleGuy);
        runTheRace(BottomGuy);
    }
}
