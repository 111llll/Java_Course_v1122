	//Name______________________________ Date_____________
   import edu.fcps.karel2.Display;
   import edu.fcps.karel2.Robot;
   public class Shifter extends Robot implements Runnable, Workable
   {
      private int myBeepers;
      public Shifter(int y)
      {
         super(1, y, Display.EAST, 0);
      
      }
   	public void workCorner(){
         while(nextToABeeper())
            pickBeeper();
         for(int i=1;i<=myBeepers;i++)
            putBeeper();
         myBeepers = getBeepers();
      }
      public void moveOneBlock(){
         move();
      }
      public void run(){
         for(int n=1;n<=7;n++)
         {
            workCorner();
            moveOneBlock();
         }
      }
      public void turnToTheRight(){}
      public void turnToTheNorth(){}
   }