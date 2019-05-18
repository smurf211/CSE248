package com.project.cse248garage.model;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.StyleSpan;

import java.io.Serializable;

/**
 * The type Vehicle.
 */
public abstract class Vehicle implements Serializable {


    int vehicleId;
    String licensePlate;
    public String attendantFirstName;
    public String attendantLastName;
    int attendantId;
    public String falseCategory;
    public Ticket ticket;
    String attendantRemovedFirst;
    String attendantRemovedLast;
    int attendantRemovedId;
    String timeIn;
    String dateIn;
    String spaceID;
    boolean earlyBird;
    double rate;


    /**
     * Gets category.
     *
     * @return the category
     */
    public abstract String getCategory();

    /**
     * Instantiates a new Vehicle.
     *
     * @param vehicleId     the vehicle id
     * @param attendantId   the attendant id
     * @param licensePlate  the license plate
     * @param falseCategory the false category
     * @param spaceID       the space id
     * @param dateIn        the date in
     * @param timeIn        the time in
     * @param earlyBird     the early bird
     * @param rate          the rate
     */
    public Vehicle(int vehicleId, int attendantId, String licensePlate, String falseCategory, String spaceID, String dateIn, String timeIn, boolean earlyBird, double rate) {
        this.vehicleId = vehicleId;
        this.licensePlate = licensePlate;
        this.attendantId = attendantId;
        this.falseCategory = falseCategory;
        this.timeIn = timeIn;
        this.dateIn = dateIn;
        this.spaceID = spaceID;
        this.earlyBird = earlyBird;
        this.rate = rate;
    }

    /**
     * Instantiates a new Vehicle.
     *
     * @param licensePlate       the license plate
     * @param attendantFirstName the attendant first name
     * @param attendantLastName  the attendant last name
     * @param attendantId        the attendant id
     */
    public Vehicle(String licensePlate, String attendantFirstName, String attendantLastName, int attendantId) {
        this.licensePlate = licensePlate;
        this.attendantFirstName = attendantFirstName;
        this.attendantLastName = attendantLastName;
        this.attendantId = attendantId;
    }

    @Override
    public String toString() {
        return "Vehicle " + "\n" +
                "ID: " + vehicleId + "\n" +
                "License Plate: " + licensePlate
                + "\n" +
                "Category: " + getCategory()
                ;
    }

    /**
     * To string span spanned string.
     *
     * @return the spanned string
     */
    public SpannedString toStringSpan() {

        String vehicle = "Vehicle\n";

        SpannableString str1 = new SpannableString(vehicle);
        str1.setSpan(new StyleSpan(Typeface.BOLD), 0, vehicle.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String IDstr = "ID: ";
        String normalText1 = String.valueOf(vehicleId) + "\n";
        SpannableString str2 = new SpannableString(IDstr + normalText1);
        str2.setSpan(new StyleSpan(Typeface.BOLD), 0, IDstr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String licensePlateStr = "License Plate: ";
        String normalText2 = licensePlate + "\n";
        SpannableString str3 = new SpannableString(licensePlateStr + normalText2);
        str3.setSpan(new StyleSpan(Typeface.BOLD), 0, licensePlateStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String categoryStr = "Category: ";
        String normalText3 = getCategory() + "\n";
        SpannableString str4 = new SpannableString(categoryStr + normalText3);
        str4.setSpan(new StyleSpan(Typeface.BOLD), 0, categoryStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        SpannedString result = (SpannedString) TextUtils.concat(str1, str2, str3, str4);


        return result;
    }


    /**
     * Gets false category.
     *
     * @return the false category
     */
    public String getFalseCategory() {
        return falseCategory;
    }

    /**
     * Sets false category.
     *
     * @param falseCategory the false category
     */
    public void setFalseCategory(String falseCategory) {
        this.falseCategory = falseCategory;
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
     * Gets attendant first name.
     *
     * @return the attendant first name
     */
    public String getAttendantFirstName() {
        return attendantFirstName;
    }

    /**
     * Gets attendant last name.
     *
     * @return the attendant last name
     */
    public String getAttendantLastName() {
        return attendantLastName;
    }

    /**
     * Gets attendant id.
     *
     * @return the attendant id
     */
    public int getAttendantId() {
        return attendantId;
    }

    /**
     * Sets attendant id.
     *
     * @param attendantId the attendant id
     */
    public void setAttendantId(int attendantId) {
        this.attendantId = attendantId;
    }

    /**
     * Gets ticket.
     *
     * @return the ticket
     */
    public Ticket getTicket() {
        return ticket;
    }

    /**
     * Sets ticket.
     *
     * @param ticket the ticket
     */
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    /**
     * Gets attendant removed first.
     *
     * @return the attendant removed first
     */
    public String getAttendantRemovedFirst() {
        return attendantRemovedFirst;
    }

    /**
     * Sets attendant removed first.
     *
     * @param attendantRemovedFirst the attendant removed first
     */
    public void setAttendantRemovedFirst(String attendantRemovedFirst) {
        this.attendantRemovedFirst = attendantRemovedFirst;
    }

    /**
     * Gets attendant removed last.
     *
     * @return the attendant removed last
     */
    public String getAttendantRemovedLast() {
        return attendantRemovedLast;
    }

    /**
     * Sets attendant removed last.
     *
     * @param attendantRemovedLast the attendant removed last
     */
    public void setAttendantRemovedLast(String attendantRemovedLast) {
        this.attendantRemovedLast = attendantRemovedLast;
    }

    /**
     * Gets attendant removed id.
     *
     * @return the attendant removed id
     */
    public int getAttendantRemovedId() {
        return attendantRemovedId;
    }

    /**
     * Sets attendant removed id.
     *
     * @param attendantRemovedId the attendant removed id
     */
    public void setAttendantRemovedId(int attendantRemovedId) {
        this.attendantRemovedId = attendantRemovedId;
    }

    /**
     * Gets vehicle id.
     *
     * @return the vehicle id
     */
    public int getVehicleId() {
        return vehicleId;
    }

    /**
     * Sets vehicle id.
     *
     * @param vehicleId the vehicle id
     */
    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    /**
     * Gets time in.
     *
     * @return the time in
     */
    public String getTimeIn() {
        return timeIn;
    }

    /**
     * Sets time in.
     *
     * @param timeIn the time in
     */
    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    /**
     * Gets date in.
     *
     * @return the date in
     */
    public String getDateIn() {
        return dateIn;
    }

    /**
     * Sets date in.
     *
     * @param dateIn the date in
     */
    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    /**
     * Sets attendant first name.
     *
     * @param attendantFirstName the attendant first name
     */
    public void setAttendantFirstName(String attendantFirstName) {
        this.attendantFirstName = attendantFirstName;
    }

    /**
     * Sets attendant last name.
     *
     * @param attendantLastName the attendant last name
     */
    public void setAttendantLastName(String attendantLastName) {
        this.attendantLastName = attendantLastName;
    }

    /**
     * Gets space id.
     *
     * @return the space id
     */
    public String getSpaceID() {
        return spaceID;
    }

    /**
     * Is early bird boolean.
     *
     * @return the boolean
     */
    public boolean isEarlyBird() {
        return earlyBird;
    }

    /**
     * Gets rate.
     *
     * @return the rate
     */
    public double getRate() {
        return rate;
    }
}
