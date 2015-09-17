/*checks out a book from book library or a movie from movie library*/
package com.twu.biblioteca;

public class CheckOutMenuOption {
    private Library library;
    private ConsoleInput consoleInput;
    private ConsoleOutput consoleOutput;

    public CheckOutMenuOption(Library library, ConsoleInput consoleInput, ConsoleOutput consoleOutput) {
        this.library = library;
        this.consoleInput = consoleInput;
        this.consoleOutput = consoleOutput;
    }

    public void checkOut() {
        String checkOutMessage = library.checkOut(entityToBeCheckedOut());
    }

    private String entityToBeCheckedOut() {
        return consoleInput.getInput();
    }
}
