package com.project.cse248garage.model;

import java.io.Serializable;

/**
 * The type Attendant.
 */
public class Attendant extends User implements Serializable {


    /**
     * Instantiates a new Attendant.
     *
     * @param userName  the user name
     * @param password  the password
     * @param firstName the first name
     * @param lastName  the last name
     * @param admin     the admin
     */
    public Attendant(String userName, String password, String firstName, String lastName, boolean admin) {
        super(userName, password, firstName, lastName, admin);
    }
}
