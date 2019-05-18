package com.project.cse248garage.model;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.StyleSpan;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket implements Serializable {


    Vehicle vehicle;
    String date;
    String time;
    double rate;
    boolean earlyBird;
    public String spaceID;


    public Ticket() {


    }


    public Ticket(Vehicle vehicle, String date, String time, double rate, boolean earlyBird, String spaceID) {

        this.date = date;
        this.time = time;
        this.rate = rate;
        this.earlyBird = earlyBird;
        this.spaceID = spaceID;
        this.vehicle = vehicle;


    }


    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public double getRate() {
        return rate;
    }

    public boolean isEarlyBird() {
        return earlyBird;
    }

    public String getEarlyBirdString() {
        if (earlyBird) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public String getCurrency(double rate) {
        if (earlyBird) {
            return "$" + addZeroToRate(rate) + " Flat rate.";

        } else {
            return "$" + addZeroToRate(rate) + " Per Hour.";
        }
    }

    public static String addZeroToRate(double rate) {

        if (!String.valueOf(rate).contains(".")) {

            return String.valueOf(rate);
        }

        String[] rateTokens = String.valueOf(rate).split("[.]");

        if (rateTokens[1].length() == 1) {

            return String.valueOf(rate) + "0";
        } else {
            return String.valueOf(rate);
        }

    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setEarlyBird(boolean earlyBird) {
        this.earlyBird = earlyBird;
    }

    @Override
    public String toString() {
        return "Ticket" + "\n" +
                "License Plate: " + getVehicle().getLicensePlate() + "\n" +
                "Category : " + getVehicle().getCategory() + "\n" +
                "Attendant Name/ID: " + getVehicle().getAttendantFirstName() + " " +
                getVehicle().getAttendantLastName() + " " +
                getVehicle().getAttendantId() + "\n" +
                "Date/Time: " + date + " " +
                Reciept.convertTimeFromMilitary(time) + '\n' +
                "Rate: " + getCurrency(rate) + "\n" +
                "Early Bird: " + getEarlyBirdString() + "\n" +
                "Space ID: " + this.spaceID;
    }

    public SpannedString toStringSpan() {

        String ticket = "\nTicket\n";

        SpannableString str1 = new SpannableString(ticket);
        str1.setSpan(new StyleSpan(Typeface.BOLD), 0, ticket.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String licensePlateStr = "License Plate: ";
        String normalText1 = getVehicle().getLicensePlate() + "\n";
        SpannableString str2 = new SpannableString(licensePlateStr + normalText1);
        str2.setSpan(new StyleSpan(Typeface.BOLD), 0, licensePlateStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String categoryStr = "Category : ";
        String normalText2 = getVehicle().getCategory() + "\n";
        SpannableString str3 = new SpannableString(categoryStr + normalText2);
        str3.setSpan(new StyleSpan(Typeface.BOLD), 0, categoryStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String attendantStr = "Attendant Name/ID: ";
        String normalText3 = getVehicle().getAttendantFirstName() + " " +
                getVehicle().getAttendantLastName() + " " +
                getVehicle().getAttendantId() + "\n";
        SpannableString str4 = new SpannableString(attendantStr + normalText3);
        str4.setSpan(new StyleSpan(Typeface.BOLD), 0, attendantStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String dateTimeStr = "Date/Time: ";
        String normalText4 = date + " " +
                Reciept.convertTimeFromMilitary(time) + '\n';
        SpannableString str5 = new SpannableString(dateTimeStr + normalText4);
        str5.setSpan(new StyleSpan(Typeface.BOLD), 0, dateTimeStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String rateStr = "Rate: ";
        String normalText5 = getCurrency(rate) + "\n";
        SpannableString str6 = new SpannableString(rateStr + normalText5);
        str6.setSpan(new StyleSpan(Typeface.BOLD), 0, rateStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String earlyBirdStr = "Early Bird: ";
        String normalText6 = getEarlyBirdString() + "\n";
        SpannableString str7 = new SpannableString(earlyBirdStr + normalText6);
        str7.setSpan(new StyleSpan(Typeface.BOLD), 0, earlyBirdStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String spaceIDstr = "Space ID: ";
        String normalText7 = this.spaceID;
        SpannableString str8 = new SpannableString(spaceIDstr + normalText7);
        str8.setSpan(new StyleSpan(Typeface.BOLD), 0, spaceIDstr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);




        SpannedString result = (SpannedString) TextUtils.concat(str1, str2, str3, str4, str5, str6, str7, str8);

        return result;
    }
}
