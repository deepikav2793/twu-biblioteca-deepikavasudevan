/*Book Library Factory creates a book library*/
package com.twu.biblioteca;

import java.util.ArrayList;

public class BookLibraryFactory {

    BookLibrary bookLibrary;

    public BookLibrary createBookLibrary() {
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));

        return new BookLibrary(availableBookList, checkedOutBookList);
    }
}