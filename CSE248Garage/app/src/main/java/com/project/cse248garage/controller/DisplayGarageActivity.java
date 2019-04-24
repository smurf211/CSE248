package com.project.cse248garage.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.project.cse248garage.R;
import com.project.cse248garage.model.Garage;
import com.project.cse248garage.model.Vehicle;


public class DisplayGarageActivity extends AppCompatActivity {
    Garage garage;
    TextView carView;
    TextView truckView;
    TextView motoView;
    Vehicle vehicle;
    String temp;
    String temp2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_garage);

        garage = (Garage) getIntent().getSerializableExtra("Garage");
    }

    public void displayGarage(View view){

        carView = findViewById(R.id.display_field1);
        truckView = findViewById(R.id.display_field2);
        motoView = findViewById(R.id.display_field3);

        for(int i = 0; i < garage.getCarBag().length; i++){


           if( !garage.getCarBag()[i].isFree()){
           temp = garage.getCarBag()[i].getVehicle().getCategory();
           temp2 = temp.substring(0,1).toUpperCase();
           carView.append("c"+ (i+1) +" [" + temp2 + "]" + "\n\n");
           }
            else {
               carView.append("c" + (i + 1) + " [" + " " + "]" + "\n\n");
           }


        }

        for(int i = 0; i < garage.getTruckSpaceBag().length; i++){

            if( !garage.getTruckSpaceBag()[i].isFree()){
                temp = garage.getTruckSpaceBag()[i].getVehicle().getCategory();
                temp2 = temp.substring(0,1).toUpperCase();
                truckView.append("t"+ (i+1) +" [" + temp2 + "]" + "\n\n");
            }
            else {
                truckView.append("t" + (i + 1) + " [" + " " + "]" + "\n\n");
            }


        }

        for(int i = 0; i < garage.getMotorcycleSpaceBag().length; i++){

            if( !garage.getMotorcycleSpaceBag()[i].isFree()){
                temp = garage.getMotorcycleSpaceBag()[i].getVehicle().getCategory();
                temp2 = temp.substring(0,1).toUpperCase();
                motoView.append("m"+ (i+1) +" [" + temp2 + "]" + "\n\n");
            }
            else {
                motoView.append("m" + (i + 1) + " [" + " " + "]" + "\n\n");
            }


        }



    }
}
