package com.project.cse248garage.model;

import java.io.Serializable;

public class Attendant extends User implements Serializable {


    public Attendant(String firstName, String lastName, boolean admin) {
        super(firstName, lastName, admin);
    }

    public Attendant(String userName, String password, String firstName, String lastName, boolean admin) {
        super(userName, password, firstName, lastName, admin);
    }
}
