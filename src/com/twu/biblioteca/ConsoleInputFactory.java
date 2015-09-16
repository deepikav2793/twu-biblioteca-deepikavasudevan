/*creates an instance of console input*/
package com.twu.biblioteca;

public class ConsoleInputFactory {
    
    ConsoleInput consoleInput;
    
    public ConsoleInput createConsoleInput() {
        consoleInput = new ConsoleInput();

        return consoleInput;
    }
}