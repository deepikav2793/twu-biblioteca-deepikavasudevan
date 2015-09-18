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

        User currentUser = new User("GUEST USER", "NO PASSWORD", ROLE.GUEST_USER, "NO NAME", "NO EMAIL ADDRESS", 0);
        ConsoleOutput consoleOutput = new ConsoleOutput();
        NotAuthorisedMenuOption notAuthorisedMenuOption = new NotAuthorisedMenuOption(consoleOutput, currentUser);
        notAuthorisedMenuOption.executeOptionOperation();

        assertEquals("NOT AUTHORISED to use this option. Please try again.\n", outputContent.toString());
    }

    @Test
    public void shouldUseConsoleOutputToPrintTheMessage() {
        User currentUser = new User("GUEST USER", "NO PASSWORD", ROLE.GUEST_USER, "NO NAME", "NO EMAIL ADDRESS", 0);
        ConsoleOutput consoleOutput = mock(ConsoleOutput.class);
        NotAuthorisedMenuOption notAuthorisedMenuOption = new NotAuthorisedMenuOption(consoleOutput, currentUser);
        notAuthorisedMenuOption.executeOptionOperation();

        verify(consoleOutput, times(1)).display("NOT AUTHORISED to use this option. Please try again.");
    }
}