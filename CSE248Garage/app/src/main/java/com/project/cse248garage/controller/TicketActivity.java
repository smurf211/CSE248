package com.project.cse248garage.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.project.cse248garage.R;
import com.project.cse248garage.model.Garage;
import com.project.cse248garage.model.Ticket;
import com.project.cse248garage.model.User;

public class TicketActivity extends AppCompatActivity {
    Garage garage;
    String licensePlate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        garage = (Garage) getIntent().getSerializableExtra("Garage");
        licensePlate = getIntent().getStringExtra("LicensePlate");
    }


    public void printTicket(View view){


        Ticket ticket = garage.findByPlate(licensePlate).getVehicle().getTicket();
       // System.out.println(ticket.toString());
        TextView displayField = findViewById(R.id.display_field);
        displayField.setText(ticket.toStringSpan());
    }

    public void done(View view){

        User user = garage.getBag().getLoggedInUser(garage.getBag().getUserAccountHash());
        //garage.getBag().displayBagHash();
        if(user.isAdmin()){
            Intent intent = new Intent(this, ManagerSelectActivity.class);
            intent.putExtra("Garage", garage);
            startActivity(intent);


        }
        else {


            Intent intent = new Intent(this, AttendantOptionsActivity.class);
            intent.putExtra("Garage", garage);
            startActivity(intent);
        }

    }



}
