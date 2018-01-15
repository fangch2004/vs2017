import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Leinwand extends Canvas {

	Line linie;

	public Leinwand(Line linie) {
		super();
		this.linie = linie;
		setWidth(400);
		setHeight(300);
	}
	public void paint(){
		GraphicsContext	gc = getGraphicsContext2D();
		gc.setStroke(Color.FIREBRICK);
		gc.setLineWidth(10);
		
		gc.strokeLine(linie.getStartX(),linie.getStartY(),
linie.getEndX(),linie.getEndY());
	}
	
}

class LinienEditor extends Application implements stroke{

	public static void main(String[] args) {
		launch(args);
	}

	Line eineLinie;
	Leinwand leinwand;
	
	public LinienEditor() {
		super();
		eineLinie=new Line(0,0,0,0);
		leinwand = new Leinwand(eineLinie);
	}

	@Override
	public void start(Stage stage) throws Exception {
		HBox pane=new HBox();
		pane.getChildren().add(leinwand);
		pane.setOnMousePressed(this);
		pane.setOnMouseReleased(this);
        Scene scene= new Scene(pane,400,300);
        stage.setTitle("Linieneditor");        
        stage.setScene(scene);        
        stage.show();    	
	}


	@Override
	public void handle(MouseEvent arg0) {
		if (arg0.getEventType()==MouseEvent.MOUSE_PRESSED){
			eineLinie.setStartX(arg0.getX());
			eineLinie.setStartY(arg0.getY());
		}
		else 
			if (arg0.getEventType()==MouseEvent.MOUSE_RELEASED){
				eineLinie.setEndX(arg0.getX());
				eineLinie.setEndY(arg0.getY());
				leinwand.paint();
			}
	}
}
