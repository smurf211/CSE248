package com.project.cse248garage.model;

import java.io.Serializable;

public abstract class Vehicle implements Serializable {

    String licensePlate;
    public String attendantFirstName;
    public String attendantLastName;
    //add attendant removed functionality
    //add attendant id to ticket
    //allow smaller vehicle to park in larger space
    //add binary file loading garage
    //add admin defined payment scheme

    public Vehicle(String licensePlate, String attendantFirstName, String attendantLastName) {
        this.licensePlate = licensePlate;
        this.attendantFirstName = attendantFirstName;
        this.attendantLastName = attendantLastName;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlate='" + licensePlate + '\'' +
                ", attendantFirstName='" + attendantFirstName + '\'' +
                ", attendantLastName='" + attendantLastName + '\'' +
                '}';
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getAttendantFirstName() {
        return attendantFirstName;
    }

    public String getAttendantLastName() {
        return attendantLastName;
    }
}
