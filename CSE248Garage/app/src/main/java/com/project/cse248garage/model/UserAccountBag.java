package com.project.cse248garage.model;

/**
 * 
 * 
 * The UserAccountBag class stores all users generated from NameWarehouse and stores them in a HashMap
 * 
 * @see <A href="../src/model/UserAccountBag.java">Java
 *      sourceCode</A>
 * 
 * 
 * @author Mike <A href="mailto:spadm98@sunysuffolk.edu">
 *         spadm98@sunysuffolk.edu </A>
 * 
 * @version v1.0, 2/26/2019
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class UserAccountBag {

	private int nElems;
	public HashMap<Manager, String> userAccountHash = new HashMap<Manager, String>();

	public UserAccountBag() {

		nElems = 0;

	}



	public void insertHash(String firstName, String lastName, boolean admin) {
		Manager user = new Manager(firstName, lastName, admin);
		userAccountHash.put(user, user.emitUserName().toLowerCase());
		nElems++;

	}



	public boolean searchAccount(String userName, String password, HashMap<Manager, String> map) {

		Manager user = null;
		for (Entry<Manager, String> entry : map.entrySet()) {
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



	public boolean searchAccount(String userName, HashMap<Manager, String> map) {

		if (map.containsValue(userName)) {

			return false;
		}
		return true;

	}



	public boolean createManagerAccount(String userName, String password, String firstName, String lastName, boolean admin) {

		CheckCredentials create = new CheckCredentials();

		if (create.checkUserNameHash(userName, userAccountHash) && create.checkPassword(password)) {

			Manager user = new Manager(userName, password, firstName, lastName, admin);
			userAccountHash.put(user, user.emitUserName());
			return true;
		}

		return false;

	}

	public boolean createAttendantAccount(String userName, String password, String firstName, String lastName) {



		CheckCredentials create = new CheckCredentials();

		if (create.checkUserNameHash(userName, userAccountHash) && create.checkPassword(password)) {

			Manager user = new Manager(userName, password, firstName, lastName, false);
			userAccountHash.put(user, user.emitUserName());
			return true;
		}

		return false;

	}



	
	public String createAccountString(String userName, String password, String firstName, String lastName,
			boolean admin) {

		CheckCredentials create = new CheckCredentials();

		if (firstName.equals("") || lastName.equals("")) {

			return "badName";
		}

		if (create.checkUserNameHash(userName, userAccountHash)) {

			if (create.checkPassword(password)) {

				Manager user = new Manager(userName, password, firstName, lastName, admin);
				userAccountHash.put(user, user.emitUserName());

				return "success";

			} else {
				return "badPass";
			}

		} else {
			return "badUser";
		}

	}
	



	public String createAccountStringAuto(String password, String firstName, String lastName, boolean admin) {
		
		

		CheckCredentials create = new CheckCredentials();

		if (firstName.equals("") || lastName.equals("")) {

			return "badName";
		}
		
		Manager user = new Manager(password, firstName, lastName, admin);
		

		if (create.checkUserNameHash(user.emitUserName(), userAccountHash)) {

			if (create.checkPassword(password)) {

				
				userAccountHash.put(user, user.emitUserName());

				return "success";

			} else {
				return "badPass";
			}

		} else {
			return "badUser";
		}

	}






	public void displayBagHash() {

		System.out.println(Arrays.asList(userAccountHash));

	}

	public int getnElems() {
		return nElems;
	}

	public HashMap<Manager, String> getUserAccountHash() {
		return userAccountHash;
	}

}
