import java.util.Scanner;
  
public class Practice123
{
   public static void main (String[] args)
   {
      Scanner input = new Scanner(System.in);
      String password;
      boolean validated;
      char letter;
      int length;

      // Get password candidate from console, until it passes our tests
      validated = false;
      while (!validated)
      {
         // get the password candidate from user
         System.out.print("Enter a password, please ('q' to quit): ");
         password = input.nextLine();
         
         length = password.length();
         // test for quit first
         if ( length == 1 
            && ( password.charAt(0) == 'q'  || password.charAt(0) == 'Q') )
         {
            System.out.println("No password defined.");
            break;  // from loop
         }
         
         // test for reasonable length
         if (length < 6 || length > 15)
         {
            System.out.println(
                  "Password must be between 6 and 15 characters.");
            continue;
         }
         
         validated = true;   // assume innocent entering loop
         // allow only letters and numbers
         for (int k = 0; k < length; k++)
         {
            letter = password.charAt(k);   // store in letter for reuse
            if (letter >= 'a' && letter <= 'z')
               continue; //  we have a good lower case letter
            else if (letter >= 'A' && letter <= 'Z')
               continue; //  we have a good upper case letter
            else if (letter >= '0' && letter <= '9')
               continue; //  we have a good numeral
            else
            {
               // this letter is not one of the three legal types
               System.out.println("Use only A-Z, a-z or 0-9, please.");
               validated = false;
               break;   // from the for loop leaving validated as false
            }
         }
         
         // if the above loop yielded an error, we try again
         if (!validated)
            continue;
         
         // if here, it is the proper length and contains legal chars
         // but is the first character a letter?
         letter = password.charAt(0);
         if (letter >= '0' && letter <= '9')
         {
            System.out.println(
                  "First character must be a letter (non-numeric).");
            validated = false;
            continue;
         }
         else
         {
            // they passed the final test
            System.out.println(
                  "Your password " + password + " has been accepted.");
            break;   // this is not really needed but is safe
         }
      }
      
      System.out.println("\nGood bye.\n");
   }
}

/* ----------- Output ----------------

Enter a password, please ('q' to quit): hi mom
Use only A-Z, a-z or 0-9, please.
Enter a password, please ('q' to quit): sdfkj(*&
Use only A-Z, a-z or 0-9, please.
Enter a password, please ('q' to quit): 8thhing
First character must be a letter (non-numeric).
Enter a password, please ('q' to quit): sdf
Password must be between 6 and 15 characters.
Enter a password, please ('q' to quit): adfa sdfjasdlfkjasdlfkjasdf
Password must be between 6 and 15 characters.
Enter a password, please ('q' to quit): sdf sdf
Use only A-Z, a-z or 0-9, please.
Enter a password, please ('q' to quit): asdfASDF
Your password asdfASDF has been accepted.

Good bye.

------------------------------------- */