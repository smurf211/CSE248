package com.project.cse248garage.model;
import java.io.Serializable;
import java.util.Random;
import java.util.regex.Pattern;


public class Manager extends User implements Serializable {

    public Manager(String userName, String password, String firstName, String lastName, boolean admin) {
        super(userName, password, firstName, lastName, admin);
    }


}
