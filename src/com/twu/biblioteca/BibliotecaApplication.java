/*Biblioteca Application*/
package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class BibliotecaApplication {

    ArrayList<Book> listOfBooks = new ArrayList<>(Arrays.asList(new Book("Gone Girl", "Gillian Flynn", 2009),
            new Book("The FountainHead", "Ayn Rand", 1964), new Book("Swann's Way", "Marcel Proust", 1867)));
    BookList bookList = new BookList(listOfBooks);

    public void start() {
        displayWelcomeMessage("Hello! Welcome to Bangalore Public Library!");
        bookList.display();
    }

    private void displayWelcomeMessage(String welcomeMessage) {
        System.out.println(welcomeMessage);
    }

    public static void main(String[] args) {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();
        bibliotecaApplication.start();
    }
}