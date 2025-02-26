import edu.fcps.karel2.Display;

public class Lab15
{
    public static void main(String[] args)
   {
      Dancer outerTop = new LineDancer(1, 7, Display.SOUTH);
      Dancer outerRight = new LineDancer(7, 7, Display.WEST);
      Dancer outerLeft = new LineDancer(1, 1, Display.EAST);
      Dancer outerBot = new LineDancer(7, 1, Display.NORTH);
      Dancer breakerMid = new BreakDancer(4, 4);
      Dancer squareDancer = new SquareDancer(2, 6, Display.EAST);
      Dancer squareCounterDancer = new SquareCounterDancer(5, 5, Display.WEST);

      Thread t1 = new Thread( outerTop );
      Thread t2 = new Thread( outerRight );
      Thread t3 = new Thread( outerLeft );
      Thread t4 = new Thread( outerBot );
      Thread t5 = new Thread( breakerMid );
      Thread t6 = new Thread( squareDancer );
      Thread t7 = new Thread( squareCounterDancer );
      t1.start();
      t2.start();
      t3.start();
      t4.start();
      t5.start();
      t6.start();
      t7.start();
   }
}