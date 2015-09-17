/*Quits the application*/
package com.twu.biblioteca;

public class QuitMenuOption implements MainMenuOption {

    private User currentUser;

    public QuitMenuOption(User currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public User executeOptionOperation() {
        System.exit(0);
        return currentUser;
    }
}
