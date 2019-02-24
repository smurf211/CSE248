package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.CreateFunctions;
import model.UserAccountBag;

class SignInTest {

	@Test
	void test() {
		UserAccountBag bag = new UserAccountBag(5000);
		bag.fillBag(3000);
		bag.createAccount("spadm98", "MjsRas1118!", "mike", "spad", "male");
		CreateFunctions function = new CreateFunctions();
		assertEquals(true, function.login("spadm98", "MjsRas1118!", bag.getUserAccountArr(), bag.getnElems()));
		assertEquals(false, function.login("spadm98", "MjsRas1118", bag.getUserAccountArr(), bag.getnElems()));
	}

}
