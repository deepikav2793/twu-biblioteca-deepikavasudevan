/*Biblioteca Application displays Welcome Message and Main Menu*/
package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class BibliotecaApplication {
    Library library = new Library();

    public void start() {
        displayWelcomeMessage("Hello! Welcome to Bangalore Public Library!");
        ArrayList<String> menuOptions = new ArrayList<>(Arrays.asList("1. List Books", "2. Quit"));

        for (; ; ) {
            MainMenu mainMenu = new MainMenu(menuOptions);
            mainMenu.display();
            mainMenu.dispatch(library, mainMenu.option());
        }
    }

    private void displayWelcomeMessage(String welcomeMessage) {
        System.out.println(welcomeMessage);
    }

    public static void main(String[] args) {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();
        bibliotecaApplication.start();
    }
}