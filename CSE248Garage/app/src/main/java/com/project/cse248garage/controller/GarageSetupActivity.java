package com.project.cse248garage.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.project.cse248garage.R;
import com.project.cse248garage.model.Car;
import com.project.cse248garage.model.Garage;
import com.project.cse248garage.model.Motorcycle;
import com.project.cse248garage.model.Truck;

public class GarageSetupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garagesetup);

       // Intent intent = getIntent();

       // String message = intent.getStringExtra("Extra_Message");
      //  TextView textView = findViewById(R.id.display_username);
      //  textView.setText(message);

    }

    public void createGarage(View view){


        EditText carSpaceField = findViewById(R.id.carspace_field);
        EditText truckSpaceField = findViewById(R.id.truckspace_field);
        EditText motorcycleSpaceField = findViewById(R.id.motorcyclespace_field);

        int carSpaces = Integer.parseInt(carSpaceField.getText().toString());
        int truckSpaces = Integer.parseInt(truckSpaceField.getText().toString());
        int motorcycleSpaces = Integer.parseInt(motorcycleSpaceField.getText().toString());

        Garage garage = new Garage(carSpaces, truckSpaces, motorcycleSpaces);

        EditText carEarlyBird = findViewById(R.id.car_earlybird);
        carEarlyBird.setText(String.valueOf(Car.earlyBird));
        EditText carPerHour = findViewById(R.id.car_perhour);
        carPerHour.setText(String.valueOf(Car.perHour));

        EditText truckEarlyBird = findViewById(R.id.truck_earlybird);
        truckEarlyBird.setText(String.valueOf(Truck.earlyBird));
        EditText truckPerHour = findViewById(R.id.truck_perhour);
        truckPerHour.setText(String.valueOf(Truck.perHour));

        EditText motorcycleEarlyBird = findViewById(R.id.motorcycle_earlybird);
        motorcycleEarlyBird.setText(String.valueOf(Motorcycle.earlyBird));
        EditText motorcyclePerHour = findViewById(R.id.motorcycle_perhour);
        motorcyclePerHour.setText(String.valueOf(Motorcycle.perHour));


        //EditText displayGarage = findViewById(R.id.garage_display);
       // displayGarage.setText(garage.toString());

    }
}
