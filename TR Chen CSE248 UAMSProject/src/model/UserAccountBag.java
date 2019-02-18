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
		
		
		
		
		while(input1.hasNext() && input2.hasNext()){
			
			input1.next();
			firstNameMale = input1.next();
			lastName = input2.next();
			
			insert(firstNameMale, lastName, male);
			
			if(input3.hasNext()) {
			firstNameFemale = input3.next();
			lastName = input2.next();
			
			insert(firstNameFemale, lastName, female);
			
					
			}
		}
		
	}
	
	
	public void displayBag() {
		
		int counter = 0;
		
		for(int i =0; i< nElems; i++) {
		
		System.out.println(userAccountArr[counter].getFirstName() +" " + userAccountArr[counter].getLastName() 
				+ " " + userAccountArr[counter].getGender() + " " + userAccountArr[counter].getUserName() 
				+ " " + userAccountArr[counter].getiD() + " " + userAccountArr[counter].getGPA() + " " + userAccountArr[counter].getPassword());
		
		counter++;
		}
	}

}
