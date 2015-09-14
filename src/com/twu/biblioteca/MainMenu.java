/*Main Menu shows list of options from which the option chosen by the user is dispatched*/
package com.twu.biblioteca;

import java.util.ArrayList;

public class MainMenu {

    private ArrayList<String> menuOptions = new ArrayList<String>();
    private ConsoleInput consoleInput;

    public MainMenu(ArrayList<String> menuOptions, ConsoleInput consoleInput) {
        this.menuOptions = menuOptions;
        this.consoleInput = consoleInput;
    }

    public void display() {
        System.out.println("MAIN MENU");

        for (String menuOption : menuOptions) {
            System.out.println(menuOption);
        }
    }

    public void dispatch(Library library, String option) {
        if (option.equals("1")) {
            library.listBooks();
        } else if (option.equals("2")) {
            System.out.println("Enter book to be checked out:");
            System.out.println(library.checkOutBook(consoleInput));
        } else if (option.equals("3")) {
            System.out.println("Enter book to be returned:");
            System.out.println(library.returnBook(consoleInput));
        } else if (option.equals("4"))
            System.exit(0);
        else
            System.out.println("Select a valid option!");
    }
}