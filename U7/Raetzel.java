import java.awt.Event;
import java.util.Arrays;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Raetzel extends Application implements EventHandler<KeyEvent>{
	public static void main(String[] args) {
		launch(args);

	}
	private String[] worte;
	private Label label;
	private String original;
	private char[] anzeige;

	public Raetzel() {
		super();
		worte= new String[]{"hallo","warum", "Kundgebung", "Allergie"};
		original=worte[0];
		anzeigeErstellen();
	}
	@Override
	public void start(Stage stage) throws Exception {
		GridPane pane=new GridPane();
		//Label 
		label=new Label(new String(anzeige));
		label.setPrefSize(300, 20);
		stage.addEventHandler(KeyEvent.KEY_PRESSED, this);
		GridPane.setMargin(label, new Insets(10,10,10,10));
		GridPane.setConstraints(label, 0, 0);
		
		Button button=new Button("neues Wort");
		button.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				int anzahl=worte.length;
				original=worte[(new Random()).nextInt(anzahl)];
				anzeigeErstellen();
				label.setText(new String(anzeige));
			}
			
		});
		button.setPrefSize(300, 20);
		GridPane.setMargin(button, new Insets(10,10,10,10));
		GridPane.setConstraints(button, 0, 1);
		pane.getChildren().addAll(label,button);
        Scene scene= new Scene(pane,300,200);
        stage.setTitle("Wörter raten");        
        stage.setScene(scene);        
        stage.show();    
	}
	
  	public void handleActionEvent(Event event) {
		int anzahl=worte.length;
		original=worte[(new Random()).nextInt(anzahl)];
		anzeigeErstellen();
		label.setText(new String(anzeige));
  	}
	
	private void anzeigeErstellen(){
		anzeige=new char[original.length()];
		Arrays.fill(anzeige, '*');
		anzeige[0]=original.charAt(0);
		anzeige[original.length()-1]=original.charAt(original.length()-1);		}

	@Override
	public void handle(KeyEvent e) {
		String s=e.getCode().getName();
		char eingabe=s.toLowerCase().charAt(0);
		System.out.println(eingabe);	
		for (int i=0;i<anzeige.length;i++)
		if (anzeige[i]=='*' && original.charAt(i)==eingabe) anzeige[i]=eingabe;
		label.setText(new String(anzeige));
	}
}
 
