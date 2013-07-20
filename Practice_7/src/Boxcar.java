// class Rectangle --------------------
class Rectangle 
{  
   // member data for the class -- some private
   // and some public      
   private double width, height;
   public char label;
  
   // A couple of class methods:   
   // -------  WhichIsBiggerRef --------------
   // returns a reference to the larger Rectangle of r1 and r2
   static public Rectangle WhichIsBiggerRef(
         Rectangle r1, Rectangle r2)
   {
      if ( r1.width * r1.height > r2.width * r2.height )
         return r1;
      else
         return r2;
   }
  
   // -------  WhichIsBiggerClone --------------
   // returns a clone of the larger Rectangle of r1 and r2
   static public Rectangle WhichIsBiggerClone(
         Rectangle r1, Rectangle r2)
   {
      Rectangle return_rect = new Rectangle();
      Rectangle r;
      
      r = WhichIsBiggerRef(r1, r2);
      return_rect.width = r.width;
      return_rect.height = r.height;
      return_rect.label = '*';  // comparison results in a new rect
                                 // with label '*'
      return return_rect;
   }
  
   // Now, the instance methods:   
   // -------  SetWidthHeight Definition --------------
   public boolean SetWidthHeight(double width, double height)
   {
      if ( width <= 0 || height <= 0 )     
         return false;
      this.width = width;
      this.height = height;
      return true;
   }
  
   // -------  GetWidth Definition --------------
   public double GetWidth()
   {
      return width;
   }
    
   // -------  GetHeight Definition --------------
   public double GetHeight()
   {
      return height;
   }
    
   // -------  GetArea Definition --------------
   public double GetArea()
   {
      return width*height;
   }
  
   // -------  GetPerimeter Definition --------------
   public double GetPerimeter()
   {
      return 2*(width + height);
   }
  
   // -------  ShowAllData Definition --------------
   public void ShowAllData()
   {
      System.out.println( "Label=" + label + " Width=" 
           + width + " Height=" + height );
   }
            
} // ----------------------- end Rectangle
  
  
//main class Boxcar --------------------
public class Boxcar {
   public static void main (String[] args)
   {
      Rectangle r1, r2, r3;
  
      // allocate two Rectangle objects      
      r1 = new Rectangle();
      r2 = new Rectangle();
  
      // create a new rectangle, r1, with dimensions 5 x 8     
      r1.label = 'a';
      r1.SetWidthHeight(5, 8);
      r1.ShowAllData();
      System.out.println( "Rectangle with label " + r1.label
           + " has area " + r1.GetArea()
           + " and perimeter " + r1.GetPerimeter() + "\n");
   
      // create a new rectangle, r2, with dimensions 6 x 6   
      // based on r1's dimensions:    
      r2.label = 'b';
      r2.SetWidthHeight( r1.GetWidth()+1, r1.GetHeight()-2);
      r2.ShowAllData();
      System.out.println( "Rectangle with label " + r2.label
           + " has area " + r2.GetArea() 
           + " and perimeter " + r2.GetPerimeter() + "\n");
   
      // find out which is bigger - result (reference) is r3:
      r3 = Rectangle.WhichIsBiggerRef(r1, r2);
        
      // at this point r3 and r1 (because r1 was bigger) point
      // to the same object.  If we changed r1, we would also be
      // changing r3.  How can you verify this? (informal hwk)
      System.out.println( "Rectangle with label " + r3.label
           + " is larger, having area " + r3.GetArea() );
        
      // find out which is bigger - result (object) is r3:
      r3 = Rectangle.WhichIsBiggerClone(r1, r2);
        
      // now r3 is decoupled from r1 and r2.  It is its own
      // object.  However the output looks identical to above.
      System.out.println( "Rectangle with label " + r3.label
           + " is larger, having area " + r3.GetArea() );
           
       // finally, a demonstration of how to use the boolean return value
      if ( ! r3.SetWidthHeight(-3, 40) )
         System.out.println("ERROR in SetWidthHeight()!");
      else
         System.out.println("OK Return SetWidthHeight()!");
      
      if ( ! r3.SetWidthHeight(21, 40) )
         System.out.println("ERROR in SetWidthHeight()!");
      else
         System.out.println("OK Return SetWidthHeight()!");
   } 
  
} // ----------------------- end Boxcar