package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.CheckCredentials;
import model.UserAccountBag;

class CheckUserNameTest {

	@Test
	void test() {
		UserAccountBag bag = new UserAccountBag();
		bag.fillBagHash(3000);
		bag.createAccount("spadm98", "MjsRas1118!", "mike", "spad", "male");
		bag.createAccount("smurf211", "MjsRas1118!", "mike", "spad", "male");
		CheckCredentials create = new CheckCredentials();
		assertEquals(false, create.checkUserNameHash("spadm98", bag.getUserAccountHash()));
		assertEquals(true, create.checkUserNameHash("spadm9899", bag.getUserAccountHash()));
		assertEquals(false, create.checkUserNameHash("smurf211", bag.getUserAccountHash()));
		
	}

}
