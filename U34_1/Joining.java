import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Joining {
	public static void main(String[] args) {
		String datei="keine";
		byte daten[]=new byte[1024];
		try{
		FileOutputStream output=new FileOutputStream("neu1.mp3");
		BufferedOutputStream boutput=new BufferedOutputStream(output);
		
		Scanner isr=new Scanner(System.in);
		while (!datei.isEmpty()){
			System.out.println("Dateiname: ");
			datei=isr.nextLine();
			System.out.println(datei);
			if (!datei.isEmpty()){
				FileInputStream input=new FileInputStream(datei);
				BufferedInputStream binput=new BufferedInputStream(input);
				int anz=binput.read(daten);
				while (anz>0){
					boutput.write(daten);
					anz=binput.read(daten);
					}
				input.close();
			}
		}
		boutput.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

