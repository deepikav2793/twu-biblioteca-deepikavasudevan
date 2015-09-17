package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class LogoutMenuOptionTest {

    @Test
    public void shouldCreateNewCurrentUser() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        ConsoleOutput consoleOutput = new ConsoleOutput();
        User currentUser = new User("Guest User", "No Password", ROLE.GUEST_USER);
        LogoutMenuOption logoutMenuOption = new LogoutMenuOption(consoleOutput, currentUser);
        logoutMenuOption.executeOptionOperation();

        assertEquals("You are logged out\n", outputContent.toString());
    }
}