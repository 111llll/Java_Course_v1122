public class Democrat extends MazeEscaper{
    public Democrat(){
        super();
    }
    public void walkDownCurrentSegment(){
        if(frontIsClear() && !leftIsClear() && !nextToABeeper())
            move();
    }
    public void turnToTheNextSegment(){
        if(leftIsClear()){
            turnLeft();
            move();
        }
        else if(!rightIsClear() && !frontIsClear() && !leftIsClear()) 
            turnAround();
        else if(rightIsClear() && !frontIsClear() && !leftIsClear())
            turnRight();
    }
}
