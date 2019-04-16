package com.project.cse248garage.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.project.cse248garage.R;
import com.project.cse248garage.model.Garage;

public class AttendantRemoveActivity extends AppCompatActivity {
    Garage garage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendant_remove);

        garage = (Garage) getIntent().getSerializableExtra("Garage");
    }

    public void removeVehicle(View view){

        EditText licenseField = findViewById(R.id.license_field);
        String licensePlate = licenseField.getText().toString();

        garage.removeCar(licensePlate);

        System.out.println(garage.toString());



    }
}
