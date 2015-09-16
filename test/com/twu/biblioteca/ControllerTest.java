package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

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

    @Test
    public void shouldUseConsoleInputWhileTakingMenuOptionsAsInputFromConsole() {
        ByteArrayInputStream inputOneOption = new ByteArrayInputStream("1".getBytes());
        System.setIn(inputOneOption);
        Factory factory = mock(Factory.class);
        when(factory.createConsoleInput()).thenReturn(new ConsoleInput());
        Controller controller = new Controller(new ArrayList<User>(), factory);

        assertEquals("1", controller.menuOptionsInput());
    }

    @Test
    public void shouldDisplayInvalidMessageWhenInvalidOptionIsEntered() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        Factory factory = mock(Factory.class);

        when(factory.createConsoleOutput()).thenReturn(new ConsoleOutput());
        Controller controller = new Controller(new ArrayList<User>(), factory);
        controller.dispatchMenuOption("Invalid");

        assertEquals("Select a valid option!\n", outputContent.toString());
    }

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldQuitTheApplicationWhenMenuOptionOfNineIsEntered() {
        exit.expectSystemExitWithStatus(0);
        Factory factory = mock(Factory.class);
        Controller controller = new Controller(new ArrayList<User>(), factory);
        controller.dispatchMenuOption("9");
    }

    @Test
    public void shouldCheckOutAMovieFromMovieLibraryWhenMenuOptionOfSixIsEntered() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        Factory factory = mock(Factory.class);
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        when(factory.createConsoleOutput()).thenReturn(new ConsoleOutput());
        when(factory.createConsoleInput()).thenReturn(consoleInput);
        when(consoleInput.getInput()).thenReturn("Funny Girl");

        Controller controller = new Controller(new ArrayList<User>(), factory);
        controller.dispatchMenuOption("6");

        assertEquals("Enter movie to be checked out:\nThank you! Enjoy the movie\n", outputContent.toString());
    }


    @Test
    public void shouldListMoviesFromMovieLibraryWhenMovieOptionOfFiveIsEntered() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        Factory factory = mock(Factory.class);
        when(factory.createConsoleOutput()).thenReturn(new ConsoleOutput());
        Controller controller = new Controller(new ArrayList<User>(), factory);
        controller.dispatchMenuOption("5");

        assertEquals("NAME OF MOVIE\tYEAR\tDIRECTOR\tMOVIE RATING\nFunny Girl\t1968\tWilliam Wyler\t8\n" +
                "Pretty in Pink\t1986\tJohn Hughes\t10\n\n", outputContent.toString());
    }

    @Test
    public void shouldCheckOutABookFromLibraryWhenBookOptionOfThreeIsEntered() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        Factory factory = mock(Factory.class);
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        when(factory.createConsoleOutput()).thenReturn(new ConsoleOutput());
        when(factory.createConsoleInput()).thenReturn(consoleInput);
        when(consoleInput.getInput()).thenReturn("Gone Girl");

        Controller controller = new Controller(new ArrayList<User>(), factory);
        controller.dispatchMenuOption("3");

        assertEquals("Enter book to be checked out:\nThank you! Enjoy the book\n", outputContent.toString());
    }

    @Test
    public void shouldListBooksFromBookLibraryWhenMovieOptionOfTwoIsEntered() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        Factory factory = mock(Factory.class);
        when(factory.createConsoleOutput()).thenReturn(new ConsoleOutput());
        Controller controller = new Controller(new ArrayList<User>(), factory);
        controller.dispatchMenuOption("2");

        assertEquals("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\nGone Girl\tGillian Flynn" +
                "\t2000\nThe Scarlett Letter\tNathaniel Hawthorne\t1850\n\n", outputContent.toString());
    }
}