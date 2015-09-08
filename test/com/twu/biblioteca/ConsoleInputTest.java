package com.twu.biblioteca;

import org.junit.Test;
import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class ConsoleInputTest {

    @Test
    public void shouldTakeAnInputFromConsole() {
        ByteArrayInputStream inputContent = new ByteArrayInputStream("1".getBytes());
        System.setIn(inputContent);
        ConsoleInput input = new ConsoleInput();
        assertEquals("1", input.getInput());
    }
}