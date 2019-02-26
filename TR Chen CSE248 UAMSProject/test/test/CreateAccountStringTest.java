package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.UserAccountBag;

class CreateAccountStringTest {

	@Test
	void test() {
		UserAccountBag bag = new UserAccountBag();
		bag.fillBagHash(3000);
		assertEquals("success",	bag.createAccountString("spadm98", "MjsRas1118!", "mike", "Spadaro", "male"));
		assertEquals("badUser", bag.createAccountString("spadm98", "MjsRas1118!", "mike", "Spadaro", "male"));
		assertEquals("badPass", bag.createAccountString("spadm9899", "MjsRas1118", "mike", "Spadaro", "male"));
		assertEquals("badPass", bag.createAccountString("spadm123", "mjsras1118!", "mike", "Spadaro", "male"));
	}

}
