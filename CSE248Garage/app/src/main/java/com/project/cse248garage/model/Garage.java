package com.project.cse248garage.model;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

import com.project.cse248garage.R;
import com.project.cse248garage.controller.BackgroundWorker;
import com.project.cse248garage.controller.MainActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * The type Garage.
 */
public class Garage implements Serializable {

    /**
     * The Exit.
     */
    public int exit = 0;
    /**
     * The Car bag.
     */
    public ParkingSpace[] carBag;
    /**
     * The Truck space bag.
     */
    public ParkingSpace[] truckSpaceBag;
    /**
     * The Motorcycle space bag.
     */
    public ParkingSpace[] motorcycleSpaceBag;
    /**
     * The Record bag.
     */
    RecordBag recordBag = new RecordBag();


    /**
     * The Car early bird.
     */
    public double carEarlyBird;
    /**
     * The Car per hour.
     */
    public double carPerHour;

    /**
     * The Truck early bird.
     */
    public double truckEarlyBird;
    /**
     * The Truck per hour.
     */
    public double truckPerHour;

    /**
     * The Moto early bird.
     */
    public double motoEarlyBird;
    /**
     * The Moto per hour.
     */
    public double motoPerHour;

    /**
     * The Garage created.
     */
    public boolean garageCreated;


    /**
     * The Bag.
     */
    UserAccountBag bag;

    /**
     * Instantiates a new Garage.
     */
    public Garage() {
        ParkingSpace.setCarDistance(1);
        ParkingSpace.setTruckDistance(1);
        ParkingSpace.setMotorcycleDistance(1);

        bag = new UserAccountBag();
    }


    /**
     * Instantiates a new Garage.
     *
     * @param carSize        the car size
     * @param motorcycleSize the motorcycle size
     * @param truckSize      the truck size
     */
    public Garage(int carSize, int motorcycleSize, int truckSize) {


        bag = new UserAccountBag();


        carBag = new ParkingSpace[carSize];
        loadCarSpaces(carSize);


        truckSpaceBag = new ParkingSpace[truckSize];
        loadTruckSpaces(truckSize);

        motorcycleSpaceBag = new ParkingSpace[motorcycleSize];
        loadMotorcycleSpaces(motorcycleSize);

    }

    /**
     * Sets spaces.
     *
     * @param carSize        the car size
     * @param motorcycleSize the motorcycle size
     * @param truckSize      the truck size
     */
    public void setSpaces(int carSize, int motorcycleSize, int truckSize) {
        carBag = new ParkingSpace[carSize];
        loadCarSpaces(carSize);


        truckSpaceBag = new ParkingSpace[truckSize];
        loadTruckSpaces(truckSize);

        motorcycleSpaceBag = new ParkingSpace[motorcycleSize];
        loadMotorcycleSpaces(motorcycleSize);
        this.garageCreated = true;

    }


    /**
     * Load car spaces.
     *
     * @param carSize the car size
     */
    public void loadCarSpaces(int carSize) {


        for (int i = 0; i < carSize; i++) {

            carBag[i] = new ParkingSpace("car", true, ParkingSpace.carDistance);
            carBag[i].setSpaceID("c" + String.valueOf(carBag[i].carDistance));
            carBag[i].setGarage(this);
            ParkingSpace.carDistance++;

        }


    }

    /**
     * Load truck spaces.
     *
     * @param truckSize the truck size
     */
    public void loadTruckSpaces(int truckSize) {


        for (int i = 0; i < truckSize; i++) {

            truckSpaceBag[i] = new ParkingSpace("truck", true, ParkingSpace.truckDistance);
            truckSpaceBag[i].setSpaceID("t" + String.valueOf(truckSpaceBag[i].truckDistance));
            truckSpaceBag[i].setGarage(this);
            ParkingSpace.truckDistance++;

        }


    }

    /**
     * Load motorcycle spaces.
     *
     * @param motorcycleSize the motorcycle size
     */
    public void loadMotorcycleSpaces(int motorcycleSize) {


        for (int i = 0; i < motorcycleSize; i++) {

            motorcycleSpaceBag[i] = new ParkingSpace("motorcycle", true, ParkingSpace.motorcycleDistance);
            motorcycleSpaceBag[i].setSpaceID("m" + String.valueOf(motorcycleSpaceBag[i].motorcycleDistance));
            motorcycleSpaceBag[i].setGarage(this);

            ParkingSpace.motorcycleDistance++;

        }


    }

    /**
     * Park from database parking space.
     *
     * @param vehicle the vehicle
     * @return the parking space
     */
    public ParkingSpace parkFromDatabase(Vehicle vehicle) {


        ParkingSpace openSpace = findBySpaceID(vehicle.getSpaceID());


        openSpace.setFree(false);
        openSpace.setEarlyBird(vehicle.isEarlyBird());
        openSpace.setVehicle(vehicle);

        openSpace.setTime(String.valueOf(vehicle.getTimeIn()));
        openSpace.setDate(String.valueOf(vehicle.getDateIn()));


        Ticket ticket = new Ticket(vehicle, vehicle.getDateIn(), vehicle.getTimeIn(), vehicle.getRate(), vehicle.isEarlyBird(), vehicle.getSpaceID());
        vehicle.setTicket(ticket);

        Record record = recordBag.getRecord(vehicle.getLicensePlate());

        if (record == null) {

            record = new Record(openSpace.getVehicle(), vehicle.getLicensePlate());
            recordBag.addRecord(record);
        }


        return openSpace;
    }


    /**
     * Park parking space.
     *
     * @param vehicle          the vehicle
     * @param category         the category
     * @param earlyBird        the early bird
     * @param backgroundWorker the background worker
     * @return the parking space
     */
    public ParkingSpace park(Vehicle vehicle, String category, Boolean earlyBird, BackgroundWorker backgroundWorker) {


        String typeVehicle = "create vehicle";


        ParkingSpace openSpace = findClosestSpace(category);


        openSpace.setFree(false);
        openSpace.setEarlyBird(earlyBird);
        openSpace.setVehicle(vehicle);


        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String[] tokens = timeStamp.split(" ");
        String date = tokens[0];
        String time = tokens[1];


        openSpace.setTime(time);
        openSpace.setDate(date);


        vehicle.setTimeIn(time);
        vehicle.setDateIn(date);


        double rate = openSpace.getPrice(category, earlyBird);

        Ticket ticket = new Ticket(vehicle, date, time, rate, earlyBird, openSpace.getSpaceID());
        vehicle.setTicket(ticket);

        Record record = recordBag.getRecord(vehicle.getLicensePlate());

        if (record == null) {

            record = new Record(openSpace.getVehicle(), vehicle.getLicensePlate());
            recordBag.addRecord(record);
        }


        User user = getBag().getLoggedInUser(getBag().getUserAccountHash());

        backgroundWorker.execute(typeVehicle, String.valueOf(user.emitID()), vehicle.getLicensePlate(), vehicle.getFalseCategory(), vehicle.getCategory(), openSpace.getSpaceID(),
                date, " ", time, "", convertBoolean(earlyBird), String.valueOf(rate));


        return openSpace;
    }

    /**
     * Park parking space.
     *
     * @param vehicle   the vehicle
     * @param category  the category
     * @param earlyBird the early bird
     * @return the parking space
     */
    public ParkingSpace park(Vehicle vehicle, String category, Boolean earlyBird) {


        ParkingSpace openSpace = findClosestSpace(category);


        openSpace.setFree(false);
        openSpace.setEarlyBird(earlyBird);
        openSpace.setVehicle(vehicle);


        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String[] tokens = timeStamp.split(" ");
        String date = tokens[0];
        String time = tokens[1];


        openSpace.setTime(time);
        openSpace.setDate(date);


        vehicle.setTimeIn(time);
        vehicle.setDateIn(date);


        double rate = openSpace.getPrice(category, earlyBird);

        Ticket ticket = new Ticket(vehicle, date, time, rate, earlyBird, openSpace.getSpaceID());
        vehicle.setTicket(ticket);

        Record record = recordBag.getRecord(vehicle.getLicensePlate());

        if (record == null) {

            record = new Record(openSpace.getVehicle(), vehicle.getLicensePlate());
            recordBag.addRecord(record);
        }


        return openSpace;
    }


    /**
     * Remove car reciept.
     *
     * @param licensePlate     the license plate
     * @param backgroundWorker the background worker
     * @param historyWorker    the history worker
     * @return the reciept
     */
    public Reciept removeCar(String licensePlate, BackgroundWorker backgroundWorker, BackgroundWorker historyWorker) {


        ParkingSpace currentSpace = findByPlate(licensePlate);


        String date = currentSpace.getDate();
        String time = currentSpace.getTime();
        Reciept reciept = new Reciept(currentSpace.getVehicle(), date, time,
                currentSpace.getVehicle().getTicket().getRate(), currentSpace.getVehicle().getTicket().isEarlyBird(), currentSpace.getSpaceID(), this);

        Record record = recordBag.getRecord(licensePlate);

        if (record == null) {

            record = new Record(currentSpace.getVehicle(), currentSpace.getVehicle().getLicensePlate());
            recordBag.addRecord(record);
        }

        record.addReciept(reciept);

        Vehicle vehicle = currentSpace.getVehicle();

        String typeHistory = "create history";
        historyWorker.execute(typeHistory, vehicle.getDateIn(), reciept.getDateOut(),
                vehicle.getTimeIn(), reciept.getTimeOut(), convertBoolean(vehicle.getTicket().isEarlyBird()),
                currentSpace.getSpaceID(), vehicle.getLicensePlate(), String.valueOf(vehicle.getAttendantId()),
                String.valueOf(vehicle.getAttendantRemovedId()), vehicle.getCategory(), vehicle.getFalseCategory(), String.valueOf(vehicle.getTicket().getRate()), String.valueOf(reciept.getPaymentScheme()),
                String.valueOf(vehicle.getVehicleId()));


        String typeRemove = "remove vehicle";
        backgroundWorker.execute(typeRemove, String.valueOf(currentSpace.getVehicle().getVehicleId()));

        currentSpace.removeVehicle();

        return reciept;
    }

    /**
     * Remove car reciept.
     *
     * @param licensePlate the license plate
     * @return the reciept
     */
    public Reciept removeCar(String licensePlate) {


        ParkingSpace currentSpace = findByPlate(licensePlate);


        String date = currentSpace.getDate();
        String time = currentSpace.getTime();
        Reciept reciept = new Reciept(currentSpace.getVehicle(), date, time,
                currentSpace.getVehicle().getTicket().getRate(), currentSpace.getVehicle().getTicket().isEarlyBird(), currentSpace.getSpaceID(), this);

        Record record = recordBag.getRecord(licensePlate);

        if (record == null) {

            record = new Record(currentSpace.getVehicle(), currentSpace.getVehicle().getLicensePlate());
            recordBag.addRecord(record);
        }

        record.addReciept(reciept);

        Vehicle vehicle = currentSpace.getVehicle();


        currentSpace.removeVehicle();

        return reciept;
    }

    /**
     * Find closest space parking space.
     *
     * @param category the category
     * @return the parking space
     */
    public ParkingSpace findClosestSpace(String category) {

        if (category.equals("car")) {

            for (int i = 0; i < carBag.length; i++) {


                if (carBag[i].isFree()) {

                    return carBag[i];

                }


            }


        }

        if (category.equals("truck")) {

            for (int i = 0; i < truckSpaceBag.length; i++) {

                if (truckSpaceBag[i].isFree()) {

                    return truckSpaceBag[i];

                }


            }


        }

        if (category.equals("motorcycle")) {

            for (int i = 0; i < motorcycleSpaceBag.length; i++) {

                if (motorcycleSpaceBag[i].isFree()) {

                    return motorcycleSpaceBag[i];

                }


            }


        }


        return null;

    }

    /**
     * Gets license plates.
     *
     * @return the license plates
     */
    public ArrayList<String> getLicensePlates() {


        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < carBag.length; i++) {

            if (!carBag[i].isFree()) {

                list.add(carBag[i].getVehicle().getLicensePlate());
            }


        }

        for (int i = 0; i < truckSpaceBag.length; i++) {

            if (!truckSpaceBag[i].isFree()) {

                list.add(truckSpaceBag[i].getVehicle().getLicensePlate());
            }


        }

        for (int i = 0; i < motorcycleSpaceBag.length; i++) {

            if (!motorcycleSpaceBag[i].isFree()) {

                list.add(motorcycleSpaceBag[i].getVehicle().getLicensePlate());
            }


        }


        return list;

    }


    /**
     * Find by plate parking space.
     *
     * @param licensePlate the license plate
     * @return the parking space
     */
    public ParkingSpace findByPlate(String licensePlate) {

        for (int i = 0; i < carBag.length; i++) {


            if (!carBag[i].isFree() && carBag[i].getVehicle().getLicensePlate().equals(licensePlate)) {

                return carBag[i];

            }


        }

        for (int i = 0; i < truckSpaceBag.length; i++) {


            if (!truckSpaceBag[i].isFree() && truckSpaceBag[i].getVehicle().getLicensePlate().equals(licensePlate)) {

                return truckSpaceBag[i];

            }


        }

        for (int i = 0; i < motorcycleSpaceBag.length; i++) {


            if (!motorcycleSpaceBag[i].isFree() && motorcycleSpaceBag[i].getVehicle().getLicensePlate().equals(licensePlate)) {

                return motorcycleSpaceBag[i];

            }


        }


        return null;

    }

    /**
     * Find by space id parking space.
     *
     * @param spaceID the space id
     * @return the parking space
     */
    public ParkingSpace findBySpaceID(String spaceID) {

        for (int i = 0; i < carBag.length; i++) {


            if (carBag[i].getSpaceID().equals(spaceID)) {

                //   System.out.println(carBag.toString());
                return carBag[i];

            }


        }

        for (int i = 0; i < truckSpaceBag.length; i++) {


            if (truckSpaceBag[i].getSpaceID().equals(spaceID)) {

                return truckSpaceBag[i];

            }


        }

        for (int i = 0; i < motorcycleSpaceBag.length; i++) {


            if (motorcycleSpaceBag[i].getSpaceID().equals(spaceID)) {

                return motorcycleSpaceBag[i];

            }


        }


        return null;

    }

    /**
     * Find by plate boolean boolean.
     *
     * @param licensePlate the license plate
     * @return the boolean
     */
    public boolean findByPlateBoolean(String licensePlate) {

        for (int i = 0; i < carBag.length; i++) {


            if (!carBag[i].isFree() && carBag[i].getVehicle().getLicensePlate().equals(licensePlate)) {

                return true;

            }


        }

        for (int i = 0; i < truckSpaceBag.length; i++) {


            if (!truckSpaceBag[i].isFree() && truckSpaceBag[i].getVehicle().getLicensePlate().equals(licensePlate)) {

                return true;

            }


        }

        for (int i = 0; i < motorcycleSpaceBag.length; i++) {


            if (!motorcycleSpaceBag[i].isFree() && motorcycleSpaceBag[i].getVehicle().getLicensePlate().equals(licensePlate)) {

                return true;

            }


        }


        return false;

    }

    /**
     * Gets garage size.
     *
     * @return the garage size
     */
    public int getGarageSize() {

        if (carBag != null && truckSpaceBag != null && motorcycleSpaceBag != null) {
            return carBag.length + motorcycleSpaceBag.length + truckSpaceBag.length;
        }

        return 0;
    }


    /**
     * Convert boolean string.
     *
     * @param earlyBird the early bird
     * @return the string
     */
    public static String convertBoolean(Boolean earlyBird) {

        if (earlyBird == true) {
            return "1";
        } else {
            return "0";
        }
    }


    /**
     * Get car bag parking space [ ].
     *
     * @return the parking space [ ]
     */
    public ParkingSpace[] getCarBag() {
        return carBag;
    }

    /**
     * Get truck space bag parking space [ ].
     *
     * @return the parking space [ ]
     */
    public ParkingSpace[] getTruckSpaceBag() {
        return truckSpaceBag;
    }

    /**
     * Get motorcycle space bag parking space [ ].
     *
     * @return the parking space [ ]
     */
    public ParkingSpace[] getMotorcycleSpaceBag() {
        return motorcycleSpaceBag;
    }

    /**
     * Gets car early bird.
     *
     * @return the car early bird
     */
    public double getCarEarlyBird() {
        return carEarlyBird;
    }

    /**
     * Sets car early bird.
     *
     * @param carEarlyBird the car early bird
     */
    public void setCarEarlyBird(double carEarlyBird) {
        this.carEarlyBird = carEarlyBird;
    }

    /**
     * Gets car per hour.
     *
     * @return the car per hour
     */
    public double getCarPerHour() {
        return carPerHour;
    }

    /**
     * Sets car per hour.
     *
     * @param carPerHour the car per hour
     */
    public void setCarPerHour(double carPerHour) {
        this.carPerHour = carPerHour;
    }

    /**
     * Gets truck early bird.
     *
     * @return the truck early bird
     */
    public double getTruckEarlyBird() {
        return truckEarlyBird;
    }

    /**
     * Sets truck early bird.
     *
     * @param truckEarlyBird the truck early bird
     */
    public void setTruckEarlyBird(double truckEarlyBird) {
        this.truckEarlyBird = truckEarlyBird;
    }

    /**
     * Gets truck per hour.
     *
     * @return the truck per hour
     */
    public double getTruckPerHour() {
        return truckPerHour;
    }

    /**
     * Sets truck per hour.
     *
     * @param truckPerHour the truck per hour
     */
    public void setTruckPerHour(double truckPerHour) {
        this.truckPerHour = truckPerHour;
    }

    /**
     * Gets moto early bird.
     *
     * @return the moto early bird
     */
    public double getMotoEarlyBird() {
        return motoEarlyBird;
    }

    /**
     * Sets moto early bird.
     *
     * @param motoEarlyBird the moto early bird
     */
    public void setMotoEarlyBird(double motoEarlyBird) {
        this.motoEarlyBird = motoEarlyBird;
    }

    /**
     * Gets moto per hour.
     *
     * @return the moto per hour
     */
    public double getMotoPerHour() {
        return motoPerHour;
    }

    /**
     * Sets moto per hour.
     *
     * @param motoPerHour the moto per hour
     */
    public void setMotoPerHour(double motoPerHour) {
        this.motoPerHour = motoPerHour;
    }

    /**
     * Gets bag.
     *
     * @return the bag
     */
    public UserAccountBag getBag() {
        return bag;
    }

    /**
     * Is garage created boolean.
     *
     * @return the boolean
     */
    public boolean isGarageCreated() {
        return garageCreated;
    }

    /**
     * Sets garage created.
     *
     * @param garageCreated the garage created
     */
    public void setGarageCreated(boolean garageCreated) {
        this.garageCreated = garageCreated;
    }

    /**
     * Gets record bag.
     *
     * @return the record bag
     */
    public RecordBag getRecordBag() {
        return recordBag;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "exit=" + exit +
                ", carBag=" + Arrays.toString(carBag) +
                ", truckSpaceBag=" + Arrays.toString(truckSpaceBag) +
                ", motorcycleSpaceBag=" + Arrays.toString(motorcycleSpaceBag) +
                ", recordBag=" + recordBag +
                ", carEarlyBird=" + carEarlyBird +
                ", carPerHour=" + carPerHour +
                ", truckEarlyBird=" + truckEarlyBird +
                ", truckPerHour=" + truckPerHour +
                ", motoEarlyBird=" + motoEarlyBird +
                ", motoPerHour=" + motoPerHour +
                ", garageCreated=" + garageCreated +
                ", bag=" + bag +
                '}';
    }
}
