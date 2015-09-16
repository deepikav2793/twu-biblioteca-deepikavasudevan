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
            list(bookLibrary);
        } else if (menuOption.equals("3")) {
            checkOut(bookLibrary);
        } else if (menuOption.equals("4")) {
            returnBook();
        } else if (menuOption.equals("5")) {
            list(movieLibrary);
        } else if (menuOption.equals("6")) {
            checkOut(movieLibrary);
        } else if (menuOption.equals("9")) {
            quitOption();
        } else {
            invalidOption();
        }
    }

    private void returnBook() {
        consoleOutput.display("Enter book to be returned:");
        String bookToBeReturned = consoleInput.getInput();
        String returnMessage = bookLibrary.returnBook(bookToBeReturned);
        consoleOutput.display(returnMessage);
    }

    private void list(Library library) {
        String list = library.list();
        consoleOutput.display(list);
    }

    private void checkOut(Library library) {
        consoleOutput.display("Enter what is to be checked out:");
        String movieToBeCheckedOut = consoleInput.getInput();
        String checkOutMessage = library.checkOut(movieToBeCheckedOut);
        consoleOutput.display(checkOutMessage);
    }

    private void quitOption() {
        System.exit(0);
    }

    private void invalidOption() {
        consoleOutput.display("Select a valid option!");
    }
}