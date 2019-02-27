package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.UserAccountBag;

class CreateAccountAutoTest {

	@Test
	void test() {
		UserAccountBag bag = new UserAccountBag();
		bag.fillBagHash(3000);
		assertEquals("success", bag.createAccountStringAuto("MjsRas1118!", "mike", "Spadaro", "male"));
		assertEquals("success", bag.createAccountStringAuto("MjsRas1118!", "mike", "Spadaro", "male"));
		assertEquals("success", bag.createAccountStringAuto("MjsRas1118!", "mike", "Spadaro", "male"));
		assertEquals("success", bag.createAccountStringAuto("MjsRas1118!", "mike", "Spadaro", "male"));

		assertEquals("badPass", bag.createAccountStringAuto("MjsRas1118", "mike", "Spadaro", "male"));
		assertEquals("badPass", bag.createAccountStringAuto("mjsras1118!", "mike", "Spadaro", "male"));
		assertEquals("badName", bag.createAccountStringAuto("mjsras1118!", "", "Spadaro", "male"));
		assertEquals("badName", bag.createAccountStringAuto("mjsras1118!", "mike", "", "male"));
		
		bag.displayBagHash();
	}

}
