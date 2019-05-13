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

public class ManagerSelectActivity extends AppCompatActivity {

    Garage garage;
    Intent intent1;
    Context ctx = this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_select);

        garage  = (Garage) getIntent().getSerializableExtra("Garage");
        intent1 = new Intent(this, GarageSetupActivity.class);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu );

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
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

    public void createGarage(View view){


        if(garage.isGarageCreated()){

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

    public void saveGarage(){


        Context context = ManagerSelectActivity.this;

        File file = new File(context.getFilesDir(), "garage.dat");


        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));

            out.writeObject(garage);

            out.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        garage.getBag().displayBagHash();

    }

    public void loadGarage(){


        Context context = ManagerSelectActivity.this;

        File file = new File(context.getFilesDir(), "garage.dat");


        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            garage = (Garage) ois.readObject();

            ois.close();
        } catch (FileNotFoundException e) {
            System.out.println( e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
        }

        garage.getBag().displayBagHash();

        System.out.println(garage.getCarEarlyBird() + " " + garage.getCarPerHour());
    }

    public void displayGarage(){

        Intent intent2 = new Intent(this, DisplayGarageActivity.class);
        intent2.putExtra("Garage", garage);
        startActivity(intent2);


    }

    public void displayAttendants(){

        Intent intent2 = new Intent(this, DisplayAttendantActivity.class);
        intent2.putExtra("Garage", garage);
        startActivity(intent2);


    }

    public void displayRecords(){

        Intent intent2 = new Intent(this, RecordsActivity.class);
        intent2.putExtra("Garage", garage);
        startActivity(intent2);


    }





}
