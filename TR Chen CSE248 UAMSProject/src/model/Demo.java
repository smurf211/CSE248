package model;

public class Demo {

	public static void main(String[] args) {
		UserAccountBag bag = new UserAccountBag(2000);
		
		bag.importFileBoy("inputData/boys_names.txt", "inputData/lastNames.txt", "inputData/girls_names.txt");
		bag.displayBag();
		System.out.println("hello world");

	}

}
