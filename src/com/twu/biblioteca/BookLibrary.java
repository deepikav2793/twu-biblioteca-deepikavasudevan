/*BookLibrary prints its list of books, checks it out and returns it*/
package com.twu.biblioteca;

import java.util.ArrayList;

public class BookLibrary implements Library {

    private final String NO_AUTHOR_NAME = "";
    private final int NO_YEAR_PUBLISHED = 0;

    private ArrayList<Book> availableBookList = new ArrayList<Book>();
    private ArrayList<Book> checkedBookList = new ArrayList<Book>();

    public BookLibrary(ArrayList<Book> availableBookList, ArrayList<Book> checkedBookList) {
        this.availableBookList = availableBookList;
        this.checkedBookList = checkedBookList;
    }

    @Override
    public String list() {
        String listOfBooks = "NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\n";
        for (Book book : availableBookList) {
            listOfBooks += book.toString() + "\n";
        }
        return listOfBooks;
    }

    @Override
    public String checkOut(String thatBookName, User currentUser) {
        String checkOutMessage = "That book is not available";
        Book thatBook = new Book(thatBookName, NO_AUTHOR_NAME, NO_YEAR_PUBLISHED);

        for (Book book : availableBookList) {
            if (book.equals(thatBook)) {
                checkedBookList.add(book);
                availableBookList.remove(book);
                checkOutMessage = "Thank you! Enjoy the book";
                break;
            }
        }
       return checkOutMessage;
    }

    public String returnBook(String thatBookName) {
        String returnMessage = "That is not a valid book to return";
        Book thatBook = new Book(thatBookName, NO_AUTHOR_NAME, NO_YEAR_PUBLISHED);

        for (Book book : checkedBookList) {
            if (book.equals(thatBook)) {
                availableBookList.add(book);
                checkedBookList.remove(book);
                returnMessage = "Thank you for returning the book";
                break;
            }
        }
        return returnMessage;
    }
}