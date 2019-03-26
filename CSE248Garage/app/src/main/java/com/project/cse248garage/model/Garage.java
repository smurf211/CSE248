package com.project.cse248garage.model;

public class Garage {

    public int exit = 0;
    public ParkingSpace[] carBag;
    public ParkingSpace[] truckBag;
    public ParkingSpace[] motorcycleBag;


    public Garage(int carSize, int motorcycleSize, int truckSize){


        carBag = new ParkingSpace[carSize];
        fillCarBag(carSize);


        truckBag = new ParkingSpace[truckSize];
        fillTruckBag(truckSize);

        motorcycleBag = new ParkingSpace[motorcycleSize];
        fillMotorcycleBag(motorcycleSize);

    }


    public void fillCarBag(int carSize){


        for(int i =0; i < carSize; i++){

            carBag[i++] = new ParkingSpace("car");
            ParkingSpace.carDistance++;

        }




    }

    public void fillTruckBag(int truckSize){


        for(int i =0; i < truckSize; i++){

            truckBag[i++] = new ParkingSpace("truck");
            ParkingSpace.truckDistance++;

        }




    }

    public void fillMotorcycleBag(int motorcycleSize){


        for(int i =0; i < motorcycleSize; i++){

            motorcycleBag[i++] = new ParkingSpace("motorcycle");
            ParkingSpace.motorcycleDistance++;

        }




    }



    public void park(){






    }



}
