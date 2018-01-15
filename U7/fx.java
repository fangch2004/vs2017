import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;//sudo apt-get install oracle-java8-installer 
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class fx extends Application {

	@Override
	public void start(Stage stage) throws Exception {
	    VBox vbox = new VBox();
	    vbox.setPadding(new Insets(10, 10, 10, 10));
	    vbox.setSpacing(10);
	    vbox.setAlignment(Pos.TOP_CENTER);

		ObservableList<String> list = FXCollections.observableArrayList(
		          "Marmelade", "Gelee");	
		ListView<String> lv = new ListView<String>();
		lv.setItems(list);
		lv.setPrefWidth(300);
		lv.setPrefHeight(60);

		vbox.getChildren().add(lv);
//1b
		ToggleGroup group = new ToggleGroup();
		RadioButton eins=new RadioButton("1:1");
		RadioButton zwei=new RadioButton("1:2");
		RadioButton drei=new RadioButton("1:3");
		HBox hor= new HBox();
hor.setAlignment(Pos.CENTER);
hor.setPrefSize(300, 20);
		hor.getChildren().addAll(eins,zwei,drei);
		eins.setToggleGroup(group);
		zwei.setToggleGroup(group);
		drei.setToggleGroup(group);
		vbox.getChildren().add(hor);
//bis
		HBox psaft= new HBox();
		psaft.setPadding(new Insets(10,10,10,10));
        psaft.setAlignment(Pos.CENTER);
		Label lsaft=new Label("Fruecht/Saft");
FlowPane.setMargin(lsaft, new Insets(10,10,10,10));
		lsaft.setPrefSize(150,20);
		TextField tsaft=new TextField("0") ;
		psaft.getChildren().addAll(lsaft,tsaft);

		HBox pzucker= new HBox();		
        pzucker.setAlignment(Pos.CENTER);
		Label lzucker=new Label("Gelierzucker");
		FlowPane.setMargin(lzucker, new Insets(10,10,10,10));
		lzucker.setPrefSize(150,20);
		TextField tzucker=new TextField("0") ;
		pzucker.getChildren().addAll(lzucker,tzucker);

		Button button=new Button("Berechnen");
		button.setPrefSize(300, 20);
		FlowPane.setMargin(button, new Insets(10,10,10,10));

		vbox.getChildren().addAll(psaft,pzucker,button);
		button.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				String select=(String) lv.getSelectionModel().getSelectedItem();
				System.out.println(select);
				if (select!=null){
				double mengeS=Double.parseDouble(tsaft.getText());
				double mengeZ=0;
				if(select.equals("Marmelade")){
					mengeZ=mengeS;
				}else
					if(select.equals("Gelee")){
						mengeZ=mengeS*100/75;
					}
				
				RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();//1b
				if (selectedRadioButton==zwei) mengeZ=mengeZ/2;//1b
				if (selectedRadioButton==drei) mengeZ=mengeZ/3;//1b
				tzucker.setText(String.valueOf(mengeZ));
				}
				
			}
			
		});
	
		
        Scene scene= new Scene(vbox,420,300);//root, 200, 200);
        stage.setTitle("MarmeladenRechner");        
        stage.setScene(scene);        
        stage.show();  
	}

	public static void main(String[] args) {
		launch(args);
	}

}