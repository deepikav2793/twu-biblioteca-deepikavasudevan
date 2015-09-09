/*Library prints its list of books and checks out book*/
package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    private final String NO_AUTHOR_NAME = "";
    private final int NO_YEAR_OF_PUBLICATION = 0;

    ArrayList<Book> availableBookList = new ArrayList<Book>();
    ArrayList<Book> checkedBookList = new ArrayList<Book>();

    Library() {
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter","Nathaniel Hawthorne", 1850));
    }

    void listBooks() {
        System.out.println("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION");

        for (Book book : availableBookList) {
            System.out.println(book.toString());
        }
    }

    public String checkOutBook(ConsoleInput consoleInput) {
        String thatBookName = consoleInput.getInput();
        Book thatBook = new Book(thatBookName, NO_AUTHOR_NAME, NO_YEAR_OF_PUBLICATION);

        for(Book book : availableBookList) {
            if (book.equals(thatBook)) {
                checkedBookList.add(book);
                availableBookList.remove(book);
                return "Thank you! Enjoy the book";
            }
        }
        return "That book is not available";
    }

    public String returnBook(ConsoleInput consoleInput) {
        String thatBookName = consoleInput.getInput();
        Book thatBook = new Book(thatBookName, NO_AUTHOR_NAME, NO_YEAR_OF_PUBLICATION);

        for (Book book : checkedBookList) {
            if(book.equals(thatBook)) {
                availableBookList.add(book);
                checkedBookList.remove(book);
            }
        }
        return "Thank you for returning the book";
    }
}