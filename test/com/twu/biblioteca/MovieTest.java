package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MovieTest {

    private Movie movie;

    @Before
    public void setUpMovie() {
        movie = new Movie("Funny Girl", 1968, "William Wyler", "8");
    }

    @Test
    public void shouldFormatItsDetailsInColumnFormat() {
        assertEquals(String.format("%-30s%-15s%-30s%-15s\n", "Funny Girl", 1968, "William Wyler", "8"), movie.toString());
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertNotEquals(movie, null);
    }

    @Test
    public void shouldBeOfTypeMovie() {
        assertNotEquals(movie, "This is not a valid object");
    }

    @Test
    public void shouldBeEqualToItself() {
        assertEquals(movie, movie);
    }

    @Test
    public void shouldBeEqualToAMovieOfTheSameName() {
        Movie movie2 = new Movie("Funny Girl", 0, "", "");

        assertEquals(movie, movie2);
    }

    @Test
    public void shouldNotBeEqualToAMovieOfTheSameName() {
        Movie movie2 = new Movie("Funny", 1968, "Willian Wyler", "8");

        assertNotEquals(movie, movie2);
    }

    @Test
    public void shouldHaveTheSameHashCodeIfItIsTheSameReference() {
        Movie movie = new Movie("Funny Girl", 1968, "William Wyler", "8");

        assertEquals(movie.hashCode(), movie.hashCode());
    }

    @Test
    public void shouldNotHaveTheSameHashCodeIfItIsNotTheSameReference() {
        Movie movie2 = new Movie("Pretty in Pink", 1967, "John Hughes", "10");

        assertNotEquals(movie.hashCode(), movie2.hashCode());
    }
}