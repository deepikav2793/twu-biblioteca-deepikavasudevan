package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void shouldFormatItsDetailsInAColumnFormat() {
        Book book = new Book("To Kill A Mockingbird", "Harper Lee", 1968);

        assertEquals(book.toString(), "To Kill A Mockingbird\tHarper Lee\t1968");
    }
}
