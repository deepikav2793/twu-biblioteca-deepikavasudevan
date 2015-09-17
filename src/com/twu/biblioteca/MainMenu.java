/*Main Menu shows list of options from which the option chosen by the user is dispatched*/
package com.twu.biblioteca;

import java.util.ArrayList;

public class MainMenu {

    private ArrayList<String> menuOptions = new ArrayList<String>();

    public MainMenu(ArrayList<String> menuOptions) {
        this.menuOptions = menuOptions;
    }

    public String mainMenuOptions() {
        String mainMenuOptions = "MAIN MENU\n";

        for (String menuOption : menuOptions) {
            mainMenuOptions += menuOption +"\n";
        }

        return mainMenuOptions;
    }

    public User executeOption(MainMenuOption mainMenuOption) {
        return mainMenuOption.executeOptionOperation();
    }
}