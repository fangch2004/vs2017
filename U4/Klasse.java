import java.util.Scanner;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;

public class Klasse {
	public static void main(String[] args)
	{
	Beobachter o= new Beobachter("Datei.txt");
	o.start();
		/*
	Scanner sc= new Scanner(System.in);
	String str=sc.next();
    if (str=="stop")*/
	
		
   BufferedReader rr=new BufferedReader(new InputStreamReader(System.in)); 
   String komm; 
   try { 
       komm = rr.readLine(); 
       while (!komm.equals("stop"))
	   { 
              komm=rr.readLine(); 
       }    
    } 
   catch (IOException e) 
		{
		    e.printStackTrace();  
		} 
   o.interrupt();
  
	}
}