package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserAccountBag {

	private UserAccount[] userAccountArr;
	private int nElems;

	public UserAccountBag(int maxSize) {

		userAccountArr = new UserAccount[maxSize];
		nElems = 0;

	}

	public void insert(String firstName, String lastName, String gender) {
		userAccountArr[nElems++] = new UserAccount(firstName, lastName, gender);

	}

	public boolean createAccount(String userName, String password, String firstName, String lastName, String gender) {

		CreateFunctions create = new CreateFunctions();

		if (create.checkUserName(userName, userAccountArr, nElems) && create.checkPassword(password)) {

			userAccountArr[nElems++] = new UserAccount(userName, password, firstName, lastName, gender);
			return true;
		}

		return false;

	}

	public void fillBag(int maxSize) {

		NameWarehouse nameWarehouse = new NameWarehouse();
		
		nameWarehouse.importFiles("inputData/boys_names.txt", "inputData/girls_names.txt", "inputData/lastNames.txt" );
		
		int j = 0;
		int q = 0;
		int h = 0;
		String male = "male";
		String female = "female";
		String[] boysFirstNames = nameWarehouse.getBoysFirstNames();
		String[] girlsFirstNames = nameWarehouse.getGirlsFirstNames();
		String[] lastNames = nameWarehouse.getLastNames();

		for (int i = 0; i < maxSize / 2; i++) {

			if (q == nameWarehouse.getBoySize()  ) {

				q = q - nameWarehouse.getBoySize() ;

			}
			
			if(j == nameWarehouse.getLastNameSize() ) {
				
				j = j - (nameWarehouse.getLastNameSize() ) ;
			}
			
			
			insert(boysFirstNames[q], lastNames[j], male);
			j++;
			q++;

		}
		
		
		for(int x = 0; x < maxSize /2; x++) {
			
			
			if (h == nameWarehouse.getGirlSize()) {

				h = h - nameWarehouse.getGirlSize();

			}
			
			if(j == nameWarehouse.getLastNameSize()) {
				
				j = j - nameWarehouse.getLastNameSize();
			}
			
			insert(girlsFirstNames[h], lastNames[j], female);
			j++;
			h++;
			
		}
		
		
		
		
		
		

	}

	public void importFileBoy(String file1, String file2, String file3) {

		String firstNameMale;
		String firstNameFemale;
		String lastName;
		String male = "male";
		String female = "female";

		Scanner input1 = null;
		try {
			input1 = new Scanner(new File(file1));
		} catch (FileNotFoundException e) {
			System.out.println("File not Found!");
		}

		Scanner input2 = null;
		try {
			input2 = new Scanner(new File(file2));
		} catch (FileNotFoundException e) {
			System.out.println("File not Found!");
		}

		Scanner input3 = null;
		try {
			input3 = new Scanner(new File(file3));
		} catch (FileNotFoundException e) {
			System.out.println("File not Found!");
		}

		while (input1.hasNext() && input2.hasNext()) {

			input1.next();
			firstNameMale = input1.next();
			lastName = input2.next();

			insert(firstNameMale, lastName, male);

			if (input3.hasNext()) {
				firstNameFemale = input3.next();
				lastName = input2.next();

				insert(firstNameFemale, lastName, female);

			}
		}

	}

	public void displayBag() {

		int counter = 0;

		for (int i = 0; i < nElems; i++) {

			System.out.println(userAccountArr[counter].getFirstName() + " " + userAccountArr[counter].getLastName()
					+ " " + userAccountArr[counter].getGender() + " " + userAccountArr[counter].getUserName() + " "
					+ userAccountArr[counter].getiD() + " " + userAccountArr[counter].getGPA() + " "
					+ userAccountArr[counter].getPassword());

			counter++;
		}
	}

	public int getnElems() {
		return nElems;
	}

	public UserAccount[] getUserAccountArr() {
		return userAccountArr;
	}

	public void setUserAccountArr(UserAccount[] userAccountArr) {
		this.userAccountArr = userAccountArr;
	}

}
