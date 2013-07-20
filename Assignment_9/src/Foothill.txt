import java.util.Scanner;
public class Foothill
{
   public static void main (String[] args)
   {
      //declare variables
      String toppings;
      toppings = PizzaOrder.toppingsOffered[0];
      boolean checksize = true;
      boolean checktoppings = true;
      int size = -1;
      PizzaOrder pizza;
      pizza = new PizzaOrder();
      //get size of pizza
      while (checksize == true)
      {
         System.out.println("Enter Size of pizza ('s', 'm', 'l') " +
         		"or 'q' to quit:");
         size = getSizefromUser();
         
         if (size == 3) //quit
         {
            System.out.println("Goodbye!");
            checksize = false;
         }
         else if (size == 4) //error
         {
            System.out.println("Please try again");
         }
         else //valid size was entered
         {
            pizza.setSize(size);
            System.out.println("Current Pizza: " + pizza.stringizeSize());
            checktoppings = true;
            //gets toppings
            while (checktoppings == true)
            {
               int topping_input;
               displaymenu();
               System.out.println("Select topping (or press 0 to order): ");
               Scanner user_input = new Scanner(System.in);
               topping_input = user_input.nextInt();
               //checks validity of number entered
               if (topping_input
                     < PizzaOrder.toppingsOffered.length+1 && topping_input > 0)
               {
                  pizza.addToppings(topping_input-1);
                  System.out.println("Current Pizza: " + pizza.stringizeSize()
                        + pizza.getToppings());
               }
               else if (topping_input == 0)
               {
                  pizza.displayPizza();
                  pizza.resettoppings();
                  checktoppings = false;
               }
               //if not valid then you do it again
               else
               {
                  System.out.println("Please try again.");
               }
            }
         }          
      }
      checksize = false;
   }
   static int getSizefromUser()
   {
      //gets size from user
      String size_input = "null";
      char pizzasize = 'x';
      Scanner user_input = new Scanner(System.in);
      size_input = user_input.next();
      pizzasize = size_input.charAt(0);
      if (pizzasize == 's' || pizzasize == 'S')
      {
         return 0;
      }
      else if (pizzasize == 'm' || pizzasize == 'M')
      {
         return 1;
      }
      else if (pizzasize == 'l' || pizzasize == 'L')
      {
         return 2;
      }
      else if (pizzasize == 'q' || pizzasize == 'Q')
      {
         return 3;
      }
      else
      {
         return 4;
      }
   }
   static void displaymenu()
   {
      //displays menu of toppings
      for (int i = 0; i < PizzaOrder.toppingsOffered.length; i++)
      {
         int j;
         j = i+1;
         System.out.println(j + ". " + PizzaOrder.toppingsOffered[i]);
      }
   }
}

class PizzaOrder
{
   public static String[] toppingsOffered = { "onions", 
      "bell peppers", "olives", "pepperoni"};
   public static double toppingsBaseCost = 2;
   public static double basePrice = 10;
   private int numToppings = 0;
   private int size = 1;
   private String[] toppings;
   //constructor
   PizzaOrder()
   {
      size = 0;
   }
   public boolean setSize(int input_size) //sets size after checking validity
   {
      if (validSize(input_size) == true)
      {
         size = input_size;
         return true;
      }
      else
      {
         return false;
      }
   }
   private boolean validSize(int sizeinput) //checks validity of size
   {
      if (sizeinput > 0 || sizeinput < 4)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   public int getSize()
   {
      return size;
   }
   private boolean validaddToppings(int n)//checks validity of topping
   {
      if (n < toppingsOffered.length && n >= 0)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   public boolean addToppings(int n)//adds toppings after checking validity
   {
      if (validaddToppings(n) == true)
      {
         //since array size has to be set when varialbe set
         //need to save toppings to temporary array while array size is changed
         if (toppings == null)
         {
            toppings = new String[1];
            String topping;
            topping = toppingsOffered[n];
            toppings[0] = topping;
         }
         else
         {
            String[] temptoppings;
            temptoppings = new String[toppings.length+1];
            for (int i = 0; i < toppings.length; i++)
            {
               temptoppings[i] = toppings[i];
            }
            temptoppings[toppings.length] = toppingsOffered[n];
            toppings = new String[temptoppings.length];
            for (int i = 0; i < temptoppings.length; i++)
            {
               toppings[i] = temptoppings[i];
            }
         }
         numToppings++;
         return true;
      }
      else
      {
         return false;
      }
   }
   public double getPrice()
   {
      //calculates price based on factors given
      if (getSize() == 0)
      {
         return basePrice + numToppings*toppingsBaseCost;
      }
      else if (getSize() == 1)
      {
         return basePrice*1.15 + numToppings*toppingsBaseCost;
      }
      else
      {
         return basePrice*1.25 + numToppings*toppingsBaseCost;
      }
   }
   public String stringizeSize()//turns size into string
   {
      if (size == 0)
      {
         return "small";
      }
      else if (size == 1)
      {
         return "medium";
      }
      else
      {
         return "large";
      }
   }
   public String getToppings() //gets toppings
   {
      String listoftoppings = "";
      for (int i=0; i < toppings.length; i++)
      {
         listoftoppings = listoftoppings + " + " + toppings[i];
      }
      return listoftoppings;
   }
   public boolean resettoppings() //resests topping after user exits pizza
   {
      toppings = new String[0];
      numToppings = 0;
      return true;
   }
   public void displayPizza() //displays order and gives price
   {
      System.out.println("Order: " + stringizeSize() + getToppings());
      System.out.println("Price: " + getPrice());
   }
}
/*------------Console Output----------------------
Enter Size of pizza ('s', 'm', 'l') or 'q' to quit:
m
Current Pizza: medium
1. onions
2. bell peppers
3. olives
4. pepperoni
Select topping (or press 0 to order): 
1
Current Pizza: medium + onions
1. onions
2. bell peppers
3. olives
4. pepperoni
Select topping (or press 0 to order): 
4
Current Pizza: medium + onions + pepperoni
1. onions
2. bell peppers
3. olives
4. pepperoni
Select topping (or press 0 to order): 
5
Please try again.
1. onions
2. bell peppers
3. olives
4. pepperoni
Select topping (or press 0 to order): 
0
Order: medium + onions + pepperoni
Price: 15.5
Enter Size of pizza ('s', 'm', 'l') or 'q' to quit:
s
Current Pizza: small
1. onions
2. bell peppers
3. olives
4. pepperoni
Select topping (or press 0 to order): 
2
Current Pizza: small + bell peppers
1. onions
2. bell peppers
3. olives
4. pepperoni
Select topping (or press 0 to order): 
0
Order: small + bell peppers
Price: 12.0
Enter Size of pizza ('s', 'm', 'l') or 'q' to quit:
j
Please try again
Enter Size of pizza ('s', 'm', 'l') or 'q' to quit:
q
Goodbye!
--------------------------------------------------*/