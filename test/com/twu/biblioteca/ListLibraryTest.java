package com.twu.biblioteca;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ListLibraryTest {

    @Test
    public void shouldPrintAListOfBooksIfLibraryIsBookLibrary() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        BookLibrary bookLibrary = mock(BookLibrary.class);
        when(bookLibrary.list()).thenReturn("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\n" +
                "The Scarlett Letter\tNathaniel Hawthorne\t1850\nGone Girl\tGillian Flynn\t2000\n");
        ConsoleOutput consoleOutput = new ConsoleOutput();
        ListLibrary listLibrary = new ListLibrary(bookLibrary, consoleOutput);
        listLibrary.displayList();
        assertEquals("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\n" +
                "The Scarlett Letter\tNathaniel Hawthorne\t1850\nGone Girl\tGillian Flynn\t2000\n\n", outputContent.toString());
    }

    @Test
    public void shouldUseBookLibrarysListingToListBooks() {
        BookLibrary bookLibrary = mock(BookLibrary.class);
        ListLibrary listLibrary = new ListLibrary(bookLibrary, new ConsoleOutput());
        listLibrary.displayList();

        verify(bookLibrary, times(1)).list();
    }

    @Test
    public void shouldPrintAListOfMoviesIfLibraryIsMovieLibrary() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        when(movieLibrary.list()).thenReturn("NAME OF MOVIE\tYEAR\tDIRECTOR\tMOVIE RATING\n" +
                "Funny Girl\t1968\tWilliam Wyler\t8\nPretty in Pink\t1986\tJohn Hughes\t10\n");
        ConsoleOutput consoleOutput = new ConsoleOutput();
        ListLibrary listLibrary = new ListLibrary(movieLibrary, consoleOutput);
        listLibrary.displayList();
        assertEquals("NAME OF MOVIE\tYEAR\tDIRECTOR\tMOVIE RATING\n" +
                "Funny Girl\t1968\tWilliam Wyler\t8\nPretty in Pink\t1986\tJohn Hughes\t10\n\n", outputContent.toString());
    }

    @Test
    public void shouldUseMovieLibrarysListingToListBooks() {
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        ListLibrary listLibrary = new ListLibrary(movieLibrary, new ConsoleOutput());
        listLibrary.displayList();

        verify(movieLibrary, times(1)).list();
    }
}