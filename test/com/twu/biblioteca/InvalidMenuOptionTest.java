package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class InvalidMenuOptionTest {

    @Test
    public void shouldPrintInvalidMessageToConsole() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));

        InvalidMenuOption invalidMenuOption = new InvalidMenuOption(new ConsoleOutput());
        invalidMenuOption.executeOptionOperation();

        assertEquals("Select a valid option!\n", outputContent.toString());
    }
}