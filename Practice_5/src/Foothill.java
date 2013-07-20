 
import java.util.Scanner;
import java.text.*;
import java.util.*;

public class Foothill
{
   
   // class variables shared by more than one method
   static double dblPrincipal, dblRate, dblYears;
   
   // main method
   public static void main (String[] args)
   {
      double answer;
   
      StateInstructions();
      GetInput();
      answer = ComputeMonthlyPayment();    
      ReportResults(answer);
   }

   // gives an overview to user
   public static void StateInstructions()
   {
      String instructions;
      
      instructions = 
         "The following program will calculate the \n"
         + "monthly payment  required for a loan of D dollars \n"
         + "over a period of Y years at an annual \n"
         + "interest rate of R%.";
      System.out.println(instructions);
      System.out.println("---------------\n");
   }
   
   // gets input, stores in static class variables
   public static void GetInput()
   {
      Scanner input = new Scanner(System.in);
      String prompt, strUserResponse;
   
      // get principal
      prompt = "\nEnter amount of the loan. (only use numbers, \n"
         + "please, no commas or characters like '$')\n"
         + "Your loan amount: ";
      System.out.print(prompt);
      strUserResponse = input.nextLine();
      dblPrincipal = Double.parseDouble(strUserResponse);
      
      // get interest
      prompt = "\nNow enter the interest rate (If the quoted rate is "
         + " 6.5%, \nfor example, enter 6.5 without the %.)\n"
         + "Your annual interest rate: ";
      System.out.print(prompt);
      strUserResponse = input.nextLine();
      dblRate = Double.parseDouble(strUserResponse);

      // get length of loan
      prompt = "\nEnter term of the loan in years: ";
      System.out.print(prompt);
      strUserResponse = input.nextLine();
      dblYears = Double.parseDouble(strUserResponse);
  }
   
   // computes and returns answer
   public static double ComputeMonthlyPayment()
   {
      // local variables needed only in this method
      double dblTemp, dblPmt, dblMonths, dblMoRt;
           
      // convert to years months
      dblMonths = dblYears * 12;
      
      // convert rate to decimal and months
      dblMoRt = dblRate / (100 * 12);
      
      // use formula to get result
      dblTemp = Math.pow(1 + dblMoRt, dblMonths);
      dblPmt = dblPrincipal * dblMoRt * dblTemp 
         / ( dblTemp - 1 );
      
      // now that we have computed the payment, return it
      return dblPmt;
  }
   
   // sign off
   public static void ReportResults(double result)
   {
      String signoff;
      NumberFormat bucks = 
         NumberFormat.getCurrencyInstance(Locale.US);
      
      signoff = 
         "\nThanks for using the Foothill Mortgage Calculator. \n"
         + "We hope you'll come back and see us again, soon.";
      
      System.out.println("Monthly Payment: " 
            + bucks.format(result));
      System.out.println(signoff);
   }
}