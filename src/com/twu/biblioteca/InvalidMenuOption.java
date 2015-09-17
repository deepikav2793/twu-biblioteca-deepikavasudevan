/*Invalid Menu option prints invalid message to console*/
package com.twu.biblioteca;

public class InvalidMenuOption implements MainMenuOption {
    private ConsoleOutput consoleOutput;

    public InvalidMenuOption(ConsoleOutput consoleOutput) {
        this.consoleOutput = consoleOutput;
    }

    @Override
    public void executeOptionOperation() {
        String invalidMessage = "Select a valid option!";
        consoleOutput.display(invalidMessage);
    }
}
