package com.project.cse248garage.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecieptTest {

    Reciept reciept = new Reciept("12:00:00", "12:01:30");


    @Test
    public void calculatePayment() {
        reciept.setRate(2.5);

        assertEquals(2.0, reciept.getTimeSeconds(), 0.01);
        assertEquals(5.0, reciept.calculatePayment(), 0.01);


    }

    @Test
    public void getTimeSeconds() {
        reciept.setRate(2.5);

        assertEquals(2.0, reciept.getTimeSeconds(), 0.01);
    }

    @Test
    public void convertTimeFromMilitary() {

       assertEquals("12:47:03 PM", Reciept.convertTimeFromMilitary("12:47:03.234"));
    }

    @Test
    public void addZeroToRate(){
        assertEquals("2.54", Ticket.addZeroToRate(2.54));
        assertEquals("2.50", Ticket.addZeroToRate(2.5));



    }
}