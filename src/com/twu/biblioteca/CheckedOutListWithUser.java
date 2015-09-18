/*Prints checked out list with user library number*/
package com.twu.biblioteca;

public class CheckedOutListWithUser implements MainMenuOption {

    private BookLibrary bookLibrary;
    private ConsoleOutput consoleOutput;
    private User currentUser;

    public CheckedOutListWithUser(BookLibrary bookLibrary, ConsoleOutput consoleOutput, User currentUser) {
        this.bookLibrary = bookLibrary;
        this.consoleOutput = consoleOutput;
        this.currentUser = currentUser;
    }

    @Override
    public User executeOptionOperation() {
        consoleOutput.display(bookLibrary.checkedOutBookListWithUser());
        return currentUser;
    }
}
