import java.util.Scanner;

public class Foothill
{
   public static void main(String[] args)
   {
      // make these symbolic constants (finals) so if we wish to change them
      // we can do so quickly up here rather than muck around in the code
      final int LOW_VAL = 15;
      final int HIGH_VAL = 1001;

      int sum;    // holds the answer
      int k;      // loop counter

      sum = 0;    // start it off at 0 - we will add to it
      // loop, adding the ODD numbers
      for ( k = LOW_VAL; k <= HIGH_VAL; k = k + 2 )
      {
         sum = sum + k;
      }
    
      System.out.println("The sum of the odd numbers between " + LOW_VAL
         + " and " + HIGH_VAL + ", inclusive, is " + sum + "\n");
   }
}
/* ------------------- Sample Run --------------------

Run the program to get the answer!

---------------------- End Sample Run ---------------- */