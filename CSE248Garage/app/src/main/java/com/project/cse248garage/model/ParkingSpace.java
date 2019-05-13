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
    String time;
    String date;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }



    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }



    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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

    public static int getCarDistance() {
        return carDistance;
    }

    public static void setCarDistance(int carDistance) {
        ParkingSpace.carDistance = carDistance;
    }

    public static int getTruckDistance() {
        return truckDistance;
    }

    public static void setTruckDistance(int truckDistance) {
        ParkingSpace.truckDistance = truckDistance;
    }

    public static int getMotorcycleDistance() {
        return motorcycleDistance;
    }

    public static void setMotorcycleDistance(int motorcycleDistance) {
        ParkingSpace.motorcycleDistance = motorcycleDistance;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }



    @Override
    public String toString() {
        return "ParkingSpace{" +
                "category='" + category + '\'' +
                ", distance=" + distance +
                ", earlyBird=" + earlyBird +
                ", price=" + price + "\n" +
                ", free=" + free + "\n"+
                ", spaceID='" + spaceID ;


    }
}
