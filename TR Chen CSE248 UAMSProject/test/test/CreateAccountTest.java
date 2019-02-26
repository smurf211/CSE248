package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.UserAccountBag;

class CreateAccountTest {

	@Test
	void test() {
		UserAccountBag bag = new UserAccountBag();
		bag.fillBagHash(3000);
		assertEquals(true,	bag.createAccount("spadm98", "MjsRas1118!", "mike", "Spadaro", "male"));
		assertEquals(false, bag.createAccount("spadm98", "MjsRas1118!", "mike", "Spadaro", "male"));
		assertEquals(false, bag.createAccount("spadm9899", "MjsRas1118", "mike", "Spadaro", "male"));
		assertEquals(false, bag.createAccount("spadm123", "mjsras1118!", "mike", "Spadaro", "male"));
	}

}
