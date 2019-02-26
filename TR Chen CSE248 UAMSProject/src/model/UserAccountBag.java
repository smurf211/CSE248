package model;

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
	HashMap<UserAccount, String> userAccountHash = new HashMap<UserAccount, String>();

	public UserAccountBag() {

		nElems = 0;

	}
	
	/**
	 *  insert new user into HashMap
	 *  
	 *  
	 *  
	 * @param String firstName, String lastName, String gender
	 * @return void
	 * @author mike
	 */

	public void insertHash(String firstName, String lastName, String gender) {
		UserAccount user = new UserAccount(firstName, lastName, gender);
		userAccountHash.put(user, user.emitUserName().toLowerCase());
		nElems++;

	}
	
	/**
	 *  searchAccount in hashMap
	 *  
	 *  
	 *  
	 * @param String userName, String password, HashMap<UserAccount, String> map
	 * @return return true if user and password match, false if no match.
	 * @author mike
	 */

	public boolean searchAccount(String userName, String password, HashMap<UserAccount, String> map) {

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
	
	/**
	 *  searchAccount in hashMap
	 *  
	 *  
	 *  
	 * @param String userName, HashMap<UserAccount, String> map
	 * @return return true if user matches, false if no match
	 * @author mike
	 */

	public boolean searchAccount(String userName, HashMap<UserAccount, String> map) {

		if (map.containsValue(userName)) {

			return false;
		}
		return true;

	}
	
	/**
	 *  create account, checks for duplicate username and correct password
	 *  
	 *  
	 *  
	 * @param String userName, String password, String firstName, String lastName, String gender
	 * @return return true if userName and password valid. false if else
	 * @author mike
	 */

	public boolean createAccount(String userName, String password, String firstName, String lastName, String gender) {

		CheckCredentials create = new CheckCredentials();

		if (create.checkUserNameHash(userName, userAccountHash) && create.checkPassword(password)) {

			
			UserAccount user = new UserAccount(userName, password, firstName, lastName, gender);
			userAccountHash.put(user, user.emitUserName());
			return true;
		}

		return false;

	}
	
	/**
	 *  create account, checks for duplicate username and correct password
	 *  
	 *  
	 *  
	 * @param String userName, String password, String firstName, String lastName, String gender
	 * @return return "success" if username and password valid, return "badPass" if password is no good, 
	 * return "badUser" if username is duplicate.
	 * @author mike
	 */

	public String createAccountString(String userName, String password, String firstName, String lastName,
			String gender) {

		CheckCredentials create = new CheckCredentials();

		if (create.checkUserNameHash(userName, userAccountHash)) {

			if (create.checkPassword(password)) {

				UserAccount user = new UserAccount(userName, password, firstName, lastName, gender);
				userAccountHash.put(user, user.emitUserName());

				return "success";

			} else {
				return "badPass";
			}

		} else {
			return "badUser";
		}

	}
	
	/**
	 *  fill HashMap from namewarehouse
	 *  
	 *  
	 *  
	 * @param int maxSize
	 * @return void
	 * @author mike
	 */

	public void fillBagHash(int maxSize) {

		NameWarehouse nameWarehouse = new NameWarehouse();

		nameWarehouse.importFiles("inputData/boys_names.txt", "inputData/girls_names.txt", "inputData/lastNames.txt");

		int j = 0;
		int q = 0;
		int h = 0;
		String male = "male";
		String female = "female";
		String[] boysFirstNames = nameWarehouse.getBoysFirstNames();
		String[] girlsFirstNames = nameWarehouse.getGirlsFirstNames();
		String[] lastNames = nameWarehouse.getLastNames();

		HashMap<UserAccount, String> userAccountHash = new HashMap<>();

		for (int i = 0; i < maxSize / 2; i++) {

			if (q == nameWarehouse.getBoySize()) {

				q = q - nameWarehouse.getBoySize();

			}

			if (j == nameWarehouse.getLastNameSize()) {

				j = j - (nameWarehouse.getLastNameSize());
			}

			insertHash(boysFirstNames[q], lastNames[j], male);
			// insert(boysFirstNames[q], lastNames[j], male);
			j++;
			q++;

		}

		for (int x = 0; x < maxSize / 2; x++) {

			if (h == nameWarehouse.getGirlSize()) {

				h = h - nameWarehouse.getGirlSize();

			}

			if (j == nameWarehouse.getLastNameSize()) {

				j = j - nameWarehouse.getLastNameSize();
			}

			insertHash(girlsFirstNames[h], lastNames[j], female);
			// insert(girlsFirstNames[h], lastNames[j], female);
			j++;
			h++;

		}

	}
	
	/**
	 *  displayHashMap, will not be in order
	 *  
	 *  
	 *  
	 * @param void
	 * @return void
	 * @author mike
	 */

	public void displayBagHash() {

		System.out.println(Arrays.asList(userAccountHash));

	}

	public int getnElems() {
		return nElems;
	}

	public HashMap<UserAccount, String> getUserAccountHash() {
		return userAccountHash;
	}

}
