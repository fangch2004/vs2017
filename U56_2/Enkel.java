
public class Enkel extends Thread{
           String name;
           Bank bank;
        public Enkel( String name, Bank bank){
        	
        	super();
        	this.name=name;
        	this.bank=bank;
        	
        }
		public void run() {
			// TODO Auto-generated method stub
			super.run();
		while(!this.isInterrupted()){
		//	while(bank.getBetrag()>5.00){
				bank.ab(Math.random()*10);
				System.out.println(name+" Restbetrag "+bank.getBetrag());
				try {
					Thread.sleep(Math.round(Math.random()*1000));
					Thread.yield();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					interrupt();
					e.printStackTrace();
				}
			}
		}
           
}
