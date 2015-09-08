package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BookTest {

    @Test
    public void shouldFormatItsDetailsInAColumnFormat() {
        Book book = new Book("To Kill A Mockingbird", "Harper Lee", 1968);

        assertEquals(book.toString(), "To Kill A Mockingbird\tHarper Lee\t1968");
    }

    @Test
    public void shouldNotBeEqualToNull() {
        Book book = new Book("Gone Girl", "Gillian Flynn", 2000);

        assertNotEquals(book, null);
    }

    @Test
    public void shouldBeOfTypeBook() {
        Book book = new Book("Gone Girl", "Gillian Flynn", 2000);

        assertEquals(book.getClass(), book.getClass());
    }

    @Test
    public void shouldBeEqualToItself() {
        Book book = new Book("Gone Girl", "Gillian Flynn", 2000);

        assertEquals(book, book);
    }

    @Test
    public void shouldBeEqualToItselfIfItHasTheSameName() {
        Book book1 = new Book("Gone Girl", "Gillian Flynn", 2000);
        Book book2 = new Book("Gone Girl", "", 0);

        assertEquals(book1, book2);
    }

    @Test
    public void shouldNotBeEqualToItselfIfItDoesntHaveTheSameName() {
        Book book1 = new Book("Gone Girl", "Gillian Flynn", 2000);
        Book book2 = new Book("Gone", "", 0);

        assertNotEquals(book1, book2);
    }

    @Test
    public void shouldHaveTheSameHashCodeIfItIsTheSameReference() {
        Book book = new Book("Gone Girl", "Gillian Flynn", 2000);

        assertEquals(book.hashCode(), book.hashCode());
    }

    @Test
    public void shouldNotHaveTheSameHashCodeIfItIsNotTheSameReference() {
        Book book1 = new Book("Gone Girl", "Gillian Flynn", 2000);
        Book book2 = new Book("Emma", "Jane Austen", 1967);

        assertNotEquals(book1.hashCode(), book2.hashCode());
    }
}
