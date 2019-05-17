package com.project.cse248garage.model;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reciept extends Ticket implements Serializable {
    String timeIn;
    String dateIn;
    String timeOut;
    String dateOut;
    double paymentScheme;
    Garage garage;
    double rate;

    public Reciept(String timeIn, String timeOut) {
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

    public Reciept(Vehicle vehicle, String dateIn, String dateOut, String timeIn , String timeOut, boolean earlyBird, String spaceID,  double rate, double paymentScheme, Garage garage) {
        super(vehicle, dateIn, timeIn, rate, earlyBird, spaceID);
        this.timeIn = timeIn;
        this.dateIn = dateIn;
        this.rate = rate;

        this.timeOut = timeOut;
        this.dateOut = dateOut;
        this.paymentScheme = paymentScheme;
        this.garage = garage;



    }




    public Reciept(Vehicle vehicle, String date, String time, double rate, boolean earlyBird, String spaceID, Garage garage) {
        super(vehicle, date, time, rate, earlyBird, spaceID);
        this.timeIn = time;
        this.dateIn = date;
        this.rate = rate;


        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String[] tokens = timeStamp.split(" ");
        String dateOut = tokens[0];
        String timeOut = tokens[1];


        this.timeOut = timeOut;
        this.dateOut = dateOut;
        this.paymentScheme = calculatePayment();
        this.garage = garage;
        User user = garage.getBag().getLoggedInUser(garage.getBag().getUserAccountHash());
        vehicle.setAttendantRemovedFirst(user.emitFirstName());
        vehicle.setAttendantRemovedLast(user.emitLastName());
        vehicle.setAttendantRemovedId(user.emitID());

    }


    public double calculatePayment() {

        double totalSeconds = getTimeSeconds();

        if (this.earlyBird) {
            return rate;
        } else {
            return totalSeconds * rate;

        }
    }


    public double getTimeSeconds() {
        double timeInMinutes;
        double timeInSeconds;
        double timeOutMinutes;
        double timeOutSeconds;
        double timeInHours;
        double timeOutHours;
        String[] timeInTokens = timeIn.split(":");
        timeInHours = Integer.valueOf(timeInTokens[0]);
        timeInMinutes = Integer.valueOf(timeInTokens[1]);
        timeInSeconds = Double.valueOf(timeInTokens[2]);
        String[] timeOutTokens = timeOut.split(":");
        timeOutHours = Integer.valueOf(timeOutTokens[0]);
        timeOutMinutes = Integer.valueOf(timeOutTokens[1]);
        timeOutSeconds = Double.valueOf(timeOutTokens[2]);

        double differenceHours = timeOutHours - timeInHours;
        double differenceMinutes = timeOutMinutes - timeInMinutes;
        double differenceSeconds = timeOutSeconds - timeInSeconds;

        double totalSeconds = (differenceHours * 60 * 60) + (differenceMinutes * 60) + differenceSeconds;

        double totalMinutes = (totalSeconds / 60);


        return Math.round(totalMinutes);
    }

    public static void sleep(long millis) throws InterruptedException {
        Thread.sleep(millis);
    }


    public String getEarlyBirdString() {
        if (earlyBird) {
            return "Yes";
        } else {
            return "No";
        }
    }


    public String getCurrency() {
        if (earlyBird) {
            return "$" + Ticket.addZeroToRate(paymentScheme);

        } else {
            return "$" + Ticket.addZeroToRate(paymentScheme);
        }
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getPaymentScheme() {
        return paymentScheme;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public static String convertTimeFromMilitary(String time) {

        String minutes;
        String seconds;
        int hours;
        String amPm;
        String[] breakMillis = time.split("[.]");

        String[] timeTokens = breakMillis[0].split(":");
        hours = Integer.valueOf(timeTokens[0]);
        minutes = timeTokens[1];
        seconds = timeTokens[2];

        if (hours < 12) {

            amPm = "AM";
        } else if (hours == 12) {
            amPm = "PM";

        } else {
            amPm = "PM";
            hours = (hours - 12);
        }

        String actualTime = String.valueOf(hours) + ":" + minutes + ":" + seconds + " " + amPm;

        return actualTime;


    }

    @Override
    public String toString() {

        /*

        String boldText = "id";
        String normalText = "name";
        SpannableString str = new SpannableString(boldText + normalText);
        str.setSpan(new StyleSpan(Typeface.BOLD), 0, boldText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


*/

        return  "Reciept" + "\n" +
                "Time In: \t\t" + convertTimeFromMilitary(timeIn)  +
                " \t\tOut: " + convertTimeFromMilitary(timeOut) + '\n' +
                "Date In: \t\t\t" + dateIn  +
                " \t\tOut: " + dateOut + '\n' +
                "Rate: " + Ticket.addZeroToRate(rate) + '\n' +
                "Amount " + "Due: " + getCurrency()  +
                " Paid: " + getCurrency() + "\n" +
                "Early Bird: " + getEarlyBirdString() + "\n" +
                "License Plate: " + getVehicle().getLicensePlate() + '\n' +
                "Category: " + getVehicle().getCategory() + '\n' +
                "Attendant Parked Name/ID: " + getVehicle().getAttendantFirstName() + " " +
                getVehicle().getAttendantLastName() + " " + getVehicle().getAttendantId() + "\n" +
                "Attendant Removed Name/ID: " + vehicle.getAttendantRemovedFirst() + " "
                + vehicle.getAttendantRemovedLast() + " " + vehicle.getAttendantRemovedId() + "\n" +

                "Space ID: " + this.spaceID;
    }
}
