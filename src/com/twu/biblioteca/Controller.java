/*Controls flow of Biblioteca*/
package com.twu.biblioteca;

import java.util.ArrayList;

public class Controller {

    private ConsoleInput consoleInput;
    private ConsoleOutput consoleOutput;

    public Controller() {
        consoleInput = new ConsoleInput();
        consoleOutput = new ConsoleOutput();
    }

    public void displayWelcomeMessage() {
        WelcomeMessage welcomeMessage = new WelcomeMessage("Hello! Welcome to Bangalore Public Library!");
        welcomeMessage.display(consoleOutput);
    }

    protected Library initialiseLibraryWithBooks() {
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));

        return new Library(availableBookList, checkedOutBookList);
    }

    private MainMenu initialiseMainMenuWithOptions() {
        ArrayList<String> menuOptions = new ArrayList<>();
        menuOptions.add("1. List Books");
        menuOptions.add("2. Checkout Book");
        menuOptions.add("3. Return Book");
        menuOptions.add("4. Quit");

        return new MainMenu(menuOptions, consoleInput, consoleOutput);
    }

    public void displayMenuOptions() {
        MainMenu mainMenu = initialiseMainMenuWithOptions();
        mainMenu.mainMenuOptions();
    }

    public void initialiseMenuDispatch(Library library, ConsoleInput consoleInput) {
        MainMenu mainMenu = initialiseMainMenuWithOptions();
        mainMenu.dispatch(library, consoleInput.getInput());
    }

    public void initialiseApplication() {
        Library library = initialiseLibraryWithBooks();
        displayWelcomeMessage();
        for (; ; ) {
            displayMenuOptions();
            initialiseMenuDispatch(library, consoleInput);
        }
    }
}