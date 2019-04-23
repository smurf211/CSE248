package com.project.cse248garage.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reciept extends Ticket implements Serializable {
    String timeIn;
    String dateIn;
    String timeOut;
    String dateOut;
    double paymentScheme;
    String attendantRemovedFirst;
    String attendantRemovedLast;
    String attendantRemovedId;
    Garage garage;


    public Reciept(String licensePlate, String category, String attendantFirstName, String attendantLastName, String date, String time, double paymentScheme, boolean earlyBird, String spaceID, String attendantID, Garage garage) {
        super(licensePlate, category, attendantFirstName, attendantLastName, date, time, paymentScheme, earlyBird, spaceID, attendantID);
        this.timeIn = time;
        this.dateIn = date;
        this.paymentScheme = paymentScheme;

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date1 = new Date();



        this.timeOut = String.valueOf(java.time.LocalTime.now());
        this.dateOut = String.valueOf(java.time.LocalDate.now());
        this.paymentScheme = calculatePayment();
        this.garage = garage;
        User user = garage.getBag().getLoggedInUser(garage.getBag().getUserAccountHash());
        this.attendantRemovedFirst = user.emitFirstName();
        this.attendantRemovedLast = user.emitLastName();
        this.attendantRemovedId = user.emitID();

    }



    public double calculatePayment(){

        double totalSeconds = getTimeSeconds();

        if(this.earlyBird){
            return paymentScheme;
        }

        else {
            return totalSeconds * paymentScheme;

        }
    }



    public double getTimeSeconds(){
        double timeInMinutes;
        double timeInSeconds;
        double timeOutMinutes;
        double timeOutSeconds;
        String[] timeInTokens = timeIn.split(":");
        timeInMinutes = Integer.valueOf(timeInTokens[1]);
        timeInSeconds = Double.valueOf(timeInTokens[2]);
        String[] timeOutTokens = timeOut.split(":");
        timeOutMinutes = Integer.valueOf(timeOutTokens[1]);
        timeOutSeconds = Double.valueOf(timeOutTokens[2]);

        double differenceMinutes = timeOutMinutes - timeInMinutes;
        double differenceSeconds = timeOutSeconds - timeInSeconds;

        double totalSeconds = (differenceMinutes * 60) + differenceSeconds;
        System.out.println("timeInMinutes: " + timeInMinutes + " timeInSeconds:" + timeInSeconds + " timeOutMinutes: " + timeOutMinutes + " timeOutSeconds: " + timeOutSeconds
        + "\n" + " dMinutes: " + differenceMinutes + " dseconds: " + differenceSeconds);
        System.out.println(totalSeconds + "Rounded: " + Math.round(totalSeconds));





    return Math.round(totalSeconds);
    }

    public static void sleep(long millis) throws InterruptedException{
        Thread.sleep(millis);
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

    public String getAttendantRemovedId() {
        return attendantRemovedId;
    }

    public void setAttendantRemovedId(String attendantRemovedId) {
        this.attendantRemovedId = attendantRemovedId;
    }

    @Override
    public String toString() {
        return "Reciept" + "\n"+
                "Time in: " + timeIn + '\n' +
                "Date in: " + dateIn + '\n' +
                "Time out: " + timeOut + '\n' +
                "Date out: " + dateOut + '\n' +
                "Payment Scheme: " + paymentScheme + '\n' +
                "Early Bird: " + earlyBird + "\n" +
                "License Plate: " + licensePlate + '\n' +
                "Category: " + category + '\n' +
                "Attendant Parked Name: " + attendantFirstName + " " +
                attendantLastName + "\n" +
                "Attendant Parked ID: " + attendantID + "\n" +
                "Attendant Removed Name: " + attendantRemovedFirst + " "
                + attendantRemovedLast + "\n"+
                "Attendant Removed ID: " + attendantRemovedId + "\n" +

                "Space ID: " + this.spaceID;
    }
}
