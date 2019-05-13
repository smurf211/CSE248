package com.project.cse248garage.model;

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
    /*

    public User(String firstName, String lastName, boolean admin ) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.admin = admin;

        userName = createUserName();

        generatePassword();
    }

    public User(String password, String firstName, String lastName, boolean admin) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.admin = admin;
        this.password = password;

        userName = createUserName();

        generatePassword();
    }
    */

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

/*

    public String createUserName() {

        String userName = null;

        if (lastName.length() >= 4) {
            userName = lastName.substring(0, 4);
            userName = userName.concat(firstName.substring(0, 1));
            userName = userName.concat(iD.substring(iD.length() - 2, iD.length()));

        }

        if (lastName.length() < 4) {

            userName = lastName;
            userName = userName.concat(firstName.substring(0, 1));
            userName = userName.concat(iD.substring(iD.length() - 2, iD.length()));

        }

        return userName;
    }



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


    public String toStringAdmin() {
        return
                "Name: " + firstName + " " + lastName
                        + "\n ID: " + iD +
                        "\n Admin: " + admin +
                        "\n UserName: " + userName +
                        "\n password: " + password;
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


}
