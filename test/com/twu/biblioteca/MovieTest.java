package com.twu.biblioteca;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void shouldFormatItsDetailsInColumnFormat() {
        Movie movie = new Movie("Funny Girl", 1968, "William Wyler", "8");

        assertEquals("Funny Girl\t1968\tWilliam Wyler\t8",movie.toString());
    }

    @Test
    public void shouldNotBeEqualToNull() {
        Movie movie = new Movie("Funny Girl", 1968, "William Wyler", "8");

        assertFalse(movie.equals(null));
    }
}