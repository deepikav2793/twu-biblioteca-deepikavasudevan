package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MovieTest {

    @Test
    public void shouldFormatItsDetailsInColumnFormat() {
        Movie movie = new Movie("Funny Girl", 1968, "William Wyler", "8");

        assertEquals("Funny Girl\t1968\tWilliam Wyler\t8",movie.toString());
    }

    @Test
    public void shouldNotBeEqualToNull() {
        Movie movie = new Movie("Funny Girl", 1968, "William Wyler", "8");

        assertNotEquals(movie, null);
    }

    @Test
    public void shouldBeOfTypeMovie() {
        Movie movie = new Movie("Funny Girl", 1968, "William Wyler", "8");

        assertEquals(movie.getClass(), movie.getClass());
    }

    @Test
    public void shouldBeEqualToItself() {
        Movie movie = new Movie("Funny Girl", 1968, "William Wyler", "8");

        assertEquals(movie, movie);
    }
}