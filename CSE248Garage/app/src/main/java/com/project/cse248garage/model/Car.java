package com.project.cse248garage.model;

public class Car extends Vehicle{


    public static double earlyBird = 20.00;
    public static double perHour = 2.50;


    public Car(String licensePlate, String attendantFirstName, String attendantLastName) {
        super(licensePlate, attendantFirstName, attendantLastName);
    }
}
