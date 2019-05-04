package com.project.cse248garage.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.project.cse248garage.R;
import com.project.cse248garage.model.Garage;
import com.project.cse248garage.model.Reciept;
import com.project.cse248garage.model.Ticket;

public class RecieptActivity extends AppCompatActivity {
    Garage garage;
    Reciept reciept;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciept);

        garage = (Garage) getIntent().getSerializableExtra("Garage");
        reciept = (Reciept) getIntent().getSerializableExtra("Reciept");

    }


    public void printReciept(View view){



       // System.out.println(ticket.toString());
        TextView displayField = findViewById(R.id.display_field);
        displayField.setText(reciept.toString());
    }

    public void done(View view){
        garage.getBag().displayBagHash();
        Intent intent = new Intent(this, AttendantOptionsActivity.class);
        intent.putExtra("Garage", garage);
        startActivity(intent);

    }



}
