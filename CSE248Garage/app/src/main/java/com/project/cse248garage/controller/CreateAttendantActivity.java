package com.project.cse248garage.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.project.cse248garage.R;
import com.project.cse248garage.model.Car;
import com.project.cse248garage.model.Garage;
import com.project.cse248garage.model.UserAccountBag;

public class CreateAttendantActivity extends AppCompatActivity {
    //UserAccountBag bag;
    Garage garage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_attendant);
        // bag  = (UserAccountBag) getIntent().getSerializableExtra("UserAccountBag");
        garage  = (Garage) getIntent().getSerializableExtra("Garage");

    }


//problem here
    public void createAttendant(View view){



        EditText userNameField = findViewById(R.id.username_field);
        EditText passwordField = findViewById(R.id.password_field);
        EditText firstname_field = findViewById(R.id.firstname_field);
        EditText lastname_field = findViewById(R.id.lastname_field);

        String userName = userNameField.getText().toString();
        String password = passwordField.getText().toString();
        String firstName = firstname_field.getText().toString();
        String lastName = lastname_field.getText().toString();

        garage.getBag().createAttendantAccount(userName, password, firstName, lastName);

       TextView displayAttendant = findViewById(R.id.display_field);


         displayAttendant.setText(garage.getBag().getUser(userName, password, garage.getBag().getUserAccountHash()).toString());


    }

    public void nextView(View view){
        Intent intent = new Intent(this, ManagerSelectActivity.class);
        intent.putExtra("Garage", garage);
        startActivity(intent);


    }
}
