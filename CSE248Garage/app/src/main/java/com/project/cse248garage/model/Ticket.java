package com.project.cse248garage.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket implements Serializable {


    Vehicle vehicle;
    String date;
    String time;
    double rate;
    boolean earlyBird;
    public String spaceID;


    public Ticket(){


    }


    public Ticket(Vehicle vehicle, String date, String time, double rate, boolean earlyBird, String spaceID) {

        this.date = date;
        this.time = time;
        this.rate = rate;
        this.earlyBird = earlyBird;
        this.spaceID = spaceID;
        this.vehicle = vehicle;


    }




    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public double getRate() {
        return rate;
    }

    public boolean isEarlyBird() {
        return earlyBird;
    }

    public String getEarlyBirdString(){
        if(earlyBird){
            return "Yes";
        }
        else{
            return "No";
        }
    }

    public String getCurrency(){
        if(earlyBird) {
            return "$" + addZeroToRate(rate) + " Flat rate.";

        }
        else{
            return "$" + addZeroToRate(rate) + " Per Hour.";
        }
    }

    public static String addZeroToRate(double rate){

        if(!String.valueOf(rate).contains(".")){

            return String.valueOf(rate);
        }

        String[] rateTokens = String.valueOf(rate).split("[.]");

        if(rateTokens[1].length() == 1){

         return String.valueOf(rate) + "0";
        }
        else{
            return String.valueOf(rate);
        }

    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Ticket" + "\n"+
                "License Plate: " + getVehicle().getLicensePlate() + "\n" +
                "Category : " + getVehicle().getCategory() + "\n" +
                "Attendant Name/ID: " + getVehicle().getAttendantFirstName() + " "+
                  getVehicle().getAttendantLastName() + " " +
                 getVehicle().getAttendantId() + "\n" +
                "Date/Time: " + date + " "  +
                 Reciept.convertTimeFromMilitary(time) + '\n' +
                "Rate: " + getCurrency()+  "\n" +
                "Early Bird: " + getEarlyBirdString() + "\n" +
                "Space ID: " + this.spaceID;
    }
}
