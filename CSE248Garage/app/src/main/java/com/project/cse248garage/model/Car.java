package com.project.cse248garage.model;

import java.io.Serializable;

public class Car extends Vehicle implements Serializable {


    @Override
    public String getCategory() {
        return "car";
    }

    public Car(String licensePlate, String attendantFirstName, String attendantLastName, String attendantId) {
        super(licensePlate, attendantFirstName, attendantLastName, attendantId);
    }


}
