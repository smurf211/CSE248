package com.project.cse248garage.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

import com.project.cse248garage.R;

public class AttendantParkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendant_park);
    }


    public void parkVehicle(View view){

        EditText licenseField = findViewById(R.id.license_field);
        EditText categoryField = findViewById(R.id.category_field);
        Switch earlyBirdSwitch = findViewById(R.id.earlybird_switch);

        String licensePlate = licenseField.getText().toString();
        String category = categoryField.getText().toString();
        boolean earlybird = earlyBirdSwitch.getShowText();

        //add attendant first/last name to vehicle, get into ticket



    }
}
