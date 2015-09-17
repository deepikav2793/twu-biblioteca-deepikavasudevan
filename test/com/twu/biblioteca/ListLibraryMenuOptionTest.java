package com.twu.biblioteca;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ListLibraryMenuOptionTest {

    @Test
    public void shouldPrintAListOfBooksIfLibraryIsBookLibrary() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        BookLibrary bookLibrary = mock(BookLibrary.class);
        when(bookLibrary.list()).thenReturn("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\n" +
                "The Scarlett Letter\tNathaniel Hawthorne\t1850\nGone Girl\tGillian Flynn\t2000\n");
        ConsoleOutput consoleOutput = new ConsoleOutput();
        ListLibraryMenuOption listLibraryMenuOption = new ListLibraryMenuOption(bookLibrary, consoleOutput);
        listLibraryMenuOption.executeOptionOperation();
        assertEquals("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\n" +
                "The Scarlett Letter\tNathaniel Hawthorne\t1850\nGone Girl\tGillian Flynn\t2000\n\n", outputContent.toString());
    }

    @Test
    public void shouldUseBookLibrarysListingToListBooks() {
        BookLibrary bookLibrary = mock(BookLibrary.class);
        ListLibraryMenuOption listLibraryMenuOption = new ListLibraryMenuOption(bookLibrary, new ConsoleOutput());
        listLibraryMenuOption.executeOptionOperation();

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
        ListLibraryMenuOption listLibraryMenuOption = new ListLibraryMenuOption(movieLibrary, consoleOutput);
        listLibraryMenuOption.executeOptionOperation();
        assertEquals("NAME OF MOVIE\tYEAR\tDIRECTOR\tMOVIE RATING\n" +
                "Funny Girl\t1968\tWilliam Wyler\t8\nPretty in Pink\t1986\tJohn Hughes\t10\n\n", outputContent.toString());
    }

    @Test
    public void shouldUseMovieLibrarysListingToListBooks() {
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        ListLibraryMenuOption listLibraryMenuOption = new ListLibraryMenuOption(movieLibrary, new ConsoleOutput());
        listLibraryMenuOption.executeOptionOperation();

        verify(movieLibrary, times(1)).list();
    }

    @Test
    public void shouldUseConsoleOutputToPrintList(){
        BookLibrary bookLibrary = mock(BookLibrary.class);
        when(bookLibrary.list()).thenReturn("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\n" +
                "The Scarlett Letter\tNathaniel Hawthorne\t1850\nGone Girl\tGillian Flynn\t2000\n");
        ConsoleOutput consoleOutput = mock(ConsoleOutput.class);
        ListLibraryMenuOption listLibraryMenuOption = new ListLibraryMenuOption(bookLibrary, consoleOutput);
        listLibraryMenuOption.executeOptionOperation();

        verify(consoleOutput, times(1)).display("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\n" +
                        "The Scarlett Letter\tNathaniel Hawthorne\t1850\nGone Girl\tGillian Flynn\t2000\n");
    }
}