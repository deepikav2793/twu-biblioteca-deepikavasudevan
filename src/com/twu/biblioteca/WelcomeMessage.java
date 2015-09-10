/*Welcome Message prints the welcome message*/
package com.twu.biblioteca;

public class WelcomeMessage {
    private String welcomeMessage;

    public WelcomeMessage() {
        welcomeMessage = "Hello! Welcome to Bangalore Public Library!";
    }

    public void display() {
        System.out.println(welcomeMessage);
    }
}
