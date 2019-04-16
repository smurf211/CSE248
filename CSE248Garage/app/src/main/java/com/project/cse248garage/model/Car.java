package com.project.cse248garage.model;

import java.io.Serializable;

public class Car extends Vehicle implements Serializable {


    public static double earlyBird = 20.00;
    public static double perHour = 2.50;


    public Car(String licensePlate, String attendantFirstName, String attendantLastName) {
        super(licensePlate, attendantFirstName, attendantLastName);
    }
}
