package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FactoryTest {

    @Test
    public void shouldCreateAConsoleInputObject() {
        Factory factory = new Factory();

        assertEquals(ConsoleInput.class, factory.createConsoleInput().getClass());
    }

    @Test
    public void shouldCreateAConsoleOutputObject() {
        Factory factory = new Factory();

        assertEquals(ConsoleOutput.class, factory.createConsoleOutput().getClass());
    }
}