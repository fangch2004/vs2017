import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Bank {
	static java.util.concurrent.locks.ReentrantLock lock =new ReentrantLock();
	static Condition condition = lock.newCondition(); 
 private double betrag;
 public Bank (double betrag){
	 super();
	 this.betrag=betrag;
 }


public double getBetrag(){
	return betrag;
}


//public synchronized void  ab(double betrag){
public  void  ab(double betrag){
	lock.lock();
	if (this.betrag-betrag>0) this.betrag=this.betrag-betrag;
	else{
		try{
	//	wait();
			condition.await();
		}
		catch ( InterruptedException e){
		
		Thread.currentThread().interrupt();
		e.printStackTrace();
	}
	}
	lock.unlock();
}

//public synchronized void   zu(double betrag){
public void  zu(double betrag){
	lock.lock();
	this.betrag=this.betrag+betrag;
	//notifyAll();
	condition.signalAll();
	lock.unlock();
	
	
}

}