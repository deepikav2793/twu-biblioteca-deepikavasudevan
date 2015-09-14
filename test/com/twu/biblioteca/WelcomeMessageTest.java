package com.twu.biblioteca;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class WelcomeMessageTest {

    private ByteArrayOutputStream outputContent = new ByteArrayOutputStream();

    @Test
    public void shouldDisplayAWelcomeMessage() {
        System.setOut(new PrintStream(outputContent));
        WelcomeMessage welcomeMessage = new WelcomeMessage("Hello! Welcome to Bangalore Public Library!");
        ConsoleOutput consoleOutput = new ConsoleOutput();

        welcomeMessage.display(consoleOutput);

        assertEquals("Hello! Welcome to Bangalore Public Library!\n", outputContent.toString());
    }

    @Test
    public void shouldInvokeAControlOutputAndUseItToDisplayWelcomeMessage() {
        WelcomeMessage welcomeMessage = new WelcomeMessage("Hello! Welcome to Bangalore Public Library!");
        ConsoleOutput consoleOutput = mock(ConsoleOutput.class);

        welcomeMessage.display(consoleOutput);

        verify(consoleOutput, times(1)).display("Hello! Welcome to Bangalore Public Library!");
    }
}