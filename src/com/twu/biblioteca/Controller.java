/*Controls flow of Biblioteca*/
package com.twu.biblioteca;

import java.util.ArrayList;

public class Controller {

    private ArrayList<User> listOfUsers;
    private ConsoleInput consoleInput;
    private ConsoleOutput consoleOutput;
    private Setup setup;

    public Controller(ArrayList<User> listOfUsers) {
        consoleInput = new ConsoleInput();
        consoleOutput = new ConsoleOutput();
        setup = new Setup();
        this.listOfUsers = listOfUsers;
    }

    public void displayWelcomeMessage() {
        WelcomeMessage welcomeMessage = setup.initialiseWelcomeMessage();
        consoleOutput.display(welcomeMessage.getWelcomeMessage());
    }


    public void displayMenuOptionsAndDispatch() {
        MainMenu mainMenu = setup.initialiseMainMenuWithOptions();
        BookLibrary bookLibrary = setup.initialiseLibraryWithBooks();
        MovieLibrary movieLibrary = setup.initialiseMovieLibraryWithMovies();

        consoleOutput.display(mainMenu.mainMenuOptions());
        mainMenu.dispatch(bookLibrary, movieLibrary, consoleInput.getInput());
    }

    public void initialiseBibliotecaApplication() {
        displayWelcomeMessage();

        for (; ; ) {
            displayMenuOptionsAndDispatch();
        }
    }
}