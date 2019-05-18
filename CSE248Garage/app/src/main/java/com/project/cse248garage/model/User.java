package com.project.cse248garage.model;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.StyleSpan;

import java.io.Serializable;
import java.util.Random;

/**
 * The type User.
 */
public class User implements Serializable {

    private String firstName;
    private String lastName;
    private int iD;
    private boolean admin;
    private boolean loggedIn;

    private String userName;
    private String password;


    /**
     * Instantiates a new User.
     */
    public User() {

    }


    /**
     * Instantiates a new User.
     *
     * @param iD        the d
     * @param firstName the first name
     * @param lastName  the last name
     * @param userName  the user name
     * @param password  the password
     * @param admin     the admin
     */
    public User(int iD, String firstName, String lastName, String userName, String password, boolean admin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.iD = iD;
        this.admin = admin;
        this.userName = userName;
        this.password = password;
    }

    /**
     * Instantiates a new User.
     *
     * @param userName  the user name
     * @param password  the password
     * @param firstName the first name
     * @param lastName  the last name
     * @param admin     the admin
     */
    public User(String userName, String password, String firstName, String lastName, boolean admin) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.admin = admin;


    }


    /**
     * Generate password.
     */
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

    /**
     * Emit first name string.
     *
     * @return the string
     */
    public String emitFirstName() {
        return firstName;
    }


    /**
     * Emit last name string.
     *
     * @return the string
     */
    public String emitLastName() {
        return lastName;
    }


    /**
     * Emit id int.
     *
     * @return the int
     */
    public int emitID() {
        return iD;
    }

    /**
     * Sets d.
     *
     * @param iD the d
     */
    public void setiD(int iD) {
        this.iD = iD;
    }

    /**
     * Emit user name string.
     *
     * @return the string
     */
    public String emitUserName() {
        return userName;
    }


    /**
     * Emit password string.
     *
     * @return the string
     */
    public String emitPassword() {
        return password;
    }

    /**
     * Is admin boolean.
     *
     * @return the boolean
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * Is logged in boolean.
     *
     * @return the boolean
     */
    public boolean isLoggedIn() {
        return loggedIn;
    }

    /**
     * Sets logged in.
     *
     * @param loggedIn the logged in
     */
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }


    /**
     * To string admin span spanned string.
     *
     * @return the spanned string
     */
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


        return result;


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

    /**
     * To string admin string.
     *
     * @return the string
     */
    public String toStringAdmin() {
        return
                "Name: " + firstName + " " + lastName
                        + "\n ID: " + iD +
                        "\n Admin: " + admin +
                        "\n UserName: " + userName +
                        "\n password: " + password;
    }

    /**
     * To string span spanned string.
     *
     * @return the spanned string
     */
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


        return result;


    }


}
