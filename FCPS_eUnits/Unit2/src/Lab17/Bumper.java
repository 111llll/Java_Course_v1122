package Lab17;

// Name: 				Date:

   import java.awt.*;

import Lab10.Polkadot;
   
    public class Bumper
   {
    //private fields, all ints, for a Bumper
    //hint: the "location" of the bumper begins at its top left corner.
    	private int X;
    	private int Y;
    	private int XWidth;
    	private int YWidth;
    	private Color Color;
   
     //constructors
       public Bumper()         //default constructor
      {
      
      }
       public Bumper(int x, int y, int xWidth, int yWidth, Color c)
      {
    	   super();
    	   X=x;
    	   Y=y;
    	   XWidth=xWidth;
    	   YWidth=yWidth;
    	   Color=c;
      
      }
      public int getX() {
    	  return X;
      }
      public int getY() {
    	  return Y;
      }
      public void setX(int x) {
    	  X=x;
      }
      public void setY(int y) {
    	  Y=y;
      }
      public int getXWidth() {
    	  return XWidth;
      }
      public int getYWidth() {
    	  return YWidth;
      }
      public void setXWidth(int xWidth) {
    	  XWidth=xWidth;
      }
      public void setYWidth(int yWidth) {
    	  YWidth=yWidth;
      }
      public Color getColor() {
    	  return Color;
      }
      public void setColor(Color color) {
    	  Color=color;
      }
      
      
      
     // accessor methods  (one for each field)
   
     // modifier methods  (one for each field)
   
     // instance methods
     // chooses a random (x,y) location.  Bumper stays entirely in the window.
        public void jump(int rightEdge, int bottomEdge)
      {
         // moves location to random (x, y) within the edges
        	X = (int) (Math.random()* (rightEdge-XWidth*2) + XWidth);
            Y = (int) (Math.random()* (bottomEdge-YWidth*2) + YWidth);
      }
      
       // draws a rectangular bumper on the buffer
       public void draw(Graphics myBuffer) 
      {
         myBuffer.setColor(getColor());
         myBuffer.fillRect(getX(), getY(), getXWidth(), getYWidth());
      }   
   	// returns true if any part of the polkadot is inside the bumper
       public boolean inBumper(Polkadot dot)
      {
         for(int x = getX(); x <= getX() + getXWidth(); x++)   //starts at upper left corner(x,y)
            for(int y = getY(); y <= getY() + getYWidth(); y++)
               if(distance(x, y, dot.getX(), dot.getY()) <= dot.getRadius() ) //checks every point on the bumper
                  return true;            
         return false;
      }  
      // returns distance between (x1, y1) and (x2, y2)
       private double distance(double x1, double y1, double x2, double y2)
      {
         return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
      }	
   }
