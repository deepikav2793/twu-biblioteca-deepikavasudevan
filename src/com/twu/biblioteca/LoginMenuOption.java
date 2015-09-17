/*Authenticates user name and password against list of users*/
package com.twu.biblioteca;

import java.util.ArrayList;

public class LoginMenuOption implements MainMenuOption {

    ConsoleInput consoleInput;
    ConsoleOutput consoleOutput;
    ArrayList<User> listOfUsers;
    User currentUser;

    public LoginMenuOption(ConsoleInput consoleInput, ConsoleOutput consoleOutput, ArrayList<User> listOfUsers) {
        this.consoleInput = consoleInput;
        this.consoleOutput = consoleOutput;
        this.listOfUsers = listOfUsers;
        currentUser = new User(username(), password(), ROLE.GUEST_USER);
    }

    @Override
    public void executeOptionOperation() {
        if(isAuthenticatedUser(username(), password()))
            consoleOutput.display("Login Successful");
        else
            consoleOutput.display("Login Unsuccessful");
    }

    private String username() {
        consoleOutput.display("Enter username:");
        return consoleInput.getInput();
    }

    private String password() {
        consoleOutput.display("Enter password:");
        return consoleInput.getInput();
    }

    private boolean isAuthenticatedUser(String username, String password) {
        User thatUser = new User(username, password, ROLE.GUEST_USER);
        for(User user : listOfUsers) {
            if(user.equals(thatUser))
                return true;
        }
        return false;
    }
}
