package com.project.cse248garage.model;
import java.io.Serializable;
import java.util.Random;
import java.util.regex.Pattern;


/**
 * The type Manager.
 */
public class Manager extends User implements Serializable {

    /**
     * Instantiates a new Manager.
     *
     * @param userName  the user name
     * @param password  the password
     * @param firstName the first name
     * @param lastName  the last name
     * @param admin     the admin
     */
    public Manager(String userName, String password, String firstName, String lastName, boolean admin) {
        super(userName, password, firstName, lastName, admin);
    }


}
