package com.project.cse248garage.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import com.project.cse248garage.R;
import com.project.cse248garage.model.Garage;
import com.project.cse248garage.model.ParkingSpace;
import com.project.cse248garage.model.Record;

import java.util.ArrayList;
import java.util.List;

public class RecordsActivity extends AppCompatActivity {
    Garage garage;
    List<String> spinnerArrayPlates;
    List<String> spinnerArrayUsers;
    Spinner plateNumbers;
    Spinner attendants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        garage = (Garage) getIntent().getSerializableExtra("Garage");

        if(garage.getGarageSize() > 0) {

            spinnerArrayPlates = garage.getRecordBag().getLicensePlates(garage);

        }
        else{
            spinnerArrayPlates = new ArrayList<String>();

        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArrayPlates);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         plateNumbers = (Spinner) findViewById(R.id.spinner);
        plateNumbers.setAdapter(adapter);

        //----------------------------------------------------
        /*
        if(garage.getGarageSize() > 0) {

            spinnerArrayUsers = garage.getBag().getUsersArrayList(garage.getBag().getUserAccountHash());

        }
        else{
            spinnerArrayUsers = new ArrayList<String>();

        }

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArrayUsers);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        attendants = (Spinner) findViewById(R.id.spinner2);
        attendants.setAdapter(adapter2);

*/



    }


    public void displayByPlate(View view){
        TextView displayField = findViewById(R.id.display_field);

        displayField.setText("");


        if(plateNumbers.getSelectedItem() == null){
            return;
        }

        String selected = plateNumbers.getSelectedItem().toString();
        if(selected.contains("(")){
           String[] tokens = selected.split("[(]");
           selected = tokens[0].trim();

        }
        Record record = garage.getRecordBag().getRecord(selected);

        System.out.println(selected);


        displayField.setMovementMethod(new ScrollingMovementMethod());
        System.out.println(record.toString());
        displayField.setText(record.toString());




    }

    public void displayByUser(View view){


        if(attendants.getSelectedItem() == null){
            return;
        }

        String selected = attendants.getSelectedItem().toString();
        Record record = garage.getRecordBag().getRecord(selected);

        TextView displayField = findViewById(R.id.display_field);

        displayField.setMovementMethod(new ScrollingMovementMethod());
        displayField.setText(record.toString());
        System.out.println(record.toString());



    }


}
