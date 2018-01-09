import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class Handler {

	public static void main(String[] args) {
		ArrayBlockingQueue<Transaction> transactionQueue=new ArrayBlockingQueue<Transaction>(100);		
		Bank bank=new Bank(transactionQueue);
		bank.accounts.put(1,new Account(1,1000));
		bank.accounts.put(2,new Account(2,1000));
		bank.accounts.put(3,new Account(3,1000));
		bank.accounts.put(4,new Account(4,1000));
		Thread t=new Thread(bank);
		transactionQueue.add(new Transaction(1,2,100));
		transactionQueue.add(new Transaction(1,3,200));
		transactionQueue.add(new Transaction(1,4,100));
		transactionQueue.add(new Transaction(1,5,100));
		t.start();

		for (Account a: bank.accounts.values()){
			System.out.println(a.getNumber()+ " "+a.getBalance());
		}
		Scanner eing=new Scanner(new InputStreamReader(System.in));
		int betrag=eing.nextInt();
		while (betrag!=0){
			int from=eing.nextInt();
			int to=eing.nextInt();
			transactionQueue.add(new Transaction(from,to,betrag));
			betrag=eing.nextInt();
		}
		eing.close();
		for (Account a: bank.accounts.values()){
			System.out.println(a.getNumber()+ " "+a.getBalance());
		}
		t.interrupt();
	}

}
