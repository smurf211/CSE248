package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.CheckCredentials;

class CheckPassTest {

	@Test
	void test() {
		CheckCredentials create = new CheckCredentials();
		assertEquals(true, create.checkPassword("MjsRas1118!"));
		assertEquals(true, create.checkPassword("PapaSmurf211!"));
		assertEquals(false, create.checkPassword("MjsRas1118"));
		assertEquals(false, create.checkPassword("MjsRas!"));
		assertEquals(false, create.checkPassword("mjsras1118!"));
	}

}
