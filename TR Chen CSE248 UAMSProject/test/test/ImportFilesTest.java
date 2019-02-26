package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.NameWarehouse;

class ImportFilesTest {

	@Test
	void test() {
		NameWarehouse warehouse = new NameWarehouse();
		warehouse.importFiles("inputData/boys_names.txt", "inputData/girls_names.txt", "inputData/lastNames.txt");
		warehouse.displayBoys();
		warehouse.displayGirls();
		warehouse.displaylastNames();
	}

}
