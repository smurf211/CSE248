package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class LoginScreen {
	
	Label loginLabel = new Label("UserName: ");
	TextField loginField = new TextField();
	Label userNameLabel = new Label("Password: ");
	TextField userNameField = new TextField();
	Button signUpButton = new Button("Sign Up");
	
	Label firstNameLabel = new Label("First Name: ");
	TextField firstNameField = new TextField();
	
	
	
	
	
	
	public HBox createLoginScreen() {
		
		HBox loginBox = new HBox();
		loginBox.getChildren().addAll(loginLabel, loginField, userNameLabel, userNameField, signUpButton);
		loginBox.setAlignment(Pos.CENTER);
		
		return loginBox;
		
		
	}
	
	
	public HBox createSignUpScreen() {
		
		HBox SignUpBox = new HBox();
		SignUpBox.getChildren().addAll(loginLabel, loginField, userNameLabel, userNameField);
		SignUpBox.setAlignment(Pos.CENTER);
		
		
		
		return SignUpBox;
	}
	
	
	

	


}
