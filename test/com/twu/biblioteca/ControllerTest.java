package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ControllerTest {

    @Test
    public void shouldInitialiseWelcomeMessageAndDisplayIt() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));

        Controller controller = new Controller();
        controller.displayWelcomeMessage();

        assertEquals("Hello! Welcome to Bangalore Public Library!\n", outputContent.toString());
    }
}
