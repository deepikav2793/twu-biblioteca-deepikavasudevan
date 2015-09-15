/*Biblioteca Application starts the application*/
package com.twu.biblioteca;

public class BibliotecaApplication {

    private Controller controller = new Controller();

    private void start() {
        controller.initialiseBibliotecaApplication();
    }

    public static void main(String[] args) {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();
        bibliotecaApplication.start();
    }
}