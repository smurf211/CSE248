package com.project.cse248garage.controller;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
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
    SpannedString tempSpan1;
    SpannedString tempSpan2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_garage);

        garage = (Garage) getIntent().getSerializableExtra("Garage");
    }

    public void displayGarage(View view) {



        if (garage.getCarBag() == null || garage.getTruckSpaceBag() == null || garage.getMotorcycleSpaceBag() == null) {

            AlertDialog.Builder builder = new AlertDialog.Builder(DisplayGarageActivity.this);
            builder.setCancelable(true);
            builder.setTitle("Warning!");
            builder.setMessage("No Garage to display, please create one.");

            builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    dialog.cancel();
                    return;

                }
            });


            builder.show();

            return;
        }






        carView = findViewById(R.id.display_field1);
        truckView = findViewById(R.id.display_field2);
        motoView = findViewById(R.id.display_field3);

/*
        for(int i = 0; i < garage.getCarBag().length; i++){


           if( !garage.getCarBag()[i].isFree()){
           temp = garage.getCarBag()[i].getVehicle().getFalseCategory();
           temp2 = temp.substring(0,1).toUpperCase();
           carView.append((i +1) +" [" + temp2  + " " + garage.getCarBag()[i].getVehicle().getLicensePlate() + "]" + "\n\n");
           }
            else {
               carView.append((i +1) + " [" + " " + "]" + "\n\n");
           }


        }
*/

        for(int i = 0; i < garage.getCarBag().length; i++){
            SpannableString str4;


            if( !garage.getCarBag()[i].isFree()){
                temp = garage.getCarBag()[i].getVehicle().getFalseCategory();


                String falseCategoryStr = temp.substring(0,1).toUpperCase();
                if(falseCategoryStr.equals("C")) {


                    str4 = new SpannableString(falseCategoryStr);
                    str4.setSpan(new ForegroundColorSpan(Color.BLUE), 0, falseCategoryStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    str4.setSpan(new StyleSpan(Typeface.BOLD), 0, falseCategoryStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                }
                else if(falseCategoryStr.equals("T")) {


                    str4 = new SpannableString(falseCategoryStr);
                    str4.setSpan(new ForegroundColorSpan(Color.RED), 0, falseCategoryStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    str4.setSpan(new StyleSpan(Typeface.BOLD), 0, falseCategoryStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                }
                else  {


                    str4 = new SpannableString(falseCategoryStr);
                    str4.setSpan(new ForegroundColorSpan(Color.MAGENTA), 0, falseCategoryStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    str4.setSpan(new StyleSpan(Typeface.BOLD), 0, falseCategoryStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                }


                tempSpan2 = new SpannedString((i +1) +" [");

                SpannedString tempSpan3=   new SpannedString( " " + garage.getCarBag()[i].getVehicle().getLicensePlate() + "]" + "\n\n");
                SpannedString result = (SpannedString) TextUtils.concat(tempSpan2, str4, tempSpan3);
                carView.append(result);
            }
            else {
                carView.append((i +1) + " [" + " " + "]" + "\n\n");
            }


        }

        for(int i = 0; i < garage.getTruckSpaceBag().length; i++){
            SpannableString str4;


            if( !garage.getTruckSpaceBag()[i].isFree()){
                temp = garage.getTruckSpaceBag()[i].getVehicle().getFalseCategory();


                String falseCategoryStr = temp.substring(0,1).toUpperCase();
                if(falseCategoryStr.equals("C")) {


                    str4 = new SpannableString(falseCategoryStr);
                    str4.setSpan(new ForegroundColorSpan(Color.BLUE), 0, falseCategoryStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    str4.setSpan(new StyleSpan(Typeface.BOLD), 0, falseCategoryStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                }
                else if(falseCategoryStr.equals("T")) {


                    str4 = new SpannableString(falseCategoryStr);
                    str4.setSpan(new ForegroundColorSpan(Color.RED), 0, falseCategoryStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    str4.setSpan(new StyleSpan(Typeface.BOLD), 0, falseCategoryStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                }
                else  {


                    str4 = new SpannableString(falseCategoryStr);
                    str4.setSpan(new ForegroundColorSpan(Color.MAGENTA), 0, falseCategoryStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    str4.setSpan(new StyleSpan(Typeface.BOLD), 0, falseCategoryStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                }


                tempSpan2 = new SpannedString((i +1) +" [");

                SpannedString tempSpan3=   new SpannedString( " " + garage.getTruckSpaceBag()[i].getVehicle().getLicensePlate() + "]" + "\n\n");
                SpannedString result = (SpannedString) TextUtils.concat(tempSpan2, str4, tempSpan3);
                truckView.append(result);
            }
            else {
                truckView.append((i +1) + " [" + " " + "]" + "\n\n");
            }


        }

        for(int i = 0; i < garage.getMotorcycleSpaceBag().length; i++){
            SpannableString str4;


            if( !garage.getMotorcycleSpaceBag()[i].isFree()){
                temp = garage.getMotorcycleSpaceBag()[i].getVehicle().getFalseCategory();


                String falseCategoryStr = temp.substring(0,1).toUpperCase();
                if(falseCategoryStr.equals("C")) {


                    str4 = new SpannableString(falseCategoryStr);
                    str4.setSpan(new ForegroundColorSpan(Color.BLUE), 0, falseCategoryStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    str4.setSpan(new StyleSpan(Typeface.BOLD), 0, falseCategoryStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                }
                else if(falseCategoryStr.equals("T")) {


                    str4 = new SpannableString(falseCategoryStr);
                    str4.setSpan(new ForegroundColorSpan(Color.RED), 0, falseCategoryStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    str4.setSpan(new StyleSpan(Typeface.BOLD), 0, falseCategoryStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                }
                else  {


                    str4 = new SpannableString(falseCategoryStr);
                    str4.setSpan(new ForegroundColorSpan(Color.MAGENTA), 0, falseCategoryStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    str4.setSpan(new StyleSpan(Typeface.BOLD), 0, falseCategoryStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                }


                tempSpan2 = new SpannedString((i +1) +" [");

                SpannedString tempSpan3=   new SpannedString( " " + garage.getMotorcycleSpaceBag()[i].getVehicle().getLicensePlate() + "]" + "\n\n");
                SpannedString result = (SpannedString) TextUtils.concat(tempSpan2, str4, tempSpan3);
                motoView.append(result);
            }
            else {
                motoView.append((i +1) + " [" + " " + "]" + "\n\n");
            }


        }

        /*


        for(int i = 0; i < garage.getTruckSpaceBag().length; i++){

            if( !garage.getTruckSpaceBag()[i].isFree()){
                temp = garage.getTruckSpaceBag()[i].getVehicle().getFalseCategory();
                temp2 = temp.substring(0,1).toUpperCase();
                truckView.append((i+1) +" [" + temp2 + " " + garage.getTruckSpaceBag()[i].getVehicle().getLicensePlate() +  "]" + "\n\n");
            }
            else {
                truckView.append((i + 1) + " [" + " " + "]" + "\n\n");
            }


        }
        */

        /*

        for(int i = 0; i < garage.getMotorcycleSpaceBag().length; i++){

            if( !garage.getMotorcycleSpaceBag()[i].isFree()){
                temp = garage.getMotorcycleSpaceBag()[i].getVehicle().getFalseCategory();
                temp2 = temp.substring(0,1).toUpperCase();
                motoView.append((i+1) +" [" + temp2 + " " + garage.getMotorcycleSpaceBag()[i].getVehicle().getLicensePlate() + "]" + "\n\n");
            }
            else {
                motoView.append((i + 1) + " [" + " " + "]" + "\n\n");
            }


        }

*/

    }
}
