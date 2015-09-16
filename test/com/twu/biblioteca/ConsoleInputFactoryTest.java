package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConsoleInputFactoryTest {

    @Test
    public void shouldCreateAConsoleInputObject() {
        ConsoleInputFactory consoleInputFactory = new ConsoleInputFactory();

        assertEquals(ConsoleInput.class, consoleInputFactory.createConsoleInput().getClass());
    }
}