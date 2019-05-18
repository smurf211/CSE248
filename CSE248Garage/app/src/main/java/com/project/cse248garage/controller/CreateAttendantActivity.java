package com.project.cse248garage.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.project.cse248garage.R;

import com.project.cse248garage.model.Car;
import com.project.cse248garage.model.CheckCredentials;
import com.project.cse248garage.model.Garage;
import com.project.cse248garage.model.User;
import com.project.cse248garage.model.UserAccountBag;

/**
 * The type Create attendant activity.
 */
public class CreateAttendantActivity extends AppCompatActivity {


    Garage garage;
    CheckCredentials check;
    EditText userNameField;
    EditText passwordField;
    EditText firstname_field;
    EditText lastname_field;
    String userName;
    String password;
    String firstName;
    String lastName;
    static String resultID;
    User testUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_attendant);

        garage = (Garage) getIntent().getSerializableExtra("Garage");
        check = new CheckCredentials();

    }


    /**
     * Create attendant.
     *
     * @param view the view
     */
    public void createAttendant(View view) {

        String type = "register";

        userNameField = findViewById(R.id.username_field);
        passwordField = findViewById(R.id.password_field);
        firstname_field = findViewById(R.id.firstname_field);
        lastname_field = findViewById(R.id.lastname_field);

        userName = userNameField.getText().toString();
        password = passwordField.getText().toString();
        firstName = firstname_field.getText().toString();
        lastName = lastname_field.getText().toString();

        if (!checkLogin()) {
            return;
        }


        garage.getBag().createAttendantAccount(userName, password, firstName, lastName);
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, firstName, lastName, userName, password, String.valueOf(0));
        testUser = garage.getBag().getUser(userName, garage.getBag().getUserAccountHash());


        TextView displayAttendant = findViewById(R.id.display_field);


        //displayAttendant.setText(garage.getBag().getUser(userName, password, garage.getBag().getUserAccountHash()).toStringAdmin());

        userNameField.setText("");
        passwordField.setText("");
        firstname_field.setText("");
        lastname_field.setText("");


    }

    /**
     * Next view.
     *
     * @param view the view
     */
    public void nextView(View view) {
        if (testUser != null) {
            System.out.println("*******************************" + resultID);
            String[] resultTokens = resultID.split(" ");
            resultID = resultTokens[2];
            User user = garage.getBag().getUser(userName, garage.getBag().getUserAccountHash());
            user.setiD(Integer.valueOf(resultID));
            System.out.println(user);
        }
        Intent intent = new Intent(this, ManagerSelectActivity.class);
        intent.putExtra("Garage", garage);
        startActivity(intent);


    }

    /**
     * Check login boolean.
     *
     * @return the boolean
     */
    public boolean checkLogin() {

        if (!check.checkUserNameHash(userName, garage.getBag().getUserAccountHash())) {

            if (userName.equals("")) {
                userNameField.setError("Enter a username");
                return false;
            } else {
                userNameField.setError("Username in use");
                return false;
            }
        }

        if (!check.checkPassword(password)) {

            if (password.equals("")) {
                passwordField.setError("Enter a password");
                return false;
            } else {
                passwordField.setError("Password must be 8 characters, contain a capital letter, lowercase letter and a special character");
                return false;
            }


        }

        if (firstName.equals("")) {
            firstname_field.setError("enter a first name");
            return false;
        }

        if (lastName.equals("")) {
            lastname_field.setError("enter a last name");
            return false;
        }


        return true;

    }

    /**
     * Gets result id.
     *
     * @return the result id
     */
    public static String getResultID() {
        return resultID;
    }

    /**
     * Sets result id.
     *
     * @param resultID the result id
     */
    public static void setResultID(String resultID) {
        CreateAttendantActivity.resultID = resultID;
    }
}
