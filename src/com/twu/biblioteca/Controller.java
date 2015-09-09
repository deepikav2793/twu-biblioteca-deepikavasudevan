/*Controls flow of control of Bibllioteca*/
package com.twu.biblioteca;

import java.util.ArrayList;

public class Controller {

    public void displayWelcomeMessage() {
        WelcomeMessage welcomeMessage = new WelcomeMessage();
        welcomeMessage.display();
    }

    private MainMenu initialiseMainMenuWithOptions() {
        ArrayList<String> menuOptions = new ArrayList<>();
        menuOptions.add("1. List Books");
        menuOptions.add("2. Check Out");
        menuOptions.add("Quit");
        ConsoleInput consoleInput = new ConsoleInput();

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

    public void initialiseApplication(Library library, ConsoleInput consoleInput) {
        displayWelcomeMessage();
        for(; ;) {
            displayMenuOptions();
            initialiseMenuDispatch(library, consoleInput);
        }
    }
}
