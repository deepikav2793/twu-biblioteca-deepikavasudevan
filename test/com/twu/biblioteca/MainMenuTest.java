package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.Assert.assertEquals;

public class MainMenuTest {

    private ByteArrayOutputStream outputContent = new ByteArrayOutputStream();

    @Before
    public void setStreamsWithInitialValue() {
        System.setOut(new PrintStream(outputContent));
    }

    @Test
    public void shouldDisplayListOfOptionsInMainMenu() {
        ArrayList<String> menuOptions = new ArrayList<>(Arrays.asList("1. List Books", "Quit"));
        ConsoleInput consoleInput = new ConsoleInput();
        ConsoleOutput consoleOutput = new ConsoleOutput();
        MainMenu mainMenu = new MainMenu(menuOptions, consoleInput, consoleOutput);

        assertEquals("MAIN MENU\n1. List Books\nQuit\n", mainMenu.mainMenuOptions());
    }


    @Test
    public void shouldListBooksWhenOptionIsInputtedAsOne() {
        ByteArrayInputStream inputOptionOne = new ByteArrayInputStream("1".getBytes());
        System.setIn(inputOptionOne);

        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));
        BookLibrary bookLibrary = new BookLibrary(availableBookList, checkedOutBookList);
        ArrayList<Movie> movieList = new ArrayList<>();
        MovieLibrary movieLibrary = new MovieLibrary(movieList);
        ConsoleInput consoleInput = new ConsoleInput();
        ArrayList<String> menuOptions = new ArrayList<>(Arrays.asList("1. List Books"));
        ConsoleOutput consoleOutput = new ConsoleOutput();
        MainMenu mainMenu = new MainMenu(menuOptions, consoleInput, consoleOutput);

        mainMenu.dispatch(bookLibrary, movieLibrary, "1");

        assertEquals("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\nGone Girl\tGillian Flynn" +
                "\t2000\nThe Scarlett Letter\tNathaniel Hawthorne\t1850\n\n", outputContent.toString());
    }

    @Test
    public void shouldGiveAppropriateMessageWhenInvalidOptionIsEntered() {
        ByteArrayInputStream inputInvalid = new ByteArrayInputStream("Invalid".getBytes());
        System.setIn(inputInvalid);

        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));
        BookLibrary bookLibrary = new BookLibrary(availableBookList, checkedOutBookList);
        ArrayList<Movie> movieList = new ArrayList<>();
        MovieLibrary movieLibrary = new MovieLibrary(movieList);
        ArrayList<String> menuOptions = new ArrayList<>(Arrays.asList("1. List Books"));
        ConsoleInput consoleInput = new ConsoleInput();
        ConsoleOutput consoleOutput = new ConsoleOutput();
        MainMenu mainMenu = new MainMenu(menuOptions, consoleInput, consoleOutput);

        mainMenu.dispatch(bookLibrary, movieLibrary, "Invalid");

        assertEquals("Select a valid option!\n", outputContent.toString());
    }

    @Test
    public void shouldHaveAnotherOptionToCheckOutABook() {
        ArrayList<String> menuOptions = new ArrayList<>(Arrays.asList("1. List Books", "2. Checkout", "Quit"));
        ConsoleInput consoleInput = new ConsoleInput();
        ConsoleOutput consoleOutput = new ConsoleOutput();
        MainMenu mainMenu = new MainMenu(menuOptions, consoleInput, consoleOutput);

        assertEquals("MAIN MENU\n1. List Books\n2. Checkout\nQuit\n", mainMenu.mainMenuOptions());
    }

    @Test
    public void shouldChooseCheckOutBookOptionWhenOptionTwoIsEntered() {
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        ArrayList<String> menuOptions = new ArrayList<>(Arrays.asList("1. List Books", "2. Checkout Book", "Quit"));
        ConsoleOutput consoleOutput = new ConsoleOutput();
        MainMenu mainMenu = new MainMenu(menuOptions, consoleInput, consoleOutput);

        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));
        BookLibrary bookLibrary = new BookLibrary(availableBookList, checkedOutBookList);
        ArrayList<Movie> movieList = new ArrayList<>();
        MovieLibrary movieLibrary = new MovieLibrary(movieList);

        when(consoleInput.getInput()).thenReturn("Gone Girl");
        mainMenu.dispatch(bookLibrary, movieLibrary, "2");

        assertEquals("Enter book to be checked out:\nThank you! Enjoy the book\n", outputContent.toString());
    }

    @Test
    public void shouldChooseReturnBookOptionWhenOptionThreeIsEntered() {
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        ArrayList<String> menuOptions = new ArrayList<>(Arrays.asList("1. List Books", "2. Checkout Book", "3. Return Book", "Quit"));
        ConsoleOutput consoleOutput = new ConsoleOutput();
        MainMenu mainMenu = new MainMenu(menuOptions, consoleInput, consoleOutput);

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

        assertEquals("Enter book to be returned:\nThat is not a valid book to return\n", outputContent.toString());
    }

    @Test
    public void shouldChooseListMoviesOptionWhenOptionFourIsEntered() {
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        ArrayList<String> menuOptions = new ArrayList<>(Arrays.asList("1. List Books", "2. Checkout Book", "3. Return Book", "Quit"));
        ConsoleOutput consoleOutput = new ConsoleOutput();
        MainMenu mainMenu = new MainMenu(menuOptions, consoleInput, consoleOutput);

        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        BookLibrary bookLibrary = new BookLibrary(availableBookList, checkedOutBookList);
        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Funny Girl", 1968, "William Wyler", "8"));
        movieList.add(new Movie("Pretty in Pink", 1986, "John Hughes", "10"));
        MovieLibrary movieLibrary = new MovieLibrary(movieList);

        mainMenu.dispatch(bookLibrary, movieLibrary, "4");

        assertEquals("NAME OF MOVIE\tYEAR\tDIRECTOR\tMOVIE RATING\nFunny Girl\t1968\tWilliam Wyler\t8\n" +
                "Pretty in Pink\t1986\tJohn Hughes\t10\n\n", outputContent.toString());
    }

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldExitTheApplicationWhenOptionFiveIsEnabled() {
        ByteArrayInputStream inputQuit = new ByteArrayInputStream("5".getBytes());
        System.setIn(inputQuit);

        exit.expectSystemExit();
        System.exit(0);
    }

    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
        System.setIn(System.in);
    }
}