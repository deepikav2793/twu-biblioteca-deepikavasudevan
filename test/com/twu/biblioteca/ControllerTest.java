package com.twu.biblioteca;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControllerTest {

    @Test
    public void shouldInitialiseWelcomeMessageAndDisplayIt() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));

        Controller controller = new Controller();
        controller.displayWelcomeMessage();

        assertEquals("Hello! Welcome to Bangalore Public Library!\n", outputContent.toString());
    }

    @Test
    public void shouldDisplayMenuOptions() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));

        Controller controller = new Controller();
        controller.displayMenuOptions();

        assertEquals("MAIN MENU\n1. List Books\n2. Check Out\nQuit\n", outputContent.toString());
    }

    @Test
    public void shouldInitialiseMenuDispatcher() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        ConsoleInput consoleInput = mock(ConsoleInput.class);

        when(consoleInput.getInput()).thenReturn("Invalid");

        Library library = new Library();
        Controller controller = new Controller();
        controller.initialiseMenuDispatch(library, consoleInput);

        assertEquals("Select a valid option!\n", outputContent.toString());
    }
}
