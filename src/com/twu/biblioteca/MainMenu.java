/*Main Menu shows list of options from which one is chosen by user*/
package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
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

        delegate();
    }

    public String option() {
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    public void delegate() {
            String choice = option();

            if (choice.equals("1")) {
                ArrayList<Book> listOfBooks = new ArrayList<>(Arrays.asList(new Book("To Kill A Mockingbird", "Harper Lee", 1968),
                        new Book("Gone Girl", "Gillian Flynn", 2000)));
                BookList bookList = new BookList(listOfBooks);
                bookList.display();
            } else if (choice.equals("2"))
                System.exit(0);
            else
                System.out.println("Select a valid option!");
    }
}