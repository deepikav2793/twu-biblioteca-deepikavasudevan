package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void shouldHaveSuccessfulLoginWhenLibraryNumberAndPasswordsAreEqual() {
        User user = new User("xxx-xxxx", "password", "Guest");

        assertEquals("Login successful", user.authenticate("xxx-xxxx", "password"));
    }

    @Test
    public void shouldHaveUnsuccessfulLoginWhenLibraryNumbersAreNotEqualAndPasswordsAreEqual() {
        User user = new User("xxx-xxxx", "password", "Guest");

        assertEquals("Login unsuccessful", user.authenticate("yyy-yyyy", "password"));
    }
}