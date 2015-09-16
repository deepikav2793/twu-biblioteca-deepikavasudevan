/*Controls flow of Biblioteca*/
package com.twu.biblioteca;

import java.util.ArrayList;

public class Controller {

    private ArrayList<User> listOfUsers;
    private Factory factory;
    private BookLibrary bookLibrary;
    private MovieLibrary movieLibrary;
    private Setup setup;
    private ConsoleInput consoleInput;
    private ConsoleOutput consoleOutput;
    private MainMenu mainMenu;

    public Controller(ArrayList<User> listOfUsers, Factory factory) {
        this.listOfUsers = listOfUsers;
        this.factory = factory;
        consoleInput = factory.createConsoleInput();
        consoleOutput = factory.createConsoleOutput();
        setup = new Setup();
        bookLibrary = setup.initialiseLibraryWithBooks();
        movieLibrary = setup.initialiseMovieLibraryWithMovies();
        mainMenu = setup.initialiseMainMenuWithOptions();
    }

    public void displayWelcomeMessage() {
        WelcomeMessage welcomeMessage = setup.initialiseWelcomeMessage();
        consoleOutput.display(welcomeMessage.getWelcomeMessage());
    }

    public void displayMenuOptions() {
        consoleOutput.display(mainMenu.mainMenuOptions());
    }

    public void initialiseBibliotecaApplication() {
        displayWelcomeMessage();

        for (; ; ) {
            displayMenuOptions();
            dispatchMenuOption(menuOptionsInput());
        }
    }

    protected String menuOptionsInput() {
        return consoleInput.getInput();
    }

    public void dispatchMenuOption(String menuOption) {
        if (menuOption.equals("2")) {
            listBooks(bookLibrary);
        } else if (menuOption.equals("3")) {
            checkOutBook();
        } else if (menuOption.equals("5")) {
            listMovies(movieLibrary);
        } else if (menuOption.equals("6")) {
            checkOutMovie();
        } else if (menuOption.equals("9")) {
            quitOption();
        } else {
            invalidOption();
        }
    }

    private void listBooks(BookLibrary bookLibrary) {
        consoleOutput.display(bookLibrary.listOfBooks());
    }

    private void listMovies(MovieLibrary movieLibrary) {
        consoleOutput.display(movieLibrary.listOfMovies());
    }

    private void checkOutBook() {
        consoleOutput.display("Enter book to be checked out:");
        consoleOutput.display(bookLibrary.checkOutBook(consoleInput.getInput()));
    }

    private void checkOutMovie() {
        consoleOutput.display("Enter movie to be checked out:");
        consoleOutput.display(movieLibrary.checkOutMovie(consoleInput.getInput()));
    }

    private void quitOption() {
        System.exit(0);
    }

    private void invalidOption() {
        consoleOutput.display("Select a valid option!");
    }
}