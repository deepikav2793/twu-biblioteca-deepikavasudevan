/*BookLibrary prints its list of books, checks it out and returns it*/
package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class BookLibrary implements Library {

    private final String NO_AUTHOR_NAME = "";
    private final int NO_YEAR_PUBLISHED = 0;

    private ArrayList<Book> availableBookList = new ArrayList<Book>();
    private ArrayList<Book> checkedBookList = new ArrayList<Book>();
    private HashMap<Book, User> checkedOutBookListWithUser = new HashMap<>();

    public BookLibrary(ArrayList<Book> availableBookList, ArrayList<Book> checkedBookList, HashMap<Book, User> checkedOutBookListWithUser) {
        this.availableBookList = availableBookList;
        this.checkedBookList = checkedBookList;
        this.checkedOutBookListWithUser = checkedOutBookListWithUser;
    }

    @Override
    public String list() {
        String listOfBooks = String.format("%-30s%-30s%-15s\n", "NAME OF BOOK", "NAME OF AUTHOR",
                "YEAR OF PUBLICATION");
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
                checkedOutBookListWithUser.put(book, currentUser);
                availableBookList.remove(book);
                checkOutMessage = "Thank you! Enjoy the book";
                break;
            }
        }
        return checkOutMessage;
    }

    public String returnBook(String thatBookName, User currentUser) {
        String returnMessage = "That is not a valid book to return";
        Book thatBook = new Book(thatBookName, NO_AUTHOR_NAME, NO_YEAR_PUBLISHED);

        for (Book book : checkedBookList) {
            if (book.equals(thatBook)) {
                if(currentUser.equals(checkedOutBookListWithUser.get(book))) {
                    availableBookList.add(book);
                    checkedOutBookListWithUser.remove(book);
                    checkedBookList.remove(book);
                    returnMessage = "Thank you for returning the book";
                    break;
                }
            }
        }
        return returnMessage;
    }

    public String checkedOutBookListWithUser() {
        String formattedCheckedOutBookListWithUser = String.format("%-30s%-30s%-15s%-20s\n", "NAME OF BOOK", "NAME OF AUTHOR",
                "YEAR OF PUBLICATION", "USER LIBRARY NUMBER");
        for (Book book : checkedOutBookListWithUser.keySet()) {
            formattedCheckedOutBookListWithUser += String.format("%-75s%-20s\n", book.toString(),
                    checkedOutBookListWithUser.get(book).getLibraryNumber());
        }
        return formattedCheckedOutBookListWithUser;
    }
}