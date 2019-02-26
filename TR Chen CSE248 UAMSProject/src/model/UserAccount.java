package model;

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

	public void generateGPA() {

		double randomDouble = Math.random();

		randomDouble = randomDouble * 4;

		double roundOff = Math.round(randomDouble * 10.0) / 10.0;

		GPA = roundOff;

	}

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getiD() {
		return iD;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double gPA) {
		GPA = gPA;
	}

	@Override
	public String toString() {
		return "UserAccount [firstName=" + firstName + ", lastName=" + lastName + ", iD=" + iD + ", gender=" + gender
				+ ", userName=" + userName + ", password=" + password + ", GPA=" + GPA + "]";
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
