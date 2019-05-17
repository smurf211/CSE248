package com.project.cse248garage.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingSpaceTest {

    Vehicle car = new Car("mike-211", "jack", "johnson", 01);

    ParkingSpace p1 = new ParkingSpace("car", true, 1);
    Garage garage = new Garage(2,2,2);


    @Test
    public void getPrice() {
        p1.setGarage(garage);
        garage.setCarEarlyBird(20);
        garage.setCarPerHour(2.50);

        assertEquals(2.50, p1.getPrice("car", false),0.01);
        assertEquals(20, p1.getPrice("car", true),0.01);


    }

    @Test
    public void getDistance() {

       assertEquals(3, p1.getDistance("car"));


    }
}