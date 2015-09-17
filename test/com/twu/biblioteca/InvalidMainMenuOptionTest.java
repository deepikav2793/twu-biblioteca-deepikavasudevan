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

        InvalidMenuOption invalidMenuOption = new InvalidMenuOption(new ConsoleOutput());
        invalidMenuOption.executeOptionOperation();

        assertEquals("Select a valid option!\n", outputContent.toString());
    }

    @Test
    public void shouldUseConsoleOutputToPrintTheMessage() {
        ConsoleOutput consoleOutput = mock(ConsoleOutput.class);
        InvalidMenuOption invalidMenuOption = new InvalidMenuOption(consoleOutput);
        invalidMenuOption.executeOptionOperation();
        verify(consoleOutput, times(1)).display("Select a valid option!");
    }
}