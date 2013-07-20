public class Foothill 
{
   public static void main(String[] args)
   {             
      // declare some string references (variables)
      String thx_mom, thx_agent, thx_fox;
      String output_string;
      
      // for fun, create the String object directly in the declaration
      String acceptance_speech = new String("I'd like to thank ");
     
      // create the rest of the  string objects to use 
      // in your speech.
      thx_mom = new String("my Mother, Reva, and wife Coleen.");
      thx_fox = new String("everyone at Fox and FBC.");
      thx_agent = new String("my agent and everyone at Paradigm.");
 
      // stand up at the podium and get settled ...
      // for this use String Literals directly in the
      // output statements.
      System.out.println( 
         "I didn't really expect to win ...");
      System.out.println( 
         "I don't even have a speech prepared!");
      System.out.println( "Anyway ...");
 
      // now finally start to thank people.
      output_string = "First of all " + acceptance_speech + thx_fox;
      System.out.println( output_string);
  
      output_string = "Next, " + acceptance_speech + thx_agent;
      System.out.println( output_string);
 
      output_string = "But mostly, " + acceptance_speech + thx_mom;
      System.out.println( output_string); 
   }
}