package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BookListTest {
    private final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();

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
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        listOfBooks.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        listOfBooks.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        
        BookList bookList = new BookList(listOfBooks);
        bookList.display();

        assertEquals("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\nGone Girl\tGillian Flynn\t2000\n", outputContent.toString());
    }
}
