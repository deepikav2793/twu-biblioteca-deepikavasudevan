package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

public class MainMenuTest {

    private ByteArrayOutputStream outputContent;
    private MainMenu mainMenu;
    private ConsoleInput consoleInput;

    @Before
    public void setStreamsWithInitialValue() {
        outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        ArrayList<String> menuOptions = new ArrayList<>(Arrays.asList("1. List Books", "2. Checkout Book", "3. Return Book",
                "4. List Movies", "5. Checkout Movie", "6. Quit"));
        consoleInput = mock(ConsoleInput.class);
        ConsoleOutput consoleOutput = new ConsoleOutput();
        mainMenu = new MainMenu(menuOptions, consoleInput, consoleOutput);

    }

    @Test
    public void shouldDisplayListOfOptionsInMainMenu() {
        assertEquals("MAIN MENU\n1. List Books\n2. Checkout Book\n3. Return Book\n4. List Movies\n5. Checkout Movie\n" +
                "6. Quit\n", mainMenu.mainMenuOptions());
    }


    @Test
    public void shouldListBooksWhenOptionWhenOptionTwoIsEntered() {
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));
        BookLibrary bookLibrary = new BookLibrary(availableBookList, checkedOutBookList);
        ArrayList<Movie> movieList = new ArrayList<>();
        MovieLibrary movieLibrary = new MovieLibrary(movieList);

        mainMenu.dispatch(bookLibrary, movieLibrary, "2");

        assertEquals("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\nGone Girl\tGillian Flynn" +
                "\t2000\nThe Scarlett Letter\tNathaniel Hawthorne\t1850\n\n", outputContent.toString());
    }

    @Test
    public void shouldGiveAppropriateMessageWhenInvalidOptionIsEntered() {
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));
        BookLibrary bookLibrary = new BookLibrary(availableBookList, checkedOutBookList);
        ArrayList<Movie> movieList = new ArrayList<>();
        MovieLibrary movieLibrary = new MovieLibrary(movieList);

        mainMenu.dispatch(bookLibrary, movieLibrary, "Invalid");

        assertEquals("Select a valid option!\n", outputContent.toString());
    }

    @Test
    public void shouldChooseCheckOutBookOptionWhenOptionThreeIsEntered() {
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));
        BookLibrary bookLibrary = new BookLibrary(availableBookList, checkedOutBookList);
        ArrayList<Movie> movieList = new ArrayList<>();
        MovieLibrary movieLibrary = new MovieLibrary(movieList);

        when(consoleInput.getInput()).thenReturn("Gone Girl");
        mainMenu.dispatch(bookLibrary, movieLibrary, "3");

        assertEquals("Enter book to be checked out:\nThank you! Enjoy the book\n", outputContent.toString());
    }

    @Test
    public void shouldChooseReturnBookOptionWhenOptionFourIsEntered() {
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));
        BookLibrary bookLibrary = new BookLibrary(availableBookList, checkedOutBookList);
        ArrayList<Movie> movieList = new ArrayList<>();
        MovieLibrary movieLibrary = new MovieLibrary(movieList);

        when(consoleInput.getInput()).thenReturn("Gone Girl");
        mainMenu.dispatch(bookLibrary, movieLibrary, "4");

        assertEquals("Enter book to be returned:\nThat is not a valid book to return\n", outputContent.toString());
    }

    @Test
    public void shouldChooseListMoviesOptionWhenOptionFiveIsEntered() {
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        BookLibrary bookLibrary = new BookLibrary(availableBookList, checkedOutBookList);
        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Funny Girl", 1968, "William Wyler", "8"));
        movieList.add(new Movie("Pretty in Pink", 1986, "John Hughes", "10"));
        MovieLibrary movieLibrary = new MovieLibrary(movieList);

        mainMenu.dispatch(bookLibrary, movieLibrary, "5");

        assertEquals("NAME OF MOVIE\tYEAR\tDIRECTOR\tMOVIE RATING\nFunny Girl\t1968\tWilliam Wyler\t8\n" +
                "Pretty in Pink\t1986\tJohn Hughes\t10\n\n", outputContent.toString());
    }

    @Test
    public void shouldChooseCheckOutMovieOptionWhenOptionSixIsEntered() {
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        BookLibrary bookLibrary = new BookLibrary(availableBookList, checkedOutBookList);
        ArrayList<Movie> movieList = new ArrayList<>();
        MovieLibrary movieLibrary = new MovieLibrary(movieList);
        movieList.add(new Movie("Funny Girl", 1968, "William Wyler", "8"));
        movieList.add(new Movie("Pretty in Pink", 1986, "John Hughes", "10"));

        when(consoleInput.getInput()).thenReturn("Funny Girl");
        mainMenu.dispatch(bookLibrary, movieLibrary, "6");

        assertEquals("Enter movie to be checked out:\nThank you! Enjoy the movie\n", outputContent.toString());
    }

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldExitTheApplicationWhenOptionNineIsEntered() {
        exit.expectSystemExitWithStatus(0);
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        BookLibrary bookLibrary = new BookLibrary(availableBookList, checkedOutBookList);
        ArrayList<Movie> movieList = new ArrayList<>();
        MovieLibrary movieLibrary = new MovieLibrary(movieList);
        movieList.add(new Movie("Funny Girl", 1968, "William Wyler", "8"));
        movieList.add(new Movie("Pretty in Pink", 1986, "John Hughes", "10"));

        when(consoleInput.getInput()).thenReturn("Funny Girl");
        mainMenu.dispatch(bookLibrary, movieLibrary, "9");
    }
}