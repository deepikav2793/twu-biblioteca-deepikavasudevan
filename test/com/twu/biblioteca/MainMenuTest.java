package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MainMenuTest {

    private ByteArrayOutputStream outputContent;
    private MainMenu mainMenu;
    private ConsoleInput consoleInput;

    @Before
    public void setStreamsWithInitialValue() {
        outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        ArrayList<String> menuOptions = new ArrayList<>(Arrays.asList("1. List Books", "2. Checkout Book", "3. Return Book",
                "4. List Movies", "5. Checkout Movie", "6. Quit"));
        consoleInput = mock(ConsoleInput.class);
        ConsoleOutput consoleOutput = new ConsoleOutput();
        mainMenu = new MainMenu(menuOptions);

    }

    @Test
    public void shouldDisplayListOfOptionsInMainMenu() {
        assertEquals("MAIN MENU\n1. List Books\n2. Checkout Book\n3. Return Book\n4. List Movies\n5. Checkout Movie\n" +
                "6. Quit\n", mainMenu.mainMenuOptions());
    }

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldExecuteQuitOptionIfQuitOptionIsSelected() {
        exit.expectSystemExitWithStatus(0);
        User currentUser = new User("Guest User","No Password",ROLE.GUEST_USER);
        QuitMenuOption quitMenuOption = new QuitMenuOption(currentUser);
        mainMenu.executeOption(quitMenuOption);
    }
}