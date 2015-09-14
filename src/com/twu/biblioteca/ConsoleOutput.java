/*prints output to console*/
package com.twu.biblioteca;

import java.io.PrintStream;

public class ConsoleOutput {

    private PrintStream printStream;

    public ConsoleOutput() {
        printStream = new PrintStream(System.out);
    }

    public void display(String displayMessage) {
        printStream.println(displayMessage);
    }
}