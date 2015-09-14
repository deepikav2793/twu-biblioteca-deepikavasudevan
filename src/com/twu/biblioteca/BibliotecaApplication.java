/*Biblioteca Application */
package com.twu.biblioteca;

public class BibliotecaApplication {

    private Controller controller = new Controller();

    private void start() {
        controller.initialiseApplication();
    }

    public static void main(String[] args) {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();
        bibliotecaApplication.start();
    }
}