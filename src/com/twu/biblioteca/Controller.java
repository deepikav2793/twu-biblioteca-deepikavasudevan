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
}
