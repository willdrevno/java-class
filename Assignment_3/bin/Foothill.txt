import java.util.Scanner;
public class Foothill 
{
   public static void main(String[] args)
   {  
      int height, weight; //declaring variables
      double bmi;
      Scanner input_stream = new Scanner(System.in);
      String user_input;
      System.out.println("How much do you weigh in pounds? ");
      user_input = input_stream.nextLine();
      weight = Integer.parseInt(user_input);
      System.out.println("How tall are you in inches? ");
      user_input = input_stream.nextLine();
      height = Integer.parseInt(user_input);
      if ( weight < 0 || height < 0 ) //scanning for negative values
      {
         System.out.println("Both your height and weight you enter " +
            "need to be positive values." + "\nPlease try again.");
         return;
      }
      //over 1000 pounds or over 8 feet seemed unreasonable
      else if (weight > 1000 || height > 96)
      {
         System.out.println("The height or weight value you entered seemed " +
         		"unreasonable." + "\nPlease try again.");
         return;
      }
      bmi = (weight*703.0)/(height*height); //calculating bmi
      System.out.println("Your Body Mass Index (BMI) is: " + bmi);
      if ( bmi < 18.5 ) //checking for which category they fall into
      {
         System.out.println("You are underweight.");
         return;
      }
      else if ( bmi <= 25 )
      {
         System.out.println("You are in the optimal weight range.");
         return;
      }
      else if ( bmi > 25 )
      {
         System.out.println("You are overweight.");
         return;
      }
   }
}
/*--------Run #1----------------------
How much do you weigh in pounds? 
185
How tall are you in inches? 
73
Your Body Mass Index (BMI) is: 24.40514167761306
You are in the optimal weight range.
----------Run #2----------------------
How much do you weigh in pounds? 
140
How tall are you in inches? 
76
Your Body Mass Index (BMI) is: 17.039473684210527
You are underweight.
----------Run #3----------------------
How much do you weigh in pounds? 
-243
How tall are you in inches? 
68
Both your height and weight you enter need to be positive values.
Please try again.
-------------------------------------*/