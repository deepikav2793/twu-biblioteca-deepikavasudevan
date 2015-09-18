/*Logs out the current user from the application*/
package com.twu.biblioteca;

public class LogoutMenuOption implements MainMenuOption{
    private ConsoleOutput consoleOutput;
    private User currentUser;

    public LogoutMenuOption(ConsoleOutput consoleOutput, User currentUser) {
        this.consoleOutput = consoleOutput;
        this.currentUser = currentUser;
    }

    @Override
    public User executeOptionOperation() {
        currentUser = new User("GUEST USER", "NO PASSWORD", ROLE.GUEST_USER, "NO NAME", "NO EMAIL ADDRESS", 0);
        consoleOutput.display("You are logged out");
        return currentUser;
    }
}
