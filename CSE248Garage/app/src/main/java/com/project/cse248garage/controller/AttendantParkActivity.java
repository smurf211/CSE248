package com.project.cse248garage.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

import com.project.cse248garage.R;
import com.project.cse248garage.model.Car;
import com.project.cse248garage.model.Garage;
import com.project.cse248garage.model.Motorcycle;
import com.project.cse248garage.model.Truck;
import com.project.cse248garage.model.User;

public class AttendantParkActivity extends AppCompatActivity {
    Garage garage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendant_park);
        garage = (Garage) getIntent().getSerializableExtra("Garage");
    }


    public void parkVehicle(View view){

        EditText licenseField = findViewById(R.id.license_field);
        EditText categoryField = findViewById(R.id.category_field);
        Switch earlyBirdSwitch = findViewById(R.id.earlybird_switch);

        String licensePlate = licenseField.getText().toString();
        String category = categoryField.getText().toString();
        boolean earlyBird = earlyBirdSwitch.getShowText();
        System.out.println(earlyBird);

        //add attendant first/last name to vehicle, get into ticket
        User user = garage.getBag().getLoggedInUser(garage.getBag().getUserAccountHash());



       if(category.equalsIgnoreCase("car")){
           Car car = new Car(licensePlate, user.emitFirstName(), user.emitLastName());
           garage.park(car, category, earlyBird);

           System.out.println(garage.toString());


       }

        if(category.equalsIgnoreCase("truck")){
            Truck truck = new Truck(licensePlate, user.emitFirstName(), user.emitLastName());
            garage.park(truck, category, earlyBird);

            //   System.out.println(garage.toString());



        }

        if(category.equalsIgnoreCase("motorcycle")){
            Motorcycle motorcycle = new Motorcycle(licensePlate, user.emitFirstName(), user.emitLastName());
            garage.park(motorcycle, category, earlyBird);

            //   System.out.println(garage.toString());



        }

        Intent intent = new Intent(this, TicketActivity.class);
        intent.putExtra("Garage", garage);
        intent.putExtra("LicensePlate", licensePlate);
        startActivity(intent);



    }
}
