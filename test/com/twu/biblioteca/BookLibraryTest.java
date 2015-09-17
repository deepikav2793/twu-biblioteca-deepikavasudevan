package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class BookLibraryTest {

    @Test
    public void shouldPrintListOfBooksInColumnFormat() {
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));
        HashMap<Book, User> checkedOutBookListWithUser = new HashMap<Book, User>();
        BookLibrary bookLibrary = new BookLibrary(availableBookList, checkedOutBookList, checkedOutBookListWithUser);

        assertEquals("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\nGone Girl\tGillian Flynn\t" +
                "2000\nThe Scarlett Letter\tNathaniel Hawthorne\t1850\n", bookLibrary.list());
    }

    @Test
    public void shouldCheckOutTheBookSpecifiedByTheUser() {
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));
        HashMap<Book, User> checkedOutBookListWithUser = new HashMap<Book, User>();
        BookLibrary bookLibrary = new BookLibrary(availableBookList, checkedOutBookList, checkedOutBookListWithUser);
        User currentUser = new User("Guest User", "No Password", ROLE.AUTHENTICATED_USER);

        assertEquals("Thank you! Enjoy the book", bookLibrary.checkOut("Gone Girl", currentUser));
    }

    @Test
    public void shouldNotHaveCheckedOutBookInUpdatedBookList() {
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));
        HashMap<Book, User> checkedOutBookListWithUser = new HashMap<Book, User>();
        BookLibrary bookLibrary = new BookLibrary(availableBookList, checkedOutBookList, checkedOutBookListWithUser);
        User currentUser = new User("Guest User", "No Password", ROLE.AUTHENTICATED_USER);
        bookLibrary.checkOut("Gone Girl", currentUser);

        assertEquals("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\n" +
                "The Scarlett Letter\tNathaniel Hawthorne\t1850\n", bookLibrary.list());
    }

    @Test
    public void shouldNotCheckOutBookSpecifiedByUserIfNotFoundInLibrary() {
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));
        HashMap<Book, User> checkedOutBookListWithUser = new HashMap<Book, User>();
        BookLibrary bookLibrary = new BookLibrary(checkedOutBookList, availableBookList, checkedOutBookListWithUser);
        User currentUser = new User("Guest User", "No Password", ROLE.AUTHENTICATED_USER);

        assertEquals("That book is not available", bookLibrary.checkOut("Goner Girl", currentUser));
    }

    @Test
    public void shouldReturnBookIfItHasBeenCheckedOut() {
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        checkedOutBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));
        HashMap<Book, User> checkedOutBookListWithUser = new HashMap<Book, User>();
        checkedOutBookListWithUser.put(new Book("Gone Girl", "Gillian Flynn", 2000),
                new User("Guest User", "No Password", ROLE.AUTHENTICATED_USER));
        BookLibrary bookLibrary = new BookLibrary(availableBookList, checkedOutBookList, checkedOutBookListWithUser);
        User currentUser = new User("Guest User", "No Password", ROLE.AUTHENTICATED_USER);

        assertEquals("Thank you for returning the book", bookLibrary.returnBook("Gone Girl", currentUser));
    }

    @Test
    public void shouldHaveReturnedBookInListOfBooks() {
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        checkedOutBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));
        HashMap<Book, User> checkedOutBookListWithUser = new HashMap<Book, User>();
        checkedOutBookListWithUser.put(new Book("Gone Girl", "Gillian Flynn", 2000),
                new User("Guest User", "No Password", ROLE.AUTHENTICATED_USER));
        BookLibrary bookLibrary = new BookLibrary(availableBookList, checkedOutBookList, checkedOutBookListWithUser);
        User currentUser = new User("Guest User", "No Password", ROLE.AUTHENTICATED_USER);
        bookLibrary.returnBook("Gone Girl", currentUser);

        assertEquals("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\n" +
                "The Scarlett Letter\tNathaniel Hawthorne\t1850\nGone Girl\tGillian Flynn\t2000\n", bookLibrary.list());
    }

    @Test
    public void shouldNotReturnBookIfItHasNotBeenCheckedOut() {
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));
        HashMap<Book, User> checkedOutBookListWithUser = new HashMap<Book, User>();
        BookLibrary bookLibrary = new BookLibrary(availableBookList, checkedOutBookList, checkedOutBookListWithUser);
        User currentUser = new User("Guest User", "No Password", ROLE.AUTHENTICATED_USER);

        assertEquals("That is not a valid book to return", bookLibrary.returnBook("Gone Girl", currentUser));
    }

    @Test
    public void shouldNotReturnBookIfBookHasBeenCheckedOutButNotByTheSameUser() {
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));
        HashMap<Book, User> checkedOutBookListWithUser = new HashMap<Book, User>();
        checkedOutBookListWithUser.put(new Book("Gone Girl", "Gillian Flynn", 2000),
                new User("usr-1001", "password1", ROLE.AUTHENTICATED_USER));
        BookLibrary bookLibrary = new BookLibrary(availableBookList, checkedOutBookList, checkedOutBookListWithUser);
        User currentUser = new User("Guest User", "No Password", ROLE.AUTHENTICATED_USER);

        assertEquals("That is not a valid book to return", bookLibrary.returnBook("Gone Girl", currentUser));
    }

    @Test
    public void shouldNotReturnBookIfBookHasNotBeenCheckedOutButUserHasCheckedOutSomeOtherBook() {
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));
        HashMap<Book, User> checkedOutBookListWithUser = new HashMap<Book, User>();
        checkedOutBookListWithUser.put(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850),
                new User("usr-1001", "password1", ROLE.AUTHENTICATED_USER));
        BookLibrary bookLibrary = new BookLibrary(availableBookList, checkedOutBookList, checkedOutBookListWithUser);
        User currentUser = new User("usr-1001", "password1", ROLE.AUTHENTICATED_USER);

        assertEquals("That is not a valid book to return", bookLibrary.returnBook("Gone Girl", currentUser));
    }
}