import edu.fcps.Digit;
import edu.fcps.karel2.Display;

public class Lab11 {
    public static void main(String[] args) {
        Display.openDefaultWorld();
        Display.setSize(42, 37);
        Display.setSpeed(10);

        Digit first = new B_letter(7, 19);
        Digit second = new One(13,19);
        Digit third = new One(19, 19);
        Digit fourth = new One(25, 19);
        Digit fifth = new Zero(1, 9);
        Digit sixth = new Seven(7, 9);
        Digit seventh = new One(13, 9);
        Digit eighth = new Six(19, 9);
        Digit ninth = new Zero(25, 9);

        first.display();
        second.display();
        third.display();
        fourth.display();
        fifth.display();
        sixth.display();
        seventh.display();
        eighth.display();
        ninth.display();
    }
}
