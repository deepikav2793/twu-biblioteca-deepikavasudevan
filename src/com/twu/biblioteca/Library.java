/*Book List prints its list of books in column format*/
package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    ArrayList<Book> availableBookList = new ArrayList<Book>();

    Library() {
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
    }

    void listBooks() {
        System.out.println("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION");

        for (Book book : availableBookList) {
            System.out.println(book.toString());
        }
    }

    public String checkOut() {
        return "Thank you! Enjoy the book";
    }
}