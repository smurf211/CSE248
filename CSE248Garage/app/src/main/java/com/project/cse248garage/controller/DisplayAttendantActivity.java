package com.project.cse248garage.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.project.cse248garage.R;
import com.project.cse248garage.model.Garage;
import com.project.cse248garage.model.User;

public class DisplayAttendantActivity extends AppCompatActivity {
    Garage garage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_attendant);

        garage = (Garage) getIntent().getSerializableExtra("Garage");

        displayAttendants();
    }


    public void displayAttendants(){
        User user = garage.getBag().getLoggedInUser(garage.getBag().getUserAccountHash());

        if(user.isAdmin()) {

            TextView displayField = findViewById(R.id.display_field);
            displayField.setText(garage.getBag().displayBagAdmin());
        }

        else{

            TextView displayField = findViewById(R.id.display_field);
            displayField.setText(garage.getBag().displayBagUser());


        }


    }
}
