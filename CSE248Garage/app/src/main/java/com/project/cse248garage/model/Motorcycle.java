package com.project.cse248garage.model;

import java.io.Serializable;

public class Motorcycle extends Vehicle implements Serializable {


    @Override
    public String getCategory() {
        return "motorcycle";
    }

    public Motorcycle(String licensePlate, String attendantFirstName, String attendantLastName, int attendantId) {
        super(licensePlate, attendantFirstName, attendantLastName, attendantId);
    }

    public Motorcycle(int vehicleId, int attendantId, String licensePlate, String falseCategory, String spaceID, String dateIn, String timeIn, boolean earlyBird, double rate) {
        super(vehicleId, attendantId, licensePlate, falseCategory, spaceID, dateIn, timeIn, earlyBird, rate);
    }
}
