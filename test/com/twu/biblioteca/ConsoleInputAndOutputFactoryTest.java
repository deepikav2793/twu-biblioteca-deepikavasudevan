package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConsoleInputAndOutputFactoryTest {

    @Test
    public void shouldCreateAConsoleInputObject() {
        ConsoleInputAndOutputFactory consoleInputAndOutputFactory = new ConsoleInputAndOutputFactory();

        assertEquals(ConsoleInput.class, consoleInputAndOutputFactory.createConsoleInput().getClass());
    }

    @Test
    public void shouldCreateAConsoleOutputObject() {
        ConsoleInputAndOutputFactory consoleInputAndOutputFactory = new ConsoleInputAndOutputFactory();

        assertEquals(ConsoleOutput.class, consoleInputAndOutputFactory.createConsoleOutput().getClass());
    }
}