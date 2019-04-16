package com.project.cse248garage.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.project.cse248garage.R;
import com.project.cse248garage.model.UserAccountBag;

public class CreateAttendantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_attendant);
    }


//problem here
    public void createAttendant(View view){
        UserAccountBag bag  = (UserAccountBag) getIntent().getSerializableExtra("UserAccountBag");


        EditText userNameField = findViewById(R.id.username_field);
        EditText passwordField = findViewById(R.id.password_field);
        EditText firstname_field = findViewById(R.id.firstname_field);
        EditText lastname_field = findViewById(R.id.lastname_field);

        String userName = userNameField.getText().toString();
        String password = passwordField.getText().toString();
        String firstName = firstname_field.getText().toString();
        String lastName = lastname_field.getText().toString();

        bag.createAttendantAccount(userName, password, firstName, lastName);

       TextView displayAttendant = findViewById(R.id.display_field);


         displayAttendant.setText(bag.getUser(userName, password, bag.getUserAccountHash()).toString());


    }

    public void nextView(View view){
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);


    }
}
