package model;

/**
 * 
 * 
 * UserAccount class to create new users.
 * 
 * @see <A href="../src/model/UserAccount.java">Java
 *      sourceCode</A>
 * 
 * 
 * @author Mike <A href="mailto:spadm98@sunysuffolk.edu">
 *         spadm98@sunysuffolk.edu </A>
 * 
 * @version v1.0, 2/26/2019
 * 
 */

import java.util.Random;
import java.util.regex.Pattern;

public class UserAccount {

	private String firstName;
	private String lastName;
	private String iD;
	private String gender;
	private String userName;
	private String password;
	private double GPA;

	private static int idCounter = 0;

	public UserAccount(String firstName, String lastName, String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		iD = String.valueOf(++idCounter);
		for (int i = 8; i > String.valueOf(idCounter).length(); i--) {
			iD = '0' + iD;

		}
		userName = createUserName();
		generateGPA();
		generatePassword();
	}
	
	public UserAccount(String password, String firstName, String lastName, String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.password = password;
		iD = String.valueOf(++idCounter);
		for (int i = 8; i > String.valueOf(idCounter).length(); i--) {
			iD = '0' + iD;

		}
		userName = createUserName();
		generateGPA();
		generatePassword();
	}

	public UserAccount(String userName, String password, String firstName, String lastName, String gender) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;

		iD = String.valueOf(++idCounter);
		for (int i = 8; i > String.valueOf(idCounter).length(); i--) {
			iD = '0' + iD;

		}
		generateGPA();

	}
	
	/**
	 *  create username based on first, last name and id.
	 *  
	 *  
	 *  
	 * @param none
	 * @return String username
	 * @author mike
	 */

	public String createUserName() {

		String userName = null;

		if (lastName.length() >= 4) {
			userName = lastName.substring(0, 4);
			userName = userName.concat(firstName.substring(0, 1));
			userName = userName.concat(iD.substring(iD.length() - 2, iD.length()));

		}

		if (lastName.length() < 4) {

			userName = lastName;
			userName = userName.concat(firstName.substring(0, 1));
			userName = userName.concat(iD.substring(iD.length() - 2, iD.length()));

		}

		return userName;
	}
	
	
	
	
	
	/**
	 *  generate random GPA for users
	 *  
	 *  
	 *  
	 * @param none
	 * @return void
	 * @author mike
	 */

	public void generateGPA() {

		double randomDouble = Math.random();

		randomDouble = randomDouble * 4;

		double roundOff = Math.round(randomDouble * 10.0) / 10.0;

		GPA = roundOff;

	}
	
	/**
	 *  generate random password
	 *  
	 *  
	 *  
	 * @param none
	 * @return void
	 * @author mike
	 */


	public void generatePassword() {

		int length = 8;

		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Small_chars = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String symbols = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

		String values = Capital_chars + Small_chars + numbers + symbols;
		String valuesNoSymbols = Capital_chars + Small_chars + numbers;

		// Using random method
		Random random = new Random();

		char[] password = new char[length];

		password[0] = Capital_chars.charAt(random.nextInt(Capital_chars.length()));
		password[1] = Small_chars.charAt(random.nextInt(Small_chars.length()));
		password[2] = numbers.charAt(random.nextInt(numbers.length()));
		password[3] = symbols.charAt(random.nextInt(symbols.length()));

		for (int i = 4; i < length; i++) {
			// Use of charAt() method : to get character value
			// Use of nextInt() as it is scanning the value as int

			password[i] = values.charAt(random.nextInt(valuesNoSymbols.length()));

		}

		this.password = String.valueOf(password);

	}

	public String emitFirstName() {
		return firstName;
	}


	public String emitLastName() {
		return lastName;
	}



	public String emitID() {
		return iD;
	}



	public String emitUserName() {
		return userName;
	}

	

	public String emitPassword() {
		return password;
	}

	

	public double emitGPA() {
		return GPA;
	}

	

	@Override
	public String toString() {
		return "UserAccount [firstName=" + firstName + ", lastName=" + lastName + ", iD=" + iD + ", gender=" + gender
				+ ", userName=" + userName + ", password=" + password + ", GPA=" + GPA + "]";
	}

	public String getGender() {
		return gender;
	}



}
