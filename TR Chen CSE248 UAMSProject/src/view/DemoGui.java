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
import model.UserAccountBag;

public class DemoGui extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		BorderPane root = new BorderPane();
		LoginScreen loginScreen = new LoginScreen();
		SignUpScreen signUpScreen = new SignUpScreen(loginScreen.getBag());
		root.setCenter(loginScreen.createLoginScreen());
		root.setTop(loginScreen.getMenuBar());

		loginScreen.getSignUpButton().setOnAction(e -> {

			root.setCenter(signUpScreen.createSignUpScreen());

		});

		signUpScreen.getBackButton().setOnAction(e -> {

			root.setCenter(loginScreen.switchToLoginScreen());

		});

		Scene scene = new Scene(root, 600, 400);

		scene.getStylesheets().add("mike.css");
		primaryStage.setScene(scene);
		primaryStage.setTitle("Welcome");

		primaryStage.show();

	}

}
