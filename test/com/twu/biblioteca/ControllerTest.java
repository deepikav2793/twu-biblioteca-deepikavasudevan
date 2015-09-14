package com.twu.biblioteca;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

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

        assertEquals("MAIN MENU\n1. List Books\n2. Checkout Book\n3. Return Book\n4. Quit\n\n", outputContent.toString());
    }

    @Test
    public void shouldInitialiseMenuDispatcher() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        ConsoleInput consoleInput = mock(ConsoleInput.class);

        when(consoleInput.getInput()).thenReturn("Invalid");

        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));
        Library library = new Library(availableBookList, checkedOutBookList);
        Controller controller = new Controller();
        controller.initialiseMenuDispatch(library, consoleInput);

        assertEquals("Select a valid option!\n", outputContent.toString());
    }

    @Test
    public void shouldInitialiseLibraryWithBooks() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));

        Controller controller = new Controller();
        Library library = controller.initialiseLibraryWithBooks();

        assertEquals("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\nGone Girl\tGillian Flynn\t" +
                "2000\nThe Scarlett Letter\tNathaniel Hawthorne\t1850\n", library.listOfBooks());
    }
}