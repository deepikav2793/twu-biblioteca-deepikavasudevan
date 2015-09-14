/*Sets up the Biblioteca Application*/
package com.twu.biblioteca;

import java.util.ArrayList;

public class Setup {

    private ConsoleInput consoleInput = new ConsoleInput();
    private ConsoleOutput consoleOutput = new ConsoleOutput();

    public WelcomeMessage initialiseWelcomeMessage() {
        return new WelcomeMessage("Hello! Welcome to Bangalore Public Library!");
    }

    public Library initialiseLibraryWithBooks() {
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));

        return new Library(availableBookList, checkedOutBookList);
    }

    public MainMenu initialiseMainMenuWithOptions() {
        ArrayList<String> menuOptions = new ArrayList<>();
        menuOptions.add("1. List Books");
        menuOptions.add("2. Checkout Book");
        menuOptions.add("3. Return Book");
        menuOptions.add("4. List Movies");
        menuOptions.add("5. Quit");

        return new MainMenu(menuOptions, consoleInput, consoleOutput);
    }
}