/*prints the user information*/
package com.twu.biblioteca;

public class UserInformationOption implements MainMenuOption {

    ConsoleOutput consoleOutput;
    User currentUser;

    public UserInformationOption(ConsoleOutput consoleOutput, User currentUser) {
        this.consoleOutput = consoleOutput;
        this.currentUser = currentUser;
    }

    @Override
    public User executeOptionOperation() {
        consoleOutput.display(currentUser.toString());
        return currentUser;
    }
}
