/*Main Menu shows list of options from which one is chosen by user*/
package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

    private ArrayList<String> menuOptions = new ArrayList<String>();

    MainMenu(ArrayList<String> menuOptions) {
        this.menuOptions = menuOptions;
    }

    public void display() {
        System.out.println("MAIN MENU");

        for (String menuOption : menuOptions) {
           System.out.println(menuOption);
        }

        option();
    }

    public String option() {
        Scanner input = new Scanner(System.in);
        return input.next();
    }
}