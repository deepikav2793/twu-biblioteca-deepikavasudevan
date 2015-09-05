/*Book List prints its list of books in column format*/
package com.twu.biblioteca;

import java.util.ArrayList;

public class BookList {
    ArrayList<Book> bookList = new ArrayList<Book>();

    BookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    void print() {
        System.out.println("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION");

        for (Book book : bookList) {
            System.out.println(book.toString());
        }
    }
}
