/*Authenticator checks validity of username and password by comparing it with list of users*/
package com.twu.biblioteca;

import java.util.ArrayList;

public class Authenticator {
    private ArrayList<User> listOfUsers;

    public Authenticator(ArrayList<User> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    public void authenticate(String username, String password) {
        ConsoleOutput consoleOutput = new ConsoleOutput();
        for(User user : listOfUsers) {
            consoleOutput.display(user.authenticate(username, password));
        }
    }
}
