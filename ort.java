import java.awt.Label;
import java.util.Arrays;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.*;



public class Wort extends Application implements EventHandler<KeyEvent> {
	private String original;
	private Label label;
	
	private String[] woerter = new String[]{"hell","Energie","Rechner","Test"};
public static void main(String[] args){
	    launch(args);
}
public void handle(KeyEvent event) {
	// TODO Auto-generated method stub
	String s= event.getCode.getName();
	
      	
}
public void start(Stage stage) throws Exception {
	// TODO Auto-generated method stub
	VBox root=new VBox();
	anzeigeErstellen();
	label= new Label();
	label.setPrefWidth(200);
	original=woerter[0];
	label.setText(original);
	Button button = new Button("next");
	button.setPrefWidth(200);
	button.addEventHandler(ActionEvent.ACTION; new EventHandler<ActionEvent>){
		public void handle(ActionEvent arg0){
			int anzahl = woerter.length;
			original=woerter
			label=setText(original);
		}
	}
	
	
	
	
	root.getChildren().add(label);
	root.getChildren().add(button);
	stage.
	
	
}
private void anzeigeErstellen(){
	char[] anzeige= new char[original.length()];
	Arrays.fill(anzeige, '*');
	anzeige[0]=original.charAt(0);
	anzeige[original.length()-1]=original.charAt(original.length()-1);
}

}
