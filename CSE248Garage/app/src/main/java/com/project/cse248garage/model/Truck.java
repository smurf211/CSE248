package com.project.cse248garage.model;

import java.io.Serializable;

public class Truck extends Vehicle implements Serializable {


    public static double earlyBird = 40.00;
    public static double perHour = 5.00;


    public Truck(String licensePlate, String attendantFirstName, String attendantLastName) {
        super(licensePlate, attendantFirstName, attendantLastName);
    }
}

