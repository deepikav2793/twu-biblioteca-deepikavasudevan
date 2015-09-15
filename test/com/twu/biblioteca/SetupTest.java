package com.twu.biblioteca;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class SetupTest {

    @Test
    public void shouldInitialiseWelcomeMessage() {
        Setup setup = new Setup();
        WelcomeMessage welcomeMessage = setup.initialiseWelcomeMessage();

        assertEquals("Hello! Welcome to Bangalore Public Library!", welcomeMessage.getWelcomeMessage());
    }

    @Test
    public void shouldInitialiseLibraryWithBooks() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));

        Setup setup = new Setup();
        BookLibrary bookLibrary = setup.initialiseLibraryWithBooks();

        assertEquals("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\nGone Girl\tGillian Flynn\t" +
                "2000\nThe Scarlett Letter\tNathaniel Hawthorne\t1850\n", bookLibrary.listOfBooks());
    }

    @Test
    public void shouldInitialiseMenuOptions() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));

        Setup setup = new Setup();
        MainMenu menu = setup.initialiseMainMenuWithOptions();

        assertEquals("MAIN MENU\n1. List Books\n2. Checkout Book\n3. Return Book\n4. List Movies\n5. Quit\n", menu.mainMenuOptions());
    }

    @Test
    public void shouldInitialiseMovieLibraryWithMovies() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));

        Setup setup = new Setup();

        MovieLibrary movieLibrary = setup.initialiseMovieLibraryWithMovies();

        assertEquals("NAME OF MOVIE\tYEAR\tDIRECTOR\tMOVIE RATING\nFunny Girl\t1968\tWilliam Wyler\t8\n" +
                "Pretty in Pink\t1986\tJohn Hughes\t10\n", movieLibrary.listOfMovies());
    }
}