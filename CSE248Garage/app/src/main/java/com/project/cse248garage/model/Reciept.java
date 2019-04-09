package com.project.cse248garage.model;

public class Reciept extends Ticket {


    public Reciept(String licensePlate, String category, String attendantFirstName, String attendantLastName, String date, String time, double paymentScheme) {
        super(licensePlate, category, attendantFirstName, attendantLastName, date, time, paymentScheme);
    }
}
