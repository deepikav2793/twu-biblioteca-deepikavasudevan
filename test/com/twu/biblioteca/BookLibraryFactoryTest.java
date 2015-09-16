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

        assertEquals("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\nGone Girl\tGillian Flynn\t" +
                "2000\nThe Scarlett Letter\tNathaniel Hawthorne\t1850\n", bookLibrary.list());
    }
}