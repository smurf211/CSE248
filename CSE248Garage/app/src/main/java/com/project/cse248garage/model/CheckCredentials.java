package com.project.cse248garage.model;

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
	

	
	
	



	public boolean checkUserNameHash(String userName, HashMap<User, String> map) {

		if (map.containsValue(userName)) {

			return false;
		}
		return true;

	}
	

	
	public boolean checkFirstName(String firstName) {
		
		if(firstName.length() < 2) {
			return false;
		}
		return true;
	}
	

	
	public boolean checkLastName(String lastName) {
		
		if(lastName.length() < 2) {
			return false;
		}
		return true;
	}
			
			
	
	

	

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
