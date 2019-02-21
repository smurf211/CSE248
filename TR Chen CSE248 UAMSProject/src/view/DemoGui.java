package view;

import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class DemoGui extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		Label nameLbl = new Label("Name: ");
		TextField nameField = new TextField();

		// second set of controls
		Label phoneLbl = new Label("Phone");
		TextField phoneField = new TextField();

		// 3rd controls
		Button okBtn = new Button("Ok");

		Button exitBtn = new Button("exit");

		// container
		HBox pane1 = new HBox(30);

		pane1.getChildren().addAll(nameLbl, nameField);
		pane1.setAlignment(Pos.CENTER);

		// second container
		HBox pane2 = new HBox(30);

		pane2.getChildren().addAll(phoneLbl, phoneField);
		pane2.setAlignment(Pos.CENTER);

		// third container
		HBox pane3 = new HBox(30);
		pane3.getChildren().add(exitBtn);

		pane3.getChildren().add(okBtn);
		pane3.setAlignment(Pos.CENTER);

		// fourth container
		TextArea displayArea = new TextArea();

		okBtn.setOnAction(e -> {
			// whatever is in here will be invoked when button is clicked.
			String name = nameField.getText();
			String phone = phoneField.getText();
			displayArea.appendText(name + ": " + phone + "\n");
			nameField.clear();
			phoneField.clear();
			

		});

		exitBtn.setOnAction(e -> {
			Platform.exit();
		});

		// parent container
		VBox pane = new VBox(30);
		pane.getChildren().addAll(pane1, pane2, pane3, displayArea);
		// pane.setAlignment(Pos.CENTER);

		// add container to the scene.
		Scene scene = new Scene(pane, 500, 500);

		// add the scene to the primary stage
		primaryStage.setScene(scene);
		primaryStage.setTitle("Welcome");

		// request display on the screen
		primaryStage.show();
		
	}
	
	

}
