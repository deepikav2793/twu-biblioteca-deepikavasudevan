package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MainMenuTest {

    private final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();

    @Before
    public void setStreamsWithInitialValue() {
        System.setOut(new PrintStream(outputContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
    }

    @Test
    public void shouldPrintMenuOptions(){
        ArrayList<String> menuOptions = new ArrayList<>(Arrays.asList("1. List Books"));
        MainMenu mainMenu = new MainMenu(menuOptions);

        mainMenu.display();

        assertEquals("MAIN MENU\n1. List Books\n", outputContent.toString());
    }
}