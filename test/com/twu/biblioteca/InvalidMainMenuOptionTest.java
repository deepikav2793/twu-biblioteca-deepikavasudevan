package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class InvalidMainMenuOptionTest {

    @Test
    public void shouldPrintInvalidMessageToConsole() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        User currentUser = new User("Guest User","No Password",ROLE.GUEST_USER);
        InvalidMenuOption invalidMenuOption = new InvalidMenuOption(new ConsoleOutput(), currentUser);
        invalidMenuOption.executeOptionOperation();

        assertEquals("Select a valid option!\n", outputContent.toString());
    }

    @Test
    public void shouldUseConsoleOutputToPrintTheMessage() {
        ConsoleOutput consoleOutput = mock(ConsoleOutput.class);
        User currentUser = new User("Guest User","No Password",ROLE.GUEST_USER);
        InvalidMenuOption invalidMenuOption = new InvalidMenuOption(consoleOutput, currentUser);
        invalidMenuOption.executeOptionOperation();
        verify(consoleOutput, times(1)).display("Select a valid option!");
    }
}