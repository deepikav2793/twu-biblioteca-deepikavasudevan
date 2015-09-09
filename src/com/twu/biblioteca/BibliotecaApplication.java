/*Biblioteca Application displays Welcome Message and invokes Main Menu repeatedly*/
package com.twu.biblioteca;

public class BibliotecaApplication {

    ConsoleInput consoleInput = new ConsoleInput();
    Library library = new Library();
    Controller controller = new Controller();

    public void start() {
        controller.initialiseApplication(library, consoleInput);
    }

    public static void main(String[] args) {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();
        bibliotecaApplication.start();
    }
}