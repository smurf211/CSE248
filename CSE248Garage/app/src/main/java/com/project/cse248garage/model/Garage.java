package com.project.cse248garage.model;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

import com.project.cse248garage.R;
import com.project.cse248garage.controller.MainActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;

public class Garage implements Serializable {

    public int exit = 0;
    public ParkingSpace[] carBag;
    public ParkingSpace[] truckSpaceBag;
    public ParkingSpace[] motorcycleSpaceBag;

    public double carEarlyBird;
    public double carPerHour;

    public double truckEarlyBird;
    public double truckPerHour;

    public double motoEarlyBird;
    public double motoPerHour;
    public boolean garageCreated;



    UserAccountBag bag;

    public Garage(){
        bag = new UserAccountBag();
    }


    public Garage(int carSize, int motorcycleSize, int truckSize){


        carBag = new ParkingSpace[carSize];
        loadCarSpaces(carSize);


        truckSpaceBag = new ParkingSpace[truckSize];
        loadTruckSpaces(truckSize);

        motorcycleSpaceBag = new ParkingSpace[motorcycleSize];
        loadMotorcycleSpaces(motorcycleSize);

    }

    public void setSpaces(int carSize, int motorcycleSize, int truckSize){
        carBag = new ParkingSpace[carSize];
        loadCarSpaces(carSize);


        truckSpaceBag = new ParkingSpace[truckSize];
        loadTruckSpaces(truckSize);

        motorcycleSpaceBag = new ParkingSpace[motorcycleSize];
        loadMotorcycleSpaces(motorcycleSize);
        this.garageCreated = true;

    }


    public void loadCarSpaces(int carSize){


        for(int i =0; i < carSize; i++){

            carBag[i] = new ParkingSpace("car", true, ParkingSpace.carDistance++);
            carBag[i].setSpaceID("c"+ String.valueOf(carBag[i].carDistance));
            carBag[i].setGarage(this);

        }




    }

    public void loadTruckSpaces(int truckSize){


        for(int i =0; i < truckSize; i++){

            truckSpaceBag[i] = new ParkingSpace("truck",true, ParkingSpace.truckDistance++);
            truckSpaceBag[i].setSpaceID("t"+ String.valueOf(truckSpaceBag[i].truckDistance));
            truckSpaceBag[i].setGarage(this);

        }




    }

    public void loadMotorcycleSpaces(int motorcycleSize){


        for(int i =0; i < motorcycleSize; i++){

            motorcycleSpaceBag[i] = new ParkingSpace("motorcycle", true, ParkingSpace.motorcycleDistance++);
            motorcycleSpaceBag[i].setSpaceID("m"+ String.valueOf(motorcycleSpaceBag[i].carDistance));
            motorcycleSpaceBag[i].setGarage(this);

        }




    }



    public void park(Vehicle vehicle, String category, Boolean earlyBird){

       // if(findClosestSpace(category) == null){

            //return false;

      //  }

        ParkingSpace openSpace = findClosestSpace(category);

        openSpace.setFree(false);
        openSpace.setEarlyBird(earlyBird);
        openSpace.setVehicle(vehicle);


        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();



        openSpace.setTime(java.time.LocalTime.now());
        openSpace.setDate(java.time.LocalDate.now());

        String time = String.valueOf(getRecieptTime(openSpace));

         String date1 =  String.valueOf(getRecieptDate(openSpace));

        Ticket ticket = new Ticket(openSpace.getVehicle().getLicensePlate(), openSpace.getCategory(),
                openSpace.getVehicle().getAttendantFirstName(),
                openSpace.getVehicle().getAttendantLastName(), date1, time, openSpace.getPrice(category, earlyBird), earlyBird, openSpace.getSpaceID(), openSpace.getVehicle().getAttendantId());
        openSpace.setTicket(ticket);


    }




    public ParkingSpace findClosestSpace(String category){

        if(category.equals("car")){

            for(int i =0; i < carBag.length; i++){



               if( carBag[i].isFree()){

                   return carBag[i];

                }


            }



        }

        if(category.equals("truck")){

            for(int i =0; i < truckSpaceBag.length; i++){

                if( truckSpaceBag[i].isFree()){

                    return truckSpaceBag[i];

                }


            }



        }

        if(category.equals("motorcycle")){

            for(int i =0; i < motorcycleSpaceBag.length; i++){

                if( motorcycleSpaceBag[i].isFree()){

                    return motorcycleSpaceBag[i];

                }


            }



        }




    return null;

    }



    public Reciept removeCar(String licensePlate){


    ParkingSpace currentSpace = findByPlate(licensePlate);

      //  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
      //  Date date1 = new Date();



     //   currentSpace.setTime(java.time.LocalTime.now());
      //  currentSpace.setDate(java.time.LocalDate.now());

    String date = String.valueOf(getRecieptDate(currentSpace));
     String time =   String.valueOf(getRecieptTime(currentSpace));
        Reciept reciept = new Reciept(currentSpace.getVehicle().getLicensePlate(), currentSpace.getCategory(),
                currentSpace.getVehicle().getAttendantFirstName(),
                currentSpace.getVehicle().getAttendantLastName(), date, time,
                currentSpace.getTicket().getPaymentScheme(), currentSpace.getTicket().isEarlyBird(), currentSpace.getSpaceID(),currentSpace.getVehicle().getAttendantId(), this);

        currentSpace.removeVehicle();

    return reciept;
    }




    public LocalTime getRecieptTime(ParkingSpace currentSpace){

        return currentSpace.getTime();


    }


    public LocalDate getRecieptDate(ParkingSpace currentSpace){

        return currentSpace.getDate();
    }

    public ParkingSpace findByPlate(String licensePlate){

        for(int i =0; i < carBag.length; i++){


            if(!carBag[i].isFree() && carBag[i].getVehicle().getLicensePlate().equals(licensePlate)){

                return carBag[i];

            }


        }

        for(int i =0; i < truckSpaceBag.length; i++){


            if(!truckSpaceBag[i].isFree() && truckSpaceBag[i].getVehicle().getLicensePlate().equals(licensePlate)){

                return truckSpaceBag[i];

            }


        }

        for(int i =0; i < motorcycleSpaceBag.length; i++){


            if(!motorcycleSpaceBag[i].isFree() && motorcycleSpaceBag[i].getVehicle().getLicensePlate().equals(licensePlate)){

                return motorcycleSpaceBag[i];

            }


        }




        return null;

    }



    public ParkingSpace[] getCarBag() {
        return carBag;
    }

    public ParkingSpace[] getTruckSpaceBag() {
        return truckSpaceBag;
    }

    public ParkingSpace[] getMotorcycleSpaceBag() {
        return motorcycleSpaceBag;
    }

    public double getCarEarlyBird() {
        return carEarlyBird;
    }

    public void setCarEarlyBird(double carEarlyBird) {
        this.carEarlyBird = carEarlyBird;
    }

    public double getCarPerHour() {
        return carPerHour;
    }

    public void setCarPerHour(double carPerHour) {
        this.carPerHour = carPerHour;
    }

    public double getTruckEarlyBird() {
        return truckEarlyBird;
    }

    public void setTruckEarlyBird(double truckEarlyBird) {
        this.truckEarlyBird = truckEarlyBird;
    }

    public double getTruckPerHour() {
        return truckPerHour;
    }

    public void setTruckPerHour(double truckPerHour) {
        this.truckPerHour = truckPerHour;
    }

    public double getMotoEarlyBird() {
        return motoEarlyBird;
    }

    public void setMotoEarlyBird(double motoEarlyBird) {
        this.motoEarlyBird = motoEarlyBird;
    }

    public double getMotoPerHour() {
        return motoPerHour;
    }

    public void setMotoPerHour(double motoPerHour) {
        this.motoPerHour = motoPerHour;
    }

    public UserAccountBag getBag() {
        return bag;
    }

    public boolean isGarageCreated() {
        return garageCreated;
    }

    public void setGarageCreated(boolean garageCreated) {
        this.garageCreated = garageCreated;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "exit=" + exit +
                ", carBag=" + Arrays.toString(carBag) +
                ", truckSpaceBag=" + Arrays.toString(truckSpaceBag) +
                ", motorcycleSpaceBag=" + Arrays.toString(motorcycleSpaceBag) +
                '}';
    }
}
