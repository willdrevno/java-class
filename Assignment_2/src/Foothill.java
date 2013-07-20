public class Foothill 
{
   public static void main(String[] args)
   {  
      int n; //declaring variables in next few lines
      double first_expression;
      double second_expression;
      double third_expression;
      double fourth_expression;
      n = 3; //when n = 3
      first_expression = 2+3+4; //2+3+...+(n+1)
      second_expression = ((n+1)*(n+2)/2)-7; //((n+1)*(n+2)/ 2)-7
      third_expression = 3+5; //3+5+...+(2n - 1)
      fourth_expression = (n*n)-5;//(n^2)-5
      System.out.println("When n = " + n + ":");
      System.out.println("2+3+ ... +(n+1)= " + first_expression);
      System.out.println("((n+1)*(n+2)/2)-7= " + second_expression);
      System.out.println("3+5+ ... +(2n-1)= " + third_expression);
      System.out.println("(n^2)-5= " + fourth_expression);
      System.out.println("------------------------------------------");
      n = 6; //when n = 6
      first_expression = 2+3+4+5+6+7;//2+3+...+(n+1)
      second_expression = ((n+1)*(n+2)/2)-7;//((n+1)*(n+2)/ 2)-7
      third_expression = 3+5+7+9+11;//3+5+...+(2n - 1)
      fourth_expression = (n*n)-5;//(n^2)-5
      System.out.println("When n = " + n + ":");
      System.out.println("2+3+ ... +(n+1)= " + first_expression);
      System.out.println("((n+1)*(n+2)/2)-7= " + second_expression);
      System.out.println("3+5+ ... +(2n-1)= " + third_expression);
      System.out.println("(n^2)-5= " + fourth_expression);
      System.out.println("------------------------------------------");
      n = 11; //n = 11
      first_expression = 2+3+4+5+6+7+8+9+10+11+12;//2+3+...+(n+1)
      second_expression = ((n+1)*(n+2)/2)-7;//((n+1)*(n+2)/ 2)-7
      third_expression = 3+5+7+9+11+13+15+19+21+23;//3+5+...+(2n - 1)
      fourth_expression = (n*n)-5;//(n^2)-5
      System.out.println("When n = " + n + ":");
      System.out.println("2+3+ ... +(n+1)= " + first_expression);
      System.out.println("((n+1)*(n+2)/2)-7= " + second_expression);
      System.out.println("3+5+ ... +(2n-1)= " + third_expression);
      System.out.println("(n^2)-5= " + fourth_expression);
      System.out.println("------------------------------------------");
   }
}
/*-----Paste of Run From Console Window-------
When n = 3:
2+3+ ... +(n+1)= 9.0
((n+1)*(n+2)/2)-7= 3.0
3+5+ ... +(2n-1)= 8.0
(n^2)-5= 4.0
------------------------------------------
When n = 6:
2+3+ ... +(n+1)= 27.0
((n+1)*(n+2)/2)-7= 21.0
3+5+ ... +(2n-1)= 35.0
(n^2)-5= 31.0
------------------------------------------
When n = 11:
2+3+ ... +(n+1)= 77.0
((n+1)*(n+2)/2)-7= 71.0
3+5+ ... +(2n-1)= 126.0
(n^2)-5= 116.0
------------------------------------------
-------------------------------------------*/

