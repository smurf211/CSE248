package com.project.cse248garage.model;

public class Motorcycle extends Vehicle{

    public static double earlyBird = 10.00;
    public static double perHour = 1.00;


    public Motorcycle(String licensePlate, String attendantFirstName, String attendantLastName) {
        super(licensePlate, attendantFirstName, attendantLastName);
    }
}
