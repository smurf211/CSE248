package com.project.cse248garage.model;

public class Car {

    public String attendantFirstName;
    public String attendantLastName;
    public String licensePlate;
    public static double earlyBird = 20.00;
    public static double perHour = 2.50;


    public Car(String attendantFirstName, String attendantLastName, String licensePlate) {
        this.attendantFirstName = attendantFirstName;
        this.attendantLastName = attendantLastName;
        this.licensePlate = licensePlate;
    }


}
