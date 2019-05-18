package com.project.cse248garage.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * The type Parking space.
 */
public class ParkingSpace implements Serializable {

    /**
     * The Category.
     */
    String category;
    /**
     * The constant carDistance.
     */
    public static int carDistance = 1;
    /**
     * The constant truckDistance.
     */
    public static int truckDistance = 1;
    /**
     * The constant motorcycleDistance.
     */
    public static int motorcycleDistance = 1;
    /**
     * The Distance.
     */
    public int distance;
    /**
     * The Early bird.
     */
    boolean earlyBird;
    /**
     * The Price.
     */
    double price;
    /**
     * The Free.
     */
    boolean free; // 1 = free space, 0 = full space
    /**
     * The Vehicle.
     */
    Vehicle vehicle;
    /**
     * The Time.
     */
    String time;
    /**
     * The Date.
     */
    String date;

    /**
     * The Space id.
     */
    public String spaceID;
    /**
     * The Garage.
     */
    Garage garage;


    /**
     * Instantiates a new Parking space.
     *
     * @param category the category
     * @param free     the free
     * @param distance the distance
     */
    public ParkingSpace(String category, boolean free, int distance) {

        this.category = category;
        this.distance = distance;
        this.free = free;


    }


    /**
     * Instantiates a new Parking space.
     *
     * @param category  the category
     * @param free      the free
     * @param earlyBird the early bird
     * @param vehicle   the vehicle
     */
    public ParkingSpace(String category, boolean free, boolean earlyBird, Vehicle vehicle) {
        this.category = category;
        this.distance = getDistance(category);
        this.earlyBird = earlyBird;
        this.price = getPrice(category, earlyBird);
        this.free = free;
        this.vehicle = vehicle;


    }


    /**
     * Remove vehicle.
     */
    public void removeVehicle() {
        this.earlyBird = false;
        this.price = 0;
        this.free = true;
        this.vehicle = null;


    }


    /**
     * Gets price.
     *
     * @param category  the category
     * @param earlyBird the early bird
     * @return the price
     */
    public double getPrice(String category, boolean earlyBird) {

        if (earlyBird) {

            if (category.equals("car")) {

                return garage.getCarEarlyBird();

            }

            if (category.equals("truck")) {

                return garage.getTruckEarlyBird();

            }

            if (category.equals("motorcycle")) {

                return garage.getMotoEarlyBird();

            }
        }

        if (!earlyBird) {

            if (category.equals("car")) {

                return garage.getCarPerHour();

            }

            if (category.equals("truck")) {

                return garage.getTruckPerHour();

            }

            if (category.equals("motorcycle")) {

                return garage.getMotoPerHour();

            }


        }

        return 0;

    }


    /**
     * Gets distance.
     *
     * @param category the category
     * @return the distance
     */
    public int getDistance(String category) {

        if (category.equals("motorcycle")) {

            int distance = motorcycleDistance;
            motorcycleDistance++;
            return distance;
        }

        if (category.equals("truck")) {

            int distance = truckDistance;
            truckDistance++;
            return distance;
        } else {

            int distance = carDistance;
            carDistance++;
            return distance;
        }


    }

    /**
     * Sets early bird.
     *
     * @param earlyBird the early bird
     */
    public void setEarlyBird(boolean earlyBird) {
        this.earlyBird = earlyBird;
    }

    /**
     * Is free boolean.
     *
     * @return the boolean
     */
    public boolean isFree() {
        return free;
    }

    /**
     * Sets free.
     *
     * @param free the free
     */
    public void setFree(boolean free) {
        this.free = free;
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets time.
     *
     * @param time the time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets vehicle.
     *
     * @return the vehicle
     */
    public Vehicle getVehicle() {
        return vehicle;
    }


    /**
     * Gets category.
     *
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }


    /**
     * Sets vehicle.
     *
     * @param vehicle the vehicle
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Is early bird boolean.
     *
     * @return the boolean
     */
    public boolean isEarlyBird() {
        return earlyBird;
    }

    /**
     * Gets space id.
     *
     * @return the space id
     */
    public String getSpaceID() {
        return spaceID;
    }

    /**
     * Sets space id.
     *
     * @param spaceID the space id
     */
    public void setSpaceID(String spaceID) {
        this.spaceID = spaceID;
    }

    /**
     * Gets garage.
     *
     * @return the garage
     */
    public Garage getGarage() {
        return garage;
    }

    /**
     * Sets garage.
     *
     * @param garage the garage
     */
    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    /**
     * Gets car distance.
     *
     * @return the car distance
     */
    public static int getCarDistance() {
        return carDistance;
    }

    /**
     * Sets car distance.
     *
     * @param carDistance the car distance
     */
    public static void setCarDistance(int carDistance) {
        ParkingSpace.carDistance = carDistance;
    }

    /**
     * Gets truck distance.
     *
     * @return the truck distance
     */
    public static int getTruckDistance() {
        return truckDistance;
    }

    /**
     * Sets truck distance.
     *
     * @param truckDistance the truck distance
     */
    public static void setTruckDistance(int truckDistance) {
        ParkingSpace.truckDistance = truckDistance;
    }

    /**
     * Gets motorcycle distance.
     *
     * @return the motorcycle distance
     */
    public static int getMotorcycleDistance() {
        return motorcycleDistance;
    }

    /**
     * Sets motorcycle distance.
     *
     * @param motorcycleDistance the motorcycle distance
     */
    public static void setMotorcycleDistance(int motorcycleDistance) {
        ParkingSpace.motorcycleDistance = motorcycleDistance;
    }

    /**
     * Gets distance.
     *
     * @return the distance
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Sets distance.
     *
     * @param distance the distance
     */
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
                ", free=" + free + "\n" +
                ", spaceID='" + spaceID;


    }
}
