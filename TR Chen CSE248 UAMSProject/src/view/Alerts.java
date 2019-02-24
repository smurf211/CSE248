package view;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

public class Alerts {
	private static Label actionStatus = new Label("");

	public static String requestID() {
		actionStatus.setText("");
		Dialog dialog = new TextInputDialog("Enter an ID");
		dialog.setTitle("ID");
		dialog.setHeaderText("Enter ID to search...");

		Optional<String> result = dialog.showAndWait();
		String entered = "none.";

		if (result.isPresent()) {
			entered = result.get();
		}
		actionStatus.setText("ID found!");
		return entered;

	}

	public static String requestPhone() {
		actionStatus.setText("");
		Dialog dialog = new TextInputDialog("Enter a valid phone number");
		dialog.setTitle("Phone Number");
		dialog.setHeaderText("Enter a valid phone number...");

		Optional<String> result = dialog.showAndWait();
		String entered = "none.";

		if (result.isPresent()) {
			entered = result.get();

		}

		return entered;

	}

	public static String requestZip() {
		actionStatus.setText("");
		Dialog dialog = new TextInputDialog("Enter a valid zip code");
		dialog.setTitle("Zip Code");
		dialog.setHeaderText("Enter a valid zip code...");

		Optional<String> result = dialog.showAndWait();
		String entered = "none.";

		if (result.isPresent()) {
			entered = result.get();

		}

		return entered;

	}
	
	public static double requestDouble() {
		actionStatus.setText("");
		Dialog dialog = new TextInputDialog("Enter a double value");
		dialog.setTitle("Failure.");
		dialog.setHeaderText("Field not accepted, Enter a double value");

		Optional<String> result = dialog.showAndWait();
		String entered = "none.";

		if (result.isPresent()) {
			entered = result.get();

		}

		return Double.parseDouble(entered);

	}
	
	public static int requestInt() {
		actionStatus.setText("");
		Dialog dialog = new TextInputDialog("Enter an integer value");
		dialog.setTitle("Failure.");
		dialog.setHeaderText("Field not accepted, Enter an integer value");

		Optional<String> result = dialog.showAndWait();
		String entered = "none.";

		if (result.isPresent()) {
			entered = result.get();

		}

		return Integer.parseInt(entered);

	}

	public static void SuccessAlert(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Action Accepted");
		alert.setHeaderText("Information Alert");
		String s = message;
		alert.setContentText(s);
		alert.showAndWait();
	}

	public static void failureAlert(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Alert!");
		alert.setHeaderText("Information Alert");
		String s = message;
		alert.setContentText(s);
		alert.showAndWait();
	}

	public static boolean inputCheck(TextField textField) {
		actionStatus.setText("");
		String txt = textField.getText().trim();
		String msg = "Text saved: ";

		if (txt.isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Alert");
			String s = "The field cannot be empty";
			alert.setContentText(s);
			alert.showAndWait();
			textField.requestFocus();
			actionStatus.setText("Failed to add the item!");
			return false;
		} else {
			actionStatus.setText("Succeed");
			return true;
		}

	}
	
	public static boolean doubleCheck(TextField textField) {
		actionStatus.setText("");
		String txt = textField.getText().trim();
		String msg = "Text saved: ";

		if (txt.isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Alert");
			String s = "The field must be a double";
			alert.setContentText(s);
			alert.showAndWait();
			textField.requestFocus();
			actionStatus.setText("Failed to add the item!");
			return false;
		} else {
			actionStatus.setText("Succeed");
			return true;
		}

	}

	public static boolean phoneCheck(TextField textField) {
		actionStatus.setText("");
		String txt = textField.getText().trim();
		String msg = "Text saved: ";

		if (txt.isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Alert");
			String s = "The field cannot be empty";
			alert.setContentText(s);
			alert.showAndWait();
			textField.requestFocus();
			actionStatus.setText("Failed to add the item!");
			return false;
		} else {
			actionStatus.setText("Succeed");
			return true;
		}

	}

	public static void confirm() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Success!");
		String s = "Selected Item Removed!";
		alert.setContentText(s);
		actionStatus.setText("Succeed");
		Optional<ButtonType> result = alert.showAndWait();
	}

	public static Label getActionStatus() {
		return actionStatus;
	}

}
