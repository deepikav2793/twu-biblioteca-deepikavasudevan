/*checks out a book from book library or a movie from movie library*/
package com.twu.biblioteca;

public class CheckOutMenuOption implements MainMenuOption {
    private Library library;
    private ConsoleInput consoleInput;
    private ConsoleOutput consoleOutput;
    private User currentUser;

    public CheckOutMenuOption(Library library, ConsoleInput consoleInput, ConsoleOutput consoleOutput, User currentUser) {
        this.library = library;
        this.consoleInput = consoleInput;
        this.consoleOutput = consoleOutput;
        this.currentUser = currentUser;
    }

    @Override
    public User executeOptionOperation() {
            consoleOutput.display("Enter what is to be checked out:");
            String checkOutMessage = library.checkOut(entityToBeCheckedOut(), currentUser);
            consoleOutput.display(checkOutMessage);

        return currentUser;
    }

    private String entityToBeCheckedOut() {
        return consoleInput.getInput();
    }
}
