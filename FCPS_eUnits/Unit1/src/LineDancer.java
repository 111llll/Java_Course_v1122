public class LineDancer extends Dancer {
    public LineDancer(int x,int y,int dir){
        super(x,y,dir,0);
    }
    public void danceStep(){
        turnLeft();
        move();
        move();
        move();
        move();
        move();
        move();
        turnRight();
        turnRight();
        move();
        move();
        move();
        move();
        move();
        move();
        turnLeft();
    }
}
