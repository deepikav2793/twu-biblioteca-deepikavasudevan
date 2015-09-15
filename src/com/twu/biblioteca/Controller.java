/*Controls flow of Biblioteca*/
package com.twu.biblioteca;

public class Controller {

    private ConsoleInput consoleInput;
    private ConsoleOutput consoleOutput;
    Setup setup = new Setup();

    public Controller() {
        consoleInput = new ConsoleInput();
        consoleOutput = new ConsoleOutput();
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

    public void initialiseApplication() {
        displayWelcomeMessage();

        for (; ; ) {
            displayMenuOptionsAndDispatch();
        }
    }
}