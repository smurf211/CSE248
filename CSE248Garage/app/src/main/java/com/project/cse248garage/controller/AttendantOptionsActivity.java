package com.project.cse248garage.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.project.cse248garage.R;
import com.project.cse248garage.model.Garage;
import com.project.cse248garage.model.User;

public class AttendantOptionsActivity extends AppCompatActivity {
    Garage garage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendant_options);
        garage = (Garage) getIntent().getSerializableExtra("Garage");
    }


    public void parkOption(View view){
        Intent intent = new Intent(this, AttendantParkActivity.class);
        intent.putExtra("Garage", garage);
        startActivity(intent);
    }

    public void removeCar(View view){
        Intent intent = new Intent(this,AttendantRemoveActivity.class);
        intent.putExtra("Garage", garage);

        startActivity(intent);

    }


    public void logOut(View view){


        User user =  garage.getBag().getLoggedInUser(garage.getBag().getUserAccountHash());
        user.setLoggedIn(false);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("Garage", garage);

        startActivity(intent);


    }

}
