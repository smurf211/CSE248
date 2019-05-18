package com.project.cse248garage.model;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.StyleSpan;

import java.io.Serializable;

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


    public abstract String getCategory();

    public Vehicle(int vehicleId,int attendantId, String licensePlate, String falseCategory, String spaceID, String dateIn, String timeIn, boolean earlyBird, double rate) {
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




        return  result;
    }



    public String getFalseCategory() {
        return falseCategory;
    }

    public void setFalseCategory(String falseCategory) {
        this.falseCategory = falseCategory;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getAttendantFirstName() {
        return attendantFirstName;
    }

    public String getAttendantLastName() {
        return attendantLastName;
    }

    public int getAttendantId() {
        return attendantId;
    }

    public void setAttendantId(int attendantId) {
        this.attendantId = attendantId;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getAttendantRemovedFirst() {
        return attendantRemovedFirst;
    }

    public void setAttendantRemovedFirst(String attendantRemovedFirst) {
        this.attendantRemovedFirst = attendantRemovedFirst;
    }

    public String getAttendantRemovedLast() {
        return attendantRemovedLast;
    }

    public void setAttendantRemovedLast(String attendantRemovedLast) {
        this.attendantRemovedLast = attendantRemovedLast;
    }

    public int getAttendantRemovedId() {
        return attendantRemovedId;
    }

    public void setAttendantRemovedId(int attendantRemovedId) {
        this.attendantRemovedId = attendantRemovedId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public void setAttendantFirstName(String attendantFirstName) {
        this.attendantFirstName = attendantFirstName;
    }

    public void setAttendantLastName(String attendantLastName) {
        this.attendantLastName = attendantLastName;
    }

    public String getSpaceID() {
        return spaceID;
    }

    public boolean isEarlyBird() {
        return earlyBird;
    }

    public double getRate() {
        return rate;
    }
}
