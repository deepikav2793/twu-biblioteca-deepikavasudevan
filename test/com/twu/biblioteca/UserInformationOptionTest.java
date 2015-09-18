package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

public class UserInformationOptionTest {

    @Test
    public void shouldPrintUserInformation() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        ConsoleOutput consoleOutput = new ConsoleOutput();
        User currentUser = mock(User.class);
        when(currentUser.toString()).thenReturn("USER INFORMATION\nLibrary Number: usr-1001\nUser Name: Bill\nEmail Address: usr1001@gmail.com"
                +"\nPhone Number: 895643225");
        UserInformationOption userInformationOption = new UserInformationOption(consoleOutput, currentUser);
        userInformationOption.executeOptionOperation();

        assertEquals("USER INFORMATION\nLibrary Number: usr-1001\nUser Name: Bill\nEmail Address: usr1001@gmail.com"
                +"\nPhone Number: 895643225\n", outputContent.toString());
    }

    @Test
    public void shouldUseConsoleOutputToPrintUserInformation() {
        ConsoleOutput consoleOutput = mock(ConsoleOutput.class);
        User currentUser = mock(User.class);
        when(currentUser.toString()).thenReturn("USER INFORMATION\nLibrary Number: usr-1001\nUser Name: Bill\nEmail Address: usr1001@gmail.com"
                + "\nPhone Number: 895643225");
        UserInformationOption userInformationOption = new UserInformationOption(consoleOutput, currentUser);
        userInformationOption.executeOptionOperation();

        verify(consoleOutput, times(1)).display("USER INFORMATION\nLibrary Number: usr-1001\nUser Name: Bill\nEmail Address: usr1001@gmail.com\n"
                        +"Phone Number: 895643225");
    }
}