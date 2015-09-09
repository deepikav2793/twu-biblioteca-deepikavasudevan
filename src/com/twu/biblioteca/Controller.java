/*Controls flow of control of Bibllioteca*/
package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class Controller {
    public void displayWelcomeMessage() {
        WelcomeMessage welcomeMessage = new WelcomeMessage();
        welcomeMessage.display();
    }

    public MainMenu initialiseMainMenuWithOptions() {
        ArrayList<String> menuOptions = new ArrayList<>(Arrays.asList("1. List Books", "2. Check Out", "Quit"));
        ConsoleInput consoleInput = new ConsoleInput();

        return new MainMenu(menuOptions, consoleInput);
    }

    public void displayMenuOptions() {
        MainMenu mainMenu = initialiseMainMenuWithOptions();
        mainMenu.display();
    }

    public void getMenuOptionAndDispatch(ConsoleInput consoleInput) {
        MainMenu mainMenu = initialiseMainMenuWithOptions();
        Library library = new Library();

        mainMenu.dispatch(library, consoleInput.getInput());
    }
}
