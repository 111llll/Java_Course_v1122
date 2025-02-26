public class SquareCounterDancer extends Dancer {
    public SquareCounterDancer(int x,int y,int dir){
        super(x,y,dir,0);
    }
    public void danceStep(){
        for(int i = 1;i <= 4;i++){
            move();
            move();
            turnLeft();
        }
    }
}
