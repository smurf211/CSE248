package com.project.cse248garage.model;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Record.
 */
public class Record implements Serializable {


    /**
     * The License plate.
     */
    String licensePlate;
    /**
     * The Vehicle.
     */
    Vehicle vehicle;

    /**
     * The Reciepts.
     */
    ArrayList<Reciept> reciepts;


    /**
     * Instantiates a new Record.
     *
     * @param vehicle      the vehicle
     * @param licensePlate the license plate
     */
    public Record(Vehicle vehicle, String licensePlate) {

        reciepts = new ArrayList<Reciept>();

        this.vehicle = vehicle;
        this.licensePlate = licensePlate;

    }


    /**
     * Add reciept.
     *
     * @param reciept the reciept
     */
    public void addReciept(Reciept reciept) {

        reciepts.add(reciept);

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
     * Sets vehicle.
     *
     * @param vehicle the vehicle
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


    /**
     * Gets reciepts.
     *
     * @return the reciepts
     */
    public ArrayList<Reciept> getReciepts() {
        return reciepts;
    }

    /**
     * Sets reciepts.
     *
     * @param reciepts the reciepts
     */
    public void setReciepts(ArrayList<Reciept> reciepts) {
        this.reciepts = reciepts;
    }

    /**
     * Gets license plate.
     *
     * @return the license plate
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * Sets license plate.
     *
     * @param licensePlate the license plate
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String toString() {

        return "Record: " + "\n" +
                vehicle + "\n" +
                "Receipts: " + "\n";


    }

    /**
     * To string span spanned string.
     *
     * @return the spanned string
     */
    public SpannedString toStringSpan() {


        SpannedString result = (SpannedString) TextUtils.concat(vehicle.toStringSpan());


        return result;


    }

    /**
     * To string present string.
     *
     * @return the string
     */
    public String toStringPresent() {


        return "Record: " + "\n" +
                vehicle + "\n" +

                "Ticket: " + vehicle.getTicket() + "\n";
    }

    /**
     * To string span present spanned string.
     *
     * @return the spanned string
     */
    public SpannedString toStringSpanPresent() {


        SpannedString result = (SpannedString) TextUtils.concat(vehicle.toStringSpan(), vehicle.getTicket().toStringSpan());


        return result;


    }


}
