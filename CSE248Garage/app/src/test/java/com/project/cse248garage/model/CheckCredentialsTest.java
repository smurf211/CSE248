package com.project.cse248garage.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CheckCredentialsTest {


    @Test
    public void checkPassword() {
        CheckCredentials create = new CheckCredentials();
        assertEquals(true, create.checkPassword("MjsRas1118!"));
        assertEquals(true, create.checkPassword("PapaSmurf211!"));
        assertEquals(false, create.checkPassword("MjsRas1118"));
        assertEquals(false, create.checkPassword("MjsRas!"));
        assertEquals(false, create.checkPassword("mjsras1118!"));

    }

    @Test
    public void login() {

        UserAccountBag bag = new UserAccountBag();

        bag.createAttendantAccount("spadm98", "MjsRas1118!", "mike", "spad");
        CheckCredentials function = new CheckCredentials();
        assertEquals(true, function.login("spadm98", "MjsRas1118!", bag.getUserAccountHash()));
        assertEquals(false, function.login("spadm98", "MjsRas1118", bag.getUserAccountHash()));


    }
}