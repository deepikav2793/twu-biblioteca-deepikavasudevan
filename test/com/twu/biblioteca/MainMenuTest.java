package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MainMenuTest {

    private ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
    private ByteArrayInputStream inputContent = new ByteArrayInputStream("1".getBytes());

    @Before
    public void setStreamsWithInitialValue() {
        System.setOut(new PrintStream(outputContent));
        System.setIn(inputContent);
    }

    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
        System.setIn(System.in);
    }

    @Test
    public void shouldPrintMenuOptions(){
        ArrayList<String> menuOptions = new ArrayList<>(Arrays.asList("1. List Books"));
        MainMenu mainMenu = new MainMenu(menuOptions);

        mainMenu.display();

        assertEquals("MAIN MENU\n1. List Books\n", outputContent.toString());
    }

    @Test
    public void shouldTakeOptionAsInputFromCustomer() {
        ArrayList<String> menuOptions = new ArrayList<>(Arrays.asList("1. List Books"));
        MainMenu mainMenu = new MainMenu(menuOptions);

        assertEquals("1", mainMenu.option());
    }

    @Test
    public void shouldListBooksWhenOptionIsInputtedAsOne() {
        ArrayList<String> menuOptions = new ArrayList<>(Arrays.asList("1. List Books"));
        MainMenu mainMenu = new MainMenu(menuOptions);

        mainMenu.parse();

        assertEquals("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\nGone Girl\tGillian Flynn\t2000\n", outputContent.toString());
    }
}