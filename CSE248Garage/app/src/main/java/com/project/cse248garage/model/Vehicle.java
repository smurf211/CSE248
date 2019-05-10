package com.project.cse248garage.model;

import java.io.Serializable;

public abstract class Vehicle implements Serializable {

    int vehicleId;
    String licensePlate;
    public String attendantFirstName;
    public String attendantLastName;
    int attendantId;
    public String falseCategory;
    public Ticket ticket;
    String attendantRemovedFirst;
    String attendantRemovedLast;
    int attendantRemovedId;




    public abstract String getCategory();



    public Vehicle(String licensePlate, String attendantFirstName, String attendantLastName, int attendantId) {
        this.licensePlate = licensePlate;
        this.attendantFirstName = attendantFirstName;
        this.attendantLastName = attendantLastName;
        this.attendantId = attendantId;
    }

    @Override
    public String toString() {
        return "Vehicle " + "\n"+
                "ID: " + vehicleId + "\n"+
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

    public int getAttendantId() {
        return attendantId;
    }

    public void setAttendantId(int attendantId) {
        this.attendantId = attendantId;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getAttendantRemovedFirst() {
        return attendantRemovedFirst;
    }

    public void setAttendantRemovedFirst(String attendantRemovedFirst) {
        this.attendantRemovedFirst = attendantRemovedFirst;
    }

    public String getAttendantRemovedLast() {
        return attendantRemovedLast;
    }

    public void setAttendantRemovedLast(String attendantRemovedLast) {
        this.attendantRemovedLast = attendantRemovedLast;
    }

    public int getAttendantRemovedId() {
        return attendantRemovedId;
    }

    public void setAttendantRemovedId(int attendantRemovedId) {
        this.attendantRemovedId = attendantRemovedId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
}
