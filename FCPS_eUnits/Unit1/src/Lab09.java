import edu.fcps.karel2.Display;
import javax.swing.JOptionPane;

public class Lab09 {
    public static void main(String[] args) {
        String filename = JOptionPane.showInputDialog("What robot world?");
        Display.openWorld("maps/" + filename + ".map");
        Display.setSize(10, 10);
        Display.setSpeed(10);

        Athlete athBot = new Athlete(1,1,Display.EAST,0);
        int beeperPickedPrevious = 0;
        int count = 0;
        while (true) {
            while(athBot.nextToABeeper())
                athBot.pickBeeper();
            for(int beeperPut = 0;beeperPut < beeperPickedPrevious;beeperPut++)
                athBot.putBeeper();
            athBot.move();
            count++;
            if(athBot.nextToABeeper())
                count = 0;
            beeperPickedPrevious = athBot.getBeepers();
            if(count >= 2)
                break;
        }
    }
}
