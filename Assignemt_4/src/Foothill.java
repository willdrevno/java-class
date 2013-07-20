import java.util.Scanner;
//importing scanner above
public class Foothill
{
   public static void main (String[] args)
   {
      int capacity, debit; //declaring variables
      double double_entered;
      String user_input, menu, initial_account, choice_str;
      char letter;
      boolean current_loop;
      Scanner input = new Scanner(System.in);
      capacity = 15; //capacity is the number of items left in someones account
      debit = 15; //debit is how much someone will pay for the current month
      current_loop = false; //set to false until someone hits quit
      choice_str = "Your choice: "; //string for giving user a choice
      menu = "Menu:" + "\nB (show Bill and starts new month)" 
      + "\nU (show Unused capacity for the current month)"
      + "\nC (Consume vending items now -- purchase candy bar, bag of " +
      "chips, etc.)" + "\nA (buy Additional items for current month)"
      + "\nQ (show bill and Quit)"; //user choices
      initial_account = "Welcome to the Foothill Vending Machine!" +
      "\nYour Account:" + " \n Unused items: " + 
      capacity + "\n Costs this month (so far): $" + debit;
      System.out.println(initial_account); //displayed when you first start up
      while (!current_loop) //runs until current loop is true
      {
         System.out.print("\n" + menu + "\n\n" + choice_str + "\n");
         user_input = input.nextLine();
         letter = user_input.charAt(0);
         if (letter == 'B' || letter == 'b') //triggered for the "bill" command
         {
            System.out.println("Closing bill for the month...");
            System.out.println("Unused items for the month (lost): " + capacity);
            System.out.println("Amount due for the month: $" + debit);
            System.out.println("\nNew month...");
            capacity = 15;
            debit = 15;
         }
         //triggered for the unused command
         else if (letter == 'U' || letter == 'u')
         {
            System.out.println("\nUnused items: " + capacity);
         }
         //triggered for the consume command
         else if (letter == 'C' || letter == 'c')
         {
            System.out.print("How many items do you want to consume?" +
            " \n(decimals will be rounded to the nearest whole number) ");
            user_input = input.nextLine();
            double_entered = Double.parseDouble(user_input);
            //double used so any numeric value could be accepted
            //checks to make sure number entered can be processed
            if (double_entered >= 1 && double_entered <= 10)
            {
               if (double_entered > capacity)
               {
                  //changes capacity and debit based on what user enters
                  capacity = capacity + 10;
                  debit = debit + 15;
               }
            capacity = capacity - (int)double_entered;
            }
            else
            {
               System.out.println("Invalid number entered. Please " +
               "enter a value from 1-10");
            }
         }
         //triggered by the add command
         else if (letter == 'A' || letter == 'a')
         {
            System.out.println("How many sets of 10 items would you like " +
            "to purchase (1-3)? \n(Decimals will be rounded " +
            "to the nearest whole number)");
            user_input = input.nextLine();
            //double used so any numeric value would be accepted
            double_entered = Double.parseDouble(user_input);
            if (double_entered >= 0 && double_entered <= 3)
            {
            capacity = capacity + ((int)double_entered*10);
            debit = debit + (11*(int)double_entered);
            }
            else
            {
               System.out.println("Invalid number entered. Please " +
               "enter a value from 1-3");
            }
         }
         //triggered by the quit command
         else if (letter == 'Q' || letter == 'q')
         {
            System.out.println("\n\nGoodbye!");
            current_loop = true;
         }
         else //brought up when there are invalid commands
         {
            System.out.println("\nPlease enter a valid input (Bill, " +
            "Unused, Consume, Add, Quit)");
         }
         //show anyway for quit command
         System.out.println("\n# of items available: " + capacity
         + "\nCosts this month (so far): " + debit);
      }
   }
}
/*-------------------Console------------------------
Welcome to the Foothill Vending Machine!
Your Account: 
 Unused items: 15
 Costs this month (so far): $15

Menu:
B (show Bill and starts new month)
U (show Unused capacity for the current month)
C (Consume vending items now -- purchase candy bar, bag of chips, etc.)
A (buy Additional items for current month)
Q (show bill and Quit)

Your choice: 
Unused

Unused items: 15

# of items available: 15
Costs this month (so far): 15

Menu:
B (show Bill and starts new month)
U (show Unused capacity for the current month)
C (Consume vending items now -- purchase candy bar, bag of chips, etc.)
A (buy Additional items for current month)
Q (show bill and Quit)

Your choice: 
fjaiowjefaoijv

Please enter a valid input (Bill, Unused, Consume, Add, Quit)

# of items available: 15
Costs this month (so far): 15

Menu:
B (show Bill and starts new month)
U (show Unused capacity for the current month)
C (Consume vending items now -- purchase candy bar, bag of chips, etc.)
A (buy Additional items for current month)
Q (show bill and Quit)

Your choice: 
con
How many items do you want to consume? 
(decimals will be rounded to the nearest whole number) 32
Invalid number entered. Please enter a value from 1-10

# of items available: 15
Costs this month (so far): 15

Menu:
B (show Bill and starts new month)
U (show Unused capacity for the current month)
C (Consume vending items now -- purchase candy bar, bag of chips, etc.)
A (buy Additional items for current month)
Q (show bill and Quit)

Your choice: 
c
How many items do you want to consume? 
(decimals will be rounded to the nearest whole number) 2

# of items available: 13
Costs this month (so far): 15

Menu:
B (show Bill and starts new month)
U (show Unused capacity for the current month)
C (Consume vending items now -- purchase candy bar, bag of chips, etc.)
A (buy Additional items for current month)
Q (show bill and Quit)

Your choice: 
u

Unused items: 13

# of items available: 13
Costs this month (so far): 15

Menu:
B (show Bill and starts new month)
U (show Unused capacity for the current month)
C (Consume vending items now -- purchase candy bar, bag of chips, etc.)
A (buy Additional items for current month)
Q (show bill and Quit)

Your choice: 
addddddd
How many sets of 10 items would you like to purchase (1-3)? 
(Decimals will be rounded to the nearest whole number)
2

# of items available: 33
Costs this month (so far): 37

Menu:
B (show Bill and starts new month)
U (show Unused capacity for the current month)
C (Consume vending items now -- purchase candy bar, bag of chips, etc.)
A (buy Additional items for current month)
Q (show bill and Quit)

Your choice: 
bill
Closing bill for the month...
Unused items for the month (lost): 33
Amount due for the month: $37

New month...

# of items available: 15
Costs this month (so far): 15

Menu:
B (show Bill and starts new month)
U (show Unused capacity for the current month)
C (Consume vending items now -- purchase candy bar, bag of chips, etc.)
A (buy Additional items for current month)
Q (show bill and Quit)

Your choice: 
add
How many sets of 10 items would you like to purchase (1-3)? 
(Decimals will be rounded to the nearest whole number)
32
Invalid number entered. Please enter a value from 1-3

# of items available: 15
Costs this month (so far): 15

Menu:
B (show Bill and starts new month)
U (show Unused capacity for the current month)
C (Consume vending items now -- purchase candy bar, bag of chips, etc.)
A (buy Additional items for current month)
Q (show bill and Quit)

Your choice: 
addit
How many sets of 10 items would you like to purchase (1-3)? 
(Decimals will be rounded to the nearest whole number)
2

# of items available: 35
Costs this month (so far): 37

Menu:
B (show Bill and starts new month)
U (show Unused capacity for the current month)
C (Consume vending items now -- purchase candy bar, bag of chips, etc.)
A (buy Additional items for current month)
Q (show bill and Quit)

Your choice: 
bill
Closing bill for the month...
Unused items for the month (lost): 35
Amount due for the month: $37

New month...

# of items available: 15
Costs this month (so far): 15

Menu:
B (show Bill and starts new month)
U (show Unused capacity for the current month)
C (Consume vending items now -- purchase candy bar, bag of chips, etc.)
A (buy Additional items for current month)
Q (show bill and Quit)

Your choice: 
con
How many items do you want to consume? 
(decimals will be rounded to the nearest whole number) 10

# of items available: 5
Costs this month (so far): 15

Menu:
B (show Bill and starts new month)
U (show Unused capacity for the current month)
C (Consume vending items now -- purchase candy bar, bag of chips, etc.)
A (buy Additional items for current month)
Q (show bill and Quit)

Your choice: 
quit


Goodbye!

# of items available: 5
Costs this month (so far): 15
----------------------------------------------------*/