package model;

/**
 * 
 * 
 * The NameWarehouse class loads firstNames for boys and girls and last names into an array from .txt files to be used later.
 * 
 * @see <A href="../src/model/NameWarehouse.java">Java
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
import java.util.Scanner;

public class NameWarehouse {

	String[] boysFirstNames = new String[600];
	String[] girlsFirstNames = new String[599];
	String[] lastNames = new String[2000];

	int boySize = 0;
	int girlSize = 0;
	int lastNameSize = 0;
	
	/**
	 *  Displays boys names from array
	 *  
	 *  
	 *  
	 * @param none
	 * @return println
	 * @author mike
	 */

	public void displayBoys() {

		for (int i = 0; i < boysFirstNames.length; i++) {

			System.out.println(boysFirstNames[i]);
		}

	}
	
	/**
	 *  Displays girls names from array
	 *  
	 *  
	 *  
	 * @param none
	 * @return println
	 * @author mike
	 */

	public void displayGirls() {

		for (int i = 0; i < girlsFirstNames.length; i++) {

			System.out.println(girlsFirstNames[i]);
		}

	}
	
	/**
	 *  Displays last names from array
	 *  
	 *  
	 *  
	 * @param none
	 * @return println
	 * @author mike
	 */

	public void displaylastNames() {

		for (int i = 0; i < lastNames.length; i++) {

			System.out.println(lastNames[i]);
		}

	}
	
	/**
	 *  Import names from given txt files.
	 *  
	 *  
	 *  
	 * @param String boys, String girls, String lasts
	 * @return void
	 * @author mike
	 */

	public void importFiles(String boys, String girls, String lasts) {

		String firstNameMale;
		String firstNameFemale;
		String lastName;
		String male = "male";
		String female = "female";

		Scanner input1 = null;
		try {
			input1 = new Scanner(new File(boys));
		} catch (FileNotFoundException e) {
			System.out.println("File not Found!");
		}

		Scanner input2 = null;
		try {
			input2 = new Scanner(new File(girls));
		} catch (FileNotFoundException e) {
			System.out.println("File not Found!");
		}

		Scanner input3 = null;
		try {
			input3 = new Scanner(new File(lasts));
		} catch (FileNotFoundException e) {
			System.out.println("File not Found!");
		}

		int i = 0;
		int y = 0;
		int z = 0;

		while (input1.hasNext()) {

			input1.next();
			boysFirstNames[i] = input1.next();
			i++;
			boySize++;

		}

		while (input2.hasNext()) {

			girlsFirstNames[y] = input2.next();
			y++;
			girlSize++;
		}

		while (input3.hasNext()) {

			lastNames[z] = input3.next();
			z++;
			lastNameSize++;
		}

	}

	public String[] getBoysFirstNames() {
		return boysFirstNames;
	}

	public String[] getGirlsFirstNames() {
		return girlsFirstNames;
	}

	public String[] getLastNames() {
		return lastNames;
	}

	public int getBoySize() {
		return boySize;
	}

	public int getGirlSize() {
		return girlSize;
	}

	public int getLastNameSize() {
		return lastNameSize;
	}

}
