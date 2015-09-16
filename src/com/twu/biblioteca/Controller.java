/*Controls flow of Biblioteca*/
package com.twu.biblioteca;

import java.util.ArrayList;

public class Controller {

    private ArrayList<User> listOfUsers;
    private Factory factory;
    private ConsoleInput consoleInput;
    private ConsoleOutput consoleOutput;
    private Setup setup;
    private BookLibrary bookLibrary;
    private MovieLibrary movieLibrary;
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
        if (menuOption.equals("6")) {
            consoleOutput.display("Enter movie to be checked out:");
            consoleOutput.display(movieLibrary.checkOutMovie(consoleInput.getInput()));
        }else if (menuOption.equals("9")) {
            quitOption();
        } else {
            invalidOption();
        }
    }

    private void quitOption() {
        System.exit(0);
    }

    private void invalidOption() {
        consoleOutput.display("Select a valid option!");
    }
}