/*Main Menu shows list of options from which one is chosen*/
package com.twu.biblioteca;

import java.util.ArrayList;

public class MainMenu {

    private ArrayList<String> menuOptions = new ArrayList<String>();

    MainMenu(ArrayList<String> menuOptions) {
        this.menuOptions = menuOptions;
    }

    public void display() {
        System.out.println("MAIN MENU");

        for (String menuOption : menuOptions) {
           System.out.println(menuOption);
        }
    }
}