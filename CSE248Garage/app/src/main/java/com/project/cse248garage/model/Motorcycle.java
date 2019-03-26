package com.project.cse248garage.model;

public class Motorcycle {
    public String attendantFirstName;
    public String attendantLastName;
    public String licensePlate;
    public static double earlyBird = 10.00;
    public static double perHour = 1.00;


    public Motorcycle(String attendantFirstName, String attendantLastName, String licensePlate) {
        this.attendantFirstName = attendantFirstName;
        this.attendantLastName = attendantLastName;
        this.licensePlate = licensePlate;
    }
}
