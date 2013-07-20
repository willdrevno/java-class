import java.util.Scanner;

public class Foothill
{
   // declare a (rare) global that can be used by all for console input
   static Scanner input_stream = new Scanner(System.in);
   // -------  main --------------
   public static void main(String[] args)
   {
      // variables to capture input
      String user_name;
      double user_temp;
      int user_id;
      
      // Patient objects
      Patient person_1 = new Patient();
      Patient person_2 = new Patient();

      // get the info for patient #1:
      System.out.println("Patient #1 ---");
      // we built three helper methods for this
      user_name = GetPatientName();
      user_id = GetPatientID();
      user_temp = GetPatientTemp();

      // set patient #1
      if ( !person_1.SetName(user_name) )
         System.out.println("Error in patient name: Invalid length.");
      if ( !person_1.SetID(user_id) )
         System.out.println("Error in patient id: out of range.");
      if ( !person_1.SetTemperature(user_temp) )
         System.out.println("Error in patient temperature:  out of range.");

      // get the info for patient #2:
      System.out.println("Patient #2 ---");
      user_name = GetPatientName();
      user_id = GetPatientID();
      user_temp = GetPatientTemp();

      // set patient #2
      if ( !person_2.SetName(user_name) )
         System.out.println("Error in patient name: Invalid length.");
      if ( !person_2.SetID(user_id) )
         System.out.println("Error in patient id: out of range.");
      if ( !person_2.SetTemperature(user_temp) )
         System.out.println("Error in patient temperature:  out of range.");

      // display patients
      person_1.Display();
      person_2.Display();
   }
   
   // main methods (non-Patient methods)
   static String GetPatientName()
   {
      String string_in;
      
      System.out.print("What's the patient's name? ");
      string_in = input_stream.nextLine();
      return string_in;
   }

   static int GetPatientID()
   {
      int id;
      String string_in;

      System.out.print("What's the patient's id #? ");
      string_in = input_stream.nextLine();
      id = Integer.parseInt(string_in);
      return id;
   }

   static double GetPatientTemp()
   {
      double temp;
      String string_in;
      
      System.out.print("What's the patient's temperature? ");
      string_in = input_stream.nextLine();
      temp = Double.parseDouble(string_in);
      return temp;
   }
}

class Patient
{
   // static data
   public static final int MIN_LENGTH = 2;
   public static final int MAX_LENGTH = 40;
   public static final int MIN_ID = 0;
   public static final int MAX_ID = 9999;
   public static final double MIN_TEMP = 88.; 
   public static final double MAX_TEMP = 111;
   public static final double ALARM_TEMP = 103.5;
   
   // instance data
   private String name;
   private int id;
   private double temperature;
   
   public Patient()
   {
      SetName("nobody");
      SetTemperature(98.6);
      SetID(0);
   }
   
   public void Display()
   {
      System.out.println("Patient: "
         + "\n  Name: " + name
         + "\n  ID: " + id
         + "\n  Body Temperature: " + temperature + " (F)");
   }
   
   // ONLY Accessors can be done on single line:
   double GetTemperature() { return temperature; }
   int GetID() { return id; }
   String GetName() { return name; }
   
   // mutators
   boolean SetTemperature(double temperature)
   {
      if (temperature < MIN_TEMP || temperature > MAX_TEMP)
         return false;
      this.temperature = temperature;
      return true;
   }

   boolean SetID(int id)
   {
      if (id < MIN_ID || id > MAX_ID)
         return false;
      this.id = id;
      return true;
   }

   boolean SetName( String name)
   {
      if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH)
         return false;
      this.name = name;
      return true;
   }  
}

/* ------------- RUN 1 (OUTPUT) ----------------------
Patient #1 ---
What's the patient's name? aa aa
What's the patient's id #? 111
What's the patient's temperature? 99.1
Patient #2 ---
What's the patient's name? bb bb
What's the patient's id #? 222
What's the patient's temperature? 102.5
Patient: 
  Name: aa aa
  ID: 111
  Body Temperature: 99.1 (F)
Patient: 
  Name: bb bb
  ID: 222
  Body Temperature: 102.5 (F)
--------------- END OF RUN 1 ------------------------- */

/* ------------- RUN 2 (OUTPUT) ----------------------
Patient #1 ---
What's the patient's name? bad bad
What's the patient's id #? 912319
What's the patient's temperature? 999.3
Error in patient id: out of range.
Error in patient temperature:  out of range.
Patient #2 ---
What's the patient's name? good good
What's the patient's id #? 555
What's the patient's temperature? 98.1
Patient: 
  Name: bad bad
  ID: 0
  Body Temperature: 98.6 (F)
Patient: 
  Name: good good
  ID: 555
  Body Temperature: 98.1 (F)
--------------- END OF RUN 2 ------------------------- */