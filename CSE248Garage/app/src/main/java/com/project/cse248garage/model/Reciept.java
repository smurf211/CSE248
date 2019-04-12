package com.project.cse248garage.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reciept extends Ticket {
    String timeIn;
    String dateIn;
    String timeOut;
    String dateOut;
    double paymentScheme;


    public Reciept(String licensePlate, String category, String attendantFirstName, String attendantLastName, String date, String time, double paymentScheme) {
        super(licensePlate, category, attendantFirstName, attendantLastName, date, time, paymentScheme);
        this.timeIn = time;
        this.dateIn = date;
        this.paymentScheme = paymentScheme;

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date1 = new Date();



        this.timeOut = String.valueOf(java.time.LocalTime.now());
        this.dateOut = String.valueOf(java.time.LocalDate.now());

    }


    public double calculatePayment(){

        double totalSeconds = getTimeSeconds();
        return totalSeconds * paymentScheme;


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

}
