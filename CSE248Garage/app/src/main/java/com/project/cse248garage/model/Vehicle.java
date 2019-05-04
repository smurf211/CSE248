package com.project.cse248garage.model;

import java.io.Serializable;

public abstract class Vehicle implements Serializable {

    String licensePlate;
    public String attendantFirstName;
    public String attendantLastName;
    public String attendantId;
    public String falseCategory;




    public abstract String getCategory();



    public Vehicle(String licensePlate, String attendantFirstName, String attendantLastName, String attendantId) {
        this.licensePlate = licensePlate;
        this.attendantFirstName = attendantFirstName;
        this.attendantLastName = attendantLastName;
        this.attendantId = attendantId;
    }

    @Override
    public String toString() {
        return "Vehicle " + "\n"+
                " License Plate: " + licensePlate
                + "\n" +
                "Category: " + getCategory()
                ;
    }

    public String getFalseCategory() {
        return falseCategory;
    }

    public void setFalseCategory(String falseCategory) {
        this.falseCategory = falseCategory;
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
