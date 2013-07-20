public class Foothill
{
   public static void main(String[] args) throws Exception
   {
      // declare the references
      Galaxy gal_1, gal_2;
      
      // instantiate the objects
      gal_1 = new Galaxy();
      gal_2 = new Galaxy();
      
      // try to set the data
      gal_1.SetName("X");
      gal_1.SetMagnitude(100);
      gal_2.SetName("Stephan's Third");
      gal_2.SetMagnitude(13.2);
      
      // let's see what happened
      System.out.println("Gal #1 name: " +  gal_1.GetName() );
      System.out.println("Gal #1 mag: " +  gal_1.GetMagnitude() );
      System.out.println("Gal #2 name: " +  gal_2.GetName() );
      System.out.println("Gal #2 mag: " +  gal_2.GetMagnitude() );
   }
}

class Galaxy
{
   // member data
   private String name;
   private double magnitude;
      
   // default constructor
   Galaxy()
   {
      name = "undefined";
      magnitude = 0.0;   
   }
  
   // 2-parameter constructor (to be discussed)
   Galaxy(String my_name, double my_mag)
   {
      if (my_name.length() > 2)
         name = my_name;
      else
         name = "undefined";
      if (my_mag >= -3 && my_mag <= 30)
         magnitude = my_mag;
      else
         magnitude = 0.0;   
   }
   
   // accessor "set" method -------------------------------
   public boolean SetMagnitude(double mag)
   {
      if (mag < -3 || mag > 30)
         return false;
      // else
      magnitude = mag;
      return true; 
   }

   public boolean SetName(String theName)
   {
      if (theName == null || theName.length() < 2)
         return false;
      // else we fall through
      name = theName;
      return true;
   }

   // accessor "get" methods --------------------------------
   public String GetName()
   {
     return name;
   }
   public double GetMagnitude()
   {
      return magnitude;
   }
}

/* ------------------ Paste of Run from Above Program ----------

Gal #1 name: undefined
Gal #1 mag: 0.0
Gal #2 name: Stephan's Third
Gal #2 mag: 13.2

---------------------------------------------------------------- */