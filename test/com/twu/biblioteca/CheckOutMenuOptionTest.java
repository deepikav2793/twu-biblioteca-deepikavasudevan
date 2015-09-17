package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class CheckOutMenuOptionTest {

    @Test
    public void shouldTakeInputFromUserOnWhatIsToBeCheckedOut() {
        BookLibrary bookLibrary = mock(BookLibrary.class);
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        ConsoleOutput consoleOutput = mock(ConsoleOutput.class);
        CheckOutMenuOption checkOutMenuOption = new CheckOutMenuOption(bookLibrary, consoleInput, consoleOutput);
        checkOutMenuOption.checkOut();

        verify(consoleInput, times(1)).getInput();
    }
}