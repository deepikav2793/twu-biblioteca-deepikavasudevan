/*checks out a book from book library or a movie from movie library*/
package com.twu.biblioteca;

public class CheckOutMenuOption implements MainMenuOption {
    private Library library;
    private ConsoleInput consoleInput;
    private ConsoleOutput consoleOutput;

    public CheckOutMenuOption(Library library, ConsoleInput consoleInput, ConsoleOutput consoleOutput) {
        this.library = library;
        this.consoleInput = consoleInput;
        this.consoleOutput = consoleOutput;
    }

    @Override
    public void executeOptionOperation() {
        consoleOutput.display("Enter what is to be checked out:");
        String checkOutMessage = library.checkOut(entityToBeCheckedOut());
        consoleOutput.display(checkOutMessage);
    }

    private String entityToBeCheckedOut() {
        return consoleInput.getInput();
    }
}
