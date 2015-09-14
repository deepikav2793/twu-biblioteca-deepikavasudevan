/*Library prints its list of books, checks it out and returns it*/
package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    private final String NO_AUTHOR_NAME = "";
    private final int NO_YEAR_PUBLISHED = 0;

    private ArrayList<Book> availableBookList = new ArrayList<Book>();
    private ArrayList<Book> checkedBookList = new ArrayList<Book>();

    public Library() {
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));
    }

    public void listBooks() {
        System.out.println("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION");

        for (Book book : availableBookList) {
            System.out.println(book.toString());
        }
    }

    public String checkOutBook(ConsoleInput consoleInput) {
        String thatBookName = consoleInput.getInput();
        Book thatBook = new Book(thatBookName, NO_AUTHOR_NAME, NO_YEAR_PUBLISHED);

        for (Book book : availableBookList) {
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
        Book thatBook = new Book(thatBookName, NO_AUTHOR_NAME, NO_YEAR_PUBLISHED);

        for (Book book : checkedBookList) {
            if (book.equals(thatBook)) {
                availableBookList.add(book);
                checkedBookList.remove(book);
                return "Thank you for returning the book";
            }
        }
        return "That is not a valid book to return";
    }
}