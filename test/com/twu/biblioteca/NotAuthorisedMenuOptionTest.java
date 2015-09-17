package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

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

    @Test
    public void shouldUseConsoleOutputToPrintTheMessage() {
        User currentUser = new User("Guest User","No Password",ROLE.GUEST_USER);
        ConsoleOutput consoleOutput = mock(ConsoleOutput.class);
        NotAuthorisedMenuOption notAuthorisedMenuOption = new NotAuthorisedMenuOption(consoleOutput, currentUser);
        notAuthorisedMenuOption.executeOptionOperation();

        verify(consoleOutput, times(1)).display("NOT AUTHORISED to access this option. Please log in.");
    }
}