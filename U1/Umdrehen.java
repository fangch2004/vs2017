import java.util.Scanner;

public class Umdrehen{
   public static void umdrehen(){
	   System.out.println("bitte Zeichenkette eingeben:");
	   Scanner sc = new Scanner(System.in);
	   
	   String str = sc.next(); 
       char[] charArray = str.toCharArray();
	   for(int i=charArray.length-1; i>=0 ;i--)
	   {
//	   System.out.print(char[i]);
	System.out.print(charArray[i]);
	   }
   }
  public static void main	(String[] args){
	  umdrehen();
  }
}