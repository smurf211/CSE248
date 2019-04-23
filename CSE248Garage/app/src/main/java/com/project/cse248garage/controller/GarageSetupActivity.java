package com.project.cse248garage.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.project.cse248garage.R;
import com.project.cse248garage.model.Car;
import com.project.cse248garage.model.Garage;
import com.project.cse248garage.model.Motorcycle;
import com.project.cse248garage.model.Truck;
import com.project.cse248garage.model.UserAccountBag;

public class GarageSetupActivity extends AppCompatActivity {
    //UserAccountBag bag;
    Garage garage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garagesetup);

       // Intent intent = getIntent();

       // String message = intent.getStringExtra("Extra_Message");
      //  TextView textView = findViewById(R.id.display_username);
      //  textView.setText(message);
          garage = (Garage) getIntent().getSerializableExtra("Garage");


    }

    public void createGarage(View view){


        EditText carSpaceField = findViewById(R.id.carspace_field);
        EditText truckSpaceField = findViewById(R.id.truckspace_field);
        EditText motorcycleSpaceField = findViewById(R.id.motorcyclespace_field);

        int carSpaces = Integer.parseInt(carSpaceField.getText().toString());
        int truckSpaces = Integer.parseInt(truckSpaceField.getText().toString());
        int motorcycleSpaces = Integer.parseInt(motorcycleSpaceField.getText().toString());

         garage.setSpaces(carSpaces, truckSpaces, motorcycleSpaces);



        EditText carEarlyBird = findViewById(R.id.car_earlybird);
        String carValueEarlyBird = carEarlyBird.getText().toString();
        garage.setCarEarlyBird(Double.valueOf(carValueEarlyBird));


        EditText carPerHour = findViewById(R.id.car_perhour);
        String carValuePerHour = carPerHour.getText().toString();
        garage.setCarPerHour(Double.valueOf(carValuePerHour));


        EditText truckEarlyBird = findViewById(R.id.truck_earlybird);
        String truckValueEarlyBird = truckEarlyBird.getText().toString();
        garage.setTruckEarlyBird(Double.valueOf(truckValueEarlyBird));


        EditText truckPerHour = findViewById(R.id.truck_perhour);
        String truckValuePerHour = truckPerHour.getText().toString();
        garage.setTruckPerHour(Double.valueOf(truckValuePerHour));


        EditText motorcycleEarlyBird = findViewById(R.id.motorcycle_earlybird);
        String motoValueEarlyBird = motorcycleEarlyBird.getText().toString();
        garage.setMotoPerHour(Double.valueOf(motoValueEarlyBird));


        EditText motorcyclePerHour = findViewById(R.id.motorcycle_perhour);
        String motoValuePerHour = motorcyclePerHour.getText().toString();
        garage.setMotoPerHour(Double.valueOf(motoValuePerHour));

        //System.out.println(garage.getCarEarlyBird() + " " + garage.getCarPerHour());
        System.out.println(garage.toString());

        //EditText displayGarage = findViewById(R.id.garage_display);
       // displayGarage.setText(garage.toString());

    }

    public void nextView(View view){


        Intent intent = new Intent(this, CreateAttendantActivity.class);




        intent.putExtra("Garage", garage);
        startActivity(intent);
    }
}
