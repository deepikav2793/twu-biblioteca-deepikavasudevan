package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class ReturnBookMainMenuOptionTest {

    @Test
    public void shouldTakeInputFromUserOnBookToBeReturnedUsingConsoleInput() {
        BookLibrary bookLibrary = mock(BookLibrary.class);
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        ConsoleOutput consoleOutput = mock(ConsoleOutput.class);
        User currentUser = new User("Guest User","No Password",ROLE.GUEST_USER);
        ReturnBookMenuOption returnBookMenuOption = new ReturnBookMenuOption(bookLibrary, consoleInput, consoleOutput, currentUser);
        returnBookMenuOption.executeOptionOperation();

        verify(consoleInput, times(1)).getInput();
    }

    @Test
    public void shouldDisplayAPromptMessageForUserToInputBookToBeReturnedAndTheReturnMessageAsWell() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        User currentUser = new User("Guest User","No Password",ROLE.AUTHENTICATED_USER);
        BookLibrary bookLibrary = mock(BookLibrary.class);
        when(bookLibrary.returnBook("Gone Girl", currentUser)).thenReturn("This is not a valid book to return");
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        when(consoleInput.getInput()).thenReturn("Gone Girl");
        ConsoleOutput consoleOutput = new ConsoleOutput();
        ReturnBookMenuOption returnBookMenuOption = new ReturnBookMenuOption(bookLibrary, consoleInput, consoleOutput, currentUser);
        returnBookMenuOption.executeOptionOperation();

        assertEquals("Enter book to be returned:\nThis is not a valid book to return\n", outputContent.toString());
    }

    @Test
    public void shouldUseConsoleOutputToPrintPromptMessageToTheConsoleAndPrintReturnMessage() {
        BookLibrary bookLibrary = mock(BookLibrary.class);
        User currentUser = new User("Guest User","No Password",ROLE.AUTHENTICATED_USER);
        when(bookLibrary.returnBook("Gone Girl", currentUser)).thenReturn("This is not a valid book to return");
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        when(consoleInput.getInput()).thenReturn("Gone Girl");
        ConsoleOutput consoleOutput = mock(ConsoleOutput.class);
        ReturnBookMenuOption returnBookMenuOption = new ReturnBookMenuOption(bookLibrary, consoleInput, consoleOutput, currentUser);
        returnBookMenuOption.executeOptionOperation();

        verify(consoleOutput, times(1)).display("Enter book to be returned:");
        verify(consoleOutput, times(1)).display("This is not a valid book to return");
    }

    @Test
    public void shouldPrintSuccessfulReturnMessageIfReturnWasUnsuccessful() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));

        BookLibrary bookLibrary = mock(BookLibrary.class);
        User currentUser = new User("Guest User","No Password",ROLE.AUTHENTICATED_USER);
        when(bookLibrary.returnBook("Gone Girl", currentUser)).thenReturn("Thank you for returning the book");
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        when(consoleInput.getInput()).thenReturn("Gone Girl");
        ConsoleOutput consoleOutput = new ConsoleOutput();
        ReturnBookMenuOption returnBookMenuOption = new ReturnBookMenuOption(bookLibrary, consoleInput, consoleOutput, currentUser);
        returnBookMenuOption.executeOptionOperation();

        assertEquals("Enter book to be returned:\nThank you for returning the book\n", outputContent.toString());
    }
}