package com.twu.biblioteca;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserTest {

    @Test
    public void shouldHaveSuccessfulLoginWhenLibraryNumberAndPasswordsAreEqual() {
        User user = new User("xxx-xxxx", "password", ROLE.GUEST_USER);

        assertTrue(user.authenticate("xxx-xxxx", "password"));
    }

    @Test
    public void shouldHaveUnsuccessfulLoginWhenLibraryNumbersAreNotEqualAndPasswordsAreEqual() {
        User user = new User("xxx-xxxx", "password", ROLE.GUEST_USER);

        assertFalse(user.authenticate("yyy-yyyy", "password"));
    }

    @Test
    public void shouldHaveUnsuccessfulLoginWhenLibraryNumbersAreEqualAndPasswordsAreEqual() {
        User user = new User("xxx-xxxx", "password", ROLE.GUEST_USER);

        assertFalse(user.authenticate("xxx-xxxx", "pass"));
    }

    @Test
    public void shouldHaveUnsuccessfulLoginWhenLibraryNumbersAreNotEqualAndPasswordsAreNotEqual() {
        User user = new User("xxx-xxxx", "password", ROLE.GUEST_USER);

        assertFalse(user.authenticate("yyy-yyyy", "pass"));
    }
}