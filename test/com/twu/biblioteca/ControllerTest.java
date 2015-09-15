package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ControllerTest {

    private ByteArrayOutputStream outputContent;
    private Controller controller;

    @Before
    public void setUpOutputContentAndController() {
        outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));

        controller = new Controller();
    }

    @Test
    public void shouldInitialiseWelcomeMessageAndDisplayIt() {
        controller.displayWelcomeMessage();

        assertEquals("Hello! Welcome to Bangalore Public Library!\n", outputContent.toString());
    }

    @Test
    public void shouldInitialiseMenuToDisplayItsOptionsAndDispatch() {
        ByteArrayInputStream inputOption = new ByteArrayInputStream("Invalid".getBytes());
        System.setIn(inputOption);

        controller.displayMenuOptionsAndDispatch();

        assertEquals("MAIN MENU\n1. List Books\n2. Checkout Book\n3. Return Book\n4. List Movies\n5. Quit\n\nSelect " +
                "a valid option!\n", outputContent.toString());
    }
}