package com.project.cse248garage.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RecordBagTest {

    RecordBag bag = new RecordBag();
    Vehicle car = new Car("mike-211", "jack", "johnson", 01);
    Record record = new Record(car, "mike-211");
    Garage garage = new Garage(2,2,2);



    @Test
    public void getRecord() {

        bag.addRecord(record);
        assertEquals(record, bag.getRecord("mike-211"));




    }

    @Test
    public void getLicensePlates() {

        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("mike-211 (Present)");

        garage.park(car, "car", true);

       assertEquals(list1, garage.getRecordBag().getLicensePlates(garage));

        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("mike-211");
        garage.getBag().getUser("admin", garage.getBag().getUserAccountHash()).setLoggedIn(true);
       garage.removeCar("mike-211");

        assertEquals(list2, garage.getRecordBag().getLicensePlates(garage));


    }
}