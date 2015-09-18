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
        String formattedListOfBooks = String.format("%-30s%-30s%-15s\n", "NAME OF BOOK", "NAME OF AUTHOR", "YEAR OF PUBLICATION")
                + String.format("%-30s%-30s%-15s\n", "To Kill A Mockingbird", "Harper Lee", 1968) +
                String.format("%-30s%-30s%-15s\n", "Gone Girl", "Gillian Flynn", 2000) +
                String.format("%-30s%-30s%-15s\n", "The Scarlett Letter", "Nathaniel Hawthorne", 1850);
        assertEquals(formattedListOfBooks, bookLibrary.list());
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
        User currentUser = new User("usr-1001", "password1", ROLE.AUTHENTICATED_USER, "Hermione Granger", "hermione@gmail.com", 867546351);

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
        User currentUser = new User("usr-1001", "password1", ROLE.AUTHENTICATED_USER, "Hermione Granger", "hermione@gmail.com", 867546351);
        bookLibrary.checkOut("Gone Girl", currentUser);

        String formattedListOfBooks = String.format("%-30s%-30s%-15s\n", "NAME OF BOOK", "NAME OF AUTHOR", "YEAR OF PUBLICATION")
                + String.format("%-30s%-30s%-15s\n", "To Kill A Mockingbird", "Harper Lee", 1968) +
                String.format("%-30s%-30s%-15s\n", "The Scarlett Letter", "Nathaniel Hawthorne", 1850);
        assertEquals(formattedListOfBooks, bookLibrary.list());
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
        User currentUser = new User("usr-1001", "password1", ROLE.AUTHENTICATED_USER, "Hermione Granger", "hermione@gmail.com", 867546351);

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
                new User("usr-1001", "password1", ROLE.AUTHENTICATED_USER, "Hermione Granger", "hermione@gmail.com", 867546351));
        BookLibrary bookLibrary = new BookLibrary(availableBookList, checkedOutBookList, checkedOutBookListWithUser);
        User currentUser = new User("usr-1001", "password1", ROLE.AUTHENTICATED_USER, "Hermione Granger", "hermione@gmail.com", 867546351);

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
                new User("usr-1001", "password1", ROLE.AUTHENTICATED_USER, "Hermione Granger", "hermione@gmail.com", 867546351));
        BookLibrary bookLibrary = new BookLibrary(availableBookList, checkedOutBookList, checkedOutBookListWithUser);
        User currentUser = new User("usr-1001", "password1", ROLE.AUTHENTICATED_USER, "Hermione Granger", "hermione@gmail.com", 867546351);
        bookLibrary.returnBook("Gone Girl", currentUser);

        String formattedListOfBooks = String.format("%-30s%-30s%-15s\n", "NAME OF BOOK", "NAME OF AUTHOR", "YEAR OF PUBLICATION")
                + String.format("%-30s%-30s%-15s\n", "To Kill A Mockingbird", "Harper Lee", 1968)
                + String.format("%-30s%-30s%-15s\n", "The Scarlett Letter", "Nathaniel Hawthorne", 1850)
                + String.format("%-30s%-30s%-15s\n", "Gone Girl", "Gillian Flynn", 2000);

        assertEquals(formattedListOfBooks, bookLibrary.list());
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
        User currentUser = new User("usr-1001", "password1", ROLE.AUTHENTICATED_USER, "Hermione Granger", "hermione@gmail.com", 867546351);

        assertEquals("That is not a valid book to return", bookLibrary.returnBook("Gone Girl", currentUser));
    }

    @Test
    public void shouldNotReturnBookIfBookHasBeenCheckedOutButUserHasCheckedOutSomeOtherBook() {
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        checkedOutBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));
        HashMap<Book, User> checkedOutBookListWithUser = new HashMap<Book, User>();
        checkedOutBookListWithUser.put(new Book("Gone Girl", "Gillian Flynn", 2000),
                new User("usr-1000", "password", ROLE.AUTHENTICATED_USER, "Bill", "usr1001@gmail.com", 895643225));
        BookLibrary bookLibrary = new BookLibrary(availableBookList, checkedOutBookList, checkedOutBookListWithUser);
        User currentUser = new User("usr-1001", "password1", ROLE.AUTHENTICATED_USER, "Hermione Granger", "hermione@gmail.com", 867546351);

        assertEquals("That is not a valid book to return", bookLibrary.returnBook("Gone Girl", currentUser));
    }

    @Test
    public void shouldReturnCheckedOutBooksWithUserList() {
        ArrayList<Book> checkedOutBookList = new ArrayList<>();
        ArrayList<Book> availableBookList = new ArrayList<>();
        availableBookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1968));
        availableBookList.add(new Book("Gone Girl", "Gillian Flynn", 2000));
        availableBookList.add(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850));
        HashMap<Book, User> checkedOutBookListWithUser = new HashMap<Book, User>();
        checkedOutBookListWithUser.put(new Book("The Scarlett Letter", "Nathaniel Hawthorne", 1850),
                new User("usr-1001", "password1", ROLE.AUTHENTICATED_USER, "Hermione Granger", "hermione@gmail.com", 867546351));
        BookLibrary bookLibrary = new BookLibrary(availableBookList, checkedOutBookList, checkedOutBookListWithUser);

        String formattedList = String.format("%-30s%-30s%-15s%-20s\n", "NAME OF BOOK", "NAME OF AUTHOR", "YEAR OF PUBLICATION", "USER LIBRARY NUMBER") +
                String.format("%-30s%-30s%-15s%-20s\n", "The Scarlett Letter", "Nathaniel Hawthorne", 1850, "usr-1001");

        assertEquals(formattedList, bookLibrary.checkedOutBookListWithUser());
    }
}