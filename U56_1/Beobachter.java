import java.io.*;
import java.util.Date;
public class Beobachter extends Thread 
{
	
	          public File file;
	          public long time;
	          public Beobachter (String Filename){
	          	super();
	          	file= new File(Filename);
	          	time=file.lastModified();     
	          }
	       
              public void run()
              {
            	  //super.run();
            	  while(!this.isInterrupted()){
            	//	  System.out.println("laeuft");
            	      long time1=file.lastModified();
					  Date ttime1=new Date (time1);
            	      if(time1!=time)
            	      {
            	      	System.out.println("veraendert");
						System.out.println("zeit der letzte veraenderung ist "+ttime1);
            	      	time=time1;
            	      }
					  else
					  {
					    	System.out.println("nicht veraendert");
		//					System.out.println("zeit der letzte veraenderung ist "+ttime1);
					  }
            		  try
            		  {
						sleep(Math.round(Math.random()*3000));
					  }
					  catch (InterruptedException e)
					  {
						// TODO Auto-generated catch block
						this.interrupt();
						e.printStackTrace();
					}
            	  }
              }
}
