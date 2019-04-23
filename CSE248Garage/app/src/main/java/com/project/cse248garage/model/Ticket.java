package com.project.cse248garage.model;

import java.io.Serializable;

public class Ticket implements Serializable {

    String licensePlate;
    String category;
    String attendantFirstName;
    String attendantLastName;
    String attendantID;
    String date;
    String time;
    double paymentScheme;
    boolean earlyBird;
    public String spaceID;

    public Ticket(){


    }


    public Ticket(String licensePlate, String category, String attendantFirstName, String attendantLastName, String date,String time, double paymentScheme, boolean earlyBird, String spaceID, String attendantID) {
        this.licensePlate = licensePlate;
        this.category = category;
        this.attendantFirstName = attendantFirstName;
        this.attendantLastName = attendantLastName;
        this.date = date;
        this.time = time;
        this.paymentScheme = paymentScheme;
        this.earlyBird = earlyBird;
        this.spaceID = spaceID;
        this.attendantID = attendantID;
    }


    public String getLicensePlate() {
        return licensePlate;
    }

    public String getCategory() {
        return category;
    }

    public String getAttendantFirstName() {
        return attendantFirstName;
    }

    public String getAttendantLastName() {
        return attendantLastName;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public double getPaymentScheme() {
        return paymentScheme;
    }

    public boolean isEarlyBird() {
        return earlyBird;
    }

    @Override
    public String toString() {
        return "Ticket" + "\n"+
                "License Plate: " + licensePlate + "\n" +
                "Category : " + category + "\n" +
                "Attendant Name: " + attendantFirstName +
                  attendantLastName + "\n" +
                "Attendant ID: " + attendantID + "\n" +
                "Date: " + date + "\n" +
                "Time: " + time + '\n' +
                "Payment: " + paymentScheme +  "\n" +
                "Early Bird: " + earlyBird + "\n" +
                 "Space ID: " + this.spaceID;
    }
}
