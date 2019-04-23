package com.project.cse248garage.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.project.cse248garage.R;
import com.project.cse248garage.model.Garage;
import com.project.cse248garage.model.Reciept;

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


        if(garage.findByPlate(licensePlate) == null){

            licenseField.setError("Vehicle not found..");
            return;
        }

        Reciept reciept = garage.removeCar(licensePlate);

        TextView displayField = findViewById(R.id.display_field);
       displayField.setText(reciept.toString());





    }

    public void done(View view){

        Intent intent = new Intent(this, AttendantOptionsActivity.class);
        intent.putExtra("Garage", garage);

        startActivity(intent);
    }
}
