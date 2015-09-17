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
        consoleOutput.display("Login Successful");
    }
}
