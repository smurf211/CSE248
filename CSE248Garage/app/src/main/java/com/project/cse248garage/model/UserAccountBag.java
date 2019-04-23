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
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class UserAccountBag implements Serializable {

	private int nElems;
	public HashMap<User, String> userAccountHash = new HashMap<User, String>();

	public UserAccountBag() {

		nElems = 0;
		createManagerAccount("smurf211", "MjsRas1118!", "mike", "spadaro", true);

	}



	public void insertHash(String firstName, String lastName, boolean admin) {
		Manager user = new Manager(firstName, lastName, admin);
		userAccountHash.put(user, user.emitUserName().toLowerCase());
		nElems++;

	}



	public boolean searchAccount(String userName, String password, HashMap<User, String> map) {

		User user = null;
		for (Entry<User, String> entry : map.entrySet()) {
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

	public User getUser(String userName, HashMap<User, String> map) {

		User user = null;
		for (Entry<User, String> entry : map.entrySet()) {
			if (userName.toLowerCase().equals(entry.getValue())) {

				user = entry.getKey();
				break;
			}
		}

		if(user != null){
			return user;
		}




			return null;


	}

	public User getLoggedInUser(HashMap<User, String> map) {

		String userName;
		User user;
		Iterator it = userAccountHash.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			//System.out.println(pair.getKey() + " = " + pair.getValue());
			//userName = (String) pair.getValue();
			user = (User) pair.getKey();
			if(user.isLoggedIn()){
				return user;
			}
			//it.remove(); // avoids a ConcurrentModificationException
		}


	return null;
	}




	public boolean searchAccount(String userName, HashMap<User, String> map) {

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

			Attendant user = new Attendant(userName, password, firstName, lastName, false);
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

	public void logoutAttendants(){
	String userName;
	User user;
		Iterator it = userAccountHash.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			//System.out.println(pair.getKey() + " = " + pair.getValue());
			//userName = (String) pair.getValue();
			user = (User) pair.getKey();
			user.setLoggedIn(false);
			it.remove(); // avoids a ConcurrentModificationException
		}


	}






	public void displayBagHash() {

		System.out.println(Arrays.asList(userAccountHash));

	}

	public int getnElems() {
		return nElems;
	}

	public HashMap<User, String> getUserAccountHash() {
		return userAccountHash;
	}

}
