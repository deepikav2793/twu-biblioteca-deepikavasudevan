/*Biblioteca Application*/
package com.twu.biblioteca;

public class BibliotecaApplication {

    public void start() {
        displayWelcomeMessage("Hello! Welcome to Bangalore Public Library!");
        displayListOfBooks();
    }

    private void displayWelcomeMessage(String welcomeMessage) {
        System.out.println(welcomeMessage);
    }

    private void displayListOfBooks() {
        System.out.println("1.Harry Potter\n2.The Fountainhead\n3.To Kill A Mockingbird");
    }
}