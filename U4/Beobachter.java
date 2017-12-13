import java.io.*;
public class Beobachter extends Thread 
{
	
	          public File file;
	          public long time;
	          public Beobachter (String Filename){
	          	super();
	          	file= new File(Filename);
	          	time=file.lastModified();
	          }
	          public long gettime()
	          {
	          	time=file.lastModified();
	          	System.out.println(time);
	          	return time;
	          }
              public void run()
              {
            	  //super.run();
            	  while(!this.isInterrupted()){
            	//	  System.out.println("läuft");
            	      long time1=file.lastModified();// gettime();
            	      if(time1!=time)
            	      {
            	      		System.out.println("veraendert");
            	      	time=time1;
            	      }
            		  try
            		  {
						sleep(Math.round(Math.random()*1000));
					  } catch (InterruptedException e) {
						// TODO Auto-generated catch block
						this.interrupt();
						e.printStackTrace();
					}
            	  }
              }
}
