package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainMenuFactoryTest {

    @Test
    public void shouldCreateAMainMenu() {
        MainMenuFactory mainMenuFactory = new MainMenuFactory();

        assertEquals(MainMenu.class, mainMenuFactory.createMainMenu().getClass());
    }
}
