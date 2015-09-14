/*takes input from console*/
package com.twu.biblioteca;

import java.util.Scanner;

public class ConsoleInput {

    private Scanner input;

    public ConsoleInput() {
        input = new Scanner(System.in);
    }

    public String getInput() {
        return input.nextLine();
    }
}
