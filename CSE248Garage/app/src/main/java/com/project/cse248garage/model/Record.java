package com.project.cse248garage.model;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;

import java.io.Serializable;
import java.util.ArrayList;

public class Record implements Serializable {


    String licensePlate;
    Vehicle vehicle;

    ArrayList<Reciept> reciepts;



    public Record(Vehicle vehicle, String licensePlate){

        reciepts = new ArrayList<Reciept>();

        this.vehicle = vehicle;
        this.licensePlate = licensePlate;

    }



    public void addReciept(Reciept reciept){

        reciepts.add(reciept);

    }


    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }





    public ArrayList<Reciept> getReciepts() {
        return reciepts;
    }

    public void setReciepts(ArrayList<Reciept> reciepts) {
        this.reciepts = reciepts;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String toString() {

        return "Record: " + "\n" +
                vehicle + "\n" +
                "Receipts: " + "\n";


    }

    public SpannedString toStringSpan() {


        SpannedString result = (SpannedString) TextUtils.concat( vehicle.toStringSpan());



        return result;


    }

    public String toStringPresent() {



        return "Record: " + "\n" +
                vehicle + "\n" +

                "Ticket: " + vehicle.getTicket() + "\n" ;
    }

    public SpannedString toStringSpanPresent() {




        SpannedString result = (SpannedString) TextUtils.concat(vehicle.toStringSpan(), vehicle.getTicket().toStringSpan());





        return result;


    }


}
