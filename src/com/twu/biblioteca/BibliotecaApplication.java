/*Biblioteca Application starts the application*/
package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApplication {

    private void start() {
        User currentUser = new User("Guest User", "No Password", ROLE.GUEST_USER);
        ArrayList<User> listOfUsers = new ArrayList<>();
        listOfUsers.add(new User("lib-1000", "password", ROLE.LIBRARIAN));
        listOfUsers.add(new User("usr-1001", "password1", ROLE.AUTHENTICATED_USER));

        Controller controller = new Controller(listOfUsers, new ConsoleInputAndOutputFactory(), new BookLibraryFactory(),
                new MainMenuFactory(), new MovieLibraryFactory(), new WelcomeMessageFactory(), currentUser);

        controller.initialiseBibliotecaApplication();
    }

    public static void main(String[] args) {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();
        bibliotecaApplication.start();
    }
}