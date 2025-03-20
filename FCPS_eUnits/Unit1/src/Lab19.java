import javax.swing.JOptionPane;
import edu.fcps.karel2.Display;

public class Lab19 {
    public static void main(String[] args) {
        String filename = JOptionPane.showInputDialog("What robot world?");
        Display.openWorld("maps/"+filename+".map");
        Display.setSpeed(10);

        Dorothy pathALG = new Dorothy();
        
        pathALG.followPath();
        while(pathALG.findPath())
            pathALG.followPath();
    }
}
