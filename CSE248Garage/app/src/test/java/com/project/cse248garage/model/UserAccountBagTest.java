package com.project.cse248garage.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserAccountBagTest {

    UserAccountBag bag = new UserAccountBag();
    User user = bag.getUser("admin", bag.getUserAccountHash());

    @Test
    public void getUser() {


       assertEquals("admin", user.emitUserName());


    }

    @Test
    public void getLoggedInUser() {
        user.setLoggedIn(true);
        User user = bag.getLoggedInUser(bag.getUserAccountHash());
        assertEquals("admin", user.emitUserName());


    }

    @Test
    public void createManagerAccount() {
        bag.createManagerAccount("mike211", "MjsRas1118!", "jack", "johny", true);
        User user1 = bag.getUser("mike211",bag.getUserAccountHash());
        assertEquals("mike211", user1.emitUserName());
        assertEquals(true, user1.isAdmin());

    }

    @Test
    public void createAttendantAccount() {

        bag.createAttendantAccount("mike211", "MjsRas1118!", "jack", "johny");
        User user1 = bag.getUser("mike211",bag.getUserAccountHash());
        assertEquals("mike211", user1.emitUserName());
        assertEquals(false, user1.isAdmin());
    }

    @Test
    public void removeUser() {
        User user1 = bag.getUser("admin", bag.getUserAccountHash());

        bag.removeUser(user1);

        user1 = bag.getUser("admin", bag.getUserAccountHash());
        assertEquals(null, user1);
    }
}