package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void shouldHaveSuccessfulLoginWhenLibraryNumbersOfUsersIsEqual() {
        User user = new User("xxx-xxxx", "password", "Guest");

        assertEquals("Login successful", user.authenticate("xxx-xxxx"));
    }
}