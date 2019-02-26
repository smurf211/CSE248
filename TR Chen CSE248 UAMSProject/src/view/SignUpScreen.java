package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.CheckCredentials;
import model.UserAccount;
import model.UserAccountBag;

public class SignUpScreen {

	Label userNameLbl = new Label("Username: ");
	TextField userNameField = new TextField();

	Label passwordLbl = new Label("Password: ");
	TextField passwordField = new TextField();

	Label firstNameLbl = new Label("First Name: ");
	TextField firstNameField = new TextField();

	Label lastNameLbl = new Label("Last Name: ");
	TextField lastNameField = new TextField();

	Label genderLbl = new Label("Gender: ");
	ObservableList<String> genderList = FXCollections.observableArrayList("Male", "Female");
	ComboBox genderBox = new ComboBox(genderList);

	Button createUserButton = new Button("Create User");
	Button backButton = new Button("Back");
	String userName;
	String password;
	String firstname;
	String lastname;
	String gender;

	UserAccountBag bag;
	Alerts alert = new Alerts();

	public SignUpScreen(UserAccountBag bag) {

		this.bag = bag;
	}

	public HBox createSignUpScreen() {

		buttonActions();

		VBox labelBox = new VBox();
		labelBox.getChildren().addAll(userNameLbl, passwordLbl, firstNameLbl, lastNameLbl, genderLbl, createUserButton,
				backButton);
		labelBox.setSpacing(25);
		labelBox.setPadding(new Insets(50, 0, 0, 50));
		VBox textFieldBox = new VBox();
		textFieldBox.getChildren().addAll(userNameField, passwordField, firstNameField, lastNameField, genderBox);
		textFieldBox.setSpacing(10);
		textFieldBox.setPadding(new Insets(50, 0, 0, 50));

		HBox box = new HBox();
		box.getChildren().addAll(labelBox, textFieldBox);

		return box;
	}

	public void buttonActions() {

		createUserButton.setOnAction(e -> {
			userName = userNameField.getText();
			password = passwordField.getText();
			firstname = firstNameField.getText();
			lastname = lastNameField.getText();
			gender = genderBox.getValue().toString();

			String returnValue = bag.createAccountString(userName, password, firstname, lastname, gender);

			if (returnValue.equals("success")) {

				alert.SuccessAlert("User Created!");

			}
			if (returnValue.equals("badUser")) {
				alert.SuccessAlert("That username is already taken.... please try again.");
			}

			if (returnValue.equals("badPass")) {
				alert.SuccessAlert(
						"Please enter a password that is at least 8 characters long, contains a capital letter, a number and a symbol.");

			}

		});

	}

	public Button getBackButton() {
		return backButton;
	}

}
