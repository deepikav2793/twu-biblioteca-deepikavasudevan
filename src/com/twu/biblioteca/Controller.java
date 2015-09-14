/*Controls flow of Biblioteca*/
package com.twu.biblioteca;

import java.util.ArrayList;

public class Controller {

    private ConsoleInput consoleInput;
    private Library library;

    public Controller() {
        consoleInput = new ConsoleInput();
        library = new Library();
    }

    public void displayWelcomeMessage() {
        WelcomeMessage welcomeMessage = new WelcomeMessage();
        welcomeMessage.display();
    }

    private MainMenu initialiseMainMenuWithOptions() {
        ArrayList<String> menuOptions = new ArrayList<>();
        menuOptions.add("1. List Books");
        menuOptions.add("2. Checkout Book");
        menuOptions.add("3. Return Book");
        menuOptions.add("4. Quit");

        return new MainMenu(menuOptions, consoleInput);
    }

    public void displayMenuOptions() {
        MainMenu mainMenu = initialiseMainMenuWithOptions();
        mainMenu.display();
    }

    public void initialiseMenuDispatch(Library library, ConsoleInput consoleInput) {
        MainMenu mainMenu = initialiseMainMenuWithOptions();
        mainMenu.dispatch(library, consoleInput.getInput());
    }

    public void initialiseApplication() {
        displayWelcomeMessage();
        for (; ; ) {
            displayMenuOptions();
            initialiseMenuDispatch(library, consoleInput);
        }
    }
}
