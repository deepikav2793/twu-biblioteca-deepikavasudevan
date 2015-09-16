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

    public String mainMenuOptions() {
        String mainMenuOptions = "MAIN MENU\n";

        for (String menuOption : menuOptions) {
            mainMenuOptions += menuOption +"\n";
        }

        return mainMenuOptions;
    }

    public void dispatch(BookLibrary bookLibrary, MovieLibrary movieLibrary, String option) {
        if (option.equals("2")) {
            consoleOutput.display(bookLibrary.listOfBooks());
        } else if (option.equals("3")) {
            consoleOutput.display("Enter book to be checked out:");
            consoleOutput.display(bookLibrary.checkOutBook(consoleInput.getInput()));
        } else if (option.equals("4")) {
            consoleOutput.display("Enter book to be returned:");
            consoleOutput.display(bookLibrary.returnBook(consoleInput.getInput()));
        } else if (option.equals("5")) {
            consoleOutput.display(movieLibrary.listOfMovies());
        } else if (option.equals("6")) {
            consoleOutput.display("Enter movie to be checked out:");
            consoleOutput.display(movieLibrary.checkOutMovie(consoleInput.getInput()));
        } else if (option.equals("9"))
            System.exit(0);
        else
             consoleOutput.display("Select a valid option!");
    }
}