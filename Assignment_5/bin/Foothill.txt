//import statements
import java.util.Scanner;
import java.text.*;
import java.util.*;
public class Foothill
{
   //universal variables
   static String input_string;
   public static void main(String[] args)
   {
      String solution_pig, solution_turkey;
      int solution_vowel;
      StateInstructions(); //displays instructions
      getString(); //gets string
      solution_pig = pigLatin(); //does pig latin part
      solution_turkey = turkeyIrish(); //does turkey irish part
      solution_vowel = countVowel(); //counts vowels
      displaysolution(solution_pig, solution_turkey, solution_vowel);
      //pumps out result
   }

   public static void StateInstructions() //displays instructions
   {
      String prompt;
      prompt = "Please enter a word. The word must \nbe no less "
            + "then 4 letters, cannot \ncontain spaces or "
            + "non-alpha \ncharacters.";
      System.out.println(prompt);
      System.out.println("---------------");
   }

   public static void getString()
   {
      int length_string;
      boolean valid;
      valid = false;
      length_string = 0;
      while (!valid) //validity based on if input string has 4 or more letters
      {
         Scanner user_input = new Scanner(System.in);
         input_string = user_input.nextLine();
         length_string = input_string.length();
         if (length_string >= 4)
         {
            valid = true;
         }
         else // if not valid then user asked to try again
         {
            System.out.println("Make sure your word is at least 4 " +
            		"letters, \ntry again.");
         }
      }
   }
   public static String pigLatin()
   {
      String string_pig, temp_pig;
      int length, k;
      length = input_string.length();
      temp_pig = "";
      //using for loop to extract 1st letter and place at back
      for (k = 1; k <= length - 1; k = k + 1)
      {
         temp_pig = temp_pig + input_string.charAt(k);
      }
      string_pig = temp_pig + input_string.charAt(0) + "ay"; //add ay
      return string_pig;
   }

   public static String turkeyIrish()
   {
      // change to piglatin
      String string_turkey, temp_turkey;
      char le;
      int length, k;
      le = ' ';
      temp_turkey = "";
      length = input_string.length();
      //using for loop to see where there are vowels
      for (k = 0; k <= length - 1; k = k + 1)
      {
         le = input_string.charAt(k); //the letter we are currently on
         if (le == 'a' || le == 'e' || le == 'i' || le == 'o' || le == 'u')
         {
            temp_turkey = temp_turkey + "ab" + le; //if vowel add "ab" before it
         } else
         {
            temp_turkey = temp_turkey + le;
         }
      }
      string_turkey = temp_turkey;
      return string_turkey;
   }
   public static int countVowel()
   {
      int int_countvowel;
      char le;
      int length, k;
      le = ' ';
      int_countvowel = 0;
      length = input_string.length();
      //count vowels with for loop, if one is found an if statement
      //is triggered
      for (k = 0; k <= length - 1; k = k + 1)
      {
         le = input_string.charAt(k);
         if (le == 'a' || le == 'e' || le == 'i' || le == 'o' || le == 'u')
         {
            int_countvowel = int_countvowel + 1;
         }
      }
      return int_countvowel;
   }
   //display of values created
   public static void displaysolution(String pig, String turkey, int vowel)
   {
      System.out.println("\nPig Latin: " + pig);
      System.out.println("Turkey Irish: " + turkey);
      System.out.println("# of vowels: " + vowel);
   }
}
/*-------------------Console Sample run 1--------------
Please enter a word. The word must 
be no less then 4 letters, cannot 
contain spaces or non-alpha 
characters.
---------------
dogs

Pig Latin: ogsday
Turkey Irish: dabogs
# of vowels: 1
-------------------Console Sample run 2-----------------
Please enter a word. The word must 
be no less then 4 letters, cannot 
contain spaces or non-alpha 
characters.
---------------
hi
Make sure your word is at least 4 letters, 
try again.
fine

Pig Latin: inefay
Turkey Irish: fabinabe
# of vowels: 2
------------------Console Sample run 3--------------
Please enter a word. The word must 
be no less then 4 letters, cannot 
contain spaces or non-alpha 
characters.
---------------
telephone

Pig Latin: elephonetay
Turkey Irish: tabelabephabonabe
# of vowels: 4
---------------------------------------------------*/
