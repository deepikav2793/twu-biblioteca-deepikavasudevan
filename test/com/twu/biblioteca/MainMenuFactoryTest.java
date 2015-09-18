package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainMenuFactoryTest {

    @Test
    public void shouldCreateAMainMenu() {
        MainMenuFactory mainMenuFactory = new MainMenuFactory();

        assertEquals(MainMenu.class, mainMenuFactory.createMainMenu().getClass());
    }

    @Test
    public void shouldInitialiseMainMenuWithOptions() {
        MainMenuFactory mainMenuFactory = new MainMenuFactory();

        MainMenu mainMenu = mainMenuFactory.createMainMenu();

        assertEquals("MAIN MENU\n1. Login\n2. List Books\n3. Checkout Book\n4. Return Book\n5. List Movies\n6. Checkout Movie" +
                "\n7. List Checked Out Books with User's Library Number\n8. User Information\n9. Logout\n10. Quit\n", mainMenu.mainMenuOptions());
    }
}
