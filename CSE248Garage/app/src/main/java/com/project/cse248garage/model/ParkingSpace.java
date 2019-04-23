package com.project.cse248garage.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class ParkingSpace implements Serializable {

    String category;
    public static int carDistance = 1;
    public static int truckDistance = 1;
    public static int motorcycleDistance = 1;
    public int distance;
    boolean earlyBird;
    double price;
    boolean free; // 1 = free space, 0 = full space
    Vehicle vehicle;
    LocalTime time;
    LocalDate date;
    Ticket ticket;
    public String spaceID;
    Garage garage;


    public ParkingSpace(String category, boolean free, int distance){

        this.category = category;
        this.distance = distance;
        this.free = free;


    }



    public ParkingSpace(String category,boolean free, boolean earlyBird, Vehicle vehicle) {
        this.category = category;
        this.distance = getDistance(category);
        this.earlyBird = earlyBird;
        this.price = getPrice(category, earlyBird);
        this.free = free;
        this.vehicle = vehicle;



    }


    public void removeVehicle(){
        this.earlyBird = false;
        this.price = 0;
        this.free = true;
        this.vehicle = null;


    }



    public double getPrice(String category, boolean earlyBird){

        if(earlyBird){

            if(category.equals("car")){

                return garage.getCarEarlyBird();

            }

            if(category.equals("truck")){

                return garage.getTruckEarlyBird();

            }

            if(category.equals("motorcycle")){

                return garage.getMotoEarlyBird();

            }
        }

        if(!earlyBird){

            if(category.equals("car")){

                return garage.getCarPerHour();

            }

            if(category.equals("truck")){

                return garage.getTruckPerHour();

            }

            if(category.equals("motorcycle")){

                return garage.getMotoPerHour();

            }





        }

     return 0;

    }

    public int getDistance(String category){

        if(category.equals("motorcycle")){

            int distance = motorcycleDistance;
            motorcycleDistance++;
            return distance;
        }

        if(category.equals("truck")){

            int distance = truckDistance;
            truckDistance++;
            return distance;
        }

        else {

            int distance = carDistance;
            carDistance++;
            return distance;
        }



    }

    public void setEarlyBird(boolean earlyBird) {
        this.earlyBird = earlyBird;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalTime getTime() {
        return time;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isEarlyBird() {
        return earlyBird;
    }

    public String getSpaceID() {
        return spaceID;
    }

    public void setSpaceID(String spaceID) {
        this.spaceID = spaceID;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    @Override
    public String toString() {
        return "ParkingSpace{" +
                "category='" + category + '\'' +
                ", distance=" + distance +
                ", earlyBird=" + earlyBird +
                ", price=" + price +
                ", free=" + free +
                '}';
    }
}
