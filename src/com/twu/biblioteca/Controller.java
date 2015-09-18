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
    private User currentUser;

    public Controller(ArrayList<User> listOfUsers, ConsoleInputAndOutputFactory consoleInputAndOutputFactory, BookLibraryFactory bookLibraryFactory, MainMenuFactory mainMenuFactory,
                      MovieLibraryFactory movieLibraryFactory, WelcomeMessageFactory welcomeMessageFactory, User currentUser) {
        this.listOfUsers = listOfUsers;
        consoleInput = consoleInputAndOutputFactory.createConsoleInput();
        consoleOutput = consoleInputAndOutputFactory.createConsoleOutput();
        welcomeMessage = welcomeMessageFactory.createWelcomeMessage();
        mainMenu = mainMenuFactory.createMainMenu();
        bookLibrary = bookLibraryFactory.createBookLibrary();
        movieLibrary = movieLibraryFactory.createMovieLibrary();
        this.currentUser = currentUser;
    }

    public void dispatchMenuOption(String menuOption) {
        MainMenuOption mainMenuOption = parseMenuOption(menuOption);
        currentUser = mainMenu.executeOption(mainMenuOption);
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
            return dispatchValidMenuOptionForOptionOne();
        } else if (menuOption.equals("2")) {
            return new ListLibraryMenuOption(bookLibrary, consoleOutput, currentUser);
        } else if (menuOption.equals("3")) {
            return dispatchValidMenuOptionForOptionThree();
        } else if (menuOption.equals("4")) {
            return dispatchValidMenuOptionForOptionFour();
        } else if (menuOption.equals("5")) {
            return new ListLibraryMenuOption(movieLibrary, consoleOutput, currentUser);
        } else if (menuOption.equals("6")) {
            return new CheckOutMenuOption(movieLibrary, consoleInput, consoleOutput, currentUser);
        } else if (menuOption.equals("7")) {
            return dispatchValidMenuOptionForOptionSeven();
        } else if (menuOption.equals("8")) {
            return dispatchValidMenuOptionForOptionEight();
        } else if (menuOption.equals("9")) {
            return dispatchValidMenuOptionForMenuOptionNine();
        } else if (menuOption.equals("10")) {
            return new QuitMenuOption(currentUser);
        } else {
            return new InvalidMenuOption(consoleOutput, currentUser);
        }
    }

    private MainMenuOption dispatchValidMenuOptionForMenuOptionNine() {
        if (currentUser.getUserRole().equals(ROLE.GUEST_USER))
            return new NotAuthorisedMenuOption(consoleOutput, currentUser);
        else
            return new LogoutMenuOption(consoleOutput, currentUser);
    }

    private MainMenuOption dispatchValidMenuOptionForOptionEight() {
        if (currentUser.getUserRole().equals(ROLE.GUEST_USER))
            return new NotAuthorisedMenuOption(consoleOutput, currentUser);
        else
            return new UserInformationOption(consoleOutput, currentUser);
    }

    private MainMenuOption dispatchValidMenuOptionForOptionSeven() {
        if (currentUser.getUserRole().equals(ROLE.LIBRARIAN))
            return new CheckedOutListWithUser(bookLibrary, consoleOutput, currentUser);
        else
            return new NotAuthorisedMenuOption(consoleOutput, currentUser);
    }

    private MainMenuOption dispatchValidMenuOptionForOptionFour() {
        if (currentUser.getUserRole().equals(ROLE.GUEST_USER))
            return new NotAuthorisedMenuOption(consoleOutput, currentUser);
        else
            return new ReturnBookMenuOption(bookLibrary, consoleInput, consoleOutput, currentUser);
    }

    private MainMenuOption dispatchValidMenuOptionForOptionThree() {
        if (currentUser.getUserRole().equals(ROLE.GUEST_USER))
            return new NotAuthorisedMenuOption(consoleOutput, currentUser);
        else
            return new CheckOutMenuOption(bookLibrary, consoleInput, consoleOutput, currentUser);
    }

    private MainMenuOption dispatchValidMenuOptionForOptionOne() {
        if (currentUser.getUserRole().equals(ROLE.GUEST_USER))
            return new LoginMenuOption(consoleInput, consoleOutput, listOfUsers, currentUser);
        else
            return new NotAuthorisedMenuOption(consoleOutput, currentUser);
    }

    public void initialiseBibliotecaApplication() {
        displayWelcomeMessage();

        for (; ; ) {
            displayMenuOptions();
            dispatchMenuOption(menuOption());
        }
    }
}