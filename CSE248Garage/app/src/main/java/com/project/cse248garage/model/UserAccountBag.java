package com.project.cse248garage.model;

/**
 * The UserAccountBag class stores all users generated from NameWarehouse and stores them in a HashMap
 *
 * @author Mike <A href="mailto:spadm98@sunysuffolk.edu">
 * spadm98@sunysuffolk.edu </A>
 * @version v1.0, 2/26/2019
 * @see <A href="../src/model/UserAccountBag.java">Java
 * sourceCode</A>
 */

import android.text.SpannedString;
import android.text.TextUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

/**
 * The type User account bag.
 */
public class UserAccountBag implements Serializable {

    private int nElems;
    /**
     * The User account hash.
     */
    public HashMap<User, String> userAccountHash = new HashMap<User, String>();

    /**
     * Instantiates a new User account bag.
     */
    public UserAccountBag() {

        nElems = 0;
        createManagerAccountLoose("admin", "123", "mike", "spadaro", true);
        User user = getUser("admin", userAccountHash);
        user.setiD(1);

    }


    /**
     * Gets user.
     *
     * @param userName the user name
     * @param password the password
     * @param map      the map
     * @return the user
     */
    public User getUser(String userName, String password, HashMap<User, String> map) {

        User user = null;
        for (Entry<User, String> entry : map.entrySet()) {
            if (userName.toLowerCase().equals(entry.getValue())) {

                user = entry.getKey();
                break;
            }
        }

        if (user.emitPassword().equals(password)) {
            return user;

        }

        return null;

    }

    /**
     * Gets user.
     *
     * @param userName the user name
     * @param map      the map
     * @return the user
     */
    public User getUser(String userName, HashMap<User, String> map) {

        User user = null;
        for (Entry<User, String> entry : map.entrySet()) {
            if (userName.toLowerCase().equals(entry.getValue())) {

                user = entry.getKey();
                break;
            }
        }

        if (user != null) {
            return user;
        }


        return null;


    }


    /**
     * Gets users array list.
     *
     * @param map the map
     * @return the users array list
     */
    public ArrayList<String> getUsersArrayList(HashMap<User, String> map) {

        ArrayList<String> userNames = new ArrayList<String>();

        for (Entry<User, String> entry : map.entrySet()) {


            userNames.add(entry.getKey().emitUserName());


        }


        return userNames;


    }

    /**
     * Gets logged in user.
     *
     * @param map the map
     * @return the logged in user
     */
    public User getLoggedInUser(HashMap<User, String> map) {

        String userName;
        User user;
        Iterator it = userAccountHash.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();

            user = (User) pair.getKey();
            if (user.isLoggedIn()) {
                return user;
            }

        }


        return null;
    }


    /**
     * Create manager account boolean.
     *
     * @param userName  the user name
     * @param password  the password
     * @param firstName the first name
     * @param lastName  the last name
     * @param admin     the admin
     * @return the boolean
     */
    public boolean createManagerAccount(String userName, String password, String firstName, String lastName, boolean admin) {

        CheckCredentials create = new CheckCredentials();

        if (create.checkUserNameHash(userName, userAccountHash) && create.checkPassword(password)) {

            Manager user = new Manager(userName, password, firstName, lastName, admin);
            userAccountHash.put(user, user.emitUserName());
            return true;
        }

        return false;

    }

    /**
     * Create manager account loose.
     *
     * @param userName  the user name
     * @param password  the password
     * @param firstName the first name
     * @param lastName  the last name
     * @param admin     the admin
     */
    public void createManagerAccountLoose(String userName, String password, String firstName, String lastName, boolean admin) {


        Manager user = new Manager(userName, password, firstName, lastName, admin);
        userAccountHash.put(user, user.emitUserName());


    }

    /**
     * Create attendant account boolean.
     *
     * @param userName  the user name
     * @param password  the password
     * @param firstName the first name
     * @param lastName  the last name
     * @return the boolean
     */
    public boolean createAttendantAccount(String userName, String password, String firstName, String lastName) {


        CheckCredentials create = new CheckCredentials();

        if (create.checkUserNameHash(userName, userAccountHash) && create.checkPassword(password)) {

            Attendant user = new Attendant(userName, password, firstName, lastName, false);
            userAccountHash.put(user, user.emitUserName());
            return true;
        }

        return false;

    }


    /**
     * Remove user.
     *
     * @param user the user
     */
    public void removeUser(User user) {

        userAccountHash.remove(user);
    }


    /**
     * Display bag hash.
     */
    public void displayBagHash() {

        System.out.println(Arrays.asList(userAccountHash));

    }

    /**
     * Display bag admin string.
     *
     * @return the string
     */
    public String displayBagAdmin() {
        int i = 1;
        String display = "";
        User user;
        Iterator it = userAccountHash.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();

            user = (User) pair.getKey();
            display += "\n" + i + ". " + user.toStringAdmin() + "\n";
            i++;

        }


        return display;


    }


    /**
     * Display bag user string.
     *
     * @return the string
     */
    public String displayBagUser() {
        int i = 1;
        String display = "";
        User user;
        Iterator it = userAccountHash.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();

            user = (User) pair.getKey();
            display += "\n" + i + ". " + user.toString() + "\n";
            i++;

        }


        return display;


    }

    /**
     * Gets elems.
     *
     * @return the elems
     */
    public int getnElems() {
        return nElems;
    }

    /**
     * Gets user account hash.
     *
     * @return the user account hash
     */
    public HashMap<User, String> getUserAccountHash() {
        return userAccountHash;
    }

}
