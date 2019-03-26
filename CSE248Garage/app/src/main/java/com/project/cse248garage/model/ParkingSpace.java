package com.project.cse248garage.model;

public class ParkingSpace {

    String category;
    public static int carDistance = 1;
    public static int truckDistance = 1;
    public static int motorcycleDistance = 1;
    public int distance;
    boolean earlyBird;
    double price;


    public ParkingSpace(String category){

        this.category = category;
        this.distance = carDistance;


    }



    public ParkingSpace(String category, boolean earlyBird) {
        this.category = category;
        this.distance = getDistance(category);
        this.earlyBird = earlyBird;
        this.price = getPrice(category, earlyBird);

    }

    public double getPrice(String category, boolean earlyBird){

        if(earlyBird){

            if(category.equals("car")){

                return Car.earlyBird;

            }

            if(category.equals("truck")){

                return Truck.earlyBird;

            }

            if(category.equals("motorcycle")){

                return Motorcycle.earlyBird;

            }
        }

        if(!earlyBird){

            if(category.equals("car")){

                return Car.perHour;

            }

            if(category.equals("truck")){

                return Truck.perHour;

            }

            if(category.equals("motorcycle")){

                return Motorcycle.perHour;

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



}
