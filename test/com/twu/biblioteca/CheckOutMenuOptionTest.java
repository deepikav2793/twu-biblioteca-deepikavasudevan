package com.twu.biblioteca;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CheckOutMenuOptionTest {

    @Test
    public void shouldTakeInputFromUserOnWhatIsToBeCheckedOutUsingConsoleInput() {
        BookLibrary bookLibrary = mock(BookLibrary.class);
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        ConsoleOutput consoleOutput = mock(ConsoleOutput.class);
        CheckOutMenuOption checkOutMenuOption = new CheckOutMenuOption(bookLibrary, consoleInput, consoleOutput);
        checkOutMenuOption.executeOptionOperation();

        verify(consoleInput, times(1)).getInput();
    }

    @Test
    public void shouldDisplayAPromptMessageForUserToInputWhatIsToBeCheckedOutAndTheCheckOutMessageAsWell() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));

        BookLibrary bookLibrary = mock(BookLibrary.class);
        when(bookLibrary.checkOut("Gone Girl")).thenReturn("Thank you! Enjoy the book");
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        when(consoleInput.getInput()).thenReturn("Gone Girl");
        ConsoleOutput consoleOutput = new ConsoleOutput();
        CheckOutMenuOption checkOutMenuOption = new CheckOutMenuOption(bookLibrary, consoleInput, consoleOutput);
        checkOutMenuOption.executeOptionOperation();

        assertEquals("Enter what is to be checked out:\nThank you! Enjoy the book\n", outputContent.toString());
    }

    @Test
    public void shouldUseConsoleOutputToPrintPromptMessageToTheConsole() {
        BookLibrary bookLibrary = mock(BookLibrary.class);
        when(bookLibrary.checkOut("Gone Girl")).thenReturn("Thank you! Enjoy the book");
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        when(consoleInput.getInput()).thenReturn("Gone Girl");
        ConsoleOutput consoleOutput = mock(ConsoleOutput.class);
        CheckOutMenuOption checkOutMenuOption = new CheckOutMenuOption(bookLibrary, consoleInput, consoleOutput);
        checkOutMenuOption.executeOptionOperation();

        verify(consoleOutput, times(1)).display("Enter what is to be checked out:");
    }

    @Test
    public void shouldTakeInputFromUserOnWhatIsToBeCheckedOut() {
        BookLibrary bookLibrary = mock(BookLibrary.class);
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        when(consoleInput.getInput()).thenReturn("Gone Girl");
        ConsoleOutput consoleOutput = mock(ConsoleOutput.class);
        CheckOutMenuOption checkOutMenuOption = new CheckOutMenuOption(bookLibrary, consoleInput, consoleOutput);
        checkOutMenuOption.executeOptionOperation();

        verify(consoleInput, times(1)).getInput();
    }
}