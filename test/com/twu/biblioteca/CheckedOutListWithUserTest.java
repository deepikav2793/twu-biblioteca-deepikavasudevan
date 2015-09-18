package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CheckedOutListWithUserTest {

    @Test
    public void shouldDisplayListOfCheckedOutBooks() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        ConsoleOutput consoleOutput = new ConsoleOutput();
        BookLibrary bookLibrary = mock(BookLibrary.class);
        String formattedList = String.format("%-30s%-30s%-15s%-20s\n", "NAME OF BOOK", "NAME OF AUTHOR", "YEAR OF PUBLICATION", "USER LIBRARY NUMBER") +
                String.format("%-30s%-30s%-15s%-20s\n", "The Scarlett Letter", "Nathaniel Hawthorne", 1850, "usr-1001");
        when(bookLibrary.checkedOutBookListWithUser()).thenReturn(formattedList);
        User currentUser = new User("Guest User", "No Password", ROLE.GUEST_USER);
        CheckedOutListWithUser checkedOutListWithUser = new CheckedOutListWithUser(bookLibrary, consoleOutput, currentUser);
        checkedOutListWithUser.executeOptionOperation();

        assertEquals(formattedList + "\n", outputContent.toString());
    }

    @Test
    public void shouldUseConsoleOutputToDisplayListOfCheckedOutBooks() {
        ConsoleOutput consoleOutput = mock(ConsoleOutput.class);
        BookLibrary bookLibrary = mock(BookLibrary.class);
        String formattedList = String.format("%-30s%-30s%-15s%-20s\n", "NAME OF BOOK", "NAME OF AUTHOR", "YEAR OF PUBLICATION", "USER LIBRARY NUMBER") +
                String.format("%-30s%-30s%-15s%-20s\n", "The Scarlett Letter", "Nathaniel Hawthorne", 1850, "usr-1001");
        when(bookLibrary.checkedOutBookListWithUser()).thenReturn(formattedList);
        User currentUser = new User("Guest User", "No Password", ROLE.GUEST_USER);
        CheckedOutListWithUser checkedOutListWithUser = new CheckedOutListWithUser(bookLibrary, consoleOutput, currentUser);
        checkedOutListWithUser.executeOptionOperation();

        verify(consoleOutput, times(1)).display(formattedList);
    }
}