public class Republican extends MazeEscaper{
    public Republican(){
        super();
    }
    public void walkDownCurrentSegment(){
        if(frontIsClear() && !rightIsClear() && !nextToABeeper())
            move();
    }
    public void turnToTheNextSegment(){
        if(rightIsClear()){
            turnRight();
            move();
        }
        else if(!rightIsClear() && !frontIsClear() && !leftIsClear()) 
            turnAround();
        else if(!rightIsClear() && !frontIsClear() && leftIsClear())
            turnLeft();
    }

}
