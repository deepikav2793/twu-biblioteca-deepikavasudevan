/*Biblioteca Application displays Welcome Message and invokes Main Menu repeatedly*/
package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class BibliotecaApplication {

    Library library = new Library();
    Controller controller = new Controller();

    public void start() {
        controller.displayWelcomeMessage();
        MainMenu mainMenu = controller.initialiseMainMenuWithOptions();

        for (; ; ) {
            mainMenu.dispatch(library, "1");
        }
    }

    public static void main(String[] args) {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();
        bibliotecaApplication.start();
    }
}