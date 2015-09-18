package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CheckedOutListWithUserTest {

    @Test
    public void shouldDisplayListOfCheckedOutBooks() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        ConsoleOutput consoleOutput = new ConsoleOutput();
        BookLibrary bookLibrary = mock(BookLibrary.class);
        String formattedListOfBooks = String.format("%-30s%-30s%-15s\n", "NAME OF BOOK", "NAME OF AUTHOR", "YEAR OF PUBLICATION")
                + String.format("%-30s%-30s%-15s\n", "To Kill A Mockingbird", "Harper Lee", 1968)
                + String.format("%-30s%-30s%-15s\n", "Gone Girl", "Gillian Flynn", 2000)
                + String.format("%-30s%-30s%-15s\n", "The Scarlett Letter", "Nathaniel Hawthorne", 1850);
        when(bookLibrary.checkedOutBookListWithUser()).thenReturn(formattedListOfBooks);
        User currentUser = new User("Guest User", "No Password", ROLE.GUEST_USER);
        CheckedOutListWithUser checkedOutListWithUser = new CheckedOutListWithUser(bookLibrary, consoleOutput, currentUser);
        checkedOutListWithUser.executeOptionOperation();

        assertEquals(formattedListOfBooks + "\n", outputContent.toString());
    }
}