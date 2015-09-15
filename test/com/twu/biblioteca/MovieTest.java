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

    @Test
    public void shouldBeEqualToAMovieOfTheSameName() {
        Movie movie1 = new Movie("Funny Girl", 1968, "William Wyler", "8");
        Movie movie2 = new Movie("Funny Girl", 0, "", "");

        assertEquals(movie1, movie2);
    }

    @Test
    public void shouldNotBeEqualToAMovieOfTheSameName() {
        Movie movie1 = new Movie("Funny Girl", 1968, "William Wyler", "8");
        Movie movie2 = new Movie("Funny", 1968, "Willian Wyler", "8");

        assertNotEquals(movie1, movie2);
    }

    @Test
    public void shouldHaveTheSameHashCodeIfItIsTheSameReference() {
        Movie movie = new Movie("Funny Girl", 1968, "William Wyler", "8");

        assertEquals(movie.hashCode(), movie.hashCode());
    }

    @Test
    public void shouldNotHaveTheSameHashCodeIfItIsNotTheSameReference() {
        Movie movie1 = new Movie("Funny Girl", 1968, "William Wyler", "8");
        Movie movie2 = new Movie("Pretty in Pink", 1967, "John Hughes","10");

        assertNotEquals(movie1.hashCode(), movie2.hashCode());
    }
}