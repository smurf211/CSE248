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
import model.CreateFunctions;
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
	ObservableList<String> genderList = 
		    FXCollections.observableArrayList(
		        "Male",
		        "Female"
		        
		    );
	ComboBox genderBox = new ComboBox(genderList);
	
	Button createUserButton = new Button("Create User");
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
		labelBox.getChildren().addAll(userNameLbl, passwordLbl, firstNameLbl, lastNameLbl, genderLbl, createUserButton);
		labelBox.setSpacing(25);
		 labelBox.setPadding(new Insets(50, 0, 0, 50));
		VBox textFieldBox = new VBox();
		textFieldBox.getChildren().addAll(userNameField, passwordField, firstNameField, lastNameField,  genderBox);
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
			gender =  genderBox.getValue().toString();
			
			if(bag.createAccount(userName, password, firstname, lastname, gender)) {
				
				
				alert.SuccessAlert("User Created!");
				
			}
			else {
				alert.SuccessAlert("Please provide the correct information.");
			}
			
			
		});
		
		
		
		
		
		
	}
	
	
	
	
	
	
	

}
