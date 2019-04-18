package com.project.cse248garage.model;

import java.io.Serializable;

public class Ticket implements Serializable {

    String licensePlate;
    String category;
    String attendantFirstName;
    String attendantLastName;
    String date;
    String time;
    double paymentScheme;
    boolean earlyBird;
    public String spaceID;

    public Ticket(){


    }


    public Ticket(String licensePlate, String category, String attendantFirstName, String attendantLastName, String date,String time, double paymentScheme, boolean earlyBird, String spaceID) {
        this.licensePlate = licensePlate;
        this.category = category;
        this.attendantFirstName = attendantFirstName;
        this.attendantLastName = attendantLastName;
        this.date = date;
        this.time = time;
        this.paymentScheme = paymentScheme;
        this.earlyBird = earlyBird;
        this.spaceID = spaceID;
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
                "licensePlate='" + licensePlate + "\n" +
                ", category='" + category + "\n" +
                ", attendantFirstName='" + attendantFirstName + "\n" +
                ", attendantLastName='" + attendantLastName + "\n" +
                ", date='" + date + "\n" +
                ", time='" + time + '\n' +
                ", paymentScheme=" + paymentScheme +  "\n" + "Space ID: " + this.spaceID;
    }
}
