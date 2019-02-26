package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.UserAccountBag;

class FillBagHashTest {

	@Test
	void test() {
		UserAccountBag bag = new UserAccountBag();
		bag.fillBagHash(3000);
		bag.displayBagHash();
		System.out.println(bag.getnElems());
			
	}

}
