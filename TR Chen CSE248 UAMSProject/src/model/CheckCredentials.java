package model;

/**
 * 
 * 
 * The CheckCredentials class contains several methods which check for valid usernames and passwords, as well as check
 * for correct login information.
 * 
 * @see <A href="../src/model/CheckCredentials.java">Java
 *      sourceCode</A>
 * 
 * 
 * @author Mike <A href="mailto:spadm98@sunysuffolk.edu">
 *         spadm98@sunysuffolk.edu </A>
 * 
 * @version v1.0, 2/26/2019
 * 
 */

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckCredentials {
	

	
	
	
	String capitals = "[A-Z]+";
	String numbers = "[0-9]+";
	String lowercase = "[a-z]+";
	String symbols = "[!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~]+";
	Pattern patternCapitals = Pattern.compile(capitals);
	Pattern patternLowercase = Pattern.compile(lowercase);
	Pattern patternNumbers = Pattern.compile(numbers);
	Pattern patternSymbols = Pattern.compile(symbols);
	
	/**
	 *  Checks if the HashMap contains the given username.
	 *  
	 *  
	 *  
	 * @param String userName, HashMap<UserAccount, String> map
	 * @return true if userName is not in HashMap, false if userName is in HashMap
	 * @author mike
	 */
	
	
	



	public boolean checkUserNameHash(String userName, HashMap<UserAccount, String> map) {

		if (map.containsValue(userName)) {

			return false;
		}
		return true;

	}
	
	
	/**
	 *  Checks if the password contains the appropriate character combinations
	 *  
	 *  
	 *  
	 * @param String password
	 * @return true if password is valid, false if password is invalid
	 * @author mike
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
	 *  method to login using existing account
	 *  
	 *  
	 *  
	 * @param String userName, String password, HashMap<UserAccount, String> map
	 * @return true if both username and password are a match, false if either username or password is incorrect
	 * @author mike
	 */

	public boolean login(String userName, String password, HashMap<UserAccount, String> map) {

		UserAccount user = null;
		for (Entry<UserAccount, String> entry : map.entrySet()) {
			if (userName.toLowerCase().equals(entry.getValue())) {

				user = entry.getKey();
				break;
			}
		}

		if (user.emitPassword().equals(password)) {
			return true;

		}

		return false;

	}

}
