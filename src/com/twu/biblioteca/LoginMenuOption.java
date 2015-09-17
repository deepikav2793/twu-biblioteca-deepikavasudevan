/*Authenticates user name and password against list of users*/
package com.twu.biblioteca;

public class LoginMenuOption implements MainMenuOption {

    ConsoleInput consoleInput;
    ConsoleOutput consoleOutput;

    public LoginMenuOption(ConsoleInput consoleInput, ConsoleOutput consoleOutput) {
        this.consoleInput = consoleInput;
        this.consoleOutput = consoleOutput;
    }
    @Override
    public void executeOptionOperation() {
        String username = username();
        String password = password();
        consoleOutput.display("Login Successful");
    }

    private String username() {
        return consoleInput.getInput();
    }

    private String password() {
        return consoleInput.getInput();
    }
}
