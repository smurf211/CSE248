package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.UserAccountBag;

class CreateAccountTest {

	@Test
	void test() {
		UserAccountBag bag = new UserAccountBag(5000);
		bag.fillBag(3000);
		
		
		
		assertEquals(true, bag.createAccount("spadm98", "MjsRas1118!", "mike", "spad", "male"));
		assertEquals(false,  bag.createAccount("spadm98", "MjsRas1118", "mike", "spad", "male"));
		assertEquals(false,  bag.createAccount("spadm98", "mjsras118!", "mike", "spad", "male"));
	}

}
