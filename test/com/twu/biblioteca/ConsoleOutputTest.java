package com.twu.biblioteca;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ConsoleOutputTest {

    @Test
    public void shouldDisplayOutputToConsole() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        ConsoleOutput consoleOutput = new ConsoleOutput();

        consoleOutput.display("Printing a string");

        assertEquals("Printing a string\n", outputContent.toString());
    }
}