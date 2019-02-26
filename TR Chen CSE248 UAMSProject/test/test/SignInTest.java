package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.CheckCredentials;
import model.UserAccountBag;

class SignInTest {

	@Test
	void test() {
		UserAccountBag bag = new UserAccountBag();
		bag.fillBagHash(3000);
		bag.createAccount("spadm98", "MjsRas1118!", "mike", "spad", "male");
		CheckCredentials function = new CheckCredentials();
		assertEquals(true, function.login("spadm98", "MjsRas1118!", bag.getUserAccountHash()));
		assertEquals(false, function.login("spadm98", "MjsRas1118", bag.getUserAccountHash()));
		
		
		
		
	}

}
