package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class NotAuthorisedMenuOptionTest {

    @Test
    public void shouldPrintAnUnauthorisedMessage() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));

        User currentUser = new User("Guest User","No Password",ROLE.GUEST_USER);
        ConsoleOutput consoleOutput = new ConsoleOutput();
        NotAuthorisedMenuOption notAuthorisedMenuOption = new NotAuthorisedMenuOption(consoleOutput, currentUser);
        notAuthorisedMenuOption.executeOptionOperation();

        assertEquals("NOT AUTHORISED to access this option. Please log in.\n", outputContent.toString());
    }
}