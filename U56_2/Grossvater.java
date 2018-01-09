import java.util.Scanner;
public class Grossvater {
	
	
  public static void main (String[]args){
	  Bank bank = new Bank(100);
	  Enkel e1 =new Enkel ("Maria",bank);
	  Enkel e2= new Enkel ("Josef",bank);
	  e1.start();
	  e2.start();
	  Scanner sc= new Scanner (System.in);
	  double betrag=sc.nextDouble();
	  while (betrag>0){
		 bank.zu(betrag); 
		 betrag=sc.nextDouble();
	  }
  }
}
