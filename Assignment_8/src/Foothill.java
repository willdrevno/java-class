public class Foothill
{
   public static void main(String[] args)
   {
      //setting up variables and instantiating objects
      DateProfile applicant1, applicant2, applicant3, applicant4;
      String applicantname, matchname;
      double matchscore;
      applicant1 = new DateProfile();
      applicant2 = new DateProfile();
      applicant3 = new DateProfile();
      applicant4 = new DateProfile();
      //putting dummy data in
      applicant1.setAll("Miley Cyrus", 'F', 'M', 3, 1);
      applicant2.setAll("Justin Bieber", 'M', 'F', 9, 2);
      applicant3.setAll("Kanye West", 'M', 'F', 2, 6);
      applicant4.setAll("Kim Kardashian", 'F', 'M', 5, 5);
      DateProfile[] applicant = {applicant1,applicant2, 
            applicant3, applicant4};
      System.out.println("Welcome to the matchmaker!");
      System.out.println("Here are the results:");
      //do two for loops to cycle through list of applicants
      //calculates match with each applicant that shows up in inner loop
      for (int k = 0; k < applicant.length; k++)
      {
         applicantname = applicant[k].getName();
         System.out.println(applicantname);
         for (int i = 0; i < applicant.length; i++)
         {
            matchname = applicant[i].getName();
            matchscore = applicant[k].fitValue(applicant[i]);
            //outputs string to console based on the applicant and match
            System.out.println("  " + matchname + " fit: " + matchscore);
         }
         
      }
   }
}
class DateProfile
{
   private char gender;
   private char searchGender;
   private int romance;
   private int finance;
   private String name;
   DateProfile()
   {
      gender = 'M';
      searchGender = 'F';
      romance = 1;
      finance = 1;
      name = "undefined";
   }
   //checking validity of everything before stored in variables
   private boolean checkGender(int gendercheck)
   {
      if (gendercheck == 'M' || gendercheck == 'F')
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   private boolean checksearchGender(int searchgendercheck)
   {
      if (searchgendercheck == 'M' || searchgendercheck == 'F')
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   private boolean checkint(int checkint)
   {
      if (checkint >= 1 && checkint <= 10)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   //get and set methods
   //set methods check for validity
   public char getGender()
   {
      return gender;
   }
   public boolean setGender(char gender)
   {
      if (checkGender(gender) == true)
      {
         this.gender = gender;
         return true;
      }
      else
      {
         return false;
      }
   }
   public char getSearchGender()
   {
      return searchGender;
   }
   public boolean setSearchGender(char searchGender)
   {
      if (checksearchGender(searchGender) == true)
      {
         this.searchGender = searchGender;
         return true;
      }
      else
      {
         return false;
      }
   }
   public int getRomance()
   {
      return romance;
   }
   public boolean setRomance(int romance)
   {
      if (checkint(romance) == true)
      {
         this.romance = romance;
         return true;
      }
      else
      {
         return false;
      }
   }
   public int getFinance()
   {
      return finance;
   }
   public boolean setFinance(int finance)
   {
      if (checkint(finance) == true)
      {
         this.finance = finance;
         return true;
      }
      else
      {
         return false;
      }
   }
   public String getName()
   {
      return name;
   }
   public boolean setName(String name)
   {
      this.name = name;
      return true;
   }
   //set all values at once, also checks validity
   public boolean setAll(String name, char gender, char searchgender, 
         int romance, int finance)
   {
      if (setGender(gender) == true && setSearchGender(searchgender) == true 
            && setRomance(romance) == true && setFinance(finance) == true)
      {
         setGender(gender);
         setSearchGender(searchgender);
         setRomance(romance);
         setFinance(finance);
         setName(name);
         return true;
      }
      else
      {
         return false;
      }
   }
   private double determineRomanceFit(DateProfile partner)
   {
      int romancedifference;
      romancedifference = Math.abs(partner.getRomance()-romance);
      //returns 1 if exact match
      if (romancedifference == 0)
         return 1.0;
      //returns 0.5 if moderate match
      else if (romancedifference <=  8)
         return 0.5;
      //returns 0.1 if really far away match
      else
         return 0.1;
   }
   private double determineFinanceFit(DateProfile partner)
   {
      int financedifference;
      financedifference = Math.abs(partner.getFinance()-finance);
      //financial fit score uses the same ranges as romance fit
      if (financedifference == 0)
         return 1.0;
      else if (financedifference <=  8)
         return 0.5;
      else
         return 0.1;
   }
   private double determineGenderFit(DateProfile partner)
   {
      //either 0 or 1 depending if desired genders match
      if (partner.getGender() == searchGender)
         return 1;
      else
         return 0;
   }
   public double fitValue(DateProfile partner)
   {
      //multiplies all fitvalues together
      double fitvalue;
      fitvalue = determineRomanceFit(partner)*determineFinanceFit(partner)*
            determineGenderFit(partner);
      return fitvalue;
   }
}
/*-----------Console Output--------------
Welcome to the matchmaker!
Here are the results:
Miley Cyrus
  Miley Cyrus fit: 0.0
  Justin Bieber fit: 0.25
  Kanye West fit: 0.25
  Kim Kardashian fit: 0.0
Justin Bieber
  Miley Cyrus fit: 0.25
  Justin Bieber fit: 0.0
  Kanye West fit: 0.0
  Kim Kardashian fit: 0.25
Kanye West
  Miley Cyrus fit: 0.25
  Justin Bieber fit: 0.0
  Kanye West fit: 0.0
  Kim Kardashian fit: 0.25
Kim Kardashian
  Miley Cyrus fit: 0.0
  Justin Bieber fit: 0.25
  Kanye West fit: 0.25
  Kim Kardashian fit: 0.0
-----------------------------------------*/
   