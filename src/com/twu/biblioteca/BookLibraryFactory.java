/*Book Library Factory creates a book library*/
package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class BookLibraryFactory {

    private BookLibrary bookLibrary;

    public BookLibrary createBookLibrary() {
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));
        HashMap<Book, User> checkedOutBookListWithUser = new HashMap<Book, User>();

        bookLibrary = new BookLibrary(availableBookList, checkedOutBookList, checkedOutBookListWithUser);
        return bookLibrary;
    }
}