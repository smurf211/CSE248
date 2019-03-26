package com.project.cse248garage.model;

public class Truck {

    public String attendantFirstName;
    public String attendantLastName;
    public String licensePlate;
    public static double earlyBird = 40.00;
    public static double perHour = 5.00;


    public Truck(String attendantFirstName, String attendantLastName, String licensePlate) {
        this.attendantFirstName = attendantFirstName;
        this.attendantLastName = attendantLastName;
        this.licensePlate = licensePlate;
    }
}
