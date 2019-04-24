package com.project.cse248garage.model;

import java.io.Serializable;

public abstract class Vehicle implements Serializable {

    String licensePlate;
    public String attendantFirstName;
    public String attendantLastName;
    public String attendantId;


    public abstract String getCategory();



    public Vehicle(String licensePlate, String attendantFirstName, String attendantLastName, String attendantId) {
        this.licensePlate = licensePlate;
        this.attendantFirstName = attendantFirstName;
        this.attendantLastName = attendantLastName;
        this.attendantId = attendantId;
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

    public String getAttendantId() {
        return attendantId;
    }

    public void setAttendantId(String attendantId) {
        this.attendantId = attendantId;
    }
}
