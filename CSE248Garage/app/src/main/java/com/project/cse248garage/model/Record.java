package com.project.cse248garage.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Record implements Serializable {


    String licensePlate;
    Vehicle vehicle;
    ArrayList<Ticket> tickets;
    ArrayList<Reciept> reciepts;



    public Record(Vehicle vehicle, String licensePlate){
        tickets = new ArrayList<Ticket>();
        reciepts = new ArrayList<Reciept>();

        this.vehicle = vehicle;
        this.licensePlate = licensePlate;

    }

    public void addTicket(Ticket ticket){

        tickets.add(ticket);

    }

    public void addReciept(Reciept reciept){

        reciepts.add(reciept);

    }


    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public ArrayList<Reciept> getReciepts() {
        return reciepts;
    }

    public void setReciepts(ArrayList<Reciept> reciepts) {
        this.reciepts = reciepts;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String toString() {
        return "Record: " +
                "Vehicle: " + vehicle + "\n" +
                "Tickets: " + tickets +  "\n" +
                "Reciepts: " + reciepts;
    }
}
