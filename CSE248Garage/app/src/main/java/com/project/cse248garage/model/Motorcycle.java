package com.project.cse248garage.model;

import java.io.Serializable;

public class Motorcycle extends Vehicle implements Serializable {

    public static double earlyBird = 10.00;
    public static double perHour = 1.00;


    public Motorcycle(String licensePlate, String attendantFirstName, String attendantLastName) {
        super(licensePlate, attendantFirstName, attendantLastName);
    }
}
