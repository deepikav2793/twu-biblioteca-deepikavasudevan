/*Controls flow of Biblioteca*/
package com.twu.biblioteca;

import java.util.ArrayList;

public class Controller {

    private ArrayList<User> listOfUsers;
    private ConsoleInput consoleInput;
    private ConsoleOutput consoleOutput;
    private WelcomeMessage welcomeMessage;
    private MainMenu mainMenu;
    private BookLibrary bookLibrary;
    private MovieLibrary movieLibrary;

    public Controller(ArrayList<User> listOfUsers, ConsoleInputAndOutputFactory consoleInputAndOutputFactory, BookLibraryFactory bookLibraryFactory, MainMenuFactory mainMenuFactory,
                      MovieLibraryFactory movieLibraryFactory, WelcomeMessageFactory welcomeMessageFactory) {
        this.listOfUsers = listOfUsers;
        consoleInput = consoleInputAndOutputFactory.createConsoleInput();
        consoleOutput = consoleInputAndOutputFactory.createConsoleOutput();
        welcomeMessage = welcomeMessageFactory.createWelcomeMessage();
        mainMenu = mainMenuFactory.createMainMenu();
        bookLibrary = bookLibraryFactory.createBookLibrary();
        movieLibrary = movieLibraryFactory.createMovieLibrary();
    }

    public void initialiseBibliotecaApplication() {
        displayWelcomeMessage();

        for (; ; ) {
            displayMenuOptions();
            dispatchMenuOption(menuOptionsInput());
        }
    }

    public void displayWelcomeMessage() {
        consoleOutput.display(welcomeMessage.getWelcomeMessage());
    }

    public void displayMenuOptions() {
        consoleOutput.display(mainMenu.mainMenuOptions());
    }

    protected String menuOptionsInput() {
        return consoleInput.getInput();
    }

    public void dispatchMenuOption(String menuOption) {
        if (menuOption.equals("2")) {
            ListLibraryMenuOption listLibraryMenuOption = new ListLibraryMenuOption(bookLibrary, consoleOutput);
            listLibraryMenuOption.executeOptionOperation();
        } else if (menuOption.equals("3")) {
            checkOut(bookLibrary);
        } else if (menuOption.equals("4")) {
            returnBook();
        } else if (menuOption.equals("5")) {
            ListLibraryMenuOption listLibraryMenuOption = new ListLibraryMenuOption(movieLibrary, consoleOutput);
            listLibraryMenuOption.executeOptionOperation();
        } else if (menuOption.equals("6")) {
            checkOut(movieLibrary);
        } else if (menuOption.equals("9")) {
            quitOption();
        } else {
            invalidOption();
        }
    }

    private void checkOut(Library library) {
        consoleOutput.display("Enter what is to be checked out:");
        String movieToBeCheckedOut = consoleInput.getInput();
        String checkOutMessage = library.checkOut(movieToBeCheckedOut);
        consoleOutput.display(checkOutMessage);
    }

    private void returnBook() {
        consoleOutput.display("Enter book to be returned:");
        String bookToBeReturned = consoleInput.getInput();
        String returnMessage = bookLibrary.returnBook(bookToBeReturned);
        consoleOutput.display(returnMessage);
    }

    private void quitOption() {
        System.exit(0);
    }

    private void invalidOption() {
        consoleOutput.display("Select a valid option!");
    }
}