package com.project.cse248garage.model;

import java.io.Serializable;

public class Truck extends Vehicle implements Serializable {


    @Override
    public String getCategory() {
        return "truck";
    }

    public Truck(String licensePlate, String attendantFirstName, String attendantLastName, String attendantId) {
        super(licensePlate, attendantFirstName, attendantLastName, attendantId);
    }



}

