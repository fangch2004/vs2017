import java.io.FileReader;
import java.util.Scanner;

	
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StreamTokenizer;

public class Messwert{
    
    public static void main(String [] args){
        try{
         FileReader fr = new FileReader("messw.txt");
         Scanner sc= new Scanner(fr);
         String mstelle=null;
         int anz=0;
         double sum=0;
         double wert=0;
         while(sc.hasNext())
         {
             if (sc.hasNextDouble())
             {
                 wert=sc.nextDouble();
                 sum+=wert;
                 anz++;
                // System.out.println(wert);
             }
             else{
                 if (mstelle!=null){
                     sum=sum/anz;
                        System.out.println(sum);
                 }
                 mstelle=sc.next();
                 System.out.println(mstelle);
                 sum=0;
                 anz=0;
             }
             
         }
	     sc.close();
	     
        }
	    catch (FileNotFoundException e) {
		e.printStackTrace();

}
}
}//tokenizer kommt in MP  vor