import java.util.Scanner;
//want to simulate a casino slot machine
//class to carry triple string
public class Foothill
{
   public static void main(String[] args)
   {
      int winnings, input_bet; //how much someone ends
      boolean pleaseend = false;
      TripleString roll;
      while (pleaseend == false) //checking to see if they want to quit
      {
         input_bet = getBet();
         roll = pull(); //pulling slot machine and get triplestring
         //if input_bet is 0 then winnings triggered to -1
         winnings = getmultiplier(roll, input_bet); //figure out winnings
         display(roll, winnings); //display result to user
         if (winnings == -1) //ends loop if winnings are -1 
         //(meaning input_bet) was 0
         {
            pleaseend = true;
         } 
      }
   }
   public static int getBet()
   {
      // output directions
      // get bet and store in class variable
      int input_bet = 0;
      boolean valid;
      valid = false;
      System.out.println("Place a bet between 1 and 100 or hit 0 to quit.");
      while (!valid)
      {
         Scanner user_input = new Scanner(System.in);
         input_bet = user_input.nextInt();
         if (input_bet >= 0 && input_bet <= 100)
         {
            valid = true;

         } 
         else
         // if not valid then user asked to try again
         {
            System.out.println("Make sure your bet is between 1 and 100. "
                  + "Try again.");
         }
      }
      return input_bet;
   }
   public static TripleString pull()
   {
      // instantiate triple string
      // reference random string
      TripleString user_role;
      user_role = new TripleString();
      String str1 = randString(), str2 = randString(), str3 = randString();
      user_role.setstrings(str1, str2, str3);
      return user_role; //outputs triplestring object as user roll
   }

   private static String randString()
   {
      String strvalue = "";
      double randvalue = Math.random(); //getting random variable
      //checking for what range our random variable produces
      //assigning string value based on it
      if (randvalue <= 0.5)
      {
         strvalue = "BAR";
         return strvalue;
      } 
      else if (randvalue <= .75)
      {
         strvalue = "cherries";
         return strvalue;
      } 
      else if (randvalue <= .875)
      {
         strvalue = "space";
         return strvalue;
      } else
      {
         strvalue = "7";
         return strvalue;
      }
   }

   public static int getmultiplier(TripleString result, int bet)
   {
      //figuring out multiplier based on certain matches
      int multiplier = 0, winnings = 0;
      if (result.getstr1() == "7" && result.getstr2() == "7"
            && result.getstr3() == "7")
      {
         multiplier = 100;
      } 
      else if (result.getstr1() == "BAR" && result.getstr2() == "BAR"
            && result.getstr3() == "BAR")
      {
         multiplier = 50;
      } 
      else if (result.getstr1() == "cherries"
            && result.getstr2() == "cherries" && result.getstr3() == "cherries")
      {
         multiplier = 30;
      } 
      else if (result.getstr1() == "cherries"
            && result.getstr2() == "cherries" && result.getstr3() != "cherries")
      {
         multiplier = 15;
      } 
      else if (result.getstr1() == "cherries"
            && result.getstr2() != "cherries")
      {
         multiplier = 5;
      } 
      else
      {
         multiplier = 0;
      }
      winnings = bet * multiplier; //multiply what they betted by multiplier
      if (bet == 0) //if input is 0 then winnings are -1 
      //to prompt end of program
      {
         winnings = -1;
      }
      return winnings;
   }

   public static void display(TripleString roll, int winnings)
   {
      //displays winnings if you won or lost
      
      if (winnings == 0)
      {
         System.out.println("You rolled: " + roll.getstr1() + " " + 
         roll.getstr2() + " " + roll.getstr3());
         System.out.println("Sorry you lost.\n");
      } 
      else if (winnings == -1)
      {
         System.out.println("Thanks for playing!");
      }
      else
      {
         System.out.println("You rolled: " + roll.getstr1() + " " + 
         roll.getstr2() + " " + roll.getstr3());
         System.out.println("You won: $" + winnings + "\nNice job!\n");
      }
   }
}
//holds slotmachine results
class TripleString
{
   // member data
   private String string1;
   private String string2;
   private String string3;
   int max_len;

   // default constructor
   TripleString()
   {
      string1 = "";// (int)(Math.random()*100);
      string2 = "";
      string3 = "";
      max_len = 20;
   }

   // checking validity of string
   private boolean validString(String str)
   {
      if (str.length() < max_len && str != "")
      {
         return true;
      } 
      else
      {
         return false;
      }
   }
   //setting strings and checking validity
   public boolean setstrings(String str1, String str2, String str3)
   {
      boolean isvalid1, isvalid2, isvalid3;
      isvalid1 = validString(str1);
      isvalid2 = validString(str2);
      isvalid3 = validString(str3);
      if (isvalid1 == true && (isvalid2 == true && (isvalid3 == true)))
      {
         string1 = str1;
         string2 = str2;
         string3 = str3;
         return true;
      } 
      else
      {
         return false;
      }
   }
   //methods to set private string variables
   public String getstr1()
   {
      return string1;
   }

   public String getstr2()
   {
      return string2;
   }

   public String getstr3()
   {
      return string3;
   }
}
/*-------------------Console output--------------
Place a bet between 1 and 100 or hit 0 to quit.
1
You rolled: cherries BAR space
You won: $5
Nice job!

Place a bet between 1 and 100 or hit 0 to quit.
2
You rolled: BAR 7 space
Sorry you lost.

Place a bet between 1 and 100 or hit 0 to quit.
3
You rolled: space cherries BAR
Sorry you lost.

Place a bet between 1 and 100 or hit 0 to quit.
4
You rolled: space space BAR
Sorry you lost.

Place a bet between 1 and 100 or hit 0 to quit.
5
You rolled: BAR BAR BAR
You won: $250
Nice job!

Place a bet between 1 and 100 or hit 0 to quit.
6
You rolled: cherries cherries space
You won: $90
Nice job!

Place a bet between 1 and 100 or hit 0 to quit.
7
You rolled: BAR BAR BAR
You won: $350
Nice job!

Place a bet between 1 and 100 or hit 0 to quit.
8
You rolled: BAR BAR BAR
You won: $400
Nice job!

Place a bet between 1 and 100 or hit 0 to quit.
9
You rolled: BAR BAR BAR
You won: $450
Nice job!

Place a bet between 1 and 100 or hit 0 to quit.
10
You rolled: BAR cherries BAR
Sorry you lost.

Place a bet between 1 and 100 or hit 0 to quit.
11
You rolled: cherries space BAR
You won: $55
Nice job!

Place a bet between 1 and 100 or hit 0 to quit.
12
You rolled: cherries cherries BAR
You won: $180
Nice job!

Place a bet between 1 and 100 or hit 0 to quit.
-3231
Make sure your bet is between 1 and 100. Try again.
14
You rolled: BAR cherries 7
Sorry you lost.

Place a bet between 1 and 100 or hit 0 to quit.
15
You rolled: cherries space BAR
You won: $75
Nice job!

Place a bet between 1 and 100 or hit 0 to quit.
16
You rolled: 7 BAR cherries
Sorry you lost.

Place a bet between 1 and 100 or hit 0 to quit.
17
You rolled: cherries 7 BAR
You won: $85
Nice job!

Place a bet between 1 and 100 or hit 0 to quit.
18
You rolled: BAR cherries BAR
Sorry you lost.

Place a bet between 1 and 100 or hit 0 to quit.
19
You rolled: space cherries 7
Sorry you lost.

Place a bet between 1 and 100 or hit 0 to quit.
242
Make sure your bet is between 1 and 100. Try again.
52
You rolled: BAR space space
Sorry you lost.

Place a bet between 1 and 100 or hit 0 to quit.
20
You rolled: space cherries BAR
Sorry you lost.

Place a bet between 1 and 100 or hit 0 to quit.
10
You rolled: space cherries BAR
Sorry you lost.

Place a bet between 1 and 100 or hit 0 to quit.
33
You rolled: BAR space cherries
Sorry you lost.

Place a bet between 1 and 100 or hit 0 to quit.
33
You rolled: BAR cherries BAR
Sorry you lost.

Place a bet between 1 and 100 or hit 0 to quit.

34
You rolled: BAR BAR cherries
Sorry you lost.

Place a bet between 1 and 100 or hit 0 to quit.
42
You rolled: space cherries BAR
Sorry you lost.

Place a bet between 1 and 100 or hit 0 to quit.
2
You rolled: BAR BAR BAR
You won: $100
Nice job!

Place a bet between 1 and 100 or hit 0 to quit.
0
Thanks for playing!
------------------------------------------------*/