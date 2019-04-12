package com.project.cse248garage.model;
import java.util.Random;
import java.util.regex.Pattern;


public class Manager extends User {

    public Manager(String userName, String password, String firstName, String lastName, boolean admin) {
        super(userName, password, firstName, lastName, true);
    }

    public Manager(String firstName, String lastName, boolean admin) {
        super(firstName, lastName, admin);
    }

    public Manager(String password, String firstName, String lastName, boolean admin) {
        super(password, firstName, lastName, admin);
    }
}
