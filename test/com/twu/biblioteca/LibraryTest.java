package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LibraryTest {
    private ByteArrayOutputStream outputContent = new ByteArrayOutputStream();

    @Before
    public void setStreamsWithInitialValue() {
        System.setOut(new PrintStream(outputContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
    }

    @Test
    public void shouldPrintListOfBooksInColumnFormat() {
        Library library = new Library();
        library.listBooks();

        assertEquals("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\nGone Girl\tGillian Flynn\t" +
                "2000\nThe Scarlett Letter\tNathaniel Hawthorne\t1850\n", outputContent.toString());
    }

    @Test
    public void shouldCheckOutTheBookSpecifiedByTheUser() {
        Library library = new Library();
        ConsoleInput consoleInput = mock(ConsoleInput.class);

        when(consoleInput.getInput()).thenReturn("Gone Girl");

        assertEquals("Thank you! Enjoy the book", library.checkOutBook(consoleInput));
    }

    @Test
    public void shouldNotHaveCheckedOutBookInUpdatedBookList() {
        ByteArrayInputStream inputBookName = new ByteArrayInputStream("Gone Girl".getBytes());
        System.setIn(inputBookName);
        Library library = new Library();
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        when(consoleInput.getInput()).thenReturn("Gone Girl");
        library.checkOutBook(consoleInput);
        library.listBooks();

        assertEquals("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\n" +
                "The Scarlett Letter\tNathaniel Hawthorne\t1850\n", outputContent.toString());
    }

    @Test
    public void shouldNotCheckOutBookSpecifiedByUserIfNotFoundInLibrary() {
        Library library = new Library();
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        library.checkOutBook(consoleInput);
        library.listBooks();

        when(consoleInput.getInput()).thenReturn("Goner Girl");

        assertEquals("That book is not available", library.checkOutBook(consoleInput));
    }

    @Test
    public void shouldReturnBookIfItHasBeenCheckedOut() {
        Library library = new Library();
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        library.checkOutBook(consoleInput);

        when(consoleInput.getInput()).thenReturn("Gone Girl");

        assertEquals("Thank you for returning the book", library.returnBook(consoleInput));
    }
}
