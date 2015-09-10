/*Biblioteca Application */
package com.twu.biblioteca;

public class BibliotecaApplication {

    private ConsoleInput consoleInput = new ConsoleInput();
    private Library library = new Library();
    private Controller controller = new Controller();

    private void start() {
        controller.initialiseApplication(library, consoleInput);
    }

    public static void main(String[] args) {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();
        bibliotecaApplication.start();
    }
}