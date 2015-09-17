/*List Library displays the bookList in Book Library or movieList in Movie Library*/
package com.twu.biblioteca;

public class ListLibrary {
    private Library library;
    private ConsoleOutput consoleOutput;

    public ListLibrary(Library library, ConsoleOutput consoleOutput) {
        this.library = library;
        this.consoleOutput = consoleOutput;
    }

    public void displayList() {
        consoleOutput.display(list());
    }

    private String list() {
        return library.list();
    }
}
