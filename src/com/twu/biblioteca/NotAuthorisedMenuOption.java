package com.twu.biblioteca;

public class NotAuthorisedMenuOption implements MainMenuOption {

    private User currentUser;
    private ConsoleOutput consoleOutput;

    public NotAuthorisedMenuOption(ConsoleOutput consoleOutput, User currentUser) {
        this.consoleOutput = consoleOutput;
        this.currentUser = currentUser;
    }

    @Override
    public User executeOptionOperation() {
        consoleOutput.display("NOT AUTHORISED to access this option. Please log in.");
        return currentUser;
    }
}
