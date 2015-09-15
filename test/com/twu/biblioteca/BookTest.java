package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BookTest {

    private Book book;

    @Before
    public void setUpBook() {
        book = new Book("Gone Girl", "Gillian Flynn", 2000);
    }

    @Test
    public void shouldFormatItsDetailsInAColumnFormat() {
        assertEquals(book.toString(), "Gone Girl\tGillian Flynn\t2000");
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertNotEquals(book, null);
    }

    @Test
    public void shouldBeOfTypeBook() {
        assertEquals(book.getClass(), book.getClass());
    }

    @Test
    public void shouldBeEqualToItself() {
        assertEquals(book, book);
    }

    @Test
    public void shouldBeEqualToItselfIfItHasTheSameName() {
        Book book2 = new Book("Gone Girl", "", 0);

        assertEquals(book, book2);
    }

    @Test
    public void shouldNotBeEqualToItselfIfItDoesntHaveTheSameName() {
        Book book2 = new Book("Gone", "", 0);

        assertNotEquals(book, book2);
    }

    @Test
    public void shouldHaveTheSameHashCodeIfItIsTheSameReference() {
        assertEquals(book.hashCode(), book.hashCode());
    }

    @Test
    public void shouldNotHaveTheSameHashCodeIfItIsNotTheSameReference() {
        Book book2 = new Book("Emma", "Jane Austen", 1967);

        assertNotEquals(book.hashCode(), book2.hashCode());
    }
}