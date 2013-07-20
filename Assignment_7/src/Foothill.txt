public class Foothill
{
   public static void main(String[] args)
   {
      iTunes song1, song2, song3, song4;
      //instantiating songs
      song1 = new iTunes();
      song2 = new iTunes();
      song3 = new iTunes();
      song4 = new iTunes();
      //Each of the following sections display a song (or just the default)
      //then makes some changes to it and displays it again
      //Song 1 section
      System.out.println("<---Song 1 Test--->");
      song1.display();
      song1.setname("Get Lucky");
      song1.display();
      System.out.println("<-End Song 1 Test->\n");
      //Song 2 section
      System.out.println("<---Song 2 Test--->");
      song2.addsong("Foothill", "Drevno", 89, 12000);
      song2.display();
      song2.setbitrate(156);
      song2.display();
      System.out.println("<-End Song 2 Test->\n");
      //Song 3 section
      System.out.println("<---Song 3 Test--->");
      song3.setname("Berkeley");
      song3.display();
      song3.addsong("UC Berkeley", "California", 77, 1912);
      song3.display();
      System.out.println("<-End Song 3 Test->\n");
      //Song 4 Section
      System.out.println("<---Song 4 Test--->");
      song4.setartist("Eminem");
      song4.setplaytime(1049);
      song4.addsong("Good Songs", "Snoop Lion", 99, 36000);
      song4.display();
      song4.addsong("Gangam Style", "Lil Wayne", 179, 9891);
      song4.display();
      System.out.println("<-End Song 4 Test->\n");
      System.out.println("<<--End of Song Tests-->>");
      //if statements wrapped with mutators to test invalid values
      if (!song4.setbitrate(1)) //not valid because minimum bitrate is 64
      {
         System.out.println("The bitrate for song 4 was " +
         		"not in the acceptable range.");
      }
      else
      {
         System.out.println("It worked! The bitrate for song 4 is " +
         		"now changed.");
      }
      if (!song2.setplaytime(200))//not valid because minimum play time is 1000
      {
         System.out.println("The play time for song 2 was " +
         		"not in the acceptable range.");
      }
      else
      {
         System.out.println("It worked! The play time for song 2 is " +
         		"now chaged.");
      }
      //testing accessors
      System.out.println("Song 1 Bitrate: " + song1.getbitrate());
      System.out.println("Song 3 Name: " + song3.getname());
      System.out.println("Song 4 Artist: " + song4.getartist());
   }
}
class iTunes
{
   //set as private to protect members from invalid entries
   private String name;
   private String artist;
   private int bitrate;
   private int totaltime;
   //static because we want to keep them the same across all song objects
   static int minbitrate = 64;
   static int maxbitrate = 705;
   static int min_str_length = 1;
   static int max_str_length = 80;
   static int min_play_time = 1000;
   static int max_play_time = 1000*60*60;
   static int default_bitrate = 64;
   static int default_playtime = 1000;
   static String default_string = "(undefined)";
   iTunes()
   {
      name = default_string;
      artist = default_string;
      bitrate = default_bitrate;
      totaltime = default_playtime;
   }
   //checks to see if bitrate is in the acceptable range
   private boolean validbitrate(int bitcheck)
   {
      if (bitcheck <= maxbitrate && bitcheck >= minbitrate)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   //checks to see if artist or song name isn't too long or too short
   private boolean validstr(String strcheck)
   {
      if (strcheck.length() >= min_str_length && 
            strcheck.length() <= max_str_length)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   //checks to see if play time for song isn't too long or too short
   private boolean validplaytime(int playcheck)
   {
      if (playcheck >= min_play_time && playcheck <= max_play_time)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   public String getname()
   {
      return name;
   }
   //accessors
   public String getartist()
   {
      return artist;
   }
   public int getbitrate()
   {
      return bitrate;
   }
   public int getplaytime()
   {
      return totaltime;
   }
   //mutators
   //each mutators checks validity before assigning to members
   public boolean setname(String client_name)
   {
      if (validstr(client_name) == true)
      {
         name = client_name;
         return true;
      }
      else
      {
         return false;
      }
   }
   public boolean setartist(String client_artist)
   {
      if (validstr(client_artist) == true)
      {
         artist = client_artist;
         return true;
      }
      else
      {
         return false;
      }
   }
   public boolean setbitrate(int client_bitrate)
   {
      if (validbitrate(client_bitrate) == true)
      {
         bitrate = client_bitrate;
         return true;
      }
      else
      {
         return false;
      }
   }
   public boolean setplaytime(int client_playtime)
   {
      if (validplaytime(client_playtime) == true)
      {
         totaltime = client_playtime;
         return true;
      }
      else
      {
         return false;
      }
   }
   //constructor that allows you to change members all at once
   public boolean addsong(String client_name, String client_artist, 
         int client_bitrate, int client_playtime)
   {
      setname(client_name);
      setartist(client_artist);
      setbitrate(client_bitrate);
      setplaytime(client_playtime);
      return true;
   }
   public String toString() //nicely formats song information
   {
      String allsonginfo;
      allsonginfo = "Song: " + name + "\nArtist: " + artist + 
            "\nPlay time: " + totaltime + " milliseconds" + "\nBitrate: " + 
            bitrate + "k"; 
      //input variables
      return allsonginfo;   
   }
   public void display() //displays song information to console
   {
      System.out.println(toString());
      System.out.println("---------");
   }
}
/*---------------------------Console Output---------------------
<---Song 1 Test--->
Song: (undefined)
Artist: (undefined)
Play time: 1000 milliseconds
Bitrate: 64k
---------
Song: Get Lucky
Artist: (undefined)
Play time: 1000 milliseconds
Bitrate: 64k
---------
<-End Song 1 Test->

<---Song 2 Test--->
Song: Foothill
Artist: Drevno
Play time: 12000 milliseconds
Bitrate: 89k
---------
Song: Foothill
Artist: Drevno
Play time: 12000 milliseconds
Bitrate: 156k
---------
<-End Song 2 Test->

<---Song 3 Test--->
Song: Berkeley
Artist: (undefined)
Play time: 1000 milliseconds
Bitrate: 64k
---------
Song: UC Berkeley
Artist: California
Play time: 1912 milliseconds
Bitrate: 77k
---------
<-End Song 3 Test->

<---Song 4 Test--->
Song: Good Songs
Artist: Snoop Lion
Play time: 36000 milliseconds
Bitrate: 99k
---------
Song: Gangam Style
Artist: Lil Wayne
Play time: 9891 milliseconds
Bitrate: 179k
---------
<-End Song 4 Test->

<<--End of Song Tests-->>
The bitrate for song 4 was not in the acceptable range.
The play time for song 2 was not in the acceptable range.
Song 1 Bitrate: 64
Song 3 Name: UC Berkeley
Song 4 Artist: Lil Wayne

-----------------------------End Console Output---------------*/