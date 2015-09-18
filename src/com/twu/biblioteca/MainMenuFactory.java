/*A Main Menu Factory creates Main Menu objects */
package com.twu.biblioteca;

import java.util.ArrayList;

public class MainMenuFactory {

    private MainMenu mainMenu;

    public MainMenu createMainMenu() {
        ArrayList<String> menuOptions = new ArrayList<>();
        menuOptions.add("1. Login");
        menuOptions.add("2. List Books");
        menuOptions.add("3. Checkout Book");
        menuOptions.add("4. Return Book");
        menuOptions.add("5. List Movies");
        menuOptions.add("6. Checkout Movie");
        menuOptions.add("7. List Checked Out Books with User's Library Number");
        menuOptions.add("8. User Information");
        menuOptions.add("9. Logout");
        menuOptions.add("10. Quit");

        mainMenu = new MainMenu(menuOptions);
        return mainMenu;
    }
}
