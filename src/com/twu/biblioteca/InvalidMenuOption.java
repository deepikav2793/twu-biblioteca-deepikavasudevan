/*Invalid Menu option prints invalid message to console*/
package com.twu.biblioteca;

public class InvalidMenuOption implements MainMenuOption {
    private ConsoleOutput consoleOutput;
    private User currentUser;

    public InvalidMenuOption(ConsoleOutput consoleOutput, User currentUser) {
        this.consoleOutput = consoleOutput;
        this.currentUser = currentUser;
    }

    @Override
    public User executeOptionOperation() {
        String invalidMessage = "Select a valid option!";
        consoleOutput.display(invalidMessage);
        return currentUser;
    }
}
