package com.project.cse248garage.controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.project.cse248garage.R;
import com.project.cse248garage.model.Garage;
import com.project.cse248garage.model.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * The type Attendant options activity.
 */
public class AttendantOptionsActivity extends AppCompatActivity {
    /**
     * The Garage.
     */
    Garage garage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendant_options);
        garage = (Garage) getIntent().getSerializableExtra("Garage");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "Display Garage", Toast.LENGTH_SHORT).show();
                displayGarage();


                return true;
            case R.id.item2:
                Toast.makeText(this, "Display Garage", Toast.LENGTH_SHORT).show();
                displayGarage();


                return true;
            case R.id.item4:
                Toast.makeText(this, "Display Attendants", Toast.LENGTH_SHORT).show();
                displayAttendants();
                return true;

            case R.id.item5:

                Toast.makeText(this, "Display Records Selected", Toast.LENGTH_SHORT).show();
                displayRecords();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }


    /**
     * Park option.
     *
     * @param view the view
     */
    public void parkOption(View view) {
        Intent intent = new Intent(this, AttendantParkActivity.class);
        intent.putExtra("Garage", garage);
        startActivity(intent);
    }

    /**
     * Remove car.
     *
     * @param view the view
     */
    public void removeCar(View view) {
        Intent intent = new Intent(this, AttendantRemoveActivity.class);
        intent.putExtra("Garage", garage);

        startActivity(intent);

    }


    /**
     * Log out.
     *
     * @param view the view
     */
    public void logOut(View view) {


        User user = garage.getBag().getLoggedInUser(garage.getBag().getUserAccountHash());
        user.setLoggedIn(false);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("Garage", garage);

        startActivity(intent);


    }


    /**
     * Display garage.
     */
    public void displayGarage() {

        Intent intent2 = new Intent(this, DisplayGarageActivity.class);
        intent2.putExtra("Garage", garage);
        startActivity(intent2);


    }

    /**
     * Display attendants.
     */
    public void displayAttendants() {

        Intent intent2 = new Intent(this, DisplayAttendantActivity.class);
        intent2.putExtra("Garage", garage);
        startActivity(intent2);


    }

    /**
     * Display records.
     */
    public void displayRecords() {

        Intent intent2 = new Intent(this, RecordsActivity.class);
        intent2.putExtra("Garage", garage);
        startActivity(intent2);


    }

}
