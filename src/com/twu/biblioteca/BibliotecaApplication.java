/*Biblioteca Application starts the application*/
package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApplication {

    private void start() {
        ArrayList<User> listOfUsers = new ArrayList<>();
        listOfUsers.add(new User("lib-1000", "password", ROLE.LIBRARIAN));
        listOfUsers.add(new User("usr-1001", "password1", ROLE.AUTHENTICATED_USER));

        Controller controller = new Controller(listOfUsers, new Factory(), new BookLibraryFactory(), new MainMenuFactory());

        controller.initialiseBibliotecaApplication();
    }

    public static void main(String[] args) {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();
        bibliotecaApplication.start();
    }
}