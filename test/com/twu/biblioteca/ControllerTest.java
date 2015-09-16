package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ControllerTest {

    private ByteArrayOutputStream outputContent;

    @Before
    public void setOutputContent() {
        outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
    }

    @Test
    public void shouldInitialiseWelcomeMessageAndDisplayIt() {
        Controller controller = new Controller(new ArrayList<User>(), new Factory());
        controller.displayWelcomeMessage();

        assertEquals("Hello! Welcome to Bangalore Public Library!\n", outputContent.toString());
    }

    @Test
    public void shouldInitialiseMenuToDisplayItsOptionsAndDispatch() {
        ByteArrayInputStream inputOption = new ByteArrayInputStream("Invalid".getBytes());
        System.setIn(inputOption);

        Controller controller = new Controller(new ArrayList<User>(), new Factory());
        controller.displayMenuOptionsAndDispatch();

        assertEquals("MAIN MENU\n1. List Books\n2. Checkout Book\n3. Return Book\n4. List Movies\n5. Quit\n\nSelect " +
                "a valid option!\n", outputContent.toString());
    }

    @Test
    public void shouldUseAFactoryToCreateConsoleInput() {
        Factory factory = mock(Factory.class);
        Controller controller = new Controller(new ArrayList<User>(), factory);

        verify(factory, times(1)).createConsoleInput();
    }
}