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

    public void dispatchMenuOption(String menuOption) {
        MainMenuOption mainMenuOption = parseMenuOption(menuOption);
         mainMenu.executeOption(mainMenuOption);
    }

    public void displayWelcomeMessage() {
        consoleOutput.display(welcomeMessage.getWelcomeMessage());
    }

    public void displayMenuOptions() {
        consoleOutput.display(mainMenu.mainMenuOptions());
    }

    protected String menuOption() {
        return consoleInput.getInput();
    }

    public MainMenuOption parseMenuOption(String menuOption) {
        if (menuOption.equals("1")) {
            return new LoginMenuOption(consoleInput, consoleOutput, listOfUsers);
        } else if (menuOption.equals("2")) {
            return new ListLibraryMenuOption(bookLibrary, consoleOutput);
        } else if (menuOption.equals("3")) {
            return new CheckOutMenuOption(bookLibrary, consoleInput, consoleOutput);
        } else if (menuOption.equals("4")) {
            return new ReturnBookMenuOption(bookLibrary, consoleInput, consoleOutput);
        } else if (menuOption.equals("5")) {
            return new ListLibraryMenuOption(movieLibrary, consoleOutput);
        } else if (menuOption.equals("6")) {
            return new CheckOutMenuOption(movieLibrary, consoleInput, consoleOutput);
        } else if (menuOption.equals("9")) {
            return new QuitMenuOption();
        } else {
            return new InvalidMenuOption(consoleOutput);
        }
    }

    public void initialiseBibliotecaApplication() {
        displayWelcomeMessage();

        for (; ; ) {
            displayMenuOptions();
            dispatchMenuOption(menuOption());
        }
    }
}