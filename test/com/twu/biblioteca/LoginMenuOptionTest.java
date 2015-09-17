package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class LoginMenuOptionTest {

    @Test
    public void shouldUseConsoleOutputToPrintLoginMessage() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        when(consoleInput.getInput()).thenReturn("usr-1001", "password1");
        ConsoleOutput consoleOutput = mock(ConsoleOutput.class);
        ArrayList<User> listOfUsers = new ArrayList<>();
        listOfUsers.add(new User("lib-1000", "password", ROLE.LIBRARIAN));
        listOfUsers.add(new User("usr-1001", "password1", ROLE.AUTHENTICATED_USER));
        LoginMenuOption loginMenuOption = new LoginMenuOption(consoleInput, consoleOutput, listOfUsers);
        loginMenuOption.executeOptionOperation();

        verify(consoleOutput, times(1)).display("Login Successful");
    }

    @Test
    public void shouldTakeUserNameAndPasswordAsInputFromConsole() {
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        ConsoleOutput consoleOutput = mock(ConsoleOutput.class);
        LoginMenuOption loginMenuOption = new LoginMenuOption(consoleInput, consoleOutput, new ArrayList<User>());
        loginMenuOption.executeOptionOperation();

        verify(consoleInput, times(2)).getInput();
    }

    @Test
    public void shouldReturnSuccessfulLoginMessageOnAuthentication() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        when(consoleInput.getInput()).thenReturn("usr-1001", "password1");
        ConsoleOutput consoleOutput = new ConsoleOutput();
        ArrayList<User> listOfUsers = new ArrayList<>();
        listOfUsers.add(new User("lib-1000", "password", ROLE.LIBRARIAN));
        listOfUsers.add(new User("usr-1001", "password1", ROLE.AUTHENTICATED_USER));

        LoginMenuOption loginMenuOption = new LoginMenuOption(consoleInput, consoleOutput, listOfUsers);
        loginMenuOption.executeOptionOperation();

        assertEquals("Login Successful\n", outputContent.toString());
    }

    @Test
    public void shouldReturnUnsuccessfulLoginMessageIfAuthenticationWasNotSuccessful() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        when(consoleInput.getInput()).thenReturn("usr-2489", "password1");
        ConsoleOutput consoleOutput = new ConsoleOutput();
        ArrayList<User> listOfUsers = new ArrayList<>();
        listOfUsers.add(new User("lib-1000", "password", ROLE.LIBRARIAN));
        listOfUsers.add(new User("usr-1001", "password1", ROLE.AUTHENTICATED_USER));

        LoginMenuOption loginMenuOption = new LoginMenuOption(consoleInput, consoleOutput, listOfUsers);
        loginMenuOption.executeOptionOperation();

        assertEquals("Login Unsuccessful\n", outputContent.toString());
    }
}