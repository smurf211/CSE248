package com.project.cse248garage.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.project.cse248garage.R;

public class AttendantOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendant_options);
    }


    public void parkOption(View view){
        Intent intent = new Intent(this, AttendantParkActivity.class);

        startActivity(intent);
    }

    public void removeCar(View view){
        Intent intent = new Intent(this,AttendantRemoveActivity.class);

        startActivity(intent);

    }

}
