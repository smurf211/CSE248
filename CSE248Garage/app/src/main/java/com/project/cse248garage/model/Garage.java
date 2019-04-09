package com.project.cse248garage.model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;

public class Garage {

    public int exit = 0;
    public ParkingSpace[] carBag;
    public ParkingSpace[] truckSpaceBag;
    public ParkingSpace[] motorcycleSpaceBag;


    public Garage(int carSize, int motorcycleSize, int truckSize){


        carBag = new ParkingSpace[carSize];
        loadCarSpaces(carSize);


        truckSpaceBag = new ParkingSpace[truckSize];
        loadTruckSpaces(truckSize);

        motorcycleSpaceBag = new ParkingSpace[motorcycleSize];
        loadMotorcycleSpaces(motorcycleSize);

    }


    public void loadCarSpaces(int carSize){


        for(int i =0; i < carSize; i++){

            carBag[i] = new ParkingSpace("car", true, ParkingSpace.carDistance++);


        }




    }

    public void loadTruckSpaces(int truckSize){


        for(int i =0; i < truckSize; i++){

            truckSpaceBag[i] = new ParkingSpace("truck",true, ParkingSpace.truckDistance++);


        }




    }

    public void loadMotorcycleSpaces(int motorcycleSize){


        for(int i =0; i < motorcycleSize; i++){

            motorcycleSpaceBag[i] = new ParkingSpace("motorcycle", true, ParkingSpace.motorcycleDistance++);


        }




    }



    public void park(Vehicle vehicle, String category, Boolean earlyBird){

        ParkingSpace openSpace = findClosestSpace(category);

        openSpace = new ParkingSpace(category, false, earlyBird, vehicle);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();



        openSpace.setTime(java.time.LocalTime.now());
        openSpace.setDate(java.time.LocalDate.now());

        String time = String.valueOf(getRecieptTime(openSpace));

         String date1 =  String.valueOf(getRecieptDate(openSpace));

        Ticket ticket = new Ticket(openSpace.getVehicle().getLicensePlate(), openSpace.getCategory(),
                openSpace.getVehicle().getAttendantFirstName(),
                openSpace.getVehicle().getAttendantLastName(), date1, time, openSpace.getPrice());
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

    String date = String.valueOf(getRecieptDate(currentSpace));
     String time =   String.valueOf(getRecieptTime(currentSpace));
        Reciept reciept = new Reciept(currentSpace.getVehicle().getLicensePlate(), currentSpace.getCategory(),
                currentSpace.getVehicle().getAttendantFirstName(),
                currentSpace.getVehicle().getAttendantLastName(), date, time, currentSpace.getPrice());

        currentSpace.removeVehicle();

    return reciept;
    }


    //make method to calculate payment.


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


            if(!motorcycleSpaceBag[i].isFree() && carBag[i].getVehicle().getLicensePlate().equals(licensePlate)){

                return motorcycleSpaceBag[i];

            }


        }




        return null;

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
