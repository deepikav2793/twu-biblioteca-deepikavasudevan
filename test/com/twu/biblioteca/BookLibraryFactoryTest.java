package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookLibraryFactoryTest {

    @Test
    public void shouldCreateABookLibrary() {
        BookLibraryFactory bookLibraryFactory = new BookLibraryFactory();

        assertEquals(BookLibrary.class, bookLibraryFactory.createBookLibrary().getClass());
    }

    @Test
    public void shouldInitialiseLibraryWithBooks() {
        BookLibraryFactory bookLibraryFactory = new BookLibraryFactory();
        BookLibrary bookLibrary = bookLibraryFactory.createBookLibrary();
        String formattedListOfBooks = String.format("%-30s%-30s%-15s\n", "NAME OF BOOK", "NAME OF AUTHOR", "YEAR OF PUBLICATION")
                + String.format("%-30s%-30s%-15s\n", "To Kill A Mockingbird", "Harper Lee", 1968)
                + String.format("%-30s%-30s%-15s\n", "Gone Girl", "Gillian Flynn", 2000)
                + String.format("%-30s%-30s%-15s\n", "The Scarlett Letter", "Nathaniel Hawthorne", 1850);

        assertEquals(formattedListOfBooks, bookLibrary.list());
    }
}