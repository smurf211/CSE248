package model;

public class Demo {

	public static void main(String[] args) {
		
		//NelsK8
		UserAccountBag bag = new UserAccountBag(1500);
		
		//bag.importFileBoy("inputData/boys_names.txt", "inputData/lastNames.txt", "inputData/girls_names.txt");
	//	bag.displayBag();
		
		
		
		//
	//	CreateFunctions create = new CreateFunctions();
		
		//System.out.println(create.checkUserName("Nelsk21", bag.getUserAccountArr(), bag.getnElems()));
		
		//System.out.println(bag.createAccount("smurf211", "PapaSmurf211", "Mike", "Spadaro", "male"));
		
		//System.out.println(create.login("smurf211", "PapSmurf211!", bag.getUserAccountArr(), bag.getnElems()));
		
	//	String password = "Papasmurf211!";
		
		//System.out.println(create.checkPassword(password));
		
		
		bag.fillBag(1500);
		bag.displayBag();
		
		
		
		

	}

}
