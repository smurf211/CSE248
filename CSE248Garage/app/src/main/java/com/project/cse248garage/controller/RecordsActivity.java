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
    List<String> spinnerArray;
    Spinner sItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        garage = (Garage) getIntent().getSerializableExtra("Garage");

        if(garage.getGarageSize() > 0) {

            spinnerArray = garage.getRecordBag().getLicensePlates();

        }
        else{
            spinnerArray = new ArrayList<String>();

        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         sItems = (Spinner) findViewById(R.id.spinner);
        sItems.setAdapter(adapter);





    }


    public void display(View view){




        String selected = sItems.getSelectedItem().toString();
        Record record = garage.getRecordBag().getRecord(selected);

        TextView displayField = findViewById(R.id.display_field);

        displayField.setMovementMethod(new ScrollingMovementMethod());
        displayField.setText(record.toString());
        System.out.println(record.toString());



    }


}
