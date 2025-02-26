import edu.fcps.karel2.Display;

public class BreakDancer extends Dancer{
    public BreakDancer(int x,int y){
        super(x,y,Display.NORTH,0);
    }
    public void danceStep(){
        for(int i = 1;i <= 16;i++)
            turnLeft();
    }
}
