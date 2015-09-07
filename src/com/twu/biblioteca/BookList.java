/*Book List prints its list of books in column format*/
package com.twu.biblioteca;

import java.util.ArrayList;

public class BookList {
    ArrayList<Book> bookList = new ArrayList<Book>();

    BookList() {
        bookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        bookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
    }

    void display() {
        System.out.println("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION");

        for (Book book : bookList) {
            System.out.println(book.toString());
        }
    }
}