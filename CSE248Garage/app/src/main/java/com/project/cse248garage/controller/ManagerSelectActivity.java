package com.project.cse248garage.controller;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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
 * The type Manager select activity.
 */
public class ManagerSelectActivity extends AppCompatActivity {


    Garage garage;
    Intent intent1;
    Context ctx = this;
    Button button14;
    Button button16;
    Button button17;
    Button button18;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_select);

        garage = (Garage) getIntent().getSerializableExtra("Garage");
        intent1 = new Intent(this, GarageSetupActivity.class);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (garage.getGarageSize() == 0) {

            button14 = findViewById(R.id.button14);
            button16 = findViewById(R.id.button16);
            button17 = findViewById(R.id.button17);
            button18 = findViewById(R.id.button18);

            button14.setEnabled(false);
            float alpha = 0.45f;
            button14.setAlpha(alpha);
            button16.setEnabled(false);
            button16.setAlpha(alpha);
            button17.setEnabled(false);
            button17.setAlpha(alpha);
            button18.setEnabled(false);
            button18.setAlpha(alpha);


        }
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
     * Create garage.
     *
     * @param view the view
     */
    public void createGarage(View view) {


        if (garage.isGarageCreated()) {

            AlertDialog.Builder builder = new AlertDialog.Builder(ManagerSelectActivity.this);
            builder.setCancelable(true);
            builder.setTitle("Warning!");
            builder.setMessage("Would you like to destroy the current garage and build and a new one? \nAttendants will be preserved.");

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

                    BackgroundWorker backgroundWorker = new BackgroundWorker(ctx);
                    backgroundWorker.execute("destroy garage");


                    intent1.putExtra("Garage", garage);

                    startActivity(intent1);


                }
            });

            builder.show();
        } else {
            intent1.putExtra("Garage", garage);

            startActivity(intent1);

        }

    }


    /**
     * Park car.
     *
     * @param view the view
     */
    public void parkCar(View view) {


        Intent intent2 = new Intent(this, AttendantParkActivity.class);
        intent2.putExtra("Garage", garage);
        startActivity(intent2);


    }

    /**
     * Remove car.
     *
     * @param view the view
     */
    public void removeCar(View view) {


        Intent intent2 = new Intent(this, AttendantRemoveActivity.class);
        intent2.putExtra("Garage", garage);
        startActivity(intent2);


    }

    /**
     * Add attendant.
     *
     * @param view the view
     */
    public void addAttendant(View view) {


        Intent intent2 = new Intent(this, CreateAttendantActivity.class);
        intent2.putExtra("Garage", garage);
        startActivity(intent2);

    }

    /**
     * Remove attendant.
     *
     * @param view the view
     */
    public void removeAttendant(View view) {

        Intent intent2 = new Intent(this, RemoveAttendantActivity.class);
        intent2.putExtra("Garage", garage);
        startActivity(intent2);


    }

    /**
     * Log out.
     *
     * @param view the view
     */
    public void logOut(View view) {
        garage.getBag().displayBagHash();


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
