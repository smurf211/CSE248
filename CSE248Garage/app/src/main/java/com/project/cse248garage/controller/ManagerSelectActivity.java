package com.project.cse248garage.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.project.cse248garage.R;
import com.project.cse248garage.model.Garage;
import com.project.cse248garage.model.User;

public class ManagerSelectActivity extends AppCompatActivity {

    Garage garage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_select);

        garage  = (Garage) getIntent().getSerializableExtra("Garage");
    }

    public void createGarage(View view){




        Intent intent1 = new Intent(this, GarageSetupActivity.class);
        intent1.putExtra("Garage", garage);

        startActivity(intent1);



    }


    public void parkCar(View view){

        Intent intent2 = new Intent(this, AttendantOptionsActivity.class);
        intent2.putExtra("Garage", garage);
        startActivity(intent2);



    }

        public void logOut(View view){


            User user =  garage.getBag().getLoggedInUser(garage.getBag().getUserAccountHash());
            user.setLoggedIn(false);
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("Garage", garage);

            startActivity(intent);


        }



}
