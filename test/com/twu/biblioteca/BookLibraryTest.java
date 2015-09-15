package com.twu.biblioteca;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BookLibraryTest {

    @Test
    public void shouldPrintListOfBooksInColumnFormat() {
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));
        BookLibrary bookLibrary = new BookLibrary(availableBookList, checkedOutBookList);

        assertEquals("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\nGone Girl\tGillian Flynn\t" +
                "2000\nThe Scarlett Letter\tNathaniel Hawthorne\t1850\n", bookLibrary.listOfBooks());
    }

    @Test
    public void shouldCheckOutTheBookSpecifiedByTheUser() {
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));
        BookLibrary bookLibrary = new BookLibrary(availableBookList, checkedOutBookList);

        assertEquals("Thank you! Enjoy the book", bookLibrary.checkOutBook("Gone Girl"));
    }

    @Test
    public void shouldNotHaveCheckedOutBookInUpdatedBookList() {
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));
        BookLibrary bookLibrary = new BookLibrary(availableBookList, checkedOutBookList);

        bookLibrary.checkOutBook("Gone Girl");

        assertEquals("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\n" +
                "The Scarlett Letter\tNathaniel Hawthorne\t1850\n", bookLibrary.listOfBooks());
    }

    @Test
    public void shouldNotCheckOutBookSpecifiedByUserIfNotFoundInLibrary() {
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));
        BookLibrary bookLibrary = new BookLibrary(checkedOutBookList, availableBookList);

        assertEquals("That book is not available", bookLibrary.checkOutBook("Goner Girl"));
    }

    @Test
    public void shouldReturnBookIfItHasBeenCheckedOut() {
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        checkedOutBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));
        BookLibrary bookLibrary = new BookLibrary(availableBookList, checkedOutBookList);

        assertEquals("Thank you for returning the book", bookLibrary.returnBook("Gone Girl"));
    }

    @Test
    public void shouldHaveReturnedBookInListOfBooks() {
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        checkedOutBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));
        BookLibrary bookLibrary = new BookLibrary(availableBookList, checkedOutBookList);

        bookLibrary.returnBook("Gone Girl");

        assertEquals("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\n" +
                "The Scarlett Letter\tNathaniel Hawthorne\t1850\nGone Girl\tGillian Flynn\t2000\n", bookLibrary.listOfBooks());
    }

    @Test
    public void shouldNotReturnBookIfItHasNotBeenCheckedOut() {
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));
        BookLibrary bookLibrary = new BookLibrary(availableBookList, checkedOutBookList);

        assertEquals("That is not a valid book to return", bookLibrary.returnBook("Gone Girl"));
    }
}