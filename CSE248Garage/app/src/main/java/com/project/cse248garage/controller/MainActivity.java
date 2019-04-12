package com.project.cse248garage.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.project.cse248garage.R;
import com.project.cse248garage.model.CheckCredentials;
import com.project.cse248garage.model.Garage;
import com.project.cse248garage.model.UserAccountBag;

public class MainActivity extends AppCompatActivity {
    UserAccountBag bag = new UserAccountBag();
    CheckCredentials checkCredentials = new CheckCredentials();


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        bag.createManagerAccount("smurf211", "MjsRas1118!", "Mike", "Spadaro", true );

    }

    public void adminLogin(View view){

    EditText userNameField = findViewById(R.id.username_field);
    EditText passwordField = findViewById(R.id.password_field);

    String userName = userNameField.getText().toString();
    String password = passwordField.getText().toString();


        if(checkCredentials.login(userName, password, bag.getUserAccountHash() )) {
            Intent intent = new Intent(this, GarageSetupActivity.class);
            intent.putExtra("Extra_Message", userName + password);

            startActivity(intent);
        }


    }

    public void displayMessage(){


    }
}
