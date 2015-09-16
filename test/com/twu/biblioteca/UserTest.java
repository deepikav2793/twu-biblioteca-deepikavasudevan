package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void shouldReturnSuccessfulAuthenticationIfLoginIsSuccessful() {
        User user = new User("xxx-xxxx", "duh", "Guest");

        assertEquals("Login successful", user.authenticate());
    }
}