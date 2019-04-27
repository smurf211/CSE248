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
    double rate;


    public Reciept(String licensePlate, String category, String attendantFirstName, String attendantLastName, String date, String time, double paymentScheme, boolean earlyBird, String spaceID, String attendantID, Garage garage) {
        super(licensePlate, category, attendantFirstName, attendantLastName, date, time, paymentScheme, earlyBird, spaceID, attendantID);
        this.timeIn = time;
        this.dateIn = date;
        this.rate = paymentScheme;


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
        System.out.println("timeInMinutes: " + timeInMinutes + " timeInSeconds:" + timeInSeconds + " timeOutMinutes: " + timeOutMinutes + " timeOutSeconds: " + timeOutSeconds
        + "\n" + " dMinutes: " + differenceMinutes + " dseconds: " + differenceSeconds);
        System.out.println(totalSeconds + "Rounded: " + Math.round(totalSeconds));
        double totalMinutes = (totalSeconds /60);




    return Math.round(totalMinutes);
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

    public String getEarlyBirdString(){
        if(earlyBird){
            return "Yes";
        }
        else{
            return "No";
        }
    }

    public String getRate(){

        if(earlyBird) {
            return "$" + String.valueOf(rate) + "Flat fee.";

        }
        else{
            return "$" + String.valueOf(rate) + "Per Hour." ;
        }


    }

    public String getCurrency(){
        if(earlyBird) {
            return "$" + String.valueOf(paymentScheme) ;

        }
        else{
            return "$" + String.valueOf(paymentScheme) ;
        }
    }

    @Override
    public String toString() {
        return "Reciept" + "\n"+
                "Time in: " + timeIn + '\n' +
                "Time out: " + timeOut + '\n' +
                "Date in: " + dateIn + '\n' +
                "Date out: " + dateOut + '\n' +
                "Rate: " + getRate() + '\n' +
                "Payment Due: " + getCurrency() + '\n' +
                "Amount Paid: " + "$" + paymentScheme + "\n"+
                "Early Bird: " + getEarlyBirdString() + "\n" +
                "License Plate: " + licensePlate + '\n' +
                "Category: " + category + '\n' +
                "Attendant Parked Name/ID: " + attendantFirstName + " " +
                attendantLastName + " " + attendantID + "\n" +
                "Attendant Removed Name/ID: " + attendantRemovedFirst + " "
                + attendantRemovedLast + " "+ attendantRemovedId + "\n" +

                "Space ID: " + this.spaceID;
    }
}
