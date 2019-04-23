package com.project.cse248garage.controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
    RadioButton carButton;
    RadioButton truckButton;
    RadioButton motoButton;
    EditText licenseField;
    Switch earlyBirdSwitch;
    boolean earlyBird;
    RadioGroup rg1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendant_park);
        garage = (Garage) getIntent().getSerializableExtra("Garage");

        System.out.println("on create");
        garage.getBag().displayBagHash();

        /*

        final RadioGroup rg1 = (RadioGroup)findViewById(R.id.rg1);
        carButton = (RadioButton) findViewById(R.id.carButton);
        truckButton =(RadioButton) findViewById(R.id.truckButton);
        motoButton =(RadioButton) findViewById(R.id.motoButton);


        //set setOnCheckedChangeListener()
        carButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton checkBox, boolean checked) {
                //basically, since we will set enabled state to whatever state the checkbox is
                //therefore, we will only have to setEnabled(checked)
              //  for(int i = 0; i < rg1.getChildCount(); i++){
               //     ((RadioButton)rg1.getChildAt(i)).setEnabled(false);
              //  }
                if(checked){
                    truckButton.setEnabled(false);
                    motoButton.setEnabled(false);

                }
            }
        });

//set default to false
        for(int i = 0; i < rg1.getChildCount(); i++){
            ((RadioButton)rg1.getChildAt(i)).setEnabled(true);
        }


*/
    }


    public void parkVehicle(View view){

       // rg1 = (RadioGroup)findViewById(R.id.rg1);



         licenseField = findViewById(R.id.license_field);

         earlyBirdSwitch = findViewById(R.id.earlybird_switch);

        licensePlate = licenseField.getText().toString();

        carButton = findViewById(R.id.carButton);
        truckButton = findViewById(R.id.truckButton);
        motoButton = findViewById(R.id.motoButton);
        earlyBird = earlyBirdSwitch.isChecked();
        User user = garage.getBag().getLoggedInUser(garage.getBag().getUserAccountHash());


        if(licensePlate.equals("")){

            licenseField.setError("Enter a license plate");
            return;
        }

        if(!carButton.isChecked() && ! truckButton.isChecked() && !motoButton.isChecked()){

            AlertDialog.Builder builder = new AlertDialog.Builder(AttendantParkActivity.this);
            builder.setCancelable(true);
            builder.setTitle("Error");
            builder.setMessage("Please select a vehicle category" +
                    "\n\n" + "Your new category will be Truck and your price will be: \n" + garage.getTruckPerHour() + " Per Hour " +
                    "\n" + garage.getTruckEarlyBird() + " Early Bird Flat Fee");

            builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();

                }
            });



            builder.show();


        }


        String category;
        Vehicle vehicle;

        if(carButton.isChecked()) {

            category = carButton.getText().toString().toLowerCase();
            vehicle = new Car(licensePlate, user.emitFirstName(), user.emitLastName(), user.emitID());

            if(garage.findClosestSpace(category) == null){

                AlertDialog.Builder builder = new AlertDialog.Builder(AttendantParkActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Sorry");
                builder.setMessage("All spaces are occupied in this category, would you like to upgrade to a larger size? " +
                        "\n\n" + "Your new category will be Truck and your price will be: \n$" + garage.getTruckPerHour() + " Per Hour " +
                        "\n\n$" + garage.getTruckEarlyBird() + " Early Bird Flat Fee");

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();

                            }
                        });

                builder.setPositiveButton("Upgrade", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    carButton.setChecked(true);
                    carButton.setChecked(false);

                    }
                });

                        builder.show();



            }
           else{
               garage.park(vehicle, category, earlyBird);
                nextView();
            }
        }


        else if(truckButton.isChecked()) {
            category = truckButton.getText().toString().toLowerCase();
            vehicle = new Truck(licensePlate, user.emitFirstName(), user.emitLastName(), user.emitID());

            if(garage.findClosestSpace(category) == null){

                AlertDialog.Builder builder = new AlertDialog.Builder(AttendantParkActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Sorry");
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
        else if(motoButton.isChecked()) {
            category = motoButton.getText().toString().toLowerCase();
            vehicle = new Motorcycle(licensePlate, user.emitFirstName(), user.emitLastName(), user.emitID());

            if(garage.findClosestSpace(category) == null){

                AlertDialog.Builder builder = new AlertDialog.Builder(AttendantParkActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Achtung!");
                builder.setMessage("All spaces are occupied in this category, would you like to upgrade to a larger size? " +
                        "\n\n" + "Your new category will be Car and your price will be: \n$" + garage.getCarPerHour() + " Per Hour " +
                        "\n\n$" + garage.getCarEarlyBird() + " Early Bird Flat Fee");

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });

                builder.setPositiveButton("Upgrade", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        motoButton.setChecked(false);
                        carButton.setChecked(true);

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
