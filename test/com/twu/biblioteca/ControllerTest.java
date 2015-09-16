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
        controller.displayMenuOptions();

        assertEquals("MAIN MENU\n1. Login\n2. List Books\n3. Checkout Book\n4. Return Book\n5. List Movies\n6. Checkout Movie" +
        "\n7. List Checked Out Books with User's Library Number\n8. Logout\n9. Quit\n\n", outputContent.toString());
    }

    @Test
    public void shouldUseAFactoryToCreateConsoleInput() {
        Factory factory = mock(Factory.class);
        Controller controller = new Controller(new ArrayList<User>(), factory);

        verify(factory, times(1)).createConsoleInput();
    }

    @Test
    public void shouldUseAFactoryToCreateConsoleOutput() {
        Factory factory = mock(Factory.class);
        Controller controller = new Controller(new ArrayList<User>(), factory);

        verify(factory, times(1)).createConsoleOutput();
    }
}