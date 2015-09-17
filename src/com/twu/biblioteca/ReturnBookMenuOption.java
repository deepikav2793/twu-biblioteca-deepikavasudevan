/*gets book to return and returns it to book library*/
package com.twu.biblioteca;

public class ReturnBookMenuOption {
    private BookLibrary bookLibrary;
    private ConsoleInput consoleInput;
    private ConsoleOutput consoleOutput;

    public ReturnBookMenuOption(BookLibrary bookLibrary, ConsoleInput consoleInput, ConsoleOutput consoleOutput) {
        this.bookLibrary = bookLibrary;
        this.consoleInput = consoleInput;
        this.consoleOutput = consoleOutput;
    }

    public void executeOptionOperation() {
        consoleOutput.display("Enter book to be returned:");
        String returnMessage =bookLibrary.returnBook(bookToBeReturned());
        consoleOutput.display(returnMessage);
    }

    private String bookToBeReturned() {
        return consoleInput.getInput();
    }
}
