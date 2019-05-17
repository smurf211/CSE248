package com.project.cse248garage.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class GarageTest {

    Garage garage = new Garage(2,2,2);

    @Test
    public void setSpaces() {
        garage.setSpaces(3,3,3);

        assertEquals(9, garage.getGarageSize());
    }

    @Test
    public void parkAndFind() {


        Vehicle car = new Car("mike-211", "jack", "johnson", 01);

        garage.park(car, "car", true);


        assertEquals(true, garage.findByPlateBoolean("mike-211"));
    }

    @Test
    public void findClosestSpace() {





        ParkingSpace space1 = garage.findClosestSpace("car");

        assertEquals(true, space1.isFree() );
        assertEquals("c1", space1.getSpaceID() );
        assertEquals(1, space1.distance );

        Vehicle car = new Car("mike-211", "jack", "johnson", 01);

        garage.park(car, "car", true);

        ParkingSpace space2 = garage.findClosestSpace("car");

        assertEquals(true, space2.isFree() );
        assertEquals("c2", space2.getSpaceID() );
        assertEquals(2, space2.distance );
    }

    @Test
    public void removeCar() {

        Vehicle car = new Car("mike-211", "jack", "johnson", 01);

        garage.getBag().getUser("admin", garage.getBag().getUserAccountHash()).setLoggedIn(true);

        garage.park(car, "car", true);



        garage.removeCar("mike-211");

        assertEquals(false, garage.findByPlateBoolean("mike-211"));
    }

    @Test
    public void findByPlate() {

        Vehicle car = new Car("mike-211", "jack", "johnson", 01);

        garage.park(car, "car", true);

        ParkingSpace p1 =  garage.findByPlate("mike-211");

        assertEquals(car, p1.getVehicle());



    }




}