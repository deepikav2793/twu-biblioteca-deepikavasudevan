package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ControllerTest {

    private ByteArrayOutputStream outputContent;

    @Before
    public void setOutputContent() {
        outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
    }

    @Test
    public void shouldInitialiseWelcomeMessageAndDisplayIt() {
        User currentUser = new User("Guest User","No Password",ROLE.GUEST_USER);
        Controller controller = new Controller(new ArrayList<User>(), new ConsoleInputAndOutputFactory(), new BookLibraryFactory(),
                new MainMenuFactory(), new MovieLibraryFactory(), new WelcomeMessageFactory(), currentUser);
        controller.displayWelcomeMessage();

        assertEquals("Hello! Welcome to Bangalore Public Library!\n", outputContent.toString());
    }

    @Test
    public void shouldInitialiseMenuToDisplayItsOptionsAndDispatch() {
        ByteArrayInputStream inputOption = new ByteArrayInputStream("Invalid".getBytes());
        System.setIn(inputOption);

        User currentUser = new User("Guest User","No Password",ROLE.GUEST_USER);
        Controller controller = new Controller(new ArrayList<User>(), new ConsoleInputAndOutputFactory(), new BookLibraryFactory(),
                new MainMenuFactory(), new MovieLibraryFactory(), new WelcomeMessageFactory(), currentUser);
        controller.displayMenuOptions();

        assertEquals("MAIN MENU\n1. Login\n2. List Books\n3. Checkout Book\n4. Return Book\n5. List Movies\n6. Checkout Movie" +
                "\n7. List Checked Out Books with User's Library Number\n8. Logout\n9. Quit\n\n", outputContent.toString());
    }

    @Test
    public void shouldUseAFactoryToCreateConsoleInput() {
        ConsoleInputAndOutputFactory consoleInputAndOutputFactory = mock(ConsoleInputAndOutputFactory.class);
        User currentUser = new User("Guest User","No Password",ROLE.GUEST_USER);
        Controller controller = new Controller(new ArrayList<User>(), consoleInputAndOutputFactory, new BookLibraryFactory(),
                new MainMenuFactory(), new MovieLibraryFactory(), new WelcomeMessageFactory(), currentUser);

        verify(consoleInputAndOutputFactory, times(1)).createConsoleInput();
    }

    @Test
    public void shouldUseAFactoryToCreateConsoleOutput() {
        ConsoleInputAndOutputFactory consoleInputAndOutputFactory = mock(ConsoleInputAndOutputFactory.class);
        User currentUser = new User("Guest User","No Password",ROLE.GUEST_USER);
        Controller controller = new Controller(new ArrayList<User>(), consoleInputAndOutputFactory, new BookLibraryFactory(),
                new MainMenuFactory(), new MovieLibraryFactory(), new WelcomeMessageFactory(), currentUser);

        verify(consoleInputAndOutputFactory, times(1)).createConsoleOutput();
    }

    @Test
    public void shouldUseBookLibraryFactoryToCreateBookLibrary() {
        BookLibraryFactory bookLibraryFactory = mock(BookLibraryFactory.class);
        User currentUser = new User("Guest User","No Password",ROLE.GUEST_USER);
        Controller controller = new Controller(new ArrayList<User>(), new ConsoleInputAndOutputFactory(), bookLibraryFactory,
                new MainMenuFactory(), new MovieLibraryFactory(), new WelcomeMessageFactory(), currentUser);

        verify(bookLibraryFactory, times(1)).createBookLibrary();
    }

    @Test
    public void shouldUseMovieLibraryFactoryToCreateMovieLibrary() {
        MovieLibraryFactory movieLibraryFactory = mock(MovieLibraryFactory.class);
        User currentUser = new User("Guest User","No Password",ROLE.GUEST_USER);
        Controller controller = new Controller(new ArrayList<User>(), new ConsoleInputAndOutputFactory(), new BookLibraryFactory(),
                new MainMenuFactory(), movieLibraryFactory, new WelcomeMessageFactory(), currentUser);

        verify(movieLibraryFactory, times(1)).createMovieLibrary();
    }

    @Test
    public void shouldUseMainMenuFactoryToCreateBookLibrary() {
        MainMenuFactory mainMenuFactory = mock(MainMenuFactory.class);
        User currentUser = new User("Guest User","No Password",ROLE.GUEST_USER);
        Controller controller = new Controller(new ArrayList<User>(), new ConsoleInputAndOutputFactory(), new BookLibraryFactory(),
                mainMenuFactory, new MovieLibraryFactory(), new WelcomeMessageFactory(), currentUser);

        verify(mainMenuFactory, times(1)).createMainMenu();
    }

    @Test
    public void shouldUseWelcomeMessageFactoryToCreateWelcomeMessage() {
        WelcomeMessageFactory welcomeMessageFactory = mock(WelcomeMessageFactory.class);
        User currentUser = new User("Guest User","No Password",ROLE.GUEST_USER);
        Controller controller = new Controller(new ArrayList<User>(), new ConsoleInputAndOutputFactory(), new BookLibraryFactory(),
                new MainMenuFactory(), new MovieLibraryFactory(), welcomeMessageFactory, currentUser);

        verify(welcomeMessageFactory, times(1)).createWelcomeMessage();
    }

    @Test
    public void shouldUseConsoleInputWhileTakingMenuOptionsAsInputFromConsole() {
        ByteArrayInputStream inputOneOption = new ByteArrayInputStream("1".getBytes());
        System.setIn(inputOneOption);
        ConsoleInputAndOutputFactory consoleInputAndOutputFactory = mock(ConsoleInputAndOutputFactory.class);
        when(consoleInputAndOutputFactory.createConsoleInput()).thenReturn(new ConsoleInput());
        User currentUser = new User("Guest User","No Password",ROLE.GUEST_USER);
        Controller controller = new Controller(new ArrayList<User>(), consoleInputAndOutputFactory, new BookLibraryFactory(),
                new MainMenuFactory(), new MovieLibraryFactory(), new WelcomeMessageFactory(), currentUser);

        assertEquals("1", controller.menuOption());
    }

    @Test
    public void shouldDisplayInvalidMessageWhenInvalidOptionIsEntered() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        ConsoleInputAndOutputFactory consoleInputAndOutputFactory = mock(ConsoleInputAndOutputFactory.class);

        when(consoleInputAndOutputFactory.createConsoleOutput()).thenReturn(new ConsoleOutput());
        User currentUser = new User("Guest User","No Password",ROLE.GUEST_USER);
        Controller controller = new Controller(new ArrayList<User>(), consoleInputAndOutputFactory, new BookLibraryFactory(),
                new MainMenuFactory(), new MovieLibraryFactory(), new WelcomeMessageFactory(), currentUser);
        controller.dispatchMenuOption("Invalid");

        assertEquals("Select a valid option!\n", outputContent.toString());
    }

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldQuitTheApplicationWhenMenuOptionOfNineIsEntered() {
        exit.expectSystemExitWithStatus(0);
        ConsoleInputAndOutputFactory consoleInputAndOutputFactory = mock(ConsoleInputAndOutputFactory.class);
        User currentUser = new User("Guest User","No Password",ROLE.GUEST_USER);
        Controller controller = new Controller(new ArrayList<User>(), consoleInputAndOutputFactory, new BookLibraryFactory(),
                new MainMenuFactory(), new MovieLibraryFactory(), new WelcomeMessageFactory(), currentUser);
        controller.dispatchMenuOption("9");
    }

    @Test
    public void shouldCheckOutAMovieFromMovieLibraryWhenMenuOptionOfSixIsEntered() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        ConsoleInputAndOutputFactory consoleInputAndOutputFactory = mock(ConsoleInputAndOutputFactory.class);
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        when(consoleInputAndOutputFactory.createConsoleOutput()).thenReturn(new ConsoleOutput());
        when(consoleInputAndOutputFactory.createConsoleInput()).thenReturn(consoleInput);
        when(consoleInput.getInput()).thenReturn("Funny Girl");
        User currentUser = new User("Guest User","No Password",ROLE.GUEST_USER);

        Controller controller = new Controller(new ArrayList<User>(), consoleInputAndOutputFactory, new BookLibraryFactory(),
                new MainMenuFactory(), new MovieLibraryFactory(), new WelcomeMessageFactory(), currentUser);
        controller.dispatchMenuOption("6");

        assertEquals("Enter what is to be checked out:\nThank you! Enjoy the movie\n", outputContent.toString());
    }


    @Test
    public void shouldListMoviesFromMovieLibraryWhenMovieOptionOfFiveIsEntered() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        ConsoleInputAndOutputFactory consoleInputAndOutputFactory = mock(ConsoleInputAndOutputFactory.class);
        when(consoleInputAndOutputFactory.createConsoleOutput()).thenReturn(new ConsoleOutput());
        User currentUser = new User("Guest User","No Password",ROLE.GUEST_USER);
        Controller controller = new Controller(new ArrayList<User>(), consoleInputAndOutputFactory, new BookLibraryFactory(),
                new MainMenuFactory(), new MovieLibraryFactory(), new WelcomeMessageFactory(), currentUser);
        controller.dispatchMenuOption("5");

        assertEquals("NAME OF MOVIE\tYEAR\tDIRECTOR\tMOVIE RATING\nFunny Girl\t1968\tWilliam Wyler\t8\n" +
                "Pretty in Pink\t1986\tJohn Hughes\t10\n\n", outputContent.toString());
    }

    @Test
    public void shouldPrintInvalidOptionIfUserHasNotLoggedInToReturnABookToLibraryWhenMenuOptionOfFourIsEntered() {
        System.setOut(new PrintStream(outputContent));
        ConsoleInputAndOutputFactory consoleInputAndOutputFactory = mock(ConsoleInputAndOutputFactory.class);
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        when(consoleInputAndOutputFactory.createConsoleOutput()).thenReturn(new ConsoleOutput());
        when(consoleInputAndOutputFactory.createConsoleInput()).thenReturn(consoleInput);
        when(consoleInput.getInput()).thenReturn("Gone Girl");
        User currentUser = new User("Guest User","No Password",ROLE.GUEST_USER);
        Controller controller = new Controller(new ArrayList<User>(), consoleInputAndOutputFactory, new BookLibraryFactory(),
                new MainMenuFactory(), new MovieLibraryFactory(), new WelcomeMessageFactory(), currentUser);
        controller.dispatchMenuOption("4");

        assertEquals("NOT AUTHORISED to access this option. Please log in.\n", outputContent.toString());
    }

    @Test
    public void shouldReturnABookToLibraryWhenMenuOptionOfFourIsEntered() {
        System.setOut(new PrintStream(outputContent));
        ConsoleInputAndOutputFactory consoleInputAndOutputFactory = mock(ConsoleInputAndOutputFactory.class);
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        when(consoleInputAndOutputFactory.createConsoleOutput()).thenReturn(new ConsoleOutput());
        when(consoleInputAndOutputFactory.createConsoleInput()).thenReturn(consoleInput);
        when(consoleInput.getInput()).thenReturn("Gone Girl");
        User currentUser = new User("Guest User","No Password",ROLE.AUTHENTICATED_USER);
        Controller controller = new Controller(new ArrayList<User>(), consoleInputAndOutputFactory, new BookLibraryFactory(),
                new MainMenuFactory(), new MovieLibraryFactory(), new WelcomeMessageFactory(), currentUser);
        controller.dispatchMenuOption("4");

        assertEquals("Enter book to be returned:\nThat is not a valid book to return\n", outputContent.toString());
    }

    @Test
    public void shouldPrintInvalidOptionIfUserHasNotLoggedInForCheckedOutBookWhenMenuOptionOfThreeIsEntered() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        ConsoleInputAndOutputFactory consoleInputAndOutputFactory = mock(ConsoleInputAndOutputFactory.class);
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        when(consoleInputAndOutputFactory.createConsoleInput()).thenReturn(consoleInput);
        when(consoleInput.getInput()).thenReturn("Gone Girl");
        when(consoleInputAndOutputFactory.createConsoleOutput()).thenReturn(new ConsoleOutput());
        User currentUser = new User("usr-1001", "password1", ROLE.GUEST_USER);
        Controller controller = new Controller(new ArrayList<User>(), consoleInputAndOutputFactory, new BookLibraryFactory(),
                new MainMenuFactory(), new MovieLibraryFactory(), new WelcomeMessageFactory(), currentUser);
        controller.dispatchMenuOption("3");

        assertEquals("NOT AUTHORISED to access this option. Please log in.\n", outputContent.toString());
    }

    @Test
    public void shouldCheckOutABookFromLibraryWhenMenuOptionOfThreeIsEntered() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        ConsoleInputAndOutputFactory consoleInputAndOutputFactory = mock(ConsoleInputAndOutputFactory.class);
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        when(consoleInputAndOutputFactory.createConsoleInput()).thenReturn(consoleInput);
        when(consoleInput.getInput()).thenReturn("Gone Girl");
        when(consoleInputAndOutputFactory.createConsoleOutput()).thenReturn(new ConsoleOutput());
        User currentUser = new User("usr-1001", "password1", ROLE.AUTHENTICATED_USER);
        Controller controller = new Controller(new ArrayList<User>(), consoleInputAndOutputFactory, new BookLibraryFactory(),
                new MainMenuFactory(), new MovieLibraryFactory(), new WelcomeMessageFactory(), currentUser);
        controller.dispatchMenuOption("3");

        assertEquals("Enter what is to be checked out:\nThank you! Enjoy the book\n", outputContent.toString());
    }

    @Test
    public void shouldListBooksFromBookLibraryWhenMovieOptionOfTwoIsEntered() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        ConsoleInputAndOutputFactory consoleInputAndOutputFactory = mock(ConsoleInputAndOutputFactory.class);
        when(consoleInputAndOutputFactory.createConsoleOutput()).thenReturn(new ConsoleOutput());
        User currentUser = new User("Guest User","No Password",ROLE.GUEST_USER);
        Controller controller = new Controller(new ArrayList<User>(), consoleInputAndOutputFactory, new BookLibraryFactory(),
                new MainMenuFactory(), new MovieLibraryFactory(), new WelcomeMessageFactory(), currentUser);
        controller.dispatchMenuOption("2");

        assertEquals("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\nGone Girl\tGillian Flynn" +
                "\t2000\nThe Scarlett Letter\tNathaniel Hawthorne\t1850\n\n", outputContent.toString());
    }

    @Test
    public void shouldInvokeLoginWhenOptionOneIsEntered() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        ConsoleInputAndOutputFactory consoleInputAndOutputFactory = mock(ConsoleInputAndOutputFactory.class);
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        when(consoleInputAndOutputFactory.createConsoleInput()).thenReturn(consoleInput);
        when(consoleInput.getInput()).thenReturn("usr-1000", "password1");
        when(consoleInputAndOutputFactory.createConsoleOutput()).thenReturn(new ConsoleOutput());
        User currentUser = new User("Guest User","No Password",ROLE.GUEST_USER);
        Controller controller = new Controller(new ArrayList<User>(), consoleInputAndOutputFactory, new BookLibraryFactory(),
                new MainMenuFactory(), new MovieLibraryFactory(), new WelcomeMessageFactory(), currentUser);
        controller.dispatchMenuOption("1");

        assertEquals("Enter username:\nEnter password:\nLogin Unsuccessful\n", outputContent.toString());
    }
}