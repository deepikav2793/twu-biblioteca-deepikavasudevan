/*Creates Welcome Message object*/
package com.twu.biblioteca;

public class WelcomeMessageFactory {

    private WelcomeMessage welcomeMessage;

    public WelcomeMessage createWelcomeMessage() {
        welcomeMessage = new WelcomeMessage("Hello! Welcome to Bangalore Public Library!");

        return welcomeMessage;
    }
}