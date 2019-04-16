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

    public Ticket(){


    }


    public Ticket(String licensePlate, String category, String attendantFirstName, String attendantLastName, String date,String time, double paymentScheme) {
        this.licensePlate = licensePlate;
        this.category = category;
        this.attendantFirstName = attendantFirstName;
        this.attendantLastName = attendantLastName;
        this.date = date;
        this.time = time;
        this.paymentScheme = paymentScheme;
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
}
