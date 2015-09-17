package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ReturnBookMenuOptionTest {

    @Test
    public void shouldTakeInputFromUserOnBookToBeReturnedUsingConsoleInput() {
        BookLibrary bookLibrary = mock(BookLibrary.class);
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        ConsoleOutput consoleOutput = mock(ConsoleOutput.class);
        ReturnBookMenuOption returnBookMenuOption = new ReturnBookMenuOption(bookLibrary, consoleInput, consoleOutput);
        returnBookMenuOption.executeOptionOperation();

        verify(consoleInput, times(1)).getInput();
    }

}