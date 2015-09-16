package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void shouldHaveSuccessfulLoginWhenLibraryNumberAndPasswordsAreEqual() {
        User user = new User("xxx-xxxx", "password", "GUEST");

        assertEquals("Login successful", user.authenticate("xxx-xxxx", "password"));
    }

    @Test
    public void shouldHaveUnsuccessfulLoginWhenLibraryNumbersAreNotEqualAndPasswordsAreEqual() {
        User user = new User("xxx-xxxx", "password", "GUEST");

        assertEquals("Login unsuccessful", user.authenticate("yyy-yyyy", "password"));
    }

    @Test
    public void shouldHaveUnsuccessfulLoginWhenLibraryNumbersAreEqualAndPasswordsAreEqual() {
        User user = new User("xxx-xxxx", "password", "GUEST");

        assertEquals("Login unsuccessful", user.authenticate("xxx-xxxx", "pass"));
    }

    @Test
    public void shouldHaveUnsuccessfulLoginWhenLibraryNumbersAreNotEqualAndPasswordsAreNotEqual() {
        User user = new User("xxx-xxxx", "password", "GUEST");

        assertEquals("Login unsuccessful", user.authenticate("yyy-yyyy", "pass"));
    }
}