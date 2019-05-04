package com.project.cse248garage.controller;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.project.cse248garage.R;
import com.project.cse248garage.model.Car;
import com.project.cse248garage.model.CheckCredentials;
import com.project.cse248garage.model.Garage;
import com.project.cse248garage.model.User;
import com.project.cse248garage.model.UserAccountBag;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {

    CheckCredentials checkCredentials = new CheckCredentials();
    Garage garage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        Intent intent = getIntent();

        if(intent.hasExtra("Garage")) {
            garage = (Garage) getIntent().getSerializableExtra("Garage");
        }
        else{
            garage = new Garage();
            System.out.println("NEW GARAGE");
        }

        garage.getBag().displayBagHash();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_mainactivity,menu );

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.item1:

                Toast.makeText(this, "Load Garage", Toast.LENGTH_SHORT).show();
               loadGarage();

               return true;


            default:
                return super.onOptionsItemSelected(item);

        }

    }

    public void adminLogin(View view){

        EditText userNameField = findViewById(R.id.username_field);
    EditText passwordField = findViewById(R.id.password_field);



    String userName = userNameField.getText().toString();
    String password = passwordField.getText().toString();

     System.out.println(checkCredentials.login(userName, password, garage.getBag().getUserAccountHash() ));

        if(checkCredentials.login(userName, password, garage.getBag().getUserAccountHash() )) {



            User user = garage.getBag().getUser(userName, password, garage.getBag().getUserAccountHash());


            if(user.isAdmin()) {
                user.setLoggedIn(true);
                Intent intent1 = new Intent(this, ManagerSelectActivity.class);
                intent1.putExtra("Garage", garage);

                startActivity(intent1);
            }

            else {
               // System.out.println(garage.getBag().getUser(userName, password, garage.getBag().getUserAccountHash()));
                user.setLoggedIn(true);
                Intent intent2 = new Intent(this, AttendantOptionsActivity.class);
                intent2.putExtra("Garage", garage);
                startActivity(intent2);
            }


        }
        else{
            userNameField.setText("");
            passwordField.setText("");
            userNameField.setError("Invalid username or password...");
            passwordField.setError("Invalid username or password...");

            userNameField.setHint("invalid credentials");
            passwordField.setHint("invalid credentials");
        }


    }


    public void saveGarage(){


        Context context = MainActivity.this;
        TextView displayField = findViewById(R.id.display_field);
        displayField.setText("Garage saved");
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


        Context context = MainActivity.this;
        TextView displayField = findViewById(R.id.display_field);
        displayField.setText("Garage loaded");
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
