import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Tester {

public static void main(String[] args) {
	TextFileSplitter tfs=new TextFileSplitter("***","kurzgeschichte.txt");
	tfs.split();
	}
}




 class TextFileSplitter {
String trennkette;
String dateiname;
public TextFileSplitter(String trennkette, String dateiname) {
	super();
	this.trennkette = trennkette;
	this.dateiname = dateiname;
}

public void split(){
	FileReader fr=null;
	FileWriter fw=null;
	BufferedReader bufr=null;	
	BufferedWriter bufw=null;
	int nr=0;
	int punktpos=dateiname.indexOf('.');
	try {
		fr = new FileReader(dateiname);
		bufr=new BufferedReader(fr);
		
	} 
catch (FileNotFoundException e) {
		e.printStackTrace();
		bufr=null;
	}
	if (bufr!=null){
		try {			
			String datnam=dateiname.substring(0, punktpos)+nr+
					dateiname.substring(punktpos, dateiname.length());
			fw=new FileWriter(datnam);
			bufw=new BufferedWriter(fw);
			String inputline;

			while ((inputline=bufr.readLine())!=null){
				if (inputline.equals(trennkette)){
					nr++;
					bufw.flush();
					fw.close();
					datnam=dateiname.substring(0, punktpos)+nr+
					dateiname.substring(punktpos, dateiname.length());
					fw=new FileWriter(datnam);
					bufw=new BufferedWriter(fw);			
					}
				else{
					bufw.write(inputline,0,inputline.length());
					bufw.newLine();			
				}
			}
			bufw.flush();
			fw.close();fr.close();
		} 
catch (IOException e) {
			e.printStackTrace();
		}
	}
}
}
