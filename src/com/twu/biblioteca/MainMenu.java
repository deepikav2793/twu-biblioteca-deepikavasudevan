/*Main Menu shows list of options from which the option chosen by the user is dispatched*/
package com.twu.biblioteca;

import java.util.ArrayList;

public class MainMenu {

    private ArrayList<String> menuOptions = new ArrayList<String>();
    private ConsoleInput consoleInput;
    private ConsoleOutput consoleOutput;

    public MainMenu(ArrayList<String> menuOptions, ConsoleInput consoleInput, ConsoleOutput consoleOutput) {
        this.menuOptions = menuOptions;
        this.consoleInput = consoleInput;
        this.consoleOutput = consoleOutput;
    }

    public void mainMenuOptions() {
        String mainMenuOptions = "MAIN MENU\n";

        for (String menuOption : menuOptions) {
            mainMenuOptions += menuOption +"\n";
        }

        consoleOutput.display(mainMenuOptions);
    }

    public void dispatch(Library library, String option) {
        if (option.equals("1")) {
            library.listBooks(consoleOutput);
        } else if (option.equals("2")) {
            consoleOutput.display("Enter book to be checked out:");
            library.checkOutBook(consoleInput, consoleOutput);
        } else if (option.equals("3")) {
            consoleOutput.display("Enter book to be returned:");
            library.returnBook(consoleInput, consoleOutput);
        } else if (option.equals("4"))
            System.exit(0);
        else
            consoleOutput.display("Select a valid option!");
    }
}