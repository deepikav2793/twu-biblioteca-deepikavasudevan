/*Biblioteca Application displays Welcome Message and invokes Main Menu repeatedly*/
package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class BibliotecaApplication {

    Library library = new Library();
    WelcomeMessage welcomeMessage = new WelcomeMessage();
    ArrayList<String> menuOptions = new ArrayList<>(Arrays.asList("1. List Books", "2. Check Out", "Quit"));
    ConsoleInput consoleInput = new ConsoleInput();
    MainMenu mainMenu =  new MainMenu(menuOptions, consoleInput);

    public void start() {
        welcomeMessage.display();

        for (; ; ) {
            mainMenu.display();
            mainMenu.dispatch(library);
        }
    }

    public static void main(String[] args) {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();
        bibliotecaApplication.start();
    }
}