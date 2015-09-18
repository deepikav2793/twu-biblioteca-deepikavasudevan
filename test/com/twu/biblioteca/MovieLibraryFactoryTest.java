package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieLibraryFactoryTest {

    @Test
    public void shouldCreateAnObjectOfTypeMovieFactory() {
        MovieLibraryFactory movieLibraryFactory = new MovieLibraryFactory();

        assertEquals(MovieLibrary.class, movieLibraryFactory.createMovieLibrary().getClass());
    }

    @Test
    public void shouldInitialiseMovieLibraryWithMovies() {
        MovieLibraryFactory movieLibraryFactory = new MovieLibraryFactory();

        MovieLibrary movieLibrary = movieLibraryFactory.createMovieLibrary();
        String formattedMovieString = String.format("%-30s%-15s%-30s%-15s\n", "NAME OF MOVIE", "YEAR", "DIRECTOR", "MOVIE RATING") +
                String.format("%-30s%-15s%-30s%-15s\n", "Funny Girl", 1968, "William Wyler", "8") +
                String.format("%-30s%-15s%-30s%-15s\n", "Pretty in Pink", 1986, "John Hughes", "10");

        assertEquals(formattedMovieString, movieLibrary.list());
    }
}