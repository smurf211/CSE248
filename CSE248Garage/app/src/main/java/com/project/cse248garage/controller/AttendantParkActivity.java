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
import com.project.cse248garage.databasePhpTest.BackgroundWorkerTest;
import com.project.cse248garage.model.Car;
import com.project.cse248garage.model.Garage;
import com.project.cse248garage.model.Motorcycle;
import com.project.cse248garage.model.ParkingSpace;
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
    String category;
    Vehicle vehicle;
    User user;
    String falseCategory;
    BackgroundWorker backgroundWorker;
    BackgroundWorker backgroundWorker1;
   static String resultID;
    String typePark = "park vehicle";
    ParkingSpace openSpace;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendant_park);
        garage = (Garage) getIntent().getSerializableExtra("Garage");

        System.out.println("on create");
        garage.getBag().displayBagHash();

    backgroundWorker = new BackgroundWorker(this);
    backgroundWorker1 = new BackgroundWorker(this);
    }


    public void parkVehicle(View view){






         licenseField = findViewById(R.id.license_field);

         earlyBirdSwitch = findViewById(R.id.earlybird_switch);

        licensePlate = licenseField.getText().toString();

        carButton = findViewById(R.id.carButton);
        truckButton = findViewById(R.id.truckButton);
        motoButton = findViewById(R.id.motoButton);
        earlyBird = earlyBirdSwitch.isChecked();
        user = garage.getBag().getLoggedInUser(garage.getBag().getUserAccountHash());


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




        if(carButton.isChecked()) {
            parkCar("car");


        }


        else if(truckButton.isChecked()) {

           parkTruck("truck");



        }

        else if(motoButton.isChecked()) {




            parkMoto("motorcycle");



        }








    }


    public void parkCar(String category){



        falseCategory = category;
        vehicle = new Car(licensePlate, user.emitFirstName(), user.emitLastName(), user.emitID());
        vehicle.setFalseCategory(category);

        if(garage.findClosestSpace(carButton.getText().toString().toLowerCase()) == null){

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
                   // carButton.setChecked(false);
                  //  truckButton.setChecked(true);
                    parkTruck(falseCategory);





                }
            });

            builder.show();



        }
        else{

          openSpace =  garage.park(vehicle, carButton.getText().toString().toLowerCase(), earlyBird, backgroundWorker);
            System.out.println(vehicle.getCategory());



        }






    }

    public void parkTruck(String category){

       // category = truckButton.getText().toString().toLowerCase();
        vehicle = new Truck(licensePlate, user.emitFirstName(), user.emitLastName(), user.emitID());
        vehicle.setFalseCategory(category);

        if(garage.findClosestSpace(truckButton.getText().toString().toLowerCase()) == null){

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

           openSpace= garage.park(vehicle, truckButton.getText().toString().toLowerCase(), earlyBird, backgroundWorker);
            System.out.println(vehicle.getCategory());



        }



    }

    public void parkMoto(String category){
        falseCategory = category;

       // category = motoButton.getText().toString().toLowerCase();
        vehicle = new Motorcycle(licensePlate, user.emitFirstName(), user.emitLastName(), user.emitID());
        vehicle.setFalseCategory(category);

        if(garage.findClosestSpace(motoButton.getText().toString().toLowerCase()) == null){

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
                   // motoButton.setChecked(false);
                   // carButton.setChecked(true);

                    if(garage.findClosestSpace("car") == null){
                        parkTruck(falseCategory);
                    }
                    parkCar(falseCategory);


                }
            });

            builder.show();




        }
        else{

         openSpace =   garage.park(vehicle, motoButton.getText().toString().toLowerCase(), earlyBird, backgroundWorker);
            System.out.println(vehicle.getCategory());



        }



    }


    public void nextView(View view){

        System.out.println("*******************************" + resultID);
        String[] resultTokens = resultID.split(" ");
        resultID = resultTokens[2];
        ParkingSpace space = garage.findByPlate(licensePlate);
        space.getVehicle().setVehicleId(Integer.valueOf(resultID));
        System.out.println(space.getVehicle());

        backgroundWorker1.execute(typePark, openSpace.getCategory(), String.valueOf(openSpace.getCarDistance()), String.valueOf(openSpace.getTruckDistance()), String.valueOf(openSpace.getMotorcycleDistance()),
                String.valueOf(openSpace.getDistance()),Garage.convertBoolean(earlyBird), Garage.convertBoolean(openSpace.isFree()),
                String.valueOf(vehicle.getVehicleId()), String.valueOf(openSpace.getTime()), String.valueOf(openSpace.getDate()), openSpace.getSpaceID());


        Intent intent = new Intent(this, TicketActivity.class);
        intent.putExtra("Garage", garage);
        intent.putExtra("LicensePlate", licensePlate);
        startActivity(intent);

    }

    public static String getResultID() {
        return resultID;
    }

    public static void setResultID(String resultID) {
        AttendantParkActivity.resultID = resultID;
    }
}
