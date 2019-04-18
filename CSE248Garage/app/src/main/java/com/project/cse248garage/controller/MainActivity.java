package com.project.cse248garage.controller;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.project.cse248garage.R;
import com.project.cse248garage.model.CheckCredentials;
import com.project.cse248garage.model.Garage;
import com.project.cse248garage.model.User;
import com.project.cse248garage.model.UserAccountBag;

public class MainActivity extends AppCompatActivity {

    CheckCredentials checkCredentials = new CheckCredentials();
    Garage garage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Intent intent = getIntent();

        if(intent.hasExtra("Garage")) {
            garage = (Garage) getIntent().getSerializableExtra("Garage");
        }
        else{
            garage = new Garage();
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
                user.setLoggedIn(false);
                Intent intent1 = new Intent(this, GarageSetupActivity.class);
                intent1.putExtra("Garage", garage);

                startActivity(intent1);
            }

            else {
               // System.out.println(garage.getBag().getUser(userName, password, garage.getBag().getUserAccountHash()));
                Intent intent2 = new Intent(this, AttendantOptionsActivity.class);
                intent2.putExtra("Garage", garage);
                startActivity(intent2);
            }


        }


    }

    public void displayMessage(){


    }
}
