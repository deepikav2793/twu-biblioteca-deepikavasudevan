/*View displays data to the console and gets data from it*/
package com.twu.biblioteca;

public class BibliotecaApplication {

    String welcomeMessage = "Hello! Welcome to Bangalore Public Library!";

    public void start() {
        printWelcomeMessage();
        printListOfBooks();
    }

    public void printWelcomeMessage() {
        System.out.println(welcomeMessage);
    }

    public void printListOfBooks() {
        System.out.println ("1.Harry Potter\n2.The Fountainhead\n3.To Kill A Mockingbird");
    }
}