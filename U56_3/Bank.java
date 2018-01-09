import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;

public class Bank implements Runnable {
	public ArrayBlockingQueue<Transaction> transactionQueue;
	public HashMap<Integer,Account> accounts;
	
	public Bank(ArrayBlockingQueue<Transaction> transactionQueue) {
		super();
		this.transactionQueue = transactionQueue;
		accounts=new HashMap<Integer,Account>();

	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()){
			try {
				Transaction t=transactionQueue.take();
				int betrag=t.getAmount();
				int from=t.getFrom();
				Account afrom=accounts.get(from);
				int to=t.getTo();
				Account ato=accounts.get(to);
				if (afrom!=null &&ato!=null){
					afrom.setBalance(afrom.getBalance()-betrag);
					ato.setBalance(ato.getBalance()+betrag);
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}		
		}
	}
}
