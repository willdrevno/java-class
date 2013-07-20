import javax.swing.*;

public class Sample
{
   public static void main (String[] args)
   {
      String[] student = new String[20];
      int value = 0;
      String strValue;
      String new_name;

      // initialize the array
      for (int k = 0; k < student.length; k++)
         student[k] = "undefined";
      
      // infinite loop until user enters q or cancels
      while (true)
      {
         // input filter loop to get a valid array index from user
         while (true)
         {
            strValue = JOptionPane.showInputDialog(
                  "Choose a student to edit\n"
                  + "from 0 to " + (student.length - 1) + "\n"
                  + " ('q' to end program):");
            // did they click cancel or close box?
            if (strValue == null)
               return; // if so, end program
            
            // did they type a string that was not 1 or 2 digits?
            if (strValue.length() < 1 || strValue.length() > 2)
               continue; // if so, prompt again
            
            // did they type 'q'?
            if (strValue.length() == 1 && strValue.charAt(0) == 'q')
               return;  // if so, exit program
            
            // finally, convert to int.  Is it a valid int?
            try
            {
               value = Integer.parseInt(strValue);              
            }
            catch (NumberFormatException e)
            {
               // typed illegal int ("34.5" or "sdf" or "*2", etc.)
               continue;
            }
            
            // is the int within our expected range?
            if (value >=0 &&  value < student.length)
               break;  // good value, escape from this loop
               
            // typed a valid int but was it in range?
            // could test inside loop or in while statement
         } 
         
         // infinite loop for name input
         while (true)
         {
            new_name = JOptionPane.showInputDialog(null, 
               "Enter New Name:", 
               "Editing student " + value + ": '" 
                     + student[value] + "'", 
               JOptionPane.QUESTION_MESSAGE );
            
            // they hit cancel or close box
            if (new_name == null)
               break;
            else if (new_name.length() >=2 && new_name.length() <= 40)
            {
               student[value] = new_name;
               break; // from input loop
            }
            else
               JOptionPane.showMessageDialog(null, 
                  "Invalid Name, try again.");
         }
      }
   }
}