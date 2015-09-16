/*A Main Menu Factory creates Main Menu objects */
package com.twu.biblioteca;

import java.util.ArrayList;

public class MainMenuFactory {

    private MainMenu mainMenu;

    public MainMenu createMainMenu() {
        ArrayList<String> menuOptions = new ArrayList<>();

        mainMenu = new MainMenu(menuOptions);
        return mainMenu;
    }
}
