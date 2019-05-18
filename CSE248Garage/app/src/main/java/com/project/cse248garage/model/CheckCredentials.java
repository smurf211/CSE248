package com.project.cse248garage.model;

/**
 * The CheckCredentials class contains several methods which check for valid usernames and passwords, as well as check
 * for correct login information.
 *
 * @author Mike <A href="mailto:spadm98@sunysuffolk.edu">
 * spadm98@sunysuffolk.edu </A>
 * @version v1.0, 2/26/2019
 * @see <A href="../src/model/CheckCredentials.java">Java
 * sourceCode</A>
 */

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Check credentials.
 */
public class CheckCredentials implements Serializable {


    /**
     * The Capitals.
     */
    String capitals = "[A-Z]+";
    /**
     * The Numbers.
     */
    String numbers = "[0-9]+";
    /**
     * The Lowercase.
     */
    String lowercase = "[a-z]+";
    /**
     * The Symbols.
     */
    String symbols = "[!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~]+";
    /**
     * The Pattern capitals.
     */
    Pattern patternCapitals = Pattern.compile(capitals);
    /**
     * The Pattern lowercase.
     */
    Pattern patternLowercase = Pattern.compile(lowercase);
    /**
     * The Pattern numbers.
     */
    Pattern patternNumbers = Pattern.compile(numbers);
    /**
     * The Pattern symbols.
     */
    Pattern patternSymbols = Pattern.compile(symbols);


    /**
     * Check user name hash boolean.
     *
     * @param userName the user name
     * @param map      the map
     * @return the boolean
     */
    public boolean checkUserNameHash(String userName, HashMap<User, String> map) {

        if (userName.equals("")) {
            return false;
        }

        if (map.containsValue(userName)) {

            return false;
        }
        return true;

    }


    /**
     * Check password boolean.
     *
     * @param password the password
     * @return the boolean
     */
    public boolean checkPassword(String password) {

        Matcher matcherCapitals = patternCapitals.matcher(password);
        Matcher matcherLowercase = patternLowercase.matcher(password);
        Matcher matcherNumbers = patternNumbers.matcher(password);
        Matcher matcherSymbols = patternSymbols.matcher(password);

        if (matcherCapitals.find() && matcherLowercase.find() && matcherNumbers.find() && matcherSymbols.find()) {

            return true;

        }

        return false;

    }


    /**
     * Login boolean.
     *
     * @param userName the user name
     * @param password the password
     * @param map      the map
     * @return the boolean
     */
    public boolean login(String userName, String password, HashMap<User, String> map) {

        User user = null;
        for (Entry<User, String> entry : map.entrySet()) {
            if (userName.toLowerCase().equals(entry.getValue())) {

                user = entry.getKey();
                break;
            }
        }

        if ((user != null) && user.emitPassword().equals(password)) {
            user.setLoggedIn(true);
            return true;

        }

        return false;

    }


}
