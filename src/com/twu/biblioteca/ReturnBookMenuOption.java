/*gets book to return and returns it to book library*/
package com.twu.biblioteca;

public class ReturnBookMenuOption implements MainMenuOption {

    private BookLibrary bookLibrary;
    private ConsoleInput consoleInput;
    private ConsoleOutput consoleOutput;
    private User currentUser;

    public ReturnBookMenuOption(BookLibrary bookLibrary, ConsoleInput consoleInput, ConsoleOutput consoleOutput, User currentUser) {
        this.bookLibrary = bookLibrary;
        this.consoleInput = consoleInput;
        this.consoleOutput = consoleOutput;
        this.currentUser = currentUser;
    }

    @Override
    public User executeOptionOperation() {
        consoleOutput.display("Enter book to be returned:");
        String returnMessage =bookLibrary.returnBook(bookToBeReturned());
        consoleOutput.display(returnMessage);
        return currentUser;
    }

    private String bookToBeReturned() {
        return consoleInput.getInput();
    }
}
