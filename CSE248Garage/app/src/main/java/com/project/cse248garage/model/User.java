package com.project.cse248garage.model;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.StyleSpan;

import java.io.Serializable;
import java.util.Random;

public class User implements Serializable {

    private String firstName;
    private String lastName;
    private int iD;
    private boolean admin;
    private boolean loggedIn;

    private String userName;
    private String password;


    public User() {

    }


    public User(int iD, String firstName, String lastName, String userName, String password,boolean admin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.iD = iD;
        this.admin = admin;
        this.userName = userName;
        this.password = password;
    }

    public User(String userName, String password, String firstName, String lastName, boolean admin) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.admin = admin;


    }




    public void generatePassword() {

        int length = 8;

        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

        String values = Capital_chars + Small_chars + numbers + symbols;
        String valuesNoSymbols = Capital_chars + Small_chars + numbers;

        // Using random method
        Random random = new Random();

        char[] password = new char[length];

        password[0] = Capital_chars.charAt(random.nextInt(Capital_chars.length()));
        password[1] = Small_chars.charAt(random.nextInt(Small_chars.length()));
        password[2] = numbers.charAt(random.nextInt(numbers.length()));
        password[3] = symbols.charAt(random.nextInt(symbols.length()));

        for (int i = 4; i < length; i++) {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int

            password[i] = values.charAt(random.nextInt(valuesNoSymbols.length()));

        }

        this.password = String.valueOf(password);

    }

    public String emitFirstName() {
        return firstName;
    }


    public String emitLastName() {
        return lastName;
    }


    public int emitID() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String emitUserName() {
        return userName;
    }


    public String emitPassword() {
        return password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }




    public SpannedString toStringAdminSpan() {



        String nameStr = "Name: ";
        String normalText1 = firstName + " " + lastName;

        SpannableString str2 = new SpannableString(nameStr + normalText1);
        str2.setSpan(new StyleSpan(Typeface.BOLD), 0, nameStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String idStr = "\nID: ";
        String normalText2 = String.valueOf(iD);
        SpannableString str3 = new SpannableString(idStr + normalText2);
        str3.setSpan(new StyleSpan(Typeface.BOLD), 0, idStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String adminStr = "\nAdmin: ";
        String normalText3 = String.valueOf(admin);
        SpannableString str4 = new SpannableString(adminStr + normalText3);
        str4.setSpan(new StyleSpan(Typeface.BOLD), 0, adminStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String usernameStr = "\nUserName: ";
        String normalText4 = userName;
        SpannableString str5 = new SpannableString(usernameStr + normalText4);
        str5.setSpan(new StyleSpan(Typeface.BOLD), 0, usernameStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String passwordStr = "\npassword: ";
        String normalText5 = password + "\n\n";
        SpannableString str6 = new SpannableString(passwordStr + normalText5);
        str6.setSpan(new StyleSpan(Typeface.BOLD), 0, passwordStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        SpannedString result = (SpannedString) TextUtils.concat(str2, str3, str4, str5, str6);




        return  result;


    }

    @Override
    public String toString() {
        return
                "Name: " + firstName + " " + lastName
                        + "\n ID: " + iD +
                        "\n Admin: " + admin +
                        "\n UserName: " + userName +
                        "\n password: " + "*******";
    }

    public String toStringAdmin() {
        return
                "Name: " + firstName + " " + lastName
                        + "\n ID: " + iD +
                        "\n Admin: " + admin +
                        "\n UserName: " + userName +
                        "\n password: " + password;
    }

    public SpannedString toStringSpan() {



        String nameStr = "Name: ";
        String normalText1 = firstName + " " + lastName;

        SpannableString str2 = new SpannableString(nameStr + normalText1);
        str2.setSpan(new StyleSpan(Typeface.BOLD), 0, nameStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String idStr = "\nID: ";
        String normalText2 = String.valueOf(iD);
        SpannableString str3 = new SpannableString(idStr + normalText2);
        str3.setSpan(new StyleSpan(Typeface.BOLD), 0, idStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String adminStr = "\nAdmin: ";
        String normalText3 = String.valueOf(admin);
        SpannableString str4 = new SpannableString(adminStr + normalText3);
        str4.setSpan(new StyleSpan(Typeface.BOLD), 0, adminStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String usernameStr = "\nUserName: ";
        String normalText4 = userName;
        SpannableString str5 = new SpannableString(usernameStr + normalText4);
        str5.setSpan(new StyleSpan(Typeface.BOLD), 0, usernameStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String passwordStr = "\npassword: ";
        String normalText5 = "**********\n\n";
        SpannableString str6 = new SpannableString(passwordStr + normalText5);
        str6.setSpan(new StyleSpan(Typeface.BOLD), 0, passwordStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        SpannedString result = (SpannedString) TextUtils.concat(str2, str3, str4, str5, str6);




        return  result;


    }


}
