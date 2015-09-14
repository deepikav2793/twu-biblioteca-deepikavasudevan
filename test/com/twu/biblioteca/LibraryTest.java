package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        ConsoleOutput consoleOutput = new ConsoleOutput();
        library.listBooks(consoleOutput);

        assertEquals("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\nGone Girl\tGillian Flynn\t" +
                "2000\nThe Scarlett Letter\tNathaniel Hawthorne\t1850\n\n", outputContent.toString());
    }

    @Test
    public void shouldCheckOutTheBookSpecifiedByTheUser() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));

        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));

        Library library = new Library(availableBookList, checkedOutBookList);
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        ConsoleOutput consoleOutput = new ConsoleOutput();

        when(consoleInput.getInput()).thenReturn("Gone Girl");
        library.checkOutBook(consoleInput, consoleOutput);

        assertEquals("Thank you! Enjoy the book\n", outputContent.toString());
    }

    @Test
    public void shouldNotHaveCheckedOutBookInUpdatedBookList() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));

        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));

        Library library = new Library(availableBookList, checkedOutBookList);
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        ConsoleOutput consoleOutput = new ConsoleOutput();

        when(consoleInput.getInput()).thenReturn("Gone Girl");

        library.checkOutBook(consoleInput, consoleOutput);
        library.listBooks(consoleOutput);

        assertEquals("Thank you! Enjoy the book\nNAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\n" +
                "The Scarlett Letter\tNathaniel Hawthorne\t1850\n\n", outputContent.toString());
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
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        ConsoleOutput consoleOutput = new ConsoleOutput();

        when(consoleInput.getInput()).thenReturn("Goner Girl");
        library.checkOutBook(consoleInput, consoleOutput);

        assertEquals("That book is not available\n", outputContent.toString());
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
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        ConsoleOutput consoleOutput = new ConsoleOutput();

        when(consoleInput.getInput()).thenReturn("Gone Girl");
        library.returnBook(consoleInput, consoleOutput);

        assertEquals("Thank you for returning the book\n", outputContent.toString());
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
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        ConsoleOutput consoleOutput = new ConsoleOutput();

        when(consoleInput.getInput()).thenReturn("Gone Girl");

        library.returnBook(consoleInput, consoleOutput);
        library.listBooks(consoleOutput);

        assertEquals("Thank you for returning the book\nNAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\n" +
                "The Scarlett Letter\tNathaniel Hawthorne\t1850\nGone Girl\tGillian Flynn\t2000\n\n", outputContent.toString());
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
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        ConsoleOutput consoleOutput = new ConsoleOutput();

        when(consoleInput.getInput()).thenReturn("Gone Girl");
        library.returnBook(consoleInput, consoleOutput);

        assertEquals("That is not a valid book to return\n", outputContent.toString());
    }
}