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
	public static void pruefen()
	{
	   System.out.println("bitte Zeichenkette eingeben:");
	   Scanner sc = new Scanner(System.in);
	   String str = sc.next(); 
       char[] charArray = str.toCharArray();
	   int index= (Integer)(charArray.length/2)+1;
       // assume there are odd chars in the word given as input
			for(int i=charArray.length-1; i>=index ;i--) 
    	 {
			if( charArray[i]==charArray[charArray.length-1-i])
				continue;
			else
				System.out.print("kein palindrom");
				return;
		 }
	    System.out.println("palindrom entdeckt");
	}
  public static void main	(String[] args){
	  umdrehen();
	  pruefen();
	  
  }
}