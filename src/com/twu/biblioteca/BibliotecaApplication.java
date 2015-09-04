/*Biblioteca Application*/
package com.twu.biblioteca;

public class BibliotecaApplication {

    String welcomeMessage = "Hello! Welcome to Bangalore Public Library!";

    public void start() {
        displayWelcomeMessage();
        displayListOfBooks();
    }

    private void displayWelcomeMessage() {
        System.out.println(welcomeMessage);
    }

    private void displayListOfBooks() {
        System.out.println("1.Harry Potter\n2.The Fountainhead\n3.To Kill A Mockingbird");
    }
}