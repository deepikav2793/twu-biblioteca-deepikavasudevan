package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    @Test
    public void shouldPrintListOfBooksInColumnFormat() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));

        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));

        Library library = new Library(availableBookList, checkedOutBookList);

        assertEquals("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\nGone Girl\tGillian Flynn\t" +
                "2000\nThe Scarlett Letter\tNathaniel Hawthorne\t1850\n", library.listOfBooks());
    }

    @Test
    public void shouldCheckOutTheBookSpecifiedByTheUser() {
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));

        Library library = new Library(availableBookList, checkedOutBookList);

        assertEquals("Thank you! Enjoy the book", library.checkOutBook("Gone Girl"));
    }

    @Test
    public void shouldNotHaveCheckedOutBookInUpdatedBookList() {
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));

        Library library = new Library(availableBookList, checkedOutBookList);

        library.checkOutBook("Gone Girl");

        assertEquals("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\n" +
                "The Scarlett Letter\tNathaniel Hawthorne\t1850\n", library.listOfBooks());
    }

    @Test
    public void shouldNotCheckOutBookSpecifiedByUserIfNotFoundInLibrary() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));

        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));

        Library library = new Library(checkedOutBookList, availableBookList);

        assertEquals("That book is not available", library.checkOutBook("Goner Girl"));
    }

    @Test
    public void shouldReturnBookIfItHasBeenCheckedOut() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));

        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        checkedOutBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));

        Library library = new Library(availableBookList, checkedOutBookList);

        assertEquals("Thank you for returning the book", library.returnBook("Gone Girl"));
    }

    @Test
    public void shouldHaveReturnedBookInListOfBooks() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        checkedOutBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));

        Library library = new Library(availableBookList, checkedOutBookList);

        library.returnBook("Gone Girl");

        assertEquals("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\n" +
                "The Scarlett Letter\tNathaniel Hawthorne\t1850\nGone Girl\tGillian Flynn\t2000\n", library.listOfBooks());
    }

    @Test
    public void shouldNotReturnBookIfItHasNotBeenCheckedOut() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));

        Library library = new Library(availableBookList, checkedOutBookList);

        assertEquals("That is not a valid book to return", library.returnBook("Gone Girl"));
    }
}