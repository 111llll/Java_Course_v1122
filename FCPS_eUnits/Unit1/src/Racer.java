import edu.fcps.karel2.Display;

public class Racer extends Athlete 
{
    public Racer(int y)
    {
        super(1,y,Display.EAST,Display.INFINITY);
    }
    public void jumpRight()
    {
        turnLeft();
        move();
        turnRight();
        move();
        turnRight();
        move();
        turnLeft();
    }
    public void jumpLeft()
    {
        turnRight();
        move();
        turnLeft();
        move();
        turnLeft();
        move();
        turnRight();
    }
    public void sprint(int Unit)
    {
        for(int i=1;i<=Unit;i++)
            move();
    }
    public void put(int Beepers)
    {
        for(int i=1;i<=Beepers;i++)
            putBeeper();
    }
    public void pick(int Beepers)
    {
        for(int i=1;i<=Beepers;i++)
            pickBeeper();
    }
    public void shuttle(int Spaces,int Beepers)
    {
        //Spaces are the spaces between the racer and the beeper
        Spaces=Spaces-1;
        move();
        jumpRight();
        sprint(Spaces);
        pick(Beepers);
        turnAround();
        sprint(Spaces);
        jumpLeft();
        move();
        put(Beepers);
        turnAround();
    }
}
