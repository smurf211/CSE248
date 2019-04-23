package com.project.cse248garage.controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.project.cse248garage.R;
import com.project.cse248garage.model.Garage;
import com.project.cse248garage.model.User;

public class ManagerSelectActivity extends AppCompatActivity {

    Garage garage;
    Intent intent1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_select);

        garage  = (Garage) getIntent().getSerializableExtra("Garage");
        intent1 = new Intent(this, GarageSetupActivity.class);
    }

    public void createGarage(View view){


        if(garage.isGarageCreated()){

            AlertDialog.Builder builder = new AlertDialog.Builder(ManagerSelectActivity.this);
            builder.setCancelable(true);
            builder.setTitle("Warning!");
            builder.setMessage("Would you like to destroy the current garage and build and a new one? \n Attendants will be preserved.");

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    dialog.cancel();
                    return;

                }
            });

            builder.setPositiveButton("Nuke it", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {




                    intent1.putExtra("Garage", garage);

                    startActivity(intent1);



                }
            });

            builder.show();
        }


    else {
            intent1.putExtra("Garage", garage);

            startActivity(intent1);

        }

    }


    public void parkCar(View view){


        Intent intent2 = new Intent(this, AttendantParkActivity.class);
        intent2.putExtra("Garage", garage);
        startActivity(intent2);



    }

    public void removeCar(View view){



        Intent intent2 = new Intent(this, AttendantRemoveActivity.class);
        intent2.putExtra("Garage", garage);
        startActivity(intent2);



    }

    public void addAttendant(View view){



        Intent intent2 = new Intent(this, CreateAttendantActivity.class);
        intent2.putExtra("Garage", garage);
        startActivity(intent2);

    }

    public void removeAttendant(View view){

        Intent intent2 = new Intent(this, RemoveAttendantActivity.class);
        intent2.putExtra("Garage", garage);
        startActivity(intent2);


    }

        public void logOut(View view){
            garage.getBag().displayBagHash();


            User user =  garage.getBag().getLoggedInUser(garage.getBag().getUserAccountHash());
            user.setLoggedIn(false);
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("Garage", garage);

            startActivity(intent);


        }



}
