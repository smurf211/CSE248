package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.CheckCredentials;
import model.UserAccountBag;

public class LoginScreen {

	Label usernameLabel = new Label("UserName: ");
	TextField usernameField = new TextField();
	Label passwordLabel = new Label("Password: ");
	TextField passwordField = new TextField();
	Button signUpButton = new Button("Sign Up");
	Button loginButton = new Button("Log In");

	Label firstNameLabel = new Label("First Name: ");
	TextField firstNameField = new TextField();
	Alerts alert = new Alerts();
	Menu fileMenu = new Menu("File");
	MenuItem displayMenuItem = new MenuItem("Display Users");
	MenuBar menuBar = new MenuBar();

	UserAccountBag bag = new UserAccountBag();

	CheckCredentials function = new CheckCredentials();

	public VBox createLoginScreen() {
		buildFileMenu();
		buildMenuBar();

		HBox loginBox = new HBox();
		loginBox.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField);
		loginBox.setPadding(new Insets(20, 0, 0, 0));
		HBox buttonBox = new HBox();
		loginBox.setAlignment(Pos.CENTER);
		buttonBox.setPadding(new Insets(10, 0, 0, 0));
		buttonBox.getChildren().addAll(loginButton, signUpButton);
		VBox box = new VBox();
		box.getChildren().addAll(loginBox, buttonBox);
		buttonBox.setAlignment(Pos.CENTER);

		bag.fillBagHash(3000);

		// bag.displayBag();

		loginButton.setOnAction(e -> {

			String userName = usernameField.getText();
			String password = passwordField.getText();

			if (function.login(userName, password, bag.getUserAccountHash())) {

				alert.SuccessAlert("Success!");

			}

			else {

				alert.SuccessAlert("Failure!");
			}

		});

		return box;

	}

	public VBox switchToLoginScreen() {
		

		HBox loginBox = new HBox();
		loginBox.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField);
		HBox buttonBox = new HBox();
		loginBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(loginButton, signUpButton);
		VBox box = new VBox();
		box.getChildren().addAll(loginBox, buttonBox);
		buttonBox.setAlignment(Pos.CENTER);

		bag.fillBagHash(3000);

		// bag.displayBag();

		loginButton.setOnAction(e -> {

			String userName = usernameField.getText();
			String password = passwordField.getText();

			if (function.login(userName, password, bag.getUserAccountHash())) {

				alert.SuccessAlert("Success!");

			}

			else {

				alert.SuccessAlert("Failure!");
			}

		});

		return box;

	}

	private void buildFileMenu() {

		fileMenu.getItems().addAll(displayMenuItem);

		displayMenuItem.setOnAction(e -> {

			bag.displayBagHash();
		});

	}

	private void buildMenuBar() {
		menuBar = new MenuBar();

		menuBar.getMenus().addAll(fileMenu);

	}

	public MenuBar getMenuBar() {
		return menuBar;
	}

	public Button getSignUpButton() {
		return signUpButton;
	}

	public void setSignUpButton(Button signUpButton) {
		this.signUpButton = signUpButton;
	}

	public UserAccountBag getBag() {
		return bag;
	}

}
