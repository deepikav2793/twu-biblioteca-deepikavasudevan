/*creates an instance of console input*/
package com.twu.biblioteca;

public class Factory {
    
    ConsoleInput consoleInput;
    ConsoleOutput consoleOutput;
    
    public ConsoleInput createConsoleInput() {
        consoleInput = new ConsoleInput();

        return consoleInput;
    }

    public ConsoleOutput createConsoleOutput() {
        consoleOutput = new ConsoleOutput();

        return consoleOutput;
    }
}