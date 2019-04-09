package com.project.cse248garage.model;

public abstract class Vehicle {

    String licensePlate;
    public String attendantFirstName;
    public String attendantLastName;

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
