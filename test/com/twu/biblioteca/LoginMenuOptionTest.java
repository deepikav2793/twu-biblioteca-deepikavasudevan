package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class LoginMenuOptionTest {

    @Test
    public void shouldPrintSuccessfulLoginMessageOnSuccessfulLogin(){
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        ConsoleOutput consoleOutput = new ConsoleOutput();
        LoginMenuOption loginMenuOption = new LoginMenuOption(consoleInput, consoleOutput);
        loginMenuOption.executeOptionOperation();

        assertEquals("Login Successful\n", outputContent.toString());
    }

    @Test
    public void shouldUseConsoleOutputToPrintLoginMessage() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        ConsoleOutput consoleOutput = mock(ConsoleOutput.class);
        LoginMenuOption loginMenuOption = new LoginMenuOption(consoleInput, consoleOutput);
        loginMenuOption.executeOptionOperation();

        verify(consoleOutput, times(1)).display("Login Successful");
    }

    @Test
    public void shouldTakeUserNameAndPasswordAsInputFromConsole() {
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        ConsoleOutput consoleOutput = mock(ConsoleOutput.class);
        LoginMenuOption loginMenuOption = new LoginMenuOption(consoleInput, consoleOutput);
        loginMenuOption.executeOptionOperation();

        verify(consoleInput, times(2)).getInput();
    }
}