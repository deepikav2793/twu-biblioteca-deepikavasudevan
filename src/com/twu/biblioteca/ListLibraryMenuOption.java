/*List Library displays the bookList in Book Library or movieList in Movie Library*/
package com.twu.biblioteca;

public class ListLibraryMenuOption implements MainMenuOption {
    private Library library;
    private ConsoleOutput consoleOutput;
    private User currentUser;

    public ListLibraryMenuOption(Library library, ConsoleOutput consoleOutput, User currentUser) {
        this.library = library;
        this.consoleOutput = consoleOutput;
        this.currentUser = currentUser;
    }

    @Override
    public User executeOptionOperation() {
        consoleOutput.display(list());
        return currentUser;
    }

    private String list() {
        return library.list();
    }
}
