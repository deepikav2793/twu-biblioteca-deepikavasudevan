package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SetupTest {

    private Setup setup;

    @Before
    public void setUpsetup() {
        setup = new Setup();
    }

    @Test
    public void shouldInitialiseWelcomeMessage() {
        WelcomeMessage welcomeMessage = setup.initialiseWelcomeMessage();

        assertEquals("Hello! Welcome to Bangalore Public Library!", welcomeMessage.getWelcomeMessage());
    }

    @Test
    public void shouldCreateMovieLibraryObject() {
        assertEquals(MovieLibrary.class, setup.initialiseMovieLibraryWithMovies().getClass());
    }

    @Test
    public void shouldInitialiseMovieLibraryWithMovies() {
        MovieLibrary movieLibrary = setup.initialiseMovieLibraryWithMovies();

        assertEquals("NAME OF MOVIE\tYEAR\tDIRECTOR\tMOVIE RATING\nFunny Girl\t1968\tWilliam Wyler\t8\n" +
                "Pretty in Pink\t1986\tJohn Hughes\t10\n", movieLibrary.list());
    }
}