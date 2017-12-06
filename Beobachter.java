
public class Beobachter extends Thread {
              public void run(){
            	  //super.run();
            	  while(!this.isInterrupted()){
            		  System.out.println("läuft");
            		  try {
						sleep(Math.round(Math.random()*1000));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						this.interrupt();
						e.printStackTrace();
					}
            	  }
              }
}
