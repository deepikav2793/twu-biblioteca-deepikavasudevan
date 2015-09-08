package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

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

        assertEquals("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\nGone Girl\tGillian Flynn\t2000\n", outputContent.toString());
    }

    @Test
    public void shouldCheckOutTheBookSpecifiedByTheUser() {
        Library library = new Library();

        assertEquals("Thank you! Enjoy the book", library.checkOut(new Book("Gone Girl", "", 0)));
    }

    @Test
    public void shouldNotHaveCheckedOutBookInUpdatedBookList() {
        ByteArrayInputStream inputBookName = new ByteArrayInputStream("Gone Girl".getBytes());
        System.setIn(inputBookName);

        Library library = new Library();
        library.checkOut(new Book("Gone Girl", "", 0));
        library.listBooks();

        assertEquals("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\n", outputContent.toString());
    }
}
