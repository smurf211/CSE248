package com.project.cse248garage.model;

import java.io.Serializable;

public class Motorcycle extends Vehicle implements Serializable {


    @Override
    public String getCategory() {
        return "motorcycle";
    }

    public Motorcycle(String licensePlate, String attendantFirstName, String attendantLastName, String attendantId) {
        super(licensePlate, attendantFirstName, attendantLastName, attendantId);
    }



}
