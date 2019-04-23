package com.project.cse248garage.controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;

import com.project.cse248garage.R;
import com.project.cse248garage.model.Car;
import com.project.cse248garage.model.Garage;
import com.project.cse248garage.model.Motorcycle;
import com.project.cse248garage.model.Truck;
import com.project.cse248garage.model.User;
import com.project.cse248garage.model.Vehicle;

public class AttendantParkActivity extends AppCompatActivity {
    Garage garage;
    String licensePlate;
    CheckBox carBox;
    CheckBox truckBox;
    CheckBox motoBox;
    EditText licenseField;
    Switch earlyBirdSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendant_park);
        garage = (Garage) getIntent().getSerializableExtra("Garage");

        System.out.println("on create");
        garage.getBag().displayBagHash();
    }


    public void parkVehicle(View view){



         licenseField = findViewById(R.id.license_field);
      //  EditText categoryField = findViewById(R.id.category_field);
         earlyBirdSwitch = findViewById(R.id.earlybird_switch);

        licensePlate = licenseField.getText().toString();
       // String category = categoryField.getText().toString();
        carBox = findViewById(R.id.checkBoxCar);
        truckBox = findViewById(R.id.checkBoxTruck);
        motoBox = findViewById(R.id.checkBoxMoto);


       // System.out.println(carBox.getText().toString());


        boolean earlyBird = earlyBirdSwitch.getShowText();
       // System.out.println(earlyBird);


        User user = garage.getBag().getLoggedInUser(garage.getBag().getUserAccountHash());




        String category;
        Vehicle vehicle;

        if(carBox.isChecked()) {

            category = carBox.getText().toString().toLowerCase();
            vehicle = new Car(licensePlate, user.emitFirstName(), user.emitLastName(), user.emitID());

            if(garage.findClosestSpace(category) == null){

                AlertDialog.Builder builder = new AlertDialog.Builder(AttendantParkActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Achtung!");
                builder.setMessage("All spaces are occupied in this category, would you like to upgrade to a larger size? " +
                        "\n\n" + "Your new category will be Truck and your price will be: \n" + garage.getTruckPerHour() + " Per Hour " +
                        "\n" + garage.getTruckEarlyBird() + " Early Bird Flat Fee");

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();

                            }
                        });

                builder.setPositiveButton("Upgrade", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    truckBox.setChecked(true);
                    carBox.setChecked(false);

                    }
                });

                        builder.show();



            }
           else{
               garage.park(vehicle, category, earlyBird);
                nextView();
            }
        }


        else if(truckBox.isChecked()) {
            category = truckBox.getText().toString().toLowerCase();
            vehicle = new Truck(licensePlate, user.emitFirstName(), user.emitLastName(), user.emitID());

            if(garage.findClosestSpace(category) == null){

                AlertDialog.Builder builder = new AlertDialog.Builder(AttendantParkActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Achtung!");
                builder.setMessage("All spaces are occupied in this category, and your vehicle will not fit elsewhere. " +
                        "\n\n" + "Shit out of luck. ");

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       licenseField.setText("");
                       earlyBirdSwitch.setChecked(false);

                    }
                });

                builder.show();



            }
            else{
                garage.park(vehicle, category, earlyBird);
                nextView();
            }





        }
        //finish this
        else if(motoBox.isChecked()) {
            category = motoBox.getText().toString().toLowerCase();
            vehicle = new Motorcycle(licensePlate, user.emitFirstName(), user.emitLastName(), user.emitID());

            if(garage.findClosestSpace(category) == null){

                AlertDialog.Builder builder = new AlertDialog.Builder(AttendantParkActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Achtung!");
                builder.setMessage("All spaces are occupied in this category, would you like to upgrade to a larger size? " +
                        "\n\n" + "Your new category will be Car and your price will be: \n" + garage.getCarPerHour() + " Per Hour " +
                        "\n" + garage.getCarEarlyBird() + " Early Bird Flat Fee");

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });

                builder.setPositiveButton("Upgrade", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        motoBox.setChecked(false);
                        carBox.setChecked(true);

                    }
                });

                builder.show();



            }
            else{
                garage.park(vehicle, category, earlyBird);
                nextView();
            }








        }








    }


    public void nextView(){
        Intent intent = new Intent(this, TicketActivity.class);
        intent.putExtra("Garage", garage);
        intent.putExtra("LicensePlate", licensePlate);
        startActivity(intent);

    }
}
