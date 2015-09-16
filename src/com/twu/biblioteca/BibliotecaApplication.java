/*Biblioteca Application starts the application*/
package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApplication {

    private void start() {
        ArrayList<User> listOfUsers = new ArrayList<>();
        listOfUsers.add(new User("lib-1000", "password", "LIBRARIAN"));
        listOfUsers.add(new User("usr-1001", "password1", "USER"));
        Controller controller = new Controller(listOfUsers);
        controller.initialiseBibliotecaApplication();
    }

    public static void main(String[] args) {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();
        bibliotecaApplication.start();
    }
}