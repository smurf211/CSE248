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
import com.project.cse248garage.model.UserAccountBag;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_attendant);
        // bag  = (UserAccountBag) getIntent().getSerializableExtra("UserAccountBag");
        garage  = (Garage) getIntent().getSerializableExtra("Garage");
        check = new CheckCredentials();

    }



    public void createAttendant(View view){



         userNameField = findViewById(R.id.username_field);
         passwordField = findViewById(R.id.password_field);
        firstname_field = findViewById(R.id.firstname_field);
        lastname_field = findViewById(R.id.lastname_field);

        userName = userNameField.getText().toString();
        password = passwordField.getText().toString();
        firstName = firstname_field.getText().toString();
        lastName = lastname_field.getText().toString();

        if(!checkLogin()){
            return;
        }


        garage.getBag().createAttendantAccount(userName, password, firstName, lastName);

       TextView displayAttendant = findViewById(R.id.display_field);


         displayAttendant.setText(garage.getBag().getUser(userName, password, garage.getBag().getUserAccountHash()).toString());


    }

    public void nextView(View view){
        Intent intent = new Intent(this, ManagerSelectActivity.class);
        intent.putExtra("Garage", garage);
        startActivity(intent);


    }

    public boolean checkLogin(){

        if(!check.checkUserNameHash(userName, garage.getBag().getUserAccountHash())){

            if(userName.equals("")){
                userNameField.setError("Enter a username");
                return false;
            }
            else {
                userNameField.setError("Username in use");
                return false;
            }
        }

        if(!check.checkPassword(password)){

            if(password.equals("")){
                passwordField.setError("Enter a password");
                return false;
            }
            else {
                passwordField.setError("Password must be 8 characters, contain a capital letter, lowercase letter and a special character");
                return false;
            }


        }

        if(firstName.equals("")){
            firstname_field.setError("enter a first name");
            return false;
        }

        if(lastName.equals("")){
            lastname_field.setError("enter a last name");
            return false;
        }


    return true;

    }
}