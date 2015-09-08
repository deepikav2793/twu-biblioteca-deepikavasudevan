/*Biblioteca Application displays Welcome Message and Main Menu*/
package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class BibliotecaApplication {

    Library library = new Library();
    ArrayList<String> menuOptions = new ArrayList<>(Arrays.asList("1. List Books", "2. Check Out", "Quit"));
    ConsoleInput consoleInput = new ConsoleInput();
    MainMenu mainMenu = new MainMenu(menuOptions, consoleInput);

    public void start() {
        displayWelcomeMessage("Hello! Welcome to Bangalore Public Library!");

        for (; ; ) {
            mainMenu.display();
            mainMenu.dispatch(library, consoleInput.getInput());
        }
    }

    public void displayWelcomeMessage(String welcomeMessage) {
        System.out.println(welcomeMessage);
    }

    public static void main(String[] args) {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();
        bibliotecaApplication.start();
    }
}