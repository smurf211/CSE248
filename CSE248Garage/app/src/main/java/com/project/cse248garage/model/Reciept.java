package com.project.cse248garage.model;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.StyleSpan;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The type Reciept.
 */
public class Reciept extends Ticket implements Serializable {

    String timeIn;
    String dateIn;
    String timeOut;
    String dateOut;
    double paymentScheme; //calculated payment
    Garage garage;
    double rate; //rate per hour or early bird fee

    /**
     * Instantiates a new Reciept.
     *
     * @param timeIn  the time in
     * @param timeOut the time out
     */
    public Reciept(String timeIn, String timeOut) {
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

    /**
     * Instantiates a new Reciept.
     *
     * @param vehicle       the vehicle
     * @param dateIn        the date in
     * @param dateOut       the date out
     * @param timeIn        the time in
     * @param timeOut       the time out
     * @param earlyBird     the early bird
     * @param spaceID       the space id
     * @param rate          the rate
     * @param paymentScheme the payment scheme
     * @param garage        the garage
     */
    public Reciept(Vehicle vehicle, String dateIn, String dateOut, String timeIn, String timeOut, boolean earlyBird, String spaceID, double rate, double paymentScheme, Garage garage) {
        super(vehicle, dateIn, timeIn, rate, earlyBird, spaceID);
        this.timeIn = timeIn;
        this.dateIn = dateIn;
        this.rate = rate;

        this.timeOut = timeOut;
        this.dateOut = dateOut;
        this.paymentScheme = paymentScheme;
        this.garage = garage;


    }


    /**
     * Instantiates a new Reciept.
     *
     * @param vehicle   the vehicle
     * @param date      the date
     * @param time      the time
     * @param rate      the rate
     * @param earlyBird the early bird
     * @param spaceID   the space id
     * @param garage    the garage
     */
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


    /**
     * Calculate payment double.
     *
     * @return the double
     */
    public double calculatePayment() {

        double totalSeconds = getTimeSeconds();

        if (this.earlyBird) {
            return rate;
        } else {
            return totalSeconds * rate;

        }
    }


    /**
     * Gets time seconds.
     *
     * @return the time seconds
     */
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

    /**
     * Sleep.
     *
     * @param millis the millis
     * @throws InterruptedException the interrupted exception
     */
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


    /**
     * Gets currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        if (earlyBird) {
            return "$" + Ticket.addZeroToRate(paymentScheme);

        } else {
            return "$" + Ticket.addZeroToRate(paymentScheme);
        }
    }

    /**
     * Sets rate.
     *
     * @param rate the rate
     */
    public void setRate(double rate) {
        this.rate = rate;
    }

    /**
     * Gets payment scheme.
     *
     * @return the payment scheme
     */
    public double getPaymentScheme() {
        return paymentScheme;
    }

    /**
     * Gets time out.
     *
     * @return the time out
     */
    public String getTimeOut() {
        return timeOut;
    }

    /**
     * Sets time out.
     *
     * @param timeOut the time out
     */
    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    /**
     * Gets date out.
     *
     * @return the date out
     */
    public String getDateOut() {
        return dateOut;
    }

    /**
     * Sets date out.
     *
     * @param dateOut the date out
     */
    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    /**
     * Convert time from military string.
     *
     * @param time the time
     * @return the string
     */
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


        return "Reciept" + "\n" +
                "Time In: \t\t" + convertTimeFromMilitary(timeIn) +
                " \t\tOut: " + convertTimeFromMilitary(timeOut) + '\n' +
                "Date In: \t\t\t" + dateIn +
                " \t\tOut: " + dateOut + '\n' +
                "Rate: " + Ticket.addZeroToRate(rate) + '\n' +
                "Amount " + "Due: " + getCurrency() +
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


    public SpannedString toStringSpan() {
        //displayField.setText(reciept.toStringSpan());
        String reciept = "\nReceipt\n";

        SpannableString str1 = new SpannableString(reciept);
        str1.setSpan(new StyleSpan(Typeface.BOLD), 0, reciept.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String timeInStr = "Time In: \t\t";
        String normalText1 = convertTimeFromMilitary(timeIn);
        SpannableString str2 = new SpannableString(timeInStr + normalText1);
        str2.setSpan(new StyleSpan(Typeface.BOLD), 0, timeInStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String timeOutStr = " \t\tOut: ";
        String normalText2 = convertTimeFromMilitary(timeOut) + "\n";
        SpannableString str3 = new SpannableString(timeOutStr + normalText2);
        str3.setSpan(new StyleSpan(Typeface.BOLD), 0, timeOutStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String dateInStr = "Date In:\t\t\t";
        String normalText3 = dateIn;
        SpannableString str4 = new SpannableString(dateInStr + normalText3);
        str4.setSpan(new StyleSpan(Typeface.BOLD), 0, dateInStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String dateOutStr = " \t\tOut: ";
        String normalText4 = dateOut + "\n";
        SpannableString str5 = new SpannableString(dateOutStr + normalText4);
        str5.setSpan(new StyleSpan(Typeface.BOLD), 0, dateOutStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String rateStr = "Rate: ";
        String normalText5 = Ticket.addZeroToRate(rate) + "\n";
        SpannableString str6 = new SpannableString(rateStr + normalText5);
        str6.setSpan(new StyleSpan(Typeface.BOLD), 0, rateStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String amountDue = "Amount " + "Due: ";
        String normalText6 = getCurrency() + "\t\t\t";
        SpannableString str7 = new SpannableString(amountDue + normalText6);
        str7.setSpan(new StyleSpan(Typeface.BOLD), 0, amountDue.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String paid = " Paid: ";
        String normalText7 = getCurrency() + "\n";
        SpannableString str8 = new SpannableString(paid + normalText7);
        str8.setSpan(new StyleSpan(Typeface.BOLD), 0, paid.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String earlyBird = "Early Bird: ";
        String normalText8 = getEarlyBirdString() + "\n";
        SpannableString str9 = new SpannableString(earlyBird + normalText8);
        str9.setSpan(new StyleSpan(Typeface.BOLD), 0, earlyBird.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String licensePlate = "License Plate: ";
        String normalText9 = getVehicle().getLicensePlate() + '\n';
        SpannableString str10 = new SpannableString(licensePlate + normalText9);
        str10.setSpan(new StyleSpan(Typeface.BOLD), 0, licensePlate.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String category = "Category: ";
        String normalText10 = getVehicle().getCategory() + '\n';
        SpannableString str11 = new SpannableString(category + normalText10);
        str11.setSpan(new StyleSpan(Typeface.BOLD), 0, category.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String aParked = "Attendant Parked: ";
        String normalText11 = getVehicle().getAttendantFirstName() + " " +
                getVehicle().getAttendantLastName() + " " + getVehicle().getAttendantId() + "\n";
        SpannableString str12 = new SpannableString(aParked + normalText11);
        str12.setSpan(new StyleSpan(Typeface.BOLD), 0, aParked.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String aRemoved = "Attendant Removed: ";
        String normalText12 = vehicle.getAttendantRemovedFirst() + " "
                + vehicle.getAttendantRemovedLast() + " " + vehicle.getAttendantRemovedId() + "\n";
        SpannableString str13 = new SpannableString(aRemoved + normalText12);
        str13.setSpan(new StyleSpan(Typeface.BOLD), 0, aRemoved.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String spaceID = "Space ID: ";
        String normalText13 = this.spaceID + "\n";
        SpannableString str14 = new SpannableString(spaceID + normalText13);
        str14.setSpan(new StyleSpan(Typeface.BOLD), 0, spaceID.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


        SpannedString result = (SpannedString) TextUtils.concat(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14);


        return result;
    }
}
