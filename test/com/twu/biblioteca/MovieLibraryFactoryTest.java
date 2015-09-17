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

        assertEquals("NAME OF MOVIE\tYEAR\tDIRECTOR\tMOVIE RATING\nFunny Girl\t1968\tWilliam Wyler\t8\n" +
                "Pretty in Pink\t1986\tJohn Hughes\t10\n", movieLibrary.list());
    }
}