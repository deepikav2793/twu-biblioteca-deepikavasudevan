/*Quits the application*/
package com.twu.biblioteca;

public class QuitMenuOption implements MainMenuOption {

    @Override
    public void executeOptionOperation() {
        System.exit(0);
    }
}
